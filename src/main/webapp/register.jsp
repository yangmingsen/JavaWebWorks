<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<title>注册界面</title>
		<link rel="stylesheet" href="others/reg/css/reset.css" />
		<link rel="stylesheet" href="others/reg/css/common.css" />
		<link rel="stylesheet" href="others/reg/css/font-awesome.min.css" />
		<style type="text/css">
			.form_text_ipt,.form_text_ipt input {
				background: #83939005;
				border-radius: 15%;
			}

		</style>
	</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
				
				<div class="logo"></div>
				
				<div class="login_box">
					<p id="hint" style="color: red;font: bold 22px/20px arial,sans-serif;"></p>
					<div class="login_form">
						<div class="login_title">
							注册
						</div>
						<form action="/user/register" method="post">
							
							<div class="form_text_ipt">
								<input name="username" id="username" type="text" placeholder="手机号/邮箱">
							</div>
							<div class="ececk_warning"><span>手机号/邮箱不能为空</span></div>
							<div class="form_text_ipt">
								<input name="password" id="password" type="password" placeholder="密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_text_ipt">
								<input name="repassword" type="password" placeholder="重复密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_text_ipt">
								<input name="code" type="text" placeholder="验证码">
							</div>
							<div class="ececk_warning"><span>验证码不能为空</span></div>
							
							<div class="form_btn">
								<button type="button" onclick="register()">注册</button>
							</div>
							<div class="form_reg_btn">
								<span>已有帐号？</span><a href="login.jsp">马上登录</a>
							</div>
						</form>
						<div class="other_login">
							<div class="left other_left">
								<span>其它登录方式</span>
							</div>
							<div class="right other_right">
								<a href="#"><i class="fa fa-qq fa-2x"></i></a>
								<a href="#"><i class="fa fa-weixin fa-2x"></i></a>
								<a href="#"><i class="fa fa-weibo fa-2x"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="others/reg/js/jquery.min.js" ></script>
		<script type="text/javascript" src="others/reg/js/common.js" ></script>
		<script type="application/javascript">

			$("#username").keyup(function () {
				$.ajax({
					type: "POST",
					url: "/user/check",
					async: true,
					data: {username: $("#username").val()},
					dataType: "json",
					success: function (data) {
						var status = data.status;
						if (status == 1) {
							$("#hint").text("该用户不可用！！！");
						} else if(status == 0 ) {
							$("#hint").text("该用户可用!!!");
						}
					}
				});
			});

			function register() {
				var username = $("#username").val();
				var password = $("#password").val();

				if(username.length>0 && password.length>0) {
					$.ajax({
						type: "POST",
						url: "/user/register",
						async: true,
						data: {"username": username,"password":password},
						dataType: "json",
						success: function (data) {
							var status = data.status;

							if (status == 1) {
								alert("注册成功!!!")
								window.location.href = "login.jsp";
							} else if(status == 0 ) {
								alert("注册失败!!!");
							}
						}
					});
				} else {
					alert("请输入账号密码!!!");
				}


			}


		</script>
	</body>
</html>
