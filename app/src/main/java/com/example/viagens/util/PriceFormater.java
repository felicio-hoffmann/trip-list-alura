package com.example.viagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormater {
    public static String formatToBRL(BigDecimal price) {
        NumberFormat currencyFormat = DecimalFormat
                .getCurrencyInstance(new Locale("pt", "br"));
        return currencyFormat.format(price);
    }
}
