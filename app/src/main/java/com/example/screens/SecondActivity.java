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
        flipper = findViewById(R.id.flipper);

        // handle bundled data
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            selectedCategory = extras.getString("category");
        }

        TextView header = findViewById(R.id.headerText);
        header.setText(selectedCategory);


        // Select emojis based on the selected category
        Resources resources = getResources();
        String[] emojis = new String[flipper.getChildCount()];
        if (selectedCategory.equals("Cats")) {
            emojis = resources.getStringArray(R.array.cats);
        } else if (selectedCategory.equals("Dogs")) {
            emojis = resources.getStringArray(R.array.dogs);
        } else if (selectedCategory.equals("Party")) {
            emojis = resources.getStringArray(R.array.party);
        }

        // get textViews from ViewFlipper and set emojis
        TextView[] views = new TextView[flipper.getChildCount()];
        for (int i = 0; i < flipper.getChildCount(); i++) {
            views[i] = (TextView) flipper.getChildAt(i);
            views[i].setText(emojis[i]);
        }

        // Flipping speed
        flipper.setFlipInterval(1000);

        // start flipping
        flipper.startFlipping();


    }
}