package com.example.nagliba_wagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeName, employeeHours;
    RadioGroup radioGroup;
    RadioButton btnSelected;
    Button Calculate;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText
        employeeName = findViewById(R.id.NAME);
        employeeHours = findViewById(R.id.HOURS);
        //RadioGroup
        radioGroup = findViewById(R.id.RG);
        //Button
        Calculate = findViewById(R.id.CALCULATE);
        //button On click listener
        Calculate.setOnClickListener(this);
    }

    public void onClick(View v) {


        if (v.getId() == R.id.CALCULATE) {
            int selectedEmployeeType = radioGroup.getCheckedRadioButtonId();

            Calculate = findViewById(selectedEmployeeType);

            String type = Calculate.getText().toString();

            String name = employeeName.getText().toString();
            String totalHours = ( employeeHours.getText().toString() );

            Intent intent = new Intent(this, MainActivity2.class);

            intent.putExtra("type", type);
            intent.putExtra("empName", name);
            intent.putExtra("hours", totalHours);
            startActivity(intent);
        }
    }
}