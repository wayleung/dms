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
								<div class="card-block">
										<div class="form-group row">
											<div class="col-md-9" style="margin-left: 10px;">
												<table>
													<c:forEach var="waybillstatus" items="${waybillstatusrtn}">
														<tr style="display:block;margin-top: 20px;margin-left: 10px;">
															<td>货物在${waybillstatus.locationName}${waybillstatus.statusName}</td><td>&nbsp;&nbsp;&nbsp;</td><td>${waybillstatus.lacationTime}</td><td>&nbsp;&nbsp;&nbsp;</td><td>经手人：${waybillstatus.eName}</td>
														</tr>
													</c:forEach>
												</table>
											</div>
										</div>
										<p style="color: red;">${requestScope.status_message}</p>
										<div style="height: 50px;"></div>	
								</div>

							</div>

<%@ include file="res-foot.jsp"%>
</body>

</html>