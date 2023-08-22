$(document).ready(function () {});
var abierto = false;

function sectionone() {
    if (abierto == false) {
        document.getElementById("section_one").style.display = "block";
        abierto = true;
    } else {
        document.getElementById("section_one").style.display = "none";
        abierto = false;
    }
}

/* Datos RCV */

var abiertoDos = false;

var abiertoTres = false;

function section_two() {
    if (abiertoTres == false) {
        document.getElementById("section_two").style.display = "block";
        abiertoTres = true;
    } else {
        document.getElementById("section_two").style.display = "none";
        abiertoTres = false;
    }
}

/* Datos Vivienda */

var abiertoCuatro = false;

function mostrarTablasSub() {
    //se comenta mientras se ve como se permite avanzar sin el conbo de movimiento
    $("#aceptarIssste").removeClass("disabled_Url");
    $("#tablasSub").hide();
    $("#spanSubcuentas").hide();
    $("#agregarBen").removeClass("disabled_Url");
    abierto = false;
    abiertoTres = false;
    document.getElementById("section_one").style.display = "none";
    document.getElementById("section_two").style.display = "none";
    var comboMovimiento = document.getElementById("movimiento").value;
    //if (comboMovimiento != "0") {
        var arrayList = null;
        var datos = {};
        datos.claveTipoRegimen = document.getElementById("regimen").value;
        datos.claveTipoRetiro = document.getElementById("retiro").value;
        datos.claveTipoSeguro = document.getElementById("seguro").value;
        datos.claveTipoPension = document.getElementById("tipoPension").value;
        datos.claveTipoPrestacion = document.getElementById("tipoPrestacion").value;
        datos.clavePension = document.getElementById("pension").value;
        datos.claveMovimiento = document.getElementById("movimiento").value;
        datos.tipoRecurso = document.getElementById("claveTipoRecursos").value;
        var tipoRecurso = document.getElementById("claveTipoRecursos").value;
        consultarSubcuentasCargadoNoCargado(datos);
    //}
}

function consultarSubcuentasCargadoNoCargado(datos) {
    $.ajax({
        type: "POST",
        url: "consultarSubcuentas.do",
        contentType: "application/json",
        data: JSON.stringify(datos),
    }).success(function (data) {
        console.log(data.flujo);
        if (data.flujo == 1) {
            var arrayList = data.lstObRespuesta;
            var arrayList2 = data.lstObRespuestaDos;

            var estatusMarca = data.obRespuesta;

            if (data.titulo == null) {
                $("#montoTotalRcv").text("$0");
            } else {
                $("#montoTotalRcv").text("$" + data.titulo);
            }

            if (data.titulo == null && data.mensaje == null) {
                $("#spanSubcuentas").show();
                $("#agregarBen").addClass("disabled_Url");
            }

            if (data.mensaje == null) {
                $("#montoTotalViv").text("$0");
            } else {
                $("#montoTotalViv").text("$" + data.mensaje);
            }

            if (arrayList != null) {
                $("#tablaRcv").html("");
                armarCuerpoTablaRcv(arrayList);
            }

            if (arrayList2 != null) {
                $("#tablaVivienda").html("");
                armarCuerpoTablaVivienda(arrayList2);
            }

            if (arrayList != null || arrayList2 != null) {
                $("#tablasSub").show();
                $("#movimiento").removeAttr("onchange");
                $("#movimiento").attr("onchange", "mostrarTablasSubDos()");
            }

            if (arrayList == null && arrayList2 == null) {
                $("#spanSubcuentas").show();
                $("#agregarBen").addClass("disabled_Url");
            }

            if (estatusMarca < 1) {
                $("#tabViv").hide();
                $("#spanEstatusMarca").show();
            } else {
                $("#tabViv").show();
                $("#spanEstatusMarca").hide();
            }
        }
    });
}
function armarCuerpoTablaRcv(arrayList) {
    var tableRCV = "";
    tableRCV += "<thead>";
    tableRCV += '<tr class="RowHeader">';
    tableRCV += '<th class="th_tabla">Subcuentas RCV</th>';
    tableRCV += '<th class="th_tabla">Clave</th>';
    tableRCV += '<th class="th_tabla">Monto</th>';
    if (document.getElementById("claveTipoRecursos").value == "sief") {
        tableRCV += '<th class="th_tabla">Acciones</th>';
        tableRCV += '<th class="th_tabla">Fecha Valor</th>';
    }

    if (document.getElementById("claveTipoRecursos").value == "sief") {
        tableRCV += '<th class="th_tabla">Precio de Acciones</th>';
        tableRCV += '<th class="th_tabla">Siefores</th>';
    }

    tableRCV += '<th class="th_tabla">Eliminar</th>';
    tableRCV += "</tr>";
    tableRCV += "</thead>";
    tableRCV += "<tbody>";
    for (var i = 0; i < arrayList.length; i++) {
        if (i % 2 == 0) {
            tableRCV += '<tr class="Row1" id="trRcv' + i + '">';
        } else {
            tableRCV += '<tr class="Row2"  id="trRcv' + i + '">';
        }
        tableRCV += '<td class="td_tabla">' + arrayList[i].descripcionSubcuenta + "</td>";
        tableRCV += '<td class="td_tabla"> ' + arrayList[i].claveSubcuenta + "</td>";

        if (document.getElementById("claveTipoRecursos").value == "sief") {
            tableRCV +=
                '<td class="td_tabla"><input class="Inputxxl" id="montoRcv' +
                i +
                '" type="text" name=""  value="' +
                arrayList[i].monto +
                '" placeholder="Monto" onkeydown="delayedCalculoRcv(' +
                arrayList[i].monto +
                "," +
                i +
                "," +
                arrayList[i].campoSar +
                ')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false" disabled="true" ></td>';
        } else {
            tableRCV += '<td class="td_tabla"><input class="Inputxxl" id="montoRcv' + i + '" type="text" name=""  value="' + arrayList[i].monto + '" placeholder="Monto"  maxlength="10" readonly></td>';
        }
        if (document.getElementById("claveTipoRecursos").value == "sief") {
            tableRCV += '<td class="td_tabla" id="acciones' + i + '">' + arrayList[i].acciones + "</td>";
            tableRCV += '<td class="td_tabla" id="fechaValor' + i + '">' + arrayList[i].fechaValor + "</td>";
        }

        if (document.getElementById("claveTipoRecursos").value == "sief") {
            tableRCV += '<td class="td_tabla" id="precioAccion' + i + '">' + arrayList[i].precioAccion + "</td>";
            tableRCV += '<td class="td_tabla"><input class="Inputxxl" id="siefore' + i + '" type="text" name=""  value="Click aquí" placeholder="" onclick="seleccionarSiefore(' + i + ')" readonly></td>';
        }

        tableRCV +=
            '<td class="td_tabla"> <p class="Link_blue" href="#"><a  onclick="eliminarFilaRcv(this, ' +
            i +
            ", '" +
            document.getElementById("claveTipoRecursos").value +
            '\')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
        tableRCV += "</tr>";

        if (arrayList[i].campoSar == "1") {
            $("#posicionSar92").val("montoRcv" + i);
        }
    }

    tableRCV += "</tbody>";

    $("#tablaRcv").append(tableRCV);
    tablaRcvPaginacion();
}

function armarCuerpoTablaVivienda(arrayList) {
    var tableVivienda = "";
    tableVivienda += "<thead>";
    tableVivienda += '<tr class="RowHeader">';
    tableVivienda += '<th class="th_tabla">Subcuentas Vivienda</th>';
    tableVivienda += '<th class="th_tabla">Clave</th>';
    tableVivienda += '<th class="th_tabla">Monto</th>';
    tableVivienda += '<th class="th_tabla">Acciones</th>';
    tableVivienda += '<th class="th_tabla">Fecha Valor</th>';
    tableVivienda += '<th class="th_tabla">Precio de Acciones</th>';
    tableVivienda += '<th class="th_tabla">Eliminar</th>';
    tableVivienda += "</tr>";
    tableVivienda += "</thead>";
    tableVivienda += "<tbody>";
    for (var i = 0; i < arrayList.length; i++) {
        if (i % 2 == 0) {
            tableVivienda += '<tr class="Row1" id="trViv' + i + '">';
        } else {
            tableVivienda += '<tr class="Row2" id="trViv' + i + '">';
        }
        tableVivienda += '<td class="td_tabla">' + arrayList[i].descripcionSubcuenta + "</td>";
        tableVivienda += '<td class="td_tabla"> ' + arrayList[i].claveSubcuenta + "</td>";
        if (arrayList[i].sinPrecioAccion == "SINPRECIOACCION") {
            tableVivienda += '<td class="td_tabla"> <input class="Inputxxl" id="montoViv' + i + '" type="text" name=""  value="' + arrayList[i].monto + '" placeholder="Monto"   maxlength="10" readonly></td>';
        } else {
            tableVivienda +=
                '<td class="td_tabla"> <input class="Inputxxl" id="montoViv' +
                i +
                '" type="text" name=""  value="' +
                arrayList[i].monto +
                '" placeholder="" onkeydown="validarRangoAcciones(' +
                i +
                ", " +
                arrayList[i].precioAccion +
                ", " +
                arrayList[i].tabla +
                ", " +
                arrayList[i].monto +
                ", " +
                arrayList[i].acciones +
                ')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false"></td>';
        }
        tableVivienda += '<td class="td_tabla"><input class="Inputxxl" id="accionesSar' + i + '" type="text" name=""  value="' + arrayList[i].acciones + '" placeholder="" onchange="" readonly></td>';
        tableVivienda += '<td class="td_tabla">' + arrayList[i].fechaValor + "</td>";

        if (arrayList[i].sinPrecioAccion == "SINPRECIOACCION") {
            tableVivienda += '<td class="td_tabla"><p class="error_span">No existe valor para conversión de subcuenta en pesos</p></td>';
        } else {
            tableVivienda += '<td class="td_tabla">' + arrayList[i].precioAccion + "</td>";
        }

        tableVivienda +=
            '<td class="td_tabla"> <p class="Link_blue" href="#"><a  onclick="eliminarFilaViv(this, ' +
            i +
            ", '" +
            arrayList[i].sinPrecioAccion +
            '\')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
        tableVivienda += "</tr>";
    }

    tableVivienda += "</tbody>";
    $("#tablaVivienda").append(tableVivienda);
    tablaViviendaPaginacion();
}

function tablaRcvPaginacion() {
    var table = $("#tablaRcv").DataTable({
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
        bInfo: false,
        order: [],
        lengthMenu: [
            [4, 16, 24, 50],
            [4, 16, 24, 50],
        ],
    });
}

function tablaViviendaPaginacion() {
    var table = $("#tablaVivienda").DataTable({
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
        bInfo: false,
        order: [],
        lengthMenu: [
            [4, 16, 24, 50],
            [4, 16, 24, 50],
        ],
    });
}

function destruirDatatabledRcv() {
    $("#tablaRcv").dataTable().fnDestroy();
}

function destruirDatatabledViv() {
    $("#tablaVivienda").dataTable().fnDestroy();
}

function mostrarTablasSubDos() {
    $("#aceptarIssste").addClass("disabled_Url");
    $("#tablasSub").hide();
    $("#spanSubcuentas").hide();
    $("#agregarBen").addClass("disabled_Url");
    abierto = false;
    abiertoTres = false;
    document.getElementById("section_one").style.display = "none";
    document.getElementById("section_two").style.display = "none";
    var comboMovimiento = document.getElementById("movimiento").value;
    var tipoRecurso = document.getElementById("claveTipoRecursos").value;
    var comboSiefore = document.getElementById("siefores").value;
   // if (comboMovimiento != "0") {
        var arrayList = null;
        var datos = {};
        datos.claveTipoRegimen = document.getElementById("regimen").value;
        datos.claveTipoRetiro = document.getElementById("retiro").value;
        datos.claveTipoSeguro = document.getElementById("seguro").value;
        datos.claveTipoPension = document.getElementById("tipoPension").value;
        datos.claveTipoPrestacion = document.getElementById("tipoPrestacion").value;
        datos.clavePension = document.getElementById("pension").value;
        datos.claveMovimiento = document.getElementById("movimiento").value;
        datos.tipoRecurso = document.getElementById("claveTipoRecursos").value;
        var tipoRecurso = document.getElementById("claveTipoRecursos").value;
        cargadoNoCargadoSubDos(datos);
   // }
}

function armarCuerpoTablaRcvDos(arrayList) {
    var tableRCV = "";
    tableRCV += "<tbody>";
    for (var i = 0; i < arrayList.length; i++) {
        if (i % 2 == 0) {
            tableRCV += '<tr class="Row1" id="trRcv' + i + '">';
        } else {
            tableRCV += '<tr class="Row2" id="trRcv' + i + '">';
        }
        tableRCV += '<td class="td_tabla">' + arrayList[i].descripcionSubcuenta + "</td>";
        tableRCV += '<td class="td_tabla"> ' + arrayList[i].claveSubcuenta + "</td>";
        if (document.getElementById("claveTipoRecursos").value == "sief") {
            tableRCV +=
                '<td class="td_tabla"><input class="Inputxxl" id="montoRcv' +
                i +
                '" type="text" name=""  value="' +
                arrayList[i].monto +
                '" placeholder="Monto" onkeydown="delayedCalculoRcv(' +
                arrayList[i].monto +
                "," +
                i +
                "," +
                arrayList[i].campoSar +
                ')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false" disabled="true" ></td>';
        } else {
            tableRCV += '<td class="td_tabla"><input class="Inputxxl" id="montoRcv' + i + '" type="text" name=""  value="' + arrayList[i].monto + '" placeholder="Monto"  maxlength="10" readonly></td>';
        }
        if (document.getElementById("claveTipoRecursos").value == "sief") {
            tableRCV += '<td class="td_tabla" id="acciones' + i + '">' + arrayList[i].acciones + "</td>";
            tableRCV += '<td class="td_tabla" id="fechaValor' + i + '">' + arrayList[i].fechaValor + "</td>";
        }

        if (document.getElementById("claveTipoRecursos").value == "sief") {
            tableRCV += '<td class="td_tabla" id="precioAccion' + i + '">' + arrayList[i].precioAccion + "</td>";
            tableRCV += '<td class="td_tabla"><input class="Inputxxl" id="siefore' + i + '" type="text" name=""  value="Click aquí" placeholder="" onclick="seleccionarSiefore(' + i + ')" readonly></td>';
        }

        tableRCV +=
            '<td class="td_tabla"> <p class="Link_blue" href="#"><a  onclick="eliminarFilaRcv(this, ' +
            i +
            ", '" +
            document.getElementById("claveTipoRecursos").value +
            '\')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
        tableRCV += "</tr>";

        if (arrayList[i].campoSar == "1") {
            $("#posicionSar92").val("montoRcv" + i);
        }
    }

    tableRCV += "</tbody>";

    $("#tablaRcv").append(tableRCV);
    tablaRcvPaginacion();
}

function cargadoNoCargadoSubDos(datos) {
    $.ajax({
        type: "POST",
        url: "consultarSubcuentas.do",
        contentType: "application/json",
        data: JSON.stringify(datos),
    }).success(function (data) {
        console.log(data.flujo);
        if (data.flujo == 1) {
            var arrayList = data.lstObRespuesta;
            var arrayList2 = data.lstObRespuestaDos;
            var estatusMarca = data.obRespuesta;

            if (data.titulo == null) {
                $("#montoTotalRcv").text("$0");
            } else {
                $("#montoTotalRcv").text("$" + data.titulo);
            }

            if (data.mensaje == null) {
                $("#montoTotalViv").text("$0");
            } else {
                $("#montoTotalViv").text("$" + data.mensaje);
            }

            if (data.titulo == null && data.mensaje == null) {
                $("#spanSubcuentas").show();
                $("#agregarBen").addClass("disabled_Url");
            }
            if (arrayList != null) {
                $("#tablaRcv").empty();
                destruirDatatabledRcv();
                armarCuerpoTablaRcvDos(arrayList);
            }

            if (arrayList2 != null) {
                $("#tablaVivienda").empty();
                destruirDatatabledViv();
                armarCuerpoTablaViviendaDos(arrayList2);
            }

            if (arrayList != null || arrayList2 != null) {
                $("#tablasSub").show();
                $("#agregarBen").removeClass("disabled_Url");
                validarDatosBeneficiarios();
            }

            if (arrayList == null && arrayList2 == null) {
                $("#spanSubcuentas").show();
                $("#agregarBen").addClass("disabled_Url");
            }

            if (estatusMarca < 1) {
                $("#tabViv").hide();
                $("#spanEstatusMarca").show();
            } else {
                $("#tabViv").show();
                $("#spanEstatusMarca").hide();
            }
        }
    });
}

function armarCuerpoTablaViviendaDos(arrayList) {
    var tableVivienda = "";
    tableVivienda += "<tbody>";
    for (var i = 0; i < arrayList.length; i++) {
        if (i % 2 == 0) {
            tableVivienda += '<tr class="Row1" id="trViv' + i + '">';
        } else {
            tableVivienda += '<tr class="Row2" id="trViv' + i + '">';
        }
        tableVivienda += '<td class="td_tabla">' + arrayList[i].descripcionSubcuenta + "</td>";
        tableVivienda += '<td class="td_tabla"> ' + arrayList[i].claveSubcuenta + "</td>";
        if (arrayList[i].sinPrecioAccion == "SINPRECIOACCION") {
            tableVivienda += '<td class="td_tabla"> <input class="Inputxxl" id="montoViv' + i + '" type="text" name=""  value="' + arrayList[i].monto + '" placeholder="Monto"  maxlength="10" readonly></td>';
        } else {
            tableVivienda +=
                '<td class="td_tabla"> <input class="Inputxxl" id="montoViv' +
                i +
                '" type="text" name=""  value="' +
                arrayList[i].monto +
                '" placeholder="Monto" onkeydown="validarRangoAcciones(' +
                i +
                ", " +
                arrayList[i].precioAccion +
                ", " +
                arrayList[i].tabla +
                ", " +
                arrayList[i].monto +
                ", " +
                arrayList[i].acciones +
                ')" onKeyPress="return soloNumerosMonto(event,this)" maxlength="10" onpaste="return false"></td>';
        }
        tableVivienda += '<td class="td_tabla"><input class="Inputxxl" id="accionesSar' + i + '" type="text" name=""  value="' + arrayList[i].acciones + '" placeholder="" onchange="" readonly></td>';
        tableVivienda += '<td class="td_tabla">' + arrayList[i].fechaValor + "</td>";
        if (arrayList[i].sinPrecioAccion == "SINPRECIOACCION") {
            tableVivienda += '<td class="td_tabla"><p class="error_span">No existe valor para conversión de subcuenta en pesos</p></td>';
        } else {
            tableVivienda += '<td class="td_tabla">' + arrayList[i].precioAccion + "</td>";
        }
        tableVivienda +=
            '<td class="td_tabla"> <p class="Link_blue" href="#"><a  onclick="eliminarFilaViv(this, ' +
            i +
            ", '" +
            arrayList[i].sinPrecioAccion +
            '\')"><img  style="width:30px;" src="../webResources/img/error.png" alt="icon_eliminar"/></a></p></td>';
        tableVivienda += "</tr>";
    }

    tableVivienda += "</tbody>";
    $("#tablaVivienda").append(tableVivienda);
    tablaViviendaPaginacion();
}

function mostrarTablasSubPlanPrivado() {
    $("#aceptarIssste").addClass("disabled_Url");
    $("#tablasSub").hide();
    $("#spanSubcuentas").hide();
    $("#agregarBen").addClass("disabled_Url");
    abierto = false;
    abiertoTres = false;
    document.getElementById("section_one").style.display = "none";
    document.getElementById("section_two").style.display = "none";
    var comboMovimiento = document.getElementById("movimiento").value;
  //  if (comboMovimiento != "0") {
        var arrayList = null;
        var datos = {};
        datos.claveTipoRegimen = document.getElementById("regimenPlanPrivado").value;
        datos.claveTipoRetiro = document.getElementById("retiro").value;
        datos.claveTipoSeguro = document.getElementById("seguro").value;
        datos.claveTipoPension = document.getElementById("tipoPension").value;
        datos.claveTipoPrestacion = document.getElementById("tipoPrestacion").value;
        datos.clavePension = document.getElementById("pension").value;
        datos.claveMovimiento = document.getElementById("movimiento").value;
        datos.tipoRecurso = document.getElementById("claveTipoRecursos").value;
        var tipoRecurso = document.getElementById("claveTipoRecursos").value;
        $.ajax({
            type: "POST",
            url: "consultarSubcuentas.do",
            contentType: "application/json",
            data: JSON.stringify(datos),
        }).success(function (data) {
            console.log(data.flujo);
            if (data.flujo == 1) {
                var arrayList = data.lstObRespuesta;
                var arrayList2 = data.lstObRespuestaDos;
                var estatusMarca = data.obRespuesta;
                if (data.titulo == null) {
                    $("#montoTotalRcv").text("$0");
                }
                if (data.mensaje == null) {
                    $("#montoTotalViv").text("$0");
                } else {
                    $("#montoTotalViv").text("$" + data.mensaje);
                }
                if (data.titulo == null && data.mensaje == null) {
                    $("#spanSubcuentas").show();
                    $("#agregarBen").addClass("disabled_Url");
                }

                if (arrayList != null) {
                    $("#tablaRcv").html("");
                    armarCuerpoTablaRcv(arrayList);
                }

                if (arrayList2 != null) {
                    $("#tablaVivienda").html("");
                    armarCuerpoTablaVivienda(arrayList2);
                }

                if (arrayList != null || arrayList2 != null) {
                    $("#tablasSub").show();
                    $("#movimiento").removeAttr("onchange");
                    $("#movimiento").attr("onchange", "mostrarTablasSubDosPlanPrivado()");
                    $("#agregarBen").removeClass("disabled_Url");
                }

                if (arrayList == null && arrayList2 == null) {
                    $("#spanSubcuentas").show();
                    $("#agregarBen").addClass("disabled_Url");
                }

                if (estatusMarca < 1) {
                    $("#tabViv").hide();
                    $("#spanEstatusMarca").show();
                } else {
                    $("#tabViv").show();
                }
            }
        });
   // }
}

function mostrarTablasSubDosPlanPrivado() {
    $("#aceptarIssste").addClass("disabled_Url");
    $("#tablasSub").hide();
    $("#spanSubcuentas").hide();
    $("#agregarBen").addClass("disabled_Url");
    abierto = false;
    abiertoTres = false;
    document.getElementById("section_one").style.display = "none";
    document.getElementById("section_two").style.display = "none";
    var comboMovimiento = document.getElementById("movimiento").value;
    //if (comboMovimiento != "0") {
        var arrayList = null;
        var datos = {};
        datos.claveTipoRegimen = document.getElementById("regimenPlanPrivado").value;
        datos.claveTipoRetiro = document.getElementById("retiro").value;
        datos.claveTipoSeguro = document.getElementById("seguro").value;
        datos.claveTipoPension = document.getElementById("tipoPension").value;
        datos.claveTipoPrestacion = document.getElementById("tipoPrestacion").value;
        datos.clavePension = document.getElementById("pension").value;
        datos.claveMovimiento = document.getElementById("movimiento").value;
        datos.tipoRecurso = document.getElementById("claveTipoRecursos").value;
        var tipoRecurso = document.getElementById("claveTipoRecursos").value;
        $.ajax({
            type: "POST",
            url: "consultarSubcuentas.do",
            contentType: "application/json",
            data: JSON.stringify(datos),
        }).success(function (data) {
            console.log(data.flujo);
            if (data.flujo == 1) {
                var arrayList = data.lstObRespuesta;
                var arrayList2 = data.lstObRespuestaDos;

                var estatusMarca = data.obRespuesta;
                if (data.titulo == null) {
                    $("#montoTotalRcv").text("$0");
                }
                if (data.mensaje == null) {
                    $("#montoTotalViv").text("$0");
                } else {
                    $("#montoTotalViv").text("$" + data.mensaje);
                }

                if (data.titulo == null && data.mensaje == null) {
                    $("#spanSubcuentas").show();
                    $("#agregarBen").addClass("disabled_Url");
                }

                if (arrayList != null) {
                    $("#tablaRcv").empty();
                    destruirDatatabledRcv();
                    armarCuerpoTablaRcvDos(arrayList);
                }

                if (arrayList2 != null) {
                    $("#tablaVivienda").empty();
                    destruirDatatabledViv();
                    armarCuerpoTablaViviendaDos(arrayList2);
                }

                if (arrayList != null || arrayList2 != null) {
                    $("#tablasSub").show();
                    $("#agregarBen").removeClass("disabled_Url");
                    validarDatosBeneficiarios();
                }

                if (arrayList == null && arrayList2 == null) {
                    $("#spanSubcuentas").show();
                    $("#agregarBen").addClass("disabled_Url");
                }

                if (estatusMarca < 1) {
                    $("#tabViv").hide();
                    $("#spanEstatusMarca").show();
                } else {
                    $("#tabViv").show();
                }
            }
        });
    //}
}

function validarRangoAcciones(i, precioAccion, tabla, montoOriginal, accionOriginal) {
    delayedCalculoAcciones(i, precioAccion, tabla, montoOriginal, accionOriginal);
}

function eliminarFilaRcv(el, i, tipoRecurso) {
    var index = $(el).parent().parent();
    var table = $("#tablaRcv").dataTable();
    var tablaRcv = $("#tablaRcv").DataTable();
    var totalRcv = tablaRcv.rows().count();
    table.fnDeleteRow(index);

    if (tipoRecurso == "sief") {
        if (totalRcv > 0) {
            montoTotalSumaRcv();
        }
    } else {
        $("#montoTotalRcv").text("$0");
    }

    var tablaViv = $("#tablaVivienda").DataTable();
    var totalViv = tablaRcv.rows().count();
    var montoTotalRcv = $("#montoTotalRcv").text();
    montoTotalRcv = montoTotalRcv.replace("$", "");

    var montoTotalViv = $("#montoTotalViv").text();
    montoTotalViv = montoTotalViv.replace("$", "");

    if (totalRcv < 1 && totalViv < 1) {
        $("#spanSubcuentas").show();
        $("#agregarBen").addClass("disabled_Url");
    } else {
        $("#spanSubcuentas").hide();
        $("#agregarBen").removeClass("disabled_Url");
    }

    if (parseFloat(montoTotalRcv) < 1 && parseFloat(montoTotalViv) < 1) {
        $("#spanSubcuentas").show();
        $("#agregarBen").addClass("disabled_Url");
    } else {
        $("#spanSubcuentas").hide();
        $("#agregarBen").removeClass("disabled_Url");
    }
}

function eliminarFilaViv(el, i, sinPrecioAccion) {
    var index = $(el).parent().parent();
    var table = $("#tablaVivienda").dataTable();
    table.fnDeleteRow(index);
    if (sinPrecioAccion != "SINPRECIOACCION") {
        montoTotalSumaViv();
    }

    var tablaRcv = $("#tablaRcv").DataTable();
    var totalRcv = tablaRcv.rows().count();
    var tablaViv = $("#tablaVivienda").DataTable();
    var totalViv = tablaRcv.rows().count();
    var montoTotalRcv = $("#montoTotalRcv").text();
    montoTotalRcv = montoTotalRcv.replace("$", "");

    var montoTotalViv = $("#montoTotalViv").text();
    montoTotalViv = montoTotalViv.replace("$", "");

    if (totalRcv < 1 && totalViv < 1) {
        $("#spanSubcuentas").show();
        $("#agregarBen").addClass("disabled_Url");
    } else {
        $("#spanSubcuentas").hide();
        $("#agregarBen").removeClass("disabled_Url");
    }

    if (parseFloat(montoTotalRcv) < 1 && parseFloat(montoTotalViv) < 1) {
        $("#spanSubcuentas").show();
        $("#agregarBen").addClass("disabled_Url");
    } else {
        $("#spanSubcuentas").hide();
        $("#agregarBen").removeClass("disabled_Url");
    }
}

function soloNumerosMonto(e, input) {
    var key = window.Event ? e.which : e.keyCode;
    var chark = String.fromCharCode(key);
    var tempValue = input.value + chark;
    if (key == 46) {
        var preg = /^([0-9]+\.?[0-9]{0,1})$/;
        if (preg.test(tempValue) === false) {
            return false;
        }
    }
    return (key >= 48 && key <= 57) || key == 8 || key == 46;
}

var timeOutID;
function delayedCalculoAcciones(i, precioAccion, tabla, montoOriginal, accionOriginal) {
    timeOutID = window.setTimeout(function () {
        calculoAccionesGen(i, precioAccion, tabla, montoOriginal, accionOriginal);
    }, 4000);
}

function calculoAccionesGen(i, precioAccion, tabla, montoOriginal, accionOriginal) {
    var montoNombre = "";
    var nombre = "";
    montoNombre = "montoViv" + i;
    nombre = "#accionesSar" + i;

    var monto = document.getElementById(montoNombre).value;

    if (parseFloat(monto) <= parseFloat(montoOriginal)) {
        if (monto.length < 1) {
            $("#" + montoNombre).val("0");
            monto = "0";
        }

        if (monto.indexOf(".") >= 0) {
            var montoRcvAgregar = monto.split(".");
            var montoRcvEnt = montoRcvAgregar[0];
            var montoRcvDecim = montoRcvAgregar[1];
            if (montoRcvDecim.length < 1 && montoRcvEnt.length > 0) {
                $("#" + montoNombre).val(montoRcvEnt + ".0");
                monto = montoRcvEnt + ".0";
            }

            if (montoRcvEnt.length < 1 && montoRcvDecim.length > 0) {
                $("#" + montoNombre).val("0." + montoRcvDecim);
                monto = "0." + montoRcvDecim;
            }

            if (montoRcvEnt.length < 1 && montoRcvDecim.length < 1) {
                $("#" + montoNombre).val("0.0");
                monto = "0.0";
            }
        }

        var accionF = parseFloat(monto) / parseFloat(precioAccion);
        var accion = accionF.toString();
        var accionCompleto = accion.split(".");
        var enterosAccion = accionCompleto[0];
        if (accion.indexOf(".") >= 0) {
            accionF = Math.round(accionF * 100) / 100;
            accion = accionF.toString();
            accionCompleto = accion.split(".");
            enterosAccion = accionCompleto[0];
            var decimalesAccion = accionCompleto[1];
            if (enterosAccion.length > 8) {
                enterosAccion = enterosAccion.substring(0, 8);
            }

            if (decimalesAccion.length > 6) {
                decimalesAccion = decimalesAccion.substring(0, 6);
            }
            $(nombre).val(enterosAccion + "." + decimalesAccion);
        } else {
            if (enterosAccion.length > 8) {
                enterosAccion = enterosAccion.substring(0, 8);
            }
            $(nombre).val(enterosAccion);
        }
    } else {
        $("#" + montoNombre).val(montoOriginal);
        $(nombre).val(accionOriginal);
    }

    montoTotalSumaViv();
}

function montoTotalSumaRcv() {
    var tabla = $("#tablaRcv").DataTable();
    var total = tabla.rows().count();
    var table = $("#tablaRcv").DataTable();

    var cell = [];
    if (total > 0) {
        for (var i = 0; i < total; i++) {
            var sinPrecioAccion = table.cell(i, 5).nodes().to$().find("p").val();
            var siefore = table.cell(i, 6).nodes().to$().find("input").val();
            if (sinPrecioAccion != "" && siefore != "Click aquí") {
                cell.push(table.cell(i, 2).nodes().to$().find("input").val());
            }
        }
        console.log(cell);
        var sumaTotal = 0;
        for (var j = 0; j < cell.length; j++) {
            sumaTotal += parseFloat(cell[j]);
        }

        if (sumaTotal.toString().indexOf(".") >= 0) {
            sumaTotal = Math.round(sumaTotal * 100) / 100;
            var sumT = sumaTotal.toString();
            $("#montoTotalRcv").text("$" + sumT);
            console.log(sumT);
        } else {
            var sumT = sumaTotal.toString();
            $("#montoTotalRcv").text("$" + sumT);
            console.log(sumT);
        }
    } else {
        $("#montoTotalRcv").text("$0");
    }

    var tablaRcv = $("#tablaRcv").DataTable();
    var totalRcv = tablaRcv.rows().count();
    var tablaViv = $("#tablaVivienda").DataTable();
    var totalViv = tablaRcv.rows().count();
    var montoTotalRcv = $("#montoTotalRcv").text();
    montoTotalRcv = montoTotalRcv.replace("$", "");

    var montoTotalViv = $("#montoTotalViv").text();
    montoTotalViv = montoTotalViv.replace("$", "");

    if (totalRcv < 1 && totalViv < 1) {
        $("#spanSubcuentas").show();
        $("#agregarBen").addClass("disabled_Url");
    } else {
        $("#spanSubcuentas").hide();
        $("#agregarBen").removeClass("disabled_Url");
    }

    if (parseFloat(montoTotalRcv) < 1 && parseFloat(montoTotalViv) < 1) {
        $("#spanSubcuentas").show();
        $("#agregarBen").addClass("disabled_Url");
    } else {
        $("#spanSubcuentas").hide();
        $("#agregarBen").removeClass("disabled_Url");
    }
}

function montoTotalSumaViv() {
    var tabla = $("#tablaVivienda").DataTable();
    var total = tabla.rows().count();
    var table = $("#tablaVivienda").DataTable();

    var cell = [];
    if (total > 0) {
        for (var i = 0; i < total; i++) {
            var sinPrecioAccion = table.cell(i, 3).nodes().to$().find("input").val();
            if (sinPrecioAccion != "") {
                cell.push(table.cell(i, 2).nodes().to$().find("input").val());
            }
        }
        console.log(cell);
        var sumaTotal = 0;
        for (var j = 0; j < cell.length; j++) {
            sumaTotal += parseFloat(cell[j]);
        }

        if (sumaTotal.toString().indexOf(".") >= 0) {
            sumaTotal = Math.round(sumaTotal * 100) / 100;
            var sumT = sumaTotal.toString();
            $("#montoTotalViv").text("$" + sumT);
            console.log(sumT);
        } else {
            var sumT = sumaTotal.toString();
            $("#montoTotalViv").text("$" + sumT);
            console.log(sumT);
        }
    } else {
        $("#montoTotalViv").text("$0");
    }
}

function validarDatosBeneficiarios() {
    var valorPorcentajeTotal = $("#porcentajeTotal").text();
    valorPorcentajeTotal = valorPorcentajeTotal.replace("$", "");
    if (Number(valorPorcentajeTotal) > 0 && Number(valorPorcentajeTotal) <= 100) {
        $("#aceptarIssste").removeClass("disabled_Url");
    }
}

function seleccionarSiefore(i, campoSar) {
    $("#aceptarSiefor").addClass("disabled_Url");
    $("#valorSieforeTemporal").val(i);
    if (document.getElementById("siefore" + i).value != "Click aquí") {
        $("#siefores").val(document.getElementById("siefore" + i).value);
    } else {
        $("#siefores").val("0");
    }
    document.getElementById("valorPosicion").innerHTML = i;
    document.getElementById("valorCampoSar").innerHTML = i;
    document.getElementById("valorPosicion").style.display = "none";
    document.getElementById("valorCampoSar").style.display = "none";
    document.getElementById("tipoRecurso").style.display = "none";
    window.location.href = "#miOpcionSiefores";
    $("#miOpcionSiefores").show();
}

function cierraModalSeleccionarSiefore() {
    $("#miOpcionSiefores").hide();
}

function selecionaSiefor() {
    $("#aceptarSiefor").removeClass("disabled_Url");
}

function aceptarSiefore() {
    var tablaRcv = $("#tablaRcv").DataTable();
    var totalRcv = tablaRcv.rows().count();
    if (document.getElementById("siefores").value == "0") {
        $("#siefore" + document.getElementById("valorPosicion").innerHTML).val("Click aquí");
        for (var j = 0; j < totalRcv; j++) {
            var monto = tablaRcv.cell(j, 2).data();
            if (monto.indexOf("montoRcv" + document.getElementById("valorPosicion").innerHTML) >= 0) {
                tablaRcv
                    .cell("#precioAccion" + document.getElementById("valorPosicion").innerHTML)
                    .data("")
                    .draw();
                tablaRcv
                    .cell("#acciones" + document.getElementById("valorPosicion").innerHTML)
                    .data("")
                    .draw();
                tablaRcv
                    .cell("#fechaValor" + document.getElementById("valorPosicion").innerHTML)
                    .data("")
                    .draw();
                break;
            }
        }
        $("#montoRcv" + document.getElementById("valorPosicion").innerHTML).attr("disabled", "disabled");
        if (totalRcv > 0) {
            montoTotalSumaRcv();
        }
    } else {
        document.getElementById("valorPosicion").style.display = "block";
        document.getElementById("valorCampoSar").style.display = "block";
        $("#siefore" + document.getElementById("valorPosicion").innerHTML).val(document.getElementById("siefores").value);
        $("#montoRcv" + document.getElementById("valorPosicion").innerHTML).removeAttr("disabled");
        consultarPrecioAccionRcv(document.getElementById("siefores").value, document.getElementById("valorPosicion").innerHTML, document.getElementById("valorCampoSar").innerHTML);
    }
}

function consultarPrecioAccionRcv(sieforeClave, i, campoSar) {
    var tablaRcv = $("#tablaRcv").DataTable();
    var totalRcv = tablaRcv.rows().count();
    $.ajax({
        method: "GET",
        url: "consultarPrecioAccionSiefore.do",
        contentType: "application/json",
        data: {
            claveSiefore: sieforeClave,
        },
    })
        .success(function (data) {
            console.log(data.flujo);
            if (data.flujo == 1) {
                var mens = data.mensaje;
                if (mens == "SINPRECIOACCION") {
                    for (var j = 0; j < totalRcv; j++) {
                        var monto = tablaRcv.cell(j, 2).data();
                        if (monto.indexOf("montoRcv" + i) >= 0) {
                            tablaRcv
                                .cell("#precioAccion" + i)
                                .data("<p class='error_span'>No existe valor para conversión de subcuenta en pesos</p>")
                                .draw();
                            tablaRcv
                                .cell("#acciones" + i)
                                .data("")
                                .draw();
                            tablaRcv
                                .cell("#fechaValor" + i)
                                .data("")
                                .draw();
                            $("#montoRcv" + document.getElementById("valorPosicion").innerHTML).attr("disabled", "disabled");
                            break;
                        }
                    }
                    if (totalRcv > 0) {
                        montoTotalSumaRcv();
                    }
                } else {
                    for (var j = 0; j < totalRcv; j++) {
                        var monto = tablaRcv.cell(j, 2).data();
                        if (monto.indexOf("montoRcv" + i) >= 0) {
                            $("#montoRcv" + document.getElementById("valorPosicion").innerHTML).removeAttr("disabled");
                            var montoOriginal = tablaRcv.cell(j, 2).nodes().to$().find("input").val();
                            tablaRcv
                                .cell("#precioAccion" + i)
                                .data(data.obRespuesta.nuValtitFhLiquida)
                                .draw();
                            tablaRcv
                                .cell("#fechaValor" + i)
                                .data(data.titulo)
                                .draw();
                            calcularAccionRcvAct(montoOriginal, i, data.obRespuesta.nuValtitFhLiquida, montoOriginal, campoSar);
                            tablaRcv
                                .cell("#acciones" + i)
                                .data($("#valorAccionesTempo").val())
                                .draw();
                            break;
                        }
                    }
                }
            }
        })
        .error(function (data) {
            console.log("Ocurrio un error ::" + data);
        });
}

var timeOut3;
function delayedCalculoRcv(montoOriginal, i, campoSar) {
    timeOut3 = window.setTimeout(function () {
        calcularVentanaRcv(montoOriginal, i, campoSar);
    }, 4000);
}

function calcularVentanaRcv(montoOriginal, i, campoSar) {
    var tablaRcv = $("#tablaRcv").DataTable();
    var totalRcv = tablaRcv.rows().count();

    for (var j = 0; j < totalRcv; j++) {
        var monto = tablaRcv.cell(j, 2).data();
        if (monto.indexOf("montoRcv" + i) >= 0) {
            var montoNuevo = tablaRcv.cell(j, 2).nodes().to$().find("input").val();
            var precioAccion = tablaRcv.cell(j, 5).data();
            calcularAccionRcvAct(montoOriginal, i, precioAccion, montoNuevo, campoSar);
            tablaRcv
                .cell("#acciones" + i)
                .data($("#valorAccionesTempo").val())
                .draw();
            break;
        }
    }
}

function calcularAccionRcvAct(montoOriginal, i, precioAccion, montoActual, campoSar) {
    if (parseFloat(montoActual) > parseFloat(montoOriginal)) {
        $("#" + "montoRcv" + i).val(montoOriginal);
        montoActual = montoOriginal;
    }

    if (montoActual.length < 1) {
        $("#" + "montoRcv" + i).val("0");
        montoActual = "0";
    }

    if (montoActual.indexOf(".") >= 0) {
        var montoRcvAgregar = montoActual.split(".");
        var montoRcvEnt = montoRcvAgregar[0];
        var montoRcvDecim = montoRcvAgregar[1];
        if (montoRcvDecim.length < 1 && montoRcvEnt.length > 0) {
            $("#" + "montoRcv" + i).val(montoRcvEnt + ".0");
            montoActual = montoRcvEnt + ".0";
        }

        if (montoRcvEnt.length < 1 && montoRcvDecim.length > 0) {
            $("#" + "montoRcv" + i).val("0." + montoRcvDecim);
            montoActual = "0." + montoRcvDecim;
        }

        if (montoRcvEnt.length < 1 && montoRcvDecim.length < 1) {
            $("#" + "montoRcv" + i).val("0.0");
            montoActual = "0.0";
        }
    }

    var accionF = parseFloat(montoActual) / parseFloat(precioAccion);
    var accion = accionF.toString();
    var accionCompleto = accion.split(".");
    var enterosAccion = accionCompleto[0];
    if (accion.indexOf(".") >= 0) {
        accionF = Math.round(accionF * 100) / 100;
        accion = accionF.toString();
        accionCompleto = accion.split(".");
        enterosAccion = accionCompleto[0];
        var decimalesAccion = accionCompleto[1];
        if (enterosAccion.length > 8) {
            enterosAccion = enterosAccion.substring(0, 8);
        }

        if (campoSar == "1") {
            if (decimalesAccion.length > 2) {
                decimalesAccion = decimalesAccion.substring(0, 2);
            }
        } else {
            if (decimalesAccion.length > 6) {
                decimalesAccion = decimalesAccion.substring(0, 6);
            }
        }

        $("#valorAccionesTempo").val(enterosAccion + "." + decimalesAccion);
    } else {
        if (enterosAccion.length > 8) {
            enterosAccion = enterosAccion.substring(0, 8);
        }
        $("#valorAccionesTempo").val(enterosAccion);
    }
    montoTotalSumaRcv();
}
