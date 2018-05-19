function idmOperationalTasks(finalize) {

	var idmOperationalTasksDataTable = $('#ID_OPERATIONAL_TASKS_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_OPERATIONAL_TASKS_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "sailPointReportTab", "value": "IDM Operational Tasks" })
	    },
		"sAjaxSource": "loadSailPointTasksJSON.jsf",
		"columns": [
            { "data": "taskName", "bSortable" : true, "sWidth" : "25%", "sClass": "text-wrap" },
            { "data": "status", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "comment", "bSortable" : false, "sWidth" : "25%", "sClass": "text-wrap" },
            { "data": "estimatedTime", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "", "bSortable" : false, "sWidth" : "10%",
           	 "mRender": function ( data, type, full ) {
                   var id = full['id'];
                   var taskName = full['taskName'];
                   var action = null;
                   if(finalize == 0){
                	   action = "edit";
	                   return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
	                   		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
	                   		+'<ul class="dropdown-menu" role="menu">'
	                   		+'<li><a href="javascript:fnEditOperationTask(\''+id+'\', \''+action+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Edit </a></li>'
	                   		+'<li><a href="javascript:fnConfirmDeleteIDMTask(\''+id+'\',\''+taskName+'\');"><i class="fa fa-trash" aria-hidden="true"></i> Delete </a></li></ul></div>';
                   } else{
                	   action = "view";
                	   return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
                  		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
                  		+'<ul class="dropdown-menu" role="menu">'
                  		+'<li><a href="javascript:fnEditOperationTask(\''+id+'\', \''+action+'\');"><i class="fa fa-eye" aria-hidden="true"></i> View </a></li></ul></div>';
                   }
                 }
  			}
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_OPERATIONAL_TASKS_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_OPERATIONAL_TASKS_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_OPERATIONAL_TASKS_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_OPERATIONAL_TASKS_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = idmOperationalTasksDataTable.fnSettings().aoColumns[iCol].bVisible;
		idmOperationalTasksDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return idmOperationalTasksDataTable;
};

function scheduledTasks(finalize) {
	
	var scheduledTasksDataTable = $('#ID_SCHEDULED_TASKS_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_SCHEDULED_TASKS_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "sailPointReportTab", "value": "Scheduled Tasks" })
	    },
		"sAjaxSource": "loadSailPointTasksJSON.jsf",
		"columns": [
			{ "data": "taskName", "bSortable" : true, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "status", "bSortable" : false, "sWidth" : "10%", "sClass": "text-wrap" },
            { "data": "reinitiateIfNeed", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "statusAfterReinitiate", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "cause", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "", "bSortable" : false, "sWidth" : "10%",
              	 "mRender": function ( data, type, full ) {
                      var id = full['id'];
                      var taskName = full['taskName'];
                      var action = null;
                      if(finalize == 0){
                    	  action = "edit";
                    	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
                    		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
                    		+'<ul class="dropdown-menu" role="menu">'
                    		+'<li><a href="javascript:fnEditScheduledTask(\''+id+'\', \''+action+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Edit </a></li>'
                    		+'<li><a href="javascript:fnConfirmDeleteScheduledTask(\''+id+'\',\''+taskName+'\');"><i class="fa fa-trash" aria-hidden="true"></i> Delete </a></li></ul></div>';
                      } else{
                    	  action = "view";
                    	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
                    		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
                    		+'<ul class="dropdown-menu" role="menu">'
                    		+'<li><a href="javascript:fnEditScheduledTask(\''+id+'\', \''+action+'\');"><i class="fa fa-eye" aria-hidden="true"></i> View </a></li></ul></div>';
                      }
                    }
     			}
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_SCHEDULED_TASKS_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_SCHEDULED_TASKS_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_SCHEDULED_TASKS_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_SCHEDULED_TASKS_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = scheduledTasksDataTable.fnSettings().aoColumns[iCol].bVisible;
		scheduledTasksDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return scheduledTasksDataTable;
};

function failedAccessRequests(finalize) {
	
	var failedAccessRequestsDataTable = $('#ID_FAILED_ACCESS_REQUESTS_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_FAILED_ACCESS_REQUESTS_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "sailPointReportTab", "value": "Failed Access Requests" })
	    },
		"sAjaxSource": "loadSailPointTasksJSON.jsf",
		"columns": [
			{ "data": "requestId", "bSortable" : true, "sWidth" : "15%", "sClass": "text-wrap" },
            { "data": "cause", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "requestCreatedDate", "bSortable" : true, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "issueIdentifiedDate", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "estimatedTime", "bSortable" : true, "sWidth" : "15%", "sClass": "text-wrap" },
            { "data": "", "bSortable" : false, "sWidth" : "10%",
              	 "mRender": function ( data, type, full ) {
                      var id = full['id'];
                      var requestId = full['requestId'];
                      var action = null;
                      if(finalize == 0){
                    	  action = "edit";
                    	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
                    		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
                    		+'<ul class="dropdown-menu" role="menu">'
                    		+'<li><a href="javascript:fnEditFailedRequest(\''+id+'\', \''+action+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Edit </a></li>'
                    		+'<li><a href="javascript:fnConfirmDeleteFailedRequest(\''+id+'\',\''+requestId+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Delete </a></li></ul></div>';
                      } else{
                    	  action = "view";
	                   	   return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
	                  		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
	                  		+'<ul class="dropdown-menu" role="menu">'
	                  		+'<li><a href="javascript:fnEditFailedRequest(\''+id+'\', \''+action+'\');"><i class="fa fa-eye" aria-hidden="true"></i> View </a></li></ul></div>';
                      }
                    }
     			}
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_FAILED_ACCESS_REQUESTS_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_FAILED_ACCESS_REQUESTS_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_FAILED_ACCESS_REQUESTS_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_FAILED_ACCESS_REQUESTS_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = failedAccessRequestsDataTable.fnSettings().aoColumns[iCol].bVisible;
		failedAccessRequestsDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return failedAccessRequestsDataTable;
};

function pendingWorkItems(finalize) {
	
	var pendingWorkItemsDataTable = $('#ID_PENDING_WORKITEMS_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_PENDING_WORKITEMS_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "sailPointReportTab", "value": "WorkItems Pending More Than 60 Days" })
	    },
		"sAjaxSource": "loadSailPointTasksJSON.jsf",
		"columns": [
			{ "data": "workItemId", "bSortable" : true, "sWidth" : "10%", "sClass": "text-wrap" },
            { "data": "rootCause", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "followedUp", "bSortable" : true, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "reminders", "bSortable" : false, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "terminateDate", "bSortable" : true, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "", "bSortable" : false, "sWidth" : "10%",
              	 "mRender": function ( data, type, full ) {
                      var id = full['id'];
                      var workItemId = full['workItemId'];
                      var action = null;
                      if(finalize == 0){
                    	  action = "edit";
                    	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
                    		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
                    		+'<ul class="dropdown-menu" role="menu">'
                    		+'<li><a href="javascript:fnEditPendingWorkItem(\''+id+'\', \''+action+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Edit </a></li>'
                    		+'<li><a href="javascript:fnConfirmDeletePendingWorkItem(\''+id+'\',\''+workItemId+'\');"><i class="fa fa-trash" aria-hidden="true"></i> Delete </a></li></ul></div>';
                      } else{
                    	  action = "view";
	                   	   return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
	                  		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
	                  		+'<ul class="dropdown-menu" role="menu">'
	                  		+'<li><a href="javascript:fnEditPendingWorkItem(\''+id+'\', \''+action+'\');"><i class="fa fa-eye" aria-hidden="true"></i> View </a></li></ul></div>';
                      }
                    }
     			}
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_PENDING_WORKITEMS_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_PENDING_WORKITEMS_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_PENDING_WORKITEMS_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_PENDING_WORKITEMS_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = pendingWorkItemsDataTable.fnSettings().aoColumns[iCol].bVisible;
		pendingWorkItemsDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return pendingWorkItemsDataTable;
};

function workitemsInAdminQueue(finalize) {
	
	var workitemsInAdminQueueDataTable = $('#ID_WORKITEMS_IN_ADMIN_QUEUE_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_WORKITEMS_IN_ADMIN_QUEUE_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "sailPointReportTab", "value": "WorkItems In IDM Admin Queue" })
	    },
		"sAjaxSource": "loadSailPointTasksJSON.jsf",
		"columns": [
			{ "data": "workItemId", "bSortable" : true, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "rootCause", "bSortable" : false, "sWidth" : "60%", "sClass": "text-wrap" },
            { "data": "expectedClosureDate", "bSortable" : true, "sWidth" : "10%", "sClass": "text-wrap" },
            { "data": "", "bSortable" : false, "sWidth" : "10%",
              	 "mRender": function ( data, type, full ) {
                      var id = full['id'];
                      var workItemId = full['workItemId'];
                      var action = null;
                      if(finalize == 0){
                    	  action = "edit";
                    	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
		                   		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
		                   		+'<ul class="dropdown-menu" role="menu">'
		                   		+'<li><a href="javascript:fnEditAdminWorkitem(\''+id+'\', \''+action+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Edit </a></li>'
		                   		+'<li><a href="javascript:fnConfirmDeleteAdminWorkitem(\''+id+'\',\''+workItemId+'\');"><i class="fa fa-trash" aria-hidden="true"></i> Delete </a></li></ul></div>';
                      } else{
                    	  action = "view";
	                   	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
		                  		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
		                  		+'<ul class="dropdown-menu" role="menu">'
		                  		+'<li><a href="javascript:fnEditAdminWorkitem(\''+id+'\', \''+action+'\');"><i class="fa fa-eye" aria-hidden="true"></i> View </a></li></ul></div>';
                      }
                    }
     			}
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_WORKITEMS_IN_ADMIN_QUEUE_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_WORKITEMS_IN_ADMIN_QUEUE_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_WORKITEMS_IN_ADMIN_QUEUE_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_WORKITEMS_IN_ADMIN_QUEUE_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = workitemsInAdminQueueDataTable.fnSettings().aoColumns[iCol].bVisible;
		workitemsInAdminQueueDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return workitemsInAdminQueueDataTable;
};

function prs(finalize) {
	
	var prsDataTable = $('#ID_PRS_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_PRS_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "sailPointReportTab", "value": "PRs" })
	    },
		"sAjaxSource": "loadSailPointTasksJSON.jsf",
		"columns": [
			{ "data": "pr_title", "bSortable" : true, "sWidth" : "40%", "sClass": "text-wrap" },
            { "data": "expected_closure_date", "bSortable" : true, "sWidth" : "50%", "sClass": "text-wrap" },
            { "data": "", "bSortable" : false, "sWidth" : "10%",
              	 "mRender": function ( data, type, full ) {
                      var id = full['id'];
                      var action = null;
                      if(finalize == 0){
                    	  action = "edit";
	                      return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
	                      		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
	                      		+'<ul class="dropdown-menu" role="menu">'
	                      		+'<li><a href=""><i class="fa fa-pencil" aria-hidden="true"></i> Edit </a></li>'
	                      		+'<li><a href=""><i class="fa fa-pencil" aria-hidden="true"></i> Delete </a></li></ul></div>';
                      } else{
                    	  action = "view";
	                   	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
		                  		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
		                  		+'<ul class="dropdown-menu" role="menu">'
		                  		+'<li><a href=""><i class="fa fa-eye" aria-hidden="true"></i> View </a></li></ul></div>';
                      }
                    }
     			}
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_PRS_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_PRS_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_PRS_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_PRS_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = prsDataTable.fnSettings().aoColumns[iCol].bVisible;
		prsDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return prsDataTable;
};

function maintenanceActivities(finalize) {
	var maintenanceActivitiesDataTable = $('#ID_MANTTENANCE_ACTIVITIES_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_MANTTENANCE_ACTIVITIES_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "sailPointReportTab", "value": "Maintenance Activities" })
	    },
		"sAjaxSource": "loadSailPointTasksJSON.jsf",
		"columns": [
			{ "data": "taskName", "bSortable" : true, "sWidth" : "30%", "sClass": "text-wrap" },
            { "data": "whenToPerform", "bSortable" : true, "sWidth" : "20%", "sClass": "text-wrap" },
            { "data": "sparc", "bSortable" : false, "sWidth" : "40%", "sClass": "text-wrap" },
            { "data": "", "bSortable" : false, "sWidth" : "10%",
              	 "mRender": function ( data, type, full ) {
                      var id = full['id'];
                      var taskName = full['taskName'];
                      var action = null;
                      if(finalize == 0){
                    	  action = "edit";
                    	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
	                   		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
	                   		+'<ul class="dropdown-menu" role="menu">'
	                   		+'<li><a href="javascript:fnEditActvityDetails(\''+id+'\', \''+action+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Edit </a></li>'
	                   		+'<li><a href="javascript:fnConfirmDeleteActivityDetails(\''+id+'\',\''+taskName+'\');"><i class="fa fa-trash" aria-hidden="true"></i> Delete </a></li></ul></div>';
                      } else{
                    	  action = "view";
	                   	  return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown">'
		                  		+'<i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button>'
		                  		+'<ul class="dropdown-menu" role="menu">'
		                  		+'<li><a href="javascript:fnEditActvityDetails(\''+id+'\', \''+action+'\');"><i class="fa fa-eye" aria-hidden="true"></i> View </a></li></ul></div>';
                      }
                    }
     			}
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_MANTTENANCE_ACTIVITIES_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_MANTTENANCE_ACTIVITIES_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_MANTTENANCE_ACTIVITIES_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_MANTTENANCE_ACTIVITIES_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = maintenanceActivitiesDataTable.fnSettings().aoColumns[iCol].bVisible;
		maintenanceActivitiesDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return maintenanceActivitiesDataTable;
};

function fnLoadsso() {

	var ssoDataTable = $('#ID_SSO_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_SSO_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "iamReportTab", "value": "sso" })
	    },
		"sAjaxSource": "loadiamTasksJSON.jsf",
		"columns": [
				{ "data": "Task#", "bSortable" : true, "sWidth" : "15%", "sClass": "text-wrap" },
				{ "data": "Description", "bSortable" : true, "sWidth" : "25%", "sClass": "text-wrap" },
				{ "data": "url", "bSortable" : true, "sWidth" : "30%", "sClass": "text-wrap" },
				{ "data": "Status", "bSortable" : true, "sWidth" : "30%", "sClass": "text-wrap" }
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_SSO_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_SSO_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_SSO_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_SSO_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = ssoDataTable.fnSettings().aoColumns[iCol].bVisible;
		ssoDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return ssoDataTable;
};

function fnLoadOam(){
	
	var oamDataTable = $('#ID_OAM_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_OAM_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "iamReportTab", "value": "oam" })
	    },
		"sAjaxSource": "loadiamTasksJSON.jsf",
		"columns": [
				{ "data": "Task#", "bSortable" : true, "sWidth" : "15%", "sClass": "text-wrap" },
				{ "data": "Description", "bSortable" : true, "sWidth" : "60%", "sClass": "text-wrap" },
				{ "data": "Status", "bSortable" : true, "sWidth" : "25%", "sClass": "text-wrap" }
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_OAM_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_OAM_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_OAM_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_OAM_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = oamDataTable.fnSettings().aoColumns[iCol].bVisible;
		oamDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return oamDataTable;
};

function fnLoadOsso(){
	
	var ossoDataTable = $('#ID_OSSO_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_OSSO_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "iamReportTab", "value": "osso" })
	    },
		"sAjaxSource": "loadiamTasksJSON.jsf",
		"columns": [
				{ "data": "Task#", "bSortable" : true, "sWidth" : "20%", "sClass": "text-wrap" },
				{ "data": "Description", "bSortable" : true, "sWidth" : "55%", "sClass": "text-wrap" },
				{ "data": "Status", "bSortable" : true, "sWidth" : "25%", "sClass": "text-wrap" },
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_OSSO_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_OSSO_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_OSSO_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_OSSO_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = ossoDataTable.fnSettings().aoColumns[iCol].bVisible;
		ossoDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return ossoDataTable;
};

function fnPasswordReset(){
	
	var passwordResetDataTable = $('#ID_PASSWORD_RESET_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_PASSWORD_RESET_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "iamReportTab", "value": "Password Reset" })
	    },
		"sAjaxSource": "loadiamTasksJSON.jsf",
		"columns": [
				{ "data": "Task#", "bSortable" : true, "sWidth" : "20%", "sClass": "text-wrap" },
				{ "data": "Description", "bSortable" : true, "sWidth" : "40%", "sClass": "text-wrap" },
				{ "data": "Status", "bSortable" : true, "sWidth" : "25%", "sClass": "text-wrap" }
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_PASSWORD_RESET_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_PASSWORD_RESET_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_PASSWORD_RESET_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_PASSWORD_RESET_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = passwordResetDataTable.fnSettings().aoColumns[iCol].bVisible;
		passwordResetDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return passwordResetDataTable;
};

function fnLoadeBusiness(){
	
	var eBusinessDataTable = $('#ID_E_BUSINESS_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_E_BUSINESS_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "iamReportTab", "value": "e-Business" })
	    },
		"sAjaxSource": "loadiamTasksJSON.jsf",
		"columns": [
				{ "data": "Instance Name", "bSortable" : true, "sWidth" : "30%", "sClass": "text-wrap" },
				{ "data": "EBS URL", "bSortable" : true, "sWidth" : "40%", "sClass": "text-wrap" },
				{ "data": "Status", "bSortable" : true, "sWidth" : "30%", "sClass": "text-wrap" }
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_E_BUSINESS_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_E_BUSINESS_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_E_BUSINESS_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_E_BUSINESS_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = eBusinessDataTable.fnSettings().aoColumns[iCol].bVisible;
		eBusinessDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return eBusinessDataTable;
};

function fnLoadLegalHoldFile(){
	
	var legalHoldFileDataTable = $('#ID_LEGAL_HOLD_FILE_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_LEGAL_HOLD_FILE_DATA_TABLE');
		},
		"bServerSide": true,
		"bDestroy": true,
		"oLanguage" : {
			"sLengthMenu" : "Show _MENU_ Rows",
			"sSearch" : "",
			"oPaginate" : {
				"sPrevious" : "",
				"sNext" : ""
			},
			"sZeroRecords": "No data available" ,
		},
		"aLengthMenu" : [5, 10, 15, 20],
		"iDisplayLength" : 5,
		"fnServerParams": function ( aoData ) {
	         aoData.push({ "name": "iamReportTab", "value": "legal Hold File" })
	    },
		"sAjaxSource": "loadiamTasksJSON.jsf",
		"columns": [
				{ "data": "Task#", "bSortable" : true, "sWidth" : "30%", "sClass": "text-wrap" },
				{ "data": "Description", "bSortable" : true, "sWidth" : "40%", "sClass": "text-wrap" },
				{ "data": "Status", "bSortable" : true, "sWidth" : "30%", "sClass": "text-wrap" }
        ],
		"fnServerData": function(sSource, aoData, fnCallback, oSettings) {
            oSettings.jqXHR = $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aoData,
                "success": function(json) {
                    fnCallback(json);
                },
                "error": function(json) {
                    fnCallback(json);
                 }
            });
        }
	});
	// modify table search input
	$('#ID_LEGAL_HOLD_FILE_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_LEGAL_HOLD_FILE_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_LEGAL_HOLD_FILE_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_LEGAL_HOLD_FILE_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = legalHoldFileDataTable.fnSettings().aoColumns[iCol].bVisible;
		legalHoldFileDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return legalHoldFileDataTable;
};
