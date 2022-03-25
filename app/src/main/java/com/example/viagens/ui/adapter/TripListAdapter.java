package com.example.viagens.ui.adapter;

import static com.example.viagens.util.PriceFormater.getCurrencyFormat;
import static com.example.viagens.util.Resource.getDrawableByText;
import static com.example.viagens.util.Text.formatDaysToText;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viagens.R;
import com.example.viagens.model.Trip;


import java.text.NumberFormat;
import java.util.List;

public class TripListAdapter extends BaseAdapter {
    private final List<Trip> trips;
    private final Context context;

    public TripListAdapter(List<Trip> trips, Context context) {
        this.trips = trips;
        this.context = context;
    }

    @Override
    public int getCount() {
        return trips.size();
    }

    @Override
    public Object getItem(int i) {
        return trips.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View createdView = LayoutInflater
                .from(context).inflate(R.layout.trip_item, viewGroup, false);
        Trip trip = trips.get(i);

        fillLocal(createdView, trip);
        fillImage(createdView, trip);
        fillDays(createdView, trip);
        fillPrice(createdView, trip);
        return createdView;
    }

    private void fillPrice(View createdView, Trip trip) {
        TextView price = createdView.findViewById(R.id.trip_item_price);
        NumberFormat currencyFormat = getCurrencyFormat();
        price.setText(currencyFormat.format(trip.getPrice()));
    }

    private void fillDays(View createdView, Trip trip) {
        TextView days = createdView.findViewById(R.id.trip_item_days);
        String dias = formatDaysToText(trip.getDays());
        days.setText(dias);
    }

    private void fillImage(View createdView, Trip trip) {
        ImageView image = createdView.findViewById(R.id.trip_item_image);
        Drawable tripImage = getDrawableByText(context, trip.getImage());
        image.setImageDrawable(tripImage);
    }

    private void fillLocal(View createdView, Trip trip) {
        TextView local = createdView.findViewById(R.id.trip_item_local);
        local.setText(trip.getLocal());
    }
}
