<%@page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="../css/login.css" rel="stylesheet" type="text/css" />
		<link href="../css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery-1.4.1.min.js"></script>
		<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
		<script>
		$(function(){
		       $("#f").validate({
		          rules:{
		               "address.receiveName":{
		                  required:true
		               },
		               "address.fullAddress":{
		                   required:true
		               },
		               "address.postalCode":{
		                   required:true,
		                   number:true,
		                   minlength:6,
		                   maxlength:7 
		               },
		                "address.phone":{
		                   required:true,
		                   number:true
		               },
		                "address.mobile":{
		                  required:true,
		                  number:true
		               }
		          },
		          messages:{
		               "address.receiveName":{
		                   required:"收件人不能为空"
		               },
		               "address.fullAddress":{
		                   required:"收件地址不能为空"
		               },
		               "address.postalCode":{
		                   required:"邮政编码不能为空",
		                   number:"邮政编码必须为数字",
		                   minlength:"邮政编码至少为六位",
		                   maxlength:"邮政编码最多为七位"
		               },
		               "address.phone":{
		                   required:"电话号码不能为空",
		                   number:"邮政编码必须为数字"
		               },
		               "address.mobile":{
		                   required:"手机号码不能为空",
		                   number:"邮政编码必须为数字"
		               }
		          }
		       });
		    });
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address">
					<option>
						填写新地址
					</option>
				</select>
			</p>
			<form name="ctl00" method="get" action="addressAction.action" id="f">
				<input type="hidden" name="id" id="addressId" />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<div style="color: red">
								<input type="text" class="text_input" name="address.receiveName"
									id="receiveName" />
							</div>
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<div style="color: red">
								<input type="text" name="address.fullAddress" class="text_input"
									id="fullAddress" />
							</div>
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码：
						</td>
						<td>
							<div style="color: red">
								<input type="text" class="text_input" name="address.postalCode"
									id="postalCode" />
							</div>
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话：
						</td>
						<td>
							<div style="color: red">
								<input type="text" class="text_input" name="address.phone"
									id="phone" />
							</div>
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							手机：
						</td>
						<td>
							<div style="color: red">
								<input type="text" class="text_input" name="address.mobile"
									id="mobile" />
							</div>
							<div class="text_left" id="mobileValidMsg">
								<p>
									请填写有效的收件人的手机
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">
					<a href="javascript:;" onclick='location="../order/orderAction.action"'>
						 <input id="cancel" class="button_1" name="cancel" type="button" value="取消" /> 
					</a>
					     <input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

