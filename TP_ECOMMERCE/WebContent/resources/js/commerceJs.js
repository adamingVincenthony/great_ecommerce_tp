
//Fonction pour l'apparition des div en cliquant sur la bar de menu
function openLink(evt, idTab) {
	var i, x, tablinks;
	x = document.getElementsByClassName("section");
	for (i = 0; i < (x.length); i++) {
		x[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablink");
	for (i = 0; i < (x.length); i++) {
		tablinks[i].className = tablinks[i].className.replace(" w3-green", "");
	}
	document.getElementById(idTab).style.display = "block";
	evt.currentTarget.className += " w3-green";
}

