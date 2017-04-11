<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
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

		#user_info_container {
			margin-left: 250px;
			padding: 5px;
			/*background-color: blanchedalmond;*/
			position: relative;
			height: 100%;
		}

		/*#user_info_box {*/
		/*position: relative;*/
		/*margin: 30px 15px;*/
		/*background-color: #ffffff;*/
		/*min-height: 93%;*/
		/*box-shadow: 0 0 15px 1px #858684;*/
		/*}*/
		/**/
		/*.user_info_box_item {*/
		/*padding: 20px 30px;*/
		/*}*/
		/**/
		/*input {*/
		/*font-size: 10px;*/
		/*}*/

	</style>
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
	<script src="${nginx_server_ip}/bootstrap/js/bootstrap.js"></script>
	<link rel="stylesheet" href="${nginx_server_ip}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${nginx_server_ip}/bootstrap/css/bootstrap.min.css">
</head>
<body>


<#include  'menu-navigation.ftl'>

<div id="user_info_container" class="container-fluid">

	<div id="user_info_box" class="row">
    <#if user == "anonymousUser">
		<div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4">
        <#--<h4 onload="$('#login_btn').trigger('click')">please login</h4>-->
			<span>asdf</span>
		</div>
    </#if>

    <#if user != "anonymousUser">
		<div class="" id="user_person_info">
            <#if user.userName ??>
				<div id="user_info_username">
					<label>昵称：</label>
					<span>${user.userName}</span>
				</div>
            </#if>
		</div>
		<div class="user_info_box_item" id="user_contact_info">
		</div>
    </#if>

	</div>

</div>

<script>

</script>

</body>
</html>
