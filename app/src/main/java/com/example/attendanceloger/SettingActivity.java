package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public void helpApp(View view) {
        Intent intent = new Intent(this,HelpAppActivity.class);
        startActivity(intent);

    }

    public void aboutUs(View view) {
        Intent intent = new Intent(this,AboutUsActivity.class);
        startActivity(intent);
    }


    public void develop(View view) {
        Intent intent = new Intent(this,DeveloperActivity.class);
        startActivity(intent);
    }
}
