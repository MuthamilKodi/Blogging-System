package controller;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.*;
import org.json.JSONObject;
public class EditCategoryController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		try{
			Database data=new Database();
	    	JSONObject obj=new JSONObject();
	    	PrintWriter out=response.getWriter();
	    	HttpSession session=request.getSession(false);
	    	if(session!=null){
	    		User user=(User)session.getAttribute("user");
	    		String id=request.getParameter("category");
	    		int categoryId=Integer.parseInt(request.getParameter("category"));
				Category category=data.getCategory(categoryId,user.getUserId(),data.connect());
				JSONObject jsonCategory=new JSONObject(category);
				System.out.println("session attribute: "+session.getAttribute("editCategoryId"));
				if(category.getCategoryId()!=0){	//If requested category is present, then send that data
					obj.put("status","success");
					obj.put("data",jsonCategory);
					out.print(obj);
					System.out.println(obj);
					session.setAttribute("editCategoryId",category.getCategoryId()); //Store which category Id to be edit
				}
				else{
					obj.put("status","failure");
					out.print(obj);
					System.out.println(obj);
				}
	    	}
	    	else{
	    		response.sendRedirect("./signin");
	    	}
  		}
		catch(Exception e){
			System.out.println(e);
			try{
				response.sendRedirect("blogsite/error.html");
			}
			catch(IOException except){
				System.out.println(except.getMessage());
			}
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		try{
			Database data=new Database();
	    	JSONObject obj=new JSONObject();
	    	PrintWriter out=response.getWriter();
	    	HttpSession session=request.getSession(false);
	    	if(session!=null){
	    		User user=(User)session.getAttribute("user");
	    		String title=request.getParameter("title");
	    		String desc=request.getParameter("desc");
	    		int sessionCategoryId=(int)session.getAttribute("editCategoryId");
	    		int categoryId=Integer.parseInt(request.getParameter("categoryId"));
	    		if(sessionCategoryId==categoryId){
	    			Category category=new Category(categoryId,user.getUserId(),title,desc);
	    			Boolean status=data.editCategory(category,data.connect());
					JSONObject jsonCategory=new JSONObject(category);
					if(status){
						obj.put("message","success");
						obj.put("code",1);
						out.print(obj);
						System.out.println(obj);
						session.removeAttribute("editCategoryId");
					}
					else{
						obj.put("message","failure");
						obj.put("code",0);
						out.print(obj);
						System.out.println(obj);
					}	
	    		}
	    		System.out.println("testing error url: "+request.getServletContext()+"/error.html");
	    	}
	    	else{
	    		response.sendRedirect("./signin");
	    	}
		}
		catch(Exception e){
			System.out.println(e);
			try{
				response.sendRedirect("blogsite/error.html");
			}
			catch(IOException except){
				System.out.println(except.getMessage());
			}
		}
	}
}