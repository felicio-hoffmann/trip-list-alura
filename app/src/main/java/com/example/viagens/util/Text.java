package com.example.viagens.util;

import androidx.annotation.NonNull;

public class Text {
    @NonNull
    public static String formatDaysToText(int days) {
        if (days > 1)
            return days + " dias";
        return days + " dia";
    }
}
