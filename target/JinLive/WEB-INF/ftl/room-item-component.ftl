<div class="item" id="${room.streamKey}">
	<a href="${nginx_server}/${application_name}/room/${room.roomId}">
		<div class="item_content_mask_layer">
			<img class="item_content_mask_layer_img" src="/images/play-button.png"/>
		</div>
		<div class="item_screenshot">
        <#if room.roomScreenshot ?? >
			<img width="300" height="170" src="${room.roomScreenshot}">
        <#else>
			<img width="300" height="170" src="/images/default-screenshot.png">
        </#if>
		</div>
		<div class="item_info_room_status">
        <#if  room.roomStatus == 1 >
			<span>Live</span>
        <#else>
			<span>Rest</span>
        </#if>
		</div>
	</a>
	<div class="item_info">
		<span class="item_info_room_name"> ${room.roomName}</span>
		<span class="item_info_user_name"> ${room.userName}</span>
	</div>
</div>
