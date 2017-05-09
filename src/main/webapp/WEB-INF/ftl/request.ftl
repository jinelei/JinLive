<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title><@spring.message "web.request"/></title>
	<script src="/js/jquery-3.2.0.min.js"></script>
	<#--<link rel="stylesheet" href="/css/bootstrap.min.css">-->
	<#--<link rel="stylesheet" href="/css/bootstrap-theme.min.css">-->
	<#--<script src="/js/bootstrap.min.js"></script>-->
    <link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="request_container" class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
        <#if status?? && status == 0>
			<div class="form-group">
				<label for="request_user_phone" id="request_user_phone_label"><@spring.message "web.userinfo.phone"/>:</label>
				<input type="text" maxlength='11' class="form-control" id="request_user_phone"
				       name="phone" onblur="checkPhone()"
				       placeholder="<@spring.message "web.userinfo.phone.tips"/>">
			</div>
			<div class="form-group">
				<label for="request_user_email" id="request_user_email_label"><@spring.message "web.userinfo.email"/>:</label>
				<input type="text" maxlength='21' class="form-control" id="request_user_email"
				       name="email" onblur="checkEmail()"
				       placeholder="<@spring.message "web.userinfo.email.tips"/>">
			</div>
			<button type="submit" id="request_submit" class="btn btn-default" onclick="postSubmit()">提交</button>
        </#if>
		</div>
	</div>

</div>

<script>

	function checkPhone() {
		var phone = $("#request_user_phone").val();
		console.log(phone);
		if (phone != "" && !(/^1(3|4|5|7|8)\d{9}$/.test(phone))) {
			console.log("wrong")
			$("#request_user_phone").parent('div').addClass('has-error');
		} else {
			console.log('success')
			$("#request_user_phone").parent('div').removeClass('has-error');
		}
	}

	function checkEmail() {
		var email = $("#request_user_email").val();
		console.log(email);
		var emailreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if (email != "" && !emailreg.test(email)) {
			console.log("wrong")
			$("#request_user_email").parent('div').addClass('has-error');
		} else {
			console.log('success')
			$("#request_user_email").parent('div').removeClass('has-error');
		}
	}

	function postSubmit() {
		if ($('div.form-group.has-error').length == 0) {
			var email = $("#request_user_email").val();
			var phone = $("#request_user_phone").val();
			console.log("submit");
			$.post(location.href, {
				phone: phone,
				email: email,
			},function (data) {
			    var res = JSON.parse(data);
			    if (res.status == 0){
			        alert("验证成功！");
			        history.back();
				}
			})
		} else {
			alert("请更正后重试");
		}
	}

</script>

</body>
</html>
