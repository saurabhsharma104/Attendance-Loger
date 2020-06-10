package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ClassWiseActivity extends AppCompatActivity {

    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_wise);

        Intent intent = getIntent();
        String a = intent.getStringExtra("Enter_Date");

        TextView textView = this.findViewById(R.id.classattendancedisplay);

        StudentInfo studentInfo = new StudentInfo(this);
        Cursor cursor = studentInfo.showClassWise(a);

        String result = "";

        while (cursor.moveToNext())
        {
            flag = 1;
            String rollno = Integer.toString(cursor.getInt(cursor.getColumnIndex("roll")));
            String curDate =   cursor.getString(cursor.getColumnIndex("cur_date"));
            String re =   cursor.getString(cursor.getColumnIndex("record"));

            result = result + "\n Roll No  :   "+rollno+"\n Date   :  "+curDate+"\n Attendance  :   "+re+"\n\n\n";

        }
        if(flag==1) {

            textView.setText(result);
            Toast.makeText(this, "View Attendance Successfully...", Toast.LENGTH_SHORT).show();
        }


    }
}
