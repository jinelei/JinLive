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

</style>

<div id="side_box" class="side-box">
	<div id="side_menu" class="side-menu side-menu-open"></div>
	<a id="collapsing_menu_btn" class="collapsing-menu-btn-open"></a>
</div>

<script type="text/javascript">

	$("#collapsing_menu_btn").on("mouseenter mouseout", MenuMouseOverAction);
	$("#collapsing_menu_btn").on('click', MenuCollapsingBtnToggle);

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
//		切换动画
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

//		切换class
		$("#side_menu").toggleClass("side-menu-close");
		$("#side_menu").toggleClass("side-menu-open");
	}

</script>
