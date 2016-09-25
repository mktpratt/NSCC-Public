<?php
session_start();
require 'Scripts/isLoggedIn.php';
checkLoginStatus();

/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/4/14
 * Time: 3:35 PM
 */

include ("common/header.php");
include ("Scripts/employeeIndex.php");
$db = connectToDB();
$MAX_PER_PAGE = 25;

$searchStr = $_POST['searchStr'];
if (isset($_GET['page']))
{
    $page = $_GET['page'] + 1;
    $startIndex = $MAX_PER_PAGE * $page;
}
else
{
    $page = 0;
    $startIndex = 0;
}



if ($searchStr == null || $searchStr == "")
    $result = mysqli_query($db,"SELECT * FROM employees ORDER BY emp_no DESC LIMIT $startIndex, $MAX_PER_PAGE");
else
    $result = mysqli_query($db,"SELECT * FROM employees WHERE first_name LIKE '%$searchStr%' OR last_name LIKE '%$searchStr%' ORDER BY emp_no DESC LIMIT $startIndex,$MAX_PER_PAGE");
?>

<style>

    table, td, th {
        border: 2px solid black;
    }

    tr:nth-child(odd) {
        background-color: #D4D4D4;
    }



</style>

<body>


<div align="right">You are logged in as <?php echo $_SESSION['Username'] ?>. Click here to <a href="Scripts/logout.php">Logout</a></div>


<form method="post">
    <b>Search First & Last Names From Database</b>
    <br /><br />
    Search: <input type="text" name="searchStr" id="searchStr" value="<?php echo $searchStr; ?>">
    <br />
    <input type="submit" value="Submit Query">
</form>



<a href="#" class="toggle-employee">Show/Hide Employee Record Table</a> <br />
<?php
$rec_count = $row[0];
$left_rec = $rec_count - ($page * $MAX_PER_PAGE);
if ($page > 0)
{
    $last = $page - 2;
    echo "<a href=\"$_PHP_SELF?page=$last\">Previous 25 Records</a> | ";
    echo "<a href=\"$_PHP_SELF?page=$page\">Next 25 Records</a>";
}
else if ($page == 0)
{
    echo "<a href=\"$_PHP_SELF?page=$last\">Next 25 Records</a> | ";
}
else if ($left_ref < $MAX_PER_PAGE)
{
    $last = $page - 2;
    echo "<a href=\"$_PHP_SELF?page=$last\">Previous 25 Records</a> | ";
}
?>
<table>

    <thead>

    <tr>
        <th>Emp #</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Birth Date</th>
        <th>Hire Date</th>
        <th>Delete</th>
        <th>Edit</th>
        <th><a href="createEmployeeForm.php"><img src="imgs/add.png"/></a></th>
    </tr>
    </thead>
    <?php
    while ($row = mysqli_fetch_assoc($result))
    {
        ?>
        <tr>
            <td><?php echo $row['emp_no']; ?></td>
            <td><?php echo $row['first_name']; ?></td>
            <td><?php echo $row['last_name']; ?></td>
            <td><?php echo $row['gender']; ?></td>
            <td><?php echo $row['birth_date']; ?></td>
            <td><?php echo $row['hire_date']; ?></td>
            <td>
                <form name="deleteForm" action="deleteEmployeeForm.php" method="post">
                    <input type="hidden" name="emp_no_delete" value="<?php echo $row['emp_no']; ?>">
                    <button name="button" value="Delete"><img src="imgs/x.jpg" class="center-delete" id="<?php echo $row['emp_no']; ?>"></button>
                </form>
            </td>
            <td>
                <form action="updateEmployeeForm.php" method="post">
                    <input type="hidden" name="emp_no_edit" value="<?php echo $row['emp_no']; ?>">
                    <button name="button" value="Edit"><img src="imgs/edit.png" class="center-edit" id="<?php echo $row['emp_no']; ?>"></button>
                </form>
            </td>
        </tr>
    <?php
    }
    ?>
</table>


</body>
</html>





