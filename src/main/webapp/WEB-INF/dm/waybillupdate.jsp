<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>


    <title>运单管理系统</title>
<%@ include file="res-head.jsp"%>


	</head>



<body>

						<div class="card">
						<form action="updateWaybill.do" method="post" 
										class="form-horizontal">
<!-- 								<div class="card-header">
									<strong>新增考生</strong>
								</div> -->
								<div class="card-block">
										<input type="hidden" name="waybillNumber" value="<%=request.getParameter("waybillNumber")%>" >
										<div class="form-group row">
											<label class="col-md-3 form-control-label" for="text-input">用户id</label>
											<div class="col-md-9">
												
												<input type="text" id="text-input" name="userId"
													class="form-control" placeholder="用户id">
												<!-- <span class="help-block">This is a help text</span> -->
											</div>
										</div>
<!-- 										
																				<div class="form-group row">
											<label class="col-md-3 form-control-label" for="text-input">货物状态</label>
											<div class="col-md-9">
												<input type="text" id="text-input" name="status"
													class="form-control" placeholder="货物状态">
												<span class="help-block">This is a help text</span>
											</div>
										</div>
										

										<div class="form-group row">
											<label class="col-md-3 form-control-label" for="text-input">现在位置</label>
											<div class="col-md-9">
												<input type="text" id="text-input" name="locationNow"
													class="form-control" placeholder="现在位置">
												<span class="help-block">This is a help text</span>
											</div>
										</div>





										<div class="form-group row">
											<label class="col-md-3 form-control-label" for="text-input">到达位置时间</label>
											<div class="col-md-9">
												<input type="text" id="text-input" name="lacationTime"
													class="form-control" placeholder="到达位置时间">
												<span class="help-block">This is a help text</span>
											</div>
										</div>

										<div class="form-group row">
											<label class="col-md-3 form-control-label" for="text-input">接手负责员工</label>
											<div class="col-md-9">
												<input type="text" id="text-input" name="employeeCharge"
													class="form-control" placeholder="接手负责员工">
												<span class="help-block">This is a help text</span>
											</div>
										</div> -->

										<p style="color: red;">${requestScope.update_message}</p>


									
								</div>
								<div class="card-footer">
									<input type="submit" class="btn btn-sm btn-primary" value="保存">
									<input type="button" class="btn btn-sm btn-danger" value="重置"><span style="color: red;">${requestScope.userUpdateMsg}</span>
								</div>
								</form>
							</div>

<%@ include file="res-foot.jsp"%>
</body>

</html>