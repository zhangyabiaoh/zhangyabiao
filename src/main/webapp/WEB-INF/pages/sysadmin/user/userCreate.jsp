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
<li id="save"><a href="#" onclick="formSubmit('insert.action','_self');">确定</a></li>
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
		新增用户信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">用户名称：</td>
	            <td class="tableContent"><input type="text" name="user_name"/></td>
	            <td class="columnTitle_mustbe">性别：</td>
	            <td class="tableContent"><input type="text" name="sex"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">联系电话：</td>
	            <td class="tableContent"><input type="text" name="phone"/></td>
	            <td class="columnTitle_mustbe">邮箱：</td>
	            <td class="tableContent"><input type="text" name="email"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">登录名称：</td>
	            <td class="tableContent"><input type="text" name="login_name"/></td>
	            <td class="columnTitle_mustbe">登录密码：</td>
	            <td class="tableContent"><input type="text" name="login_password"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">职位：</td>
	            <td class="tableContent"><input type="text" name="position"/></td>
	            <td class="columnTitle_mustbe">所在部门：</td>
	            <td class="tableContent"><input type="text" name="deptname"/></td>
	        </tr>
	      <!--   <tr>
	            <td class="columnTitle_mustbe">备注：</td>
	            <td class="tableContent"><textarea name="cnote" style="height:120px;"></textarea></td>
	        </tr> -->
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

