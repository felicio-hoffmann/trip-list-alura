package com.example.viagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.viagens.R;
import com.example.viagens.dao.TripDAO;
import com.example.viagens.model.Trip;
import com.example.viagens.ui.adapter.TripListAdapter;

import java.util.List;

public class TripListActivity extends AppCompatActivity {
    List<Trip> trips = new TripDAO().list();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_list);
        ListView tripList = findViewById(R.id.trip_list);
        tripList.setAdapter(new TripListAdapter(trips, this));
    }
}