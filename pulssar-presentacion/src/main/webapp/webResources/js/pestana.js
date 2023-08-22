//$(document).ready(function() {
//	ocultarBotonEditar();
//});



function mostrar(vElement) {
	var stiloElemento = document.getElementById(vElement).style.display;
	if(stiloElemento == "block") {
		document.getElementById(vElement).style.display = "none";
	} else {
		document.getElementById(vElement).style.display = "block"
	}
}


function bloquearEnlace(link){
    link.style.pointerEvents = 'none';
    link.style.color = '#bbb';
}


//function ocultarBotonEditar(){
//	if(_AFORE_SESION == _AFORE_PARAMETRO && _TIPO_SOLICITANTE_SESION != _TIPO_SOLICITANTE_PARAMETRO){
//        var botonEditar = document.getElementById("botonEditarMdd");
//        if ( $("#botonEditarMdd").length > 0 ) {
//    		document.getElementById("botonEditarMdd").style.display = "none"
//        }
//	}
//}