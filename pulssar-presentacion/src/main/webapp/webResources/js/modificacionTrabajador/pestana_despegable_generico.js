
var abierto = false;

function mostrarDesplegableReferencias(){
  if(abierto==false){
 	document.getElementById("referencias1").style.display = "block";
 	document.getElementById("referencias2").style.display = "block";
 	abierto = true;
  }else{
	  document.getElementById("referencias1").style.display = "none";
	  document.getElementById("referencias2").style.display = "none";
	  abierto = false;
  }
}


function mostrarDesplegableBeneficiarios(){
	if(abierto==false){
	 	document.getElementById("desplegableTablaBeneficiarios").style.display = "block";
	 	abierto = true;
	  }else{
		  document.getElementById("desplegableTablaBeneficiarios").style.display = "none";
		  abierto = false;
	  }
}