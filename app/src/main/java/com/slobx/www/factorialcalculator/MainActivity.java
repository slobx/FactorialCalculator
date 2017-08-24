package com.slobx.www.factorialcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numberField;
    Button resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberField = (EditText) findViewById(R.id.numberEditText);
        resultButton = (Button) findViewById(R.id.resultButton);
    }

    private void backgroundFactorialCalculation(int number) {

        int factorial = 1;

        if (number <= 0) {
            makeToast("Number must be greater than zero");
            numberField.setText("");
        } else if (number > 12) {
            makeToast("This version of program only calculates factorials for numbers 1-12");
            numberField.setText("");
        } else {
            for (int i = 1; i <= number; i++) {
                factorial = factorial * i;
            }
            makeToast("Factorial of number " + number + " is " + factorial);
            numberField.setText("");
        }
    }

    public void calculateFactorial(View view){
        String inputText = numberField.getText().toString();
        if (inputText.matches("")){
            makeToast("You must enter a number");
        } else {
            backgroundFactorialCalculation(Integer.parseInt(inputText));
        }
    }

    private void makeToast(String toastText){
        Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();
    }
}
