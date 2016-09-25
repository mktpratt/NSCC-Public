<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/26/14
 * Time: 5:07 PM
 */
include ("dbconnect.php");
$db = connectToDB();

$actorID = mysqli_real_escape_string($db, $_POST['actorID']);
$actorFirstName = mysqli_real_escape_string($db, $_POST['firstName']);
$actorLastName = mysqli_real_escape_string($db, $_POST['lastName']);

$sqlDelete = mysqli_query($db, "UPDATE actor
                                SET first_name = '$actorFirstName', last_name = '$actorLastName'
                                WHERE actor_id = '$actorID'");
if(!$sqlDelete) {
    die('Could not update the record from the Sakila Database: ' .
        mysqli_error($db));
}
else
{
    echo "Successfully updated " . mysqli_affected_rows($db) . " record(s)";
}
?>
    <br />
    <a href="createActor.php">Return back to Actor List</a>


<?php
mysqli_close($db);
?>
