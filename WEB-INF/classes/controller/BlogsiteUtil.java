package controller;
class BlogsiteUtil{
	public boolean isValidEmail(String emailId){
		if(emailId!=null)
			return emailId.matches("^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$");
		else
			return false;
	}
	public boolean isValidUserName(String userName){
		if(userName!=null)
			return userName.matches("^[a-zA-Z._\\s*-]{3,}$");
		else
			return false;
	}
	public boolean isValidPassword(String password){
		if(password!=null)
			return password.matches("^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$).{8,20}$");
		else
			return false;
	}
	public boolean isValidConfirmPassword(String confirmPassword,String password){
		if(confirmPassword!=null&&password!=null){
			System.out.println("confirmPassword1");
			System.out.println(confirmPassword.equals(password));
			return confirmPassword.equals(password);
		}
		else{
			System.out.println("confirmPassword2");
			return false;
		}
		
	}
	public boolean isValidAvatar(String type,int size){
		System.out.println(type);
		if((type.equals("image/jpg")||type.equals("image/png")||type.equals("image/jpeg"))&&size<=1024*1024*10)
			return true;
		else
			return false;
	}
}