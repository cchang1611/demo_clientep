//Función para generar Captcha
function generaCaptcha(){
	$('#defaultReal').realperson({regenerate: '', dot:'1'}); 
}

//Función para comparar HashCode de código generado contra una cadena.
function compareCaptcha(){
	var captchaHash = $('#defaultReal').realperson('getHash');
	var input = document.getElementById('defaultReal').value;
	var inputHash = getHashCode(input);
	if(captchaHash === inputHash){
		return true;
	}
	return false;
}

//Método para obtener hashCode de una cadena con Javascript
function getHashCode(value) {
	var hash = 5381, len = value.length;
	if (value.length === 0) {
		return hash;
	}
	for (i = 0; i < len; i++) {
		charC = value.charCodeAt(i);
		hash = ((hash<<5)+hash)+charC;
		hash = hash & hash;
	}
	return hash;
}