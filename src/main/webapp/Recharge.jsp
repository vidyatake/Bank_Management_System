<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge</title>
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
	<div align="center">
		<h1>RECHARGE</h1>
	</div>
	<a href="Profile.jsp"><button style="padding: 10px;">PROFILE</button></a>
	<form action="RechargeController">
		<table align="center" border="4px" style="border-collapse: collapse;">
			<tr>
				<td>Enter Mobile Number :</td>
				<td><input type="text" name="mNo" placeholder="Mobile Number" pattern="[0-9]*" maxlength="10" required></td>
			</tr>
			<tr>
				<td>Select Service Operator :</td>
				<td>
					<select name="mOp">
						<option value="Jio">Jio</option>
						<option value="Airtel">Airtel</option>
						<option value="VI">VI (Vodafone Idea)</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Enter Recharge Amount :</td>
				<td><input type="text" name="Amt" placeholder="Recharge Amount" pattern="[0-9]*[.,]?[0-9]*" required></td>
			</tr>

			<tr>
				<td><button type="reset">RESET</button></td>
				<td><button type="submit">CONFIRM</button></td>
			</tr>
		</table>
	</form>

	

</body>
</html>