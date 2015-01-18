<%@page import="java.util.List, java.util.ArrayList, models.UserInfo, models.UserInfoBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
     <!-- MORRIS CHART STYLES-->
   
        <!-- CUSTOM STYLES-->
    <link href="css/custom.css" rel="stylesheet" />
     <!-- GOOGLE FONTS-->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
     <!-- TABLE STYLES-->
    <link href="js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
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
font-size: 16px;"> <a href="Logout" class="btn btn-danger square-btn-adjust">Logout</a></div>
        </nav>   
           <!-- /. NAV TOP  -->
                <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                    <img src="images/find_user.png" class="user-image img-responsive"/>
					</li>
				
                      <li  >
                        <a class="active-menu"  href="table.jsp"><i class="fa fa-users fa-3x"></i> User Management</a>
                    </li>
                    <li  >
                        <a  href="form.jsp"><i class="fa fa-edit fa-3x"></i> News </a>
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
                    <!-- Advanced Tables -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>User Id</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Username</th>
                                            <th>Email</th>
                                            <th>Ban</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                       	 	UserInfoBean user = (UserInfoBean) request.getAttribute("userBean"); 
                                        	List<UserInfo> list = user.getUserList(); 
                                        	for (UserInfo user_info : list) { 
                                        		out.println("<tr><td>" + user_info.getId() + "</td><td>" + user_info.getFirst_name() + "</td><td>"
                                        		+ user_info.getLast_name() + "</td><td>" + user_info.getUsername() + "</td><td>"
                                        		+ user_info.getEmail() + "</td><td>" 
                                        		+ "<form action='UserList' method='POST'><input type='hidden' name='ban_value' id='hid_val' value='" 
                                        		+ user_info.getId() + "'/><input type='submit' name='delete' value='Ban' /></form></td><td>" 
                                        		+ "<form action='UserList' method='POST'><input type='hidden' name='delete_value' id='hid_val' value='" + user_info.getId() 
                                        		+ "'/><input type='submit' name='delete' value='Delete' /></form></td></tr>"); 
                                        	}
										%>
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
 
                    <!--  end  Context Classes  -->
	
            </div>
                <!-- /. ROW  -->
        </div>

    <!-- JQUERY SCRIPTS -->
    <script src="js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="js/bootstraps.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="js/dataTables/jquery.dataTables.js"></script>
    <script src="js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
         <!-- CUSTOM SCRIPTS -->
    <script src="js/custom.js"></script>
    
   
</body>
</html>
