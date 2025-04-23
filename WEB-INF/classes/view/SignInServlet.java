package view;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class SignInServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res){
		try{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			out.println("<html>");
			out.println("    <head>");
			out.println("        <meta charset='utf-8'>");
			out.println("        <meta name='viewport' content='width=device-width,initial-scale=1.0'>");
			out.println("        <title>SIGNIN</title>");
			out.println("        <link rel='stylesheet' href='./static/css/style.css'>");
			out.println("		 <script type='text/javascript' src='./static/js/script.js'></script>");
			out.println("    </head>");
			out.println("    <body>");
			/*if(req.getAttribute("error")==null){
				out.println("<script>window.onload=function(){document.getElementById('error').style.visibility='hidden';}</script>");
			}*/
			out.println("        <section class='form_section'>");
			out.println("            <div class='container form_section_container'>");
			out.println("                <h2>Sign In</h2>");
			out.println("                <div id='error' class='alert_message error'>");
			//out.println("                    <p class='alert_message error'></p>");
			out.println("                </div>");
			out.println("                <form action='signincontroller' enctype='' method='post' id='signInForm'>");
			out.println("                    <input type='email' name='email' id='email' placeholder='Email' required>");
			out.println("					 <p class='alert_message error' id='emailError'></p>");
			out.println("                    <input type='Password' name='password' id='password' placeholder='Password'>");
			out.println("					 <p class='alert_message error' id='passwordError'></p>");
			out.println("                    <input type='button' id='submitbtn' onclick='signin()' class='btn' value='Sign In'>");
			out.println("                    <small>Don't have an acoount <a href='/blogsite/signup'>Sign Up </a>here</small>");
			out.println("                </form>");
			out.println("            </div>");
			out.println("        </section>");
			out.println("    </body>");
			out.println("</html>");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}