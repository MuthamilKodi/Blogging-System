package controller;
import java.io.*;
import model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
public class SignInController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
		Database data=new Database();
    	Boolean success=false;
		String emailID=request.getParameter("email");
		String password=request.getParameter("password");
		JSONObject obj=new JSONObject();
		PrintWriter out=response.getWriter();
		if(!isvalidEmail(emailID)){
			obj.put("messageCode",1);
			out.print(obj);
			return;
		}
		//int userID=data.signInUser(emailID,password,data.connect());
		User user=data.signInUser(emailID,password,data.connect());
		/*if(userID!=-1){
			System.out.println("signin servlet success");
			HttpSession session=request.getSession();
			session.setAttribute("userID",userID);
			obj.put("messageCode",3);
			//response.sendRedirect("/blogsite/dashboard");
		}*/
		//int user_id=user.getUserId();
		if(user!=null){
			System.out.println("signin servlet success");
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			obj.put("messageCode",3);
		}
		else{
			//request.setAttribute("error","Email Id or Password is wrong");
			//RequestDispatcher rd=request.getRequestDispatcher("/signin");
			//rd.forward(request,response);
			obj.put("messageCode",2);
			System.out.println("signin servlet failure");
		}
		out.print(obj);
		System.out.println(obj);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	boolean isvalidEmail(String emailId){
		return emailId.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$");
	}
}