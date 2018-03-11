<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%> 

    
    
    <header class="app-header navbar">
        <button class="navbar-toggler mobile-sidebar-toggler hidden-lg-up" type="button">☰</button>
        <a class="navbar-brand" href="#"></a>
         <ul class="nav navbar-nav hidden-md-down">
            <li class="nav-item">
                <a class="nav-link navbar-toggler sidebar-toggler" href="#">☰</a>
            </li>


<!--             <li class="nav-item px-1">
                <a class="nav-link" href="setting.jsp">用户设置</a>
            </li> -->
        </ul> 

        <ul class="nav navbar-nav ml-auto">
<!-- 		<li class="nav-item dropdown hidden-md-down">
                <a class="nav-link nav-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <i class="icon-bell"></i>
                    <span class="badge badge-pill badge-danger">10</span>
                </a>
                

                
                <div class="dropdown-menu dropdown-menu-right">

                    <div class="dropdown-header text-center">
                        <strong>111</strong>
                    </div>

                    <a class="dropdown-item" href="#"><i class="fa fa-bell-o"></i> Updates<span class="badge badge-info">42</span></a>
                    <a class="dropdown-item" href="#"><i class="fa fa-envelope-o"></i> Messages<span class="badge badge-success">42</span></a>
                    <a class="dropdown-item" href="#"><i class="fa fa-tasks"></i> Tasks<span class="badge badge-danger">42</span></a>
                    <a class="dropdown-item" href="#"><i class="fa fa-comments"></i> Comments<span class="badge badge-warning">42</span></a>

                    <div class="dropdown-header text-center">
                        <strong>22</strong>
                    </div>

                   
                </div>




            </li>
             <li class="nav-item hidden-md-down">
                <a class="nav-link" href="#"><i class="icon-list"></i></a>
            </li>
            <li class="nav-item hidden-md-down">
                <a class="nav-link" href="#"><i class="icon-location-pin"></i></a>
            </li> -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle nav-link" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <%-- <img height="45" width="45" src="${admin.photoUrl==null?'admin_photo/user.png':admin.photoUrl}" class="img-avatar"> --%>
                    <span class="hidden-md-down">${admin.adminName}</span>
                </a>
                <div class="dropdown-menu dropdown-menu-right">

                    <div class="dropdown-header text-center">
                        <strong>账户</strong>
                    </div>

                    <a class="dropdown-item" href="#"><i class="fa fa-bell-o"></i> Updates<span class="badge badge-info">42</span></a>
                    <a class="dropdown-item" href="#"><i class="fa fa-envelope-o"></i> Messages<span class="badge badge-success">42</span></a>
                    <a class="dropdown-item" href="#"><i class="fa fa-tasks"></i> Tasks<span class="badge badge-danger">42</span></a>
                    <a class="dropdown-item" href="#"><i class="fa fa-comments"></i> Comments<span class="badge badge-warning">42</span></a>

                    <div class="dropdown-header text-center">
                        <strong>设置</strong>
                    </div>

                    <a class="dropdown-item" href="personal.jsp"><i class="fa fa-user"></i>个人中心</a>
<!--                     <a class="dropdown-item" href="#"><i class="fa fa-wrench"></i> Settings</a>
                    <a class="dropdown-item" href="#"><i class="fa fa-usd"></i> Payments<span class="badge badge-default">42</span></a>
                    <a class="dropdown-item" href="#"><i class="fa fa-file"></i> Projects<span class="badge badge-primary">42</span></a>
                    <div class="divider"></div>
                    <a class="dropdown-item" href="#"><i class="fa fa-shield"></i> Lock Account</a> -->
                    <a class="dropdown-item" href="adminLogout.do"><i class="fa fa-lock"></i>登出</a>
                </div>
            </li>
<!--             <li class="nav-item hidden-md-down">
                <a class="nav-link navbar-toggler aside-menu-toggler" href="#">☰</a>
            </li> -->

        </ul>
    </header>
    
    
   