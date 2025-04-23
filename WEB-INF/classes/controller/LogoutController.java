package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException{
		try{
			HttpSession session=request.getSession(false);
			if(session!=null){
				session.invalidate();
				response.sendRedirect("/blogsite/");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}