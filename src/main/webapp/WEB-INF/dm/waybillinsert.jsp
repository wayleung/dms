<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>



<title>运单管理系统</title>
<%@ include file="res-head.jsp"%>




</head>



<body
	class="app header-fixed sidebar-fixed aside-menu-fixed aside-menu-hidden">

	<jsp:include page="headbar.jsp"></jsp:include>
	<jsp:include page="sidebar.jsp"></jsp:include>

	<!-- Main content -->
	<main class="main"> <!-- Breadcrumb -->
	<ol class="breadcrumb">
		<li class="breadcrumb-item">运单管理系统</li>
		<!--                 <li class="breadcrumb-item"><a href="#">Admin</a>
                </li> -->
		<li class="breadcrumb-item active">运单录入</li>

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
			<div class="card">
				<div class="card-header">
					<strong>运单录入</strong>
				</div>
				<p style="color: red;">${requestScope.add_message}</p>
				<div class="card-block">
					<form action="addWaybill.do" method="post"
						class="form-horizontal ">

						<div class="form-group row">
							<label for="text-input" style="margin-left: 30px;">运单号码</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="waybillNumber"
									class="form-control" placeholder="请输入运单号码">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>


							<label for="text-input" style="margin-left: 30px;">揽件人</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="pickedupBy"
									class="form-control" placeholder="请输入揽件人">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>
							
														<label for="text-input" style="margin-left: 30px;">总费用</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="totalCharge"
									class="form-control" placeholder="请输入总费用">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>

						</div>
						
							<div class="form-group row">
							<label for="text-input" style="margin-left: 30px;">收件人</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="toName"
									class="form-control" placeholder="请输入收件人">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>


							<label for="text-input" style="margin-left: 30px;">收件人地址</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="toAddress"
									class="form-control" placeholder="请输入收件人地址">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>
							

							<label for="text-input" style="margin-left: 30px;">收件人电话</label>
							<div class="col-md-2">
								<input type="text" id="text-input" name="toPhone"
									class="form-control" placeholder="请输入收件人电话">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>

						</div>
						<div class="form-group row">
						
													<label for="text-input" style="margin-left: 30px;">目的地</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="destination"
									class="form-control" placeholder="请输入目的地">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>
						
<!-- 												<div class="form-group row">
							<label for="text-input" style="margin-left: 30px;">货物状态</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="status"
									class="form-control" placeholder="请输入货物状态">
								<span class="help-block">This is a help text</span>
							</div>


							<label for="text-input" style="margin-left: 30px;">现在位置</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="locationNow"
									class="form-control" placeholder="请输入现在位置">
								<span class="help-block">This is a help text</span>
							</div>
							
														<label for="text-input" style="margin-left: 30px;">到达位置时间</label>
							<div class="col-md-2">
								<input type="text" id="text-input" name="lacationTime"
									class="form-control" placeholder="请输入到达位置时间">
								<span class="help-block">This is a help text</span>
							</div>

						</div>
						
												<div class="form-group row">
							<label for="text-input" style="margin-left: 30px;">接手负责人员</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="employeeCharge"
									class="form-control" placeholder="请输入接手负责人员">
								<span class="help-block">This is a help text</span>
							</div>
 -->

							<label for="text-input" style="margin-left: 30px;">寄件人</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="fromName"
									class="form-control" placeholder="请输入寄件人">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>
							
														<label for="text-input" style="margin-left: 30px;">寄件人地址</label>
							<div class="col-md-2">
								<input type="text" id="text-input" name="fromAddress"
									class="form-control" placeholder="请输入寄件人地址">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>

						</div>
						
												<div class="form-group row">
							<label for="text-input" style="margin-left: 30px;">寄件人电话</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="fromPhone"
									class="form-control" placeholder="请输入寄件人电话">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>


							<label for="text-input" style="margin-left: 30px;">寄件时间</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="sendDate"
									class="form-control" placeholder="请输入寄件时间"  onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>
							
														<label for="text-input" style="margin-left: 30px;">始发地</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="departure"
									class="form-control" placeholder="请输入始发地">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>

						</div>
						
					
						
												<div class="form-group row">
							<!-- <label for="text-input" style="margin-left: 30px;">收件时间</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="receiveDate"
									class="form-control" placeholder="请输入收件时间"  onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
								<span class="help-block">This is a help text</span>
							</div> -->


							
							


							<div class="col-md-2">
								<input type="submit" class="btn btn-sm btn-primary" value="保存">
								<input type="button" class="btn btn-sm btn-danger" value="重置">

							</div>
						</div>
						

					</form>

				</div>

			</div>



			

		</div>

	</div>
	<!-- /.conainer-fluid --> </main>

	<jsp:include page="asidemenu.jsp"></jsp:include>


	</div>

	<jsp:include page="footer.jsp"></jsp:include>


<%@ include file="res-foot.jsp"%>

	<script src="admin/layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  var start = {
    min: laydate.now()
    ,max: '2099-06-16 23:59:59'
    ,istoday: false
    ,choose: function(datas){
      end.min = datas; //开始日选好后，重置结束日的最小日期
      end.start = datas //将结束日的初始值设定为开始日
    }
  };
  
  var end = {
    min: laydate.now()
    ,max: '2099-06-16 23:59:59'
    ,istoday: false
    ,choose: function(datas){
      start.max = datas; //结束日选好后，重置开始日的最大日期
    }
  };
  
  document.getElementById('LAY_demorange_s').onclick = function(){
    start.elem = this;
    laydate(start);
  }
  document.getElementById('LAY_demorange_e').onclick = function(){
    end.elem = this
    laydate(end);
  }
  
});



</script>
</body>

</html>