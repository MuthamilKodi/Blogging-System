package view;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class PostServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res){
		try{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			out.println("<html>");
			out.println("	<head>");
			out.println("		<meta charset='utf-8'>");
			out.println("		<meta name='viewport' content='width=device-width,initial-scale=1.0'>");
			out.println("		<title>POST</title>");
			out.println("		<link rel='stylesheet' href='./static/css/style.css'>");
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
			out.println("							<img src='./static/images/avatar1.jpg'>");
			out.println("						</div>");
			out.println("						<ul>");
			out.println("							<li><a href='/blogsite/dashboard'>Dashboard</a></li>");
			out.println("							<li><a href='/blogsite/logout'>Logout</a></li>");
			out.println("						</ul>");
			out.println("					</li>");
			out.println("				</ul>");
			out.println("			</div>");
			out.println("		</nav>");
			out.println("		<!--===========================NAV END====================================-->");
			out.println("		<section class='singlepost'>");
			out.println("			<div class='fixed_details'>");
			out.println("				<a>Like</a>");
			out.println("				<span>20</span>");
			out.println("				<a>Comment</a>");
			out.println("				<span>23</span>");
			out.println("				<a>Share</a>");
			out.println("				<span>12</span>");
			out.println("			</div>");
			out.println("			<div class='container singlepost_container'>");
			out.println("				<h2>jhjvjm hjvmv bkhvhmn jmkbkjb</h2>");
			out.println("				<div class='post_details'>");
			out.println("					<div class='post_author'>	");
			out.println("						<div class='post_avatar'>");
			out.println("							<a href='/blogsite/user'><img src='./static/images/avatar1.jpg'></a>");
			out.println("						</div>");
			out.println("						<div class='post_author_info'>");
			out.println("							<h5>By: Jane Doe</h5>");
			out.println("							<h5>june 10,2022</h5>");
			out.println("						</div>");
			out.println("					</div>");
			out.println("					<div>");
			out.println("						100 Views");
			out.println("					</div>");
			out.println("				</div>");
			out.println("				<div class='singlepost_thumbnail'>");
			out.println("					<img src='./static/images/yoga1.jpg'>");
			out.println("				</div>");
			out.println("				<p>This new edition has benefited from review by a number of people who gave generously");
			out.println("							of their time and expertise. The following professors reviewed all or a large part of the");
			out.println("							manuscript: Hossein Beyzavi (Marymount University), Donald F. Costello (University of");
			out.println("							Nebraska–Lincoln), James Haralambides (Barry University)</p>");
			out.println("				<p>This new edition has benefited from review by a number of people who gave generously");
			out.println("							of their time and expertise. The following professors reviewed all or a large part of the");
			out.println("							manuscript: Hossein Beyzavi (Marymount University), Donald F. Costello (University of");
			out.println("							Nebraska–Lincoln), James Haralambides (Barry University)</p>");
			out.println("				<section class='category_buttons'>");
			out.println("					<form>");
			out.println("						<h2>Leave a Comment</h2>");
			out.println("						<label>Comment</label><br><br>");
			out.println("						<input type='text' style='width: 100%;background: transparent;border:1px solid white;color:white;height: 2rem;'><br><br>");
			out.println("						<input type='button' class='btn' value='Post Comment'>");
			out.println("					</form>");
			out.println("					<h2>Comments</h2>");
			out.println("					<div style='border:1px solid wheat;'>");
			out.println("					<div class='post_author'>	");
			out.println("						<div class='post_avatar'>");
			out.println("							<img src='./static/images/avatar1.jpg'>");
			out.println("						</div>");
			out.println("						<div class='post_author_info'>");
			out.println("							<h5>Jane Doe</h5>");
			out.println("							<h5>june 10,2022</h5>");
			out.println("						</div>");
			out.println("					</div>");
			out.println("					<div class='comment'>");
			out.println("						dytfygkhhhhhhjbkbk vhjhv  hjv");
			out.println("					</div></div><div style='border:1px solid wheat;'>");
			out.println("					<div class='post_author'>	");
			out.println("						<div class='post_avatar'>");
			out.println("							<img src='./static/images/avatar1.jpg'>");
			out.println("						</div>");
			out.println("						<div class='post_author_info'>");
			out.println("							<h5>Jane Doe</h5>");
			out.println("							<h5>june 10,2022</h5>");
			out.println("						</div>");
			out.println("					</div>");
			out.println("					<div class='comment'>");
			out.println("						dytfygkhhhhhhjbkbk vhjhv  hjv");
			out.println("					</div></div>");
			out.println("				</section>");
			out.println("			</div>");
			out.println("		</section>");
			out.println("		<!--=========================================END OF SINGLE POST==============================================-->");
			out.println("		<footer>");
			out.println("			<div class='container footer_container'>");
			out.println("				<article>");
			out.println("					<h1>Categories</h1>");
			out.println("					<ul>");
			out.println("						<li><a href='/blogsite/#'>Art</a></li>");
			out.println("						<li><a href='/blogsite/#'>Wild Craft</a></li>");
			out.println("						<li><a href='/blogsite/#'>Yoga</a></li>");
			out.println("						<li><a href='/blogsite/#'>Sports</a></li>");
			out.println("						<li><a href='/blogsite/#'>Food</a></li>");
			out.println("						<li><a href='/blogsite/#'>Entertainment</a></li>");
			out.println("				</article>");
			out.println("				<article>");
			out.println("					<h1>Blog</h1>");
			out.println("					<ul>");
			out.println("						<li><a href='/blogsite/#'>Safety</a></li>");
			out.println("						<li><a href='/blogsite/#'>Repair</a></li>");
			out.println("						<li><a href='/blogsite/#'>Recent</a></li>");
			out.println("						<li><a href='/blogsite/#'>Popular</a></li>");
			out.println("						<li><a href='/blogsite/#'>Categories</a></li>");
			out.println("				</article>");
			out.println("				<article>");
			out.println("					<h1>Permalinks</h1>");
			out.println("					<ul>");
			out.println("						<li><a href='/blogsite/#'>Home</a></li>");
			out.println("						<li><a href='/blogsite/#'>About</a></li>");
			out.println("						<li><a href='/blogsite/#'>Services</a></li>");
			out.println("						<li><a href='/blogsite/#'>Contact</a></li>");
			out.println("				</article>");
			out.println("			</div>");
			out.println("			<div class='footer_copyright'>");
			out.println("				<small>Copyright &copy; Blog Site</small>");
			out.println("			</div>");
			out.println("		</footer>");
			out.println("	</body>");
			out.println("</html>");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}