<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Beneficiary</title>
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
	<%
	if (session.getAttribute("udata") == null) {
		session.setAttribute("f1", true);
		response.sendRedirect("Login.jsp");
		return;
	}
	%>
	 
	<div align="center">
		<h1>Add Details of Beneficiary</h1>
	</div>
	<a href="Profile.jsp"><button style="padding: 10px;">Profile</button></a>
	
	<form action="AddbController" method="post">
		<table align="center" border="4px" style="border-collapse: collapse;">
			<tr>
				<td>Enter Account Number :</td>
				<td><input type="text" name="aNo" placeholder="Account Number"
					required></td>
			</tr>
			<tr>
				<td><button type="reset">RESET</button></td>
				<td><button type="submit">ADD</button></td>
			</tr>
		</table>
	</form>
	
	<%if(session.getAttribute("accf")!=null){%>
		<script>
			alert("Enter A Valid Account Number!!")
		</script>
	<%}session.removeAttribute("accf");%>
	
	<%if(session.getAttribute("sacc")!=null){%>
		<script>
			alert("You Can Not Add Yourself As a Beneficiary!!")
		</script>
	<%}session.removeAttribute("sacc");%>
	
</body>
</html>


