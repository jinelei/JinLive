<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title><@spring.message 'web.subscribe'/></title>
	<script src="/js/jquery-3.2.0.min.js"></script>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
	<script src="/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/css/base.css">
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="subscribe_container">
    <#include 'room-list-component.ftl'>
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
