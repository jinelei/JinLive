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

<#--#room_list_container {-->
<#--margin-left: 250px;-->
<#--padding: 5px;-->
<#--}-->

	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	        crossorigin="anonymous"></script>
	<style>
		* {
			padding: 0;
			margin: 0;
		}

		#template_container {
			margin-left: 330px;
		}

		.item {
			width: 300px;
			display: inline-block;
			background-color: white;
			box-shadow: 0px 0px 6px 3px #4c4948;
			margin: 4px;
			position: relative;
			transition: all 550ms;
		}

		.item_screenshot {
			width: 300px;
			height: 170px;
			display: inline-block;
			background-color: darkslategrey;
		}

		.item_content_mask_layer {
			width: 300px;;
			height: 170px;
			position: absolute;
			z-index: 1000;
			opacity: 0;
			transition: background 0.9s;
		}

		.item_content_mask_layer_img {
			position: absolute;
			top: 50%;
			left: 50%;
			margin-left: -32px;
			margin-top: -32px;
			opacity: 0;
			transition: all 0.5s;
		}

		.item:hover .item_content_mask_layer {
			background: black;
			opacity: 0.6;
		}

		.item:hover .item_content_mask_layer_img {
			opacity: 0.5;
			transform: scale(1.5, 1.5);
		}

		.item:hover .item_content_mask_layer_img {
			display: block;
			position: absolute;
			top: 50%;
			left: 50%;
			margin-left: -32px;
			margin-top: -32px;
			opacity: 1;
			/*transition: all ease-out 250ms;*/
		}

		.item_info {
			width: 300px;
			height: 50px;
			background-color: #dddedb;
			position: relative;
		}

		.item_info_room_name {
			text-align: center;
			font-size: 15px;;
			margin: 0;
			padding: 3px 5px;
			position: relative;
		}

		.item_info_user_name {
			background: url(http://127.0.0.1/images/anchors.png) 0 3px no-repeat;
			text-align: left;
			font-size: 12px;;
			padding: 1px 3px 1px 14px;
			margin: 0;
			position: absolute;
			left: 5px;
			top: 25px;
		}

		.item_info_room_status {
			position: absolute;
			top: 50px;
			right: 1px;
			background-color: #295680;
			padding: 3px 5px;
			box-shadow: 0px 0px 3px 2px #0e4127;
			color: white;
		}
	</style>
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="room_list_container">
<#if byCategoryId ??>
	<h4>${categoryName}</h4>
    <#list byCategoryId as room>
		<div class="item" id="${room.streamKey}">
			<div class="item_content_mask_layer">
				<img class="item_content_mask_layer_img" src="${nginx_server_ip}/images/play-button.png"/>
			</div>
			<div class="item_screenshot">
                <#if room.roomScreenshot ?? >
					<h2>asdf</h2>
                <#else>
					<img src="${nginx_server_ip}/images/default-screenshot.png">
                </#if>
			</div>
			<div class="item_info_room_status">
                <#if  room.roomStatus == 1 >
					<span>Live</span>
                <#else>
					<span>Rest</span>
                </#if>
			</div>
			<div class="item_info">
				<span class="item_info_room_name"> ${room.roomName}</span>
				<span class="item_info_user_name"> ${room.userName}</span>
			</div>
		</div>
    </#list>
</#if>
<#if byOnline ??>
	<h4>Online</h4>
    <#list byOnline as room>
		<div class="item" id="${room.streamKey}">
			<div class="item_content_mask_layer">
				<img class="item_content_mask_layer_img" src="${nginx_server_ip}/images/play-button.png"/>
			</div>
			<div class="item_screenshot">
                <#if room.roomScreenshot ?? >
					<h2>asdf</h2>
                <#else>
					<img src="${nginx_server_ip}/images/default-screenshot.png">
                </#if>
			</div>
			<div class="item_info_room_status">
                <#if  room.roomStatus == 1 >
					<span>Live</span>
                <#else>
					<span>Rest</span>
                </#if>
			</div>
			<div class="item_info">
				<span class="item_info_room_name"> ${room.roomName}</span>
				<span class="item_info_user_name"> ${room.userName}</span>
			</div>
		</div>
    </#list>
</#if>

</div>
<div hidden>
	<form action="${tomcat_proxy_server_ip}/${application_name}/room" method="post">
		<input type="text" id="stream_key" name="stream_key"/>
		<input type="submit" id="submit"/>
	</form>
</div>

<script>

	//	bind click event
	$(".item").on("click", function () {
		var id = $(this).attr("id");
		$("#stream_key").val(id);
		$("#submit").click();
	})

	$("#side_box").on("boxzoomin boxzoomout", function (event) {
		if (event.type == "boxzoomin") {
			$("#template_container").css("margin-left", "100px");
		} else if (event.type == "boxzoomout") {
			$("#template_container").css("margin-left", "260px");
		}
	})

</script>

</body>
</html>
