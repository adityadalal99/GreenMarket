<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OTP verification</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
var s="";
$(document).ready(function(){
	$("#submit_button").click(function(event){
		$.get("checkOTP", { otp_val: $("#Otp_val").val() }, function(data){
			s=data;	
			if(data!="")
				{
				window.alert(s);
				}
			if(data=="")
				{
				$("#submit_button").unbind('click').click();
				}
		});
		event.preventDefault();
	});
});
</script>
<style>
h1
{
	font-size:40px;
}
div
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
<%
String email=(String)session.getAttribute("Email");
%>
<div>

<form class="form" method="post" action="ResetPassword.jsp">
	<h1>
	<b style="font-family: Comic Sans MS">Forgot Password</b>
	</h1>
	<p>Enter the OTP sent to <%= email  %> 
	or <a href="ForgotPassword.html">change email</a> </p>
	<input type="text" name="Otp_val" id="Otp_val" placeholder=" Enter OTP" class="a"><br><br>
	<input type="submit" value="Verify OTP" class="a" style="background-color:#76b852; cursor: pointer; color:#ffffff" id="submit_button" >
	<p>Note: OTP is only valid for 5 minutes</p>
	<a href="ResendMail">Resend OTP</a>
 </form>
</div> 
</body>
</html>