<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/26/14
 * Time: 5:07 PM
 */
include ("dbconnect.php");
$db = connectToDB();

$idToUpdate = mysqli_real_escape_string($db, $_POST['idToUpdate']);

$result = mysqli_query($db,"SELECT * FROM actor WHERE actor_id = '$idToUpdate'");

if(!$result) {
    die('Error: ' . mysqli_error($db));
}
$row = mysqli_fetch_assoc($result);

?>
    <br />
    <html>
    <head>
        <title>Actor</title>
    </head>
    <body>

    <form action="updateActor.php" method="post" enctype="multipart/form-data">
             <input type="hidden" name="actorID" value="<?php echo $row['actor_id']?>">
        First Name : <input type="input" name="firstName" value="<?php echo $row['first_name']?>"> <br />
        Last Name : <input type="input" name="lastName" value="<?php echo $row['last_name']; ?>"> <br />
        <input type="submit" value="Submit">
    </form>

    </body>
    </html>


<?php
mysqli_close($db);
?>
