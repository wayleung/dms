<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>



<title>运单管理系统</title>


<%@ include file="res-head.jsp"%>


<script type="text/javascript">
function userinsert(){
//新增运单页面层
layer.open({
  type: 2,
  skin: 'layui-layer-rim', //加上边框
  area: ['800px', '600px'], //宽高
  title:'新增运单',
  content: 'userinsert.jsp'
});
}

function userimport(){
//导入运单页面层
layer.open({
  type: 2,
  skin: 'layui-layer-rim', //加上边框
  area: ['600px', '250px'], //宽高
  title:'导入运单',
  content: 'userimport.jsp'
});
}


function userexport(){
var checekboxs="";
var size = 0;
$("input[class='checkbox_single']:checkbox:checked").each(function(){ 
checekboxs+=$(this).val()+"," 
size++;
}) 




//运单导出
layer.confirm('查询结果有'+size+'条记录，是否确定导出', {
  title:'信息确认',
  btn: ['确定','取消'] //按钮
}, function(){
  			$.ajax({
				type : "post",//数据发送的方式（post 或者 get）
				url : "exportUsers.do",//要发送的后台地址
				data : {
					'userids':checekboxs,
				},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
				async : true,
				success : function(data) {//ajax请求成功后触发的方法
					
						layer.msg('导出成功', {
							icon : 1
						});
						setTimeout("location.reload()",1300);
					

					;
				},
				error : function(msg) {//ajax请求失败后触发的方法
					alert(msg);//弹出错误信息
				}
			});
}, function(){

});
}


function waybillupdate(waybillNumber){
//编辑更新运单页面层
layer.open({
  type: 2,
  skin: 'layui-layer-rim', //加上边框
  area: ['800px', '400px'], //宽高
  title:'更新运单信息',
  content: 'waybillupdate.do?waybillNumber='+waybillNumber
});
}
function waybillstatusinsert(waybillNumber){
	//新增物流状态页面层
	layer.open({
	  type: 2,
	  skin: 'layui-layer-rim', //加上边框
	  area: ['800px', '400px'], //宽高
	  title:'新增运单状态信息',
	  content: 'waybillstatusinsert.do?waybillNumber='+waybillNumber
	});
	}



function waybillstatusshow(waybillNumber){
	//编辑更新运单页面层
	layer.open({
	  type: 2,
	  skin: 'layui-layer-rim', //加上边框
	  area: ['800px', '400px'], //宽高
	  title:'运单状态信息',
	  content: 'showWaybillStatus.do?waybill_number='+waybillNumber
	});
	}


function waybilldelete(waybillNumber){
//运单删除
layer.confirm('是否确定删除', {
  title:'信息确认',
  btn: ['确定','取消'] //按钮
}, function(){
  			$.ajax({
				type : "get",//数据发送的方式（post 或者 get）
				url : "deleteWaybill.do?waybill_number="+waybillNumber,//要发送的后台地址
				data : {
				},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
				async : true,
				success : function(data) {//ajax请求成功后触发的方法
					
						layer.msg('删除成功', {
							icon : 1
						});
						setTimeout("location.reload()",1300);
					

					;
				},
				error : function(msg) {//ajax请求失败后触发的方法
					alert(msg);//弹出错误信息
				}
			});
}, function(){
/*   layer.msg('取消后的操作', {
    time: 20000, //20s后自动关闭
    btn: ['明白了', '知道了']
  }); */
});
}


function userdeletealot(){
var checekboxs="";
var size = 0;
$("input[class='checkbox_single']:checkbox:checked").each(function(){ 
checekboxs+=$(this).val()+"," 
size++;
}) 



//运单删除
layer.confirm('是否确定删除'+size+'条记录', {
  title:'信息确认',
  btn: ['确定','取消'] //按钮
}, function(){
  			$.ajax({
				type : "post",//数据发送的方式（post 或者 get）
				url : "deleteUserAlot.do",//要发送的后台地址
				data : {
					'userids':checekboxs,
				},//要发送的数据（参数）格式为{'val1':"1","val2":"2"}
				async : true,
				success : function(data) {//ajax请求成功后触发的方法
					
						layer.msg('删除成功', {
							icon : 1
						});
						setTimeout("location.reload()",1300);
					

					;
				},
				error : function(msg) {//ajax请求失败后触发的方法
					alert(msg);//弹出错误信息
				}
			});
}, function(){
/*   layer.msg('取消后的操作', {
    time: 20000, //20s后自动关闭
    btn: ['明白了', '知道了']
  }); */
});
}




//反选 
function selectall(){ 
$("input.checkbox_single").each(function(){ 
if($(this).attr("checked")) 
{ 
$(this).removeAttr("checked"); 
} 
else 
{ 
$(this).attr("checked","true"); 
} 
}) 
}





//考试记录
function usertestRecord(user_id){
//编辑更新运单页面层
layer.open({
  type: 2,
  skin: 'layui-layer-rim', //加上边框
  area: ['830px', '600px'], //宽高
  title:'用户评估',
  content: 'usertestRecord.do?userid='+user_id
});
}




</script>
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
		<li class="breadcrumb-item active">运单查询/修改</li>

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
					<strong>查询</strong>
				</div>
				<div class="card-block">
					<form action="showWaybill.do" method="post"
						class="form-horizontal ">

						<div class="form-group row">
							<label for="text-input" style="margin-left: 30px;">运单号码</label>
							<div class="col-md-3">
								<input type="text" id="text-input" name="waybill_number"
									class="form-control" placeholder="请输入运单号码">
								<!-- <span class="help-block">This is a help text</span> -->
							</div>



							<!-- 			<label for="select" style="margin-left: 30px;">所在部门</label>
							<div class="col-md-2">
								<select id="select" name="dept" class="form-control">
									<option >请选择</option>
									<option value="人事部">人事部</option>
									<option value="秘书部">秘书部</option>
									<option value="公关部">公关部</option>
									<option value="市场部">市场部</option>
								</select>
							</div>
							
							
							<label for="select" style="margin-left: 30px;">运单状态</label>
							<div class="col-md-2">
								<select id="select" name="user_status" class="form-control">
									<option >请选择</option>
									<option value="锁定">锁定</option>
									<option value="挂起">挂起</option>
									<option value="激活">激活</option>
								</select>
							</div>
						</div>




						<div class="form-group row">
							<label for="text-input" style="margin-left: 30px;">创建时间</label>
							<div class="col-md-2">
								<input type="text" id="text-input" name="begin_time"
									class="form-control" placeholder="开始时间"  onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
								<span class="help-block">This is a help text</span>
							</div>
							<label for="select">-</label>
							<div class="col-md-2">
								<input type="text" id="text-input" name="end_time"
									class="form-control" placeholder="结束时间"  onclick="layui.laydate({elem: this, istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
								<span class="help-block">This is a help text</span>
							</div> -->


							<div class="col-md-2">
								<input type="submit" class="btn btn-sm btn-primary" value="查询">
								<input type="button" class="btn btn-sm btn-danger" value="重置">

							</div>
						</div>

					</form>

				</div>

			</div>



			<div class="card">
				<div class="card-header">
					<i class="fa fa-align-justify"></i>运单信息
					<div style="float: right;">
						<!-- <a href="#" onclick="userinsert()"><span
							class="btn btn-sm btn-primary">新增</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" onclick="userimport()"><span
							class="btn btn-sm btn-success">导入</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#" onclick="userdeletealot()"><span
							class="btn btn-sm btn-danger">批量删除</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="exportUsers.do"><span class="btn btn-sm btn-info">导出当前页</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="exportAllUsers.do"><span class="btn btn-sm btn-info">导出全部记录</span></a> -->
					</div>
				</div>
				<div class="card-block">
				<p style="color: red;">${requestScope.delete_message}</p>
					<table class="table">
						<thead>
							<tr>
								<!-- <th><input type="checkbox" onchange="selectall()"></th> -->
								<th>运单号码</th>
								<th>揽件人</th>
								<th>总费用</th>
								<th>寄件人</th>
								<th>寄件人地址</th>
								<th>寄件人电话</th>
								<th>寄件时间</th>
								<th>始发地</th>
								<th>收件人</th>
								<th>收件人地址</th>
								<th>收件人电话</th>
<!-- 								<th>收件时间</th>	 -->
								<th>目的地</th>
<!-- 								<th>货物状态</th>
								<th>现在位置</th>
								<th>到达位置时间</th>
								<th>接手负责人员</th>	 -->
								<th><b>运单管理</b></th>
								
							</tr>
						</thead>
						<c:if test="${!empty waybill}">
							<tbody>

<%-- 							<c:forEach var="user" items="${users}"> --%>
								<tr>
									<%-- <td><input type="checkbox" value="${user.userId}" name="checkbox_${user.userId}" class="checkbox_single" ></td> --%>
									<td>${waybill.waybillNumber}</td>
									<td>${waybill.pickedupBy}</td>
									<td>${waybill.totalCharge}</td>
									<td>${waybill.fromName}</td>
									<td>${waybill.fromAddress}</td>
									<td>${waybill.fromPhone}</td>
									<td>${waybill.sendDate}</td>
									<td>${waybill.departure}</td>
									<td>${waybill.toName}</td>
									<td>${waybill.toAddress}</td>
									<td>${waybill.toPhone}</td>
<%-- 									<td>${waybill.receiveDate}</td> --%>
									<td>${waybill.destination}</td>			
<%-- 									<td>${waybill.status}</td>
									<td>${waybill.locationNow}</td>
									<td>${waybill.lacationTime}</td>
									<td>${waybill.employeeCharge}</td> --%>
									<td><a href="#" onclick="waybillstatusshow(${waybill.waybillNumber})"><span
											class="btn btn-sm btn-success">物流状态</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
<%-- 											<a href="#" onclick="waybillupdate(${waybill.waybillNumber})"><span
											class="btn btn-sm btn-primary">更新</span></a>&nbsp;&nbsp;&nbsp;&nbsp; --%>
											<a href="#" onclick="waybillstatusinsert(${waybill.waybillNumber})"><span
											class="btn btn-sm btn-primary">新增物流状态</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="#" onclick="waybilldelete(${waybill.waybillNumber})"><span
											class="btn btn-sm btn-danger">删除</span></a>&nbsp;&nbsp;&nbsp;&nbsp;
								</tr>
<%-- 							</c:forEach> --%>



						</tbody>
						</c:if>
						
					</table>
					<%-- ${fn:length(users)<=0} 判断list长度是否小于0 要引入fn标签 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> --%>
					<c:if test="${empty waybill}">
						<div
							style="margin-top: 50px; margin-bottom: 50px; text-align: center;">
							<h3>该条件没有查询到结果</h3>
						</div>
					</c:if>
					<%-- <ul class="pagination">
										<c:choose>
										<c:when test="${pageInfo.hasPreviousPage}">
											<li class="page-item"><a class="page-link" href="queryUserByAdminID.do?pageNum=1">首页</a>
											</li>
											<li class="page-item"><a class="page-link" href="queryUserByAdminID.do?pageNum=${pageInfo.prePage }">上一页</a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link" >首页</a>
											</li>
											<li class="page-item"><a class="page-link" >上一页</a>
											</li>
										</c:otherwise>
										</c:choose>
											<li class="page-item"><a class="page-link">${pageInfo.pageNum }/${pageInfo.pages}</a>
											</li>
										<c:choose>
										<c:when test="${pageInfo.hasNextPage}">
											<li class="page-item"><a class="page-link" href="queryUserByAdminID.do?pageNum=${pageInfo.nextPage }">下一页</a>
											</li>
											<li class="page-item"><a class="page-link" href="queryUserByAdminID.do?pageNum=${pageInfo.pages }">尾页</a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a class="page-link" >下一页</a>
											</li>
											<li class="page-item"><a class="page-link" >尾页</a>
											</li>
										</c:otherwise>
										</c:choose>
										

									</ul> --%>
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