//=======================================================================================
//							SIGNIN
//=======================================================================================
function signin(){
	const email=document.getElementById("email");
	const password=document.getElementById("password");
	const emailError=document.getElementById("emailError");
	const passwordError=document.getElementById("passwordError");
	//email.addEventListener("input",() => validateEmail());
	//password.addEventListener("input",() => validatePassword());
	const errors=[];
	function validatePassword(){
		const passwordVal=password.value.trim();
		if(!passwordVal){
			displayError(passwordError,"Password is required");
			errors.push(password);
		}
		else{
			clearError(passwordError);
		}
	}
	function validateFormData(){
		validatePassword();
		const statusEmailValidation=validateEmail(email.value,emailError);
		console.log(statusEmailValidation);
		if(!statusEmailValidation){
			errors.push(email);
		}
		console.log(errors.length);
		if(errors.length==0){
			sendData();
		}
	}
	function sendData(){
		const req=new XMLHttpRequest();
		req.onload=function(){
			//console.log(this.responseText);
			const obj=JSON.parse(this.responseText);
			const code=obj.messageCode;
			if(code==1){
				emailError.innerText="Invalid Email Id";
				emailError.style.visibility="visible";
			}
			else if(code==2){
				const error=document.getElementById("error")
				error.innerText="Email Id or Password is wrong";
				error.style.display="block";
			}
			else{
				window.location.href="dashboard";
			}
		};
		req.open("POST","signincontroller");
		req.setRequestHeader('Content-type','application/x-www-form-urlencoded');
		req.send("email="+email.value+"&password="+password.value);
	}
	validateFormData();
}
//==============================================================================================
//								SIGNUP
//==============================================================================================
function signup(){
	const userName=document.getElementById("username").value;
	const email=document.getElementById("email").value;
	const password=document.getElementById("password").value;
	const confirmPassword=document.getElementById("confirmPassword").value;
	const avatar=document.getElementById("avatar").value;
	const nameError=document.getElementById("nameError");
	const emailError=document.getElementById("emailError");
	const passwordError=document.getElementById("passwordError");
	const confirmPasswordError=document.getElementById("confirmPasswordError");
	const avatarError=document.getElementById("avatarError");
	const signupError=document.getElementById("signupError");
	const errors=[];
	function validateUserName(){
		const regex=/^[a-zA-Z._\\s*-]{3,}$/;
		//const regex=new RegExp("^[a-zA-Z._\\s*-]{3,}$");	
		if(!userName.trim()){
			displayError(nameError,"User Name is required");
			errors.push(nameError);
		}
		else if(!regex.test(userName)){
			displayError(nameError,"Invalid Username");
			errors.push(nameError);
		}
		else{
			clearError(nameError);
		}
	}
	function validatePassword(){
		const regex=new RegExp("^(?=.*[0-9])"+"(?=.*[a-z])(?=.*[A-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$)");
		if(!password.trim()){
			displayError(passwordError,"Password is required");
			errors.push(password);
		}
		else if(!regex.test(password)){
			displayError(passwordError,"Invalid password");
			errors.push(passwordError);
		}
		else{
			clearError(passwordError);
		}
	}
	function validateConfirmPassword(){
		if(!confirmPassword.trim()){
			displayError(confirmPasswordError,"Confirm Password is required");
			errors.push(confirmPasswordError);
		}
		else if(password!=confirmPassword){
			displayError(confirmPasswordError,"Confirm Password should be match to password");
			errors.push(confirmPasswordError);
		}
		else{
			clearError(confirmPasswordError);
		}
	}
	function validateAvatar(){
		const acceptedFileTypes=["png","jpg","jpeg"];
		const regex=new RegExp(".+\\."+acceptedFileTypes.join("|"));
		if(!avatar){

		}
		else if(!regex.test(avatar)){
			displayError(avatarError,"Avatar should be "+acceptedFileTypes.join(", ")+" file types");
			errors.push(avatarError);
		}
		else{
			const avatarSize=document.getElementById("avatar").files.item(0).size/1024;
			console.log(avatarSize+" avatarSize");
			if(avatarSize>10*1024){
				displayError(avatarError,"Avatar should be less than 10 Mb");
				errors.push(avatarError);
			}
			else{
				clearError(avatarError);
			}
		}
	}
	validateUserName();
	if(!validateEmail(email,emailError)){
		errors.push(emailError);
	}
	validatePassword();
	validateConfirmPassword();
	validateAvatar();
	function sendData(){
		const req=new XMLHttpRequest();
		req.onload=function(){
			//console.log(this.responseText);
			const obj=JSON.parse(this.responseText);
			const code=obj.messageCode;
			if(code==6){
				window.location.href="signin";
			}
			else if(code==8){
				displayError(signupError,"Email ID already exists");
			}
			else if(code==7){
				displayError(signupError,"Failure try again..");
			}
		};
		req.open("POST","signupcontroller");
		//req.setRequestHeader('Content-Type','multipart/form-data');
		//string data="username="+userName+"&email="+email+"&password="+password+"&confirmPassword="+confirmPassword;
		const form=document.getElementById("signUpForm");
		const formData=new FormData(form);
		if(avatar){
			//formData.append(avatar.value,document.getElementById("avatar").files.item(0));
			//data+="&avatar="+document.getElementById("avatar").files.item(0);
		}
		req.send(formData);
		console.log(formData);
	}
	if(errors.length==0){
		sendData();
	}
}
//=====================================================================================================================
//								CATEGORY
//=====================================================================================================================
function category(reqUrl,categoryId){
	const error=document.getElementById("error");
	clearError(error);
	const errors=[];
	var titleElt=document.getElementById("title");
	var descElt=document.getElementById("desc")
	function validateCategoryTitle(){
		var title=titleElt.value.trim();
		var titleErrField=document.getElementById("titleError");
		const titleRegex=/^\w+(\s\w+)*$/;
		//Required Field
		if(title==null||title==""){
			console.log("Title is empty");
			errors.push("title");
			displayError(titleErrField,"Category Title is mandatory");
		}
		//Field value limit
		else if(title.length>40){
			errors.push("title");
			displayError(titleErrField,"Category Title does not exceed 40 characters");
		}
		//Regex
		else if(!titleRegex.test(title)){
			errors.push("title");
			displayError(titleErrField,"Invalid Category Title");
		}
		else{
			clearError(titleErrField);
		}
	}
	function validateCategoryDesc(){
		var desc=descElt.value.trim();
		var descErrField=document.getElementById("descError");
		const descRegex=/^\w+\.?(\s\w+\.?)*$/;
		//Field value limit
		if(desc!=null&&desc.length>400){
			errors.push("desc");
			displayError(descErrField,"Description does not exceed 400 characters")
		}
		//Regex
		else if(desc!=""&&!descRegex.test(desc)){
			errors.push("desc");
			displayError(descErrField,"Invalid Category Description");
		}
		else{
			clearError(descErrField);
		}
	}	
	validateCategoryTitle();
	validateCategoryDesc();
	function sendData(){
		const req=new XMLHttpRequest();
		req.onload=function(){
			const obj=JSON.parse(this.responseText);
			const code=obj.code;
			const message=obj.message;
			if(code==0){
				error.className="alert_message error";
				error.innerText=message;
				error.style.display="block";
			}
			else if(code==1){
				error.className="alert_message success";
				error.innerText=message;
				error.style.display="block";
				if(categoryId!=null){
					window.location.href="/blogsite/managecategories";
				}
			}
		};
		req.open("POST",reqUrl);
		req.setRequestHeader('Content-type','application/x-www-form-urlencoded');
		if(categoryId==null)
			req.send("title="+titleElt.value.trim()+"&desc="+descElt.value.trim());
		else
			req.send("categoryId="+categoryId+"&title="+titleElt.value.trim()+"&desc="+descElt.value.trim());
	}
	if(errors.length==0)
		sendData();
}

function addCategory(){
	category("addcategorycontroller");
}

function editCategoryGet(){
	const req=new XMLHttpRequest();
	req.onload=function(){
		var titleElt=document.getElementById("title");
		var descElt=document.getElementById("desc")
		const obj=JSON.parse(this.responseText);
		const status=obj.status;
		if(status=="success"){
			const category=obj.data;
			titleElt.value=category.categoryName;
			descElt.value=category.categoryDesc;
		}
		else{
			window.location.href="managecategories";
		}
	};
	req.open("GET","editcategorycontroller"+window.location.search);
	req.send();
}

function editCategoryPost(){
	const queryString=window.location.search;
	const editBtn=document.getElementsByClassName[0];
	category("editcategorycontroller",queryString.slice(queryString.indexOf('=')+1));
}

function manageCategory(){
	const req=new XMLHttpRequest();
	req.onload=function(){
		const categoryTable=document.getElementById("categoriesTable");
		const obj=JSON.parse(this.responseText);
		const status=obj.status;
		if(status=="success"){
			const categories=obj.data;
			for(categ in categories){
				const category=categories[categ];
				//console.log(category);
				const tr=document.createElement("tr");
				categoryTable.appendChild(tr);
				tr.setAttribute("data-category_id",category.categoryId);
				const name=document.createElement("td");
				const categoryName=category.categoryName;
				name.innerText=categoryName;
				tr.appendChild(name);
				const desc=document.createElement("td");
				desc.innerText=category.categoryDesc;
				tr.appendChild(desc);
				const edit=document.createElement("td");
				const editUrl=document.createElement("a");
				editUrl.setAttribute("href","/blogsite/editcategory?category="+tr.dataset.category_id);
				editUrl.setAttribute("class","btn sm");
				editUrl.innerText="Edit";
				edit.appendChild(editUrl);
				tr.appendChild(edit);
				const del=document.createElement("td");
				//const content="<button class='btn danger' onclick='deleteCategory(\""+categoryName+"\",\")'>Delete</button>"
				const content="<button class='btn danger'>Delete</button>";
				del.innerHTML=content;
				const delBtn=del.children[0];
				//Delete Category 
				delBtn.addEventListener("click",function deleteCategory(){
					const deleteStatus=window.confirm("Are you sure you want to delete \'"+categoryName+"\'");
					if(deleteStatus){
						const req=new XMLHttpRequest();
							req.onload=function(){
								const obj=JSON.parse(this.responseText);
								const message=obj.message;
								if(message==true){
									alert("Successfully Deleted");
									window.location.href="/blogsite/managecategories";
								}
								else{
									alert("Failure");
								}
							};
							req.open("GET","deletecategorycontroller?category="+category.categoryId);
							req.send();
					}
				});
				tr.appendChild(del);
			}
		}
		else{
			categoryTable.innerText="You are not have any categoried yet. You can add category.";
			categoryTable.style.className="newuser";
		}
	};
	req.open("GET","getusercategoriescontroller?full");
	req.send();
}
//==============================================================================================================
//								POST
//==============================================================================================================
function loadCategories(){
	const req=new XMLHttpRequest();
	req.onload=function(){
		const obj=JSON.parse(this.responseText);
		const status=obj.status;
		if(status=="success"){
			const categories=obj.data;
			const categoryIdElt=document.getElementById("categoryId");
			for(category in categories){
				const optionElt=document.createElement("option");
				optionElt.innerText=categories[category]["categoryName"];
				optionElt.setAttribute("value",categories[category]["categoryId"]);
				categoryIdElt.appendChild(optionElt);
			}
		}
	};
	req.open("GET","getusercategoriescontroller?short");
	req.send();
}
function addPost(){
	post()
}
function post(reqUrl,categoryId){
	const error=document.getElementById("formError");
	clearError(error);
	const errors=[];
	const titleElt=document.getElementById("title");
	const contentElt=document.getElementById("content");
	const categoryIdElt=document.getElementById("categoryId");
	const thumbnail=document.getElementById("thumbnail").value;
	function validateTitle(){
		var title=titleElt.value.trim();
		var titleErrField=document.getElementById("titleError");
		const titleRegex=/^\w+(\s\w+)*$/;
		//Required Field
		if(title==null||title==""){
			console.log("Title is empty");
			errors.push("title");
			displayError(titleErrField,"Post Title is mandatory");
		}
		//Field value limit
		else if(title.length>80){
			errors.push("title");
			displayError(titleErrField,"Post Title does not exceed 80 characters");
		}
		//Regex
		else if(!titleRegex.test(title)){
			errors.push("title");
			displayError(titleErrField,"Invalid Post Title");
		}
		else{
			clearError(titleErrField);
		}
	}
	function validateContent(){
		var content=contentElt.value.trim();
		var contentErrField=document.getElementById("contentError");
		const contentRegex=/^\w+\.?(\s\w+\.?)*$/;
		//Required Field
		if(content==null||content==""){
			console.log("content is empty");
			errors.push("content");
			displayError(contentErrField,"Post Content is mandatory");
		}
		//Field value limit
		else if(content.length>5000){
			errors.push("content");
			displayError(contentErrField,"Post Content does not exceed 5000 characters")
		}
		//Regex
		else if(contentRegex.test(content)){
			errors.push("content");
			displayError(contentErrField,"Invalid Post Content");
		}
		else{
			clearError(contentErrField);
		}
	}
	function validateCategoryId(){
		var categoryId=categoryIdElt.value;
		var categoryIdErrField=document.getElementById("categoryIdError");
		//Required Field
		if(categoryId==null||categoryId==""){
			console.log("Category Id is empty");
			errors.push("categoryId");
			displayError(categoryIdErrField,"Category Id is mandatory");
		}
		else{
			clearError(categoryIdErrField);
		}
	}
	function validateThumbnail(){
		const thumbnailError=document.getElementById("thumbnailError");
		const acceptedFileTypes=["png","jpg","jpeg"];
		const regex=new RegExp(".+\\."+acceptedFileTypes.join("|"));
		if(!thumbnail){
			displayError(thumbnailError,"Thumbnail is required");
			errors.push("thumbnailError");
		}
		else if(!regex.test(thumbnail)){
			displayError(thumbnailError,"Thumbnail should be "+acceptedFileTypes.join(", ")+" file types");
			errors.push(thumbnailError);
		}
		else{
			const thumbnailSize=document.getElementById("thumbnail").files.item(0).size/1024;
			console.log(thumbnailSize+" thumbnailSize");
			if(thumbnailSize>10*1024){
				displayError(thumbnailError,"Thumbnail should be less than 10 Mb");
				errors.push(thumbnailError);
			}
			else{
				clearError(thumbnailError);
			}
		}
	}	
	validateTitle();
	validateContent();
	validateCategoryId();
	validateThumbnail();
	function sendData(){
		const req=new XMLHttpRequest();
		req.onload=function(){
			const obj=JSON.parse(this.responseText);
			const code=obj.code;
			const message=obj.message;
			if(code==0){
				error.className="alert_message error";
				error.innerText=message;
				error.style.display="block";
			}
			else if(code==1){
				error.className="alert_message success";
				error.innerText=message;
				error.style.display="block";
				if(categoryId!=null){
					window.location.href="/blogsite/managecategories";
				}
			}
		};
		req.open("POST",reqUrl);
		req.setRequestHeader('Content-type','multipart/form-data');
		const form=document.getElementById("postForm");
		const formData=new FormData(form);
		req.send(formData);
	}
	if(errors.length==0)
		sendData();
}

//==============================================================================================================
//								GENERAL
//==============================================================================================================
function validateEmail(emailVal,emailError){
	//const emailVal=email.value;
	const emailRegex=/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	if(!emailVal){
		displayError(emailError,"Email Id is required");
		return false;
	}
	else if(!emailRegex.test(emailVal)){
		displayError(emailError,"Please Enter valid Email ID");
		return false;
	}
	else{
		clearError(emailError);
		return true;
	}
}

function displayError(field,message){
	field.innerText=message;
	field.style.display="block";
//	errors.push(field);
}

function clearError(field){
	field.innerText="";
	field.style.display="none";
//	errors.pop(field);
}

function profileLoading() {
	const req=new XMLHttpRequest();
	req.onload=function(){
		const obj=JSON.parse(this.responseText);
		const code=obj.MessageCode;
		const profElt=document.getElementsByClassName("nav_profile")[0];
		if(code==1){
			profElt.style.display="none";
			//window.location.href="signin";
		}
		else if(code==2){
			let as=obj.avatarString;
			let elt=profElt.children[0].children[0];
			elt.setAttribute("src",as);
		}
	};
	req.open("GET","profileservlet");
	req.send();
}

window.onload=profileLoading();

if(window.location.pathname=="/blogsite/managecategories"){
	console.log("managecategories");
	window.onload=manageCategory();
}

if(window.location.pathname=="/blogsite/editcategory"){
	console.log("edit categories");
	window.onload=editCategoryGet();
}

if(window.location.pathname=="/blogsite/addpost"){
	window.onload=loadCategories();
}
