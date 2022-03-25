package com.example.viagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class Resource {

    public static Drawable getDrawableByText(Context context, String drawableName) {
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(drawableName, "drawable", context.getPackageName());
        Drawable tripImage = resources.getDrawable(drawableId);
        return tripImage;
    }
}
