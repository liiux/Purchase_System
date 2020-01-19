<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" deferredSyntaxAllowedAsLiteral="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>/css/style.css" rel="stylesheet"
		type="text/css" />
	<link href="<%=basePath %>/css/select.css" rel="stylesheet"
		type="text/css" />
	<script type="text/javascript" src="<%=basePath %>/js/jquery.js"></script>
	<script type="text/javascript"
		src="<%=basePath %>/js/jquery.idTabs.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath %>/js/select-ui.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath %>/editor/kindeditor.js"></script>
	<script type="text/javascript"
		src="<%=basePath %>/js/laydate/laydate.js"></script>
	<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
	<script type="text/javascript">



$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
	
	
	
});


</script>
</head>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><h>首页</h></li>
			<li><h>计划员管理</h></li>
			<li><h>制定采购计划</h></li>
		</ul>
	</div>
	<br/>
	<form method="post" action="<%=basePath %>/addPlan.do?user_id=${sessionScope.user_id}">
	<label>&nbsp;&nbsp;</label><input id="newPlan" type="submit" class="btn" value="新建采购计划" ></input>
	</form>
	<script type="text/javascript">
		/* $(function(){
			$("#newPlan").click(function(){
				$.ajax({
					uri
				})
			})
		})
		 */
	</script>
	
	
</body>
</html>
