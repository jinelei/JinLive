<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>search result</title>
	<script src="/js/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	        crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/css/base.css">
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
<#if status ==0 && user?? && user != "anonymousUser">
	<input hidden id="modify_user_id" value="${user.userId}">
	<br/>
	<h3 class="text-info">个人信息</h3>
	<table class="table table-hover">
		<tr>
			<td>主播昵称：</td>
			<td><span>
                <#if user.userNickname??> ${user.userNickname}
                <#else>
					无
                </#if></span>
			</td>

		</tr>
		<tr>
			<td>性别：</td>
			<td><span>
                <#if user.userSex == 0>保密<#elseif  user.userSex == 1>男<#elseif user.userSex ==2>女</#if></span>
			</td>
		</tr>
		<tr>
			<td>年龄：</td>
			<td><span>
                <#if user.userAge??>${user.userAge}<#else>无</#if></span>
			</td>
		</tr>
		<tr>
			<td>身高：</td>
			<td><span>
                <#if user.userHeight?? >${user.userHeight}<#else>无</#if></span>
			</td>
		</tr>
		<tr>
			<td>体重：</td>
			<td><span>
                <#if user.userWeight??>${user.userWeight}<#else>无</#if></span>
			</td>
		</tr>
	</table>

	<br/>
	<h3 class="text-info">联系方式</h3>
	<table class="table table-hover">
		<tr>
			<td>邮箱：</td>
			<td>
                <#if user.userEmail??>${user.userEmail}<#else>无</#if></span>
			</td>
		</tr>
		<tr>
			<td>手机号：</td>
			<td><span>
                <#if user.userPhone??>${user.userPhone}<#else>无</#if></span>
			</td>
		</tr>
	</table>
	<br/>
	<h3 class="text-info">帐号信息</h3>
	<table class="table table-hover">
		<tr>
			<td>财富值：</td>
			<td><span>
                <#if user.userTreasure??>${user.userTreasure}<#else>无</#if></span>
			</td>
		</tr>
	</table>
<#else>
	<div style="text-align: center">
		<h4 style="padding-top: 80px">不存在用户 </h4>
	</div>
</#if>

</div>


</body>
</html>
