var imgWidth;
var imgHeight;
var valorSign;//1 -Trabajador 2- Agente
var numeroArchivos = null;
$(document).ready(function() {
	$("#btnFirmarTrabajador").click(function(event) {
		$("#btnFirmarTrabajador").attr("disabled","disabled");
		inicioFirma(1);
//		obtieneDatosPruebaTemporal(1);
	});
	
	$("#btnAgenteFirma").click(function(event) {
		$("#btnAgenteFirma").attr("disabled","disabled");	
		inicioFirma(2);
//		obtieneDatosPruebaTemporal(2);
	});
	$("#btnRecepcionImgCop").click(function(event) {
		$("#btnRecepcionImgCop").attr("disabled","disabled");
		window.location.href = "#modalLoader";
		var solicitanteFiltrado;
		if("10" == SOLICITANTE){
			solicitanteFiltrado = SOLICITANTE
		}else{
			solicitanteFiltrado = SOLICITANTE.substr(1);
		}
		
		if(NSS == "" || NSS == null){
			NSS = "0";
		}
		
		if(CURPSOLICITANTE == "" || CURPSOLICITANTE == null){
			CURPSOLICITANTE = "0";
		}
		var PAGOBANCO = "0";
		var digita = {
		folioProcesar : FOLIOPADRE,
		proceso : SERVICIO,
		curpTitular:CURP,
		nssTitular:NSS,
		curpSolicitante:CURPSOLICITANTE,
		tipoSoliciante:solicitanteFiltrado,
		idRFCModificado:CAMBIORFC,
		idSesion:IDSESION,
		pagoBanco:PAGOBANCO,
		tipoFlujo:FLUJODIGITALIZADOR
		
	};
		
		SignInicio(JSON.stringify(digita));
//		continuarProceso();
//		window.location.href = "documentosAdicionalesExpedienteServicio.do";
	});
	
	$("#btnRegresarModifDatos").click(function(event){
		$(location).attr('href', 'modificaTrabajador.do');
	});	
	
	$("#btnModalActExpContinuar").click(function(event){
		$("#btnModalActExpContinuar").attr("disabled","disabled");
		window.location.href = "#modalLoader";
		event.preventDefault();
		continuarProceso();
	});
	
	$("#btnModalActExpCancelar").click(function(event){
		$("#btnModalActExpCancelar").attr("disabled","disabled");
		window.location.href = "#modalLoader";
		event.preventDefault();
		terminarProceso();
	});
	
	$('#btnErrorM').click(function(event) {
		window.location.href = "datosGenerales.do";
	});
	
	
});

function continuarProceso(){
	console.log("Entro continuar proceso");
	numeroIntentos = 0;
	numeroArchivos = 0;
	consultaIntervaloImagenes();
}

function consultaIntervaloImagenes(){
	var intervalo =	setInterval(function(){
		cosultaRecepcionImagenes(intervalo);
		},30000)
}

function cosultaRecepcionImagenes(intervalo){
	numeroIntentos++;
	console.log(numeroIntentos);
	$.ajax({
		url : 'consultarRecepcionImagenes.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json',
		data : {
			folioPadre : FOLIOPADRE,
			cvProceso : SERVICIO,
			estatus : "1"
		}
	}).success(function(recepcion) {
		if(recepcion != null){
			numeroArchivos = Number(recepcion.numeroTotalRecibidos);
			clearInterval(intervalo);
			console.log("intervalo detenido, consulta imagenes");
			if(numeroArchivos > 0){
				console.log("enviando submit");
				$("#fm_recepcionImagenes").submit();
			}else{
				console.log("sin archivos , enviando recepcion de archivos");
				window.location.href = "enviarSolicitudBan.do";
			}

		}else if(numeroIntentos == Number(INTENTOS)){
			console.log("numero intentos agotado, muestra modal");
			clearInterval(intervalo);
			window.location.href = "#";
			var tituloModal = "<h2 class='ModalTitle' >Solicitud</h2>";
			var mensajeModal = "Aun no se han encontrado archivos ¿Desea continuar con el tramite?";
			$('#tituloActExp').empty();
			$('#mensajeActExp').empty();
			$('#tituloActExp').append(tituloModal);
			$('#mensajeActExp').append(mensajeModal);
			$('#botonesModalActExp').show();
			window.location.href = "#modalActExp";
		}
	})
}

function terminarProceso(){
	$.ajax({
		url : 'terminarFolio.do',
		type : "GET",
		contentType : 'application/json',
		dataType: 'json',
		data : {
			idFolio : IDFOLIO_HIJO,
			estatus : "2"
		}
	}).success(function(resultado) {
		$(location).attr('href', 'datosGenerales.do');
	})
}

/**
 * Inicia la toma de la firma
 * @param signValue
 * @returns
 */
function inicioFirma(signValue) {
	valorSign = signValue;
	var peticion = generaPeticionFirma();
}

/**
 * Genera la peticion
 * @returns
 */
function generaPeticionFirma(){
	
		var url = contextoSistema+"/public/generaPeticionPadFirma.do";
			$.ajax({
				method      : "GET",
				url         : url,
				contentType : "application/json",
			})
			.success(function(data) {
				  console.log(data);
				  ejecutaWebServiceFirma(data);
				
			})
			.error(function(data) {
				console.log("Error en al generar la peticion");
				console.log("stringify "+JSON.stringify(data));		
			});
	
	
}

//Obtiene el objeto de peticion
function getHTTPObjectFirma(){
    var xhr = false;
    if (window.ActiveXObject) {
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch(e) {
            try {
                xhr = new ActiveXObject("Microsoft.XMLHTTP");
            } catch(e) {
                xhr = false;
            }
        }
    } else if (window.XMLHttpRequest) {
        try {
            xhr = new XMLHttpRequest();
        } catch(e) {
            xhr = false;
        }
    }
    return xhr;
}

/**
* Realiza la peticion a coppel
* @returns
*/
function ejecutaWebServiceFirma(peticion){
		soapData 	= "",
		httpObject 	= null,
		docXml 		= null,
		iEstado 	= 0,
		sMensaje 	= "";
		sUrlSoap 	= peticion.urlSoap.replace("tps", "tp");
		
		//Cadena para la ejecuci�n de la aplicaci�n
		soapData=peticion.soapData;
		soapData= remplazarFrima(soapData, "tps", "tp")
		
		//Objeto para la peticion
		httpObject = getHTTPObjectFirma();

		if(httpObject){
			if(httpObject.overrideMimeType)
				httpObject.overrideMimeType("false");

			httpObject.open('POST', sUrlSoap, false); //-- no asincrono
			httpObject.setRequestHeader("Accept-Language", null);
			httpObject.onreadystatechange=function(){
				if(httpObject.readyState == 4 && httpObject.status == 200){
					parser = new DOMParser();
					docXml = parser.parseFromString(httpObject.responseText, "text/xml");
					iEstado = docXml.getElementsByTagName('Estado')[0].childNodes[0].nodeValue;
					sDescripcion = "";
					if(iEstado ==1){
							sDescripcion = docXml.getElementsByTagName('DescripcionEstado')[0].childNodes[0].nodeValue;
							if(valorSign == 1) {
								firmaAgente = "";
								firmaTrabajador = sDescripcion;
								generarPdfSolicitudModificacionDeDatos();							
								$("#btnFirmarTrabajador").css("display", "none");
								$("#btnAgenteFirma").css("display", "block");
							}else if (valorSign == 2){
								firmaAgente = sDescripcion;
								generarPdfSolicitudModificacionDeDatos();		
								$("#btnAgenteFirma").css("display", "none");
								$("#btnRecepcionImgCop").css("display", "block");
							}
//							agregarFirma(sDescripcion);
							
					}else if(iEstado == -1 && valorSign == 1){
						console.log("se cierra pad firma trabajador");
						$("#btnFirmarTrabajador").removeAttr("disabled");		
					}else if(iEstado == -1 && valorSign == 2){
						console.log("se cierra pad firma empleado");
						$("#btnAgenteFirma").removeAttr("disabled");

					}else {
						document.getElementById('tituloError').innerHTML = "ERROR";
						document.getElementById('mensajeErrorModal').innerHTML = "SE PRESENT\u00D3 UN ERROR EN EL DISPOSITIVO C&Oacute;DIGO {" + iEstado + "} PARA LA TOMA DE FIRMA FAVOR DE REPORTARLO";
						window.location.href = "#errorModal";
					}
				}else{
					document.getElementById('tituloError').innerHTML = "ERROR";
					document.getElementById('mensajeErrorModal').innerHTML = "SE PRESENT\u00D3 UN ERROR EN EL DISPOSITIVO PARA LA TOMA DE FIRMA FAVOR DE REPORTARLO";
					window.location.href = "#errorModal";
					console.log(httpObject.status);
				}
			};
			httpObject.send(soapData);
		}
	
}



/**
 * Remplaza la cadena
 * @param cadena
 * @param cadenaBuscar
 * @param valor
 * @returns
 */
function remplazarFrima(cadena,cadenaBuscar,valor){
	
	while(cadena.search(cadenaBuscar) != -1){
		cadena = cadena.replace(cadenaBuscar,valor);
	}
	
	return cadena;
}



/**
 * Agrega las firmas
 * @param respuestaDatos
 * @returns
 */
function agregarFirmas(respuestaDatos){
	if(valorSign == 1) {
		firmaAgente = "";
		firmaTrabajador = respuestaDatos.DescripcionEstado;
		generarPdfSolicitudModificacionDeDatos();
		$("#btnFirmarTrabajador").css("display", "none");
		$("#btnAgenteFirma").css("display", "block");
	}else if (valorSign == 2){
		firmaAgente = respuestaDatos.DescripcionEstado;
		generarPdfSolicitudModificacionDeDatos();	
		$("#btnAgenteFirma").css("display", "none");
		$("#btnRecepcionImgCop").css("display", "block");
	}
}


//Se usa para probar firmas como texto
function obtieneDatosPruebaTemporal(valorSign) {
	if(valorSign == 1) {
		firmaAgente = "";
		firmaTrabajador = "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I+bzyCxFpoWXCTO25sjJvvwOPDE35NH9VOVacFOIR1YYoY/uxtDQghG0c3kyHZC0yhXPWCr4nu+bz0+ikMXhMfjRvUqsY8kkvPicT/EealRyARBhcuSqx38daqTAmKxE6J23k4bH811og+V6ao6w0thXYKhial6OKR/2W9JaDGCNx3HGzruN+yn9PaNMGQGX1FaOWzm3KZ7dooP3YmdAPXqrrsiZBho26rKIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgLDuiytMz2xsc952a0FxPkAOaD517S7EmZzmG0rTcd7MgntFp+GNvPn+BP4L6FWiZDBHFE0NjY0Na0dAB0C+dey0OzeazuqLDediY1q58o2nnt/IfRfTGKD0vBcAFh0gBO/br6L5jqLOZDWOTn03pNzo6jDwX8o3m1g7sYe5/10TdFU9rtm3r+3+hdLVJLrcW50tiwx2zS7bYtb2P/AHUwybO5fTtPTOlcFdwdQRiKzcuAM9239oN7knzX0rTGn6OnMVFQx0fBGweJxHikd3c49ypjh9U5RDaWwNPTmGr43HsDYo27l5+J7j1c49ySpnh59fnzXsDZFQA2REQEREBEWCdggysE7Lms3a9bb30rGHyJ5/go6bLWZSBjMbPPudveS/qmfPnz/kgmuIbrivZGnj4/eXbMUDPN7gN/oo51HL3nH7Xkm1Iv+HTb4v8And/Zbcfp/HUiHtg99P1M05948n5n+iDjZqOa+eHCY6xYB/zph7qIfU8z9Fh+GyuSP/i+TMUH/p6Q4Afm481Zg0AbDomyCMx2Gx+P51KsTH95C3d5+bjzUmG7FZRAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREAqm+1nLOw+hMlNG4tllaIGEdi87flurk7oqZ7UtOWNTaRno0nhttr2zRBx2DnN35H5gn67KaO/QGMbiNHYqo0AOELXv27ud4j+amb1yCjWlsW5o4a8TeJ8kjuFrR5kqkUdWZWvia1YaVyz8nHGI3R8LRFxAbbiTfbbkuePSmZ1RYjs63ssjqRu448VUcfd79jI7q4hTqdcVvJZX2iWZaOCMmP0w0ltnIkbPsjfm2P09f8AsvoOn8NRwWMhoY2ERV4xyHUuPck9yuyrWir144YY2RwsaGsYxuwaPIDyXVsnFERFoEREBERAREQF4kjEg2JcB6HZe0Qc8VWCH/Dia0+e3M/Vby0E81lEDZERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEIB6hEQNh5LGwHQBZRAREQEREBERAREQEREBERAREQEREBERAREQERN0BERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERATYIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiD/2Q==";
		generarPdfSolicitudModificacionDeDatos();
		$("#btnFirmarTrabajador").css("display", "none");
		$("#btnAgenteFirma").css("display", "block");
	}else if (valorSign == 2){
		firmaAgente = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAYEBQYFBAYGBQYHBwYIChAKCgkJChQODwwQFxQYGBcUFhYaHSUfGhsjHBYWICwgIyYnKSopGR8tMC0oMCUoKSj/2wBDAQcHBwoIChMKChMoGhYaKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCj/wAARCAE2AgADASIAAhEBAxEB/8QAHAABAAIDAQEBAAAAAAAAAAAAAAUGAQMEAgcI/8QARhAAAQQBAgQDBQQIAwYFBQAAAQACAwQFBhESITFBIlFhBxMycYEUUpGxFSNCYnKhwdEzQ/AWJFOS4fElNFRjggg2ssLS/8QAFgEBAQEAAAAAAAAAAAAAAAAAAAEC/8QAGBEBAQEBAQAAAAAAAAAAAAAAACEBETH/2gAMAwEAAhEDEQA/AP1SiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIm6AiwHA9CnEEGUTcIgIiICIiAiIgIiICIiAiIgIiICIiAiE7dVjcIMoiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiwXbdOaDJWOIeqg85qXGYUBtyyDO7k2GMccjj6Af1UK+fU+eaDTjZhKTttnzgPmcPRv7P1QWbK5ejiaxnyNmOCMDfxHmfkOpVaOsL2TJGlsLYut/wDUWD7mL6b8yu7GaMxdOX7RaZJkLnUz23e8O/oDyCsjI2saGtADRyA25BBRBg9bZEF1/UlfHscd/dUoA4tHlxOXl+ktT0mGXF6xtyzjn7u9Cx8btu3IbgL6COSwT2QVfRuoX5iO1VyEDauYoSe5t12ncAkbhzT3a4cwrSvmPs+sfpf2k6xysH/k2GKmxw6Pcwcz/IL6cgIiICIiAiIgIiICIiAiIgIiHkEBN15LvIblUrVGvMfiJPsNGOTK5dx4WVKvjId+8Rvt+f5oLTkrTatOaw58UbYmOeXSu4WDYftHsFWPZrqq3qzD2LtukysGTmKN0biWSgftNJ6jff8ABQFfSOf1fZjt66tiHHBwezEVj4flIe/y5r6XVrRVII4a8bI4YxsxjRsGjyAUHSOiIEVBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAWCVpsTx143STyNjjaNy5x2A+qqdvUd3LzyUtLQe82PDJfeNoo/l5lBP5nNUsPX99fnZGDya3q5x8gO6rP2jUGpXb0w7D4t3ISvG80o9B2HqpLDaVrVLLbmQlfkMh1M0x3DSfut7KzhoCCDwmmsdiNnwxGW0Rs+zMeOR/wAyVOcI3WUQEREBUb2l6klw+KZQxZD83kXe4qxjm4bnYv8Ap+an9S52rp7Ez37r/BGNmsHxPcejR5lVbQmEuXMlJqnUYH6SsjhrQEbCtF22HmQgn9D6di0xpypjoyHStBfNJ3kkPNx3+f5KyLAaAsoCIiAiIgIiICLzuuS1kqlb/FsRtPlvufwQdqFQ0uXe48NKnYndtuDtwt/msB+anPKOrWbtyLiXlBM7815MjW78RDfmVEuxdqdpbayU5BO/6oBi5reNxGNryWL8pbG0bufPMeeyCYlv1Yv8SxC0+ReFC53WWDwtd0l6/EHbeGNh4nu+QVUbk7GcmfV0ZiYoa++zslYZ4W792g9T+KmdMaCx+Lsfbsg85LKE7mecfCf3W9kFUnz2Y1qRHHZOncK7fdxBM8o9Nun8vqrbpajpnTtZrMdJEJiOF9iTnLIfMu2VvEMewHu2beXCEMMR6xsPzaEHPFkKcjtobMLz5B43XWHg8xsQuOxicfYB99Tgd/8AAKNfpqvEeLHWbdF2+/6qXdv/ACu3CCwDmEVYktZ7FNDrEMeVrA+J0DeCZo8+E8nfTZSeIy1TLVzNRmEgaeF7dtnMPk4HmCglEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERARFqsSMhiMkr2sY3mXOOwCDYVAah1HVw5bEOKxdfyjrRc3uPr5BRNrO39QWJqOmWGONjuCS/K08G3fgPcqXwGnqmJJmaDPdeP1lmQbvd8vIIIePAZHP2W2tSzmOuCHR4+E+Ebfed3VwggirwsihjZHG0bBrRsAt46IgbBERAREQFH5XJV8VSmuXZRHXibu4n8h5lbcjcgoVJLNqRscMbeJziVScZUtaxvMyeWjdFg4ncVSm8bGVw6Pd6eQ/wBENWFxtrV+Xiz2fhMePhPFj6Tu4++8eZ5EL6KGjyXmNoaxoAAAGwHkvaAiIgIm61TzRwx8cr2saO7jsEG1YJ5lQUmd9/IY8XXktuH7W2zAfmsfo/IXtzkLRhiP+TBy/F3/AHQd9rK1Kzyx84dJ/wANnid+AXHJfyVk8NCn7tpHKWc7bfRd1LG1ae/uIQHnq883H6ruQQTsPPb2ORvSvHI8EXgaF3VMXTqsDYa7Bt3I3P4ld6wUDYeQXiRwjaXOIa0cySdgFA57VFHFOdCHGxeHw1oubifL0UI7D5zU0rH52U4+g3YipXceN38R/wBfRB05bWPvJjS0zWdk7wOxLR+rZ6krTR0bLkLIv6stuvWOra7XEQs9Nu/+uqtWJxtTFVGVqMLIYm8tgOZ+Z7lSA6INEEMcELIoY2MjaNmtaNgFv2CIgIiICbAoiBsFU9QYCR1r9MYIivmYh57R2R9yQd9/PqFbFhBE6eyrMzjIrTWOikJLJYXfFFI3k5p9QVLqo1YzjNeTxMG1bLQfaNh0E0ZAcfTdpH1BVuQEREBERAREQEREBERAREQEREBERAREQEREBERAREQFgkbHmhI5qt5/UjKU7Mfj4/tWUm5MhHRp83eQQSGey9PEUnWLkmw6NY3m558gFWmUMnqx0U+YMtHFjxNpMd4pefIuPkuzB6bf9tOTzz228i47hu+8cHkGj5d1bQNkGinWhqQMhrxNiiYNmsaNgF0IiAiIgIiIC479uCjTls2ZAyGIFznH/XVesjdgoU5LNuQRwxjdziqlTqWNWWYr2SY+DEMIdBVcecp++70Qa6tWfWVyK9eifDg4XbwVnbh1g9Q93kPRXeNgYwNaA0AbAAbAfJZY0MaGtADRyAHZe0BFguAXHeyFajEX2ZA0Dt1J+iDt3HmuS9dr04+OzK1jT036n5KKdbyOTaRjYxWhPSeYcz06BbqeBgil99afJbsf8SY77fIINbclbvu4cZUc2IjnNOOH8B3XqLBtkl99kZpbcm+4Djswemym2jZZQaoYmQsDImNY0dA0bBbUTfnsgJuPNanSNa0ucdmgbknkAFV7+qH2bZx+nq7rdvlxTbbRsB7koJzL5eliqpnvTsjZtuBvzd8h3VUdfzWqRtiGHH4t3WxI3aR4/d+fp+K7cbpEOssu5+y7JXWjwh/+Gzz2H+h6K2MaGgADYAbbDoghMFpvH4cccEIfaPx2JBu9x/p9FOt9VlEBERAREQEREBERARE3QVrPf/dumuEePisc/Jvu+asqqgeb/tDa1nOLGUzxn/3JXch/yt3+qtaAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiIC8ueGglx2A6krXPMyvG6SZ7WRtG7nOOwAVKltXdZTvr0jLTwbTtJZB2dOd+jfRBvymet5a3JitNNBcPDNdI/Vxb+XmpfTunquFhPugJbUnOaw8buef6D0Xdi8bWxlOOrSjEULRyA7+p8yu8BAA2REQEREBERAXBlslWxdKW1ckEcTBuSe/oPVecvlauKpPs3XhrByDRzLj5Ad1XsbjLGobTMnnGubUaeKrReOTR2c8dyg1Y+ha1Rbbkcyx0OOYeKrScNuLnuHv8AP5K6Mbw9NtuyyG8J814llbEwvkc1rANySeQQbSdlzXLkFSIy2ZGxsHdx23ULYzkl2V1fBMZYla4B8rt+Bn917paea60LmUnfbs9Q13wMPoEHl+QvZTduJj91AeX2mTl+AXRj8HHXIlszSW7Hd8x4gPkFMBgA2HLtyXpB5Ddtum3kvSIgIhOy0zzMhjL5HNawcy5x2A+qDaXbKHzmdp4ln69/FMRuyFnNzv7D1UNd1Fbyto0dNxcfLx3HDwRnl/PmpDBaagx8n2qzI+5fPMzy8y35eSCJbjsrqWVs2UkkoY4EPZVZye7+L/qrVjsfWx9dsFKFkMTezR19Se67eEbLKAiIgIiICIiAiIgIiICIiAuLJ3ocbQsXLTuGCBhe8+g/quxztlVMi46gzzcc0b4yi8S23dpJRzZF9OTj9EHTo2pLDj33bkYZeyMhtTju3f4W/RvCPorGsAbLKAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIeSATsuHKZGvjarrFyQRxAgbnuT0A9VozmXrYai+zbeGhoJawHxO9AFXcdjbepLMeTzzDHUY7ir0XdvJz/P5INcFW7rC19qyTX1sIznDX6Om/ed6K6QQRQQsihYI42ANa1vIADsFtY1rWgNAAHQDsvSAiIgIiICIiB3URn87UwlcPtP3lf4Yomjd0jvIBc2ptQQ4aNrGh092XwwwMG7nHouPA6emdfOXzzhPkX82R9WVx5DzPqg14fD28lfZl9QE+9B3r1P2YR5keat23CNwtFu1DUrvnsyNihYN3Od2VXsX8vnZRFhmirji7Z9uT4njb9gIJfL52vRcIYh9puuOzK8Z3cf7KNhxOQzL/e5+Xgg5OZUhJG38RUthsLTxbSYG8czh+smed3vPmSpXhHkg01qsNeERQRtjjb0a0bBbwNhsiICIiAsOOwWuaRsUbnyOaxjRuXOOwCqV/UlnKTvoaXDZ5hyksu5RxD59ygls7qClhowLEnFO74IGDd7+w5KEZi8nqcsmzjnU8fycynGdnH+IqVwOm4Me82bchu5F/N9iUb/AIDsrDwjyQc9KnBSrMr1YmxQs6NaNl0gbDYdERAREQEREBERAREQEREBERAWCdlkqF1BmG4uONkTDYvzngr129Xu8z5NHcoObUWUnilixmMLXZS0DwbjcQs7yu9B0HmVI4XGQYnHRVa/E4N3c57ubnuJ3c4+pPNcuAxJoCWxclFjJWSHTzevZoHZo7KcHRAREQEREBERAREQEREBERAREQEREBERAREJGyAeiiNQ5qthaJnsuLnn/DiafE93kF51JnK2Epe9n3fI88MUTfikd5KHwGEs2r36Zz+77jucNcndsDe3Lz/1zQeMHhbWUuMzOohvNydBTPwwjtuPNXJg6rLQsoCIiAiIgIi8vcGt3JAHmUGSqxqPUf2Sy3HYyP7VlZeTI2/Cz1cuTNZ2zkrkuG04WvtDds1knwQjz3Hf0UpgcHUwddz9w+y4bz2pT4nnvuT0CDVpzT4oONzIy/a8pJzdK/nwcubW+QXvPajgxrvcV2OuZF3wVoTu7f8Ae8go69mb+bmdS0y0NiB4Zr7x4WefB5lSuBwFTDtc6Fhksyc5J383PPfn2HogjKGAu5OZtzU8wlIG7KTB+rj+fmVa442xtaxjQ1jeQAHIBbUQEREBEWCfUIMqLzOapYeAy3pmsH7Ld/E75BRWe1KIJxQw8YvZKTkGMd4WeritWJ0s19gZHPuF3IuA+IeCPryA79UHI2tlNWFstx0tDDkbthb8c4Pn5DZWrF4+rjarYKUDIYR+ywdT5nzPquxo4dgBsF7QNkREBERAREQEREBERAREQEREBD0WHEbdVBZnLurTMpY2L7XkpB4Ygdmxj77z2H5oNmby7ccyKKJjrF+c8MFdh5vPXmezR3K04PESV3vvZOQWMpMNnyAeGNv3GDs0fz7rZhcQ2i99mzI61kZgPe2Hf/i0dmjyCnB0QYAG3QLKIgIiICIiAiIgIiICIiAiIgIiICIiAiIgbqF1FnKuDx5sWCXvceGOJvxPd2C6c1la+JpOs2nbAcmt7uPkFXNOYm1lLbc3qBrTOSTWrkeGFvY7eaD3pvDWbVoZnPAPtv5ww7eGBp9PNXADZA3nvusoCIiAiIgIeSLhyORrY6q6e3KI4x3J6nyCDomljiic+R7WMaNy5x2AVLt5C9qm5Lj8WySti4ztNePLj2/ZZ5rLK93V1gS3WyVcE0nghHhfP5E+ilM3maenKENetCH2CA2tThHid5cuwQbwMXpXDPfs2GBnNx28Ujv6klQTaeR1g5kuSY+hhgQ5lcO2km7+I9h6Lrw2AtXbrctqOT3to84qu+8cH07lW9o2CDnpVIaVaOCrCyKFg2axg2AXSERAREQEWC4Ac1F53NU8NTdYuScP3WD4nnyAQd1meKvE6WeRrI2jdznHYAKnS5TIaonfVwjXVsaN2y3XD4xt0Z6r1BjL2qZm284JKuPaQYqTXEGQeb/7K31q8daFkUEbI4mDZrWjYD6II/BYCjhYSynCA9w8crub3n1Kl0HREBERAREQEREBERAREQEREBETfqgLBcNuq02bMNWB81iRscTRzc47AKuMfb1CSIjNSxW+xf8ADLY+X3W9fUoNlzJ2MhPLQ0+WOmYeGa24bxw+g+8706BSeJxcONiLYhxyvPFLO7nJI7zce66qNOGjXjgqRsigYNgxo2C6UGANllEQEREBERAREQEREBERAREQEREBERAREQFw5K9Bjqktm08MijG5P9PmVvsTMgifLK5rY2Auc49gO6pUDJNX5P7TZaW4OAkRxnl79w7n0/7IN+Koy6kyEeZykfDUZzqQE9vvOCugbsvDY2ta1rRs0DYAcgFsQEREBERAWOLmhOyqmX1FNPYlx2nGfabzeT5Nv1cPqT0QSecz1XENa2XilsyeGKCMcT3n5KCxmBtZS5DldTOc+Vji6CkCOCIHpxeZ/kpXT2no8Y59q1M+5kJTxPnk/Z36ho7BcOos9NJcdhNPAS5VzfHIPgrjzcfP0QdGo9QCjKzH42J1nLTDaONo3DB95/kFnTenvsUhvZOY28vIPHO7ozf9lo7BdGmsBDhq5LnusXpec9mT4pD/AG9FOtaG9EGA3buvSIgIiIC8uds0nbfbyQkqnZrUk9q67D6cYJ75/wASf/LhHc7+aDu1NqSPGe7q1IXXcjK4NZBHzI9Tt0XLgtNyTWG5PUbxbyR2LWH4IR5AdN126Z05Bhw+aR7rF+YbzWHncuJ5nbyG6sIAHRAaNu+6yiICIiAiIgIiICIiAiIgIiICIVz2J468TpZ3tjiaN3PcdgB6oN+/PZRWSy8NKUV42usXnjwV4+bj6nyHqVwuu3sxs3Eg16pOzrkjeZH/ALbT1+ZUtQxtenGRE0l7/jkcd3PPmSgiaOIs252XM/I2WZh4oqzP8KL/APp3qrGGgIAsoAREQEREBERAREQEREBERAREQEREBERARD0KrerdU0dLV4Z8ky29szixgrwmQk9djt0QWReXkjbZfPW+0maw3ioaS1DYb1DjBwA/ioPO66zmVEmHxmlcnDdePGHSM4gzbc9+W6Cz5OeXVmTdjKb3MxcB/wB6nA295z+FpVwpVoa1WKKvG2OJjeFrR2C+e4bUGXxGPipw6GywYzq73sRLj3J59V3t13fYdrOj87EPNjGv/IoL4iog9pFBh2uYnO1T395RedvwXRD7StMSEiS/JXd5TwPZ+YQXNFXqer9P29hBmaDnHsZgD/PZS8NytOAYLMMg/ckB/JB1LmvXIKUDprUrYomjcucVFZ7PVsUGx+Oxcfv7uvCOJ7jt5Dp81H08Jcytz7fqJzS3rDRB3bH/ABeZQc77eR1Wfd410tDFhwLrJGz5efNrR8u6suLxlTGVvc04WsaTxE9XOPmT3K7I2NYxrWNDWtGwAGwAVR1dnrLLjMHp4Nly848TifDXZ953kfJB51JnbVi/+gtOePIO29/YHw1mE8yT95TWncHVwdQw1wXyyO45pnnd0ju5J/ovOmsFXwVEwxH3k0h455nfFK89Sf6KdQYDQOgWURAREQFqkkbGxz5HBrG8y53IBasjcgoVZLFuVsULBuXOOwVFH6R1zOJGvlpacA4duklk7/yCDdcy13VVubGYAvhoxnaxfI5Hru1qtOCxFTDUmVqUYDernn4pD5k9yuqhSr0KsdarEyKBg2axo6Lr2HkgAAdEREBERAREQEREBERAREQERD0KAsOJAUTlc1VxuzJnvfYf8EEQ4pHfTsuIVslmWtdfc7H1T1qxn9Y8eT3jp9EG7IZ2Nlg1MdE69e6GOP4Wfxu6ALxBhJLUzbOdmFuQeJkAG0MZ9B3PqVMUadelC2GrCyKNo5BoXTsEHlrQGgAbAdB5L0iICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAvMgHD4gCPVeio7NZOvicfNctO2jjG+3dx8ggi9W5wYmvHDXHvMhZPBBF19N/5rbpXC/ouq99h3vchYIksSnnu7yHoOii9J42xetP1Blm7Wpm7V4j/ks7bfP8j6q5t35oMjoiJugLS+GN7SJI2OHqAtvEPNV3NaorUJvslWOS9kXDdleAbn6noEHRkMLgpIny38djnNaN3PlhYdh89l89vaZxOpJTDpvCQ14N9n3/FGG/wgHYq2xafv5mWKxqSZoiYeJlGAkMG/3z+0VaoYmwsayNjWRtGwa0bABBQqXssxVJzZqeQzEFsN4TNHZ2J+mykI9LZmt/5TV+SA33AniZL9OYVyJA+qgNW6gradxLrk4MkhIjghbzdLIejR/VBT9RZTVeGtVsfTymPyeTtEiGD7KWva3b4zs7YAeqzpnH6p07BMHYilkbNhxkntMtlr5Dv6jpz7Kd0Lp+xUM+azO8mbyADpd+kDe0bfIBXIcggpn+1+SrHbIaVy0fbeHhlH8ivcWvcMR/vQvU+5+0VHt2+uyt/nyWHMDhs4A/MIIKnq3AXCBBmKTiezpQ0/z2UxXswWG8VeeKVvmx4d+S47mCxdxrhax1SUO68ULTv/ACUJP7PtNu2MNA1XdA6tM+Mj5bFBbt1D6hzVPB0XW70mzN+FjW83Pd5AKi6px8Gm4mNx+czz78uzK9OOyJS89tw4Hl6rGJ0NqG1Yr5bOZ3iyTOccUsDJWRDyPQb+oQd2Pw+Q1bdhyWpGvrY9h4q+PB+L1f8A63PyX0KNoYxrWgNaBsAOgVbjo6pj2/8AGaEg/epEE/g5dUNTP7/r8jR2/cqn+rkE6i54Y5WMDZpfeu+9w8P5LoQEREBERAREQEREBETcICbqOyOUpY5jXXLDIy7k1vVzj5AdSoplnM5c/wC6QHGVCec0w4pXD91vb6oJTJ5Krj2b2pg0nfhYObn+gaOZUWX5jLsLYmOxNU9JHbOncPQdG/VduMwdWhI6cNdPbf8AHPMeJ5/sPQKZQRWHw1TFs/UMc6Z3OSaU8Ujz5lylURAREQEREBERAREQEREBERAREQEREBERBgrBOy9LBCm9DdN02TZSoxxLO4TZYSjy+RrGOc4gNaNyT2Xz+vvrjOiZ7XDA0XFrW9BO8eY8lt1jkJsnko9L4l7hYm2NqUdI4+v+voFMz3aGkMNVbJFYFCMiN0sUReGb/tv257E99u6VViZyHTb0C97qnWPaNpeIeDKR2HcvBXY6Un8AtQ1fkMkAMDpvIzB3Sa437PH8/FzI+iUXXj9D+CruV1biqEwrtmNu44btrVh7x5+g6KNjwWocvIH6gy4rV+9PHbtB+ch5n6bKfw2CxuGi93jqkcO/xPA3e71LjzKVEAyvqHPyyG492Hxbvghj2M7xt+0ejVYMNhaGGhMePriPi+N55vf/ABOPMrTntRYnT8HvMrdhrg/C1x3e/wCTRzKhGawyWTYDp7TV+xE4eGxcIrRn1G+5I+iVV03O/f8ABZ4lSw7XdnmI8BTHkXSSuH5BZdW10BxNyGCefI13gfjulFtmmZDE6SRwaxo4nOPIADqSvnWmYn601U/U1sE4ik50OKid0eQfFMR+Sr/tIy2szWg03PUxr7GWJYDRmd7x0bebxs7YN3HLdXX2fajxlyJ2Cq0rOMvY2JrZaFloD2N6bgjk4eqtRdW7gc+q9brAG4WdlKG6wXLOy8F2wJ7DulHouG3dU/VOqnV7Yw+BYLuckHKPbdsI+88/0XDldR2s9dkw2kHgvZu2zkescA36NPdysOmNOUsBVMdVvHNJzmsP5vld5k/0Vo4dLaXjxkz8jkJTdzU3OWw/nw/utHYfzVqHTuvWybKUN03TZNkobhY4k2KbFKpvus7pzWHchzSocSwXgeaj8vk6eHoTXclMyvVibxPkeeX/AFK+auzuqfaBYczS3FhMAHcLshO39bL/AAD+34pR9CzOpMNhGE5bJVah68MkgDj8m9T+C0YPV+Bz0rosPla1qVvWNrtnAefCdjt6qv4P2W6bxrhNdrvy14832LzjIXHz2PLqqXqSjU1N7SsbhtJ1K1H9Eye+u36sYjLdj8ALfoPmfRVX3TiTiUTkM3TpTe4dIZbJG4hiHE8/2XCG53Ku2eWYqtv0aeOYj8gpRI5XNUsa1otTbSOOzYmgue75NHNRzbGbysrmwQjGUyOUsuzpXD0b0H1XfjcHSx27q8IMxO7ppPG9x8ySpUN27pUQ+NwNKjObDWOmtuO7rE7uN5+p6fRTA2WeaxsUqs7puE2WNilQ4lnfkmybJRjiQuCbFZ5pRjiHqgcs81jYpVOJOJNimxShxLO6xsVnmlQ3TdNk2Shum6xsVnZKMcScSzsmyUYJWN162TZKMoiLSiIiAiIgKu6xz0en8PJZd4p3n3cDAObnnpy9FOyvEbXOkcGsAJJPYL53hGO1jq9+ZnaTicc4xVWO6Pk35u+nX8EE5ofCSY6ibmRJflbp95PI74mg9GfL+pVrLN+52WeEb/zWUHPFWhiPFHExh82sA/Jby31KytFiZkEL5ZXtZGwFznOOwAHUoPFmxFTgkmnkZFCwF73vOwaB1JK+eyalzOtbMtXRw+x4ph4JcvMwni8xE3v81EwfafapnJZZXyQaLoy8DYhu03njuT93py+XdfWadWCpWjgqxMhhjHCxjBsGj5IK5p3RGKxE32p7H38k7m+7cPvJHH035N+itfCO/NZA2CIMBoCw8cl6QjdB8g1HYzFf2tSWquBuZJ0VAV6JA4YWvdzc5zzyAHP1Vr0PpafESX8rmJ2Wc9kXB1iWMeBjR0YzfsP5q58I227LOyAERYJPog5cjkK2Opy2rs0cFeMbufIdgFRPeZXXLgyv77F6acfFI7wz2x+6P2WFT82loL+Qbczc8mRfG7ihhk8MMXyYORPqd1ZGsa0ANAAHQBBw4fE08PTZVx0DIIW/stHU+Z8z6qRAREBERAREQERD0QCuPJXYcdRnuW3tjggY6R7z0AA3W+SRscZc9zWtHUuOwC+X+1XIx6hhwuCxl6B9W9a3uSxSgtZEzYu4iD05/iAg4cZi7ntPy0eczwfBpqB5+w0N9vf7ftP+f/RfWq8MVeBkMDGRRMHC1jRwho9B2Vcgzddgix+nKL7jImBrTGOCFgHQcR/ooTWVqTEY05LUN50j3eGvjqjixssh5Bu/U+pQY9o2tfsMH6G05vc1Bd/VwshHF7oHq4nz67fiufQehMjisSa1279nbORLY9x/jyv338Unlz6Lp9mOjjjGvzeYiAzV0blmx2rMPRg8jt1X0YNGwQcGPxlSgwNrRBrtti883n5uPNd4bttzWUQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAQ9UXBl70ONx1m7ZdwwwRmR30HRBT/aNlppn19NYt4+35Hwvdv/AIce43P4b/RWvBYyvhsVWoVRtFCwNB7uPcn1JVO9nOPlyFm3qzKs4bl0lsDTz93EO4+e34BfRAOSzgyiItAqF7aRkXez3IsxMT5JX8LZAwbu93v4tgr6vLxugp/sws4eXR2Lgwk8UsMMLQ9jSOJr9t3cQ677kq5DoqXl/Z7hL1916q2xi8geZsUJPdOJ8yByP4Lw3HayxjOGnmKOVjb0ZfgMbyP42f2QXdFT/wBO6nrN2uaWMxHV9O6x4PyDgCvI1blNjxaPze/p7o//ALILksOOwXzjLe0a7j3xRSaVyIsTHhjhfNG17z6NBJ+uy7WT67y0Q93UxWCjePimkdYmb/8AEAN3+qC5SWIonME0scbnnZrXODSfl5roaSeqouH9nWPr5JuUzVq5msm13GJrb/Ax3mxg5BXpvdBlNgiIGwREQEREBERARFD5POY/GuLLFhpmPNsLPE93oGhBMHoVyX79ajE6S5PHCwDfxu2UH9rzeU2+xQNxtY/5tkcUhH7rO31Wu/iKeJxl/KTh123BDJN72wePm1pPIdB0QfMdYZbI+03U3+zGm5XR4eqOO7YJLA877c++2/Qd1cdKeyjA4J5lkYbMxaGniGzeXp3XL/8AT/jRBo+TKSje3krD5ZHnqQHEDn+Kueq9RY/TeO+05CQgvPDFCznJM77rQOZKmeDZqDMY/TGHfbuObDBGNmRsA4pHdmtHclVHSmDu53Ms1XqmP3dnb/cKDulZnZxH3+62af09kM9lI9Rawi4J4jvRx3VlZvZzh3evobB4efM+aoNaOEDZekRAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERB5J6L5xruxJn9SUNK03H3LyJrzmnowdt/l/MhXfOZGHFY21esuDYq8Ze7f+X4nkqf7K8dO6pb1BkGbXco8vG/VsYPIfX+ynovVWGOCvFDCwMijaGtaOwHQLoQcgnZUY3HmsbjzVf1lqnHaSxByGUdJ7ovEbGRN3c9x7ALzo7VFPVeFGTx8U8UBkdHtM3hO467LO7RYy4DusFzfPqvhuqc9qzVOYv2NCzTDGYdzWkRO4ftT9/F/F06eXzVkn9o9m5QEGE09lpc25vCIpq5ZHG7bq5x5bb/knRMas17TwmVhw9KpYyuamALadbbcA9C5x5Bch1pnqLg7L6MyUUB/zKsrbHD8wNj+aezXR0+E+1ZXOyttahvuLp5d+L3Y+4P6n5K/hpAVFJZr9k44aOn8/YnI5MNMs/EuICwWayz8gEnuNN48/EGOE9l4+e3Cz+avW3JZ2VFdwGl8ZhHGarA6S48frLc7jJM/5uPMfIbBWJvRYWQpgIiKgiIgIm6xxBBlNx5qIy2ex2MaBbtNbI7k2NvieT6AKNdk83kvDiscKsJ6Wbp25eYYOaCyTSsijMkj2sY0blzjsB9VX59VVZHuhxEcmSsb7cEA8I+bzyCxFpoWXCTO25sjJvvwOPDE35NH9VOVacFOIR1YYoY/uxtDQghG0c3kyHZC0yhXPWCr4nu+bz0+ikMXhMfjRvUqsY8kkvPicT/EealRyARBhcuSqx38daqTAmKxE6J23k4bH811og+V6ao6w0thXYKhial6OKR/2W9JaDGCNx3HGzruN+yn9PaNMGQGX1FaOWzm3KZ7dooP3YmdAPXqrrsiZBho26rKIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgLDuiytMz2xsc952a0FxPkAOaD517S7EmZzmG0rTcd7MgntFp+GNvPn+BP4L6FWiZDBHFE0NjY0Na0dAB0C+dey0OzeazuqLDediY1q58o2nnt/IfRfTGKD0vBcAFh0gBO/br6L5jqLOZDWOTn03pNzo6jDwX8o3m1g7sYe5/10TdFU9rtm3r+3+hdLVJLrcW50tiwx2zS7bYtb2P/AHUwybO5fTtPTOlcFdwdQRiKzcuAM9239oN7knzX0rTGn6OnMVFQx0fBGweJxHikd3c49ypjh9U5RDaWwNPTmGr43HsDYo27l5+J7j1c49ySpnh59fnzXsDZFQA2REQEREBEWCdggysE7Lms3a9bb30rGHyJ5/go6bLWZSBjMbPPudveS/qmfPnz/kgmuIbrivZGnj4/eXbMUDPN7gN/oo51HL3nH7Xkm1Iv+HTb4v8And/Zbcfp/HUiHtg99P1M05948n5n+iDjZqOa+eHCY6xYB/zph7qIfU8z9Fh+GyuSP/i+TMUH/p6Q4Afm481Zg0AbDomyCMx2Gx+P51KsTH95C3d5+bjzUmG7FZRAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREAqm+1nLOw+hMlNG4tllaIGEdi87flurk7oqZ7UtOWNTaRno0nhttr2zRBx2DnN35H5gn67KaO/QGMbiNHYqo0AOELXv27ud4j+amb1yCjWlsW5o4a8TeJ8kjuFrR5kqkUdWZWvia1YaVyz8nHGI3R8LRFxAbbiTfbbkuePSmZ1RYjs63ssjqRu448VUcfd79jI7q4hTqdcVvJZX2iWZaOCMmP0w0ltnIkbPsjfm2P09f8AsvoOn8NRwWMhoY2ERV4xyHUuPck9yuyrWir144YY2RwsaGsYxuwaPIDyXVsnFERFoEREBERAREQF4kjEg2JcB6HZe0Qc8VWCH/Dia0+e3M/Vby0E81lEDZERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEIB6hEQNh5LGwHQBZRAREQEREBERAREQEREBERAREQEREBERAREQERN0BERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERAREQEREBERATYIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiAiIgIiICIiD/2Q==";
		generarPdfSolicitudModificacionDeDatos();
		$("#btnAgenteFirma").css("display", "none");
		$("#btnRecepcionImgCop").css("display", "block");
//		validaFlujo9B();
	}
}