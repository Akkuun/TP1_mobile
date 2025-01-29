package com.example.tp1_mobile;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Objects;

public class imagePageActivity extends AppCompatActivity {
    private static final int REQUEST_CALL_PHONE = 1;
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
        //get Intent data (phone number)
        Bundle extras = getIntent().getExtras();
        callButton.setOnClickListener(v -> {
            //if we get null data, return
            if(extras == null) return;
            //make sure we have the phone number
            phoneNumber = Objects.requireNonNull(Objects.requireNonNull(extras).getString("PhoneNumber")).replace("Téléphone : ", "");
            //we make sure we have the permission to call, if not we ask for it
            if (ContextCompat.checkSelfPermission(imagePageActivity.this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(imagePageActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
            }
        });


    }
}
