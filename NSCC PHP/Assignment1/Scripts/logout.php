<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/15/14
 * Time: 2:03 PM
 */

session_start();
session_destroy();
header("location:../login.php");

?>