package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ViewAttendanceActivity extends AppCompatActivity {

    public static String roll,start_date,end_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);


    }

    public void viewAStudent(View view) {

        EditText editText = this.findViewById(R.id.editText7);
        roll = editText.getText().toString();

        EditText editText1 = this.findViewById(R.id.editText9);
        start_date = editText1.getText().toString();

        EditText editText2 = this.findViewById(R.id.editText13);
        end_date = editText2.getText().toString();

        if ((start_date.equals(end_date))||(start_date.isEmpty())||(end_date.isEmpty()))
        {
            Intent intent = new Intent(this, StudentWiseActivity.class);
            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this,MultiStudentAttendance.class);
            startActivity(intent);
        }

    }

    public void viewClass(View view) {
        EditText editText = findViewById(R.id.enterdate);
        String date = editText.getText().toString();

        Intent intent = new Intent(this,ClassWiseActivity.class);
        intent.putExtra("Enter_Date",date);
        startActivity(intent);

    }

    public String getRoll()
    {

        return roll;
    }

    public String getDate()
    {

        return start_date;
    }

    public String getDate2()
    {

        return end_date;
    }

}
