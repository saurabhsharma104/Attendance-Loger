package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ViewStudentActivity extends AppCompatActivity {

    Cursor cursor;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);


       textView = findViewById(R.id.student_display);
        StudentInfo studentInfo = new StudentInfo(this);
        try {
            cursor = studentInfo.readStudent();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Not view......... ", Toast.LENGTH_SHORT).show();
        }
        String result = "";
        while (cursor.moveToNext())
        {
            String rollno = Integer.toString(cursor.getInt(cursor.getColumnIndex(StudentInfo.ROLLNO)));
            String name =   cursor.getString(cursor.getColumnIndex(StudentInfo.NAME));
            String fname =   cursor.getString(cursor.getColumnIndex(StudentInfo.FNAME));
            String mob =   cursor.getString(cursor.getColumnIndex(StudentInfo.MOBNO));
            String address =   cursor.getString(cursor.getColumnIndex(StudentInfo.ADDRESS));

            result = result+"Student RollNo  : "+rollno+"\nStudent's Name : "+name+"\nFather's Name   : "+fname+"\nMobile Number  : "+mob+"\nAddress\t            : "+address+"\n\n\n";
        }

        textView.setText(result);
        Toast.makeText(this, "View Student Successfully...", Toast.LENGTH_SHORT).show();

    }
}