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
$db = connectToDB();

$idToUpdate = mysqli_real_escape_string($db, $_POST['emp_no_edit']);

$result = mysqli_query($db,"SELECT * FROM employees WHERE emp_no = '$idToUpdate'");

if(!$result) {
    die('Error: ' . mysqli_error($db));
}
$row = mysqli_fetch_assoc($result);

?>
<script type="text/javascript" src="Scripts/validator.js"></script>
    <br />
    <html>
    <body>

    <form name="createEmployee" action="updateEmployee.php" onsubmit="return validateEmployeeForm()" method="post" enctype="multipart/form-data">
        <p><b>Editing Employee #<?php echo $row['emp_no']; ?></b> <br /><br />
            <table>
             <input type="hidden" name="empNo" value="<?php echo $row['emp_no']?>">
            <tr>
                <td>First Name :</td>
                <td><input type="input" name="firstName" value="<?php echo $row['first_name']?>"><span id="firstNameSpan"></span></td>
            </tr>
            <tr>
                <td>Last Name :</td>
                <td><input type="input" name="lastName" value="<?php echo $row['last_name']; ?>"><span id="lastNameSpan"></span></td>
            </tr>
            <tr>
                <td>Gender : </td>
                <td><input type="input" name="gender" value="<?php echo $row['gender']; ?>"><span id="genderSpan"></span></td>
            </tr>
            <tr>
                <td>Birth Date :</td>
                <td><input type="input" name="birthDate" value="<?php echo $row['birth_date']; ?>"><span id="birthDateSpan"></span></td>
            </tr>
            <tr>
                <td>Hire Date :</td>
                <td><input type="input" name="hireDate" value="<?php echo $row['hire_date']; ?>"><span id="hireDateSpan"></span></td>
            </tr>
        </table>
        <input type="submit" value="Submit">
        </p>
    </form>

    </body>
    </html>


<?php
mysqli_close($db);
?>
