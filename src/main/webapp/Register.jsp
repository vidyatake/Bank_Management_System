<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<style>
td {
	align-content: center;
	padding: 10px;
}

input {
	padding: 5px;
	margin: 5px;
}

button {
	background-color: #031a66;
	border: 2px solid black;
	color: rgb(255, 255, 255);
	padding: 15px 28px;
	width: 100%;
	margin: 10px 0px;
	height: 50px;
	width: 200px;
	text-align: center;
	font-size: 12px;
	margin: 4px 2px;
	transition-duration: 0.2s;
	cursor: pointer;
	border-radius: 20px;
}

button:hover {
	background-color: rgb(6, 138, 2);
	border: 1px solid;
	color: rgb(255, 255, 255);
}

form {
	margin: auto;
	margin-top: 30px;
	background-color: rgb(119, 200, 232);
	width: 500px;
	border: 1px solid black;
	padding: 50px;
}
</style>
</head>
<body>

	<a href="Index.jsp"><button style="padding: 10px;">HOME</button></a>
	
	<h1 style="margin-left:250px;margin-top: -40px;">USER REGISTRATION</h1>
	<form action="RegisterController" method="post">
		<table align="center" border="4px" style="border-collapse: collapse;">
			<tr>
				<td>Enter Account Number :</td>
				<td><input type="text" name="aNo" placeholder="Account Number" pattern="[0-9]*" maxlength="5" title="Only Numbers are Accepted"
					required></td>
			</tr>
			<tr>
				<td>Enter Customer Name :</td>
				<td><input type="text" name="cName" placeholder="Customer Name" pattern="^[a-zA-Z]+(\s[a-zA-Z]+)?$" title="Enter A valid Name"
					required></td>
			</tr>
			<tr>
				<td>Enter Mobile Number :</td>
				<td><input type="text" name="mNo" placeholder="Mobile Number" pattern="[0-9]*" maxlength="10" title="Only Numbers are Accepted"
					required></td>
			</tr>
			<tr>
				<td>Enter Account Opening Balance :</td>
				<td><input type="text" name="aBal"
					placeholder="Account Balance" pattern="[0-9]*[.,]?[0-9]*" title="Only Decimal Values Are Accepted" maxlength="8" required></td>
			</tr>
			<tr>
				<td>Enter password :</td>
				<td><input type="password" name="Pass" placeholder="Password" maxlength = "20"
					required></td>
			</tr>

			<tr>
				<td><button type="reset">RESET</button></td>
				<td><button type="submit">REGISTER</button></td>
			</tr>
		</table>
	</form>
	
	<% if(session.getAttribute("acc")!=null){%>
		<script type="text/javascript">
			alert("Account Number Aldredy Present Go to Login!!")
		</script>
		<%}session.invalidate();%>
		
	
	

</body>
</html>