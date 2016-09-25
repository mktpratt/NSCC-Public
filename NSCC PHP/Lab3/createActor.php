<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/26/14
 * Time: 4:12 PM
 */
?>

<style>

    table, td, th {
        border: 2px solid red;
    }

</style>

<?php
include_once ("dbconnect.php");
$db = connectToDB();

$firstName = mysqli_real_escape_string($db,$_POST['firstName']);
$lastName = mysqli_real_escape_string($db,$_POST['lastName']);

if(!empty($firstName) && !empty($lastName))
{
    $sqlInsert = "INSERT INTO actor (first_name, last_name) VALUES ('$firstName', '$lastName')";
    if(!mysqli_query($db, $sqlInsert))
    {
        die('Error: ' . mysqli_error($db));
    }
    echo "Added " . $firstName . " " . $lastName . " to the database. <br />";
}



$result = mysqli_query($db,"SELECT * FROM actor ORDER BY actor_id DESC LIMIT 0,10");
?>
<table>
    <thead>
    <tr>
        <th>ActorID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Last Updated</th>
    </tr>
    </thead>
<?php
while ($row = mysqli_fetch_assoc($result))
{
?>
    <tr>
    <td><?php echo $row['actor_id']; ?></td>
    <td><?php echo $row['first_name']; ?></td>
    <td><?php echo $row['last_name']; ?></td>
    <td><?php echo $row['last_update']; ?></td>
    </tr>
<?php
}
?>
</table>

<html>
<head>
    <title>Actor List</title>
</head>
<body>

<form action="deleteActor.php" method="post" enctype="multipart/form-data">
    <br />
    ID to Delete : <input type="input" name="idToDelete"> <br />
    <input type="submit" value="Submit">
</form>
<form action="updateActorForm.php" method="post" enctype="multipart/form-data">
    <br />
    ID to Update : <input type="input" name="idToUpdate"> <br />
    <input type="submit" value="Submit">
</form>

</body>
</html>

<?php
mysqli_close($db);
?>


