package com.azimbaldiwala.bmicalculator;

import android.graphics.Color;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public void getBmi(View view){

        EditText height = (EditText) findViewById(R.id.textHeight);
        EditText weight = (EditText) findViewById(R.id.textWeight);
        // Converting editText into string
        String height_ = height.getText().toString();
        String weight_ = weight.getText().toString();
        // Converting string to double using wrapper class
        double fHeight = Double.parseDouble(height_);
        double fWeight = Double.parseDouble(weight_);


        // Applying BMI Formula

        double bmi = 0.0;
        // Converting height into meter from cms
        fHeight = fHeight/100;

        bmi = fWeight / (fHeight * fHeight);
        bmi = Math.round(bmi * 100.0)/100.0;
        String fBmi = "BMI: " + bmi;

        // Display to textView

        TextView showBmi = (TextView) findViewById(R.id.textResult);
        showBmi.setText(fBmi);

        TextView showStatus = (TextView) findViewById(R.id.textStatus);
        String stat;

        if(bmi < 16.0){
            stat =  "Status: Severe Underweight";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(255,0,0));
        }
        else if(bmi >= 16.0 && bmi < 17.0){
            stat = "Status: Moderate Underweight";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(255,51,51));
        }
        else if(bmi >= 17.0 && bmi < 18.5){
            stat = "Status: Mild Underweight";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(255,204,0));
        }
        else if(bmi >= 18.5 && bmi < 24){
            stat = "Status: Healthy weight";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(0,204,0));
        }
        else if(bmi >= 24 && bmi < 25){
            stat = "Status: At risk of overweight";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(255,204,0));
        }
        else if(bmi >= 25 && bmi < 30){
            stat = "Status: Overweight";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(255,51,51));
        }
        else if(bmi >= 30 && bmi < 35){
            stat = "Status: Obese Class I";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(255,0,0));
        }
        else if(bmi >= 35 && bmi < 40){
            stat = "Status: Obese Class II";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(255,0,0));
        }

        else{
            stat = "Status: Obese Class III!";
            showStatus.setText(stat);
            showStatus.setTextColor(Color.rgb(255,0,0));
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}