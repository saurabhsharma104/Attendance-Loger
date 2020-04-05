package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteSudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_sudent);
    }

    public void deleteStudent(View view) {
        EditText editText = findViewById(R.id.editText11);
        String  roll = editText.getText().toString();

        int r = Integer.valueOf(roll);
        StudentInfo studentInfo = new StudentInfo(this);
        boolean msg=studentInfo.deleteStudentInTable(r);
        if(msg)
            Toast.makeText(this, "Add Delete Successfully...", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Add Delete failed...", Toast.LENGTH_SHORT).show();




    }
}
