package view;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpSession;
import java.util.Base64;
import model.*;
public class DashboardServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res){
		try{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			HttpSession session=req.getSession(false);
			Database data=new Database();
			//String su=String.valueOf(session.getAttribute("userID"));
			User user=(User)session.getAttribute("user");
			//int userID=Integer.parseInt(su);
			//User user=data.getUser(userID,data.connect());
			//int roleID=data.getUserType(userID,data.connect());
			int roleID=user.getUserRole();
			byte[] avatarBytes=user.getImage();
			String avatarString;
			if(avatarBytes!=null)
				avatarString="data:png;base64,"+Base64.getEncoder().encodeToString(avatarBytes);
		    else
		    	avatarString="/blogsite/static/images/Avatar.png";
			out.println("<html>");
			out.println("	<head>");
			out.println("		<meta charset='utf-8'>");
			out.println("		<meta name='viewport' content='width=device-width,initial-scale=1.0'>");
			out.println("		<title>DASHBOARD</title>");
			out.println("		<link rel='stylesheet' href='./static/css/style.css'>");
			out.println("		 <script type='text/javascript' src='./static/js/script.js'></script>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<nav>");
			out.println("			<div class='container nav_container'>");
			out.println("				<a class='nav_logo' href='/blogsite/home'>BLOG SITE</a>");
			out.println("				<ul class='nav_items'>");
			out.println("					<li><a href='/blogsite/about'>About</a></li>");
			out.println("					<li><a href='/blogsite/contact'>Contact</a></li>");
			out.println("					<li class='categ_menu'><a>Category</a>");
			out.println("						<ul>");
			out.println("							<li><a href='/blogsite/yoga'>Yoga</a></li>");
			out.println("							<li><a href='/blogsite/food'>Food</a></li>");
			out.println("						</ul>");
			out.println("					</li>");
			out.println("					<li><a href='/blogsite/signin'>Signin</a></li>");
			out.println("					<li><a href='/blogsite/signup'>Signup</a></li>");
			out.println("					<li class='nav_profile'>");
			out.println("						<div class='avatar'>");
			out.println("							<img src='"+avatarString+"'>");
			out.println("						</div>");
			out.println("						<ul>");
			out.println("							<li><a href='/blogsite/dashboard'>Dashboard</a></li>");
			out.println("							<li><a href='/blogsite/logoutcontroller'>Logout</a></li>");
			out.println("						</ul>");
			out.println("					</li>");
			out.println("				</ul>");
			out.println("			</div>");
			out.println("		</nav>");
			out.println("		<!--===========================NAV END====================================-->");
			if(roleID==2){
				out.println("		<section class='dashboard'>");
				out.println("				<main style='margin:10rem;'>");
				out.println("					<h1>Hello "+user.getUserName()+"!</h1>");
				out.println("					<div class='newuser'>");
				out.println("						<h3>You are a blog viewer. You can view posts, and can like,comment to posts</h3>");
				out.println("						<p>If you want to create posts and add it in your blog, create blog. Then you are a blogger.</p>");
				out.println("						<p style='margin:2rem;'><button class='btn'>Create Blog</button></p>");
				out.println("					</div>");
				out.println("				</main>");
				out.println("			</div>");
				out.println("		</section>");
				out.println("		<!--===============================MANAGE END====================================================-->");
			}
			else if(roleID==3){
				out.println("		<section class='dashboard'>");
				out.println("			<div class='container dashboard_container'>");
				out.println("				<aside>");
				out.println("					<ul>");
				out.println("						<li><a href='/blogsite/addcategory'><h5>Add Category</h5></a></li>");
				out.println("						<li><a href='/blogsite/editcategory'><h5>Edit Category</h5></a></li>");
				out.println("						<li><a href='/blogsite/managecategories'><h5>Manage Categories</h5></a></li>");
				out.println("						<li><a href='/blogsite/addpost'><h5>Add Post</h5></a></li>");
				out.println("						<li><a href='/blogsite/editpost'><h5>Edit Post</h5></a></li>");
				out.println("						<li><a href='/blogsite/manageposts'><h5>Manage Posts</h5></a></li>");
				out.println("				</ul></aside>");
				out.println("				<main>");
				out.println("					<h1>Hello "+user.getUserName()+"!</h1>");
				out.println("					<div class='blogger'>");
				out.println("						<h2>Welcome to your Blog Dashboard</h2>");
				out.println("						<div>");
				out.println("							<div class='sandwitch'>");
				out.println("								<h3>Posts</h3>");
				out.println("								<p>340</p>");
				out.println("							</div>");
				out.println("							<div class='sandwitch'>");
				out.println("								<h3>Total Views</h3>");
				out.println("								<p>567</p>");
				out.println("							</div>");
				out.println("						</div>");
				out.println("					</div>");
				out.println("					<div class='newuser'>");
				out.println("						<h3>You have no posts yet.</h3>");
				out.println("						<p>You can create posts and add it in your blog</p>");
				out.println("					</div>");
				out.println("				</main>");
				out.println("			</div>");
				out.println("		</section>");
			}
			else{
				res.sendRedirect("/blogsite/signin");
			}
			out.println("		<!--===============================MANAGE END====================================================-->");
			out.println("		<footer>");
			out.println("            <div class='container footer_container'>");
			out.println("                <article>");
			out.println("                    <h1>Categories</h1>");
			out.println("                    <ul>");
			out.println("                        <li><a href='/blogsite/#'>Art</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Wild Craft</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Yoga</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Sports</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Food</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Entertainment</a></li>");
			out.println("                </article>");
			out.println("                <article>");
			out.println("                    <h1>Blog</h1>");
			out.println("                    <ul>");
			out.println("                        <li><a href='/blogsite/#'>Safety</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Repair</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Recent</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Popular</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Categories</a></li>");
			out.println("                </article>");
			out.println("                <article>");
			out.println("                    <h1>Permalinks</h1>");
			out.println("                    <ul>");
			out.println("                        <li><a href='/blogsite/#'>Home</a></li>");
			out.println("                        <li><a href='/blogsite/#'>About</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Services</a></li>");
			out.println("                        <li><a href='/blogsite/#'>Contact</a></li>");
			out.println("                </article>");
			out.println("            </div>");
			out.println("            <div class='footer_copyright'>");
			out.println("                <small>Copyright &copy; Blog Site All Rights Reserved</small>");
			out.println("            </div>");
			out.println("        </footer>");
			out.println("        <!--===============================================FOOTER END=======================================-->");
			out.println("    </body>");
			out.println("   </html>");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}