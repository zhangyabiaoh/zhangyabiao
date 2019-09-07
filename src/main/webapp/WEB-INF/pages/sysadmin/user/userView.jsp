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
	            <td class="columnTitle">用户名称：</td>
	            <td class="tableContent">${obj.user_name}</td>
	            <td class="columnTitle">性别：</td>
	            <td class="tableContent">${obj.sex}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">联系电话：</td>
	            <td class="tableContent">${obj.phone}</td>
	            <td class="columnTitle">邮箱：</td>
	            <td class="tableContent">${obj.email}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">登录名：</td>
	            <td class="tableContent">${obj.login_name}</td>
	            <td class="columnTitle">职位：</td>
	            <td class="tableContent">${obj.position}</td>
	        </tr>
	        <tr>
	            <td class="columnTitle">所在部门：</td>
	            <td class="tableContent">${obj.deptname}</td>
	        </tr>
		</table>
		</div>
	</div>
</div>
</form>
</body>
</html>

