// Basic initialization is like this:
// $('.your-class').slick();

// I added some other properties to customize my slider
// Play around with the numbers and stuff to see
// how it works.
var banderaMenuInput = $('#banderaMenuInput').val();

if(banderaMenuInput=='false'){
	$('.slick-carousel').slick({
		  infinite: true,
		  slidesToShow: 4, // Shows a three slides at a time
		  slidesToScroll: 1, // When you click an arrow, it scrolls 1 slide at a time
		  arrows: true, // Adds arrows to sides of slider
		  dots: true // Adds the dots on the bottom
		});
	$('.Carrousel__Title').css('width', '230px');
}else{
	$('.slick-carousel').slick({
		  infinite: true,
		  slidesToShow: 6, // Shows a three slides at a time
		  slidesToScroll: 1, // When you click an arrow, it scrolls 1 slide at a time
		  arrows: true, // Adds arrows to sides of slider
		  dots: true // Adds the dots on the bottom
		});
}