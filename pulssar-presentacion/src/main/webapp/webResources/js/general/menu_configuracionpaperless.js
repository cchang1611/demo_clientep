
function myFunction01() {
document.getElementById("myDropdownPaperless").classList.toggle("showPaperless");
}

window.onclick = function(event) {
	var matches =  matches = event.target.matches ? event.target.matches('.dropbtnPaperless') : event.target.msMatchesSelector('.dropbtnPaperless');
if (!matches) {
  var dropdownsPaperless = document.getElementsByClassName("dropdownPaperless-content");
  var i;
  for (i = 0; i < dropdownsPaperless.length; i++) {
    var openDropdownPaperless = dropdownsPaperless[i];
    if (openDropdownPaperless.classList.contains('showPaperless')) {
      openDropdownPaperless.classList.remove('showPaperless');
      }
    }
  }
}
