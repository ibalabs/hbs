<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<title>Customers</title>
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
			<form id="ID_CUSTOMERS_FORM">
				<input type="hidden" id="ID_ACTION">
				<input type="hidden" id="ID_DB_ID">
				<div class="main-content">
					<div class="wrap-content container" id="container">
						<section id="page-title" class="padding-top-15 padding-bottom-15">
							<div class="row">
								<div class="col-sm-7">
									<h1 class="mainTitle">Customers</h1>
								</div>
							</div>
						</section>
						
						<!-- end: PAGE TITLE -->
						<!-- start: DYNAMIC TABLE -->
						<div class="container-fluid container-fullw bg-white">
							<div class="row">
								<div class="col-md-12">
									<div class="data-table-container">
										<div class="table-btn-container">
											<button type="button" class="btn btn-wide btn-primary" onclick="fnCreateCustomer();">
												<i class="ti-plus"></i> Add
											</button>
										</div>
										<table class="table table-striped table-bordered table-hover table-full-width" id="ID_CUSTOMER_DETAILS_TABLE">
											<thead>
												<tr>
													<th width="15%">Name</th>
													<th width="10%">Alias</th>
													<th width="15%">Address</th>
													<th width="10%">City</th>
													<th width="10%">Mobile</th>
													<th width="10%">Balance Amount</th>
													<th width="15%">Actions</th>
												</tr>
											</thead>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	
	<div id="ID_SAVE_CUSTOMER_MODEL" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add Customer</h4>
				</div>
				<div class="modal-body">
					<fieldset>
						<div class=""></div>
						<div class="form-group">
							<label> Customer Name <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<input type="text" placeholder="Customer Name" id="ID_CUSTOMER_NAME"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label>Alias <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<input type="text" placeholder="Alias" id="ID_CUSTOMER_ALIAS"
									class="form-control"></input>
							</div>
						</div>
						<div class="form-group">
							<label>Address <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<textarea  placeholder="Address" id="ID_CUSTOMER_ADDRESS"
									class="form-control"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label>City <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<input type="text" placeholder="City" id="ID_CUSTOMER_CITY"
									class="form-control"></input>
							</div>
						</div>
						<div class="form-group">
							<label>Mobile <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<input type="text" placeholder="Mobile" id="ID_CUSTOMER_MOBILE"
									class="form-control"></input>
							</div>
						</div>
						<div class="form-group">
							<label>Balance Amount <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<input type="text" placeholder="Balance Amount" id="ID_CUSTOMER_BAL_AMT"
									class="form-control"></input>
							</div>
						</div>
						<div class="form-group">
							<label>Description <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<input type="text" placeholder="Customer Description" id="ID_CUSTOMER_DESC"
									class="form-control"></input>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">
						Cancel</button>
					<button type="button" class="btn btn-primary"
						onclick="javascript:fnSaveCustomer();">Save</button>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
   		$(document).ready(function() {
			$(".loader").fadeOut("slow");
			fnFetchAllCustomerDetails();
		});
	</script>
	<script type="text/javascript">
		function fnCreateCustomer(){
			document.getElementById("ID_ACTION").value = "CREATE";
			document.getElementById("ID_CUSTOMER_NAME").value = "";
			document.getElementById("ID_CUSTOMER_DESC").value = "";
			document.getElementById("ID_CUSTOMER_BAL_AMT").value = "";
			document.getElementById("ID_CUSTOMER_MOBILE").value = "";
			document.getElementById("ID_CUSTOMER_CITY").value = "";
			document.getElementById("ID_CUSTOMER_ADDRESS").value = "";
			document.getElementById("ID_CUSTOMER_ALIAS").value = "";
			document.getElementById("ID_DB_ID").value = "";
			$('#ID_SAVE_CUSTOMER_MODEL').modal('show');
		}
	
		function fnSaveCustomer(){
			var custName = document.getElementById("ID_CUSTOMER_NAME").value;
			var custDesc = document.getElementById("ID_CUSTOMER_DESC").value;
			var balAmt = document.getElementById("ID_CUSTOMER_BAL_AMT").value;
			var mobile = document.getElementById("ID_CUSTOMER_MOBILE").value;
			var city = document.getElementById("ID_CUSTOMER_CITY").value;
			var address = document.getElementById("ID_CUSTOMER_ADDRESS").value;
			var alias = document.getElementById("ID_CUSTOMER_ALIAS").value;
			var dbId = document.getElementById("ID_DB_ID").value;
			var action  = document.getElementById("ID_ACTION").value;
			$.ajax({
				cache 				: "false",
				type 				: "POST",
				dataType 			: "json",
				contentType 		: "application/json; charset=utf-8",
				data 				: '{"dbId":"' + dbId + '","address":"' + address + '","city":"' + city + '","alias":"' + alias + '","custName":"' + custName + '","custDesc":"' + custDesc + '","balAmt":"' + balAmt + '","mobile":"' + mobile + '","action":"' + action + '"}',
				url 				: "${pageContext.request.contextPath}/saveCustomerDetails.html",
				async				: false
			}).done(function(data) {
				if(JSON.stringify(data.status) == '"SUCCESS"') {
					$.notify({message: data.message },{type: 'success'});
				}else{
					$.notify({message: data.message },{type: 'warning'});
				}
			}).fail(function(jqxhr, textStatus, errorThrown) {
				alert("..jqxhr2.."+JSON.stringify(jqxhr));
			});
			$('#ID_SAVE_CUSTOMER_MODEL').modal('hide');
			fnFetchAllCustomerDetails();
		}
		
		function fnFetchAllCustomerDetails(){
    		$.ajax({
   			 	 cache		 	: "false",
  		         type        	: "POST",
  		       	 contentType	: "application/json; charset=utf-8",
  		       	 dataType    	: "json",
  		         url 			: "${pageContext.request.contextPath}/fetchAllCustomerDetails.html", 
  		         async		 	: false
	   	    }).done(function(data) {
	   	    	$("#ID_CUSTOMER_DETAILS_TABLE").dataTable().fnDestroy();
	            $('table#ID_CUSTOMER_DETAILS_TABLE TBODY').find("tr").remove();
	   	    	$.each(data.CUSTOMER_DETAILS,function(index, customerDetails){
	   	    			var id = customerDetails['id'];
	   	    			var custName = customerDetails['customerName'];
		    	 		$('table#ID_CUSTOMER_DETAILS_TABLE TBODY').append('<tr>'
		    			+'<td width="15%">'+customerDetails['customerName']+'</td>'
		    			+'<td width="10%">'+customerDetails['alias']+'</td>'
		    			+'<td width="15%">'+customerDetails['address']+'</td>'
		    			+'<td width="10%">'+customerDetails['city']+'</td>'
		    			+'<td width="10%">'+customerDetails['mobile']+'</td>'
		    			+'<td width="10%">'+customerDetails['balanceAmount']+'</td>'
		    			+'<td width="15%"><a class="btn btn-sm btn-primary" style="margin-right:5px;" onclick=fnEditCustomerDetails("'+ id +'");><i class="fa fa-pencil"></i> </a>'
                        +'<a class="btn btn-sm btn-red" onclick=fnDeteleCustomerDetails("'+ id +'","'+ custName +'"); style="margin-right:5px;"><i class="fa fa-trash-o"></i> </a></td></tr>');
    	    	  });
	   	    }).fail(function(jqXHR, textStatus, error) {
	   	    });
    		$('#ID_CUSTOMER_DETAILS_TABLE').dataTable({
    			"aoColumnDefs" : [{
    				"aTargets" : [0]
    			}],
    			"oLanguage" : {
    				"sLengthMenu" : "Show _MENU_ Rows",
    				"sSearch" : "",
    				"oPaginate" : {
    					"sPrevious" : "",
    					"sNext" : ""
    				}
    			},
    			"aaSorting" : [[1, 'asc']],
    			"aLengthMenu" : [[5, 10, 15, 20, -1], [5, 10, 15, 20, "All"]],
    			"iDisplayLength" : 5,
    		});
    		$('#ID_CUSTOMER_DETAILS_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
    		$('#ID_CUSTOMER_DETAILS_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
    		$('#ID_CUSTOMER_DETAILS_TABLE_wrapper .dataTables_length select').select2();
    	}
		
		function fnEditCustomerDetails(id, custName){
			$.ajax({
				cache 				: "false",
				type 				: "POST",
				dataType 			: "json",
				contentType 		: "application/json; charset=utf-8",
				data 				: '{"custName":"' + custName + '","dbId":"' + id + '","action":"UPDATE"}',
				url 				: "${pageContext.request.contextPath}/editCustomerDetails.html",
				async				: false
			}).done(function(data) {
				if(JSON.stringify(data.status) == '"SUCCESS"') {
					document.getElementById("ID_DB_ID").value = id;
					document.getElementById("ID_ACTION").value = "UPDATE";
					document.getElementById("ID_CUSTOMER_NAME").value = data.CUSTOMER_DETAILS.customerName;
					document.getElementById("ID_CUSTOMER_DESC").value = data.CUSTOMER_DETAILS.desciption;
					document.getElementById("ID_CUSTOMER_BAL_AMT").value = data.CUSTOMER_DETAILS.balanceAmount;
					document.getElementById("ID_CUSTOMER_MOBILE").value = data.CUSTOMER_DETAILS.mobile;
					document.getElementById("ID_CUSTOMER_CITY").value = data.CUSTOMER_DETAILS.city;
					document.getElementById("ID_CUSTOMER_ADDRESS").value = data.CUSTOMER_DETAILS.address;
					document.getElementById("ID_CUSTOMER_ALIAS").value = data.CUSTOMER_DETAILS.alias;
				}
			}).fail(function(jqxhr, textStatus, errorThrown) {
				alert("..jqxhr2.."+JSON.stringify(jqxhr));
			});
			$('#ID_SAVE_CUSTOMER_MODEL').modal('show');
		}
		
		function fnDeteleCustomerDetails(dbId, custName){
			$.ajax({
				cache 				: "false",
				type 				: "POST",
				dataType 			: "json",
				contentType 		: "application/json; charset=utf-8",
				data 				: '{"custName":"' + custName + '","dbId":"' + dbId + '"}',
				url 				: "${pageContext.request.contextPath}/deteleCustomerDetails.html",
				async				: false
			}).done(function(data) {
				if(JSON.stringify(data.status) == '"SUCCESS"') {
					$.notify({message: data.message },{type: 'success'});
				}else{
					$.notify({message: data.message },{type: 'warning'});
				}
			}).fail(function(jqxhr, textStatus, errorThrown) {
				alert("..jqxhr2.."+JSON.stringify(jqxhr));
			});
			$('#ID_SAVE_CUSTOMER_MODEL').modal('hide');
			fnFetchAllCustomerDetails();
		}
	</script>
</body>
</html>