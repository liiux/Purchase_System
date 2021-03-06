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
<link href="<%=basePath%>/css/style.css" rel="stylesheet"
	type="text/css" />
<!-- 引入bootstrap分页 -->
<link rel="stylesheet"
	href="<%=basePath%>/js/bootstrap/bootstrap.css" />
<script src="<%=basePath%>/js/bootstrap/jquery.min.js"></script>
<script src="<%=basePath%>/js/bootstrap/bootstrap.min.js"></script>
<script src="<%=basePath%>/js/bootstrap/bootstrap-paginator.js"></script>
<script>
$(function() {
	$('#pagination').bootstrapPaginator({
		bootstrapMajorVersion: 3,
		currentPage: ${requestScope.pageInfo.pageNum },
		totalPages: ${requestScope.pageInfo.pages },
		pageUrl: function(type, page, current) {
			return '/addPlanInfo.do?pageNum=' + page;
		},
		itemTexts: function(type, page, current) {
			switch(type) {
				case "first":
					return "首页";
				case "prev":
					return "上一页";
				case "next":
					return "下一页";
				case "last":
					return "末页";
				case "page":
					return page;
			}
		}
	});
});
</script>
<%-- <script type="text/javascript" src="<%=basePath %>/js/jquery.js"></script>--%>
<script type="text/javascript">
 $(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
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
	<div class="rightinfo">
		 <%-- <div class="tools">
			<ul class="toolbar">
				<li id="add" class="click"><span><img
						src="<%=basePath%>/images/t01.png" /></span>添加</li>
				<li class="click"><span><img
						src="<%=basePath%>/images/t02.png" /></span>修改</li>
				<li id="batchDel"><span><img
						src="<%=basePath%>/images/t03.png" /></span>删除</li>
			</ul>

			<div class="toolbar1">
				<table>
					<form method="post" name="serch"
						action="<%=basePath%>/getSupplierInfoByCondition.do">
						<tr>
							<td class="zi"><span>选择分类：</span></td>
							<td><select name="type">
									<option value="名称">名称</option>
									<option value="地址">地址</option>
									<option value="联系人">联系人</option>
									<option value="联系电话">联系电话</option>
							</select></td>
							<td class="zi"><span>关键字：</span></td>
							<td><input name="keyWord" type="text" placeholder="与分类关联" /></td>
							<td><input type="submit" value="查询" class="button" /></td>
						</tr>
					</form>
				</table>
			</div>

		</div> --%> 
		<table class="tablelist">
			<thead>
				<tr>

					<th>编号</th>
					<th>原料名称</th>
					<th>原料数量</th>
					<th>原料单价</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.pageInfo.list }" var="map"
					varStatus="num">
					<tr>

						<td>${num.count }</td>
						<td>${map.name }</td>
						<td>${map.num }</td>
						<td>${map.price }</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- bookstrap的分页 -->
		<!-- 把分页搞出来 -->
		<ul id="pagination"></ul>


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



		<div class="tip">
			<div class="tiptop">
				<span>提示信息</span><a></a>
			</div>
			<div class="tipinfo">
				<span><img src="images/ticon.png" /></span>
				<div class="tipright">
					<p>是否确认对信息的修改 ？</p>
					<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
				</div>
			</div>
			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" /> &nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	
	 $(function(){
		 <%-- $("#delBtn").click(function(){
				var flag=window.confirm("您确认删除本条记录吗？");
				if(flag){
					var food_id=$(this).attr("food_id")
					var plan_id=$(this).attr("plan_id")
					$.ajax({
						url:"<%=basePath%>/delPlanInfo.do",
						type:"POST",
						data:{foodId:food_id,planId:plan_id},
						dataType:"JSON",
						success:function(result){
							if(result){//删除成功
								window.location.reload();
							}else{
								window.alert("删除失败，请您重新试一次！")
							}
						}
					});
				}
			}); --%>
		<%--
		/* 全选复选框按钮 */
		$("#selectAll").change(function(){
			var flag =  $(this).prop("checked");
			if(flag){//全选
				$("input[name=ck]").prop("checked",true);
			}else{//全部取消
				$("input[name=ck]").prop("checked",false);
			}
		});
		
		/* 批量删除 */
		$("#batchDel").click(function(){
			//先判断有没有被勾选
			var $ckChecked = $("input[name=ck]:checked");
			var len = $ckChecked.size();
			if(len>=1){
				var ids = "";
				$ckChecked.each(function(index,dom){
					var id = $(dom).val();
					ids+=id+",";
				});
				//将多个id传递给后台的controller方法
				$.ajax({
					url:"<%=basePath %>/batchDel.do",
					type:"POST",
					dataType:"JSON",
					data:{idAttr:ids},
					success:function(result){
						if(result){
							window.location.reload();
						}else{
							alert("批量删除失败");
						}
					}
				});
			}else{
				alert("亲，请选择要删除的记录!");
			}
		});
		
		$("#add").click(function(){
			$.ajax({
				url:"<%=basePath %>/addSupplierInfo_main.do"
			})
		}) --%>
		
	});
	</script>
</body>
</html>
