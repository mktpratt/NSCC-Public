<?php
/**
 * Created by PhpStorm.
 * User: MikeandMeaghan
 * Date: 4/24/2015
 * Time: 12:25 PM
 */

require_once("Shape.php");
require_once("iResizable.php");

class Circle extends Shape implements iResizable
{
    private $radius;

    public function __construct($in_name,$in_radius)
    {
        parent::__construct( $in_name);
        $this->radius  = $in_radius;
    }

    // Abstract class method
    public function calculateSize()
    {
        return 2 * pi( ) * $this->radius;
    }
}

?>