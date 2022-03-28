package com.example.viagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viagens.R;
import com.example.viagens.model.Trip;
import com.example.viagens.util.PriceFormater;
import com.example.viagens.util.Resource;
import com.example.viagens.util.Text;

import java.math.BigDecimal;

public class TripSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_summary);
        Trip tripSP = new Trip("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        TextView local = findViewById(R.id.summary_text_city);
        local.setText(tripSP.getLocal());

        ImageView image = findViewById(R.id.summary_image_local);
        Drawable drawableByText = Resource.getDrawableByText(this, tripSP.getImage());
        image.setImageDrawable(drawableByText);

        TextView days = findViewById(R.id.summary_text_days);
        String daysToText = Text.formatDaysToText(tripSP.getDays());
        days.setText(daysToText);

        TextView price = findViewById(R.id.summary_text_price);
        String s = PriceFormater.formatToBRL(tripSP.getPrice());
        price.setText(s);
    }
}