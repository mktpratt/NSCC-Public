<?php
session_start();
require '../Scripts/isLoggedIn.php';
checkLoginStatus();


/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/16/14
 * Time: 3:38 PM
 */

include_once ("../db/dbconnect.php");
$db = connectToDB();

$numToDelete = mysqli_real_escape_string($db, $_POST['emp_num_delete']);

$sqlDelete = mysqli_query($db, "DELETE FROM employees WHERE emp_no = '$numToDelete'");
if(!$sqlDelete) {
    die('Could not delete the record from the Employee Database: ' .
        mysqli_error($db));
}
else
{
    echo "Successfully deleted " . mysqli_affected_rows($db) . " record(s)";
}
?>
<br />
<a href="../EmployeeList.php">Return back to Employee List</a>

<?php
mysqli_close($db);
?>
