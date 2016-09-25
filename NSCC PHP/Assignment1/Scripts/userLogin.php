<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/15/14
 * Time: 2:12 PM
 */
session_start();

include_once ("../db/dbconnect.php");
$db = connectToDB();



$loginUser = $_POST['username'];
$loginPwd = $_POST['password'];


$loginUser = stripslashes($loginUser);
$loginPwd = stripslashes($loginPwd);
$loginUser = mysqli_real_escape_string($db, $loginUser);
$loginPwd = mysqli_real_escape_string($db, $loginPwd);
$shaPwd = hash("sha1", $loginPwd);

$sql = "SELECT * FROM employees.login_user WHERE username='$loginUser' AND password='$shaPwd'";
$result = mysqli_query($db, $sql);
$count = mysqli_num_rows($result);

mysqli_close($db);

if ($count == 1)
{
    echo "connected";
    $_SESSION['Username'] = $loginUser;
    $_SESSION['Password'] = $loginPwd;
    $_SESSION['Count'];
    header("location:../EmployeeList.php");
}
else {
    echo "Incorrect Username or Password!";
    echo "<br />";
    echo '<a href="../login.php">Try again</a>';
}