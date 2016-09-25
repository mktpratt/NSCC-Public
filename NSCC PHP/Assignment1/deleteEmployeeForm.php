<?php
session_start();
require 'Scripts/isLoggedIn.php';
checkLoginStatus();

/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/16/14
 * Time: 3:41 PM
 */

include ("common/header.php");
$db = connectToDB();

$numToDelete = mysqli_real_escape_string($db, $_POST['emp_no_delete']);

$result = mysqli_query($db,"SELECT * FROM employees WHERE emp_no = '$numToDelete'");

if(!$result) {
    die('Error: ' . mysqli_error($db));
}
$row = mysqli_fetch_assoc($result);

?>
<br />
<html>

<body>

<form action="Scripts/deleteEmployee.php" method="post" enctype="multipart/form-data">
    <p><b> Are you SURE you'd like to delete Employee #<?php echo $row['emp_no']; ?>?</b> <br /><br />
        <input type="hidden" name="emp_num_delete" value="<?php echo $row['emp_no']; ?>">
    <table>
        <input type="hidden" name="empNo" value="<?php echo $row['emp_no_delete']?>">
        <tr>
            <td>First Name :</td>
            <td><?php echo $row['first_name']; ?></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><?php echo $row['last_name']; ?></td>
        </tr>
        <tr>
            <td>Gender : </td>
            <td><?php echo $row['gender']; ?></td>
        </tr>
        <tr>
            <td>Birth Date :</td>
            <td><?php echo $row['birth_date']; ?></td>
        </tr>
        <tr>
            <td>Hire Date :</td>
            <td><?php echo $row['hire_date']; ?></td>
        </tr>
    </table>
    <br />
    <input type="submit" class="delButton" value="Delete"> <a href="EmployeeList.php"><input type="button" value="Cancel"></a>
    </p>
</form>

</body>
</html>


<?php
mysqli_close($db);
?>
