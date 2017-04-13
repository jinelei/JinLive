<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title>Demo: play HLS video</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	      integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	      integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"/>
	<script src="${nginx_server_ip}/js/stomp.js"></script>
	<script src="${nginx_server_ip}/js/sockjs.min.js"></script>
	<script src="${nginx_server_ip}/js/jquery-3.2.0.min.js"></script>
	<script src="${nginx_server_ip}/js/player/cyberplayer.js"></script>
	<style>
		* {
			margin: 0;
			padding: 0;
		}

		body {
			background-color: #d4d4d4;
		}

		.main-contariner {
			position: relative;
			width: 100%;
			height: 100%;
		}

		#player_box {
			padding: 20px;
		}

		.player-box {
			overflow: hidden;
			z-index: 0;
			/*background-color: #C5820D;*/
			position: relative;
			right: 10px;
			margin-right: 370px;
			margin-left: 330px;
		}

	</style>
</head>
<body>
<div id="main_container" class="main-contariner">
<#include  "menu-navigation.ftl">
	<div id="player_box" class="player-box player-box-chat-open player-box-side-open">
		<div id="player"></div>
	</div>
<#include  "chat-box.ftl">
</div>

<script type="text/javascript">

	var live_stream_url = "${nginx_server_ip}" + "/stream/" + "${stream_key}" + "/index.m3u8";
	//		初始化播放器andwebsocket
	var player = cyberplayer("player").setup({
		width: 854,
		height: 480,
		stretching: "uniform",
		file: live_stream_url,
		autostart: true,
//		repeat: false,
//		rtmp: {
//			reconnecttime: 5, // rtmp直播的重连次数
//			bufferlength: 1 // 缓冲多少秒之后开始播放 默认1秒
//		},
		volume: 100,
		controls: true,
		ak: '7f266db038bd47eaaea92c43055153ab' // 公有云平台注册即可获得accessKey
	});
	//	resize
	playerBoxResize();

	//	bind enter event
	$("#menu_container").on('boxzoomin boxzoomout', function (event) {
		if (event.type == 'boxzoomin') {
			$('#player_box').animate({'margin-left': '100px'}, 200, playerBoxResize);
		} else if (event.type == 'boxzoomout') {
			$('#player_box').animate({'margin-left': '330px'}, 200, playerBoxResize);
		}
	})

	$("#chat_box").on('boxzoomin boxzoomout', function (event) {
		console.log(event.type);
		if (event.type == 'boxzoomin') {
			console.log("zoomin")
			$('#player_box').animate({'margin-right': '20px'}, 100, playerBoxResize);
		} else if (event.type == 'boxzoomout') {
			console.log("zoomout")
			$('#player_box').animate({'margin-right': '370px'}, 100, playerBoxResize);
		}
	});

	function playerBoxResize() {
		var wid = $("#player_box").width();
		var hei = wid / 16 * 8;
		player.resize(wid, hei);
	}

</script>
</body>
</html>
