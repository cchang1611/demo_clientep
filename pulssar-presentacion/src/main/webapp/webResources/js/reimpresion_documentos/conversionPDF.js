
var __TOTAL_PAGES = 0;
var PAGINA_ACTUAL = 0;
var ARCHIVO_ACTUAL=0;

var CONTADOR;
var LISTA;
var PETICION;

var WIDTH = 0;
var HEIGHT = 0;

var PAGINAS_GENERADAS=0;

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
 * y convierte todas sus páginas
 * @param contenido64
 * @param identificador
 * @returns
 */
function agregaPdf(contenido64,nombreArchivo){
	 if(LISTA === undefined){
		 LISTA=new Array();
	 }
	 if(CONTADOR === undefined){
		 CONTADOR = new Object();
	 }
	  CONTADOR.index=0;
	  
	  var peticion = new Object();
	  peticion.contenido64 = contenido64;
	  peticion.nombreArchivo = nombreArchivo;
	  peticion.paginasConvertir=0;
	  peticion.escala=1;
	  peticion.atributo="src";
	  LISTA.push(peticion);
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



/**
 * Inicia el proceso de generación de pdf
 * @returns
 */
function iniciarTransformacionPdf(){
	 if(LISTA != undefined && CONTADOR != undefined){
	    console.log("Total Registros en lista:"+LISTA.length);	 
	    console.log("Archivo actual:"+CONTADOR.index);
	 
	
	if(CONTADOR.index < LISTA.length){  	    
	   PETICION = LISTA[CONTADOR.index];
	   CONTADOR.index +=1;
	   console.log("Generado pdf de :"+PETICION.identificador)
	   soloPdf(PETICION.contenido64);
	   
	}else{
		LISTA=new Array();
	}
	 }
}


/**
 * Realiza la conversion del pdf a imagen
 * @param contenido64
 * @returns
 */
/**
 * @param contenido64
 * @returns
 */

function soloPdf(contenido64){
	var file = new Blob([contenido64],{type:'application/pdf'});
	var fileURL=URL.createObjectURL(file);
	var divImage=document.getElementById("salida");
	var image2='<iframe id="framepdf" width="700" name ="framepdf" height="500" title="Reimpresión" src="data:application/pdf;base64,'+contenido64+'"></iframe>';
	divImage.insertAdjacentHTML("beforeend",image2);
	var idFrame=document.getElementById("viewer");
	console.log(idFrame);
}


function trasnformarPdf(contenido64){
	PDFJS.disableWorker = true;
	var pdfData = atob(contenido64);
	PAGINA_ACTUAL = 0;
	
	
	$('#divConvertidorPdf').empty();
	var canvasContainer = document.getElementById('divConvertidorPdf');

    PDFJS.getDocument({data: pdfData}).then(generarPaginas);

	/**
	 * Inicia la genesracion de pdf
	 */
	function generarPaginas(pdfDoc) {
		__TOTAL_PAGES = pdfDoc.numPages;
		PAGINAS_GENERADAS=0;
		WIDTH = 0;
	    HEIGHT = 0;
		if (PETICION.paginasConvertir > 0){
			__TOTAL_PAGES=PETICION.paginasConvertir;
		}
		
		console.log("TOTAL PAGINAS A GENERAR:"+__TOTAL_PAGES);
		
		for(var num = 1; num <= __TOTAL_PAGES; num++){
			pdfDoc.getPage(num).then(generarPagina);
		}		
	}
	
	/**
	 * Transforma cada pagina
	 */
	 function generarPagina(page) {
		   //console.log(LISTA.length);
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
			
		    WIDTH = viewport.width+20;
		    HEIGHT = viewport.height;

			
	        wrapper.appendChild(canvas);
	        canvasContainer.appendChild(wrapper);
	        page.render(renderContext).then(unionImagenes);
	        
	 }
	 
	 /**
	  * Realiza la union de  imagenes
	  */
	 function unionImagenes(){
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
              
		      for (var i = 0; i < __TOTAL_PAGES; i++) {
		         var canvas1= document.getElementById('Canvas'+(i+1));
				 var ctx1 = canvas1.getContext('2d');
				 var imageData1p=ctx1.getImageData(0, 0, canvas1.width,canvas1.height);
				 ctxPdf.putImageData(imageData1p,0,0);
				 wrapper.appendChild(canvasPdf);
				 canvasContainer.appendChild(wrapper);
				 recepcionImagenPdf(canvasPdf.toDataURL(),i);
				
				
	 		  }
			  
		   }
		 
	 }
	 
	 /**
	  * Funcion que recibe la imagenuna vez terminada la ejecución
	  * @param imagen
	  * @returns
	  */
	 function recepcionImagenPdf(imagen,i){
		 
		var divImage=document.getElementById("slideshow-container");
		var image2='<div class="mySlides fade"><img  class="img_carrusel" src= alt="'+PETICION.nombreArchivo+'" id="Slide1_'+i+'" style="width:50%"/></div>';
		divImage.insertAdjacentHTML("beforeend",image2);
		var imagenRemplazar=document.getElementById('Slide1_'+i+'');
	 	
		if(PETICION.atributo =='href'){
	 	  imagenRemplazar.href=imagen;
	 	}else{
	 	  imagenRemplazar.src=imagen;
	 	}
	 	iniciarTransformacionPdf();
	 }
	
}


