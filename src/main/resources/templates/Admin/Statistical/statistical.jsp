<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin | QuanLyThongKe</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
	integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="../Admin/assets/Themes/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="../Admin/assets/Themes/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="../Admin/assets/Themes/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../Admin/assets/Themes/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="../Admin/assets/Themes/dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- Google Font -->

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">

		<header class="main-header">
			<!-- Logo -->
			<a href="../index.jsp" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<n class="logo-mini">DIAMOND <b>CAFE</b></n> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg">DIAMOND <b>CAFE</b></span>
			</a>
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>

				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<!--User Account -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <img
								src="../Themes/dist/img/user2-160x160.jpg" class="user-image"
								alt="User Image"> <span class="hidden-xs">USER</span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><img
									src="../Themes/dist/img/user2-160x160.jpg" class="img-circle"
									alt="User Image"></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">Tài khoản</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">Đăng xuất</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</nav>
		</header>

		<!-- =============================================== -->
		<!-- Left side column. contains the sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->


				<!-- search form -->


				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu" data-widget="tree">
					<li class="treeview active">
						<ul class="treeview-menu">
							<li><a href="../index.jsp"> <i class="fa-solid fa-house"></i>&nbsp;&nbsp;&nbsp;&nbsp;<span>Trang
										chủ</span>
							</a></li>
							<li><a href="../Dish/dish.jsp"><span
									class="material-symbols-outlined"> fastfood </span> Quản lý món</a></li>
							<li><a href="../Category/category.jsp"><span
									class="material-symbols-outlined"> food_bank </span> Quản lý
									Loại món</a></li>
							<li><a href="../Customer/customer.jsp"><i
									class="fa-solid fa-user"></i>&nbsp;&nbsp;&nbsp;&nbsp; Quản lý
									Khách hàng </a></li>
							<li><a href="../Employee/employee.jsp"><i
									class="fa-solid fa-users"></i>&nbsp;&nbsp;&nbsp; Quản lý Nhân
									Viên</a></li>
							<li><a href="../Statistical/statistical.jsp"><i
									class="fa fa-line-chart"></i>&nbsp; Thống kê Doanh thu</a></li>
						</ul>
					</li>
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>




		<!-- =============================================== -->
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Quản lý Thống kế</h1>

			</section>

			<!-- Main content -->
			<section class="content">
				<div>
					<div>
						<div>
							<a href="Sumday.jsp" class="btn btn-warning"> Theo ngày </a>
							<a href="Summonth.jsp" class="btn btn-warning"> Theo tháng </a>
							<a href="Sumquarter.jsp" class="btn btn-warning"> Theo năm </a>
						</div>
					</div>
				</div>
				</div>
		</div>

		</section>

		<!-- /.content -->
	</div>

	<!-- /.content-wrapper -->
	<!-- Control Sidebar -->

	</div>




</body>
</html>
