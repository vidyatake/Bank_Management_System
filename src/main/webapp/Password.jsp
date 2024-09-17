<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bank.model.Register" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<head>
<!-- f1,pflag(password Updation),thflag(Transaction History) -->
<title>Account Details</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html; charset=iso-8859-2" http-equiv="Content-Type">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link href="./css/AccDetails.css" rel="stylesheet">
<style>
#pdiv{
	margin: auto;
	margin-top: 30px;
	background-color: rgb(100, 177, 248);
	width: 700px;
	border: 1px solid black;
	padding: 2rem;
}
tr, td {
	border: 2px solid;
	border-collapse: collapse;
}
table{
text-align: center;
}
</style>
</head>
<body>	
	<%
	if(session.getAttribute("udata")==null){
		session.setAttribute("f1", true);
		response.sendRedirect("Login.jsp");
		return;
	}
	%>
	<a href="Report.jsp" class="btn btn-dark btn-lg" style="margin:10px;margin-top:20px;">Profile Report</a>
	
	<h1 style="margin-left:300px;margin-top: -40px;">Change Password</h1>
	<div id="pdiv">
		<form action="PasswordController" method="post" id="ptable">
		<table style="border: 5%;" align="center" border="4px" >
				<tr>
				<td>Enter New Password</td>
				<td><input type="text" name="npass" placeholder="Password" required></td>
			</tr>
			<tr>
				<td><button type="reset" class="btn btn-dark btn-lg" >Reset</button></td>
				<td><button type="submit" class="btn btn-dark btn-lg" >Confirm</button></td>
			</tr>
		</table>
	</div>
	</form>
</body>

</html>


