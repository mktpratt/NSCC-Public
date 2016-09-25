<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
</head>
<body>
<?php
include_once("Circle.php");

echo "<form action='action_page.php'>
        <fieldset>
          <legend>Personal information:</legend>
            First name:<br>
            <input type='text' name='firstname' value='Mickey'>
            <br>
            Last name:<br>
            <input type='text' name='lastname' value='Mouse'>
            <br><br>
            <input type='submit' value='Submit'>
        </fieldset>
      </form>";

//$myCircle = new Circle("Circle");
//echo "<h1>" . $mySportsCar->driveFiftyMiles() . "</h1>";
//echo "<h1>Current Mileage: " . $mySportsCar->getMileage() . "</h1>";
//echo "<h1>" . $mySportsCar->runIntoTree() . "</h1>";
?>
</body>
</html>