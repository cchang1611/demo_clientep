/**
 * Script de la pantalla de seleccion de parametros
 */
$(document).ready(
		function() {
			$('#datetimepicker1').datetimepicker({
				locale : 'es',
				format : 'DD/MM/YYYY',
				daysOfWeekDisabled: [0,6],
				maxDate: new Date()
			});
			$('#datetimepicker2').datetimepicker({
				locale : 'es',
				format : 'DD/MM/YYYY',
				maxDate: new Date(),
				daysOfWeekDisabled: [0,6],
				useCurrent : true
			});
			$("#datetimepicker1").on("dp.change", function(e) {
				$("#datetimepicker2").data("DateTimePicker").minDate(e.date);
				validaCamposConsulta();
				activaBtnConsulta();
			});
		
			$("#datetimepicker2").on("dp.change", function(e) {
				validaCamposConsulta();
				activaBtnConsulta();
			});
			
			$("#fechaInicial").keypress(function(evt) {
				evt.preventDefault();
			})
			$("#fechaFinal").keypress(function(evt) {
				evt.preventDefault();
			})
			$('#fechaInicial').bind('copy paste', function(e) {
				e.preventDefault();
				return false;
			});
			$('#fechaFinal').bind('copy paste', function(e) {
				e.preventDefault();
				return false;
			});
		});