package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeletePeriodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_period);
    }

    public void deleteAPeriod(View view) {
        EditText editText = this.findViewById(R.id.editText10);
        String pno = editText.getText().toString();
        StudentInfo studentInfo = new StudentInfo(this);

        int p = Integer.valueOf(pno);

        boolean msg =studentInfo.deletePeriodInTable(p);
        if(msg)
            Toast.makeText(this, "Add Delete Successfully...", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Add Delete failed...", Toast.LENGTH_SHORT).show();



    }
}
