package controller;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import org.json.JSONObject;
public class DeleteCategoryController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		try{
			Database data=new Database();
	    	JSONObject obj=new JSONObject();
	    	PrintWriter out=response.getWriter();
	    	HttpSession session=request.getSession(false);
	    	if(session!=null){
	    		User user=(User)session.getAttribute("user");
	    		int categoryId=Integer.parseInt(request.getParameter("category"));
				Boolean status=data.deleteCategory(categoryId,user.getUserId(),data.connect());
				JSONObject jsonCategory=new JSONObject();
				obj.put("message",status);
				out.print(obj);
				System.out.println(obj);
			}
	    	else{
	    		response.sendRedirect("./signin");
	    	}
	    	out.flush();
  		}
		catch(Exception e){
			System.out.println(e);
			try{
				response.sendRedirect("error.html");
			}
			catch(IOException except){
				System.out.println(except.getMessage());
			}
		}
	}
}