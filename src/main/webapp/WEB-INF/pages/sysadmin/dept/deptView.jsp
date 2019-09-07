<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
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
		浏览生产厂家信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="5">
	        <tr>
	            <td class="columnTitle">部门名称：</td>
	            <td class="tableContent">${obj.deptname}</td>
	            <td class="columnTitle">部门主管：</td>
	            <td class="tableContent">${obj.deptmanager}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">部门位置：</td>
	            <td class="tableContent">${obj.deptaddress}</td>
	            <td class="columnTitle">部门介绍：</td>
	            <td class="tableContent">${obj.deptnote}</td>
	        </tr>
		</table>
		</div>
	</div>
</div>
</form>
</body>
</html>

