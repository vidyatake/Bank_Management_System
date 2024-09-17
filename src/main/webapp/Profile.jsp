<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head> 
	
    <title>
        Profile Page
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta content="text/html; charset=iso-8859-2" http-equiv="Content-Type">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <style>
        .card{
            margin-top: 1rem;
            margin-bottom: 1rem;
        }
        .navbar{
   position: sticky;
    top: 0;
    width: 100vw;
    z-index: 2; 
    height: fit-content;
   background-color: rgb(240, 243, 247);
}

.navbar img{
     left: 0;
}
.navbar-brand{
    color: black;
}
.navbar-brand:hover{
    color: black;
}
button {
	background-color: #449ce9;
	border: 2px solid black;
	color: rgb(3, 3, 3);
	padding: 10px 20px;
	width: 80%;
	margin: 10px 0px;
	height: 40px;
	width: 150px;
	text-align: center;
	font-size: 12px;
	transition-duration: 0.2s;
	cursor: pointer;
	border-radius: 20px;
}

button:hover {
	background-color: rgb(166, 185, 240);
	border: 1px solid;
	color: rgb(19, 18, 18);
}
h5{
    font-family: Georgia, 'Times New Roman', Times, serif;
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
	
	<%
	if(session.getAttribute("bal")!=null){ %>
		<script>
			alert("Insufficient Account Balance!!");
		</script>
	<% }session.removeAttribute("bal"); %>
	
	<%
	if(session.getAttribute("s")!=null){ %>
		<script>
			alert("Something Went Wrong Try Again!!");
		</script>
	<% }session.removeAttribute("s"); %>
	
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>
    -->

    <nav class="navbar ">
        <div class="container">
          <a class="navbar-brand" href="#">
            <img src="./assets/BankLogo.jpg" alt="" width="40" height="35">Country Bank
          </a>  
          <a href="LogoutController"><button style="padding: 10px;"><h5>LOGOUT</h5></button></a>
 
        </div>

    </nav>

    <div class="container text-center">
        <div class="row justify-content-evenly">
            <div class="col-4">
                <div class="card">
                    <img src="./assets/AccDetails.jpg" class="card-img-top" alt="..." width="0.3rem" >
                    <div class="card-body">
                      <h5 class="card-title">Account Details</h5>
                      <p class="card-text">See your account details </p>
                      <a href="Report.jsp" class="btn btn-primary">Account Report</a>
                    </div>
                  </div>
            </div>           
            <div class="container text-center">
                <div class="row justify-content-evenly">
                    <div class="col-4">
                        <div class="card">
                            <img src="./assets/Fund Transfer.jpg" class="card-img-top" alt="..." width="0.3rem" >
                            <div class="card-body">
                              <h5 class="card-title">Fund Transfer</h5>
                              <p class="card-text">Transfer funds to your friends, family, colleagues just within seconds</p>
                              <a href="FundController" class="btn btn-primary">Fund Transfer</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container text-center">
                <div class="row justify-content-evenly">
                    <div class="col-4">
                        <div class="card">
                            <img src="./assets/Recharge.jpg" class="card-img-top" alt="..." width="0.3rem" >
                            <div class="card-body">
                              <h5 class="card-title">Recharge</h5>
                              <p class="card-text">Get your recharge done within a blink of an eye</p>
                              <a href="Recharge.jsp" class="btn btn-primary">Recharge</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>

</body>
</html>