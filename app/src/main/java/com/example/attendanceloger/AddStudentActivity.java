package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

import static android.app.PendingIntent.getActivity;

public class AddStudentActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
    }



    public void addAStudent(View view) {

        EditText roll = (EditText)findViewById(R.id.editText5);
        EditText sname =findViewById(R.id.editText);
        EditText fname =findViewById(R.id.editText2);
        EditText mobno =findViewById(R.id.editText4);
        EditText address=findViewById(R.id.editText8);

        String r = roll.getText().toString();
        String n = sname.getText().toString();
        String f = fname.getText().toString();
        String m = mobno.getText().toString();
        String a = address.getText().toString();

        int ro = Integer.parseInt(r);

       if((n=="")||(f==null)||(m==null)||(a==null)||(r==null)) {
            Toast.makeText(this, "Please fill all field...", Toast.LENGTH_SHORT).show();
            return;
        }
       StudentInfo studentInfo = new StudentInfo(this);
       SQLiteDatabase database = studentInfo.getWritableDatabase();
       boolean bo =studentInfo.addStudentInTable(ro,n,f,m,a,database);
       if(bo==true)
           Toast.makeText(this, "Add Student Successfully...", Toast.LENGTH_SHORT).show();
       else
           Toast.makeText(this, "Add Student failed...", Toast.LENGTH_SHORT).show();
       roll.setText("");
       sname.setText("");
       fname.setText("");
       mobno.setText("");
       address.setText("");

       database.close();

    }

}
