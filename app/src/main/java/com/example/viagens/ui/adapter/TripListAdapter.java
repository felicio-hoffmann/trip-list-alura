package com.example.viagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viagens.R;
import com.example.viagens.model.Trip;

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
        View createdView = LayoutInflater.from(context).inflate(R.layout.trip_item, viewGroup, false);
        Trip trip = trips.get(i);

        TextView local = createdView.findViewById(R.id.trip_item_local);
        local.setText(trip.getLocal());

        ImageView image = createdView.findViewById(R.id.trip_item_image);
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(trip.getImage(), "drawable", context.getPackageName());
        Drawable tripImage = resources.getDrawable(drawableId);
        image.setImageDrawable(tripImage);

        TextView days = createdView.findViewById(R.id.trip_item_days);
        days.setText(trip.getDays() + "dias");

        TextView price = createdView.findViewById(R.id.trip_item_price);
        price.setText(trip.getPrice().toString());
        return createdView;
    }
}
