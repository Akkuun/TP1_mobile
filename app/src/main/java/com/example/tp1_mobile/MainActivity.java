package com.example.tp1_mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

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

    //switch to change the language
    private Switch switchLanguage;

    //label
    private TextView nameLabel;
    private TextView firstNameLabel;
    private TextView ageLabel;
    private TextView skillLabel;
    private TextView phoneLabel;
    private TextView validateLabel;



    private boolean FrenchSelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views -> get all id
        nameEditText = findViewById(R.id.name);
        firstNameEditText = findViewById(R.id.firstName);
        ageEditText = findViewById(R.id.age);
        skillEditText = findViewById(R.id.skill);
        phoneEditText = findViewById(R.id.phone);
        validateButton = findViewById(R.id.button);

        //init label -> get all id
        // Initialize labels
        nameLabel = findViewById(R.id.NameLabelID);
        firstNameLabel = findViewById(R.id.FirstNameID);
        ageLabel = findViewById(R.id.AgeLabelID);
        skillLabel = findViewById(R.id.SkillLabelID);
        phoneLabel = findViewById(R.id.PhoneLabelID);



        //switch to change the language, we add a listener to change the text of the fields and the button
        switchLanguage = findViewById(R.id.switchLangage);
        switchLanguage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            FrenchSelected = !isChecked;
            //french is selected
            if (FrenchSelected) {
                //text fileds and button
                nameEditText.setHint(getString(R.string.nom));
                firstNameEditText.setHint(getString(R.string.prenom));
                ageEditText.setHint(getString(R.string.age));
                skillEditText.setHint(getString(R.string.competence));
                phoneEditText.setHint(getString(R.string.telephone));
                validateButton.setText(getString(R.string.valider));
                //labels
                nameLabel.setText(getString(R.string.nomLabel));
                firstNameLabel.setText(getString(R.string.prenomLabel));
                ageLabel.setText(getString(R.string.ageLabel));
                skillLabel.setText(getString(R.string.competenceLabel));
                phoneLabel.setText(getString(R.string.telephoneLabel));
                validateButton.setText(getString(R.string.valider));
            } else {
                //it's english
                //text fileds and button
                nameEditText.setHint(getString(R.string.name_en));
                firstNameEditText.setHint(getString(R.string.firstName_en));
                ageEditText.setHint(getString(R.string.age_en));
                skillEditText.setHint(getString(R.string.skill_en));
                phoneEditText.setHint(getString(R.string.phone_en));
                validateButton.setHint(getString(R.string.validate_en));
                //labels
                nameLabel.setText(getString(R.string.nameLabel_en));
                firstNameLabel.setText(getString(R.string.firstNameLabel_en));
                ageLabel.setText(getString(R.string.ageLabel_en));
                skillLabel.setText(getString(R.string.skillLabel_en));
                phoneLabel.setText(getString(R.string.phoneLabel_en));
                validateButton.setText(getString(R.string.validate_en));

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}