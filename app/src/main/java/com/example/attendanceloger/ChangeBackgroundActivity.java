package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ChangeBackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);
    }

    public void yellowBg(View view) {
        Toast.makeText(this, "Background update Successfully...", Toast.LENGTH_SHORT).show();

    }

    public void greenBg(View view) {
        Toast.makeText(this, "Background update Successfully...", Toast.LENGTH_SHORT).show();

    }

    public void blueBg(View view) {
        Toast.makeText(this, "Background update Successfully...", Toast.LENGTH_SHORT).show();

    }
}
