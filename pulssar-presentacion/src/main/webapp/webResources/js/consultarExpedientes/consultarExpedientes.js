/**
 * Js que contiene la logica para la consulta de expedientes incluyendo el carrusel
 * jmordone
 */

/**
 * Agrega las imagenes al carrusel
 * @returns
 */
var slideIndex = 1;
showSlides(slideIndex);
var slideIndex02 = 1;
showSlides02(slideIndex02);
var CONTADOR;
var LISTA;
var CONTADOR2;
var LISTA2;
var banderaJS=false;

/**
 * Evento inivial de javascript
 * @returns
 */
$(document).ready(function() {
	configurarTramitesPorServicio();
});

/**
 * Crea carrusel dinamico
 * @param listaExpedientes
 * @returns
 */
function creaImagenesCarrusel(listaExpedientes){
	const listaImagenes = JSON.parse(listaExpedientes);
	console.log(listaImagenes);
	if(listaImagenes!=null && listaImagenes.length>0 ){
		loadingSpinner(true);
		var show = "style='display: block'";
		var dato ="";
		    for (var i=0;i<listaImagenes.length;i++){    
		    	    if (listaImagenes[i].extension=="pdf"){
		    	    	 dato+="<div class='mySlides fade' "+show+">";	             
			    	     dato+="  <img class='img_carrusel' draggable='true' ondragstart='drag(event)' src='../webResources/img/pdf.jpg'  alt='"+listaImagenes[i].nombreArchivo+"' id='Slide1_"+i+"'  style='width:30%'>";    	    	
			    	     dato+=" <h3 id='"+listaImagenes[i].nombreArchivo+"' style='display: none;'>'"+listaImagenes[i].byteArchivo+"'</h3>"
			    	     dato+="</div>"; 
				         agregaPdfTransforma1pagina(listaImagenes[i].byteArchivo,'Slide1_'+i+'');
		    	    }else if (listaImagenes[i].extension=="mp4"){         
			            dato+="<div class='mySlides fade '"+show+">";
		    	    	dato+="<img class='img_carrusel' draggable='true' ondragstart='drag(event)' src='../webResources/img/video.jpg' alt='"+listaImagenes[i].nombreArchivo+"' style='width:50%'/>";  
		    	    	dato+="<h3 id='srcVideo' style='display: none;'>"+listaImagenes[i].byteArchivo+"</h3>";
			            dato+="</div>";
		    	    }else {
		    	    	dato+="<div class='mySlides fade' "+show+">"; 
			            dato+="   <img id='imagenCarrusel' draggable='true' ondragstart='drag(event)' class='img_carrusel' src='data:image/jpg;base64,"+listaImagenes[i].byteArchivo+"' alt='"+listaImagenes[i].nombreArchivo+"' style='width:200px'>"; 
			            dato+="</div>";
		    	    }
		            
		    	show="display: none;";
		    }
		    dato+="</div>";	    
		
		$('#imagenesCarrusel').empty();
		$('#imagenesCarrusel').html(dato);
		loadingSpinner(false);
	}
	
}


/**
 * Crea carrusel dinamico
 * @param listaExpedientes
 * @returns
 */
function creaImagenesSegundoCarrusel(listaImagenes){	
	if(listaImagenes!=null && listaImagenes.length>0){
		$("#overlay").show();
		var show = "style='display: block'";
		var dato ="";
		bandera=false;
		    for (var i=0;i<listaImagenes.length;i++){    
		    	    if (listaImagenes[i].extension=="pdf"){
		    	    	 dato+="<div class='mySlides02 fade02' "+show+">";	             
			    	     dato+="<img class='img_carrusel2' draggable='true' ondragstart='drag(event)' src='../webResources/img/pdf.jpg'  alt='"+listaImagenes[i].nombreArchivo+"' id='Slide2_"+i+"'  style='width:30%'>";    	    	
			    	     dato+="<h3 id='"+listaImagenes[i].nombreArchivo+"' style='display: none;'>'"+listaImagenes[i].byteArchivo+"'</h3>"
			    	     dato+="</div>"; 
				         agregaPdfTransforma1pagina2(listaImagenes[i].byteArchivo,'Slide2_'+i+'');
		    	    }else if (listaImagenes[i].extension=="mp4"){         
			            dato+="<div class='mySlides02 fade02 '"+show+">";
			            dato+="<img class='img_carrusel2' draggable='true' ondragstart='drag(event)' src='../webResources/img/video.jpg' alt='"+listaImagenes[i].nombreArchivo+"' style='width:50%'/>";  
		    	    	dato+="<h3 id='srcVideo2' style='display: none;'>"+listaImagenes[i].byteArchivo+"</h3>";
			            dato+="</div>";      	    	    	
		    	    }else {
		    	    	dato+="<div class='mySlides02 fade02' "+show+">"; 
			            dato+="   <img id='imagenCarrusel' draggable='true' ondragstart='drag(event)' class='img_carrusel2' src='data:image/jpg;base64,"+listaImagenes[i].byteArchivo+"' alt='"+listaImagenes[i].nombreArchivo+"' style='width:200px'>"; 
			            dato+="</div>";
		    	    }
		            
		    	show="display: none;";
		    }
		    dato+="</div>";	
		    dato+="<a class='prev' onclick='plusSlides02(-1)'>&#10094;</a>";
		    dato+="<a class='next' onclick='plusSlides02(1)'>&#10095;</a>";
		$('#imagenesCarrusel2').empty();
		$('#imagenesCarrusel2').html(dato);
		
		//se agrega funcion para expandir imagenes esto se realiza debido a que se crea el carrusel dinamico
		$(".img_carrusel2").mousedown(function(e) {		
			var nombre = $(this).attr('alt');
			var arrayCadena = nombre.split("\.");
			var formatFile = arrayCadena[1];
		    var rutaVideo;
		    var rutaPdf;  
			// 1. izquierdo 2. medio/rueda 3. derecho
			if (e.which == 1) {
				BOTON_MOUSE=1;
				if (formatFile == 'mp4'){
					var format="data:video/mp4;base64,";
					rutaVideo=document.getElementById('srcVideo2').innerHTML;
					var videoHTML= "<source  type='video/mp4' src="+format+rutaVideo+">";
					$('#idVideo').html(videoHTML);
					$("#imgExpand").hide();
					$("#idVideo").show();		
				}			
				else if (formatFile == 'pdf') {
					if(banderaJS==false){
						rutaPdf=document.getElementById(nombre).innerHTML;
						agregaPdfhref2(rutaPdf,"imgExpand");
						iniciarTransformacionPdf2();
						banderaJS=true;
					}else{
						rutaPdf=document.getElementById(nombre).innerHTML;
						agregaPdfhref2(rutaPdf,"imgExpand");
						iniciarTransformacionPdf2();
						$('#imgGran').attr('src',$(this).attr('src'));
						$('#imgExpand').attr('href',$(this).attr('src'));
						$("#idVideo").hide();		
						$("#imgExpand").show();
					}
					
					
				}else{
					$('#imgGran').attr('src',$(this).attr('src'));
					$('#imgExpand').attr('href',$(this).attr('src'));
					$("#idVideo").hide();		
					$("#imgExpand").show();
				}
			}else if(e.which == 3 ){
				BOTON_MOUSE=3;
				if (formatFile == 'mp4'){
					  var format="data:video/mp4;base64,";
					  rutaVideo=document.getElementById('srcVideo2').innerHTML;
					   var videoHTML= "<source  type='video/mp4' src="+format+rutaVideo+">";
					   $('#idVideo2').html(videoHTML);
					   $("#imgExpandTwo").hide();			
					   $("#idVideo2").show();		
			    }
				else if (formatFile == 'pdf') {
					if(banderaJS==false){
						rutaPdf=document.getElementById(nombre).innerHTML;
						agregaPdfhref2(rutaPdf,"imgExpandTwo");
						iniciarTransformacionPdf2();
						banderaJS=true;
					}else{
						rutaPdf=document.getElementById(nombre).innerHTML;
						agregaPdfhref2(rutaPdf,"imgExpandTwo");
						iniciarTransformacionPdf2();
						
						$('#imgGranTwo').attr('src',$(this).attr('src'));
						$('#imgExpandTwo').attr('href',$(this).attr('src'));
						$("#idVideo2").hide();		
						$("#imgExpandTwo").show();
					}
					
				}else{
					$('#imgGranTwo').attr('src',$(this).attr('src'));
					$('#imgExpandTwo').attr('href',$(this).attr('src'));
					$("#idVideo2").hide();		
					$("#imgExpandTwo").show();
				}
			}

		});

		
		$("#imgExpand").click(function() {
			if (windows1 == 1) {
				$("#windows_a").find("*").prop("disabled", true);
			}
			windows1 = 1;
		});
		$("#imgExpandTwo").click(function() {
			if (windows2 == 1) {
				$("#windows_b").find("*").prop("disabled", true);
			}
			windows2 = 1;
		});

		$("#habilitar").click(function() {
			$("#windows_a").find("*").prop("disabled", false);
			$("#windows_b").find("*").prop("disabled", false);
			windows1 = 0;
			windows2 = 0;		
		});
		setTimeout(function(){
			$("#overlay").hide();
			
		},400);	
		
	}
   
}


/**
 * plusSlides
 * @param n
 * @returns
 */
function plusSlides(n) {
	showSlides(slideIndex += n);
}

/**
 * currentSlide
 * @param n
 * @returns
 */
function currentSlide(n) {
    showSlides(slideIndex = n);
}

/**
 * showSlides
 * @param n
 * @returns
 */
function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    if(dots.length>0){
    	dots[slideIndex-1].className += " active";
    }
    if(slides.length>0){
    	 slides[slideIndex-1].style.display = "block";
    } 
}


function plusSlides02(n) {
	showSlides02(slideIndex02 += n);
}

function currentSlide02(n) {
    showSlides02(slideIndex02 = n);
}

function showSlides02(n) {
    var i;
    var slides02 = document.getElementsByClassName("mySlides02");
    var dots02 = document.getElementsByClassName("dot");
    if (n > slides02.length) {slideIndex02 = 1}
    if (n < 1) {slideIndex02 = slides02.length}
    for (i = 0; i < slides02.length; i++) {
        slides02[i].style.display = "none";
    }
    for (i = 0; i < dots02.length; i++) {
        dots02[i].className = dots02[i].className.replace(" active", "");
    }
    if(dots02.length>0){
    	dots02[slideIndex02-1].className += " active";
    }
    if(slides02.length>0){
    	 slides02[slideIndex02-1].style.display = "block";
    } 
}

/**
 * Evento en la tabla click
 * @returns
 */
function configurarTramitesPorServicio(){
	
    $('#tablaExpedientes').on('click','tr',function(e) {
		e.preventDefault();
		var renglon=$(this),
		  descripcionExpediente,
		  cvTipoProceso,
		  chFechaOperacion,
		  afore,
		  curp,
		  tipoServicio;
		
		$(this).children('td').each(function (i){
			switch (i) {
			case 0:
				break;
			case 1:
				descripcionExpediente=$(this).text();
				break;
			case 2:
				cvTipoProceso=$(this).text();
				break;
			case 3:
				chFechaOperacion=$(this).text();
				break;	
			case 4:
				afore=$(this).text();
				break;
			case 5:
				curp=$(this).text();
				break;
			case 6:
				tipoServicio=$(this).text();
				break;
			}
		})
		obtieneExpediente(cvTipoProceso,chFechaOperacion,afore,curp,tipoServicio);
	});
	
}





/**
 * obtiene email
 * @param modulo
 * @returns
 */
function obtieneExpediente(cvTipoProceso,chFechaOperacion,afore,curp,tipoServicio) {
	try {
		$.ajax({
			method : "GET",
			url : "consultaExpedientesClaveDocumento.do",
			contentType : "application/json",
			data : {
				cvTipoProceso : cvTipoProceso,
				chFechaOperacion:chFechaOperacion,
				afore:afore,
				curp:curp,
				tipoServicio:tipoServicio
				
			}
		}).success(function(data) {
			if(data.mensajeError!=null && data.mensajeError!=""){
				mostrarDiv(data.mensajeError);
			}else{
				$('#carruselDosNombreExpediente').text(data.nombreExpediente);
				creaImagenesSegundoCarrusel(data.listaImagenes);
			}
			
			
		});
	} catch (err) {
		console.log("Ocurrio un error ::" + err);
	}
}


/**
 * Agrega los documentos a conversion
 * y solo genera la imagen de la primera página
 * @param contenido64
 * @param identificador
 * @returns
 */
function agregaPdfTransforma1pagina(contenido64, identificador){
	 if(LISTA === undefined){
		 LISTA=new Array();
	 }
	 if(CONTADOR === undefined){
		 CONTADOR = new Object();
	 }
	  CONTADOR.index=0;
	 
	  var peticion = new Object();
	  peticion.contenido64 = contenido64;
	  peticion.identificador = identificador;
	  peticion.paginasConvertir=1;
	  peticion.atributo="src";
	  peticion.escala=1;
	  LISTA.push(peticion);
}

/**
 * Agrega los documentos a conversion
 * y solo genera la imagen de la primera página
 * @param contenido64
 * @param identificador
 * @returns
 */
function agregaPdfTransforma1pagina2(contenido64, identificador){
	 if(LISTA2 === undefined){
		 LISTA2=new Array();
	 }
	 if(CONTADOR2 === undefined){
		 CONTADOR2 = new Object();
	 }
	  CONTADOR2.index=0;
	 
	  var peticion = new Object();
	  peticion.contenido64 = contenido64;
	  peticion.identificador = identificador;
	  peticion.paginasConvertir=1;
	  peticion.atributo="src";
	  peticion.escala=1;
	  LISTA2.push(peticion);
}

/**
 * Agrega los documentos a conversion
 * y convierte todas sus páginas
 * @param contenido64
 * @param identificador
 * @returns
 */
function agregaPdf(contenido64, identificador){
	 if(LISTA === undefined){
		 LISTA=new Array();
	 }
	 if(CONTADOR === undefined){
		 CONTADOR = new Object();
	 }
	  CONTADOR.index=0;
	  
	  var peticion = new Object();
	  peticion.contenido64 = contenido64;
	  peticion.identificador = identificador;
	  peticion.paginasConvertir=0;
	  peticion.escala=2;
	  peticion.atributo="src";
	  LISTA.push(peticion);
}

function agregaPdf2(contenido64, identificador){
	 if(LISTA2 === undefined){
		 LISTA2=new Array();
	 }
	 if(CONTADOR2 === undefined){
		 CONTADOR2 = new Object();
	 }
	  CONTADOR2.index=0;
	  
	  var peticion = new Object();
	  peticion.contenido64 = contenido64;
	  peticion.identificador = identificador;
	  peticion.paginasConvertir=0;
	  peticion.escala=2;
	  peticion.atributo="src";
	  LISTA2.push(peticion);
}

/**
 * Agrega la imagen generada en el componente href
 * @param contenido64
 * @param identificador
 * @returns
 */
function agregaPdfhref(contenido64, identificador){
	 if(LISTA === undefined){
		 LISTA=new Array();
	 }
	 if(CONTADOR === undefined){
		 CONTADOR = new Object();
	 }
	  CONTADOR.index=0;
	  
	  var peticion = new Object();
	  peticion.contenido64 = contenido64;
	  peticion.identificador = identificador;
	  peticion.paginasConvertir=0;
	  peticion.escala=2;	  
	  peticion.atributo="href";
	  LISTA.push(peticion);
}

function agregaPdfhref2(contenido64, identificador){
	 if(LISTA2 === undefined){
		 LISTA2=new Array();
	 }
	 if(CONTADOR2 === undefined){
		 CONTADOR2 = new Object();
	 }
	  CONTADOR2.index=0;
	  
	  var peticion = new Object();
	  peticion.contenido64 = contenido64;
	  peticion.identificador = identificador;
	  peticion.paginasConvertir=0;
	  peticion.escala=2;	  
	  peticion.atributo="href";
	  LISTA2.push(peticion);
}


/**
 * Inicia el proceso de generación de pdf
 * @returns
 */
function iniciarTransformacionPdf(){
	 if(LISTA != undefined && CONTADOR != undefined){
	    console.log("Total Registros en lista:"+LISTA.length);	 
	    console.log("Archivo actual:"+CONTADOR.index);
	 
	
	if(CONTADOR.index < LISTA.length){  	    
	      var PETICION = LISTA[CONTADOR.index];
	   CONTADOR.index +=1;
	   console.log("Generado pdf de :"+PETICION.identificador)
	      trasnformarPdf(PETICION);	   
	}else{
		LISTA=new Array();
	}
	 }
}

function iniciarTransformacionPdf2(){
	 if(LISTA2 != undefined && CONTADOR2 != undefined){
	    console.log("Total Registros en lista:"+LISTA2.length);	 
	    console.log("Archivo actual:"+CONTADOR2.index);
	 
	
	if(CONTADOR2.index < LISTA2.length){  	    
	      var PETICION2 = LISTA2[CONTADOR2.index];
	   CONTADOR2.index +=1;
	   console.log("Generado pdf de :"+PETICION2.identificador)
	      trasnformarPdf2(PETICION2);	   
	}else{
		LISTA2=new Array();
	}
	 }
}


/**
 * Realiza la conversion del pdf a imagen
 * @param contenido64
 * @returns
 */
function trasnformarPdf(PETICION){
	PDFJS.disableWorker = true;
	var pdfData = atob(PETICION.contenido64);
	
	
	$('#divConvertidorPdf').empty();
	var canvasContainer = document.getElementById('divConvertidorPdf');

    PDFJS.getDocument({data: pdfData}).then(function generarPaginas(pdfDoc) {
    	var __TOTAL_PAGES = pdfDoc.numPages;
    	var PAGINA_ACTUAL = 0;
		var PAGINAS_GENERADAS=0;
		var WIDTH = 0;
		var HEIGHT = 0;
		if (PETICION.paginasConvertir > 0){
			__TOTAL_PAGES=PETICION.paginasConvertir;
		}
		
		console.log("TOTAL PAGINAS A GENERAR:"+__TOTAL_PAGES);
		
		for(var num = 1; num <= __TOTAL_PAGES; num++){
	
			//GENERA LAS PAGINAS
			pdfDoc.getPage(num).then( function generarPagina(page) {			   
	        var viewport = page.getViewport(PETICION.escala);
	        var wrapper = document.createElement("div");
	        wrapper.className = "canvas-wrapper";
	        var canvas = document.createElement('canvas');
	        var ctx = canvas.getContext('2d');
	        var renderContext = {canvasContext: ctx, viewport: viewport};
	        
	        canvas.height = viewport.height;
	        canvas.width = viewport.width;
			canvas.style.display = 'none';
			canvas.id = "Canvas"+(++PAGINA_ACTUAL);
			
		    WIDTH += viewport.width+20;
		    HEIGHT = viewport.height;

			
	        wrapper.appendChild(canvas);
	        canvasContainer.appendChild(wrapper);
	 
			    //REALIZA LA UNION DE IMAGENES
			    page.render(renderContext).then(function unionImagenes(){
		 PAGINAS_GENERADAS ++;
		 console.log("PAGINAS  GENERADAS:"+PAGINAS_GENERADAS);
	   if(PAGINAS_GENERADAS == __TOTAL_PAGES){
		   
		      var wrapper = document.createElement("div");
	          wrapper.className = "canvas-wrapper";
		   
  		      var canvasPdf = document.createElement('canvas');
		      var ctxPdf = canvasPdf.getContext('2d');
			  canvasPdf.height = HEIGHT;
              canvasPdf.width = WIDTH;
              canvasPdf.style.display = 'none';
              canvasPdf.id="final";
			  var contador = 0;
				 
		      for (var i = 0; i < __TOTAL_PAGES; i++) {
		         var canvas1= document.getElementById('Canvas'+(i+1));
				 var ctx1 = canvas1.getContext('2d');
				 var imageData1p=ctx1.getImageData(0, 0, canvas1.width,canvas1.height);
				 ctxPdf.putImageData(imageData1p,contador,0);
				 contador +=canvas1.width+20;
				
	 		  }
			  wrapper.appendChild(canvasPdf);
			  canvasContainer.appendChild(wrapper);
			        	 
			        	 //MANDA A LA GENERACION DE LA SIGUIENTE IMAGEN
			        	 recepcionImagenPdf(PETICION,canvasPdf.toDataURL())
			        }
			    });
		    });
		   }
	});
		 
	 }


/**
 * Realiza la conversion del pdf a imagen
 * @param contenido64
 * @returns
 */
function trasnformarPdf2(PETICION2){
	PDFJS.disableWorker = true;
	var pdfData = atob(PETICION2.contenido64);
	
	
	$('#divConvertidorPdf2').empty();
	var canvasContainer = document.getElementById('divConvertidorPdf2');

    PDFJS.getDocument({data: pdfData}).then(function generarPaginas(pdfDoc) {
    	var __TOTAL_PAGES = pdfDoc.numPages;
    	var PAGINA_ACTUAL = 0;
		var PAGINAS_GENERADAS=0;
		var WIDTH = 0;
		var HEIGHT = 0;
		if (PETICION2.paginasConvertir > 0){
			__TOTAL_PAGES=PETICION2.paginasConvertir;
		}
		
		console.log("TOTAL PAGINAS A GENERAR:"+__TOTAL_PAGES);
		
		for(var num = 1; num <= __TOTAL_PAGES; num++){
	
			//GENERA LAS PAGINAS
			pdfDoc.getPage(num).then( function generarPagina(page) {			   
	        var viewport = page.getViewport(PETICION2.escala);
	        var wrapper = document.createElement("div");
	        wrapper.className = "canvas-wrapper";
	        var canvas = document.createElement('canvas');
	        var ctx = canvas.getContext('2d');
	        var renderContext = {canvasContext: ctx, viewport: viewport};
	        
	        canvas.height = viewport.height;
	        canvas.width = viewport.width;
			canvas.style.display = 'none';
			canvas.id = "Canvas"+(++PAGINA_ACTUAL);
			
		    WIDTH += viewport.width+20;
		    HEIGHT = viewport.height;

			
	        wrapper.appendChild(canvas);
	        canvasContainer.appendChild(wrapper);
	 
			    //REALIZA LA UNION DE IMAGENES
			    page.render(renderContext).then(function unionImagenes(){
		 PAGINAS_GENERADAS ++;
		 console.log("PAGINAS  GENERADAS:"+PAGINAS_GENERADAS);
	   if(PAGINAS_GENERADAS == __TOTAL_PAGES){
		   
		      var wrapper = document.createElement("div");
	          wrapper.className = "canvas-wrapper";
		   
  		      var canvasPdf = document.createElement('canvas');
		      var ctxPdf = canvasPdf.getContext('2d');
			  canvasPdf.height = HEIGHT;
              canvasPdf.width = WIDTH;
              canvasPdf.style.display = 'none';
              canvasPdf.id="final";
			  var contador = 0;
				 
		      for (var i = 0; i < __TOTAL_PAGES; i++) {
		         var canvas1= document.getElementById('Canvas'+(i+1));
				 var ctx1 = canvas1.getContext('2d');
				 var imageData1p=ctx1.getImageData(0, 0, canvas1.width,canvas1.height);
				 ctxPdf.putImageData(imageData1p,contador,0);
				 contador +=canvas1.width+20;
				
	 		  }
			  wrapper.appendChild(canvasPdf);
			  canvasContainer.appendChild(wrapper);
			        	 
			        	 //MANDA A LA GENERACION DE LA SIGUIENTE IMAGEN
			        	 recepcionImagenPdf2(PETICION2,canvasPdf.toDataURL())
			        }
			    });
		    });
		   }
	});
		 
	 }

	 
	 /**
	  * Funcion que recibe la imagenuna vez terminada la ejecución
	  * @param imagen
	  * @returns
	  */
function recepcionImagenPdf(PETICION,imagen){
	 	console.log ("Termino Generacion "+PETICION.identificador);
	 	var imagenRemplazar=document.getElementById(PETICION.identificador);
	 	if(PETICION.atributo =='href'){
	 	  imagenRemplazar.href=imagen;
	 	}else{
	 	  imagenRemplazar.src=imagen;
	 	}
	 	iniciarTransformacionPdf();
	 }

function recepcionImagenPdf2(PETICION2,imagen){
 	console.log ("Termino Generacion "+PETICION2.identificador);
 	var imagenRemplazar=document.getElementById(PETICION2.identificador);
 	if(PETICION2.atributo =='href'){
 	  imagenRemplazar.href=imagen;
 	}else{
 	  imagenRemplazar.src=imagen;
 	}
 	iniciarTransformacionPdf2();
 }


/**
 * loadingSpinner
 * @param active
 * @returns
 */
function loadingSpinner(active) {
	//true para activar
	//false para desactivar
	if (active) {
		$("#overlay").show();
		//$("#overlay").fadeIn(300);		
	}else{
		setTimeout(function(){
			$("#overlay").hide();
			//$("#overlay").fadeOut(300);
		},600);		
	}
}

/**
 * mostrarDiv
 * @returns
 */
function mostrarDiv(mensajeError){
	$('#exitoModalAceptarVisor').css("opacity", "1");
	$('#exitoModalAceptarVisor').css("pointer-events", "visible");
	$('#exitoModalAceptarVisor').css("display", "block");	
	$('#mensajeExitoAceptarVisor').html(mensajeError);
	$('#tituloExitoAceptarVisor').html("Error");
}

/**
 * ocultarDiv
 * @returns
 */
function ocultarDiv(){
	$('#exitoModalAceptarVisor').css("opacity", "0");
	$('#exitoModalAceptarVisor').css("pointer-events", "none");
	$('#exitoModalAceptarVisor').css("display", "none");		
}


