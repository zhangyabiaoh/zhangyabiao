<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title></title>
</head>
<script language="javascript"> 
	function preSubmit(serviceName){
		if(serviceName=="删除"||serviceName=="查看"||serviceName=="修改"||serviceName=="启用"||serviceName=="禁止"||serviceName=="排序"||serviceName=="重置密码"){
			if(serviceName=="排序"){
				showBuilding();
				return false;
			}
			if(serviceName=="删除"){
				if(_CheckAll(true,serviceName) == false){
	            	return false;
	 			}
				return confirm(operationNote(serviceName));
			}
			if(_CheckAll(true,serviceName) == false){
				return false;
	 		}
		}
	}
	
	function preCheck(serviceName) {
	 	if(serviceName=="修改"||serviceName=="查看"){
				return onlySelect(serviceName,"id",1);
		}	
	}
	
	function onlineUser(serviceName) {
	 	//formSubmit("system_admin/userListAction.do?online=1","_self");	
	}
</script>
 
<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
<li id="view"><a href="#" onclick="formSubmit('toview.action','_self');this.blur();">查看</a></li>
<li id="new"><a href="#" onclick="formSubmit('tocreate.action','_self');this.blur();">新增</a></li>
<!-- <li id="update"><a href="#" onclick="formSubmit('toupdate.action','_self');this.blur();">修改</a></li> -->
<li id="delete"><a href="#" onclick="formSubmit('deleteById.action','_self');this.blur();">删除</a></li>
<li id="delete"><a href="#" onclick="formSubmit('delete.action','_self');this.blur();">删除N</a></li>
<!-- <li id="new"><a href="#" onclick="formSubmit('start.action','_self');this.blur();">启用</a></li>
<li id="new"><a href="#" onclick="formSubmit('stop.action','_self');this.blur();">停用</a></li> -->
</ul>
  </div>
</div>
</div>
</div>

<!-- 页面主体部分（列表等） -->    
<div class="textbox" id="centerTextbox">
  <div class="textbox-header">
  <div class="textbox-inner-header">
  <div class="textbox-title">
    用户列表
  </div> 
  </div>
  </div>
  
<div>

<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	<thead>
	<tr>
		<td class="tableHeader"><input type="checkbox" name="selid" onclick="checkAll('id',this)"></td>
		<td class="tableHeader">序号</td>
		<td class="tableHeader">角色名称</td>
		<td class="tableHeader">角色权限</td>
		<td class="tableHeader">角色介绍</td>
		<td class="tableHeader">状态</td>
	</tr>
	</thead>
	<tbody class="tableBody" >
	
	<c:forEach items="${dataList}" var="o" varStatus="status">
	<tr class="odd" onmouseover="this.className='highlight'" onmouseout="this.className='odd'" >
		<td><input type="checkbox" name="id" value="${o.id}"/></td>
		<td>${status.index+1}</td>
		<td><a href="toview.action?id=${o.id}">${o.rolername}</a></td>
		<td>${o.rolerprivate}</td>
		<td>${o.rolernote}</td>
		<td>
			<c:if test="${o.state==1}"><a href="stop.action?id=${o.id}"><font color="green">启用</font></a></c:if>
			<c:if test="${o.state==0}"><a href="start.action?id=${o.id}">停用</a></c:if>
		</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</div>
 
</div>
 
 
</form>


</body>
</html>