<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript" src="../../js/datepicker/WdatePicker.js"></script>
</head>
<body>
<form method="post">
	<input type="hidden" name="id" value="${obj.id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');">确定</a></li>
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
		修改购销合同信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">客户名称：</td>
	            <td class="tableContent"><input type="text" name="customer" value="${obj.customer}"/></td>
	            <td class="columnTitle_mustbe">收购方：</td>
	            <td class="tableContent"><input type="text" name="c_offer" value="${obj.c_offer}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">合同号：</td>
	            <td class="tableContent"><input type="text" name="contract_num" value="${obj.contract_num}"/></td>
	            <td class="columnTitle_mustbe">打印版式：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="print_style" value="2" class="input" <c:if test="${obj.print_style=='2'}">checked</c:if>>两款
	            	<input type="radio" name="print_style" value="1" class="input" <c:if test="${obj.print_style=='1'}">checked</c:if>>一款
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">签单日期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="sign_date" value="<fmt:formatDate value="${obj.sign_date}" pattern="yyyy-MM-dd"/>"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	            <td class="columnTitle_mustbe">重要程度：</td>
	            <td class="tableContentAuto">
	            	<input type="radio" name="importance_num" value="3" class="input" <c:if test="${obj.importance_num==3}">checked</c:if>>★★★
	            	<input type="radio" name="importance_num" value="2" class="input" <c:if test="${obj.importance_num==2}">checked</c:if>>★★
	            	<input type="radio" name="importance_num" value="1" class="input" <c:if test="${obj.importance_num==1}">checked</c:if>>★
	            </td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">交货期限：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="delivery_date" value="<fmt:formatDate value="${obj.delivery_date}" pattern="yyyy-MM-dd"/>"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	            <td class="columnTitle_mustbe">船期：</td>
	            <td class="tableContent">
					<input type="text" style="width:90px;" name="ship_date" value="<fmt:formatDate value="${obj.ship_date}" pattern="yyyy-MM-dd"/>"
	             			onclick="WdatePicker({el:this,isShowOthers:true,dateFmt:'yyyy-MM-dd'});"/>
				</td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">贸易条款：</td>
	            <td class="tableContent"><input type="text" name="trade_clause" value="${obj.trade_clause}"/></td>
	            <td class="columnTitle_mustbe">验货员：</td>
	            <td class="tableContent"><input type="text" name="inspector" value="${obj.inspector}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">制单人：</td>
	            <td class="tableContent"><input type="text" name="cinput_by" value="${obj.cinput_by}"/></td>
	            <td class="columnTitle_mustbe">审单人：</td>
	            <td class="tableContent"><input type="text" name="checked_by" value="${obj.checked_by}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">要求：</td>
	            <td class="tableContent"><textarea name="crequests" style="height:120px;">${obj.crequests}</textarea></td>
	            <td class="columnTitle_mustbe">说明：</td>
	            <td class="tableContent"><textarea name="accountfor" style="height:120px;">${obj.accountfor}</textarea></td>
	        </tr>
		</table>
	</div>
</div>
 
 
</form>
</body>
</html>

