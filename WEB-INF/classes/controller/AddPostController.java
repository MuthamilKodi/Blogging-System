package controller;
import java.io.*;
import model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
public class AddPostController extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		try{
			
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