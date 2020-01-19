<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() +request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>酒店客房管理系统头部</title>
<link href="<%=basePath %>/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=basePath %>/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})

//获取系统时间
function current(){ 
    var d=new Date(),str=''; 
    str +=d.getFullYear()+'年'; //获取当前年份 
    str +=d.getMonth()+1+'月'; //获取当前月份（0——11） 
    str +=d.getDate()+'日'; 
    str +=d.getHours()+'时'; 
    str +=d.getMinutes()+'分'; 
    //str +=d.getSeconds()+'秒'; 
    return str;
} 
setInterval(function(){
    $("#systime").html(current)
},100);	
</script>
</head>

<body style="background:url(<%=basePath %>/images/topbg.gif) repeat-x;">
<div class="topleft"> <a href="#"></a> </div>

<div class="systime">
  <span id="systime"></span>
</div>
<div class="topright">
  <ul>
    <li><a href="<%=basePath %>/login.do" target="_parent">退出</a></li>
  </ul>
  <div class="user"> <span>当前用户：${sessionScope.user_name}</span> </div>
</div>
</body>
</html>
