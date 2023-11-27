package com.example.contact_saver_app_emmanuel_lishiba_chiboboka;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class listofusers extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<String> id, profile, name, dob, email;
    databaseAssitant dbAssist;
    userAdapter uAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userviews);
       dbAssist = new databaseAssitant(this);

        id =new ArrayList<>();
        profile =new ArrayList<>();
        name =new ArrayList<>();
        dob =new ArrayList<>();
        email =new ArrayList<>();
        rv = findViewById(R.id.rvId);
        uAdapter = new userAdapter(this, id, profile,name,dob, email);
        rv.setAdapter(uAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        displayData();
    }

    private void displayData() {
        Cursor cursor = dbAssist.readData();
        if(cursor.getCount() == 0) {
            Toast.makeText(listofusers.this, "No entries exist",Toast.LENGTH_SHORT).show();
            return ;
        }
        while (cursor.moveToNext()) {

            id.add(cursor.getString(0));
            profile.add(cursor.getString(1));
            name.add(cursor.getString(2));
            dob.add(cursor.getString(3));
            email.add(cursor.getString(4));
        }
    }
}
