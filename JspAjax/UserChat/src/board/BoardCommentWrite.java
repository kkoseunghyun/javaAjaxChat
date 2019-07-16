package board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardCommentWrite") 
public class BoardCommentWrite extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		
		String boardID = request.getParameter("boardID");
		if(boardID == null || boardID.equals("")) {
			session.setAttribute("messageType", "���� �޼���");
			session.setAttribute("messageContent", "boardID ����");
			System.out.println(boardID);
			response.sendRedirect("index.jsp");
			return;
		}
		
		String content = request.getParameter("content");
		if(content == null || content.equals("")) {
			session.setAttribute("messageType", "���� �޼���");
			session.setAttribute("messageContent", "content ����");
			System.out.println(content);
			response.sendRedirect("index.jsp");
			return;
		}
		String userID = (String) session.getAttribute("userID"); // ���� (���� �α��ε�)
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.commentWrite(boardID, content, userID); // ������ ����� ���� �Լ� 
		session.setAttribute("messageType", "���� �޼���");
		session.setAttribute("messageContent", "���������� ����� ��ϵǾ����ϴ�.");
		response.sendRedirect("boardShow.jsp?boardID=" + boardID);
		return;
	}

}