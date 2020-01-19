<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
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
	<div class="formbody">
			<div class="formtitle">
				<span>采购计划信息</span>
			</div>
			<div id="usual1" class="usual">
				<div id="tab1" class="tabson">
					<form method="post" action="/addPlanInfo.do?maxPlan=${sessionScope.maxPlan} ">
						<ul class="forminfo">
							<li style="margin-top: 20px;"><label for="name">原料名称<b>*</b></label>
								<div class="vocation">
									<input name="name" type="text" class="dfinput"
										placeholder="请填写原料名称" style="width: 344px;" />
								</div></li>
							<br />
							<br />
							<br />
							<li><label for="name">原料数量<b>*</b></label>
								<div class="vocation">
									<input name="num" type="text" class="dfinput"
										placeholder="请填写原料数量" style="width: 344px;" />
								</div></li>
							<br />
							<li><label for="name">原料单价<b>*</b></label>
								<div class="vocation">
									<input name="price" type="text" class="dfinput"
										placeholder="请填写原料单价" style="width: 344px;" />
								</div></li>
							<br />
							<li><label>&nbsp;</label> <input name="" type="submit"
								class="btn" value="添加" /></li>
						</ul>
					</form>
				</div>
			</div>
			<script type="text/javascript"> 
  
      $("#usual1 ul").idTabs(); 
    </script>
			<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	
	!function(){
laydate.skin('qianhuang');
laydate({elem: '#Calendar'});
laydate.skin('qianhuang');
laydate({elem: '#Calendar2'});
}();
$(function dd(){
		var d=new Date(),str="";
		str+=(d.getFullYear()+"-");
		str+="0";
		str+=(d.getMonth()+1+"-");
		str+=d.getDate();
		$("#Calendar").attr("value",str);
		$("#Calendar2").attr("value",str);
	});

	</script>
		</div>
</body>
</html>
