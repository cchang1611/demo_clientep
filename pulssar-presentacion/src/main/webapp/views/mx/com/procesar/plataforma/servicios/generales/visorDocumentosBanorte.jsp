<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<script type="text/javascript">
var context = '${pageContext.request.contextPath}';
numeroIntentos = 0;
function mandarImagenes(){
	$("#idAceptarVisor").attr("disabled","disabled");
	document.getElementById("imagenesDoctos").submit();
}
</script>
		<input id="tipoProceso" type="hidden" name="tipoProceso"
			value="${parametrosRetiroParcialCalculoImss.folioHijo}" />
	<div id="carruselDocumentosModal" class="Modal">
		<div class="ModalContainerpdf ">
			<div class="ModalHeader">
				<h2 class="ModalTitle">Documentos</h2>
				<a href="#" class="ModalButton">X</a>
			</div>

 			<div class="wrapper">
				<div class="Container">
					<div class="Layout__L">
						<div class="Datos_Container">
							<div class="Container_Carousel">
								<div class="slideshow-container" id="imagenesCarrusel">
								  <c:forEach items="${imagenesDoc}" var="imagendoc">
								    <script>
								     agregarImagenVisor('${imagendoc.contenidoDocumento}','${imagendoc.nombreDocumento}');
								     </script>
								  </c:forEach>
									<a class="prev" onclick="plusSlides(-1)">&#10094;</a> 
									<a	class="next" onclick="plusSlides(1)">&#10095;</a>
								</div>
							</div>
						</div>
					</div>
					
					<div class="ContainerButtonsCenter">
					<input id="idAceptarVisor" class="Submit" type="Submit" value="Aceptar" onclick="mandarImagenes()"/>
					<input class="Submit" type="Submit" value="Cancelar" onclick="respuestaCancelarVisorDoc()"/>
					</div>
				</div>
			</div> 

  
		</div>
	</div>
	
	 <div id="visorDocumentosCarruselModal" class="Modal">
          <div class="ModalContainerpdf">
            <div class="ModalHeader">
            <h2 class="ModalTitle"></h2>
            <a href="#carruselDocumentosModal" class="ModalButton">X</a>
            </div>
            <div id="botonesPdf" style="display: none;text-align: center">
            	<button id="prevbutton" class="Submit" type="button">Pag. Anterior</button>
            	<button id="nextbutton" class="Submit" type="button">Pag. Siguiente</button>
				<button id="zoominbutton" class="Submit" type="button">Zoom +</button>
				<button id="zoomoutbutton" class="Submit" type="button">Zoom -</button>
			</div>
            <div class="Modal__Alertpdf " id="visorDocumentos">        
            </div>
            <div class="ModalFooter">
              <div class="ContainerButtons">
                <a href="#carruselDocumentosModal" class="Submitx">Aceptar</a>
              </div>
            </div>
          </div>
        </div>
        
