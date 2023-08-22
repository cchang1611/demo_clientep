 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
								     agregarImagenVisor('${imagendoc.byteArchivo}','${imagendoc.nombreArchivo}');
								     </script>
								  </c:forEach>
									<a class="prev" onclick="plusSlides(-1)">&#10094;</a> 
									<a	class="next" onclick="plusSlides(1)">&#10095;</a>
								</div>
							</div>
							<div class="ContainerButtonsCenter">
								<a href="#" class="Submitx" id="aceptarImagenCarrusel" onclick="aceptarImagenCarrusel()">Aceptar</a>
								<a href="#" class="Submitx" id="cancelarImagenCarrusel" onclick="cancelarImagenCarrusel()">Cancelar</a>
							</div>

						</div>
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