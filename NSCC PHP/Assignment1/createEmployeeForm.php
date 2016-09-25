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
include ("common/header.php");
?>
<script type="text/javascript" src="Scripts/validator.js"></script>
<br />
<html>

<body>

<form name="createEmployee" onsubmit="return validateEmployeeForm()" action="Scripts/createEmployee.php" method="post" enctype="multipart/form-data">
    <p><b>Creating an employee</b> <br /><br />
    <table>
        <tr>
            <td>First Name :</td>
            <td><input type="input" name="firstName"><span id="firstNameSpan"></span></td>

        </tr>
        <tr>
            <td>Last Name :</td>
            <td><input type="input" name="lastName"><span id="lastNameSpan"></span></td>
        </tr>
        <tr>
            <td>Gender : </td>
            <td><input type="input" name="gender"><span id="genderSpan"></span></td>
        </tr>
        <tr>
            <td>Birth Date :</td>
            <td><input type="text" name="birthDate"><span id="birthDateSpan"></span></td>
        </tr>
        <tr>
            <td>Hire Date :</td>
            <td><input type="text" name="hireDate"><span id="hireDateSpan"></span></td>
        </tr>
    </table><br />
    <input type="submit" value="Submit">
    </p>
</form>

</body>
</html>


