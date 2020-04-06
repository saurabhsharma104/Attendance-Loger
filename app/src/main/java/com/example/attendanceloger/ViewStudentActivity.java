package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
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
            String result = "";

            while (cursor.moveToNext())
            {
                String rollno = Integer.toString(cursor.getInt(cursor.getColumnIndex(StudentInfo.ROLLNO)));
                String name =   cursor.getString(cursor.getColumnIndex(StudentInfo.NAME));
                String fname =   cursor.getString(cursor.getColumnIndex(StudentInfo.FNAME));
                String mob =   cursor.getString(cursor.getColumnIndex(StudentInfo.MOBNO));
                String address =   cursor.getString(cursor.getColumnIndex(StudentInfo.ADDRESS));

                result += "\n RollNo                 :    " + rollno + "\n Student's Name :  " + name + "\n Father's Name    :  " + fname +
                        "\n Mobile No           :  "+mob+"\n Address              :  "+address+"\n\n";

            }

            textView.setText(result);
            Toast.makeText(this,"if you want to delete a student then click on it.", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Not view......... ", Toast.LENGTH_SHORT).show();
        }

    }

    public void clickForDelete(View view) {


        Intent intent = new Intent(this,DeleteSudentActivity.class);
        startActivity(intent);

    }
}
