package com.example.androidassignment_764942;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class listfvrtplacesActivity extends AppCompatActivity {

   DatabaseFile mDatabase;
    List<PlaceClasses> listPlace;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listfvrtplaces);
        listView = findViewById(R.id.favrt_places);
        listPlace = new ArrayList<>();
        mDatabase = new DatabaseFile(this);
        loadPlaces();


        AdaptorPlaces placesAdaptor = new AdaptorPlaces(this,R.layout.listview_fvrtplaces,listPlace,mDatabase);
        listView.setAdapter(placesAdaptor);

    }



    private void loadPlaces(){

        Cursor cursor = mDatabase.getAllPlaces();
        if(cursor.moveToFirst()){

            do{


                listPlace.add(new PlaceClasses(cursor.getString(0),cursor.getString(1),
                        cursor.getString(2),
                        cursor.getDouble(3),cursor.getDouble(4)
                ));

            }while (cursor.moveToNext());

            cursor.close();
        }



    }

}
