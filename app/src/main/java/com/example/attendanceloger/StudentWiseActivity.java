package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StudentWiseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_wise);

        TextView textView1 = this.findViewById(R.id.textView8);
        TextView textView2 = this.findViewById(R.id.textView9);
        TextView textView3 = this.findViewById(R.id.textView10);
        TextView textView4 = this.findViewById(R.id.textView6);
        TextView textView5 = this.findViewById(R.id.textView24);
        ViewAttendanceActivity viewAttendanceActivity = new ViewAttendanceActivity();

        String roll = viewAttendanceActivity.getRoll();
        String date = viewAttendanceActivity.getDate();
        if(date.isEmpty())
        {
            date = viewAttendanceActivity.getDate2();
        }


        StudentInfo studentInfo = new StudentInfo(this);
        Cursor cursor = studentInfo.showStudentWise(roll,date);


        while (cursor.moveToNext())
        {
            String rollno = Integer.toString(cursor.getInt(cursor.getColumnIndex("roll")));
            String curDate =   cursor.getString(cursor.getColumnIndex("cur_date"));
            String re =   cursor.getString(cursor.getColumnIndex("record"));

            textView4.setText(rollno);
            textView3.setText(curDate);
            textView5.setText(re);

        }
        cursor = studentInfo.readOneStudent(roll);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(StudentInfo.NAME));
            String fname = cursor.getString(cursor.getColumnIndex(StudentInfo.FNAME));
            textView1.setText(name);
            textView2.setText(fname);
        }


        Toast.makeText(this, "View Attendance Successfully...", Toast.LENGTH_SHORT).show();





    }

}
