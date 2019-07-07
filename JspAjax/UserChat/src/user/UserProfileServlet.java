package user;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// cos.jar �� �̿��Ͽ� ���Ͼ��ε� ȯ�漳�� (MultipartRequest �̿�)
		MultipartRequest multi = null;
		int fileMaxSize = 10 * 1024 * 1024;
		String savePath = request.getRealPath("/upload").replaceAll("\\\\", "/"); // upload��� ���� ���� ���� �������ߵ�  (C:\Users\pym78\Documents\GitHub\javaAjaxChat\JspAjax\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\UserChat)
		try {
			multi = new MultipartRequest(request, savePath, fileMaxSize, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			request.getSession().setAttribute("messageType", "���� �޼���");
			request.getSession().setAttribute("messageContent", "���� ũ��� 10MB�� ���� �� �����ϴ�.");
			response.sendRedirect("profileUpdate.jsp");
			return;
		}
		// ������ �ƴϸ� ���� �� �� ������ ����
		String userID = multi.getParameter("userID");
		HttpSession session = request.getSession();
		if(!userID.equals((String) session.getAttribute("userID"))) {
			request.getSession().setAttribute("messageType", "���� �޼���");
			request.getSession().setAttribute("messageContent", "������ �� �����ϴ�.");
			response.sendRedirect("index.jsp");
			return;
		}
		// ���ε� �� �� �ִ� Ȯ���� ����
		String fileName = "";
		File file = multi.getFile("userProfile"); // profileUpdate.jsp���� �޾ƿ� ������ file �� ���� 
		if(file != null) {
			String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1); // Ȯ���� ó���κ�
			if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")) {
				String prev = new UserDAO().getUser(userID).getUserProfile(); // ���� ������ ����
				File prevFile = new File(savePath + "/" + prev);
				if(prevFile.exists()) {
					prevFile.delete();
				}
				fileName = file.getName();
			} else { // ������ Ȯ���ڰ� �ƴѰ�쿡 
				if(file.exists()) { // �޾ƿ� ���� ����
					file.delete();
				}
				request.getSession().setAttribute("messageType", "���� �޼���");
				request.getSession().setAttribute("messageContent", "�̹��� ���ϸ� ���ε� �����մϴ�.");
				response.sendRedirect("profileUpdate.jsp");
				return;
			}
		}
		new UserDAO().profile(userID, fileName); // ���� db�� ������Ʈ ���ִ� ����
		request.getSession().setAttribute("messageType", "���� �޼���");
		request.getSession().setAttribute("messageContent", "�̹��� ���� �Ϸ�!");
		response.sendRedirect("index.jsp");
		return;
	}

}