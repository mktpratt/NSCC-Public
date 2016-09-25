<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/12/14
 * Time: 5:27 PM
 */
?>

<h2>Mike's Celsius to Fahrenheit Converter</h2>
<a href="FtoC.php">Fahrenheit to Celsius</a>

<style>

    table, td, th {
        border: 2px solid black;
    }

    tr:nth-child(odd) {
        background-color: #708090;
    }

</style>

<table>
    <tr>
        <th>Celsius</th>
        <th>Fahrenheit</th>
    </tr>

    <tr>
        <?php
        // For loop for displaying temperature
        for($f = 0; $f <= 100; $f++):
        ?>
        <td>
            <?php echo $f;?>
        </td>

        <td>
            <?php echo round(($c * (9/5) + 32),0); ?>
        </td>
    </tr>
    <?php
    endfor;
    ?>

</table>