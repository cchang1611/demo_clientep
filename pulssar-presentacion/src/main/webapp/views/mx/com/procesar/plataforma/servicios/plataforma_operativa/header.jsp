<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ------------------------ estilos -------------------------------- -->
<!-- bootstrap -->
<link id="comun-template"
	href="<c:url value='/webResources/plataforma_operativa/bootstrap/core/css/bootstrap.min.css'/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value='/webResources/plataforma_operativa/bootstrap/core/css/styles.css'/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/webResources/plataforma_operativa/jquery/core/jquery-ui-1.11.4.custom/jquery-ui.css'/>"
	rel="stylesheet" type="text/css" />

<!-- jqGrid -->
<link
	href="<c:url value='/webResources/plataforma_operativa/jquery/plugins/jqGrid/css/ui.jqgrid.css'/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/webResources/plataforma_operativa/jquery/plugins/jqGrid/css/ui.jqgrid-bootstrap-ui.css'/>"
	rel="stylesheet" type="text/css" />


<!-- custom style procesar -->
<link id="customStyle"
	href="<c:url value='/webResources/plataforma_operativa/css/customProcesar.css'/>"
	rel="stylesheet" type="text/css" />



<!-- custom scroller -->
<link
	href="<c:url value='/webResources/plataforma_operativa/jquery/plugins/customScroller/jquery.mCustomScrollbar.css'/>"
	rel="stylesheet" type="text/css" />

<!-- ------------------------ scripts -------------------------------- -->

<!-- jquery 
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/core/js/jquery.js'/>"></script>
-->
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/core/jquery-ui-1.11.4.custom/jquery-ui.min.js'/>"></script>

<!-- plugin de validacion -->
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/JQValidation/jquery.validate.min.js'/>"></script>

<!-- bootstrap -->
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/bootstrap/core/js/scripts.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/bootstrap/core/js/bootstrap.min.js'/>"></script>
<!-- paginador -->
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/bootstrap/bootpag/js/jquery.bootpag.min.js'/>"></script>

<!-- jqGrid -->
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/jqGrid/jquery.jqGrid.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/jqGrid/i18n/grid.locale-es.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/jqGrid/i18n/grid.locale-en.js'/>"></script>

<!-- date time picker -->
<link
	href="<c:url value='/webResources/plataforma_operativa/jquery/plugins/datepicker/css/bootstrap-datetimepicker.css'/>"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/datepicker/js/moment-with-locales.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/datepicker/js/bootstrap-datetimepicker.js'/>"></script>

<!-- block ui -->
<script type="text/javascript"
	src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/blockui/jquery.blockUI.js'/>"></script>

<!-- Utilerias -->
<script type="text/javascript" src="<c:url value='/webResources/plataforma_operativa/util/js/procesarUtil.js'/>"></script>

<!-- File Input -->
<link href="<c:url value='/webResources/plataforma_operativa/css/fileInput/jasny-bootstrap.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/fileInput/jasny-bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/jqueryform/jquery.form.min.js'/>"></script>
<!-- File Download -->
<script type="text/javascript" src="<c:url value='/webResources/plataforma_operativa/jquery/plugins/jqFileDownload/jquery.fileDownload.js'/>"></script>

<input type="hidden" id="contextPath" value="${pageContext.servletContext.contextPath}">