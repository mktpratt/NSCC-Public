<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/26/14
 * Time: 2:40 PM
 */

function connectToDB()
{
    $db = mysqli_connect("localhost", "root", "inet2005", "sakila");
    if (!db)
    {
        die('Could not connect to the Sakila Database: ' .
            mysqli_error($db));
    }
    return $db;
}