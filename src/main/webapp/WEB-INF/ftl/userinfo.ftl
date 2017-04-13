<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>search result</title>
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	        crossorigin="anonymous"></script>
	<style>
		* {
			padding: 0;
			margin: 0;
		}

		#userinfo_container {
			margin-left: 330px;
		}

	</style>
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="userinfo_container">
<#if user?? && user != "anonymousUser">
	<input hidden id="modify_user_id" value="${user.userId}">
	<br/>
	<h3 class="text-info">个人信息</h3>
	<table class="table table-hover">
		<tr>
			<td>主播昵称：</td>
			<td>
                <#if user.userNickname??> ${user.userNickname}
                <#else>
					无
                </#if>
				&nbsp;&nbsp;&nbsp;<a id="modify_user_nickname" class="modify_a">修改</a>
			</td>
			<td style="display: none;">
				<div class="input-group">
					<input id="modify_user_nickname_input" type="text" class="form-control modify-user-input"
					       name="nickname"
					       placeholder="Input new Value" aria-describedby="basic-addon1">
					<span id="modify_user_nickname_submit"
					      class="glyphicon glyphicon-saved input-group-addon modify-user-submit-btn"
					      aria-hidden="true"></span>
				</div>
			</td>
		</tr>
		<tr>
			<td>性别：</td>
			<td>
                <#if user.userSex == 0>保密<#elseif  user.userSex == 1>男<#elseif user.userSex ==2>女</#if>
				&nbsp;&nbsp;&nbsp;<a id="modify_user_sex" class="modify_a">修改</a>
			</td>
			<td style="display: none;">
				<div class="input-group">
					<input id="modify_user_sex_input" type="text" class="form-control modify-user-input"
					       name="sex"
					       placeholder="Input new Value" aria-describedby="basic-addon1">
					<span id="modify_user_sex_submit"
					      class="glyphicon glyphicon-saved input-group-addon modify-user-submit-btn"
					      aria-hidden="true"></span>
				</div>
			</td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td>
                <#if user.userAge??>${user.userAge}<#else>无</#if>
				&nbsp;&nbsp;&nbsp;<a id="modify_user_age" class="modify_a">修改</a>
			</td>
			<td style="display: none;">
				<div class="input-group">
					<input id="modify_user_age_input" type="text" class="form-control modify-user-input"
					       name="age"
					       placeholder="Input new Value" aria-describedby="basic-addon1">
					<span id="modify_user_age_submit"
					      class="glyphicon glyphicon-saved input-group-addon modify-user-submit-btn"
					      aria-hidden="true"></span>
				</div>
			</td>
		</tr>
		<tr>
			<td>身高：</td>
			<td>
                <#if user.userHeight?? >${user.userHeight}<#else>无</#if>
				&nbsp;&nbsp;&nbsp; <a id="modify_user_height" class="modify_a">修改</a>
			</td>
			<td style="display: none;">
				<div class="input-group">
					<input id="modify_user_height_input" type="text" class="form-control modify-user-input"
					       name="height"
					       placeholder="Input new Value" aria-describedby="basic-addon1">
					<span id="modify_user_height_submit"
					      class="glyphicon glyphicon-saved input-group-addon modify-user-submit-btn"
					      aria-hidden="true"></span>
				</div>
			</td>
		</tr>
		<tr>
			<td>体重：</td>
			<td>
                <#if user.userWeight??>${user.userWeight}<#else>无</#if>
				&nbsp;&nbsp;&nbsp; <a id="modify_user_weight" class="modify_a">修改</a>
			</td>
			<td style="display: none;">
				<div class="input-group">
					<input id="modify_user_weight_input" type="text" class="form-control modify-user-input"
					       name="weight"
					       placeholder="Input new Value" aria-describedby="basic-addon1">
					<span id="modify_user_weight_submit"
					      class="glyphicon glyphicon-saved input-group-addon modify-user-submit-btn"
					      aria-hidden="true"></span>
				</div>
			</td>
		</tr>
	</table>

	<br/>
	<h3 class="text-info">联系方式</h3>
	<table class="table table-hover">
		<tr>
			<td>邮箱：</td>
			<td>
                <#if user.userEmail??>${user.userEmail}<#else>无</#if>
				&nbsp;&nbsp;&nbsp; <a id="modify_user_email" class="modify_a">修改</a>
			</td>
			<td style="display: none;">
				<div class="input-group">
					<input id="modify_user_email_input" type="text" class="form-control modify-user-input"
					       name="email"
					       placeholder="Input new Value" aria-describedby="basic-addon1">
					<span id="modify_user_email_submit"
					      class="glyphicon glyphicon-saved input-group-addon modify-user-submit-btn"
					      aria-hidden="true"></span>
				</div>
			</td>
		</tr>
		<tr>
			<td>手机号：</td>
			<td>
                <#if user.userPhone??>${user.userPhone}<#else>无</#if>
				&nbsp;&nbsp;&nbsp;<a id="modify_user_phone" class="modify_a">修改</a>
			</td>
			<td style="display: none;">
				<div class="input-group">
					<input id="modify_user_phone_input" type="text" class="form-control modify-user-input"
					       name="phone"
					       placeholder="Input new Value" aria-describedby="basic-addon1">
					<span id="modify_user_phone_submit"
					      class="glyphicon glyphicon-saved input-group-addon modify-user-submit-btn"
					      aria-hidden="true"></span>
				</div>
			</td>
		</tr>
	</table>
	<br/>
	<h3 class="text-info">帐号信息</h3>
	<table class="table table-hover">
		<tr>
			<td>财富值：</td>
			<td>
                <#if user.userTreasure??>${user.userTreasure}<#else>无</#if>
				&nbsp;&nbsp;&nbsp; <a id="modify_user_treasure" class="modify_a">修改</a>
			</td>
			<td style="display: none;">
				<div class="input-group">
					<input id="modify_user_treasure_input" type="text" class="form-control modify-user-input"
					       name="treasure"
					       placeholder="Input new Value" aria-describedby="basic-addon1">
					<span id="modify_user_treasure_submit"
					      class="glyphicon glyphicon-saved input-group-addon modify-user-submit-btn"
					      aria-hidden="true"></span>
				</div>
			</td>
		</tr>
	</table>
<#else>
	<div style="text-align: center">
		<h4 style="padding-top: 80px">Please
			<a class="text-primary" data-whatever="login" data-toggle="modal"
			   data-target="#user_modal" href="#">Login</a>
		</h4>
	</div>
</#if>

</div>

<script>

	$(".modify_a").on('click', function () {
		console.log(this);
		$(this).parent('td').parent('tr').children('td:last').show();
		$(this).parent('td').hide();
	})
	$(".modify-user-input").on('blur', function () {
		var type = $(this).attr('name');
		var userid = $("#modify_user_id").val();
		var value = $(this).val();
		console.log(type);
		console.log(userid);
		console.log(value);

		checkInputEmpty(this);

		$.post("/user/update", {
			userid: userid,
			type: type,
			value: value,
		}, function (data, status) {
			console.log(data);
			console.log(status);
		});
	})

	function checkInputEmpty(ele) {
	    if ($(ele).val().length ==0){
	        $(ele).parent('div').addClass("has-error");
//	        inputShake(ele);
		}
	}

</script>

</body>
</html>
