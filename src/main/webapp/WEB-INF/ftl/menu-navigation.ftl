<#--user login modal-->
<div class="modal fade" id="user_modal" tabindex="-1" role="dialog" aria-labelledby="user_modal_label">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
						aria-hidden="true">&times;</span></button>
				<h4 class="modal-title login" id="user_modal_label">User Login</h4>
				<h4 class="modal-title logout" id="user_modal_label">User Logout</h4>
				<h4 class="modal-title register" id="user_modal_label">User Register</h4>
			</div>
			<div class="modal-body">
				<h4 class="logout text-primary">Confirm Logout</h4>
				<form class="register">
					<div class="form-group">
						<label for="modal_register_user_name" id="modal_register_user_name_label">Username:</label>
						<input type="text" class="form-control" id="modal_register_user_name" placeholder="Username">
					</div>
					<div class="form-group">
						<label for="modal_register_user_password"
						       id="modal_register_user_password_label">Password:</label>
						<input type="password" class="form-control" id="modal_register_user_password"
						       placeholder="Password">
					</div>
					<div class="form-group">
						<label for="modal_register_user_password1"
						       id="modal_register_user_password1_label">Password:</label>
						<input type="password" class="form-control" id="modal_register_user_password1"
						       placeholder="Password Again">
					</div>
					<div class="form-group">
						<label for="modal_register_user_phone" id="modal_register_user_phone_label">Phone:</label>
						<input type="text" maxlength='11' class="form-control" id="modal_register_user_phone"
						       placeholder="Phone">
					</div>
					<div class="form-group">
						<label for="modal_register_user_age" id="modal_register_user_age_label">Age:</label>
						<input type="number" class="form-control" id="modal_register_user_age"
						       placeholder="Age">
					</div>
					<div class="form-group">
						<label for="modal_register_user_sex" id="modal_register_user_sex_label">Sex:</label>
						<select class="form-control" id="modal_register_user_sex">
							<option>screct</option>
							<option>man</option>
							<option>woman</option>
						</select>
					</div>
				</form>
				<form class="login">
					<div class="form-group">
						<label for="modal_user_name">Username:</label>
						<input type="text" class="form-control" id="modal_login_user_name" placeholder="Username">
					</div>
					<div class="form-group">
						<label for="modal_user_password">Password:</label>
						<input type="password" class="form-control" id="modal_login_user_password"
						       placeholder="Password">
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
				<button type="button" class="btn btn-primary login" id="user_login_submit" onclick="userLoginSubmit">
					Login
				</button>
				<button type="button" class="btn btn-primary logout" id="user_logout_submit">Logout</button>
				<button type="button" class="btn btn-primary register" id="user_register_submit">Register</button>
			</div>
		</div>
	</div>
</div>
<#assign security=JspTaglibs["/WEB-INF/tlds/security.tld"]/>
<style>
	#menu_container {
		position: fixed;
		width: 300px;
		top: 0;
		left: 0;
		bottom: 0;
		/*background-color: #0e4127;*/
		background-color: #dee1d9;
		/*border: dashed 1px red;*/
	}

	#collapsing_menu_btn {
		width: 14px;
		height: 120px;
		position: fixed;
		top: 40%;
		left: 300px;
		background: url(http://192.168.31.169/images/collapsing.png) no-repeat;
		background-position: -30px 0;
	}

	#icon_box > img {
		position: relative;
		top: 13px;
		left: 50%;
		margin-left: -25px;
		width: 50px;
		margin-bottom: 40px;
		/*border: dashed 1px red;*/
	}

	.list-group > span {
		font-size: 20px;
		/*color: gray;*/
		/*border: dashed 1px red;*/
	}

	.category-name-item {
		width: 40%;
		height: 27px;
		overflow: hidden;
		padding: 5px 1px;
		background: #262b29;
		font-size: 13px;
		color: white;
		margin: 5px;
		display: inline-block;
		text-align: center;
		transition: all 0.5s;
		/*border: dashed 1px red;*/

	}

	.category-name-item:hover {
		background-color: #76171e;
	}

	#user_box {
		position: absolute;
		bottom: 0;
		right: 0;
		left: 0;
		height: 80px;
		background-color: #525b57;
	}

	.user-action-item {
		color: white;
		padding: 4px 10px;
		margin: 4px 10px;
		background-color: #346b76;
		border: solid 1px #52aabb;
		border-radius: 4px;
		display: inline-block;
		transition: all 200ms;
		cursor: pointer;
	}

	.user-action-item:hover {
		background-color: #183237;
		border: solid 1px #2e606a;
	}

	#userinfo_and_logout_box, #login_and_register_box {
		position: relative;
		margin: 20px 0 0 0;
	}

	#userinfo_and_logout_box div:last-child, #login_and_register_box div:last-child {
		position: absolute;
		top: 20%;
		right: 20%;
		/*border: dashed 1px blue;*/
	}

	#userinfo_and_logout_box div:first-child, #login_and_register_box div:first-child {
		position: absolute;
		top: 20%;
		left: 20%;
		/*border: dashed 1px yellow;*/
	}

	.side-menu-mini {
		display: none;
		width: 50px;
		height: 50px;
		margin: 30px auto;
		text-align: center;
		font-size: 18px;
		transition: all 0.5s;
	}

	.side-menu-mini:hover {
		background: rgba(106, 108, 111, 0.99);
	}

</style>

</div>
<div class="container-fluid side-container-open" id="menu_container">
<#--logo box-->
	<div class="row-fluid">
		<div class="span12">
			<div id="icon_box">
				<img onclick="reloadIndex()" class="img-circle" src="/images/pacman.png"/>
			</div>
		</div>
	</div>
<#--search box-->
	<div class="side-open row-fluid">
		<div class="span12">
			<div class="input-group">
				<input id="search_input" type="text" class="form-control" name="search_key"
				       placeholder="Search Room/Anchor" aria-describedby="basic-addon1">
				<span id="search_btn" class="glyphicon glyphicon-search input-group-addon" aria-hidden="true"></span>
			</div>
		</div>
	</div>
<#--seapartor bar-->
	<div id="div_separator2" class="side-open menu-toggle-switch"
	     style="margin: 20px auto;width: 100%; border-bottom: solid 1px darkgrey"></div>
	<ul id="category_list" class="side-open row-fluid">
	</ul>
<#--side box close display-->
	<div class="side-close row ">
		<div id="category_all" class="side-close span12 side-menu-mini">
			<img width="50px" height="50px" src="/images/computer.png"/>
		</div>
		<div id="category_category" class="side-close span12 side-menu-mini">
			<img width="50px" height="50px" src="/images/menu.png"/>
		</div>
		<div class="side-close side-menu-mini span12">
			<img width="50px" height="50px" src="/images/computer.png"/>
		</div>
	</div>
<#--category list-->
	<div class="side-open row-fluid">
		<div class="span12">
		</div>
	</div>
	<div id="user_box">
    <@security.authorize access="hasAnyRole('USER')">
		<div id="userinfo_and_logout_box">
            <@security.authentication property="principal" var="user"/>
			<div class="user-action-item side-open">
				<a id="user_info_btn" href="/live/user/info"> ${user.userName} </a>
			</div>
			<div class="side-close" style="display: none;padding: 0 8px;">
				<a id="user_info_btn" href="/live/user/info">
					<img width="50px" height="50px" src="/images/computer.png"/>
				</a>
			</div>
			<div class="user-action-item side-open" data-whatever="logout" data-toggle="modal" data-target="#user_modal"
			     role="button">Logout
			</div>
		</div>
    </@security.authorize>
    <@security.authorize access="!hasAnyRole('USER')">
		<div id="login_and_register_box">
			<div id="user_login_btn" class="user-action-item side-open" data-whatever="login" data-toggle="modal" data-target="#user_modal"
			     role="button">Login
			</div>
			<div class="side-close" style="display: none;color: #fff;">
				<div data-whatever="login" data-toggle="modal" data-target="#user_modal" role="button">Login</div>
			</div>
			<div class="user-action-item side-open" data-whatever="register" data-toggle="modal"
			     data-target="#user_modal"
			     role="button">Register
			</div>
		</div>
    </@security.authorize>

    <#--侧边栏开关-->
		<a id="collapsing_menu_btn" class="collapsing-menu-btn-open"></a>

	</div>
</div>

<#--<script src="/js/sockjs.min.js"></script>-->
<#--<script src="/js/stomp.js"></script>-->
<script type="text/javascript">


	//	handle search event
	$("#search_btn").on('click', searchSubmit);
	$("#user_login_submit").on('click', userLoginSubmit);
	$("#user_logout_submit").on('click', userLogoutSubmit);
	$("#user_register_submit").on('click', userRegisterSubmit);
	$("#user_modal").on('show.bs.modal', modalShowAction);
	$("#modal_register_user_password1").on('blur', checkPasswordConformity);
	$("#modal_login_user_password,#modal_register_user_password").on('blur', checkPassword);
	$("#modal_login_user_name,#modal_register_user_name").on('blur', checkUsername);
	$("#modal_register_user_phone").on('blur', checkPhoneNumber);
	$("#collapsing_menu_btn").on("mouseenter mouseout", MenuMouseOverAction);
	$("#collapsing_menu_btn").on('click', MenuCollapsingBtnToggle);

	//	functions
	function checkUsername() {
		var name = $(this).val();
		console.log(name);
		if ($(this) == $("#modal_register_user_name"))
			requestUsernameIsExist(name);
		if (name == "") {
			errorShowController(this, 1, "Not be empty");
			inputShake(this);
		} else if (!(/^[a-z][a-z0-9_]{5,18}$/.test(name))) {
			errorShowController(this, 1, "Consist of character,number and underline, length 6-18, start with character");
			inputShake(this);
		} else {
			errorShowController(this, 0, "Illegal phone number");
		}
	}
	function checkPasswordConformity() {
		var password = $("#modal_register_user_password").val();
		var password1 = $("#modal_register_user_password1").val();
		if (password != password1 || password1 == "") {
			errorShowController(this, 1, "Two passwords are not consistent");
			inputShake(this);
		} else {
			errorShowController(this, 0, "Not be empty");
		}
	}
	function checkPhoneNumber() {
		var phone = $(this).val();
		console.log(phone);
		if (phone == "") {
			errorShowController(this, 1, "Not be empty");
			inputShake(this);
		} else if (!(/^1(3|4|5|7|8)\d{9}$/.test(phone))) {
			errorShowController(this, 1, "Illegal phone number");
			inputShake(this);
		} else {
			errorShowController(this, 0, "Illegal phone number");
		}
	}
	function checkPassword() {
//		console.log($(this).val());
		if ($(this).val() == "") {
			errorShowController(this, 1, "Not be empty");
			inputShake(this);
		} else if (!(/^[a-z0-9]{6,18}$/.test($(this).val()))) {
			errorShowController(this, 1, "Length must between 6 and 18");
			inputShake(this);
		}
		else {
			errorShowController(this, 0, "Not be empty");
		}
	}

	function errorShowController(inputEle, status, errorMsg) {
		var str = $(inputEle).prev('label').text();
		var preStr = str.substr(0, str.indexOf(':') + 1);
		if (status == 1) {
			$(inputEle).parent(".form-group").addClass("has-error");
			$(inputEle).prev('label').addClass("text-danger");
			$(inputEle).prev('label').text(preStr + errorMsg);
			inputShake($(inputEle));
		}
		else {
			$(inputEle).parent(".form-group").removeClass("has-error");
			$(inputEle).prev('label').addClass("text-danger");
			$(inputEle).prev('label').removeClass("text-danger");
			$(inputEle).prev('label').text(preStr);
		}
	}
	function inputShake(inputEle) {
		$(inputEle).stop().animate({"margin-left": "-10px"}, 30).animate({"margin-left": "10px"}, 30)
				.animate({"margin-left": "-10px"}, 30).animate({"margin-left": "0px"}, 30);
	}

	function userRegisterSubmit() {
		var password = $("#modal_register_user_password").val();
		var username = $("#modal_register_user_name").val();
		var phone = $("#modal_register_user_phone").val();
		var age = $("#modal_register_user_age").val();
		var sex = $("#modal_register_user_sex option:selected").index();
		$(".register > .form-group > input").trigger('blur');
		if ($(".register>.has-error").length == 0) {
			$.post("/live/user/registerAjax", {
				username: username,
				password: password,
				phone: phone,
				sex: sex,
				age: age
			}, function (result) {
				var res = JSON.parse(result);
				console.log(res.status);
				if (res.status == 0) {
					$("#user_modal").modal('hide');
				} else {
//					    USER_NOT_EXIST = "0"; USER_NOT_UNIQUE = "1"; USER_WAS_EXIST = "2";
					if (res.errorCode == 2) {
						errorShowController($("#modal_register_user_name"), 1, "Already exist");
						inputShake($("#modal_register_user_name"));
					} else {
						errorShowController($("#modal_register_user_name"), 1, "Unknow error");
						inputShake($("#modal_register_user_name"));
					}
				}
			});
		}
	}
	function userLogoutSubmit() {
		console.log("logout");
		$.get("/live/logout", function (data, status) {
			if (status == "success") {
				location.reload(false);
			}
		});
	}
	function userLoginSubmit() {
		var username = $("#modal_login_user_name").val();
		var password = $("#modal_login_user_password").val();
		$(".login> .form-group > input").trigger('blur');
		if ($(".login>.has-error").length == 0) {
			if (username != null && password != null) {
				$.post("/live/user/loginAjax", {username: username, password: password},
						function (result) {
							var res = JSON.parse(result);
							if (res.status == 0) {
								$("#login_box").fadeOut(200);
								location.reload(false);
							} else {
								alert("login error")
							}
						}
				)
			} else {
				alert("username/password not be null");
			}
		}
	}

	//	load category data
	function requestUsernameIsExist(name) {
		$.get("/live/user/exist/name/" + name, function (data) {
			var res = JSON.parse(data);
			console.log(res);
			errorShowController($("#modal_register_user_name"), res.status, "User already exist");
		});
	}
	$.get("/live/search/category", processCategoryData);

	function processCategoryData(data) {
		var tmp = JSON.parse(data);
		$.each(tmp.array, function (key, value) {
			var row_fluid_div = $("<div class='list-group'></div>").appendTo($("#category_list"));
			$("<span class='list-group-item text-primary'> " + value.tag.tagName.tagName + "</span>").appendTo($(row_fluid_div));
			var item_tag_category = $("<div class='list-group-item'></div>").appendTo($(row_fluid_div));
			$.each(value.category.categoryArray, function (k, v) {
				var t = JSON.parse(v);
				var category_item = $("<div class='category-name-item' id='" + t.categoryId + "'>" + t.categoryName + "</div>").appendTo($(item_tag_category));
				$(category_item).on('click', function () {
					var category_id = $(this).attr("id");
					window.location.href = "/live/category/cid/" + category_id;
				})
			})
		})
	}
	function searchSubmit() {
		var key = $("#search_input").val();
		if (key != "") {
			location.href = "/live/search/key/" + key;
		}

	}
	function reloadIndex() {
		location.href = "/live/index";
	}
	function modalShowAction(event) {
		var button = $(event.relatedTarget);
		var recipient = button.data('whatever');
		var modal = $(this);
		if (recipient == "login") {
			modal.find('.logout').hide();
			modal.find('.register').hide();
			modal.find('.login').show();
		} else if (recipient == "logout") {
			modal.find('.logout').show();
			modal.find('.register').hide();
			modal.find('.login').hide();
		} else if (recipient == "register") {
			modal.find('.logout').hide();
			modal.find('.register').show();
			modal.find('.login').hide();
		}
	}
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
//		$(".menu-toggle-switch").toggle();
		if ($("#menu_container").hasClass("side-container-open")) {
			$(".side-open").hide();
			$(".side-close").show();
			$("#collapsing_menu_btn").animate({left: '69px'}, 200);
			$("#menu_container").animate({width: "70px"}, 200, function () {
				$("#menu_container").trigger("boxzoomin");
			});
		} else {
			$(".side-open").show();
			$(".side-close").hide();
			$("#collapsing_menu_btn").animate({left: '300px'}, 200);
			$("#menu_container").animate({width: "300px"}, 200, function () {
				$("#menu_container").trigger("boxzoomout");
			});
		}

		$("#menu_container").toggleClass("side-container-close");
		$("#menu_container").toggleClass("side-container-open");
	}

</script>
