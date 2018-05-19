function configure() {

	var configureDataTable = $('#ID_CONFIGURE_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_CONFIGURE_DATA_TABLE');
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
	         aoData.push({ "name": "sparcConfigurationTab", "value": "Configure" })
	    },
		"sAjaxSource": "loadSparcConfiguration.jsf",
		"columns": [
			{ "data": "type", "bSortable" : true, "sWidth" : "200px", "sClass": "text-wrap",
				"mRender": function ( data, type, full ) {
					var type = full['type'];
					if(type == 'u_reporting_customer'){
						return 'Reporting Customer';
					}else if(type  == 'assignment_group'){
						return 'Assignment Group';
					}else if(type == 'cmdb_ci'){
						return 'Configuration Item';
					}else if(type == 'u_business_service'){
						return 'Business Service';
					}
				}
			},
            { "data": "name", "bSortable" : true, "sWidth" : "200px", "sClass": "text-wrap" },
            { "data": "code", "bSortable" : false, "sWidth" : "200px", "sClass": "text-wrap" },
            { "data": "created", "bSortable" : false, "sWidth" : "300px", "sClass": "text-wrap",
            	"mRender": function ( data, type, full ) {
            		var date = full['created'];
            		var newDate = new Date(date);
            		dateString = newDate.toString();
                    return dateString;
                  }
            },
            { "data": "", "bSortable" : false,"sWidth" : "100px",
           	 "mRender": function ( data, type, full ) {
           		 	var id = full['id'];
           		 	var name = full['name'];
           		 	var type = full['type'];
           		 	return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button><ul class="dropdown-menu" role="menu"><li><a href="javascript:fnUpdateSparcConfig(\''+id+'\',\''+type+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Edit</a></li><li><a href="javascript:fnConfirmDeleteConfig(\''+id+'\',\''+name+'\');" ><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</a></li></ul></div>';
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
	$('#ID_CONFIGURE_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_CONFIGURE_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_CONFIGURE_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_CONFIGURE_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = configureDataTable.fnSettings().aoColumns[iCol].bVisible;
		configureDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return configureDataTable;
};

function mapping() {
	
	var mappingDataTable = $('#ID_MAPPING_DATA_TABLE').dataTable({
		"initComplete": function(){
			fnGBotTableSearchFilter('ID_MAPPING_DATA_TABLE');
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
	         aoData.push({ "name": "sparcConfigurationTab", "value": "Mapping" })
	    },
		"sAjaxSource": "loadSparcConfiguration.jsf",
		"columns": [
			{ "data": "name", "bSortable" : true, "sWidth" : "100px", "sClass": "text-wrap" },
			{ "data": "reportingCustomer", "bSortable" : false, "sWidth" : "200px", "sClass": "text-wrap" },
            { "data": "assignmentGroup", "bSortable" : false, "sWidth" : "200px", "sClass": "text-wrap" },
            { "data": "cmdbConfItem", "bSortable" : false, "sWidth" : "200px", "sClass": "text-wrap" },
            { "data": "businessService", "bSortable" : false, "sWidth" : "200px", "sClass": "text-wrap" },
            { "data": "", "bSortable" : false,"sWidth" : "100px",
	          	 "mRender": function ( data, type, full ) {
	          		 	var id = full['id'];
	          		 	var name = full['name'];
	          		 	return '<div class="btn-group"><button type="button" class="btn btn-info btn-xs dropdown-toggle" data-toggle="dropdown"><i class="fa fa-cog" aria-hidden="true"></i> Actions <span class="caret"></span></button><ul class="dropdown-menu" role="menu"><li><a href="javascript:fnUpdateSparcMapping(\''+id+'\');"><i class="fa fa-pencil" aria-hidden="true"></i> Edit</a></li><li><a href="javascript:fnConfirmDeleteMapping(\''+id+'\',\''+name+'\');" ><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</a></li></ul></div>';
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
	$('#ID_MAPPING_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
	// modify table per page dropdown
	$('#ID_MAPPING_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
	// initialzie select2 dropdown
	$('#ID_MAPPING_DATA_TABLE_wrapper .dataTables_length select').select2();
	/* Get the DataTables object again - this is not a recreation, just a get of the object */
	$('#ID_MAPPING_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
		var iCol = parseInt($(this).attr("data-column"));
		var bVis = mappingDataTable.fnSettings().aoColumns[iCol].bVisible;
		mappingDataTable.fnSetColumnVis(iCol, ( bVis ? false : true));
	});
	
	return mappingDataTable;
};

