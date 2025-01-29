package com.example.tp1_mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText firstNameEditText;
    private EditText ageEditText;
    private EditText skillEditText;
    private EditText phoneEditText;
    private Button validateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameEditText = findViewById(R.id.name);
        nameEditText.setText(getString(R.string.nom));

        firstNameEditText = findViewById(R.id.firstName);
        firstNameEditText.setText(getString(R.string.prenom));

        ageEditText = findViewById(R.id.age);
        ageEditText.setText(getString(R.string.age));

        skillEditText = findViewById(R.id.skill);
        skillEditText.setText(getString(R.string.competence));

        phoneEditText = findViewById(R.id.phone);
        phoneEditText.setText(getString(R.string.telephone));
        validateButton = findViewById(R.id.button);
        validateButton.setText(getString(R.string.valider));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}