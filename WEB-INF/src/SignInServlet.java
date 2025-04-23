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
			out.println("    </head>");
			out.println("    <body>");
			out.println("        <section class='form_section'>");
			out.println("            <div class='container form_section_container'>");
			out.println("                <h2>Sign In</h2>");
			out.println("                <div class='alert_message success'>");
			out.println("                    <p>This is a successful message</p>");
			out.println("                </div>");
			out.println("                <form action='' enctype=''>");
			out.println("                    <input type='text' placeholder='Email' pattern='^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$' title='Invalid Email Format' required>");
			out.println("                    <input type='Password' placeholder='Password'>");
			out.println("                    <button type='submit' class='btn'>Sign In</button>");
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