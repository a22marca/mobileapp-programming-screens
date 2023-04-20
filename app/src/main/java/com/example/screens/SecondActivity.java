package com.example.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class SecondActivity extends AppCompatActivity {

    private ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String selectedCategory = "";

        // handle bundled data
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedCategory = extras.getString("category");
        }

        flipper.setFlipInterval(1000);
        flipper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                flipper.startFlipping();
            }
        });
    }
}