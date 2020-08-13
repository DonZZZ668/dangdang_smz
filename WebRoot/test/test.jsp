<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
				var i=5;
				var id=window.setInterval(fun,1000);
				function fun(){
					
					$("#time").html((i--)+"秒后自动跳转至当当网首页");
					if(i==0){
						location.href="http://www.baidu.com";
					}
				}
		</script>
	</head>
	<body>
		<div id="time"></div>
	</body>
</html>

