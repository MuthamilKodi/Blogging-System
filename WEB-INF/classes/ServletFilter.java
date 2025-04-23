import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.*;

public class ServletFilter implements Filter{
	public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain) throws ServletException,IOException{
		HttpServletRequest hRequest=(HttpServletRequest)request;
		HttpServletResponse hResponse=(HttpServletResponse)response;
		String path=hRequest.getServletPath();
		HttpSession session=hRequest.getSession(false);
			
		/*if(path=="/home"||path=="/")
		chain.doFilter(hRequest,hResponse);
		else{
			if(session!=null){
				chain.doFilter(hRequest,hResponse);
			}
			else{
				hResponse.sendRedirect("signin");
			}
		}*/
		if(session!=null){
			int roleId=((User)session.getAttribute("user")).getUserRole();
			if(path=="/signin"||path=="/signincontroller"||path=="/signup"||path=="/signupcontroller"){
				hResponse.sendRedirect("dashboard");
			}
			else if(roleId==2&&(path=="/addcategory"||path=="editcategory"||path=="managecategories"||path=="/addcategorycontroller"||path=="/editcategorycontroller"||path=="/managecategoriescontroller"||path=="/deletecategorycontroller"||path=="/addpost"||path=="/editpost"||path=="/manageposts"||path=="/addpostcontroller"||path=="/editpostcontroller"||path=="/managepostscontroller"||path=="/deletepostcontroller")){
				hResponse.sendRedirect("deny.html");
			}
			else if(roleId==3&&path=="/editcategory"){
				String queryString=hRequest.getParameter("category");
				if(queryString==null||queryString==""){
					hResponse.sendRedirect("managecategories");
				}
				else if(queryString!=null){
					try{
						int categoryId=Integer.parseInt(queryString);
						chain.doFilter(hRequest,hResponse);
					}
					catch(Exception e){
						hResponse.sendRedirect("deny.html");
					}
				}
				else{
					chain.doFilter(hRequest,hResponse);
				}
			}
			else if(roleId==3&&path=="/deletecategorycontroller"){
				String queryString=hRequest.getParameter("category");
				if(queryString==null||queryString==""){
					hResponse.sendRedirect("managecategories");
				}
				else if(queryString!=null){
					try{
						int categoryId=Integer.parseInt(queryString);
						chain.doFilter(hRequest,hResponse);
					}
					catch(Exception e){
						hResponse.sendRedirect("deny.html");
					}
				}
				else{
					chain.doFilter(hRequest,hResponse);
				}
			}
			else{
				chain.doFilter(hRequest,hResponse);
			}
		}
		else if(session==null&&(path=="/dashboard"||path=="/dashboardcontroller"||path=="/addcategory"||path=="/editcategory"||path=="/managecategories"||path=="/addcategorycontroller"||path=="/editcategorycontroller"||path=="/managecategoriescontroller"||path=="/deletecategorycontroller"||path=="/addpost"||path=="/editpost"||path=="/manageposts"||path=="/addpostcontroller"||path=="/editpostcontroller"||path=="/managepostscontroller"||path=="/deletepostcontroller")){
			hResponse.sendRedirect("signin");
		}
		else{
			chain.doFilter(hRequest,hResponse);
		}
		/*else if(session==null&&(path=="/signin"||path=="/signincontroller"||path=="/signup"||path=="/signupcontroller"||path=="/home"||path=="/"||path=="/categoryposts"||path=="/post")){
			chain.doFilter(hRequest,hResponse);
		}
		else{
			hResponse.sendRedirect("signin");
		}*/
	}
}