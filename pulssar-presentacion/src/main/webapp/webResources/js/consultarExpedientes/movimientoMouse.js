var mouse=null;
var TIEMPO_60_SEGUNDOS=60000;  // tiempo en milisegundos
var MINUTOS= 5;
var banderaTimeOutBuzon=true;

console.log("Script  de TimeOut ");	

$(document).on('mousemove',function(){
	clearTimeout(mouse);
	mouse= setTimeout(mensajeModal,(MINUTOS*TIEMPO_60_SEGUNDOS));
});


function mensajeModal(){
	console.log("Script  de TimeOut tramites mensajeModal");
}

