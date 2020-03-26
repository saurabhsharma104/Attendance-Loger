package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public String[] arraySpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arraySpinner = new String[]{"Select Class / Lectures ", "First", "Second", "Third", "Forth", "Sixth", "Seventh", "Eighth", "Ninth", "Tenth", "Eleven", "Twelve"};

        Spinner s = findViewById(R.id.simpleSpinner);
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

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

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
