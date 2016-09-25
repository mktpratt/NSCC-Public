<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 10/4/14
 * Time: 3:24 PM
 */

include ("db/dbconnect.php");
?>

<html>
<head>
    <title>Mike's INET2005 Assignment 1</title>
    <link href="css/style.css" rel="stylesheet">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

    <script>
      $(document).ready(function() {
        $('.toggle-employee').click(function() {
          $('table').toggle('fast');
        });
      });
    </script>

</head>
