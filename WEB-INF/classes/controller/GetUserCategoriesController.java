package controller;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import model.*;
public class GetUserCategoriesController extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		try{
			response.setContentType("application/json");
			PrintWriter out=response.getWriter();
			Database data=new Database();
			HttpSession session=request.getSession(false);
			if(session==null){
				response.sendRedirect("signin");
			}
			else{
				JSONObject obj=new JSONObject();
				JSONArray jsonArray=new JSONArray();
				String queryString=request.getQueryString();
				User user=(User)session.getAttribute("user");
				ArrayList<Category> categories=null;
				System.out.println(queryString);
				if(queryString.equals("short"))
					categories=data.getUserCategoriesName(user.getUserId(),data.connect());
				else if(queryString.equals("full"))
					categories=data.getUserCategories(user.getUserId(),data.connect());
				if(categories!=null){
					for(Category category:categories){
						JSONObject jsonCategory=new JSONObject(category);
						jsonArray.put(jsonCategory);
					}
					obj.put("data",jsonArray);
					obj.put("status","success");
				}
				else{
					obj.put("status","failure");
				}
				out.print(obj);
				System.out.println(obj);
			}
			out.flush();
		}
		catch (Exception e) {
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