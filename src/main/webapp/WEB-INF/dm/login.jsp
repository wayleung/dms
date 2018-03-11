<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ include file="taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%@ include file="res-head.jsp"%>
<%-- <jsp:include page="res-head.jsp"></jsp:include> --%>
<title>学生宿舍管理系统-登录</title>
<script>
	function updateCode(value) {
		//单击图片，重新获得src，random作用？      
		value.src = "checkCode.do?" + Math.random();
	}
</script>
</head>
<body class="app flex-row align-items-center">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card-group mb-0">
					<div class="card p-2">
						<div class="card-block">
							<h1>学生宿舍管理系统</h1>
							<p class="text-muted">请登录您的账号</p>
							<form action="adminLogin.do" method="post">
								<div class="input-group mb-1">
									<span class="input-group-addon"><i class="icon-user"></i>
									</span> <input type="text" class="form-control" name="admin_account"
										placeholder="请输入账号">
								</div>
								<div class="input-group mb-2">
									<span class="input-group-addon"><i class="icon-lock"></i>
									</span> <input type="text" class="form-control" name="admin_password"
										placeholder="请输入密码">
								</div>

								<div class="input-group mb-2">
									<span class="input-group-addon"><i class="icon-lock"></i>
									</span> <input type="text" class="form-control"
										name="randomcode_client" placeholder="请输入验证码"> <img
										src="checkCode.do" onclick="updateCode(this)" />
								</div>
								<p style="color: red;">${requestScope.LoginMsg}</p>
								<div class="row">
									<div class="col-6">
										<input type="submit" class="btn btn-primary px-2" value="登录">
									</div>
									<div class="col-6 text-right">
										<button type="button" class="btn btn-link px-0">忘记密码?</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					 <div class="card card-inverse card-primary py-3 hidden-md-down" style="width:44%">
                        <div class="card-block text-center">
                            <div>
                            	<h2>欢迎使用</h2>
                                <h2>学生宿舍管理系统管理员端</h2>   
                            </div>
                        </div>
                    </div> -->
				</div>
			</div>
		</div>
	</div>
	<%-- 	<jsp:include page="res-foot.jsp"></jsp:include> --%>
	<%@ include file="res-foot.jsp"%>


</body>

</html>