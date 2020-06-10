package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MultiStudentAttendance extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_student_attendance);

        TextView textView1 = this.findViewById(R.id.textView30);
        TextView textView2 = this.findViewById(R.id.textView31);
        TextView textView3 = findViewById(R.id.multi_display);
        TextView textView4 = findViewById(R.id.textView33);

        String result;

        int flag =0;
        int count=0;
        result="";

        ViewAttendanceActivity viewAttendanceActivity = new ViewAttendanceActivity();

        String roll = viewAttendanceActivity.getRoll();
        String start_date = viewAttendanceActivity.getDate();
        String end_date = viewAttendanceActivity.getDate2();
        textView1.setText("ROLL NO :      "+"          "+roll);

        StudentInfo studentInfo = new StudentInfo(this);
        Cursor cursor = studentInfo.multiAttendance(roll);

        while (cursor.moveToNext()) {
            String rollno = Integer.toString(cursor.getInt(cursor.getColumnIndex("roll")));
            String curDate = cursor.getString(cursor.getColumnIndex("cur_date"));
            String re = cursor.getString(cursor.getColumnIndex("record"));

            textView1.setText("ROLL NO :  " + rollno);

            if((flag==1)||(curDate.equals(start_date)))
            {
                flag=1;
                result += "\n"+curDate+"\t\t        \t                         "+re+"\n\n";
                if(re.equalsIgnoreCase("Present")) {
                    count += 1;
                }
            }

            if(curDate.equals(end_date))
            {
                break;
            }
        }
        cursor = studentInfo.readOneStudent(roll);
        if (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(StudentInfo.NAME));
            String fname = cursor.getString(cursor.getColumnIndex(StudentInfo.FNAME));
            String r ="Father's Nmae        :  "+fname+" \n\n        DATE               \t                 RECORD     ";
            textView2.setText("Name   : "+name);
            textView4.setText(r);
        }

        if(flag==1) {
            result+="\n\nTotal Present Days  :  "  +count+"\n\n";
            textView3.setText(result);
            Toast.makeText(this, "View Multiple Attendance Successfully...", Toast.LENGTH_SHORT).show();
        }



    }
}
