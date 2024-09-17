<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
	
	<h1 style="margin-left:330px;margin-top: -40px;">USER LOGIN</h1>
	
	
		<form action="LoginController" method="post">
		<table align="center" border="4px" style="border-collapse: collapse;">
			<tr>
				<td>Enter Account Number :</td>
				<td><input type="text" name="aNo" placeholder="Account Number"
					required></td>
			</tr>
			<tr>
				<td>Enter password :</td>
				<td><input type="password" name="Pass" placeholder="Password"
					required></td>
			</tr>
			<tr>
				<td><button type="reset">RESET</button></td>
				<td><button type="submit">LOGIN</button></td>
			</tr>

		</table>
	</form>
	
	
	
	<%if(session.getAttribute("f1")!=null){%>
		<script>
			alert("Something Went Wrong Login Again!!");
		</script>
		<%}session.removeAttribute("f1"); %>
	<%if(session.getAttribute("acc")!=null){%>
		<script>
			alert("Invalid Account Number!!");
		</script>
		<%}session.removeAttribute("acc"); %>
	<%if(session.getAttribute("pass")!=null){%>
		<script>
			alert("Invalid Password!!");
		</script>
		<%}session.removeAttribute("pass"); %>
	
	
</body>
</html>