package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TimeTableActivity extends AppCompatActivity {
    Cursor cursor;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        try
        {
            textView = findViewById(R.id.textView17);
            StudentInfo studentInfo = new StudentInfo(this);
            cursor = studentInfo.showTimeTable();

            String result = "";
            while (cursor.moveToNext())
            {
                String pno1 = Integer.toString(cursor.getInt(cursor.getColumnIndex(StudentInfo.PNO)));
                String desc1 =   cursor.getString(cursor.getColumnIndex(StudentInfo.DECE));

                result = result+"Period No    :   "+pno1+"\nDescription   :   "+desc1+"\n\n\n";
            }

            textView.setText(result);
            Toast.makeText(this, "if you want to delete a period then click on it.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Not view......... ", Toast.LENGTH_SHORT).show();
        }


    }

    public void addTimeTables(View view) {

        Intent intent = new Intent(this,TimeTable2.class);
        startActivity(intent);
    }

    public void viewTimeTable(View view)
    {
        try
        {
        textView = findViewById(R.id.textView17);
        StudentInfo studentInfo = new StudentInfo(this);
        cursor = studentInfo.showTimeTable();

        String result = "";
        while (cursor.moveToNext())
        {
            String pno1 = Integer.toString(cursor.getInt(cursor.getColumnIndex(StudentInfo.PNO)));
            String desc1 =   cursor.getString(cursor.getColumnIndex(StudentInfo.DECE));

            result = result+"Period No    :   "+pno1+"\nDescription   :   "+desc1+"\n\n\n";
        }

        textView.setText(result);
        Toast.makeText(this, "if you want to delete a period then click on it.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Not view......... ", Toast.LENGTH_SHORT).show();
        }

    }

    public void deletePeriod(View view) {
        Intent intent = new Intent(this,DeletePeriodActivity.class);
        startActivity(intent);

    }
}
