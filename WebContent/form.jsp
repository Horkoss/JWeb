<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin</title>
	<!-- BOOTSTRAP STYLES-->
    <link href="css/bootstrap.css" rel="stylesheet" />
     <!-- FONTAWESOME STYLES-->
    <link href="css/font-awesome.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
    <link href="css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="table.html">Admin</a> 
            </div>
  <div style="color: white;
padding: 15px 50px 5px 50px;
float: right;
font-size: 16px;"> <a href="Logout" class="btn btn-danger square-btn-adjust">Logout</a> </div>
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="images/find_user.png" class="user-image img-responsive"/>
					</li>
                      <li  >
                        <a  href="table.jsp"><i class="fa fa-users fa-3x"></i> User Management</a>
                    </li>
                    <li  >
                        <a class="active-menu"  href="form.jsp"><i class="fa fa-edit fa-3x"></i> News </a>
                    </li>				
                   <li  >
                        <a  href="newsLetters.jsp"><i class="fa fa-newspaper-o fa-3x"></i> Newsletters</a>
                    </li>
                </ul>
               
            </div>
            
        </nav>  
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">

               <div class="row">
                <div class="col-md-12">
                    <!-- Form Elements -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3>Redact a news</h3>
                                    <form role="form" action="News" method="POST">

                                        <div class="form-group">
                                            <label>Title</label>
                                            <input class="form-control" placeholder="Please Enter Title" id="title" name="title" />
                                        </div>

                                        <div class="form-group">
                                            <label>Message</label>
                                            <textarea class="form-control" rows="3" id="message" name="message"></textarea>
                                        </div>
										<input type="Submit" value="Publish" />
									</form>
</div></div>

                                 
    </div>

                </div>
            </div>
	
                <!-- /. ROW  -->
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="js/bootstraps.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="js/jquery.metisMenu.js"></script>
      <!-- CUSTOM SCRIPTS -->
    <script src="js/custom.js"></script>
    
   
</body>
</html>
