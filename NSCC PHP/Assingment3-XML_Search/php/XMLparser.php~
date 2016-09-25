<?php
echo " test";
//XML Parser - converts to XML DOM Object

//Initialize the XML Parser
$parser = xml_parser_create();

//Function to use at the start of an element

function start($parser,$element_name,$element_attrs){
	
	switch($element_name){
	
	//NODES ARE CASE SENSITIVE MUST BE CAPITALIZED
	case "CAR":
		echo "Car:";
		break;
	
	case "MAKE":
		echo "The make of the car is ... ";
		break;
	
	case "MODEL":
		echo "The model of the car is ... ";
		break;
	
	case "COLOR":
		echo "Color: ";
		break;
	
	case "YEAR":
		echo "Year:  ";
		break;
	
	}
}
echo " test";
function stop($parser,$element_name){
	echo "<br>";
}
echo " test";
function char($parser,$data){
	echo $data;
}

//specify element handler
xml_set_element_handler($parser,"start","stop");

//specify the data handler
xml_set_character_data_handler($parser,"char");

//open XML file
$fp = fopen("/cars.xml","r");

//read the data
while ($data =fread($fp,4096)){
	xml_parse($parser,$data,feof($fp)) 
	or die (sprintf("XML error: %s at line %d",
					xml_error_string(xml_get_error_code($parser)),
					xml_get_current_line_number($parser)));
}




//Free the parser
xml_parser_free($parser);


 
 


echo $output;


?>