var Charts = function() {
	"use strict";
	var dataSet = [];
	var options = {

		responsive : false,
		segmentShowStroke : true,
		segmentStrokeColor : '#fff',
		segmentStrokeWidth : 2,
		percentageInnerCutout : 0,
		animationSteps : 100,
		animationEasing : 'easeOutBounce',
		animateRotate : true,
		animateScale : false,
	};
	var pieChartHandler = function() {
		var ctx = $("#pieChartSparc").get(0).getContext("2d");
		var pieChartSparc = new Chart(ctx).Pie(dataSet, options);
	};

	var pieSaprcReqItems = function() {
		var ctx = $("#pieSparcReqItems").get(0).getContext("2d");
		var pieSparcReqItems = new Chart(ctx).Pie(dataSet, options);
	};

	return {
		init : function() {
			$.ajax({
				"dataType" : 'json',
				"type" : "POST",
				"data": { chartDataType: "sparcAccountIncidents"} ,
				"url" : 'loadChartData.jsf',
				"success" : function(json) {
					dataSet = json;
					pieChartHandler();
				},
				"error" : function(json) {
					fnCallback(json);
				}
			});

			$.ajax({
				"dataType" : 'json',
				"type" : "POST",
				"data": { chartDataType: "saprcReqItems"} ,
				"url" : 'loadChartData.jsf',
				"success" : function(json) {
					dataSet = json;
					pieSaprcReqItems();
				},
				"error" : function(json) {
					fnCallback(json);
				}
			});
		}
	};
}();
