<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>潭州学院keke老师模板页面</title>
	<meta http-equiv="pragma" permission="no-cache">
	<meta http-equiv="cache-control" permission="no-cache">
	<meta http-equiv="expires" permission="0">    
	<meta http-equiv="keywords" permission="keyword1,keyword2,keyword3">
	<meta http-equiv="description" permission="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	<!-- 引入树的js和css -->
	<link rel="stylesheet" href="${basePath}/resources/sg/tree/tm_tree.css"/>
	<script type="text/javascript" src="${basePath}/resources/sg/tree/tm_tree.js"></script>
										
 </head>
 <body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="content"> 首页 > 权限管理</div>
			<div class="cnt">
				<div class="tabwrap">
					<div id="permissiontree"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
		$(function(){
			
			function initPermissionTree(){
				tzAjax.request({
					path:adminPath,
					model:"permission",
					method:"root",
					success:function(data){
						var root = data.root;
						var children= data.children;
						$("#permissiontree").tmTree({root:root,children:children,type:"checkbox",onclick:function($obj,data){
							
						},callback:function(opid){
							var $this = $(this);
							$.tzConfirm({callback:function(ok){
								if(ok){
									$this.closest("li").remove();
								}
							}});
							
						}});
					}
				});
			};
			initPermissionTree();
			
			$(".nav").find("li.items").find("a").click(function(){
				var len = $(this).next().length;
				if(len>0){
					$(this).next().stop(true,true).slideToggle()
					.end().parents("li")
					.addClass("active")
					.siblings().removeClass("active")
					.find("ul").slideUp("slow");
				}
			});
		});
	</script>
 </body>
</html>
