<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>freemark index</title>
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
<#--<script src="${nginx_server_ip}/bootstrap/js/bootstrap.min.js"></script>-->
<#--<link href="${nginx_server_ip}/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">-->
<#--<link href="${nginx_server_ip}/bootstrap/css/bootstra-theme.min.css" rel="stylesheet" media="screen"-->
<#--crossorigin="anonymous">-->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	        crossorigin="anonymous"></script>
	<style>
		#index_container {
			margin-left: 300px;
		}

		* {
			padding: 0;
			margin: 0;
		}
	</style>
</head>
<body>

<#include  'menu-navigation.ftl'>

<div class="container-fluid" id="index_container">
	<div class="row-fluid">
		<div class="span12">
			<div class="row-fluid">
				<div class="span6">
					asdf
				</div>
				<div class="span6">
				</div>
			</div>
		</div>
	</div>
</div>


<#--<div id="room_list_container container-fuild">-->
<#--<#list rooms as room>-->
<#--<div class="col-lg-3">-->
<#--<div class="item" id="${room.streamKey}">-->
<#--<div class="item_content_mask_layer">-->
<#--<img class="item_content_mask_layer_img" src="${nginx_server_ip}/images/play-button.png"/>-->
<#--</div>-->
<#--<div class="item_screenshot">-->
<#--<#if room.roomScreenshot ?? >-->
<#--<h2>asdf</h2>-->
<#--<#else>-->
<#--<img src="${nginx_server_ip}/images/default-screenshot.png">-->
<#--</#if>-->
<#--</div>-->
<#--<div class="item_info_room_status">-->
<#--<#if  room.roomStatus == 1 >-->
<#--<span>Live</span>-->
<#--<#else>-->
<#--<span>Rest</span>-->
<#--</#if>-->
<#--</div>-->
<#--<div class="item_info">-->
<#--<span class="item_info_room_name"> ${room.roomName}</span>-->
<#--<span class="item_info_user_name"> ${room.userName}</span>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--</#list>-->
<#--</div>-->
<#--<div hidden>-->
<#--<form action="${tomcat_proxy_server_ip}/${application_name}/room" method="post">-->
<#--<input type="text" id="stream_key" name="stream_key"/>-->
<#--<input type="submit" id="submit"/>-->
<#--</form>-->
<#--</div>-->

<script>

	//	bind click event
	$(".item").on("click", function () {
		var id = $(this).attr("id");
		$("#stream_key").val(id);
		$("#submit").click();
	})

	$("#side_box").on("boxzoomin boxzoomout", function (event) {
		if (event.type == "boxzoomin") {
			$("#room_list_container").css("margin-left", "100px");
		} else if (event.type == "boxzoomout") {
			$("#room_list_container").css("margin-left", "260px");
		}
	})

</script>

</body>
</html>
