package com.example.tp1_mobile;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class imagePageActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ok);

        // Initialize views
        imageView = findViewById(R.id.imageView);

        imageView.setImageResource(R.drawable.cat);
    }
}
