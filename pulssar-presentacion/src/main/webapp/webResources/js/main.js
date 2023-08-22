$(document).ready(function() {
	$("div.blog-post").hover(function() {
		$(this).find("div.content-hide").slideToggle("fast");
		},
		function() {
			$(this).find("div.content-hide").slideToggle("fast");
		}
	);
	$('.flexslider').flexslider({
		prevText: '',
		nextText: ''
	});
	$('.testimonails-slider').flexslider({
		animation: 'slide',
		slideshowSpeed: 5000,
		prevText: '',
		nextText: '',
		controlNav: false
	});
	$(function(){
		$('#Container').mixItUp();
		$(document).ready(function() {
			$(".fancybox").fancybox();
		});
	});
	
	var visit = GetCookie("cookieSar");
	if (visit != "1") {
		window.location.href = "#infoCokies";
	}

	$("#btnCookie").click(function() {
		aceptar_cookies();
		window.location.href = "#";
	});
});

function GetCookie(name) {
	var arg = name + "=";
	var alen = arg.length;
	var clen = document.cookie.length;
	var i = 0;
	while (i < clen) {
		var j = i + alen;
 
		if (document.cookie.substring(i, j) == arg) {
			return "1";
		}
		i = document.cookie.indexOf(" ", i) + 1;
		if (i == 0) {
			 break;
		}
	}
	return null;
}

function aceptar_cookies() {
	var date = new Date();
	date.setTime(date.getTime()+(600*1000));
	document.cookie = "cookieSar=aceptada; expires=" + date.toGMTString();
 
	var visit = GetCookie("cookieSar");
	if (visit != "1") {
		window.location.href = "#infoCokies";
	}
}