<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="es">
<body>
<input type="hidden" name="val" id="val" />
<div id="agregaBeneficiario" class="Modal" style="display:none; opacity:1; pointer-events:visible;">
			<div class="ModalContainer">
				<div class="ModalHeader">
					<h2 id="tituloBeneficiario" class="ModalTitle">Beneficiario</h2>
					<a href="#" class="ModalButton" onclick="cerrarModal();">X</a>
				</div>
				<div class="Container">
					<div class="Layout__M">
						<span id="mensajeRenapo" class="Labeltexterror"></span>
						<div class="Datosxxl form-group">
							<label class="LabelTextEdit" for="usuario">Curp Beneficiario:</label>
							<input class="InputEdit" type="text" name="curpBeneficiarioModal" id="curpBeneficiarioModal" placeholder="Curp Beneficiario" maxlength="18" onkeyup="rellenaDatosBeneficiario()"/>
							<span id="error" class="Labeltexterror"></span>
						</div>
						<div class="Datosxxl form-group">
							<label class="LabelTextEdit" for="usuario">Nombre Beneficiario:</label>
							<input class="InputEdit" type="text" name="nombreBenModal" id="nombreBenModal" placeholder="Nombre Beneficiario" maxlength="40"/>
							<span id="error" class="Labeltexterror"></span>
						</div>
						<div class="Datosxxl form-group">
							<label class="LabelTextEdit" for="usuario">Apellido Paterno Beneficiario:</label>
							<input class="InputEdit" type="text" name="paternoBenModal" id="paternoBenModal" placeholder="Apellido Paterno Beneficiario" maxlength="40"/>
							<span id="error" class="Labeltexterror"></span>
						</div>
						<div class="Datosxxl form-group">
							<label class="LabelTextEdit" for="usuario">Apellido Materno Beneficiario:</label>
							<input class="InputEdit" type="text" name="maternoBenModal" id="maternoBenModal" placeholder="Apellido Materno Beneficiario" maxlength="40"/>
							<span id="error" class="Labeltexterror"></span>
						</div>
						<div class="Datosxxl form-group">
							<label class="LabelTextEdit" for="usuario">Parentesco Beneficiario:</label>
							<select class="Select" id="parentescoBen" name="parentescoBen">
							<option value="">Seleccione una opción</option>
							<c:forEach items="${parentescos}" var="tParentesco">
								<option value="${tParentesco.claveParentesco}|${tParentesco.descripcion}"><c:out
								value="${tParentesco.claveParentesco} ${tParentesco.descripcion}"></c:out>
								</option>
							</c:forEach>
							</select>
							<span id="error" class="Labeltexterror"></span>
						</div>
						<div class="Datosxxl form-group">
							<label class="LabelTextEdit" for="lPorcentaje">Porcentaje:</label>
							<input class="InputEdit" type="text" name="porcentajeModal" id="porcentajeModal" placeholder="Porcentaje" maxlength="3"/>
							<span id="error" class="Labeltexterror"></span>
						</div>
						<div class="ModalFooter">
						  <input id="btnExitoBeneficiario" class="Submit" type="button" value="Guardar" onclick="guardaBeneficiario();"/>
					</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>