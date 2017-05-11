<div class="row">
<div class="span12">
<#if online?? || offline??>
    <#if online??>
		<h4 class="text-info"><@spring.message "web.room.live"/></h4>
        <#list online as room>
			<div class="col-lg-3">
                <#include  'room-item-component.ftl'>
			</div>
        </#list>
    </#if>
</div>
</div>
<div class="row">
<div class="span12">
    <#if offline??>
		<h4 class="text-primary"><@spring.message "web.room.rest"/></h4>
        <#list offline as room>
			<div class="col-lg-3">
                <#include  'room-item-component.ftl'>
			</div>
        </#list>
    </#if>
<#else>
	<h4 class="text-primary"><@spring.message "web.subscribe.none"/></h4>
</#if>
	<div hidden>
		<form action="${nginx_server}/${application_name}/room" method="post">
			<input type="text" id="stream_key" name="stream_key"/>
			<input type="submit" id="submit"/>
		</form>
	</div>
</div>
</div>
