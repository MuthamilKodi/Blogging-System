package controller;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.http.HttpSession;
import java.util.Base64;
import org.json.JSONObject;
import model.*;
public class ProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res){
		try{
			res.setContentType("application/json");
			PrintWriter out=res.getWriter();
			HttpSession session=req.getSession(false);
			JSONObject obj=new JSONObject();
			if(session==null){
				obj.put("MessageCode",1);
				out.print(obj);
			}
			else{
				User user=(User)session.getAttribute("user");
				byte[] avatarBytes=user.getImage();
				String avatarString;
				if(avatarBytes!=null)
					avatarString="data:png;base64,"+Base64.getEncoder().encodeToString(avatarBytes);
			    else
			    	avatarString="/blogsite/static/images/Avatar.png";
			    obj.put("MessageCode",2);
			    obj.put("avatarString",avatarString);
			    out.print(obj);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}