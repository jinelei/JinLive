<html>
<head>
	<title>freemark index</title>
	<style>
		#content {
			width: 80%;
			background-color: darkgray;
			padding: 5px;
		}

		.item {
			width: 160px;
			height: 100px;
			display: inline-block;
			background-color: darkslategrey;
		}

		.item_content {
			width: 160px;
			height: 90px;
			display: inline-block;
			background-color: darkslategrey;
		}

		.item_title {
			text-align: center;
		}

	</style>
	<script src="js/jquery-3.2.0.min.js"></script>
	<script src="js/sockjs-0.3.min.js"></script>
	<script src="js/stomp.js"></script>
</head>
<body>
<div id="header">
	<h2>FreeMarker Spring MVC Hello World</h2>
</div>
<div id="content">
    <#list vodStreams as vodstream>
        <div class="item" id="${vodstream.name}">
            <div class="item_content">
            </div>
            <p class="item_title">
            ${vodstream.name}
            </p>
        </div>
    </#list>
    <#list liveStreams as livestream>
        <div class="item" id="${livestream.name}">
            <div class="item_content">
            </div>
            <p class="item_title">
            ${livestream.name}
            </p>
        </div>
    </#list>
</div>
<div hidden>
	<form action="/live/room" method="post">
		<input type="text" id="stream_id" name="stream_id"/>
		<input type="submit" id="submit"/>
	</form>
</div>

<script>

    $(".item").on("click",function () {
        var id = $(this).attr("id");
        $("#stream_id").val(id);
        $("#submit").click();
    })

</script>

</body>
</html>
