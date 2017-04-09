<style>
	.side-box {
		position: fixed;
		top: 0;
		bottom: 0;
		left: 0;
		/*background-color: #7E5005;*/
		width: 245px;
	}

	.side-menu {
		position: fixed;
		top: 0;
		bottom: 0;
		background-color: #3d403a;
		width: 230px;
	}

	#collapsing_menu_btn {
		width: 14px;
		height: 120px;
		position: fixed;
		top: 40%;
		left: 228px;
		background: url(http://192.168.31.169/images/collapsing.png) no-repeat;
		background-position: -30px 0;
	}

	#icon_box {
		width: 100%;
		height: 70px;
		position: relative;
	}

	#icon_box > img {
		position: absolute;
		top: 13px;
		left: 50%;
		margin-left: -32px;
		width: 50px;
		height: 50px;
	}

	.searchinput {
		width: 168px;
		float: left;
		color: #636365;
		/*font-family: arial;*/
		font-size: 10pt;
		vertical-align: middle;
		margin-left: 18px;
		margin-right: 5px;
		padding-left: 8px;
	}

	.tab_search {
		height: 30px;
	}

	.searchaction {
		width: 20px;
		float: left;
		height: 20px;
	}

	.menu-category-item {
		position: relative;
		padding: 3px;
		margin: 10px 3px;
	}

	.menu-category-item-title {
		font-size: 19px;
		color: gray;
		position: relative;
		left: -5px;
	}

	.menu-category-item-box {
		position: relative;
		margin-top: 10px;
		/*top:25px;*/
	}

	.menu-category-item-box-list {
		width: 40%;
		height: 20px;
		overflow: hidden;
		padding: 5px 1px;
		background: #262b29;
		font-size: 13px;
		color: white;
		margin: 5px;
		display: inline-block;
		text-align: center;
		transition: all 0.5s;
	}

	.menu-category-item-box-list:hover {
		background-color: #346b76;
	}

	.menu-mini {
		display: none;
		width: 60px;
		height: 70px;
		padding: 10px 1px;
		margin: 28px auto;
		text-align: center;
        font-size: 18px;
        transition:  all 0.5s;
	}

	.menu-mini:hover{
		background: rgba(106, 108, 111, 0.99);
	}

</style>

<div id="side_box" class="side-box">
	<div id="side_menu" class="side-menu side-menu-open">
		<div id="icon_box">
			<img src="${nginx_server_ip}/images/pacman.png"/>
		</div>
		<div id="search_box" class="menu-toggle-switch">
			<form action="${tomcat_proxy_server_ip}/${application_name}/search" method="post" name="search">
				<table border="0" align="center" cellpadding="0" cellspacing="0" class="tab_search">
					<tr>
						<td>
							<input type="text" name="q" title="Search" class="searchinput" id="searchinput"
							       onkeydown="if (event.keyCode==13) {}"
							       onblur="if(this.value=='')value='- Search Anchors/Rooms-';"
							       onfocus="if(this.value=='- Search Anchors/Rooms-')value='';"
							       value="- Search Anchors/Rooms-" size="10"/>
						</td>
						<td>
							<input type="image" width="21" height="20" class="searchaction"
							       onclick="if(document.forms['search'].searchinput.value=='- Search Anchors/Rooms-')document.forms['search'].searchinput.value='';"
							       alt="Search" src="${nginx_server_ip}/images/search.png" border="0" hspace="2"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="div_separator1" class="menu-toggle-switch"
		     style="margin: 20px auto;width: 80%; border-bottom: solid 1px darkgrey"></div>
		<div id="div_separator2" class="menu-toggle-switch"
		     style="margin: 20px auto;width: 80%; border-bottom: solid 1px darkgrey"></div>
		<div id="category_all" class="menu-toggle-switch menu-mini">
			<img width="50px" height="50px" src="${nginx_server_ip}/images/computer.png"/>
			<span>all</span>
		</div>
		<div id="category_category" class="menu-toggle-switch menu-mini">
			<img width="50px" height="50px" src="${nginx_server_ip}/images/menu.png"/>
			<span>category</span>
		</div>
		<div class="menu-toggle-switch menu-mini">
			<img width="50px" height="50px" src="${nginx_server_ip}/images/computer.png"/>
			<span>robot</span>
		</div>
		<div class="menu-toggle-switch" id="user_box"></div>
	</div>
	<a id="collapsing_menu_btn" class="collapsing-menu-btn-open"></a>
</div>

<script type="text/javascript">

	$("#collapsing_menu_btn").on("mouseenter mouseout", MenuMouseOverAction);
	$("#collapsing_menu_btn").on('click', MenuCollapsingBtnToggle);
	$("#icon_box").on('click', function () {
		window.location.href = "${tomcat_proxy_server_ip}/${application_name}/index";
	});
	$("#category_all").on('click', function () {
		window.location.href = "${tomcat_proxy_server_ip}/${application_name}/index";
	})
	$("#category_category").on('click', function () {
		window.location.href = "${tomcat_proxy_server_ip}/${application_name}/index";
	})


	$.get("${tomcat_proxy_server_ip}/${application_name}/search", function (data) {
		var tmp = JSON.parse(data);
		$.each(tmp.array, function (key, value) {
			var item_tag = $("<div class='menu-category-item'></div>").appendTo($("#div_separator2"));
			$("<span class='menu-category-item-title'> " + value.tag.tagName.tagName + "</span>").appendTo($(item_tag));
			var item_tag_category = $("<div class='menu-category-item-box'></div>").appendTo($(item_tag));
			$.each(value.category.categoryArray, function (k, v) {
				var t = JSON.parse(v);
				var category_item = $("<div class='menu-category-item-box-list' id='" + t.categoryId + "'>" + t.categoryName + "</div>").appendTo($(item_tag_category));
				$(category_item).on('click', function () {
					var category_id = $(this).attr("id");
					window.location.href = "${tomcat_proxy_server_ip}/${application_name}/category/cid/" + category_id;
				})
			})
		})
	})

	function MenuMouseOverAction(event) {
		if (event.type == 'mouseenter') {
//			console.log("mouse enter action");
			if ($(this).hasClass('collapsing-menu-btn-open'))
				$(this).css('background-position-x', '-45px');
			else
				$(this).css('background-position-x', '-15px');
		} else if (event.type == 'mouseout') {
//			console.log("mouse out action");
			if ($(this).hasClass('collapsing-menu-btn-open'))
				$(this).css('background-position-x', '-30px');
			else
				$(this).css('background-position-x', '0px');
		}
	}
	function MenuCollapsingBtnToggle() {
		console.log("toggle btn click");
		$("#collapsing_menu_btn").toggleClass("collapsing-menu-btn-open");
		$("#collapsing_menu_btn").toggleClass("collapsing-menu-btn-close");
		$("#collapsing_menu_btn").trigger("mouseover");
		$(".menu-toggle-switch").toggle();
		if ($("#side_menu").hasClass("side-menu-open")) {
			$("#collapsing_menu_btn").animate({left: '69px'}, 200);
			$("#side_menu").animate({width: "70px"}, 200, function () {
				$("#side_box").trigger("boxzoomin");
			});
		} else {
			$("#collapsing_menu_btn").animate({left: '229px'}, 200);
			$("#side_menu").animate({width: "230px"}, 200, function () {
				$("#side_box").trigger("boxzoomout");
			});
		}

		$("#side_menu").toggleClass("side-menu-close");
		$("#side_menu").toggleClass("side-menu-open");
	}
</script>
