package com.example.contact_saver_app_emmanuel_lishiba_chiboboka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class addUser_Activity extends AppCompatActivity {

    ImageView profileImage;
    EditText nameTxt, dobTxt, emailTxt;
    int profileImg = 0;
    int [] selectionImgs = {R.drawable.boy, R.drawable.profile, R.drawable.man, R.drawable.joker};
    ImageView profileSelection;
    databaseAssitant databaseAssist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        databaseAssist = new databaseAssitant(this);
        setIds();
    }

    public void setIds () {
        profileImage = findViewById(R.id.profileImg);
        nameTxt = findViewById(R.id.nametxtId);
        dobTxt = findViewById(R.id.dobtxtId);
        emailTxt = findViewById(R.id.emailtxtId);
    }


    public void selectProfileBack (View view){
        if (profileImg == 0) {
            profileSelection = findViewById(R.id.profileImg);
            profileImg = profileImg;
        }
        else {
            profileSelection = findViewById(R.id.profileImg);
            profileImg--;
        }
        profileSelection.setImageResource(selectionImgs[profileImg]);
    }

    public void selectProfileNext (View view){
        if (profileImg == 3) {
            profileSelection = findViewById(R.id.profileImg);
            profileImg = profileImg;

        }
        else {
            profileSelection = findViewById(R.id.profileImg);
            profileImg++;
        }
        profileSelection.setImageResource(selectionImgs[profileImg]);
    }

    public void storeDetails(View view) {

        databaseAssist = new databaseAssitant(addUser_Activity.this);
        int getProfile = profileImg;
        String getName = nameTxt.getText().toString();
        String getDob = dobTxt.getText().toString();
        String getEmail = emailTxt.getText().toString();


        databaseAssist.addUser(getProfile,getName, getDob, getEmail);

    }

    public void viewDetails(View view) {
        Intent intent2 = new Intent(addUser_Activity.this, listofusers.class);
        startActivity(intent2);
    }
}