<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title><@spring.message "web.home"/></title>
	<script src="/js/jquery-3.2.0.min.js"></script>
	<#--<link rel="stylesheet" href="/css/bootstrap.min.css">-->
	<#--<link rel="stylesheet" href="/css/bootstrap-theme.min.css">-->
	<#--<script src="/js/bootstrap.min.js"></script>-->
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="/css/base.css">
</head>
<body>

<#include  'menu-navigation.ftl'>

<div class="container-fluid" id="index_container">
	<div class="row-fluid">
		<div class="span12">

		<#list rooms as room>
			<div class="col-lg-3">
				<#include  'room-item-component.ftl'>
			</div>
		</#list>

		</div>
	</div>
</div>

<script>
//		bind click event
	$(".item").on("click", function () {
		$(this).children("a").trigger("click");
	})

	$("#menu_container").on("boxzoomin boxzoomout", function (event) {
		if (event.type == "boxzoomin") {
			$("#index_container").css("margin-left", "100px");
		} else if (event.type == "boxzoomout") {
			$("#index_container").css("margin-left", "330px");
		}
	})

</script>

</body>
</html>
