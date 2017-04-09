<html>
<head>
	<title>search result</title>
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<style>
		body {
			background-color: #d4d4d4;
		}

		#room_list_container {
			margin-left: 250px;
			padding: 5px;
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
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
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
			$("#room_list_container").css("margin-left", "100px");
		} else if (event.type == "boxzoomout") {
			$("#room_list_container").css("margin-left", "260px");
		}
	})

</script>

</body>
</html>
