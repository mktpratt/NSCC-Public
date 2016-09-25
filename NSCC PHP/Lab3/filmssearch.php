<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/22/14
 * Time: 2:55 PM
 */

include("dbconnect.php");
$db = connectToDB();

$desc = $_POST['filmDescSearch'];

$result = mysqli_query($db,"SELECT * FROM film WHERE description LIKE '%$desc%' LIMIT 0,10");
?>


<style>

    table, td, th {
        border: 2px solid red;
    }

</style>


<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Description</th>
    </tr>
    </thead>
    <?php
    while ($row = mysqli_fetch_assoc($result))
    {
        ?>
        <tr>
            <td><?php echo $row['title']; ?></td>
            <td><?php echo $row['description']; ?></td>
        </tr>
    <?php
    }
    ?>
</table>

<br />
<html>
<body>
<form action="#" method="post" enctype="multipart/form-data">
    <input type="input" name="filmDescSearch">
    <input type="submit" value="Submit">
</form>
</body>
</html>