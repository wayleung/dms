<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%> 
<%@ include file="taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>学生宿舍管理系统</title>
<%@ include file="res-head.jsp"%>
</head>

<body class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">

	<jsp:include page="headbar.jsp"></jsp:include>
	<jsp:include page="sidebar.jsp"></jsp:include>

        <!-- Main content -->
        <main class="main">

            <!-- Breadcrumb -->
            <ol class="breadcrumb">
                <li class="breadcrumb-item">学生宿舍管理系统管理员端</li>
<!--                 <li class="breadcrumb-item"><a href="#">Admin</a>
                </li> -->
                <li class="breadcrumb-item active">首页</li>

                <!-- Breadcrumb Menu-->
<!--                 <li class="breadcrumb-menu hidden-md-down">
                    <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                        <a class="btn btn-secondary" href="#"><i class="icon-speech"></i></a>
                        <a class="btn btn-secondary" href="./"><i class="icon-graph"></i> &nbsp;Dashboard</a>
                        <a class="btn btn-secondary" href="#"><i class="icon-settings"></i> &nbsp;Settings</a>
                    </div>
                </li> -->
                
                
            </ol>


            <div class="container-fluid">
                <div class="animated fadeIn">
								<div class="jumbotron">
				<h1>你好, ${admin.adminName}! </h1>
				<h1>欢迎使用学生宿舍管理系统管理员端</h1>
				
				<!-- <p>
					<a class="btn btn-primary btn-lg" href="personal.jsp" role="button">进入个人中心</a>
				</p> -->
			</div>


		


                </div>

            </div>
            <!-- /.conainer-fluid -->
        </main>

        <jsp:include page="asidemenu.jsp"></jsp:include>


    </div>

	<jsp:include page="footer.jsp"></jsp:include>

	<%@ include file="res-foot.jsp"%>
</body>

</html>