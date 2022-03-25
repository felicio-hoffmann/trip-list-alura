package com.example.viagens.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormater {
    public static NumberFormat getCurrencyFormat() {
        NumberFormat currencyFormat = DecimalFormat
                .getCurrencyInstance(new Locale("pt", "br"));
        return currencyFormat;
    }
}
