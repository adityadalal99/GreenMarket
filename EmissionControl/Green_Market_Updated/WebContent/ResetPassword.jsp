<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#submitbutton").click(function(e){
		var pass=$("#password").val();
        var cpass=$("#cpassword").val();
        var i=0;
        var count=0;
        if(pass.length!=cpass.length)
        	{
        	window.alert("Password and Confirm Password do not match");
        	e.preventDefault(e);
        	}
        else
        	{
        	for(i=0;i<pass.length;i++)
        		{
        		if(pass.charAt(i)!=cpass.charAt(i))
        			{
        			window.alert("Password and Confirm Password do not match");
                	e.preventDefault(e);
                	break;
        			}
        		}
        	}
	});
});
</script>
<style>
h1
{
	font-size:40px;
}
#div1
{
	background-color: white;
	height: 300px;
	width:400px;
	margin-left: 425px;
	margin-right: 200px;
	margin-top: 130px;
	margin-bottom: 200px;
	padding: 30px;
    text-align: center;
	border-width: thin;
	border-radius: 25px;
      
}
body{
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
	background-color:#76b852;

}
.form
{
	padding: 0px;
}
.a{
	border-radius: 8px;
	width: 300px;
	height: 40px;
	font-size: 20px;
	font-weight: lighter;
	font-family:Comic Sans MS; 
}
.form input
{
	outline:0;
	cursor: auto;
}
a:link
{
	color:#76b852;
	text-decoration:none;

}
a:visited
{
	color:#76b852;
	text-decoration:none;
	}
a:active
{
	color:#76b852;
	text-decoration:none;
}

.message
{
	color: #b3b3b3;
}

.form input
{
	  background: #f2f2f2;

}
</style>
</head>
<body>
<div id="div1">

<form class="form" id="register_form" action="ChangePassword" method="post">
	<h1>
	<b style="font-family: Comic Sans MS">Emission Checker</b>
	</h1>
  
  <input type="password" name="Password" id="password" class="a" placeholder=" Password"><br><br>

  <input type="password" name="CPassword" id="cpassword" class="a" placeholder=" Confirm Password"><br><br>
  
  <input type="submit" value="Change Password" style="background-color:#76b852; cursor: pointer; color:#ffffff"  class="a" id="submitbutton"><br>
  
</form>
</div> 	
</body>
</html>