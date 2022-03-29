package com.example.viagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.viagens.R;
import com.example.viagens.model.Trip;
import com.example.viagens.util.PriceFormater;

import java.math.BigDecimal;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setTitle(getString(R.string.payment_activity_title));

        Trip tripSP = new Trip("São Paulo", "são_paulo_sp", 2, new BigDecimal(243.99));

        showPrice(tripSP);
    }

    private void showPrice(Trip tripSP) {
        TextView price = findViewById(R.id.payment_price);
        String priceText = PriceFormater.formatToBRL(tripSP.getPrice());
        price.setText(priceText);
    }
}