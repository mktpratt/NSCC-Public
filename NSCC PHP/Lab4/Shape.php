<?php
/**
 * Created by PhpStorm.
 * User: MikeandMeaghan
 * Date: 4/24/2015
 * Time: 12:21 PM
 */

abstract class Shape
{
    protected $name;


    // Abstract methods
    abstract public function calculateSize();

    public function __construct($in_name)
    {
        $this->name = $in_name;
    }
}

?>