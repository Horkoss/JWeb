<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login | E-Shopper</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <link rel="stylesheet" href="javascript/validation/css/validationEngine.jquery.css" type="text/css"/> 
    <script src="javascript/validation/jquery.js" type="text/javascript" type="text/javascript"></script> 
    <script src="javascript/validation/jquery-1.8.2.min.js" type="text/javascript"></script> 
    <script src="javascript/validation/jquery.validationEngine.js" type="text/javascript"></script> 
    <script src="javascript/validation/languages/jquery.validationEngine-fr.js" type="text/javascript"></script>
</head><!--/head-->

<body>
	<%@include file="topBar.jsp" %> 
	<section id="form"><!--form-->
		<div class="container">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form"><!--login form-->
						<h2>Login to your account</h2>
						<form action="Login" method="POST" id="form_1" name="form_1">
							<input type="text" placeholder="E-mail" name="email" id="email" />
							<input type="password" placeholder="Password" name="password" id="password" />
							<button type="submit" class="btn btn-default">Login</button>
						</form>
					</div><!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OR</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form"><!--sign up form-->
						<h2>New User Signup!</h2>
							<form action="Signup" method="POST" id="form_2" name="form_2">
								<input type="text" name="first_name" id="first_name" class="validate[required] text-input" placeholder="First Name" />
								<input type="text" name="last_name" id="last_name" class="validate[required] text-input" placeholder="Last Name"/>
								<input type="text" name="email" id="email" class="validate[custom[email]] text-input" placeholder="E-mail"/>
							    <input type="text" name="username" id="username" class="validate[required] text-input" placeholder="Username"/>
								<input type="password" name="password" id="password" class = "validate[required,minSize[6],maxSize[50]]" placeholder="Password"/>
								<input type="password" name="password" id="password" class = "validate[required,equals[password]]" placeholder="Confirm Password"/>
								<button type="submit" class="btn btn-default">Sign Up</button>
					</div><!--/sign up form-->
				</div>
			</div>
		</div>
	</section><!--/form-->
	
	<script type="text/javascript"> 
		$(document).ready(function() { 
			$("#form_1").validationEngine();
			$("#form_2").validationEngine();
		}); 
	</script>
    <script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>