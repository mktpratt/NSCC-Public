<!DOCTYPE html>

<html>
<body>

<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/8/14
 * Time: 11:27 PM
 */
echo "<h1> Greetings from Lab1. </h1>";



?>

<p>Blah blah blah blah.. This is some text after the closing PHP tag.</p>

<h3>This is a new paragraph written in php.</h3>

<?php
/** Step 2: Using a string variable */
$myName = "Mike Pratt";
echo "My name is: " . $myName;

?>

<br /><br />


<b>Step 3: Using the Concatenation Operator</b> <br />
<?php
/** Step 3: Using the Concatenation Operator */
$string1 = "This is ";
$string2 = "a string that ";
$string3 = "is made up of ";
$string4 = "4 different strings.";
$finalString = $string1 . $string2 . $string3 . $string4;
echo "\r\n" . $finalString;

?>

<br /><br />

<b>Step 4: Using the Arithmetic Operators</b> <br />
<?php
/** Step 4: Using the Arithmetic Operators */
# a. (32 * 14) + 83
$anum1 = 32;
$anum2 = 14;
$anum3 = 83;

echo "a) (" . $anum1 . " * " . $anum2 . ") + " . $anum3 . " = " . (($anum1 * $anum2) + $anum3);

echo "<br />";

# b. (1024 / 128) - 7
$bnum1 = 1024;
$bnum2 = 128;
$bnum3 = 7;

echo "b) (" . $bnum1 . " / " . $bnum2 . ") - " . $bnum3 . " = " . (($bnum1 / $bnum2) - $bnum3);

echo "<br />";

# c. the remainder of 769 divided by 6
$cnum1 = 769;
$cnum2 = 6;

echo "c) The remainder of 769 divided by 6 = " . ($cnum1 % $cnum2)

?>

<br /><br />

<b>Step 5: Use a loop</b> <br />

<?php

for ($i = 10; $i >= 1; $i--)
{
    echo $i . "...";
    if ($i == 1)
    {
        echo "BLAST OFF!!!";
    }
}

?>

<br /><br />

<b>Step 6: Use an array</b> <br />

<?php

$colours = array("Blue", "Black", "Green", "Red", "Yellow", "Orange", "Pink");

echo "Using a for loop <br />";
for ($n = 0; $n < count($colours); $n++)
{
    echo ($n + 1) . ". " . $colours[$n] . " ";
}

echo "<br />Using a foreach loop <br />";
foreach($colours as $index=>$c)
{
    echo ($index + 1) . ". " . $c . " ";
}


echo "<br />Using a while loop <br />";
$c = 0;
while ($c < count($colours))
{
    echo ($c + 1) . ". " . $colours[$c] . " ";
    $c++;
}

?>
</body>
</html>