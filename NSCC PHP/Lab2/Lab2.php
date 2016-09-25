<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/11/14
 * Time: 1:08 PM
 */
?>

    <b><u>Mike Pratt - Lab 2</u><br /><br /></b>

<?php
function acceptStrings($number, $string)
{
    switch ($number)
    {
        case 1:
            echo "<h1>" . $string . "</h1>\n";
            break;
        case 2:
            echo "<h2>" . $string . "</h2>\n";
            break;
        case 3:
            echo "<h3>" . $string . "</h3>\n";
            break;
        case 4:
            echo "<h4>" . $string . "</h4>\n";
            break;
        case 5:
            echo "<h5>" . $string . "</h5>\n";
            break;
        case 6:
            echo "<h6>" . $string . "</h6>\n";
            break;
        default:
            echo "Error! The number is not between 1 and 6!\n";
            break;

    }
}
?>

    <b><u>Step 1: Write a PHP Function</u><br /><br /></b>


<?php

for ($i = 0; $i <= 6; $i++)
{
    acceptStrings($i, "This is a string");
}

?>

    <b><u>Step 2: Pass variables to PHP functions by both Reference and Value</u></b> <br />


<?php

function byValue($var)
{
    $var .= '...blah';
}

function byReference(&$var)
{
    $var .= '...blah';
}

?>

<?php

//3. Outside of the function,
//a. create a string variable and give it a default message such as “Hello, World”.
$string = 'Hello, World';
//b. print the variable.
echo $string . "<br />";
?>

    <b><u>Passing by Value</u></b><br />

<?php
//c. pass it into the value function.
byValue($string);
//d. print the variable
echo $string . "<br />";
?>

    <b><u>Passing by Reference</u></b><br />

<?php
//e. pass it into the reference function
byReference($string);
//f. print the variable
echo $string . "<br />";

?>

    <br /><b><u>Step 3: Use a global variable in a function  </u></b><br />

<?php

$age = 24;

function printAge()
{
    echo 'I am ' . $GLOBALS['age'] . ' years old.<br />';
}

printAge();

?>



