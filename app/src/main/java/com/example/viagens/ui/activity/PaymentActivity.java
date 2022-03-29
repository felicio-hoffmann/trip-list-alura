package com.example.viagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        goToTransactionSummary();


    }

    private void goToTransactionSummary() {
        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.trip_key))){
            Trip trip = (Trip) intent.getSerializableExtra(getString(R.string.trip_key));
            showPrice(trip);
            Button confirmPaymentButton = findViewById(R.id.payment_confirm_button);
            confirmPaymentButton.setOnClickListener(view -> {
                Intent goToTransactionSummary = new Intent(PaymentActivity.this,
                        TransactionSummaryActivity.class);
                goToTransactionSummary.putExtra(getString(R.string.trip_key), trip);
                startActivity(goToTransactionSummary);
            });
        }
    }

    private void showPrice(Trip tripSP) {
        TextView price = findViewById(R.id.payment_price);
        String priceText = PriceFormater.formatToBRL(tripSP.getPrice());
        price.setText(priceText);
    }
}