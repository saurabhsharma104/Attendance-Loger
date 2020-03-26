package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TimeTable2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table2);
    }

    public void addTimeTable12(View view) {

        EditText pno1 = findViewById(R.id.editText3);
        EditText descrip1 =findViewById(R.id.editText6);

        String m = pno1.getText().toString();
        String a = descrip1.getText().toString();

        int po = Integer.parseInt(m);
        if((m == "")||(a == "")) {
            Toast.makeText(this, "Please fill all field...", Toast.LENGTH_SHORT).show();
            return;
        }
        StudentInfo studentInfo = new StudentInfo(this);
        SQLiteDatabase database = studentInfo.getWritableDatabase();

        boolean bo =studentInfo.addTimeTable(po,a,database);
        if(bo)
            Toast.makeText(this, "Add Student Successfully...", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Add Student failed...", Toast.LENGTH_SHORT).show();

        pno1.setText("");
        descrip1.setText("");

        database.close();
    }
}
