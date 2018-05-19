<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
        xmlns:h="http://java.sun.com/jsf/html"
        xmlns:f="http://java.sun.com/jsf/core"
        xmlns:ui="http://java.sun.com/jsf/facelets">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>CAMS</title>
    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/fontawesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default-theme.css"/>   
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/toastr/toastr.min.css"/>
	
	<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/toastr/toastr.min.js"></script>
    <script>
	    jQuery(document).ready(function() {
	    	$(".loader").fadeOut("slow");
	    	document.getElementById("LoginForm:ID_USERNAME").focus();
	    	document.getElementById("LoginForm:ID_PASSWORD").focus();
		});
	</script>
</head>
<body>
	<div class="hero-fullbody"></div>
	<div  class=" template-card">
		<header class="hero overlay">
		    <nav class="front-navbar">
			    <div class="container">
			        <div class="navbar-header">
			            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
			                <span class="sr-only">Toggle navigation</span>
			                <span class="fa fa-bars"></span></button>
			            	<a href="login.html" class="brand">
			            		<img src="${pageContext.request.contextPath}/resources/images/logo_white.png"/>
			            	</a>
			        </div>
			    </div>
			</nav>
		    <div class="masthead">
			  	<section class="card-section">
			  		<div class="container">
			      		<div class="col-lg-8 col-lg-offset-2">
			          		<div class="card text-center">
			              		<header class="text-center">
			                  		<h2 class="section-title">SignIn</h2>
			              		</header>
				              	<form id="LoginForm" method="POST">
			                  		<div class="row">
			                      		<div class="col-md-6">
				                      		<input type="text" id="ID_USERNAME" name="LOGIN_USER_NAME" placeholder="Username" class="search-field"/>
				                     	</div>
				                      	<div class="col-md-6"> 
				                      		<input type="password" id="ID_PASSWORD" name="LOGIN_PASSWORD" placeholder="password" class="search-field"/>
				                      	</div>
				                  	</div>
				                  	<div class="row">
				                      	<div class="col-md-12">
				                      		<input id="ID_LOGIN_BUTTON" type="submit" class="btn btn-primary" value="Log In" onclick="javascript:fnLogin();">
                        					<p class="forget-pass"><a href="">Forgot your password?</a> </p>
			                      		</div>
				                  	</div>
				              	</form>
			          		</div>
			      		</div>
				 	</div>
				</section>
		    </div>
		</header>
	</div>
	<script type="text/javascript">
		function fnLogin(){
			document.getElementById("LoginForm").action="userLogin.html";
			document.getElementById("LoginForm").sumbit();
		}
	</script>
</body>
</html>