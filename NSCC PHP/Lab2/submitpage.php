<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/12/14
 * Time: 6:22 PM
 */

$firstname = $_POST['FirstName'];
$lastname = $_POST['LastName'];
$heightfeet = $_POST['HeightFeet'];
$heightinches = $_POST['HeightInches'];
$heightmetres = round((((12 * $heightfeet) + $heightinches) / 39.37),2);

echo 'Your first name is: ' . $firstname . "<br />";
echo 'Your last name is: ' . $lastname . "<br />";
echo 'Your height in metres is: ' . $heightmetres;

?>

<br /><br /><br />
<b><u>File Information:</u></b><br />


<?php
if ($_FILES["file"]["error"] > 0) {
    echo "Error loading file!";
}
else
{
    $fileTmpName = $_FILES['file']['tmp_name'];
    $fileOrigName = $_FILES["file"]["name"];
    $fileSize = $_FILES["file"]["size"] / 1024;
    $fileUploadError = $_FILES["file"]["error"];


    echo "Tmp: " . $fileTmpName . "<br />";
    echo "Orig: " . $fileOrigName . "<br />";
    echo "Size: " . $fileSize . "kB<br />";
    echo "Error: " . $fileUploadError . "<br>";
    if (file_exists($fileOrigName)) {
        echo $_FILES["file"]["name"] . " already exists. ";
    }
    else {
        move_uploaded_file($fileTmpName,"uploads/".$fileOrigName);
    }
}


?>