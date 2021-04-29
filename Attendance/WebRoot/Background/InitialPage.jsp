<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>系统</title>
<link rel="stylesheet" href="<%=basePath %>/commot/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath %>/commot/layui/lay-module/layui_ext/dtree/dtree.css">
<link rel="stylesheet" href="<%=basePath %>/commot/layui/lay-module/layui_ext/dtree/font/dtreefont.css">
<!-- 内容展示 -->
<script type="text/javascript" src="<%=basePath %>/commot/jquery-1.12.4.js"></script>
<!-- 弹窗 -->
<script type="text/javascript" src="<%=basePath %>/commot/common.js"></script>

<!-- treetable -->
<%-- <script type="text/javascript" src="<%=basePath %>/common/js/treeTable.js"></script> --%>
<style type="text/css">
.layui-header  {
            /*  background-color: #fffffb !important; */
             background-image: url("static/image/timg.jpg");
        }
.layui-header  a{
            color: #1d1626 !important;
        }
</style>
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo"><img
						src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
						class="layui-nav-img"> </div>
			<!-- 头部区域（可配合layui 已有的水平导航） -->
			<!-- <ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">nav 1</a></li>
				<li class="layui-nav-item"><a href="">nav 2</a></li>
				<li class="layui-nav-item"><a href="">nav 3</a></li>
				<li class="layui-nav-item"><a href="javascript:;">nav groups</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">menu 11</a>
						</dd>
						<dd>
							<a href="">menu 22</a>
						</dd>
						<dd>
							<a href="">menu 33</a>
						</dd>
					</dl></li>
			</ul> -->
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
						class="layui-nav-img"> 
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">Setting</a>
						</dd>
						<dd>
							<a href="">Sign out</a>
						</dd>
					</dl></li>
				<!-- <li class="layui-nav-item"><a href="">Sign out</a></li> -->
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<jsp:include page="/commot/Left.jsp"></jsp:include>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div id="bodydiv" style="padding: 15px;">
			内容主体区域
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			底部固定区域
		</div>
	</div>
	
	<script src="<%=basePath %>/commot/layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
		});
	</script>
</body>
<!-- 分配权限 -->
	<div style="height: 400px;overflow: auto;display: none;" id="fenpei" >
	  <ul id="demoTree" class="dtree" data-id="0"></ul>
	</div>
</html>
