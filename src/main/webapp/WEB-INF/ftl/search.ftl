<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title><@spring.message "web.search.result"/></title>
	<script src="/js/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
	<script src="/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/css/base.css">
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="room_list_container">
<#if fuzzyUserName ??>
	<h4><@spring.message "web.search.anchor"/>:</h4>
    <#list fuzzyUserName as room>
		<#include  'room-item-component.ftl'>
    </#list>
</#if>

<#if fuzzyRoomName ??>
	<h4><@spring.message "web.search.room"/>:</h4>
    <#list fuzzyRoomName as room>
		<#include  'room-item-component.ftl'>
    </#list>
<#else>
	<h4><@spring.message "web.search.result.none"/></h4>
</#if>
</div>
<div hidden>
	<form action="${nginx_serverip}/${application_name}/room" method="post">
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
			$("#room_container").css("margin-left", "100px");
		} else if (event.type == "boxzoomout") {
			$("#room_container").css("margin-left", "260px");
		}
	})

</script>

</body>
</html>
