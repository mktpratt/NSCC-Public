<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/26/14
 * Time: 5:07 PM
 */
include ("dbconnect.php");
$db = connectToDB();

$idToDelete = mysqli_real_escape_string($db, $_POST['idToDelete']);

$sqlDelete = mysqli_query($db, "DELETE FROM actor WHERE actor_id = '$idToDelete'");
if(!$sqlDelete) {
    die('Could not delete the record from the Sakila Database: ' .
    mysqli_error($db));
}
else
{
    echo "Successfully deleted " . mysqli_affected_rows($db) . " record(s)";
}
?>
<br />
<a href="createActor.php">Return back to Actor List</a>

<?php
mysqli_close($db);
?>
