<?php
/**
 * Created by PhpStorm.
 * User: Mike Pratt
 * Date: 9/12/14
 * Time: 5:09 PM
 */
?>

<h1> This page was rendered in PHP version <?php echo phpversion();?> </h1><br /><br />

<h1> This page was rendered with PHP Zend version <?php echo zend_version(); ?></h1><br /><br />

<h1> The value assigned to the directive in the php.ini file is: <?php echo ini_get("max_execution_time"); ?></h1>
