<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<title>Customer Wise</title>
<script type="text/javascript">
	jQuery(document).ready(function() {
		$(".loader").fadeOut("slow");
	});
</script>
</head>
<body>
	<div id="app">
		<jsp:include page="global_includes.jsp" />
		<div class="app-content">
			<jsp:include page="header.jsp" />
			<form id="ID_CUSTOMER_WISE_FORM">
				<div class="main-content">
					<div class="wrap-content container" id="container">
						<section id="page-title" class="padding-top-15 padding-bottom-15">
							<div class="row">
								<div class="col-sm-7">
									<h1 class="mainTitle">Customer Wise</h1>
								</div>
							</div>
						</section>
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>