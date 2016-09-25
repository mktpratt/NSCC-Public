<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/15/14
 * Time: 12:06 PM
 */
function checkLoginStatus() {


    if(empty($_SESSION['Username']) || empty($_SESSION['Password'])) {
        header("location:login.php");
    }
}



?>