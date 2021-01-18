/**
 * 
 */
$(function(){
	$("#search").on("keyup", function(){
		document.getElementById('searched-place').value = document.getElementById('search').value;
	});
})

function selectPeopleNum() {
	
	//console.log(document.getElementById("optionNo").value);
	document.getElementById("peopleNum").value = document.getElementById("optionNo").value;
}

function submitSearch(){
	document.getElementById('searched-data').submit();
}

function enterkey() {
    if (window.event.keyCode == 13) {
    	submitSearch();
    }
}
