<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<script type="text/javascript" src="<c:url value='/webResources/js/autocomplete/jquery-1.12.4.js'/>"></script>
</head>
<body>
	<form:form id="fm_login" name="formulario" method="post" modelAttribute="usuario" action="${pageContext.request.contextPath}/login" accept-charset="ISO-8859-15">
		<input type="text" path="j_username" name="j_username" value="${usuario}" hidden="hidden" />
		<input type="password" path="j_password" name="j_password" value="${pass}" hidden="hidden" />
	</form:form>
	
	<script type="text/javascript">
		window.onload = function() {
			var $form = $('#fm_login');
			$form.submit();
		};
	</script>
</body>
</html>
