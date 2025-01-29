package com.example.tp1_mobile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class imagePageActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageButton callButton;

    private String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ok);

        // Initialize views
        imageView = findViewById(R.id.imageView);

        imageView.setImageResource(R.drawable.cat);

        //call button
        callButton = findViewById(R.id.callButton);
        callButton.setImageResource(R.drawable.phone_icon);

        Bundle extras = getIntent().getExtras();
        callButton.setOnClickListener(v -> {
            if(extras == null) return;
            //make sure we have the phone number
            phoneNumber = Objects.requireNonNull(extras).getString("PhoneNumber");
            Log.d("phone number", phoneNumber);
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));

        });


    }
}
