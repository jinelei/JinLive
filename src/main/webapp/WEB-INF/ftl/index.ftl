<html>
<head>
	<title>freemark index</title>
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
		}

		.item_content {
			width: 300px;
			height: 170px;
			display: inline-block;
			background-color: darkslategrey;
		}

		.item_title {
			text-align: center;
			font-size: 15px;;
			margin: 0;
		}
        .item_info{
	        width: 300px;
	        background-color: #727670;
		}

	</style>
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
	<script src="${nginx_server_ip}/js/sockjs.min.js"></script>
	<script src="${nginx_server_ip}/js/stomp.js"></script>
</head>
<body>


<div id="header">
	<h2>FreeMarker Spring MVC Hello World</h2>
</div>
<#include  'menu-navigation.ftl'>
<div id="room_list_container">
<#list rooms as room>
	<div class="item" id="${room.streamKey}">
		<div class="item_content">
            <#if room.roomScreenshot ?? >
            <#--<img src="${nginx_server_ip}/images/default-screenshot.png">-->
				<h2>asdf</h2>
            <#else>
				<img src="${nginx_server_ip}/images/default-screenshot.png">
            </#if>
		</div>
		<div class="item_info">
			<p class="item_title"> ${room.roomName}</p>
		</div>
	</div>
</#list>
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

</script>

</body>
</html>
