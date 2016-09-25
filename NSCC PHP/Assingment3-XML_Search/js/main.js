

var xmlHttp;

function GetXmlHttpObject(){

	var xmlHttp = null;
	
	try{
		xmlHttp = new XMLHttpRequest(); // Good for Firefox/Safari/Chrome etc...
	}catch (e){
		try{
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // Newer IE 6 >
		} catch(e){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); // IE 6 <
		}
	}
	return xmlHttp;
}


function showCars(searchString){

	xmlHttp = GetXmlHttpObject();
	
	if (xmlHttp == null){
		alert("Browser does not support HTTP Requests");
		return;
	}
	
	if( searchString.length == 0){
		document.getElementById("clearInput").innerHTML = "";
		document.getElementById("showCourse").innerHTML = "";
		return;
	}
	
	var url = "./test.php";
	url = url+"?car="+searchString;
	
	xmlHttp.onreadystatechange = stateChanged;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}

function stateChanged(){

	if (xmlHttp.readyState==4){
		document.getElementById("showCourse").innerHTML = "<?php include('test.php')";
	}
}