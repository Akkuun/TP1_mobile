package com.example.tp1_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private TextView detailName;
    private TextView detailFirstName;
    private TextView detailAge;
    private TextView detailSkill;
    private TextView detailPhone;

    private Button goBack;
    private Button call;



    private boolean FrenchSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        // Initialize views
        detailName = findViewById(R.id.detailName);
        detailFirstName = findViewById(R.id.detailFirstName);
        detailAge = findViewById(R.id.detailAge);
        detailSkill = findViewById(R.id.detailSkill);
        detailPhone = findViewById(R.id.detailPhone);

        //button
        goBack = findViewById(R.id.goBack);
        call = findViewById(R.id.call);

        // Get data from intent
        Bundle extras = getIntent().getExtras();
        //if the data is not null, set the text of the textview
        if (extras != null) {
            FrenchSelected =  extras.getBoolean("FrenchSelected", true);

            //log
            System.out.println("FrenchSelected: " + FrenchSelected);

            if(FrenchSelected){
                detailName.setText("Nom : " + extras.getString("name"));
                detailFirstName.setText("Prénom : " + extras.getString("firstName"));
                detailAge.setText("Age : " + extras.getString("age"));
                detailSkill.setText("Compétence : " + extras.getString("skill"));
                detailPhone.setText("Téléphone : " + extras.getString("phone"));
                call.setText("Appeler");
                goBack.setText("Retour");
            }else{
                detailName.setText("Name : " + extras.getString("name"));
                detailFirstName.setText("First Name : " + extras.getString("firstName"));
                detailAge.setText("Age : " + extras.getString("age"));
                detailSkill.setText("Skill : " + extras.getString("skill"));
                detailPhone.setText("Phone : " + extras.getString("phone"));
                goBack.setText("Go back");
                call.setText("Call");

            }

        }

        //button for go back
        findViewById(R.id.goBack).setOnClickListener(v -> finish());

        //button for open an another activity
        call.setOnClickListener(v -> {
            Intent intent = new Intent(DetailsActivity.this, imagePageActivity.class);
            intent.putExtra("PhoneNumber", detailPhone.getText().toString());
            startActivity(intent);
        });

    }
}