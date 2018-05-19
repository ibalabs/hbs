<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />


<header class="navbar navbar-default navbar-static-top">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">
			<img src="${pageContext.request.contextPath}/resources/images/logo.png">
		</a>
	</div>
	<div class="navbar-collapse collapse">
		<ul class="nav navbar-right">
			<li class="dropdown current-user"><a href
				class="dropdown-toggle" data-toggle="dropdown"> <span
					class="username">HBS Administrator <i class="ti-angle-down"></i></span>
			</a>
				<ul class="dropdown-menu dropdown-dark">
					<li><a href="login.html"> Log Out </a></li>
				</ul></li>
		</ul>
		<!-- start: MENU TOGGLER FOR MOBILE DEVICES -->
		<div class="close-handle visible-xs-block menu-toggler"
			data-toggle="collapse" href=".navbar-collapse">
			<div class="arrow-left"></div>
			<div class="arrow-right"></div>
		</div>
	</div>
</header>
