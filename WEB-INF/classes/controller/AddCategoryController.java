package controller;
import java.io.*;
import model.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
public class AddCategoryController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			Database data=new Database();
	    	Boolean success=false;
	    	JSONObject obj=new JSONObject();
			PrintWriter out=response.getWriter();
	    	HttpSession session=request.getSession(false);
	    	User user=(User)session.getAttribute("user");
			String title=request.getParameter("title");
			String desc=request.getParameter("desc");
			if(title==null||title==""){
				obj.put("message","Category title is required");
				obj.put("code",0);
			}
			else if(!title.matches("^\\w+(\\s\\w+)*$")){
				obj.put("message","Category title is Invalid");
				obj.put("code",0);
			}
			else if(title.length()>40){
				obj.put("message","Category title does not exceed 40 characters");
				obj.put("code",0);
			}	
			else if(desc!=""&&!desc.matches("^\\w+\\.?(\\s\\w+\\.?)*$")){
				obj.put("message","Category Description is Invalid");
				obj.put("code",0);
			}
			else if(desc.length()>400){
				obj.put("message"," Category Description does not exceed 400 characters");
				obj.put("code",0);
			}		
			else{
				Category category=new Category(1,user.getUserId(),title,desc);
				boolean alreadyExists=data.verifyCategory(category,data.connect());
				if(alreadyExists){
					obj.put("message","Category is Already Exists");
					obj.put("code",0);
				}
				else{
					success=data.addCategory(category,data.connect());
					if(success){
						obj.put("message","Category Added Succesfully");
						obj.put("code",1);
					}
					else{
						obj.put("message","Failure...");
						obj.put("code",0);
					}
				}
			}
			out.print(obj);
			System.out.println(obj);
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