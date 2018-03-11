<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<body>
<h2>运单查询</h2>
<table>
	<thead>
		<tr>
	        <th>运单号</th>
	        <th>寄件人</th>
	        <th>始发地</th>
	        <th>收件人</th>
	        <th>目的地</th>
	    </tr>
	</thead>
	<tbody>
		<tr>
            <td>${waybill.waybillNumber}</td>
            <td>${waybill.fromName}</td>
            <td>${waybill.departure}</td>
            <td>${waybill.toName}</td>
            <td>${waybill.destination}</td>
        </tr>
        <%--     <c:forEach var="waybill" items="${waybills}">
        <tr>
            <td>${waybill.waybillNumber}</td>
            <td>${waybill.fromName}</td>
            <td>${waybill.departure}</td>
            <td>${waybill.toName}</td>
            <td>${waybill.destination}</td>
        </tr>
    </c:forEach> --%>
	</tbody>
</table>
</body>
</html>
