<html>
<head>
	<title>login</title>
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<style>
		* {
			padding: 0;
			margin: 0;
		}

		body {
			background-color: #d4d4d4;
		}

		#login_container {
			margin-left: 260px;
		}

	</style>
	<script src="/js/jquery-3.2.0.min.js"></script>
</head>
<body>


<#include  'menu-navigation.ftl'>

<div id="login_container">

<#if error??>
	<span>${error}</span>
</#if>
<#if msg??>
	<span>${msg}</span>
</#if>

	<#--<form id="login_form" name="f" action="${tomcat_proxy_server_ip}/${application_name}/login" method="POST">-->
    <form id="login_form" name="f" action="/perfrom_login" method="POST">
		<table>

			<tr>
				<td>User:</td>
				<td><input type="text" name="username" value=""/></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td>
					<input type="password" name="password" value=""/>
                <#if _scrf??>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </#if>
				</td>
			</tr>

			<tr>
				<td><input type="submit" value="S"/></td>
			</tr>

		</table>
	</form>

</div>

<script>

</script>

</body>
</html>
