var slideIndex = 1;
var listaImagenes = [];
$(document).ready(function() {
	console.log("inicio de visor");
	showSlides(slideIndex);
});

/**
 * Muestra el siguiente slide
 * @param n
 * @returns
 */
function plusSlides(n) {
	console.log("muestra siguiente slide");
	showSlides(slideIndex += n);
}

/**
 * Muestra el slide especificado
 * @param n
 * @returns
 */
function currentSlide(n) {
	console.log("muestra el slade especificado");
	showSlides(slideIndex = n);
}
/**
 * Muesta Slides especifica
 * @param n
 * @returns
 */
function showSlides(n) {
	console.log("valida el slide solicitado para mostrarlo");
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");
	if (n > slides.length) {
		slideIndex = 1;
	}
	if (n < 1) {
		slideIndex = slides.length;
	}
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	if(slideIndex > 0 && slides.length > 0){
	  slides[slideIndex -1].style.display = "block";
	} 

}





/**
 * Agrega una imagen, esto borrará las imagenes que se obtuvieron del sevidor 
 * @param imagenl
 * @param nombre
 * @returns
 */
function agregarImagenVisor(imagen,nombre){
	console.log("entrada"+ imagen + "," +nombre);
	var posicion = obtenerIndexImagen(nombre);
	var tipoArchivo = obtenerTipoArchivo(nombre);
	if(posicion == -1){
		var datosArchivo = new Object();
		datosArchivo.nombreArchivo = nombre;
		datosArchivo.byteArchivo = imagen;
		datosArchivo.tipoArchivo =tipoArchivo;
		listaImagenes.push(datosArchivo);
		creaImagenesCarrusel();
		slideIndex=1;

	}
}

/**
 * Obtiene el tipo de archivo
 * @param nobmre
 * @returns
 */
function obtenerTipoArchivo(nombre){
	console.log("tipo arhivo" + nombre);
	var extension = obtenerExtension(nombre);
	var tipoArchivo = determinarTipoArchivo(extension);
	return tipoArchivo;
}

/**
 * Obtiene la extension
 * @param nombre
 * @returns
 */
function obtenerExtension(nombre){
	console.log("extension" + nombre);
	var partes = nombre.split(".");
	var tipoArchivo = "NA";
	console.log(partes.length);
	if (partes.length>0){
		tipoArchivo = partes[partes.length-1];
	}
	return tipoArchivo;
	
}

/**
 * Determina el tipo de archivo
 * @param extension1
 * @returns
 */
function determinarTipoArchivo(extension1){
	console.log("tipo de extension" + extension1);
	var tipo = "N/A";
	var extension = extension1.toUpperCase();
	if (extension =="PNG" || extension =="JPG" || extension =="JPEG" || extension =="TIF" || extension =="TIFF"){
		tipo = "IMAGEN";
	}else if (extension =="PDF"){
		tipo = "PDF";
	}else if (extension =="MP4"){
		tipo = "VIDEO";
	}
	return tipo;
}

/**
 * funcion que asigna valor de src a href
 * @param contador
 * @returns
 */
function asignarValorHref(contador){
	var cadenaImagen = $("#imagenCarrusel"+contador+"").attr('src');
	$("#imgExpand"+contador+"").attr('href',cadenaImagen);
}


/**
 * Agrega las imagenes al carrusel
 * @returns
 */
function creaImagenesCarrusel(){
	var show = "style='display: block'";
	var dato ="";
	    for (var i=0;i<listaImagenes.length;i++){
	    	    
	    	    if (listaImagenes[i].tipoArchivo=="IMAGEN"){
	    	    	dato+="<div class='mySlides fade' "+show+">";
		            dato+="<a id='imgExpand"+i+"' class='img_carrusel' data-magnify='gallery' data-caption='IMAGEN' data-mdl='1' data-group='a' href='' style='' onClick='asignarValorHref("+i+")'>"; 
		            dato+="   <img id='imagenCarrusel"+i+"' class='img_carrusel' src='data:image/jpg;base64,"+listaImagenes[i].byteArchivo+"' alt='"+listaImagenes[i].nombreArchivo+"' style='width:200px'>"; 
		            dato+="</a>";
		            dato+="</div>";
	    	    }else if (listaImagenes[i].tipoArchivo=="PDF"){
		            dato+="<div class='mySlides fade' "+show+">";
		            dato+="<a href='#visorDocumentosCarruselModal' onClick='cargarPdf("+i+")'>";		             
	    	    	dato+="  <img class='slideshow_img' src='../webResources/img/pdf.jpg'>";
		            dato+="</a>";	    	    	
		            dato+="</div>";
	    	    }else if (listaImagenes[i].tipoArchivo=="VIDEO"){
		            dato+="<div class='mySlides fade '"+show+">";
		            dato+="<a href='#visorDocumentosCarruselModal' onClick='cargarVideo("+i+")'>";		             
	    	    	dato+="  <img class='slideshow_img' src='../webResources/img/video.jpg'>";
		            dato+="</a>";	    	    	
		            dato+="</div>";
	    	    }
	            
	    	show="display: none;";
	    }
	    dato+="</div>";	    
	    dato+="<a class='prev' onclick='plusSlides(-1)'>&#10094;</a>";
	    dato+="<a class='next' onclick='plusSlides(1)'>&#10095;</a>";
	
	$('#imagenesCarrusel').empty();
	$('#imagenesCarrusel').html(dato);
   
}

/**
 * Carga el pdf
 * @param pos
 * @returns
 */
function cargarPdf(pos){
	var dato="";
		dato+="<canvas id='the-canvas'></canvas>"
		$('#visorDocumentos').empty();
		$('#visorDocumentos').html(dato);
		$("#botonesPdf").css("display", "block");
		$('#visorDocumentos').attr('style','overflow: auto;background: #333;border: solid 3px;');
		compatibilidadPdf(listaImagenes[pos].byteArchivo);
}

/**
 * Carga el video
 * @param pos
 * @returns
 */
function cargarVideo(pos){
	//console.log('Cambiando imagen '+pos);
	var dato="";
	dato+="<video class='slideshow_video' src='data:video/mp4;base64,"+listaImagenes[pos].byteArchivo+"' controls autoplay poster='../webResources/img/video.jpg'></video>";
	$('#visorDocumentos').empty();
	$('#visorDocumentos').html(dato);
}


/**
 * Borra imagen del visor
 * @param nombre
 * @returns
 */
function borrarImagenVisor(nombre){
	console.log('borrar imagen visor '+nombre);
	var posicion = obtenerIndexImagen(nombre);
	if(posicion > -1){
		listaImagenes.splice(posicion,1);
	}
	creaImagenesCarrusel();
}

/**
 * Regresa la posicion dentro del arreglo donde se encuentra la imagen
 * -1 si no encontro la imagen
 * @param nombre
 * @returns
 */
function obtenerIndexImagen(nombre){
	var pos = -1;
	for (var i=0;i<listaImagenes.length;i++){
		if(listaImagenes[i].nombreArchivo== nombre){
			pos = i;
		}
	}
	return pos;
}


/**
 * Cerrar Ventana
 * @returns
 */
function closedWindows(n) {
	console.log("Cerrando ventana");
}


/**
 * Boton aceptar
 * @returns
 */
function aceptarImagenCarrusel() {
	$("#aceptarImagenCarrusel").attr("disabled","disabled");
	console.log("boton aceptar");	
	respuestaAceptadaVisorDoc();
}

/**
 * Boton cancelar
 * @returns
 */
function cancelarImagenCarrusel() {
	$("#cancelarImagenCarrusel").attr("disabled","disabled");
	console.log("boton cancelar");
	respuestaCancelarVisorDoc();
}

/**
 * Limpia la imagen seleccionada del carrusel
 * @returns
 */
function limpiarlistaImagenes(){
	listaImagenes=[];
	creaImagenesCarrusel();
}

/**
 * funcion para visor compatible con internet explorer
 * @param contenido64
 * @returns
 */
function compatibilidadPdf(contenido64){
    var pdfData = atob(contenido64);
          
          // Loaded via <script> tag, create shortcut to access PDF.js exports.
          var pdfjsLib = window['pdfjs-dist/build/pdf'];
          var pdfScale = 1; // make pdfScale a global variable
          var viewport;
          var pageNum = 1;
          var canvas = document.getElementById('the-canvas');
          var context = canvas.getContext('2d');
          // The workerSrc property shall be specified.
          pdfjsLib.GlobalWorkerOptions.workerSrc = '../webResources/js/pdfExplorer/pdf.worker.js';
          
          // Using DocumentInitParameters object to load binary data.
          var loadingTask = pdfjsLib.getDocument({data: pdfData});
          loadingTask.promise.then(function(pdf) {
            console.log('PDF loaded');
            displayPage(pdf, 1);
                shownPdf = pdf;
            // Fetch the first page
            
            var shownPdf; // another global we'll use for the buttons

            function renderPage(page) {
                    var scale = pdfScale; // render with global pdfScale variable
                    viewport = page.getViewport({scale: scale});
                    canvas.height = viewport.height;
                    canvas.width = viewport.width;
                    var renderContext = {
                       canvasContext: context,
                       viewport: viewport
                    };
                    
                    if (context) {
                        context.clearRect(0, 0, canvas.width, canvas.height);
                        context.beginPath();
                    }
                    page.render(renderContext);
                 }
        
                 function displayPage(pdf, num) {
                    pdf.getPage(num).then(function getPage(page) { renderPage(page); });
                 }
                 var nextbutton = document.getElementById("nextbutton");
                 if ( $("#nextbutton").length > 0 ) {
	                 nextbutton.onclick = function() {
	                    if (pageNum >= shownPdf.numPages) {
	                       return;
	                    }
	                    pageNum++;
	                    displayPage(shownPdf, pageNum);
	                 }
                 }
        
                 var prevbutton = document.getElementById("prevbutton");
                 if ( $("#prevbutton").length > 0 ) {
	                 prevbutton.onclick = function() {
	                    if (pageNum <= 1) {
	                       return;
	                    }
	                    pageNum--;
	                    displayPage(shownPdf, pageNum);
	                 }
                 }
        
                 var zoominbutton = document.getElementById("zoominbutton");
                 if ( $("#zoominbutton").length > 0 ) {
	                 zoominbutton.onclick = function() {
	                    pdfScale = pdfScale + 0.25;
	                    displayPage(shownPdf, pageNum);
	                 }
                 }
        
                 var zoomoutbutton = document.getElementById("zoomoutbutton");
                 if ( $("#zoomoutbutton").length > 0 ) {
	                 zoomoutbutton.onclick = function() {
	                    if (pdfScale <= 0.25) {
	                       return;
	                    }
	                    pdfScale = pdfScale - 0.25;
	                    displayPage(shownPdf, pageNum);
	                 }
                 }
          }, function (reason) {
              
            // PDF loading error
            console.error(reason);
          });
}



function obtenerParametro(valor){
	console.log("Obtener valor deshabiltar ");
	$.ajax({
		url : 'indicadorImpresionOpc.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json'
	}).success(function(resultado) {
		console.log("valor deshabiltar funcion: "+resultado);
		//1- ocultar descargar pdf, 2- ocultar boton
		if (valor == 1) {
			if (resultado) {
				$("#botones").show();							
			}else{
				$("#botones").hide();				
			}
		}else{
			$("#divDescargar").show();			
			if (resultado) {
				$("#divDescargar").hide();
			}
		}
	})
	.error(function(data) {
		console.log('ERROR obtener valor: '+data);
	});
}

