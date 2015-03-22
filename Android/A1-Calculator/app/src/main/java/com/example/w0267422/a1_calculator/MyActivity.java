/*  Assignment 1 - Calculator
    MyActivity.java class
    Written by: Mike Pratt
    Due Date: Oct. 1, 2014
    Version: 1.0
 */

package com.example.w0267422.a1_calculator;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.example.w0267422.a1_calculator.calcMath;


public class MyActivity extends Activity implements OnClickListener {

    // Create buttons and other variables
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDec, btnClr, btnDel,
            btnMul, btnAdd, btnDiv, btnSub, btnEqual, btnPoM;
    TextView tvCalc;
    double total;
    String operator;
    int lastPressed = 0, empty = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        // Find/set the buttons
        btn0 = (Button)findViewById(R.id.button0);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);
        btn9 = (Button)findViewById(R.id.button9);
        btnEqual = (Button)findViewById(R.id.buttonEquals);
        btnDec = (Button)findViewById(R.id.buttonDecimal);
        btnPoM = (Button)findViewById(R.id.buttonPlusOrMinus);
        btnAdd = (Button)findViewById(R.id.buttonPlus);
        btnSub = (Button)findViewById(R.id.buttonMinus);
        btnDiv = (Button)findViewById(R.id.buttonDivide);
        btnMul = (Button)findViewById(R.id.buttonMultiply);
        btnDel = (Button)findViewById(R.id.buttonDelete);
        btnClr = (Button)findViewById(R.id.buttonClear);
        tvCalc=(TextView)findViewById(R.id.textViewCalc);

        // Set button onClickListener
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDec.setOnClickListener(this);
        btnPoM.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnClr.setOnClickListener(this);
        btnClr.performClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    // Add the number to the string on screen
    public void showNum(String num) {
        if (empty == 1) {
            tvCalc.setText("");
            empty = 0;
        }
        else if (tvCalc.getText() == "0")
        {
            tvCalc.setText("");
        }
        tvCalc.setText(tvCalc.getText() + num);
    }


    // Override the onClick method to do specific button presses
    @Override
    public void onClick(View view) {
        // Button 0
        if (view.getId() == R.id.button0) {
            showNum("0");
        }
        // Button 1
        else if (view.getId() == R.id.button1) {
            showNum("1");
        }
        // Button 2
        else if (view.getId() == R.id.button2) {
            showNum("2");
        }
        // Button 3
        else if (view.getId() == R.id.button3) {
            showNum("3");
        }
        // Button 4
        else if (view.getId() == R.id.button4) {
            showNum("4");
        }
        // Button 5
        else if (view.getId() == R.id.button5) {
            showNum("5");
        }
        // Button 6
        else if (view.getId() == R.id.button6) {
            showNum("6");
        }
        // Button 7
        else if (view.getId() == R.id.button7) {
            showNum("7");
        }
        // Button 8
        else if (view.getId() == R.id.button8) {
            showNum("8");
        }
        // Button 9
        else if (view.getId() == R.id.button9) {
            showNum("9");
        }
        // Clr button
        else if (view.getId() == R.id.buttonClear) {
            tvCalc.setText("0");
            total = 0.0;
            operator = "";
            enableButtons();
        }
        // Decimal button
        else if (view.getId() == R.id.buttonDecimal) {
            // Check if blank
            if (empty == 1)
            {
                tvCalc.setText("");
                empty = 0;
            }
                // Check if there is no decimal already
            if (tvCalc.getText().toString().indexOf(".") < 0) {
                String num = tvCalc.getText().toString();
                num = calcMath.addDecimal(num);
                tvCalc.setText(num);
            }
        }
        // Del button
        else if (view.getId() == R.id.buttonDelete)
        {
            // Check if the length is greater than 0
            if (tvCalc.getText().toString().length() > 0) {
                int beginning = 0;
                int end = tvCalc.getText().toString().length() - 1;
                String updatedNum = tvCalc.getText().toString().substring(beginning, end);
                // If it's empty, set to 0
                if (beginning == 0 && end == 0)
                {
                    updatedNum = "0";
                }
                tvCalc.setText(updatedNum);
            }
        }
        // Plus button
        else if (view.getId() == R.id.buttonPlus)
        {
            setOperator("+");
        }
        // Minus button
        else if (view.getId() == R.id.buttonMinus)
        {
            setOperator("-");
        }
        // Multiply button
        else if (view.getId() == R.id.buttonMultiply)
        {
            setOperator("x");
        }
        // Divide button
        else if (view.getId() == R.id.buttonDivide)
        {
            setOperator("÷");
        }
        // Equals button
        else if (view.getId() == R.id.buttonEquals) {
            Double newNum = Double.parseDouble(tvCalc.getText().toString());
            total = calcMath.equals(total, operator, newNum);
            // Check for NaN
            if (String.valueOf(total).equals("NaN")) {
                disableButtons();
            }
            tvCalc.setText(String.valueOf(total));
            operator = "=";
        }
        // +- button
        else if (view.getId() == R.id.buttonPlusOrMinus) {
            Double newNum = Double.parseDouble(tvCalc.getText().toString());
            if (newNum > 0 || newNum < 0)
                newNum = calcMath.plusOrMinus(newNum);
            else
                newNum = 0.0;
            tvCalc.setText(String.valueOf(newNum));
        }
        lastPressed = view.getId();
    }

    // Set the operator
    public void setOperator(String op) {
        if (lastPressed == R.id.buttonPlus || lastPressed == R.id.buttonMinus ||
        lastPressed == R.id.buttonMultiply|| lastPressed == R.id.buttonDivide) {

        }
        else {
            empty = 1;
            Double newNum = Double.parseDouble(tvCalc.getText().toString());
            if (operator == "" || operator == "=") {
                total = newNum;
                tvCalc.setText(String.valueOf(total));
            }
            else if (operator == "+") {
                total = calcMath.add(total,newNum);
                tvCalc.setText(String.valueOf(total));
            }
            else if (operator == "-") {
                total = calcMath.subtract(total, newNum);
                tvCalc.setText(String.valueOf(total));
            }
            else if (operator == "÷") {
                total = calcMath.divide(total, newNum);
                if (String.valueOf(total).equals("NaN")) {
                    disableButtons();
                }
                tvCalc.setText(String.valueOf(total));
            }
            else if (operator == "x") {
                total = calcMath.multiply(1, newNum);
                tvCalc.setText(String.valueOf(total));
            }
        }
        operator = op;
    }

    // Disable all the button except Clr
    private void disableButtons() {
        btn0.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3 .setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btnEqual.setEnabled(false);
        btnDec.setEnabled(false);
        btnPoM.setEnabled(false);
        btnAdd.setEnabled(false);
        btnSub.setEnabled(false);
        btnDiv.setEnabled(false);
        btnMul.setEnabled(false);
        btnDel.setEnabled(false);
    }

    // Enable all the disabled buttons again
    private void enableButtons() {
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3 .setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btnEqual.setEnabled(true);
        btnDec.setEnabled(true);
        btnPoM.setEnabled(true);
        btnAdd.setEnabled(true);
        btnSub.setEnabled(true);
        btnDiv.setEnabled(true);
        btnMul.setEnabled(true);
        btnDel.setEnabled(true);
    }
}


