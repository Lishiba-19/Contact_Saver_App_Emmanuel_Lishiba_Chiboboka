package com.example.contact_saver_app_emmanuel_lishiba_chiboboka;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class databaseAssitant extends SQLiteOpenHelper {

    private static databaseAssitant dbAssist;

    private static final String TAG = "databaseAssitant";
    private final Context context;

    public databaseAssitant(Context context) {
        super(context, "userDetailsNew.db", null, 21);
        this.context = context;
    }

    public static databaseAssitant dbInstance(Context context) {
        if(dbAssist == null)
            dbAssist = new databaseAssitant(context);

        return dbAssist;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists users(id integer not null primary key autoincrement, profile int(30) ,name varchar(30), dob varchar(30), email varchar(30))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists users");
        onCreate(db);
    }

    void addUser(int profile, String name, String dob, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("profile", profile);
        contentValues.put("name", name);
        contentValues.put("dob", dob);
        contentValues.put("email", email);
        long result = db.insert("users", null, contentValues);

        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readData (){
        SQLiteDatabase sqDb = this.getWritableDatabase();
        Cursor cursor = sqDb.rawQuery("SELECT * FROM users", null);
        return  cursor;
    }

}
