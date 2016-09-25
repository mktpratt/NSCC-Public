<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/4/14
 * Time: 3:25 PM
 */
include ("common/header.php");
include ("js/validateLogin.js");
session_start();
?>

<!DOCTYPE html>
<html>

<body>
<form name="myForm" action="Scripts/userLogin.php" method="post">
    <h1>Please Login</h1>
Username: <input type="text" name="username"> <br />
    Password: <input type="password" name="password"> <br />
    <input type="submit" value="Submit">
    </form>
</body>
</html>