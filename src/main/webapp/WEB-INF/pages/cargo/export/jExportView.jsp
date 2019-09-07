<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
</head>
<body>
<form method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="back"><a href="list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		浏览出口报运信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle">合同号：</td>
	            <td class="tableContent">${obj.customerContract}</td>
	            <td class="columnTitle">信用证号：</td>
	            <td class="tableContent">${obj.lcno}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">收货人及地址：</td>
	            <td class="tableContent">${obj.consignee}</td>
	            <td class="columnTitle">装运港：</td>
	           <td class="tableContent">${obj.shipmentPort}</td>
	        </tr>
	          <tr>
	            <td class="columnTitle">目的港：</td>
	            <td class="tableContent">${obj.destinationPort}</td>
	            <td class="columnTitle">运输方式：</td>
	           <td class="tableContent">${obj.transportMode}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">价格条件：</td>
	            <td class="tableContent">${obj.priceCondition}</td>
	            <td class="columnTitle">状态：</td>
	           <td class="tableContent">${obj.state}</td>
	        </tr>
	        
		</table>
	</div>
</div>
 
 


 
</div>
</form>
</body>
</html>

