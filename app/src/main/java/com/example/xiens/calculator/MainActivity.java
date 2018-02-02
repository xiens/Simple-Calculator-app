package com.example.xiens.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * author Zbigniew Pamula
 * version 1.0
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean enterPressed = false;
    int firstPress = 0; //first press of operation button, if any operation button is pressed for the first time, the result of operation is not calculated, because we only have one number
    int operation = 10; //0 - add  1 - subtract 2- multiply 3-divide 4- modulo 10 - no operation
    double temp = 0; //first variable remembered
    double input = 0; //second variable
    double memory = 0;//memory variable for MC, MR, M+, M-

    //two integers to store current operation number and next operation number
    int currentOperation = 10;
    int nextOperation = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //numbers 0 - 9
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button0 = (Button) findViewById(R.id.button0);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);

        //operations
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        Button buttonAdd = (Button) findViewById(R.id.buttonPlus);
        Button buttonSubtract = (Button) findViewById(R.id.buttonMinus);
        Button buttonC = (Button) findViewById(R.id.buttonC);
        Button buttonCE = (Button) findViewById(R.id.buttonCE);
        Button buttonPow = (Button) findViewById(R.id.buttonPow);
        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        Button buttonOneOverX = (Button) findViewById(R.id.buttonOneOverX);
        Button buttonSqrt = (Button) findViewById(R.id.buttonSQRT);
        Button buttonPercent = (Button) findViewById(R.id.buttonModulo);
        Button buttonComma = (Button) findViewById(R.id.buttonComma);
        Button buttonSign = (Button) findViewById(R.id.buttonSign);

        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonCE.setOnClickListener(this);
        buttonPow.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        buttonOneOverX.setOnClickListener(this);
        buttonSqrt.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonComma.setOnClickListener(this);
        buttonSign.setOnClickListener(this);

        //Memory buttons
        Button buttonMPlus = (Button) findViewById(R.id.buttonMPlus);
        Button buttonMMinus = (Button) findViewById(R.id.buttonMMinus);
        Button buttonMC = (Button) findViewById(R.id.buttonMC);
        Button buttonMR = (Button) findViewById(R.id.buttonMR);
        Button buttonMS = (Button) findViewById(R.id.buttonMSet);

        buttonMPlus.setOnClickListener(this);
        buttonMMinus.setOnClickListener(this);
        buttonMC.setOnClickListener(this);
        buttonMR.setOnClickListener(this);
        buttonMS.setOnClickListener(this);

        //equals
        Button buttonEquals = (Button) findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        TextView resultBox = (TextView) findViewById(R.id.textView2);
        TextView resultBox1 = (TextView) findViewById(R.id.textView);
        double result = 0;


        switch (v.getId()) {
            //input buttons from 0 - 9
            case R.id.button0: {
                resultBox.append("0");
                resultBox1.append("0");
                break;
            }
            case R.id.button1: {
                resultBox.append("1");
                resultBox1.append("1");
                break;
            }
            case R.id.button2: {
                resultBox.append("2");
                resultBox1.append("2");
                break;
            }
            case R.id.button3: {
                resultBox.append("3");
                resultBox1.append("3");
                break;
            }
            case R.id.button4: {
                resultBox.append("4");
                resultBox1.append("4");
                break;
            }
            case R.id.button5: {
                resultBox.append("5");
                resultBox1.append("5");
                break;
            }
            case R.id.button6: {
                resultBox.append("6");
                resultBox1.append("6");
                break;
            }
            case R.id.button7: {
                resultBox.append("7");
                resultBox1.append("7");
                break;
            }
            case R.id.button8: {
                resultBox.append("8");
                resultBox1.append("8");
                break;
            }
            case R.id.button9: {
                resultBox.append("9");
                resultBox1.append("9");
                break;
            }
            //clear all
            case R.id.buttonC: {
                resultBox.setText("");
                resultBox1.setText(""); //erase all
                temp = 0;
                input = 0;
                firstPress = 0;
                enterPressed = false;
                break;
            }
            case R.id.buttonCE: {
                resultBox.setText("");
                break;
            }

            case R.id.buttonPlus: {
                //protection from accidentally clicking the button two times
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    operation = 0;
                    doOperation(resultBox, resultBox1, operation);
                }
                break;
            }
            case R.id.buttonMinus: {
                //protection from accidentally clicking the button two times
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    operation = 1;
                    doOperation(resultBox, resultBox1, operation);
                }
                break;
            }
            case R.id.buttonMultiply: {
                //protection from accidentally clicking the button two times
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    operation = 2;
                    doOperation(resultBox, resultBox1, operation);
                }
                break;
            }
            case R.id.buttonDivide: {
                //protection from accidentally clicking the button two times
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    operation = 3;
                    doOperation(resultBox, resultBox1, operation);
                }
                break;
            }


            case R.id.buttonPow: {
                //protection from accidentally clicking the button two times
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    pow2(resultBox, resultBox1);
                }
                break;
            }
            case R.id.buttonSQRT: {
                //protection from accidentally clicking the button two times
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    sqrt(resultBox, resultBox1);
                }
                break;
            }
            case R.id.buttonOneOverX: {
                //protection from accidentally clicking the button two times
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    oneOverX(resultBox, resultBox1);
                }
                break;
            }
            case R.id.buttonModulo: {
                //protection from accidentally clicking the button two times
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    operation = 4;
                    doOperation(resultBox, resultBox1, operation);
                }
                break;
            }
            //comma
            case R.id.buttonComma: {
                //protection from accidentally adding second dot
                if (resultBox.getText().toString().contains(".")) {
                } else {
                    resultBox.append(".");
                    resultBox1.append(".");
                }
                break;
            }
            case R.id.buttonBack: {
                String text = resultBox.getText().toString();
                if (text != "") {
                    resultBox.setText(text.substring(0, text.length() - 1));
                }
                break;
            }
            case R.id.buttonMC: {
                //memory clear
                memory = 0;
                break;
            }
            case R.id.buttonMSet: {
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    memory = Double.parseDouble(resultBox.getText().toString());
                }
                break;
            }
            case R.id.buttonMR: {
                //memory retrieve
                if (memory != 0) {
                    resultBox.setText(Double.toString(memory));
                }
                break;
            }
            case R.id.buttonMMinus: {
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    memory -= Double.parseDouble(resultBox.getText().toString());
                }
                break;
            }
            case R.id.buttonMPlus: {
                String text = resultBox.getText().toString();
                if (text.length() != 0) {
                    memory += Double.parseDouble(resultBox.getText().toString());
                }
                break;
            }

            case R.id.buttonSign: {
                String text = resultBox.getText().toString();
                String text1 = resultBox1.getText().toString();

                int numLength = text.length();
                if (text.length() != 0) {
                    resultBox.setText("-" + text);
                }
                if (text1.length() != 0) {
                    text1 = text1.substring(0, text1.length() - numLength) + "-" + text1.substring((text1.length() - numLength), text1.length());
                    resultBox1.setText(text1);
                }
                break;
            }

            case R.id.buttonEquals: {
                //resultBox can't be empty !
                if (resultBox.getText().toString() != "") {
                    enterPressed = true;
                    input = Double.parseDouble(resultBox.getText().toString());
                    ////
                    operation = currentOperation;
                    ////
                }
                break;
            }

        }

        if (enterPressed)
            switch (operation) {
                case 0: {
                    result = temp + input;
                    resultBox.setText(Double.toString(result));
                    operation = 10;//no operation
                    nextOperation = 10;
                    currentOperation = 10;
                    temp = 0;
                    enterPressed = false;
                    firstPress = 0;
                    resultBox1.setText(""); //Clear resultBox1
                    break;
                }
                case 1: {
                    result = temp - input;
                    resultBox.setText(Double.toString(result));
                    operation = 10;//no operation
                    nextOperation = 10;
                    currentOperation = 10;
                    enterPressed = false;
                    firstPress = 0;
                    resultBox1.setText(""); //Clear resultBox1
                    break;
                }
                case 2: {
                    result = temp * input;
                    resultBox.setText(Double.toString(result));
                    operation = 10;//no operation
                    nextOperation = 10;
                    currentOperation = 10;
                    temp = 0;
                    enterPressed = false;
                    firstPress = 0;
                    resultBox1.setText(""); //Clear resultBox1
                    break;
                }
                case 3: {
                    if (input == 0) {
                        resultBox1.setText("Don't divide by zero");
                    } else {
                        result = temp / input;
                        resultBox.setText(Double.toString(result)); //presenting the result
                    }
                    operation = 10;//no operation
                    nextOperation = 10;
                    currentOperation = 10;
                    temp = 0;
                    enterPressed = false;
                    firstPress = 0;
                    resultBox1.setText(""); //Clear resultBox1
                    break;
                }
                case 4: {
                    if (input == 0) {
                        resultBox1.setText("Don't divide by zero");
                    } else {
                        result = temp % input;
                        resultBox.setText(Double.toString(result)); //presenting the result
                    }
                    operation = 10;//no operation
                    nextOperation = 10;
                    currentOperation = 10;
                    temp = 0;
                    enterPressed = false;
                    firstPress = 0;
                    resultBox1.setText(""); //Clear resultBox1
                    break;
                }
            }

    }

    //doOperation does operations depending on parameter operation
    // addition- 0 , subtraction - 1, multiplication - 2, division - 3, modulo - 4
    public void doOperation(TextView resultBox, TextView resultBox1, int operation) {
        double result = 0;

        if (currentOperation == 10) {
            currentOperation = operation;
        } else {
            nextOperation = operation;
        }

        input = Double.parseDouble(resultBox.getText().toString());
        if (firstPress == 0) temp = input; //if pressed  first time temp = input

        if (firstPress > 0) {//if there is no current operation

            switch (currentOperation) {
                case 0: {
                    result = temp + input;
                    break;
                }
                case 1: {
                    result = temp - input;
                    break;
                }
                case 2: {
                    result = temp * input;
                    break;
                }
                case 3: {
                    //protection from dividing by zero
                    if (input == 0) {
                        resultBox1.setText("Don't divide by zero");
                    } else {
                        result = temp / input;
                    }
                    break;
                }
                case 4: {
                    //protection from dividing by zero
                    if (input == 0) {
                        resultBox1.setText("Don't divide by zero");
                    } else {
                        result = temp % input;
                    }
                    break;
                }
            }

            resultBox1.setText(Double.toString(result)); //presenting the result
            resultBox.setText(Double.toString(result)); //presenting the result, so we can then parse it to temp
            temp = Double.parseDouble(resultBox.getText().toString());//now temp is the previous sum

            if (nextOperation != 10) //if the next operation is assigned
            {
                currentOperation = nextOperation;
            }

        } else {
            resultBox1.setText(Double.toString(temp)); //presenting the input (only first time)
        }

        firstPress++;

        switch (currentOperation) {
            case 0: {
                resultBox1.append(" + ");//presenting the result
                break;
            }
            case 1: {
                resultBox1.append(" - ");//presenting the result
                break;
            }
            case 2: {
                resultBox1.append(" * ");//presenting the result
                break;
            }
            case 3: {
                resultBox1.append(" / ");//presenting the result
                break;
            }
            case 4: {
                resultBox1.append(" % ");//presenting the result
                break;
            }

        }
        resultBox.setText(""); //Clear resultBox
    }

    public void pow2(TextView resultBox, TextView resultBox1) {
        double result = 0;
        double temp1 = 0;

        temp1 = Double.parseDouble(resultBox.getText().toString());
        result = Math.pow(temp1, 2);

        String text = resultBox1.getText().toString();
        String textToDelete = resultBox.getText().toString();

        if (text.length() != 0) {
            resultBox1.setText(text.substring(0, text.length() - textToDelete.length()));
        }
        resultBox.setText(Double.toString(result)); //presenting the result, so we can then parse it to temp
        resultBox1.append("(" + Double.toString(result) + ")^2"); //presenting the result
        if (firstPress != 0) {
            input = Double.parseDouble(resultBox.getText().toString());//now input is the result
        } else {
            temp = Double.parseDouble(resultBox.getText().toString());
        }
    }

    public void oneOverX(TextView resultBox, TextView resultBox1) {
        double result = 0;
        double temp1 = 0;

        temp1 = Double.parseDouble(resultBox.getText().toString());
        if (temp1 != 0) {
            result = 1 / temp1;
            String text = resultBox1.getText().toString();
            String textToDelete = resultBox.getText().toString();

            if (text.length() != 0) {
                resultBox1.setText(text.substring(0, text.length() - textToDelete.length()));
            }

            resultBox.setText(Double.toString(result)); //presenting the result, so we can then parse it to temp
            resultBox1.append("1/(" + Double.toString(result) + ")"); //presenting the result
            if (firstPress != 0) {
                input = Double.parseDouble(resultBox.getText().toString());//now input is the result
            } else {
                temp = Double.parseDouble(resultBox.getText().toString());
            }
        } else {
            resultBox1.setText("Don't divide by zero");
        }

    }

    public void sqrt(TextView resultBox, TextView resultBox1) {
        double result = 0;
        double temp1 = 0;

        temp1 = Double.parseDouble(resultBox.getText().toString());
        result = Math.sqrt(temp1);

        String text = resultBox1.getText().toString();
        String textToDelete = resultBox.getText().toString();

        if (text.length() != 0) {
            resultBox1.setText(text.substring(0, text.length() - textToDelete.length()));
        }

        resultBox.setText(Double.toString(result)); //presenting the result, so we can then parse it to temp
        resultBox1.append("sqrt(" + Double.toString(result) + ")"); //presenting the result
        if (firstPress != 0) {
            input = Double.parseDouble(resultBox.getText().toString());//now input is the result
        } else {
            temp = Double.parseDouble(resultBox.getText().toString());
        }
    }


}