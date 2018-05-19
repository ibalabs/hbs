<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/fontawesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/themify-icons/themify-icons.min.css" />
    <link href="${pageContext.request.contextPath}/resources/plugins/animate.css/animate.min.css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/resources/plugins/perfect-scrollbar/perfect-scrollbar.min.css" rel="stylesheet" media="screen" />
    <link href="${pageContext.request.contextPath}/resources/plugins/switchery/switchery.min.css" rel="stylesheet" media="screen" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/custom.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/plugins.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default-theme.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/toastr/toastr.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.css" media="screen"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/DataTables/css/DT_bootstrap.css" media="screen"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/plugins/sweetalert/sweet-alert.css" media="screen">

	<script src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/modernizr/modernizr.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery-cookie/jquery.cookie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/switchery/switchery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/DataTables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/table-data.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/ui-notifications.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/selectFx/classie.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/selectFx/selectFx.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/toastr/toastr.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/toastr/toastr.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap-notify.js"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/sweetalert/sweet-alert.min.js"></script>

    <script type="text/javascript">
        $(function() {
			$(".loader").fadeOut("slow");
			Main.init();
			TableData.init();
			
            var fullURI = window.location.pathname;
            var url = fullURI.substring(fullURI.lastIndexOf("/") + 1, fullURI.length);
            if (url == "dashboard.html") {
                document.title = 'Dashboard';
                $("#ID_DASHBOARD").addClass('active');
            } else if (url == "uom.html") {
                document.title = 'UOM';
                $("#ID_UOM").addClass('active');
            } else if (url == "products.html") {
                document.title = 'Products';
                $("#ID_PRODUCTS").addClass('active');
            } else if (url == "customer.html") {
                document.title = 'Customer';
                $("#ID_CUSTOMERS").addClass('active');
            } else if (url == "salesinvoice.html") {
                document.title = 'Sales Invoice';
                $("#ID_SALES_INVOICE").addClass('active');
            } else if (url == "receipts.html") {
                document.title = 'Receipts';
                $("#ID_RECEIPTS").addClass('active');
            }else if (url == "totalduelist.html") {
                document.title = 'Total due list';
                $("#ID_REPORTS").addClass('active');
                $("#ID_TOTAL_DUE_LIST").addClass('active');
            }else if (url == "customerreports.html") {
                document.title = 'Customer Wise Reports';
                $("#ID_REPORTS").addClass('active');
                $("#ID_CUSTOMER_REPORTS").addClass('active');
            }else if (url == "productreports.html") {
                document.title = 'Product Wise Reports';
                $("#ID_REPORTS").addClass('active');
                $("#ID_PRODUCT_REPORTS").addClass('active');
            }else if (url == "referralreports.html") {
                document.title = 'Referral Wise Cost';
                $("#ID_REPORTS").addClass('active');
                $("#ID_REFRRAL_COST_REPORTS").addClass('active');
            }else if (url == "productcostreports.html") {
                document.title = 'Product Wise Cost';
                $("#ID_REPORTS").addClass('active');
                $("#ID_PRODUCT_COST_REPORTS").addClass('active');
            }
        });
        
        function notification_error(title, message){
        	toastr["error"](message, title);
        }
        function notification_warning(title, message){
        	toastr["warning"](message, title);
        }
        function notification_info(title, message){
        	toastr["info"](message, title);
        }
        function notification_success(title, message){
        	toastr["success"](message, title);
        }
    </script>

    <!-- Side bar -->
    <div class="sidebar app-aside" id="sidebar">
        <div class="sidebar-container perfect-scrollbar">
            <nav>
                <ul class="main-navigation-menu">
                    <li id="ID_DASHBOARD">
                        <a href="dashboard.html">
                            <div class="item-content">
                                <div class="item-media">
                                    <i class="ti-home"></i>
                                </div>
                                <div class="item-inner">
                                    <span class="title"> Dashboard </span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li id="ID_UOM">
                        <a href="${pageContext.request.contextPath}/uom.html">
                            <div class="item-content">
                                <div class="item-media">
                                    <i class="ti-panel"></i>
                                </div>
                                <div class="item-inner">
                                    <span class="title"> UOM </span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li id="ID_PRODUCTS">
                        <a href="${pageContext.request.contextPath}/products.html">
                            <div class="item-content">
                                <div class="item-media">
                                    <i class="ti-pinterest"></i>
                                </div>
                                <div class="item-inner">
                                    <span class="title"> Products </span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li id="ID_CUSTOMERS">
                        <a href="${pageContext.request.contextPath}/customers.html">
                            <div class="item-content">
                                <div class="item-media">
                                    <i class="ti-id-badge"></i>
                                </div>
                                <div class="item-inner">
                                    <span class="title"> Customers </span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li id="ID_SALES_INVOICE">
                        <a href="${pageContext.request.contextPath}/salesinvoice.html">
                            <div class="item-content">
                                <div class="item-media">
                                    <i class="ti-clipboard"></i>
                                </div>
                                <div class="item-inner">
                                  <span class="title"> Sales Invoice</span>
                              </div>
                          </div>
                      </a>
                  </li>
                  <li id="ID_RECEIPTS">
                        <a href="${pageContext.request.contextPath}/receipts.html">
                            <div class="item-content">
                                <div class="item-media">
                                    <i class="ti-menu-alt"></i>
                                </div>
                                <div class="item-inner">
                                    <span class="title"> Receipts </span>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li id="ID_REPORTS">
                    	<a href="javascript:void(0)">
							<div class="item-content">
								<div class="item-media">
									 <i class="ti-file"></i>
								</div>
								<div class="item-inner">
									<span class="title"> Reports </span><i class="icon-arrow"></i>
								</div>
							</div>
						</a>
	                    <ul class="sub-menu">
		                    <li id="ID_TOTAL_DUE_LIST">
		                        <a href="${pageContext.request.contextPath}/totalduelist.html">
		                            <div class="item-content">
		                                <div class="item-media">
		                                    <i class="ti-email"></i>
		                                </div>
		                                <div class="item-inner">
		                                    <span class="title"> Total Due List </span>
		                                </div>
		                            </div>
		                        </a>
		                    </li>
		                    <li id="ID_CUSTOMER_REPORTS">
		                        <a href="${pageContext.request.contextPath}/customerreports.html">
		                            <div class="item-content">
		                                <div class="item-media">
		                                    <i class="ti-id-badge"></i>
		                                </div>
		                                <div class="item-inner">
		                                    <span class="title"> Customer Wise </span>
		                                </div>
		                            </div>
		                        </a>
		                    </li>
		                    <li id="ID_PRODUCT_REPORTS">
		                        <a href="${pageContext.request.contextPath}/productreports.html">
		                            <div class="item-content">
		                                <div class="item-media">
		                                    <i class="ti-package"></i>
		                                </div>
		                                <div class="item-inner">
		                                    <span class="title"> Product Wise </span>
		                                </div>
		                            </div>
		                        </a>
		                    </li>
		                    <li id="ID_REFRRAL_COST_REPORTS">
		                        <a href="${pageContext.request.contextPath}/referralreports.html">
		                            <div class="item-content">
		                                <div class="item-media">
		                                    <i class="ti-loop"></i>
		                                </div>
		                                <div class="item-inner">
		                                    <span class="title"> Referral Wise Cost </span>
		                                </div>
		                            </div>
		                        </a>
		                    </li>
		                    <li id="ID_PRODUCT_COST_REPORTS">
		                        <a href="${pageContext.request.contextPath}/productcostreports.html">
		                            <div class="item-content">
		                                <div class="item-media">
		                                    <i class="ti-package"></i>
		                                </div>
		                                <div class="item-inner">
		                                    <span class="title"> Product Wise Cost </span>
		                                </div>
		                            </div>
		                        </a>
		                    </li>
	                   </ul>
	                 </li>
            </nav>
        </div>
    </div>
    <!-- Side bar End-->