<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Access-Control-Allow-Origin" content="*"/>
	<title><#if categoryName ??>${categoryName}</#if></title>
	<link rel="stylesheet" href="/css/base.css">
	<script src="/js/jquery-3.2.0.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
</head>
<body>

<#include  'menu-navigation.ftl'>
<div id="room_container">
<#if byCategoryId ??>
	<h4>${categoryName}</h4>
    <#list byCategoryId as room>
        <#include  'room-item-component.ftl'>
    </#list>
</#if>
<#if byOnline ??>
	<h4>Online</h4>
    <#list byOnline as room>
        <#include  'room-item-component.ftl'>
    </#list>
</#if>

</div>


<script src="/js/category.js"></script>

</body>
</html>
