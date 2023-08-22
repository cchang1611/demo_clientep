$(document).ready(function () {
    if (banderaIssste == 0) {
        combosVacios();
        //agregarOnchangesNoCargado();
        consultarNoCargadoRegimen();
        $("#fechaIncioPensionT").val("01/01/0001");
        $("#fechaEmisionPensionT").attr("readonly", "readonly");
        $("#fechaIncioPensionT").attr("disabled", "disabled");
    } else {
        combosVacios();
    }
    $("#aceptarSiefor").addClass("disabled_Url");
    document.getElementById("tipoRecurso").style.display = "block";
    $("#botonPlanPrivado").addClass("disabled_Url");
    $("#botonCargado").addClass("disabled_Url");
    $("#botonNoCargado").addClass("disabled_Url");
    deshabiltarCamposInicio();
    fechaSolicitud();
    deshabilitarOpcionesDisposicion();

    document.getElementById("cargaMensajeIssste").innerHTML = _MENSAJE;
    document.getElementById("tituloIssste").innerHTML = _TITULO;
    window.location.href = "#miModalOpcionCarga";
    $("#miModalOpcionCarga").show();
    deshabilitarOpciones();
    $("#aceptarRes").addClass("disabled_Url");

    $("#tablaResolucion tr").on("click", "input[type=radio]", function () {
        const $tipoPrestacion = $("#tipoPrestacion");
        const $seguro = $("#seguro");
        const $retiro = $("#retiro");
        const $tipoPension = $("#tipoPension");
        const $regimen = $("#regimen");
        const $pension = $("#pension");
        const $movimiento = $("#movimiento");
        $tipoPrestacion.empty();
        $seguro.empty();
        $retiro.empty();
        $tipoPension.empty();
        $regimen.empty();
        $pension.empty();
        $movimiento.empty();
        $("#descripcionTipoPrestacion").val($(this).closest("tr").find("td").eq(2).text());
        $("#descripcionSeguro").val($(this).closest("tr").find("td").eq(3).text());
        $("#descripcionRetiro").val($(this).closest("tr").find("td").eq(4).text());
        $("#descripcionTipoPension").val($(this).closest("tr").find("td").eq(5).text());
        $("#descripcionRegimen").val($(this).closest("tr").find("td").eq(6).text());
        $("#descripcionPension").val($(this).closest("tr").find("td").eq(7).text());
        $("#descripcionMovimiento").val($(this).closest("tr").find("td").eq(8).text());
    });

    var table = $("#tablaResolucion").DataTable({
        select: {
            style: "multi",
        },
        language: {
            decimal: "",
            emptyTable: "No hay información",
            info: "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
            infoEmpty: "Mostrando 0 to 0 of 0 Entradas",
            infoFiltered: "(Filtrado de _MAX_ total entradas)",
            infoPostFix: "",
            thousands: ",",
            lengthMenu: "Mostrar _MENU_ ",
            loadingRecords: "Cargando...",
            processing: "Procesando...",
            search: "Buscar:",
            zeroRecords: "Sin resultados encontrados",
            paginate: {
                first: "Primero",
                last: "Ultimo",
                next: "Siguiente",
                previous: "Anterior",
            },
        },
        columnDefs: [
            {
                targets: [10],
                visible: false,
            },
        ],
        bInfo: false,
        order: [],
        lengthMenu: [
            [4, 16, 24, 50],
            [4, 16, 24, 50],
        ],
        fnDrawCallback: function (oSettings) {
            $("input[name='res']").prop("checked", false);
            var valor = document.getElementById("valorRadioDos").value;
            if (valor != "") {
                $("input[name='res'][value='" + valor + "']").prop("checked", true);
            }
        },
    });

    $("#fechaIncioPensionT").datepicker({
        minDate: "-10y",
        //maxDate: new Date(),
        changeMonth: true,
        changeYear: true,
        dateFormat: "dd/mm/yy",
        lenguage: "es",
        monthNames: ["Enero", "Febrero", "Marzo", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
        monthNamesShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
    });

    $("#fechaEmisionPensionT").datepicker({
        minDate: "-10y",
        //maxDate: new Date(),
        changeMonth: true,
        changeYear: true,
        dateFormat: "dd/mm/yy",
        language: "es",
        monthNames: ["Enero", "Febrero", "Marzo", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
        monthNamesShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
    });

    $("#regimen").change(function () {
        console.log("regimen");
        $("#aceptarIssste").addClass("disabled_Url");
        $("selecccionDerecho").empty();
        ocultarTablasSubcuentas();
        var datos = {};
        datos.claveTipoRegimen = $("#regimen").find("option:selected").val();
        consultarNoCargado("retiro", datos);

        $("#retiro").empty();
        $("#seguro").empty();
        $("#tipoPension").empty();
        $("#tipoPrestacion").empty();
        $("#pension").empty();
    });

    $("#retiro").change(function () {
        $("#labelDocProbatorio").hide();
        $("#docProbatorio").hide();
        if ($("#retiro").find("option:selected").val() == "E") {
            $("#labelDocProbatorio").show();
            $("#docProbatorio").show();
        }

        $("#spanClaveDocProbatorio").hide();
        $("#aceptarIssste").addClass("disabled_Url");
        ocultarTablasSubcuentas();

        $("#seguro").empty();
        $("#tipoPension").empty();
        $("#tipoPrestacion").empty();
        $("#pension").empty();
        $("#movimiento").empty();

        deshabilitarTipoDisposicionTipoRetiro($("#retiro").val());
        if ($("#retiro").val() != "0" && $("#regimen").val() != "0") {
            var datos = {};
            datos.claveTipoRetiro = $("#retiro").find("option:selected").val();
            consultarNoCargado("seguro", datos);
        }
    });

    $("#seguro").change(function () {
        $("#aceptarIssste").addClass("disabled_Url");
        ocultarTablasSubcuentas();
        $("#tipoPension").empty();
        $("#tipoPrestacion").empty();
        $("#pension").empty();
        $("#movimiento").empty();
        if ($("#retiro").val() != "0" && $("#regimen").val() != "0" && $("#seguro").val() != "0") {
            var datos = {};
            datos.claveTipoSeguro = $("#seguro").find("option:selected").val();
            consultarNoCargado("tipoPension", datos);
        }
    });

    $("#tipoPension").change(function () {
        $("#aceptarIssste").addClass("disabled_Url");
        ocultarTablasSubcuentas();
        $("#tipoPrestacion").empty();
        $("#pension").empty();
        $("#movimiento").empty();
        var comboRegimen = document.getElementById("regimen").value;
        var comboRetiro = document.getElementById("retiro").value;
        var comboSeguro = document.getElementById("seguro").value;
        var comboTipoPension = document.getElementById("tipoPension").value;
        if ($("#retiro").val() != "0" && $("#regimen").val() != "0" && $("#seguro").val() != "0" && $("#tipoPension").val() != "0") {
            var datos = {};
            datos.claveTipoPension = $("#tipoPension").find("option:selected").val();
            consultarNoCargado("tipoPrestacion", datos);
        }
    });

    $("#tipoPrestacion").change(function () {
        $("#aceptarIssste").addClass("disabled_Url");
        ocultarTablasSubcuentas();
        $("#pension").empty();
        $("#movimiento").empty();
        if ($("#retiro").val() != "0" &&  $("#regimen").val() != "0" && $("#seguro").val() != "0" &&  $("#tipoPension").val()  != "0" &&  $("#tipoPrestacion").val()  != "0") {
        	var datos = {};
            datos.claveTipoPrestacion = $("#tipoPrestacion").find("option:selected").val();
            consultarNoCargado("pension", datos);
        }
    });

    $("#pension").change(function () {
        $("#aceptarIssste").addClass("disabled_Url");
        $("#movimiento").empty();
        ocultarTablasSubcuentas();
        if ($("#retiro").val() != "0" && $("#regimen").val() != "0" && $("#seguro").val() != "0" && $("#tipoPension").val() != "0" && $("#tipoPrestacion").val() != "0" && $("#pension").val() != "0") {
        	var datos = {};
            datos.clavePension = $("#pension").find("option:selected").val();
            consultarNoCargado("movimiento", datos);
        }
    });

});

////////////////////////END DOCUMENT READY//////////////////////////////////////////

function consultarNoCargado(siguiente, datos) {
    var arrayList = null;

    //datos.primerCombo = primerCombo;

    datos.seleccionadoTipoRegimen = $("#regimen").find("option:selected").val();
    datos.seleccionadoRetiro = $("#retiro").find("option:selected").val();
    datos.seleccionadoSeguro = $("#seguro").find("option:selected").val();
    datos.seleccionadoPension = $("#tipoPension").find("option:selected").val();
    datos.seleccionadoTipoPrestacion = $("#tipoPrestacion").find("option:selected").val();
    console.log(JSON.stringify(datos));

    $.ajax({
        type: "POST",
        url: "consultarNoCargadoIssste.do",
        contentType: "application/json",
        data: JSON.stringify(datos),
    }).success(function (data) {
        if (data.flujo == 1) {
        	 console.log(data.lstObRespuesta);
            lista = data.lstObRespuesta;
            llenaCombo(siguiente, lista);
        }
    });
}

function llenaCombo(combo, lista) {
    console.log("llenando combo " + combo);
    const $sigCombo = $("#" + combo);
    $sigCombo.append(
        $("<option>", {
            value: "0",
            text: "Seleccione una opción",
        })
    );
    
    if(lista.length == 0 ){
    	 $sigCombo.append(
	        $("<option>", {
	            value: "0",
	            text: "No aplica",
	        })
	    );
    }

    for (var i = 0; i < lista.length; i++) {
        $sigCombo.append(
            $("<option>", {
                value: lista[i].clave,
                text: lista[i].descripcion,
            })
        );
    }
}

function deshabilitarOpciones() {
    $("#tipoPrestacion").removeAttr("disabled");
    $("#seguro").removeAttr("disabled");
    $("#retiro").removeAttr("disabled");
    $("#tipoPension").removeAttr("disabled");
    $("#regimen").removeAttr("disabled");
    $("#pension").removeAttr("disabled");
    $("#movimiento").removeAttr("disabled");
}
function deshabilitarOpcionesDisposicion() {
    $("#disposicion option[value='D1']").attr("disabled", true);
    $("#disposicion option[value='D3']").attr("disabled", true);
    $("#disposicion").removeAttr("disabled");
}
function deshabilitarOpcionesNoCarga() {
    combosVacios();
    $("#disposicion option[value='D4']").removeAttr("disabled");
    //agregarOnchangesNoCargado();
    deshabilitarOpcionesDisposicionCargado();
    consultarNoCargadoRegimen();
    //consultarNoCargado("0", null, null, null, null,  null, null, null, null, null, null, null);
    $("#tipoPrestacion").removeAttr("disabled");
    $("#seguro").removeAttr("disabled");
    $("#retiro").removeAttr("disabled");
    $("#tipoPension").removeAttr("disabled");
    $("#regimen").removeAttr("disabled");
    $("#pension").removeAttr("disabled");
    $("#movimiento").removeAttr("disabled");
    $("#fechaIncioPensionT").val("01/01/0001");
    $("#fechaIncioPensionT").attr("readonly", "readonly");
    $("#fechaIncioPensionT").attr("disabled", "disabled");
    //Beneficiarios
    $("#curpBeneficiario").removeAttr("disabled");
    $("#nombre").removeAttr("disabled");
    $("#apellidoPaterno").removeAttr("disabled");
    $("#apellidoMaterno").removeAttr("disabled");
    $("#rfcBeneficiario").removeAttr("disabled");
    $("#porcentaje").removeAttr("disabled");
    $("#banco").removeAttr("disabled");
    $("#cuentaClabe").removeAttr("disabled");
}

function mostrarModalResolucion() {
    window.location.href = "#miModalResolucion";
    var combo = $("#tipoRecurso").val();
    var x;
    if (combo == "banx") {
        x = "DT";
    }
    if (combo == "sief") {
        x = "RO";
    }

    $("#tablaResolucion").DataTable().columns(10).search(x).draw();

    $("#miModalResolucion").show();
}

function valorResolucion() {
    $("#valorRadio").val($("input:radio[name=res]:checked").val());
    var valorRadio = document.getElementById("valorRadio").value;
    const $tipoPrestacion = $("#tipoPrestacion");
    const $seguro = $("#seguro");
    const $retiro = $("#retiro");
    const $tipoPension = $("#tipoPension");
    const $regimen = $("#regimen");
    const $pension = $("#pension");
    const $movimiento = $("#movimiento");
    $tipoPrestacion.append(
        $("<option>", {
            value: document.getElementById("claveTipoPrestacion").value,
            text: document.getElementById("descripcionTipoPrestacion").value,
        })
    );
    $seguro.append(
        $("<option>", {
            value: document.getElementById("claveSeguro").value,
            text: document.getElementById("descripcionSeguro").value,
        })
    );
    $retiro.append(
        $("<option>", {
            value: document.getElementById("claveRetiro").value,
            text: document.getElementById("descripcionRetiro").value,
        })
    );
    $tipoPension.append(
        $("<option>", {
            value: document.getElementById("claveTipoPension").value,
            text: document.getElementById("descripcionTipoPension").value,
        })
    );
    $regimen.append(
        $("<option>", {
            value: document.getElementById("claveRegimen").value,
            text: document.getElementById("descripcionRegimen").value,
        })
    );
    $pension.append(
        $("<option>", {
            value: document.getElementById("clavePension").value,
            text: document.getElementById("descripcionPension").value,
        })
    );
    $movimiento.append(
        $("<option>", {
            value: document.getElementById("claveMovimiento").value,
            text: document.getElementById("descripcionMovimiento").value,
        })
    );

    $("#numeroResolucionT").val(document.getElementById("numeroResolucion").value);
    $("#secuenciaPensionT").val(document.getElementById("secuenciaPension").value);
    $("#fechaIncioPensionT").val(document.getElementById("fechaInicioPension").value);
    $("#fechaEmisionPensionT").val(document.getElementById("fechaEmisionPension").value);
    $("#numeroSemanasCotizadasT").val(document.getElementById("numeroSemanasCotizadas").value);
    $("#numeroIssste").val(document.getElementById("numeroIsssteH").value);

    $("#tipoPrestacion").attr("disabled", "disabled");
    $("#seguro").attr("disabled", "disabled");
    $("#retiro").attr("disabled", "disabled");
    $("#tipoPension").attr("disabled", "disabled");
    $("#regimen").attr("disabled", "disabled");
    $("#pension").attr("disabled", "disabled");
    $("#movimiento").attr("disabled", "disabled");
    $("#numeroResolucionT").attr("disabled", "disabled");
    $("#secuenciaPensionT").attr("disabled", "disabled");
    $("#fechaIncioPensionT").attr("disabled", "disabled");
    $("#fechaEmisionPensionT").attr("disabled", "disabled");
    $("#numeroSemanasCotizadasT").attr("disabled", "disabled");
    $("#numeroIssste").attr("disabled", "disabled");

    $("#disposicion option[value='D2']").attr("disabled", true);
    $("#disposicion option[value='D4']").attr("disabled", true);
    $("#disposicion option[value='D5']").attr("disabled", true);
    $("#disposicion option[value='D1']").removeAttr("disabled");
    $("#disposicion option[value='D3']").removeAttr("disabled");

    var retiroC = document.getElementById("retiro").value;
    $("#labelDocProbatorio").hide();
    $("#docProbatorio").hide();
    if (retiroC == "E") {
        $("#labelDocProbatorio").show();
        $("#docProbatorio").show();
    }

    //Beneficiarios
    $("#comboSolicitante").removeAttr("disabled");
    $("#curpBeneficiario").removeAttr("disabled");
    $("#nombre").removeAttr("disabled");
    $("#apellidoPaterno").removeAttr("disabled");
    $("#apellidoMaterno").removeAttr("disabled");
    $("#rfcBeneficiario").removeAttr("disabled");
    $("#porcentaje").removeAttr("disabled");
    $("#banco").removeAttr("disabled");
    $("#cuentaClabe").removeAttr("disabled");
    mostrarTablasSub();
}

function habilitarAceptar(
    cvTipoPrestacion,
    cvTipoSeguro,
    cvTipoRetiro,
    cvTipoPension,
    cvTipoRegimen,
    cvClavePension,
    cvMovimiento,
    secuenciaPension,
    fechaEmision,
    fechaInicioPension,
    semanasCotizadas,
    numeroConcesion,
    bandera,
    idResolucion,
    numeroIssste
) {
    $("#claveTipoPrestacion").val(cvTipoPrestacion);
    $("#claveSeguro").val(cvTipoSeguro);
    $("#claveRetiro").val(cvTipoRetiro);
    $("#claveTipoPension").val(cvTipoPension);
    $("#claveRegimen").val(cvTipoRegimen);
    $("#clavePension").val(cvClavePension);
    $("#claveMovimiento").val(cvMovimiento);
    $("#numeroResolucion").val(numeroConcesion);
    $("#secuenciaPension").val(secuenciaPension);
    $("#fechaInicioPension").val(fechaInicioPension);
    $("#fechaEmisionPension").val(fechaEmision);
    $("#numeroSemanasCotizadas").val(semanasCotizadas);
    $("#numeroIsssteH").val(numeroIssste);
    $("#spanCargado").hide();
    $("#spanFechaNac").hide();
    $("#valorRadioDos").val(idResolucion);
    if (bandera == "1") {
        $("#aceptarRes").removeClass("disabled_Url");
    } else {
        $("#spanCargado").show();
        $("#aceptarRes").addClass("disabled_Url");
    }
    var retiroE = document.getElementById("claveRetiro").value;
    if (retiroE == "E") {
        if (_EDAD < 65) {
            $("#spanFechaNac").show();
            $("#aceptarRes").addClass("disabled_Url");
        }
    }
}

function combosVacios() {
    const $regimen = $("#regimen");
    $regimen.empty();
    const $retiro = $("#retiro");
    $retiro.empty();
    const $seguro = $("#seguro");
    $seguro.empty();
    const $tipoPension = $("#tipoPension");
    $tipoPension.empty();
    const $tipoPrestacion = $("#tipoPrestacion");
    $tipoPrestacion.empty();
    const $pension = $("#pension");
    const $movimiento = $("#movimiento");
    $pension.empty();
    $movimiento.empty();
}

function validarFechaIn() {
    $("#spanFechaIn").hide();
    var fecha = document.getElementById("fechaIncioPensionT").value;
    var fechaNueva = $.datepicker.parseDate("dd/mm/yy", fecha);
    if (Date.parse(fechaNueva) > Date.now()) {
        $("#spanFechaIn").show();
    }
}

function validarFechaEm() {
    $("#spanFechaEm").hide();
    var fecha = document.getElementById("fechaEmisionPensionT").value;
    var fechaNueva = $.datepicker.parseDate("dd/mm/yy", fecha);
    if (Date.parse(fechaNueva) > Date.now()) {
        $("#spanFechaEm").show();
    }
}

function habilitarNrp() {
    combosVacios();
    $("#regimen").hide();
    $("#labelReg").hide();
    $("#divRegimenPrincipal").hide();
    $("#regimenPlanPrivado").show();
    $("#labelRegPlanPrivado").show();
    $("#divNrp").show();
    $("#divTipoRecurso").hide();
    $("#divRegimen").show();

    deshabilitarPlan();
    //agregarOnchangesPlanPrivado();
    consultarExistenciaCurp();
    $("#movimiento").removeAttr("onchange");
    $("#movimiento").attr("onchange", "mostrarTablasSubPlanPrivado()");
    // $("#siefores").removeAttr('onchange');
    // $("#siefores").attr('onchange', 'mostrarTablasSubPlanPrivado()');
    $("#aceptarIssste").removeAttr("onclick");
    $("#aceptarIssste").attr("onclick", "implementacionExpedienteServicioPlanPrivado()");
    //Beneficiarios
    $("#comboSolicitante").removeAttr("disabled");
    $("#curpBeneficiario").removeAttr("disabled");
    $("#nombre").removeAttr("disabled");
    $("#apellidoPaterno").removeAttr("disabled");
    $("#apellidoMaterno").removeAttr("disabled");
    $("#rfcBeneficiario").removeAttr("disabled");
    $("#porcentaje").removeAttr("disabled");
    $("#banco").removeAttr("disabled");
    $("#cuentaClabe").removeAttr("disabled");
    //$("#siefores").removeAttr("disabled");
    //$("#movimiento").removeAttr('onchange');
}

function consultarExistenciaCurp() {
    $.ajax({
        method: "GET",
        url: "consultarExistenciaCurp.do",
        contentType: "application/json",
        async: true,
    })
        .success(function (data) {
            console.log(data.flujo);
            if (data.flujo == 1) {
                var mens = data.mensaje;
                if (mens != "01") {
                    window.location.href = "#miModalPlanPrivado";
                    $("#miModalPlanPrivado").show();
                } else {
                    removerDeshabilitadosPlan();
                    deshabilitarOpcionesDisposicionPlanPrivado();
                    consultarRetiroC("0", null, null, null, null, null, null, null, null, null, null, null);
                    consultarRetiroC(null, null, "C", null, null, null, null, null, null, null, null, null);
                }
            }
        })
        .error(function (data) {
            console.log("Ocurrio un error ::" + data);
        });
}

function consultarRetiroC(
    primerCombo,
    claveTipoRegimen,
    claveTipoRetiro,
    claveTipoSeguro,
    claveTipoPension,
    claveTipoPrestacion,
    clavePension,
    seleccionadoTipoRegimen,
    seleccionadoRetiro,
    seleccionadoSeguro,
    seleccionadoPension,
    seleccionadoTipoPrestacion
) {
    var arrayList = null;
    var datos = {};
    datos.primerCombo = primerCombo;
    datos.claveTipoRegimen = claveTipoRegimen;
    datos.claveTipoRetiro = claveTipoRetiro;
    datos.claveTipoSeguro = claveTipoSeguro;
    datos.claveTipoPension = claveTipoPension;
    datos.claveTipoPrestacion = claveTipoPrestacion;
    datos.clavePension = clavePension;
    datos.seleccionadoTipoRegimen = seleccionadoTipoRegimen;
    datos.seleccionadoRetiro = seleccionadoRetiro;
    datos.seleccionadoSeguro = seleccionadoSeguro;
    datos.seleccionadoPension = seleccionadoPension;
    datos.seleccionadoTipoPrestacion = seleccionadoTipoPrestacion;
    $.ajax({
        type: "POST",
        url: "consultarIsssteRetiroC.do",
        contentType: "application/json",
        data: JSON.stringify(datos),
    }).success(function (data) {
        console.log(data.flujo);
        if (data.flujo == 1) {
            arrayList = data.lstObRespuesta;
            obtenerInformacionPrimerComboC(primerCombo, arrayList);
            llenarPlanRegimen(claveTipoRetiro, arrayList);
            obtenerInformacionSeguroCombo(claveTipoRegimen, arrayList);
            obtenerInformacionTipoPensionCombo(claveTipoSeguro, arrayList);
            obtenerInformacionTipoPrestacionCombo(claveTipoPension, arrayList);
            obtenerInformacionClavePensionCombo(claveTipoPrestacion, arrayList);
            obtenerInformacionMovimientoCombo(clavePension, arrayList);
        }
    });
}

function obtenerInformacionPrimerComboC(primerCombo, arrayList) {
    if (primerCombo != null) {
        const $retiro = $("#retiro");

        for (var i = 0; i < arrayList.length; i++) {
            $retiro.append(
                $("<option>", {
                    value: arrayList[i].clave,
                    text: arrayList[i].descripcion,
                })
            );
        }
        $("#retiro").attr("disabled", "disabled");
    }
}

function removerDeshabilitadosPlan() {
    $("#tipoPrestacion").removeAttr("disabled");
    $("#seguro").removeAttr("disabled");
    $("#tipoPension").removeAttr("disabled");
    $("#regimenPlanPrivado").removeAttr("disabled");
    $("#pension").removeAttr("disabled");
    $("#movimiento").removeAttr("disabled");
    $("#numeroResolucionT").removeAttr("disabled");
    $("#secuenciaPensionT").removeAttr("disabled");
    $("#fechaIncioPensionT").removeAttr("disabled");
    $("#fechaEmisionPensionT").removeAttr("disabled");
    $("#numeroSemanasCotizadasT").removeAttr("disabled");
    $("#numeroIssste").removeAttr("disabled");

    $("#disposicion").removeAttr("disabled");
    $("#docProbatorio").removeAttr("disabled");
}

function deshabilitarPlan() {
    const $retiro = $("#retiro");
    $retiro.empty();
    const $regimen = $("#regimenPlanPrivado");
    $regimen.empty();
    const $seguro = $("#seguro");
    $seguro.empty();
    const $tipoPension = $("#tipoPension");
    $tipoPension.empty();
    const $tipoPrestacion = $("#tipoPrestacion");
    $tipoPrestacion.empty();
    const $pension = $("#pension");
    const $movimiento = $("#movimiento");
    $pension.empty();
    $movimiento.empty();
    $("#tipoPrestacion").attr("disabled", "disabled");
    $("#seguro").attr("disabled", "disabled");
    $("#retiro").attr("disabled", "disabled");
    $("#tipoPension").attr("disabled", "disabled");
    $("#regimenPlanPrivado").attr("disabled", "disabled");
    $("#pension").attr("disabled", "disabled");
    $("#movimiento").attr("disabled", "disabled");
    $("#numeroResolucionT").attr("disabled", "disabled");
    $("#secuenciaPensionT").attr("disabled", "disabled");
    $("#fechaIncioPensionT").attr("disabled", "disabled");
    $("#fechaEmisionPensionT").attr("disabled", "disabled");
    $("#numeroSemanasCotizadasT").attr("disabled", "disabled");
    $("#numeroIssste").attr("disabled", "disabled");
    $("#disposicion").attr("disabled", "disabled");
    $("#docProbatorio").attr("disabled", "disabled");
}

function llenarPlanRegimen(claveRegimen, arrayList) {
    if (claveRegimen != null && arrayList != null) {
        const $regimen = $("#regimenPlanPrivado");
        $regimen.append(
            $("<option>", {
                value: "0",
                text: "Seleccione una opción",
            })
        );

        for (var i = 0; i < arrayList.length; i++) {
            $regimen.append(
                $("<option>", {
                    value: arrayList[i].clave,
                    text: arrayList[i].descripcion,
                })
            );
        }
    }
}

function llenarTipoPensionComboPlan() {
    $("#aceptarIssste").addClass("disabled_Url");
    ocultarTablasSubcuentas();
    const $tipoPension = $("#tipoPension");
    $tipoPension.empty();
    const $tipoPrestacion = $("#tipoPrestacion");
    $tipoPrestacion.empty();
    const $pension = $("#pension");
    $pension.empty();
    const $movimiento = $("#movimiento");
    $movimiento.empty();
    var comboRegimen = document.getElementById("regimenPlanPrivado").value;
    var comboRetiro = document.getElementById("retiro").value;
    var comboSeguro = document.getElementById("seguro").value;
    if (comboRetiro != "0" && comboRegimen != "0" && comboSeguro != "0") {
        consultarRetiroC(null, null, null, comboSeguro, null, null, null, comboRegimen, comboRetiro, null, null, null);
    }
}

function llenarTipoPrestacionComboPlan() {
    $("#aceptarIssste").addClass("disabled_Url");
    ocultarTablasSubcuentas();
    const $tipoPrestacion = $("#tipoPrestacion");
    $tipoPrestacion.empty();
    const $pension = $("#pension");
    $pension.empty();
    const $movimiento = $("#movimiento");
    $movimiento.empty();
    var comboRegimen = document.getElementById("regimenPlanPrivado").value;
    var comboRetiro = document.getElementById("retiro").value;
    var comboSeguro = document.getElementById("seguro").value;
    var comboTipoPension = document.getElementById("tipoPension").value;
    if (comboRetiro != "0" && comboRegimen != "0" && comboSeguro != "0" && comboTipoPension != "0") {
        consultarRetiroC(null, null, null, null, comboTipoPension, null, null, comboRegimen, comboRetiro, comboSeguro, null, null);
    }
}

function llenarClavePensionComboPlan() {
    $("#aceptarIssste").addClass("disabled_Url");
    ocultarTablasSubcuentas();
    const $pension = $("#pension");
    $pension.empty();
    const $movimiento = $("#movimiento");
    $movimiento.empty();
    var comboRegimen = document.getElementById("regimenPlanPrivado").value;
    var comboRetiro = document.getElementById("retiro").value;
    var comboSeguro = document.getElementById("seguro").value;
    var comboTipoPension = document.getElementById("tipoPension").value;
    var comboTipoPrestacion = document.getElementById("tipoPrestacion").value;
    if (comboRetiro != "0" && comboRegimen != "0" && comboSeguro != "0" && comboTipoPension != "0" && comboTipoPrestacion != "0") {
        consultarRetiroC(null, null, null, null, null, comboTipoPrestacion, null, comboRegimen, comboRetiro, comboSeguro, comboTipoPension, null);
    }
}

function llenarClaveMovimientoComboPlan() {
    $("#aceptarIssste").addClass("disabled_Url");
    ocultarTablasSubcuentas();
    const $movimiento = $("#movimiento");
    $movimiento.empty();
    var comboRegimen = document.getElementById("regimenPlanPrivado").value;
    var comboRetiro = document.getElementById("retiro").value;
    var comboSeguro = document.getElementById("seguro").value;
    var comboTipoPension = document.getElementById("tipoPension").value;
    var comboTipoPrestacion = document.getElementById("tipoPrestacion").value;
    var comboClavePension = document.getElementById("pension").value;
    if (comboRetiro != "0" && comboRegimen != "0" && comboSeguro != "0" && comboTipoPension != "0" && comboTipoPrestacion != "0" && comboClavePension != "0") {
        consultarRetiroC(null, null, null, null, null, null, comboClavePension, comboRegimen, comboRetiro, comboSeguro, comboTipoPension, comboTipoPrestacion);
    }
}

/*function agregarOnchangesNoCargado() {
    $("#seguro").removeAttr("onchange");
    $("#seguro").attr("onchange", "llenarTipoPensionCombo()");
    $("#tipoPension").removeAttr("onchange");
    $("#tipoPension").attr("onchange", "llenarTipoPrestacionCombo()");
    $("#tipoPrestacion").removeAttr("onchange");
    $("#tipoPrestacion").attr("onchange", "llenarClavePensionCombo()");
    $("#pension").removeAttr("onchange");
    $("#pension").attr("onchange", "llenarClaveMovimientoCombo()");
}*/

/*function agregarOnchangesPlanPrivado() {
    $("#seguro").removeAttr("onchange");
    $("#seguro").attr("onchange", "llenarTipoPensionComboPlan()");
    $("#tipoPension").removeAttr("onchange");
    $("#tipoPension").attr("onchange", "llenarTipoPrestacionComboPlan()");
    $("#tipoPrestacion").removeAttr("onchange");
    $("#tipoPrestacion").attr("onchange", "llenarClavePensionComboPlan()");
    $("#pension").removeAttr("onchange");
    $("#pension").attr("onchange", "llenarClaveMovimientoComboPlan()");
}*/

function ocultarTablasSubcuentas() {
    document.getElementById("section_one").style.display = "none";
    document.getElementById("section_two").style.display = "none";
    $("#tablasSub").hide();
    $("#spanEstatusMarca").hide();
}

function fechaSolicitud() {
    var fechaHoy = new Date();
    var fechaSolicitud = ("0" + fechaHoy.getDate()).slice(-2) + "/" + ("0" + (fechaHoy.getMonth() + 1)).slice(-2) + "/" + fechaHoy.getFullYear();
    $("#fechaSolicitud").val(fechaSolicitud);
    $("#fechaSolicitud").attr("disabled", "disabled");
}

function deshabiltarCamposInicio() {
    $("#numeroResolucionT").val("");
    $("#secuenciaPensionT").val("");
    $("#fechaIncioPensionT").val("");
    $("#fechaEmisionPensionT").val("");
    $("#numeroSemanasCotizadasT").val("");
    $("#numeroIssste").val("");
    $("#claveSolicitante").attr("disabled", "disabled");
    $("#curpAgenteServicio").attr("disabled", "disabled");
    $("#fechaNacimiento").attr("disabled", "disabled");
    $("#tablasSub").hide();
    $("#regimen").show();
    $("#labelReg").show();
    $("#regimenPlanPrivado").hide();
    $("#labelRegPlanPrivado").hide();
    $("#spanFechaIn").hide();
    $("#spanFechaEm").hide();
    $("#divRegimen").hide();
    $("#divRegimenPrincipal").show();
    $("#spanClaveDocProbatorio").hide();
    $("#descripcionSolicitante").attr("disabled", "disabled");
    $("#spanCargado").hide();
    $("#aceptarIssste").addClass("disabled_Url");
    $("#labelDocProbatorio").hide();
    $("#docProbatorio").hide();
    $("#divNrp").hide();
    $("#spanFechaNac").hide();
    $("#spanEstatusMarca").hide();
    $("#spanSubcuentas").hide();
    //beneficiario
    $("#curpBeneficiario").attr("disabled", "disabled");
    $("#nombre").attr("disabled", "disabled");
    $("#apellidoPaterno").attr("disabled", "disabled");
    $("#apellidoMaterno").attr("disabled", "disabled");
    $("#rfcBeneficiario").attr("disabled", "disabled");
    $("#porcentaje").attr("disabled", "disabled");
    $("#banco").attr("disabled", "disabled");
    $("#cuentaClabe").attr("disabled", "disabled");
    $("#agregarBen").addClass("disabled_Url");
    $("#spanPorcentaje").hide();
    $("#spanObligatoriosBen").hide();
    $("#spanCurpBen").hide();
    $("#spanRfcBen").hide();
    $("#elimBen").addClass("disabled_Url");
    $("#spanCuentaClabe").hide();
    $("#spanObligatoriosPrin").hide();
    $("#spanGargadoNoDatos").hide();
    $("#spanCuentaClabeBanco").hide();
}

function validarEdadTrabajador(tipoRetiro) {
    if (tipoRetiro == "E") {
        if (_EDAD < 65) {
            window.location.href = "#miModalFechaNac";
            $("#miModalFechaNac").show();
        }
    }
}

function deshabilitarOpcionesDisposicionPlanPrivado() {
    $("#disposicion option[value='D2']").attr("disabled", true);
    $("#disposicion option[value='D4']").attr("disabled", true);
}

function deshabilitarOpcionesDisposicionCargado() {
    $("#disposicion option[value='D5']").attr("disabled", true);
}

function deshabilitarTipoDisposicionTipoRetiro(tipoRetiro) {
    const retirosSiefore = ["C", "K", "O"];
    $("#disposicion option[value='D4']").removeAttr("disabled");
    if (retirosSiefore.indexOf(tipoRetiro) != -1) {
        $("#disposicion option[value='D4']").attr("disabled", true);
    }
}

function consultarNoCargadoRegimen() {
    var arrayList = null;
    var x = $("#tipoRecurso").val();
    if (x == "sief") {
        x = "RO";
    } else {
        x = "DT";
    }
    console.log("llena combo retiro");
    $.ajax({
        type: "POST",
        url: "consultarNoCargadoRegimen.do?tipoRegimen=" + x,
        contentType: "application/json",
    }).success(function (data) {
        if (data.flujo == 1) {
            arrayList = data.lstObRespuesta;
            console.log(arrayList);
            obtenerInformacionPrimerCombo(arrayList);
        }
    });
}

function obtenerInformacionPrimerCombo(arrayList) {
    if (arrayList.length > 0) {
        const $regimen = $("#regimen");
        $regimen.append(
            $("<option>", {
                value: "0",
                text: "Seleccione una opción",
            })
        );

        for (var i = 0; i < arrayList.length; i++) {
            $regimen.append(
                $("<option>", {
                    value: arrayList[i].chParametro,
                    text: arrayList[i].chValorParametro,
                })
            );
        }
    }
}

function mostrarModalEleccion() {
    $(location).attr("href", "disposicionTotalIssstes.do");
    document.getElementById("cargaMensajeIssste").innerHTML = _MENSAJE;
    document.getElementById("tituloIssste").innerHTML = _TITULO;
    window.location.href = "#miModalOpcionCarga";
    $("#miModalOpcionCarga").show();
}

function validarTipoRecurso() {
    var comboTipoRecurso = document.getElementById("tipoRecurso");
    $("#claveTipoRecursos").val(document.getElementById("tipoRecurso").value);
    $("#tipoRecursosDescripcion").val(comboTipoRecurso.options[comboTipoRecurso.selectedIndex].text);
    $("#spanGargadoNoDatos").hide();

    if (banderaIssste == 0) {
        $("#spanGargadoNoDatos").show();
    }
    if (document.getElementById("tipoRecurso").value == "sief") {
        $("#botonPlanPrivado").removeClass("disabled_Url");
        $("#botonCargado").removeClass("disabled_Url");
        $("#botonNoCargado").removeClass("disabled_Url");
    } else if (document.getElementById("tipoRecurso").value == "banx") {
        $("#botonCargado").removeClass("disabled_Url");
        $("#botonNoCargado").removeClass("disabled_Url");
        $("#botonPlanPrivado").addClass("disabled_Url");
    } else {
        $("#botonPlanPrivado").addClass("disabled_Url");
        $("#botonCargado").addClass("disabled_Url");
        $("#botonNoCargado").addClass("disabled_Url");
    }

    if (banderaIssste == 0) {
        $("#botonCargado").addClass("disabled_Url");
    }
}

function modalOk(tipoRetiroValidado) {
    if (tipoRetiroValidado) {
        $("#aceptarIssste").addClass("Submitx");
        $("#aceptarIssste").removeClass("Submitx_disabled");
        $("#aceptarIssste").prop("disabled", false);
    } else {
        $("#aceptarIssste").addClass("Submitx_disabled");
        $("#aceptarIssste").removeClass("Submitx");
        $("#aceptarIssste").prop("disabled", true);
    }
}
