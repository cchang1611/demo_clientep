<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>

<form:form action="/private/enviarArchivos" method="post" enctype="multipart/form-data" id="frmAdjuntar">

	<div class="Line"></div>
	<div class="Datos_Container">
		<div class="Title">Documentos Obligatorios</div>

		<div class="accordion js-accordion">
			<c:forEach items="${obligatorios}" var="docObligatorios">
				<div class="accordion__item js-accordion-item">
					<div class="accordion-header js-accordion-header">${docObligatorios.descripcion}</div>
					<div class="accordion-body js-accordion-body">
						<div class="accordion-body__contents" style="text-align: center;">
							<c:forEach items="${docObligatorios.subDocumentos}" var="subdocObligatorios" varStatus="num">
								<div class="dropFileForm">
									<input type="hidden" id="hid${subdocObligatorios.clave}" value="${subdocObligatorios.descripcion}" /> 
									<input id="input${subdocObligatorios.clave}" name="${subdocObligatorios.clave}" type="file" class="fileInput" onchange="cambiaNombre(event, '${subdocObligatorios.clave}', this)">
									<label for="input${subdocObligatorios.clave}" class="fileLabel" ondrop="overrideDefault(event);addFiles(event);"> 
										<i 	class="fa fa-download fa-5x"></i> <br> 
										<span id="fileLabelText${subdocObligatorios.clave}">${subdocObligatorios.descripcion}</span> <br> 
										<span id="uploadStatus"></span>
									</label>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<br />
		<div class="Title">Documentos No Obligatorios</div>
		<div class="accordion js-accordion">

			<c:forEach items="${noObligatorios}" var="dNObligatorio" varStatus="num">
					<div class="accordion__item js-accordion-item">
					<div class="accordion-header js-accordion-header">${dNObligatorio.descripcion}</div>
					<div class="accordion-body js-accordion-body">
						<div class="accordion-body__contents" style="text-align: center;">
							<c:forEach items="${dNObligatorio.subDocumentos}" var="subdocNoObligatorios" varStatus="num">
								<div class="dropFileForm">
									<input type="hidden" id="hid${subdocNoObligatorios.clave}"  value="${subdocNoObligatorios.descripcion}" /> 
									<input id="input${subdocNoObligatorios.clave}" name="${subdocNoObligatorios.clave}" type="file" class="fileInput" onchange="cambiaNombre(event, '${subdocNoObligatorios.clave}', this)" accept="image/png, image/jpg,image/jpeg, image/tif, .pdf">
									<label for="input${subdocNoObligatorios.clave}" class="fileLabel" ondrop="overrideDefault(event);addFiles(event);"> 
									<i class="fa fa-download fa-5x"></i> <br> 
									<span id="fileLabelText${subdocNoObligatorios.clave}">${subdocNoObligatorios.descripcion}</span>
										<br> <span id="uploadStatus"></span>
									</label>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>



	</div>

	<div class="ContainerButtons">
		<input type="button" value="ADJUNTAR" class="Submitx"
			id="botonAdjuntar" />
	</div>
</form:form>