<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/12/14
 * Time: 5:27 PM
 */
?>

<h2>Mike's Fahrenheit to Celsius Converter</h2>
<a href="CtoF.php">Celsius to Fahrenheit</a>

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
        <th>Fahrenheit</th>
        <th>Celsius</th>
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
            <?php echo round(($f - 32) * (5/9),0); ?>
        </td>
    </tr>
<?php
endfor;
?>

</table>