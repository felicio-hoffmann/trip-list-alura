package com.example.viagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.viagens.R;
import com.example.viagens.model.Trip;
import com.example.viagens.util.DateFormatter;
import com.example.viagens.util.PriceFormater;
import com.example.viagens.util.Resource;

import java.io.Serializable;
import java.math.BigDecimal;

public class TransactionSummaryActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_summary);

        setTitle(getString(R.string.transaction_summary_title));

        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.trip_key))){
            Trip trip = (Trip) intent.getSerializableExtra(getString(R.string.trip_key));
            showLocal(trip);
            showImage(trip);
            showDate(trip);
            showPrice(trip);
        }

    }

    private void showPrice(Trip tripSP) {
        TextView price = findViewById(R.id.transaction_summary_price);
        String priceText = PriceFormater.formatToBRL(tripSP.getPrice());
        price.setText(priceText);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showDate(Trip tripSP) {
        TextView date = findViewById(R.id.transaction_summary_date);
        String dateText = DateFormatter.dateToString(tripSP.getDays());
        date.setText(dateText);
    }

    private void showImage(Trip tripSP) {
        ImageView image = findViewById(R.id.transaction_summary_image);
        Drawable drawableByText = Resource.getDrawableByText(this, tripSP.getImage());
        image.setImageDrawable(drawableByText);
    }

    private void showLocal(Trip tripSP) {
        TextView local = findViewById(R.id.transaction_summary_city);
        local.setText(tripSP.getLocal());
    }
}