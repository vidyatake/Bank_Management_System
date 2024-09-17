<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="bank.model.*"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
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
	width: 550px;
	border: 1px solid black;
	padding: 50px;
}
</style>
</head>

<body>
<body>
	<%
	if (session.getAttribute("udata") == null) {
		session.setAttribute("f1", true);
		response.sendRedirect("Login.jsp");
		return;
	}
	%>
	<%
	if (session.getAttribute("bedata") == null) {
		session.setAttribute("fuacc", true);
		response.sendRedirect("FundController");
		return;
	}
	%>
	<%!List<Beneficiary> blst = null;%>
	<% blst = (List<Beneficiary>)session.getAttribute("bedata"); %>
	
	<a href="Profile.jsp" ><button style="padding: 10px;">PROFILE</button></a>
	<div align="center" style="display: inline-block;margin-left:70px;">
		<h1>FUND TRANSFER</h1>
		
	</div>	
	
	<form action="PaymentController" method="post">
	
		<div align="center" style="margin-top: -30px;">
			<h1>List Of Beneficiearies</h1>	
		</div>
		
		<table align="center" border="4px" style="border-collapse: collapse;">
			<tr>
				<td>To Account</td>
				<td>Name</td>
				<td>Mobile Number</td>
				<td>Select</td>
			</tr>
			<%
			if (blst != null) {
				for (Beneficiary b : blst) {
			%>
			<tr>
				<td><%=b.getT_accno()%></td>
				<td><%=b.getName()%></td>
				<td><%=b.getMobileno()%></td>
				<td><input type="radio" name="select"
					value="<%=b.getT_accno()%>" required></td>
			</tr>
			<%
			}
			}
			%>
			<tr>
				<td colspan="2">Enter Amount to transfer :</td>
				<td colspan="2"><input type="text" name="Amount" placeholder="Amount" required></td>
			</tr>
			<tr>
				<td colspan="2"><button type="reset">RESET</button></td>
				<td colspan="2"><button type="submit">PAY</button></td>
			</tr>
		</table>	
	</form>
	<a href="Addb.jsp"><button style="padding: 10px;">Add New Beneficiary</button></a>
	
	
	
	<%if(session.getAttribute("bflag")!=null){%>
		<script>
			alert("Beneficiary Is Aldredy Present In The List!!")
		</script>
	<%}session.removeAttribute("bflag");%>
</body>

</html>