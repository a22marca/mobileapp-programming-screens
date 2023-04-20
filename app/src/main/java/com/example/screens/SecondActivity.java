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

        // get textViews from ViewFlipper
        flipper = findViewById(R.id.flipper);
        TextView[] views = new TextView[flipper.getChildCount()];
        for (int i = 0; i < flipper.getChildCount(); i++) {
            views[i] = (TextView) flipper.getChildAt(i);
        }

        // Select emojis based on the selected category
        Resources resources = getResources();
        String[] emojis = new String[3];
        if (selectedCategory.equals("Cats")) {
            emojis = resources.getStringArray(R.array.cats);
        } else if (selectedCategory.equals("Dogs")) {
            emojis = resources.getStringArray(R.array.dogs);
        } else if (selectedCategory.equals("Party")) {
            emojis = resources.getStringArray(R.array.party);
        }

        // setText for the TextViews in the ViewFlipper
        for (int i = 0; i < views.length; i++){
            views[i].setText(emojis[i]);
        }

        // Flipping speed
        flipper.setFlipInterval(1000);

        // Method to start flipping the View Flipper
        flipper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                flipper.startFlipping();
            }
        });
    }
}