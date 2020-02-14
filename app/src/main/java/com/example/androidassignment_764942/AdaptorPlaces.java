package com.example.androidassignment_764942;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class AdaptorPlaces extends ArrayAdapter {

    Context mcontext;
    int layoutRes;
    DatabaseFile mDatabase;
    List<PlaceClasses> listPlace;


    public AdaptorPlaces(@NonNull Context mcontext, int layoutRes, List<PlaceClasses> listPlace, DatabaseFile mDatabase) {
        super(mcontext, layoutRes,listPlace);
        this.mcontext = mcontext;
        this.layoutRes = layoutRes;
        this.listPlace = listPlace;
        this.mDatabase = mDatabase;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(layoutRes,null);
        TextView tvname = view.findViewById(R.id.tv_name);
        TextView tvaddress = view.findViewById(R.id.tv_address);
        TextView tvlongitude = view.findViewById(R.id.tv_longitude);
        TextView tvlatitude = view.findViewById(R.id.tv_latitude);
        TextView tvdate = view.findViewById(R.id.tv_date);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String addDate = simpleDateFormat.format(calendar.getTime());


        final PlaceClasses list = listPlace.get(position);
        tvname.setText(list.getDate());
        tvaddress.setText(list.getAddress());
        //tvlatitude.setText(list.getLatitude());
        //tvlongitude.setText(list.getLongitude());
        tvdate.setText(addDate);



        return view;

    }




}
