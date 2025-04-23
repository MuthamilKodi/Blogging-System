package controller;
import model.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.Part;
import java.time.Instant;
import java.sql.Timestamp;
import java.util.Arrays;
import jakarta.servlet.annotation.*;
import java.util.Base64;
import controller.BlogsiteUtil;
import org.json.JSONObject;
@MultipartConfig()
public class SignUpController extends HttpServlet{
    
public void signUp(){

}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	    try{
        Database data=new Database();
        BlogsiteUtil blogUtil=new BlogsiteUtil();
    	Boolean success=false;
        User user=new User();  
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        Part imagePart=null;
        byte[] avatar_bytes=null;
        InputStream avatar=null;
        JSONObject obj=new JSONObject();
        String userName=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String confirmPassword=request.getParameter("confirmPassword");
        System.out.println(userName+email+password+confirmPassword);
        boolean nameStatus=!blogUtil.isValidUserName(userName);
        System.out.println("1"+nameStatus);
        if(nameStatus){
            obj.put("messageCode",1);
            out.print(obj);
            return;
        }
        user.setUserName(userName);
        boolean emailStatus=!blogUtil.isValidEmail(email);
        System.out.println("2"+emailStatus);
        if(emailStatus){
            obj.put("messageCode",2);
            out.print(obj);
            return;
        }
        user.setUserEmail(email);
        boolean passwordStatus=!blogUtil.isValidPassword(password);
        System.out.println("3"+passwordStatus);
        if(passwordStatus){
            obj.put("messageCode",3);
            out.print(obj);
            return;
        }
        user.setUserPassword(password);
        boolean confirmPasswordStatus=!blogUtil.isValidConfirmPassword(confirmPassword,password);
        System.out.println("4"+confirmPasswordStatus);
        if(confirmPasswordStatus){
            obj.put("messageCode",4);
            out.print(obj);
            return;
        }
        imagePart=request.getPart("avatar");
        String image_type=imagePart.getContentType();
        try{
            avatar=imagePart.getInputStream();
            avatar_bytes=new byte[avatar.available()];
            System.out.println("Avatar bytes "+avatar.available());
            if(avatar.available()!=0){
                boolean avatarStatus=!blogUtil.isValidAvatar(image_type,avatar.available());
                System.out.println("5"+avatarStatus);
                if(avatarStatus){
                    obj.put("messageCode",5);
                    out.print(obj);
                    return;
                }
                avatar.read(avatar_bytes);
                avatar.close();
            }
            //String base64Avatar=Base64.getEncoder().encodeToString(avatar_bytes);
            //out.println("<img src='data:"+image_type+";base64,"+base64Avatar+"'/>");
        }
        catch(Exception e){
             e.printStackTrace();
        }
        user.setUserAvatar(avatar_bytes);
        

        //RequestDispatcher rd=request.getRequestDispatcher("signup");
        if(!(data.verifyEmailId(user.getEmailId(),data.connect()))){
        	//User user=new User(1,name,email.toLowerCase(),password,instant);
        	success=data.registerUser(user,data.connect());
        	if(success){
                obj.put("messageCode",6);
                out.print(obj);
                /*out.println("success");
                request.setAttribute("demo","SignUp Successful");
            	rd.include(request,response);
            	response.sendRedirect("signin");*/
        	}
         	else{
                obj.put("messageCode",7);
                out.print(obj);
             	/*out.println("failure");
            	request.setAttribute("demo","SignUp Failure");
            	rd.forward(request,response);*/
         	}
        }
        else{
            obj.put("messageCode",8);
            out.print(obj);
        	/*out.println("email id already exists");
        	request.setAttribute("demo","Email Id already Exists");
        	rd.forward(request,response);*/
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
     }
}