package com.example.viagens.util;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.viagens.model.Trip;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public DateFormatter() {
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    public String dateToString(int days) {
        LocalDate initialDate = LocalDate.now();
        LocalDate returnDate = LocalDate.now().plusDays(days);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM");
        String formattedDate = initialDate.format(dateTimeFormatter) + " - "
                + returnDate.format(dateTimeFormatter) + " de " + returnDate.getYear();
        return formattedDate;
    }
}