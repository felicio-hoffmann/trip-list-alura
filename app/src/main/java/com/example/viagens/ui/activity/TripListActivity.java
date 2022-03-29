package com.example.viagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.viagens.R;
import com.example.viagens.dao.TripDAO;
import com.example.viagens.model.Trip;
import com.example.viagens.ui.adapter.TripListAdapter;

import java.util.List;

public class TripListActivity extends AppCompatActivity {
    public static final String APP_TITLE = "Pacotes";
    List<Trip> trips = new TripDAO().list();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(APP_TITLE);
        configureList();
        List<Trip> list = TripDAO.list();
        ListView tripList = findViewById(R.id.trip_list);

        goToSummary(list, tripList);
    }

    private void goToSummary(List<Trip> list, ListView tripList) {
        tripList.setOnItemClickListener((adapterView, view, i, l) -> {
            Trip trip = list.get(i);
            Intent intent = new Intent(TripListActivity.this, TripSummaryActivity.class);
            intent.putExtra(getString(R.string.trip_key), trip);
            startActivity(intent);
        });
    }

    private void configureList() {
        setContentView(R.layout.activity_trip_list);
        ListView tripList = findViewById(R.id.trip_list);
        tripList.setAdapter(new TripListAdapter(trips, this));
    }
}