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
			out.println("		 <script type='text/javascript' src='./static/js/script.js'></script>");
			out.println("    </head>");
			out.println("    <body>");
			out.println("        <section class='form_section'>");
			out.println("            <div class='container form_section_container'>");
			out.println("                <h2>Sign Up</h2>");
			/*Object demo=req.getAttribute("demo");
			if(demo==null){
			out.println("<script language='javascript' type='text/javascript'>window.onload=function() { document.style.background='blue'; document.getElementById('demo').style.visibility='hidden'; } </script>");}
			*/
			out.println("                <div id='demo'>");
			out.println("                    <p class='alert_message error' id='signupError'></p>");
			out.println("                </div>");
			out.println("                <form action='signupcontroller' enctype='multipart/form-data' autocomplete='on' method='post' id='signUpForm'>");
			out.println("                    <input type='text' placeholder='User Name' name='username' id='username' title='Username should contain only letters and numbers not symbol' required>");
			out.println("					 <p class='alert_message error' id='nameError'></p>");
			
			out.println("                    <input type='email' placeholder='Email' name='email' id='email'  title='Invalid Email Format' required>");
			out.println("					 <p class='alert_message error' id='emailError'></p>");
			
			out.println("                    <input type='Password' placeholder='Create Password' name='password' id='password' title='Should contain atleast 8 characters and symbols' required>");
			out.println("					 <p class='alert_message error' id='passwordError'></p>");
			
			out.println("                    <input type='Password' placeholder='Confirm Password' name='confirmPassword' oninput='check(this)' id='confirmPassword' required> ");
			out.println("									<script language='javascript' type='text/javascript'>");
			out.println("									function check(input) {");
			out.println("										if (input.value != document.getElementById('password').value) {");
			out.println("										input.setCustomValidity('Password Must be Matching.');");
			out.println("										} else {");
			out.println("										input.setCustomValidity('');");
			out.println("										}");
			out.println("									}");
			out.println("									</script>");
			out.println("					 <p class='alert_message error' id='confirmPasswordError'></p>");
			
			out.println("                    <div class='form_control'>");
			out.println("                        <label for='avatar'>User Avatar</label>");
			out.println("                        <input type='file' name='avatar' id='avatar' required accept='image/*'>");
			out.println("                    </div>");
			out.println("					 <p class='alert_message error' id='avatarError'></p>");
			
			out.println("                    <button type='button' class='btn' onclick='signup()'>Sign UP</button>");
			//out.println("				 		<script>");
			//out.println("							function loadDoc() {");
			//out.println("							  const xhttp = new XMLHttpRequest();");
			//out.println("							  xhttp.onload = function() {");
			//out.println("							    document.getElementById('demo').innerHTML = this.responseText;");
			//out.println("							  }");
			//out.println("							  xhttp.open('POST','/signupcontroller');");
			//out.println("							  xhttp.setRequestHeader('Content-type', 'multipart/form-data');");
			//out.println("							  xhttp.send();");
			//out.println("							}");
			//out.println("						</script>");
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
}