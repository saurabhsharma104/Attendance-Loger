package com.example.attendanceloger;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class AddAttendanceActivity extends AppCompatActivity {

    int roll;
    Cursor cursor;
    String currentDate;

    TextView textViewa;
    TextView textViewb;
    TextView textViewc;




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);

        textViewa = this.findViewById(R.id.textView8);
        textViewb = this.findViewById(R.id.textView9);
        textViewc = this.findViewById(R.id.textView6);
        int flag = 0;
        TextView textView = this.findViewById(R.id.textView10);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = sdf.format(new Date());
        textView.setText(currentDate);

        try {
            StudentInfo studentInfo = new StudentInfo(this);
            cursor = studentInfo.readStudent();

            if(cursor.moveToNext()) {

                String rollno = Integer.toString(cursor.getInt(cursor.getColumnIndex(StudentInfo.ROLLNO)));
                String name = cursor.getString(cursor.getColumnIndex(StudentInfo.NAME));
                String fname = cursor.getString(cursor.getColumnIndex(StudentInfo.FNAME));
                textViewa.setText(name);
                textViewb.setText(fname);
                textViewc.setText(rollno);
                roll = Integer.valueOf(rollno);
                flag=1;

            }
            else
            {
                Toast.makeText(this, "Please add Student.... ", Toast.LENGTH_SHORT).show();
            }

        }
        catch (Exception e)
        {
            Toast.makeText(this, "Not view......... ", Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public  void absent(View view)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = sdf.format(new Date());
        absentPresent("Absent",currentDate);

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void present(View view)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        currentDate = sdf.format(new Date());
        absentPresent("Present",currentDate);
    }


    public void absentPresent(String re,String cur) {
        try {

            StudentInfo studentInfo = new StudentInfo(this);
            SQLiteDatabase database = studentInfo.getWritableDatabase();
            boolean msg = studentInfo.addAttendance(roll,cur, re, database);
            if (!(msg))
                Toast.makeText(this, "Add Attendance failed...", Toast.LENGTH_SHORT).show();

            if (cursor.moveToNext()) {
                String rollno = Integer.toString(cursor.getInt(cursor.getColumnIndex(StudentInfo.ROLLNO)));
                String name = cursor.getString(cursor.getColumnIndex(StudentInfo.NAME));
                String fname = cursor.getString(cursor.getColumnIndex(StudentInfo.FNAME));
                textViewa.setText(name);
                textViewb.setText(fname);
                roll = Integer.valueOf(rollno);
                textViewc.setText(rollno);

               } else {
                Toast.makeText(this, "Attendance taken successfully completed......", Toast.LENGTH_SHORT).show();

            }
            database.close();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "One exception occur...", Toast.LENGTH_SHORT).show();
        }
    }

}



