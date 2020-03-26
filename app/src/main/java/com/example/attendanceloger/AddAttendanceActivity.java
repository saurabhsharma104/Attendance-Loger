package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAttendanceActivity extends AppCompatActivity {

    String currentDate;
    int roll;
    Cursor cursor;

    TextView textView9 = findViewById(R.id.textView9);
    TextView textView11 = findViewById(R.id.textView11);
    TextView textView13 = findViewById(R.id.textView13);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_attendance);

        TextView textView = findViewById(R.id.textView14);
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("dd.MM.yyyy");
        currentDate = sdf.format(new Date());
        textView.setText(currentDate);
        StudentInfo studentInfo = new StudentInfo(this);
        try {
            cursor = studentInfo.readStudent();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Not view......... ", Toast.LENGTH_SHORT).show();
        }
        try{
            if(cursor.moveToNext()) {
                String rollno = Integer.toString(cursor.getInt(cursor.getColumnIndex(StudentInfo.ROLLNO)));
                String name = cursor.getString(cursor.getColumnIndex(StudentInfo.NAME));
                String fname = cursor.getString(cursor.getColumnIndex(StudentInfo.FNAME));
                textView9.setText(name);
                textView11.setText(fname);
                textView13.setText(rollno);
            }
         }
         catch (NullPointerException e)
         {
            Toast.makeText(this, "Not view......... ", Toast.LENGTH_SHORT).show();
         }
    }

    public  void absent(View view)
    {
        absentPresent("A");
    }
    public void present(View view)
    {
        absentPresent("P");
    }


    public void absentPresent(String re)
    {

        StudentInfo studentInfo = new StudentInfo(this);
        SQLiteDatabase database = studentInfo.getWritableDatabase();
        String msg =studentInfo.addAttendance(roll,currentDate,re,database);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        if(cursor.moveToNext())
        {
            roll = cursor.getInt(cursor.getColumnIndex(StudentInfo.ROLLNO));
            String name =   cursor.getString(cursor.getColumnIndex(StudentInfo.NAME));
            String fname =   cursor.getString(cursor.getColumnIndex(StudentInfo.FNAME));
            textView9.setText(name);
            textView11.setText(fname);
            textView13.setText(roll);

            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Attendance taken successfully completed......", Toast.LENGTH_SHORT).show();

        }
        database.close();


    }
}
