<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bank.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="text/html; charset=iso-8859-2" http-equiv="Content-Type">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link href="./css/FundTransfer.css" rel="stylesheet">
</head>
<body>
	<%
	if(session.getAttribute("udata")==null){
		session.setAttribute("f1", true);
		response.sendRedirect("Login.jsp");
		return;
	}
	%>
	<%! 
	BillModel b = null;
	%>
	<% 
	b = (BillModel)session.getAttribute("pdata");
	%>
	<a href="Profile.jsp" class="btn btn-dark btn-lg" style="margin:10px;margin-top:20px;">Profile</a>
	
	<div align="center" style="margin-top: -50px">
		<h1>Recharge Details</h1>
	</div>
	<form>
		<table style="border: 5%; align: center; border: 4px";>
			<tr>
				<td>Transaction ID:</td>
				<td><%=b.getT().getId() %></td>
			</tr>
			<tr>
				<td>From Account:</td>
				<td><%=b.getT().getFaccNo() %></td>
			</tr>
			<tr>
				<td>To:</td>
				<td><%=b.getT().getTaccNo() %></td>
			</tr>
			<tr>
				<td>Transaction Date:</td>
				<td><%=b.getT().getDate() %></td>
			</tr>
			<tr>
				<td>Transaction Type:</td>
				<td><%=b.getT().getService() %></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><%=b.getT().getAmount() %></td>
			</tr>
		</table>
	</form>
	<br>
	<h4>Thank You!! See you again!!</h4>

</body>
</html>