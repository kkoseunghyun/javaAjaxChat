package user;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import chat.ChatDAO;
import chat.ChatDTO;

@WebServlet("/UserFindServlet") // �̷��� WebServlet annotation ���� ���Ǹ� ���ָ� ���� web.xml���� ���Ǹ� �����ʿ� ���� �������� ���������� �ν��ϰ� �ȴ�.
public class UserFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userID = request.getParameter("userID");
		
		if(userID == null || userID.equals("") ) {
			response.getWriter().write("-1");
		} else if(new UserDAO().registerCheck(userID) == 0) { // 0: �̹� �����ϴ� ȸ�� 
			try {
				response.getWriter().write(find(userID));
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().write("-1");
			}
		} else {
			response.getWriter().write("-1");
		}
	}
	
	// JSON �������� ������ data 
	public String find(String userID) throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("userProfile", new UserDAO().getProfile(userID));
		return obj.toJSONString();
	}
	/*
	public String find(String userID) throws Exception {
		StringBuffer result = new StringBuffer("");
		result.append("{\"userProfile\":\"" + new UserDAO().getProfile(userID) + "\"}");
		return result.toString();
	}
	*/

}
