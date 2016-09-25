<?php
session_start();
require 'Scripts/isLoggedIn.php';
checkLoginStatus();

/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/26/14
 * Time: 5:07 PM
 */
include("common/header.php");
$db = connectToDB();

$date = date('Y-m-d h:i:s a', time());

$empNo = mysqli_real_escape_string($db, $_POST['empNo']);
$empFirstName = mysqli_real_escape_string($db, $_POST['firstName']);
$empLastName = mysqli_real_escape_string($db, $_POST['lastName']);
$empGender = mysqli_real_escape_string($db, $_POST['gender']);
$empBirthDate = mysqli_real_escape_string($db, $_POST['birthDate']);
$empHireDate = mysqli_real_escape_string($db, $_POST['hireDate']);

$sqlDelete = mysqli_query($db, "UPDATE employees
                                SET first_name = '$empFirstName', last_name = '$empLastName', gender = '$empGender',
                                hire_date = '$empHireDate', birth_date = '$empBirthDate', modified_by = '$_SESSION[Username]',
                                last_modified = '$date'
                                WHERE emp_no = '$empNo'");
if(!$sqlDelete) {
    die('Could not update the record from the Employee Database: ' .
        mysqli_error($db));
}
else
{
    echo "Successfully updated " . mysqli_affected_rows($db) . " record(s)";
}
?>

    <br />
    <a href="EmployeeList.php">Return back to Actor List</a>


<?php
mysqli_close($db);
?>
