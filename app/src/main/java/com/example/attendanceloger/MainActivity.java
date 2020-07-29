package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    public static String item = "Select Class / Lectures";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.simpleSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.arraySpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    public void addStudent(View view)
    {
        Intent intent = new Intent(this,AddStudentActivity.class);
        startActivity(intent);

    }

    public void addAttendance(View view)
    {
        Intent intent = new Intent(this,AddAttendanceActivity.class);
        startActivity(intent);


    }

    public void viewStudents(View view)
    {
        Intent intent = new Intent(this,ViewStudentActivity.class);
        startActivity(intent);

    }

    public void viewAttendance(View view)
    {
        Intent intent = new Intent(this,ViewAttendanceActivity.class);
        startActivity(intent);


    }

    public void timeTable(View view)
    {
        Intent intent = new Intent(this,TimeTableActivity.class);
        startActivity(intent);


    }
    public void setting(View view)
    {
        Intent intent = new Intent(this,SettingActivity.class);
        startActivity(intent);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        item = adapterView.getItemAtPosition(i).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
