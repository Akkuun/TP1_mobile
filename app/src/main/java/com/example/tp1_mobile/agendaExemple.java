package com.example.tp1_mobile;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class agendaExemple extends AppCompatActivity {

    private ListView listView;
    private Button addEventButton;
    private CalendarView calendarView;
    private EditText eventTitle;
    private List<String> events;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agenda_exemple);

        // Initialize views
        listView = findViewById(R.id.listView2);
        addEventButton = findViewById(R.id.addEvent);
        calendarView = findViewById(R.id.calendarView);
        calendarView.setDate(System.currentTimeMillis(), false, true);
        eventTitle = findViewById(R.id.eventUserInput);
        eventTitle.setHint("Entrez l'intitulé de l'événement");

        // Initialize event list and adapter
        events = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1, events) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = view.findViewById(android.R.id.text1);
                TextView text2 = view.findViewById(android.R.id.text2);
                String[] eventDetails = events.get(position).split(" - ");
                text1.setText(eventDetails[0]);
                text2.setText(eventDetails[1]);
                return view;
            }
        };
        listView.setAdapter(adapter);

        // Add event button click listener
        addEventButton.setOnClickListener(view -> {
            String event = eventTitle.getText().toString();
            if (!event.isEmpty()) {
                long selectedDate = calendarView.getDate();
                String formattedDate = convertDate(selectedDate);
                events.add(event + " - Date: " + formattedDate);
                adapter.notifyDataSetChanged();
                eventTitle.setText("");
            }
        });

    }

    public String convertDate(long timestamp) {
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }



}