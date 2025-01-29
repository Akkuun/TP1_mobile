package com.example.tp1_mobile;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class trainExemple extends AppCompatActivity {


    private TextView depart;
    private TextView destination;

    private Button rechercher;

    private ListView resultats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_exemple);

        // Initialize views
        depart = findViewById(R.id.depart);
        destination = findViewById(R.id.destination);
        // Initialize button
        rechercher = findViewById(R.id.search);

        //hint for textView
        depart.setHint("Depart");
        destination.setHint("Destination");
        //Initialize listview
        resultats = findViewById(R.id.listView);



        // Search feature
        rechercher.setOnClickListener(v -> {
            //if the fields are empty, return
            if(depart.getText().toString().isEmpty() || destination.getText().toString().isEmpty()) return;
            //fake Data
            String[] TitleFakeData = {" Train 1 ", " Train 2 ", " Train 3 ", " Train 4 "};
            String[] SubtitleFakeData = {" Depart : 11:00 , Arrivee : 13:45 ", " Depart : 11:30 , Arrivee : 14:15 ", " Depart : 12:00 , Arrivee : 14:45 ", " Depart : 12:30 , Arrivee : 15:15 "};
            // Create an ArrayAdapter from List to loop through the data
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, TitleFakeData) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text1 = view.findViewById(android.R.id.text1);
                    TextView text2 = view.findViewById(android.R.id.text2);
                    text1.setText(TitleFakeData[position]);
                    text2.setText(SubtitleFakeData[position]);
                    return view;
                }
            };
            // Set the layout for the data
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_2);
            // Set the adapter to the listview to display the data
            resultats.setAdapter(adapter);
        });


    }

    // Search feature

}
