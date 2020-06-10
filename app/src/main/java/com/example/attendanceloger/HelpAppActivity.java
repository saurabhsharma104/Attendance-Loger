package com.example.attendanceloger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class HelpAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_app);

        PDFView pdfView = findViewById(R.id.help_display);
        pdfView.fromAsset("help.pdf").load();
    }
}
