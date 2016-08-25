<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>潭州学院keke老师模板页面</title>
	<meta http-equiv="pragma" adminstat="no-cache">
	<meta http-equiv="cache-control" adminstat="no-cache">
	<meta http-equiv="expires" adminstat="0">    
	<meta http-equiv="keywords" adminstat="keyword1,keyword2,keyword3">
	<meta http-equiv="description" adminstat="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	<script src="${basePath}/resources/js/echart/echarts-all.js"></script>
 </head>
 <body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="content"> 首页  &gt; 日记管理</div>
			<div class="cnt">
				<select onchange="loadData(this.value)">
					<option>请选择年份</option>
					<c:forEach begin="2010" end="2020" var="year">
						<option value="${year}">${year}</option>
					</c:forEach>
				</select>
				<div class="tabwrap" id="main" style="height: 400px;">
						
				</div>
			</div>
		</div>
	</div>
	<script>
	
	$(function(){
		loadData(new Date().getFullYear());
	});
	function loadData(year){
		$.ajax({
			type:"post",
			url:"http://localhost:8088/moonvip_admin/admin/stat/list",
			data:{year:year},
			success:function(data){
// 				alert(JSON.stringify(data));
					var json={
							
							title:year+"报表",
				            datas:parseData(data)
					};
				initChart("main",json)
			}
		});
	}
		
		function parseData(jsonArr){
			var jsonObj = {};
			for(var key in jsonArr){
				var num = jsonArr[key].num;
				var m = jsonArr[key].m;
				jsonObj["s"+parseInt(m)]= num;
			};
			var arr = [];
			for(var i=1;i<=12;i++){
				arr.push(jsonObj["s"+i]||0);
			}
			return arr;
		}
		
		function initChart(targetid,json){
		var myChart = echarts.init(document.getElementById(targetid,'main'));
		var option = {
			    title : {
			    	x:"center",
			        text: json.title,
			        subtext:"月份/总数"
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value'
			        }
			    ],
			    series : [
			        {
			            name:'访问人数',
			            type:'bar',
			            data:json.datas,
			            markPoint : {
			                data : [
			                    {type : 'max', name: '最大值'},
			                    {type : 'min', name: '最小值'}
			                ]
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name: '平均值'}
			                ]
			            }
			        
			        }
			    ]
			};
			                    
                    
		myChart.setOption(option);
		}
    </script>
 </body>
</html>
