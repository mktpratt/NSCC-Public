/*  Assignment 1 - Calculator
    calcMath.java class
    Written by: Mike Pratt
    Due Date: Oct. 1, 2014
    Version: 1.0
 */

package com.example.w0267422.a1_calculator;

import android.app.Activity;
import android.widget.TextView;
import java.lang.Math;

public class calcMath {

    // Addition function
    public static double add(double leftVal, double rightVal)
    {
        double a = 0;
        a = leftVal + rightVal;
        return a;
    }
    // Subtraction function
    public static double subtract(double leftVal, double rightVal)
    {
        double a = 0;
        a = leftVal - rightVal;
        return a;
    }
    // Multiplication function
    public static double multiply(double leftVal, double rightVal)
    {
        double a = 0;
        a = leftVal * rightVal;
        return a;
    }
    // Division function
    public static double divide(double leftVal, double rightVal) {
        if (rightVal == 0) {
            return Double.parseDouble("NaN");
        } else if (leftVal == 0) {
            return rightVal;
         }
        else {
            Double c = leftVal / rightVal;
            return c;
        }
    }

    // Plus or Minus switch function
    public static double plusOrMinus(double val)
    {
        double a = val * -1;
        return a;
    }

    // Equals function
    public static double equals(double leftVal, String operator, double rightVal) {
        double a = 0;

        if (operator.equals("+")) {
            a = add(leftVal, rightVal);
        }
        else if (operator.equals("-")) {
            a = subtract(leftVal, rightVal);
        }
        else if (operator.equals("x")) {
            a = multiply(leftVal, rightVal);
        }
        else if (operator.equals("÷")) {
            a = divide(leftVal, rightVal);
        }
        return a;
    }

    public static String addDecimal(String num) {
        String a = "";
        if (num == "") {
            num = "0";
        }
        a = num + ".";
        return a;
    }

    }
