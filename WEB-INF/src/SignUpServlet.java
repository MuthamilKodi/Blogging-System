package view;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class SignUpServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res){
		try{
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			out.println("<html>");
			out.println("    <head>");
			out.println("        <meta charset='utf-8'>");
			out.println("        <meta name='viewport' content='width=device-width,initial-scale=1.0'>");
			out.println("        <title>SIGNUP</title>");
			out.println("        <link rel='stylesheet' href='./static/css/style.css'>");
			out.println("    </head>");
			out.println("    <body>");
			out.println("        <section class='form_section'>");
			out.println("            <div class='container form_section_container'>");
			out.println("                <h2>Sign Up</h2>");
			out.println("                <div class='alert_message success'>");
			out.println("                    <p>SignUp Successfull</p>");
			out.println("                </div>");
			out.println("                <form action='/SignUpServlet' enctype='multipart/form-data' autocomplete='on'>");
			out.println("                    <input type='text' placeholder='User Name' name='username' pattern='^[a-zA-Z._\\s*-]{3,}$' title='Username should contain only letters and numbers not symbol' required>");
			//out.println("                	 <div class='alert_message error'>");
			out.println("                    	<p class='alert_message error'></p>");
			//out.println("                	 </div>");
			out.println("                    <input type='email' placeholder='Email' name='email' pattern='^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$' title='Invalid Email Format' required>");
			out.println("                	 <div class='alert_message error'>");
			out.println("                    	<p></p>");
			out.println("                	 </div>");
			out.println("                    <input type='Password' placeholder='Create Password' name='password' id='password' pattern='^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$).{8,20}$' title='Should contain atleast 8 characters and symbols' required>");
			out.println("                	 <div class='alert_message error'>");
			out.println("                    	<p></p>");
			out.println("                	 </div>");
			out.println("                    <input type='Password' placeholder='Confirm Password' oninput='check(this)' id='confirmPassword' required> ");
			out.println("									<script language='javascript' type='text/javascript'>");
			out.println("									function check(input) {");
			out.println("										if (input.value != document.getElementById('password').value) {");
			out.println("										input.setCustomValidity('Password Must be Matching.');");
			out.println("										} else {");
			out.println("										input.setCustomValidity('');");
			out.println("										}");
			out.println("									}");
			out.println("									</script>");
			out.println("                	 <div class='alert_message error'>");
			out.println("                    	<p></p>");
			out.println("                	 </div>");
			out.println("                    <div class='form_control'>");
			out.println("                        <label for='avatar'>User Avatar</label>");
			out.println("                        <input type='file' name='avatar' id='avatar' accept='image/*'>");
			out.println("                    </div>");
			out.println("                	<div class='alert_message error'>");
			out.println("                   	 <p></p>");
			out.println("                	</div>");
			out.println("                    <button type='submit' class='btn'>Sign Up</button>");
			out.println("                    <small>Already have an acoount <a href='/blogsite/signin'>Sign In </a>here</small>");
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
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();

        String name = request.getParameter ("username");
        String email = request.getParameter ("email");
        String password = request.getParameter ("password");
//        avatar=request.getParameter("avatar");
    }
}