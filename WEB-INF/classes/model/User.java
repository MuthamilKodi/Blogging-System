package model;
import java.sql.*;
import java.io.*;
enum UserRole{
		ADMIN,
		VIEWER,
		BLOGGER
}
public class User{
	private int user_id;
	private String username;
	private String email;
	private String password;
	private Timestamp date;
	private UserRole user_role;
	private byte[] avatar; 

	public User(){
		this.user_role=UserRole.VIEWER;
	}
	//for session user object details
	public User(int user_id,int user_role,String username,byte[] avatar){
		this.user_id=user_id;
		if(user_role==1)
			this.user_role=UserRole.ADMIN;
		else if(user_role==2)
			this.user_role=UserRole.VIEWER;
		else if(user_role==3)
			this.user_role=UserRole.BLOGGER;
		this.username=username;
		this.avatar=avatar;
	} 

	/*public User(int user_id,String username,String email,String password,Timestamp date){
		this.user_id=user_id;
		this.username=username;
		this.email=email;
		this.password=password;
		this.date=date;
		//this.user_role=UserRole.VIEWER;
	}

	public User(int user_id,String username,String email,String password,Timestamp date,byte[] avatar){
		this(user_id,username,email,password,date);

		this.avatar=avatar;
	}*/


	// public User(int user_id,String password,String name,int role_id,String email){
	// 	this.user_id=user_id;
	// 	this.username=name;
	// 	this.email=email;
	// 	this.password=password;
	// 	this.user_role=UserRole.ADMIN;		
	// }

	public int getUserId(){
		return user_id;
	}

	public byte[] getImage(){
		return avatar;
	}

	public String getEmailId(){
		return email;
	}

	public String getPassword(){
		return password;
	}

	public String getUserName(){
		return username;
	}

	public Timestamp getDate(){
		return date;
	}

	public int getUserRole(){
		int role=0;
		switch (this.user_role){
		case ADMIN:
			role=1;
			break;
		case VIEWER:
			role=2;
			break;
		case BLOGGER:
			role=3;
			break;
		}
		return role;
	}
	
	/*public UserRole getUserRole(){
		return this.user_role;
	}*/

	public void setUserRole(UserRole user_role){
		this.user_role=user_role;
	}

	public void setUserRole(int user_role){
		switch (user_role){
		case 1:
			this.user_role=UserRole.ADMIN;
			break;
		case 2:
			this.user_role=UserRole.VIEWER;
			break;
		case 3:
			this.user_role=UserRole.BLOGGER;
			break;
		}
	}

	public void setUserId(int user_id)
	{
		this.user_id=user_id;
	}
	public void setUserName(String username){
		this.username=username;
	}
	public void setUserPassword(String password){
		this.password=password;
	}
	public void setUserEmail(String email){
		this.email=email;
	}
	public void setUserAvatar(byte[] avatar){
		this.avatar=avatar;
	}
	public void show(){
		System.out.println(this.user_id+this.username);
	}
}