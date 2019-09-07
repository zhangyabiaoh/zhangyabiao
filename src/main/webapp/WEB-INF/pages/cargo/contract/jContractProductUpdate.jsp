<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <script type="text/javascript">
    	//设置冗余的生产厂家名称
    	function setFactoryName(val){
    		var ele = document.getElementById("factory_name");
    		ele.value = val;
    	}
    </script>
</head>
<body>
<form method="post">
	<input type="text" name="id" value="${obj.id}"/>
	<input type="text" name="contractId" value="${obj.contract_id}"/>

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
    <div id="navMenubar">
<ul>
<li id="save"><a href="#" onclick="formSubmit('update.action','_self');">确定</a></li>
<li id="back"><a href="${ctx}/cargo/contract/list.action">返回</a></li>
</ul>
    </div>
</div>
</div>
</div>
     
<div class="textbox" id="centerTextbox">
    
    <div class="textbox-header">
    <div class="textbox-inner-header">
    <div class="textbox-title">
		修改货物信息
    </div> 
    </div>
    </div>
<div>
    <div>
		<table class="commonTable" cellspacing="1">
	        <tr>
	            <td class="columnTitle_mustbe">厂家名称：</td>
	            <td class="tableContent">
	            	<select name="factory_id" onchange="setFactoryName(this.options[this.selectedIndex].text);">
		            	<option value="">--请选择--</option>
	            		<c:forEach items="${factoryList}" var="f">
	            			<option value="${f.id}" <c:if test="${obj.factory_id==f.id}">selected</c:if>>${f.factoryName}</option>
	            		</c:forEach>
	            	</select>
	            	<input type="hidden" id="factory_name" name="factory_name" value="${obj.factory_name}"/>
	            </td>
	            <td class="columnTitle_mustbe">货号：</td>
	            <td class="tableContent"><input type="text" name="product_num" value="${obj.product_num}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">货物照片：</td>
	            <td class="tableContent"><input type="text" name="product_img" value="${obj.product_img}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">数量：</td>
	            <td class="tableContent"><input type="text" name="product_number" value="${obj.product_number}"/></td>
	            <td class="columnTitle_mustbe">包装单位：</td>
	            <td class="tableContent"><input type="text" name="pack_unit" value="${obj.pack_unit}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">装率：</td>
	            <td class="tableContent"><input type="text" name="load_rate" value="${obj.load_rate}"/></td>
	            <td class="columnTitle_mustbe">箱数：</td>
	            <td class="tableContent"><input type="text" name="boxs_num" value="${obj.boxs_num}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">单价：</td>
	            <td class="tableContent"><input type="text" name="product_price" value="${obj.product_price}"/></td>
	            <td class="columnTitle_mustbe">排序号：</td>
	            <td class="tableContent"><input type="text" name="orderno" value="${obj.orderno}"/></td>
	        </tr>
	        <tr>
	            <td class="columnTitle_mustbe">货物描述：</td>
	            <td class="tableContent"><textarea name="product_description" style="height:120px;">${obj.product_description}</textarea></td>
	        </tr>
		</table>
	</div>
</div>
 

 
</form>
</body>
</html>

