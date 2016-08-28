<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.1.min.js"></script>
	    <script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		<script>
		    $(function(){
		      $("#f").validate({
		        rules:{
		          "user.email":{
	                    required:true,
	                    email:true
	              },
	              "user.nickname":{
	                    required:true,
	                    minlength:2,
	                    maxlength:20
	              },
	              "user.password":{
	                    required:true,
	                    minlength:6,
	                    maxlength:20
	              },
	              password1:{
	                   required:true,
	                   equalTo: "#txtPassword"
	              },
	              number:{
	                   remote:"check.action"
	              }
		        },
		        messages:{
	              "user.email":{
	                 required:"邮箱不能为空",
	                 email:"邮箱格式不正确"
	              },
	              "user.nickname":{
	                 required:"昵称不能为空",
	                 minlength:"昵称长度不能小于4位",
	                 maxlength:"昵称长度不能大于20位"
	              },
	              "user.password":{
	                 required:"验证码不能为空",
	                 minlength:"密码长度不能小于6位",
	                 maxlength:"密码长度不能大于20位"
	              },
	               password1:{
	                   required:"密码不能为空",
	                   equalTo: "两次密码不一致"
	              },
	              number:{
	                   remote:"验证码不对"
	              }
		        }
		      });
		    });
		    
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post" action="register.action" id="f">
				<h2>
					以下均为必填项
				</h2>
				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
						<div style="color:red">
							<input name="user.email" type="text" id="txtEmail"
								class="text_input" />
						</div>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
								<span id="email.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
						<div style="color:red">
							<input name="user.nickname" type="text" id="txtNickName"
								class="text_input" />
						</div>
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="name.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
						<div style="color:red">
							<input name="user.password" type="password" id="txtPassword"
								class="text_input" />
						</div>
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="password.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
						<div style="color:red">
							<input name="password1" type="password" id="txtRepeatPass"
								class="text_input" />
						</div>
							<div class="text_left" id="repeatPassValidMsg">
								<span id="password1.info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<a href="javascript:;" onclick="${'imgVcode'}.src='checkCodeAction?'+(new Date()).getTime()"><img class="yzm_img" id='imgVcode' name="imgVcode" src="checkCodeAction" /></a>
						<div style="color:red">
							<input name="number" type="text" id="txtVerifyCode"
								class="yzm_input" />
						</div>
						
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中的五个字母。</span>

									<span id="number.info" style="color:red"></span>
									<a href="javascript:;" onclick="${'imgVcode'}.src= 'checkCodeAction?'+(new Date()).getTime()">看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>
				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"
						type="submit" value="注 册" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

