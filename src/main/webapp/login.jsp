<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="others/log/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="others/log/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="others/log/css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
						<h3>欢迎你</h3>
						<form action="#" name="f" method="post">
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" id="username" class="text" style="color: #FFFFFF !important" type="text" value="yangmingsen" placeholder="请输入账户">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" id="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;" value="123456" type="password"  placeholder="请输入密码">
							</div>
							<div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF" id="submit" >登录</a></div>
						</form>
					</div>
				</div>
			</div>
		</div><!-- /container -->
		<script src="others/log/js/TweenLite.min.js"></script>
		<script src="others/log/js/EasePack.min.js"></script>
		<script src="others/log/js/rAF.js"></script>
		<script src="others/log/js/demo-1.js"></script>

		<script src="/js/jquery-3.3.1.js"></script>
		<script type="application/javascript">
			$(function () {
				$("#submit").click(function () {
					var username = $("#username").val();
					var password = $("#password").val();
					$.ajax({
						type: "POST",
						url: "/user/login",
						async: false,
						dataType: "json",
						data: {"username":username,"password":password},
						success(data) {
							var status = data.status;

							if (status == 1) {
								window.location.href = "index.jsp";
							} else if(status == 0 ) {
								alert("账号密码错误!!!");
							}
						}
					});
				});
			})

		</script>
		
	</body>
</html>