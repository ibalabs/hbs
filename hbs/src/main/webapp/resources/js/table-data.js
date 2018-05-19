var TableData = function() {
	"use strict";
	var accessDetailsTable = function() {

		var oTable = $('#ID_ACCESS_DETAILS_TABLE').dataTable({
			"aoColumnDefs" : [{
				"bSortable": false, "aTargets": [ 3 ]
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
			"aLengthMenu" : [5, 10, 15, 20],
			"iDisplayLength" : 5,
		});
		$('#ID_ACCESS_DETAILS_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
		$('#ID_ACCESS_DETAILS_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
		$('#ID_ACCESS_DETAILS_TABLE_wrapper .dataTables_length select').select2();
		$('#ID_ACCESS_DETAILS_TABLE_column_toggler input[type="checkbox"]').change(function() {
			var iCol = parseInt($(this).attr("data-column"));
			var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
			oTable.fnSetColumnVis(iCol, ( bVis ? false : true));
		});
	};
	
	var groupDataTable = function() {

		var oTable = $('#ID_GROUP_DATA_TABLE').dataTable({
			"aoColumnDefs" : [{
				"bSortable": false, "aTargets": [ 0 ]
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
			"aLengthMenu" : [5, 10],
			"iDisplayLength" : 5,
			 "bDestroy": true
		});
		$('#ID_GROUP_DATA_TABLE_wrapper .dataTables_filter input').addClass("form-control input-sm").attr("placeholder", "Search");
		$('#ID_GROUP_DATA_TABLE_wrapper .dataTables_length select').addClass("m-wrap small");
		$('#ID_GROUP_DATA_TABLE_wrapper .dataTables_length select').select2();
		$('#ID_GROUP_DATA_TABLE_column_toggler input[type="checkbox"]').change(function() {
			var iCol = parseInt($(this).attr("data-column"));
			var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
			oTable.fnSetColumnVis(iCol, ( bVis ? false : true));
		});
	};
	
	return {
		init : function() {
			accessDetailsTable();
			groupDataTable();
		}
	};
}();
