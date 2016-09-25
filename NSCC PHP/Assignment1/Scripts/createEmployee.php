<?php

session_start();
require 'isLoggedIn.php';
checkLoginStatus();

/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/16/14
 * Time: 3:37 PM
 */

include_once ("../db/dbconnect.php");
$db = connectToDB();

$date = date('Y-m-d h:i:s a', time());
$firstName = mysqli_real_escape_string($db,$_POST['firstName']);
$lastName = mysqli_real_escape_string($db,$_POST['lastName']);
$gender = mysqli_real_escape_string($db, $_POST['gender']);
$birthDate = mysqli_real_escape_string($db, $_POST['birthDate']);
$hireDate = mysqli_real_escape_string($db, $_POST['hireDate']);
$hireDateParsed = date_parse($hireDate);
$birthDateParsed = date_parse($birthDate);

if(!empty($firstName) && !empty($lastName) && !empty($gender) && !empty($birthDate) && !empty($hireDate))
{
    $sqlInsert = "INSERT INTO employees (first_name, last_name, gender, birth_date, hire_date, last_modified, modified_by)
        VALUES ('$firstName', '$lastName', '$gender', '$birthDate', '$hireDate', '$date', '$_SESSION[Username]')";
    if(!mysqli_query($db, $sqlInsert))
    {
        die('Error: ' . mysqli_error($db));
    }
    echo "Added " . $firstName . " " . $lastName . " to the database. <br />";
}
else
    echo "Failed to create employee";
?>
<br />
<a href="../EmployeeList.php">Return back to Employee List</a>