<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<title>UoM</title>
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
			<form id="ID_UOM_FORM">
				<input type="hidden" id="ID_ACTION">
				<input type="hidden" id="ID_UOM_DB_ID">
				<div class="main-content">
					<div class="wrap-content container" id="container">
						<section id="page-title" class="padding-top-15 padding-bottom-15">
							<div class="row">
								<div class="col-sm-7">
									<h1 class="mainTitle">UoM</h1>
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
											<button type="button" class="btn btn-wide btn-primary" onclick="fnCreateUOM();">
												<i class="ti-plus"></i> Add
											</button>
										</div>
										<table class="table table-striped table-bordered table-hover table-full-width" id="ID_UOM_DETAILS_TABLE">
											<thead>
												<tr>
													<th width="25%">Id</th>
													<th width="25%">Name</th>
													<th width="25%">Description</th>
													<th width="25%">Actions</th>
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
	
	<div id="ID_SAVE_UOM_MODEL" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add UOM</h4>
				</div>
				<div class="modal-body">
					<fieldset>
						<div class="form-group">
							<label> UOM ID <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<input type="text" placeholder="UOM ID" id="ID_UOM_ID"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label> UOM Name <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<input type="text" placeholder="UOM Name" id="ID_UOM_NAME"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label>UOM Description <span class="symbol required"></span>
							</label>
							<div class="form-group">
								<textarea placeholder="UOM Description" id="ID_UOM_DESC"
									class="form-control"></textarea>
							</div>
						</div>
					</fieldset>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">
						Cancel</button>
					<button type="button" class="btn btn-primary"
						onclick="javascript:fnSaveUOM();">Save</button>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
   		$(document).ready(function() {
			$(".loader").fadeOut("slow");
			fnFetchAllUomDetails();
		});
	</script>
	<script type="text/javascript">
		function fnCreateUOM(){
			document.getElementById("ID_ACTION").value = "CREATE";
			document.getElementById("ID_UOM_ID").value = "";
			document.getElementById("ID_UOM_NAME").value = "";
			document.getElementById("ID_UOM_DESC").value = "";
			document.getElementById("ID_UOM_DB_ID").value = "";
			$('#ID_SAVE_UOM_MODEL').modal('show');
		}
	
		function fnSaveUOM(){
			var uomId = document.getElementById("ID_UOM_ID").value;
			var uomName = document.getElementById("ID_UOM_NAME").value;
			var uomDesc = document.getElementById("ID_UOM_DESC").value;
			var action  = document.getElementById("ID_ACTION").value;
			var dbId = document.getElementById("ID_UOM_DB_ID").value;
			$.ajax({
				cache 				: "false",
				type 				: "POST",
				dataType 			: "json",
				contentType 		: "application/json; charset=utf-8",
				data 				: '{"dbId":"' + dbId + '","uomId":"' + uomId + '","uomName":"' + uomName + '","uomDesc":"' + uomDesc + '","action":"' + action + '"}',
				url 				: "${pageContext.request.contextPath}/saveUom.html",
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
			$('#ID_SAVE_UOM_MODEL').modal('hide');
			fnFetchAllUomDetails();
		}
		
		function fnFetchAllUomDetails(){
    		$.ajax({
   			 	 cache		 	: "false",
  		         type        	: "POST",
  		       	 contentType	: "application/json; charset=utf-8",
  		       	 dataType    	: "json",
  		         url 			: "${pageContext.request.contextPath}/fetchAllUomDetails.html",
  		         async		 	: false
	   	    }).done(function(data) {
	   	    	$("#ID_UOM_DETAILS_TABLE").dataTable().fnDestroy();
	            $('table#ID_UOM_DETAILS_TABLE TBODY').find("tr").remove();
	   	    	$.each(data.UOM_DETAILS,function(index, uomDetails){
	   	    			var id = uomDetails['id'];
		    	 		$('table#ID_UOM_DETAILS_TABLE TBODY').append('<tr>'
		    			+'<td width="25%">'+uomDetails['uomId']+'</td>'
		    			+'<td width="25%">'+uomDetails['uomName']+'</td>'
		    			+'<td width="25%">'+uomDetails['uomDesc']+'</td>'
		    			+'<td width="25%"><a class="btn btn-sm btn-primary" style="margin-right:5px;" onclick=fnEditUomDetails("'+ id +'");><i class="fa fa-pencil"></i> Edit</a>'
                        +'<a class="btn btn-sm btn-red" href="#" style="margin-right:5px;"><i class="fa fa-trash-o"></i> Delete</a></td></tr>');
    	    	  });
	   	    }).fail(function(jqXHR, textStatus, error) {
	   	    });
    		$('#ID_UOM_DETAILS_TABLE').dataTable({
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
    		$('#ID_UOM_DETAILS_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
    		$('#ID_UOM_DETAILS_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
    		$('#ID_UOM_DETAILS_TABLE_wrapper .dataTables_length select').select2();
    	}
		
		function fnEditUomDetails(id){
			$.ajax({
				cache 				: "false",
				type 				: "POST",
				dataType 			: "json",
				contentType 		: "application/json; charset=utf-8",
				data 				: '{"uomId":"' + id + '","action":"UPDATE"}',
				url 				: "${pageContext.request.contextPath}/editUomDetails.html",
				async				: false
			}).done(function(data) {
				if(JSON.stringify(data.status) == '"SUCCESS"') {
					document.getElementById("ID_UOM_DB_ID").value = id;
					document.getElementById("ID_ACTION").value = "UPDATE";
					document.getElementById("ID_UOM_ID").value = data.UOM_DETAILS.uomId;
					document.getElementById("ID_UOM_NAME").value = data.UOM_DETAILS.uomName;
					document.getElementById("ID_UOM_DESC").value = data.UOM_DETAILS.uomDesc;
				}
			}).fail(function(jqxhr, textStatus, errorThrown) {
				alert("..jqxhr2.."+JSON.stringify(jqxhr));
			});
			$('#ID_SAVE_UOM_MODEL').modal('show');
		}
	</script>
</body>
</html>