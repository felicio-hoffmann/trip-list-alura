package com.example.viagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.viagens.R;
import com.example.viagens.model.Trip;
import com.example.viagens.util.DateFormatter;
import com.example.viagens.util.PriceFormater;
import com.example.viagens.util.Resource;
import com.example.viagens.util.Text;

import java.math.BigDecimal;

public class TripSummaryActivity extends AppCompatActivity {

    private final DateFormatter dateFormatter = new DateFormatter();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_summary);
        setTitle(getString(R.string.summary_activity_title));
        Trip trip = new Trip("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        showLocal(trip);
        showImage(trip);
        showDays(trip);
        showPrice(trip);
        showDate(trip);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDate(Trip trip) {
        TextView date = findViewById(R.id.summary_text_date);
        String formattedDate = dateFormatter.dateToString(trip.getDays());
        date.setText(formattedDate);
    }


    private void showPrice(Trip trip) {
        TextView price = findViewById(R.id.summary_text_price);
        String s = PriceFormater.formatToBRL(trip.getPrice());
        price.setText(s);
    }

    private void showDays(Trip trip) {
        TextView days = findViewById(R.id.summary_text_days);
        String daysToText = Text.formatDaysToText(trip.getDays());
        days.setText(daysToText);
    }

    private void showImage(Trip trip) {
        ImageView image = findViewById(R.id.summary_image_local);
        Drawable drawableByText = Resource.getDrawableByText(this, trip.getImage());
        image.setImageDrawable(drawableByText);
    }

    private void showLocal(Trip tripSP) {
        TextView local = findViewById(R.id.summary_text_city);
        local.setText(tripSP.getLocal());
    }
}