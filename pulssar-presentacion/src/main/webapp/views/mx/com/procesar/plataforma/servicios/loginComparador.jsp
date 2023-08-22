<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<head>
	<script type="text/javascript" src="<c:url value='/webResources/js/autocomplete/jquery-1.12.4.js'/>"></script>
</head>
<body>
	<form:form id="fm_login" name="formulario" method="post" modelAttribute="usuario" action="${url}">
		<input type="text" path="usComparador" name="user" value="${usComparador}" hidden="hidden" />
		<input type="text" path="pwComparador" name="pwd" value="${pwComparador}" hidden="hidden" />
	</form:form>
	
	<script type="text/javascript">
		window.onload = function() {
			var $form = $('#fm_login');
			$form.submit();
		};
	</script>
</body>
</html>
