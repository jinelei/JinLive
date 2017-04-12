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
						<input type="number" maxlength='11' class="form-control" id="modal_register_user_phone"
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
		border: dashed 1px red;
	}

	#icon_box > img {
		position: relative;
		top: 13px;
		left: 50%;
		margin-left: -25px;
		width: 50px;
		margin-bottom: 40px;
		border: dashed 1px red;
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
		border: dashed 1px red;

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
		border: dashed 1px blue;
	}

	#userinfo_and_logout_box div:first-child, #login_and_register_box div:first-child {
		position: absolute;
		top: 20%;
		left: 20%;
		border: dashed 1px yellow;
	}

	n
</style>

</div>
<div class="container-fluid" id="menu_container">
<#--logo box-->
	<div class="row-fluid">
		<div class="span12">
			<div id="icon_box">
				<img onclick="reloadIndex()" class="img-circle" src="${nginx_server_ip}/images/pacman.png"/>
			</div>
		</div>
	</div>
<#--search box-->
	<div class="row-fluid">
		<div class="span12">
			<div class="input-group">
				<input id="search_input" type="text" class="form-control" name="search_key"
				       placeholder="Search Room/Anchor" aria-describedby="basic-addon1">
				<span id="search_btn" class="glyphicon glyphicon-search input-group-addon" aria-hidden="true"></span>
			</div>
		</div>
	</div>
<#--seapartor bar-->
	<div id="div_separator2" class="menu-toggle-switch"
	     style="margin: 20px auto;width: 100%; border-bottom: solid 1px darkgrey"></div>
	<ul id="category_list" class="row-fluid">
	</ul>
<#--category list-->
	<div class="row-fluid">
		<div class="span12">
		</div>
	</div>
<div id="user_box">
<@security.authorize access="hasAnyRole('USER')">
	<div id="userinfo_and_logout_box">
		<div class="user-action-item">
            <@security.authentication property="principal" var="user"/>
			<a id="user_info_btn" href="/live/user/info"> ${user.userName} </a>
		</div>
    <#--<div class="user-action-item" id="logout_btn">logout</div>-->
		<div class="user-action-item" data-whatever="logout" data-toggle="modal" data-target="#user_modal"
		     role="button">Logout
		</div>
	</div>
</div>
</@security.authorize>
<@security.authorize access="!hasAnyRole('USER')">
	<div id="login_and_register_box">
		<div class="user-action-item" data-whatever="login" data-toggle="modal" data-target="#user_modal"
		     role="button">Login
		</div>
		<div class="user-action-item" data-whatever="register" data-toggle="modal" data-target="#user_modal"
		     role="button">Register
		</div>
	</div>
</@security.authorize>
</div>

</div>


<script type="text/javascript">

	//	load category data
	$.get("${tomcat_proxy_server_ip}/${application_name}/search/category", processCategoryData);


	//	handle search event
	$("#search_btn").on('click', searchSubmit);
	$("#user_login_submit").on('click', userLoginSubmit);
	$("#user_logout_submit").on('click', userLogoutSubmit);
	$("#user_register_submit").on('click', userRegisterSubmit);
	$("#user_modal").on('show.bs.modal', modalShowAction);
	$("#modal_register_user_password1").on('blur', checkPasswordConformity);
	$("#modal_login_user_name,#modal_login_user_password,#modal_register_user_name,#modal_register_user_password,#modal_register_user_phone").on('blur', checkInputEmpty);
	//	functions
	function checkPasswordConformity() {
		var password = $("#modal_register_user_password").val();
		var password1 = $("#modal_register_user_password1").val();
		if (password != password1 || password1 == "") {
			errorShowController(this, 1, "Two Passwords Are Not Consistent");
			inputShake(this);
		} else {
			errorShowController(this, 0, "Not Be Empty");
		}
	}
	function checkInputEmpty() {
//		console.log($(this).val());
		if ($(this).val() == "") {
			errorShowController(this, 1, "Not Be Empty");
			inputShake(this);
		} else {
			errorShowController(this, 0, "Not Be Empty");
		}
	}
	function userRegisterSubmit() {
		var password = $("#modal_register_user_password").val();
		var username = $("#modal_register_user_name").val();
		var phone = $("#modal_register_user_phone").val();
		var age = $("#modal_register_user_age").val();
		var sex = $("#modal_register_user_sex option:selected").index();
		$(".register > .form-group > input").trigger('blur');
		if ($(".register>.has-error").length == 0) {
			$.post("http://localhost/live/user/registerAjax", {
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
						errorShowController($("#modal_register_user_name"), 1, "Already Exist");
					} else {
						errorShowController($("#modal_register_user_name"), 1, "Unknow Error");
					}
				}
			});
		}
	}
	function errorShowController(inputEle, status, errorMsg) {
		var str = $(inputEle).prev('label').text();
		var preStr = str.substr(0, str.indexOf(':') + 1);
		if (status == 1) {
			$(inputEle).parent(".form-group").addClass("has-error");
			$(inputEle).prev('label').addClass("text-danger");
			$(inputEle).prev('label').text(preStr + errorMsg);
		}
		else {
			$(inputEle).parent(".form-group").removeClass("has-error");
			$(inputEle).prev('label').addClass("text-danger");
			$(inputEle).prev('label').removeClass("text-danger");
			$(inputEle).prev('label').text(preStr);
		}
		inputShake($(inputEle));
	}
	function inputShake(inputEle) {
		$(inputEle).stop().animate({"margin-left": "-10px"}, 30).animate({"margin-left": "10px"}, 30)
				.animate({"margin-left": "-10px"}, 30).animate({"margin-left": "0px"}, 30);
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
		if (username != null && password != null) {
			$.post("http://localhost/live/user/loginAjax", {username: username, password: password},
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
					window.location.href = "${tomcat_proxy_server_ip}/${application_name}/category/cid/" + category_id;
				})
			})
		})
	}
	function searchSubmit() {
		var key = $("#search_input").val();
		if (key != "") {
			location.href = "${tomcat_proxy_server_ip}/${application_name}/search/key/" + key;
		}

	}
	function reloadIndex() {
		location.href = "${tomcat_proxy_server_ip}/${application_name}/index";
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

</script>
