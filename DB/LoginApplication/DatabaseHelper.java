package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "people.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE person(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "first_name TEXT, " +
                        "last_name TEXT, " +
                        "email TEXT, " +
                        "password, TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS person;");
        onCreate(db);
    }

    public long addPerson(String firstName, String lastName, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("first_name", firstName);
        cv.put("last_name", lastName);
        cv.put("email", email);
        cv.put("password", password);

        return db.insert("person", null, cv);
    }

    public Cursor getAllPeople() {
        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("SELECT * FROM person", null);
    }

    public int updatePerson(int id, String firstName, String lastName, String email,  String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("first_name", firstName);
        cv.put("last_name", lastName);

        return db.update("person", cv, "id = ?", new String[]{String.valueOf(id)});
    }

    public int deletePerson(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete("person", "id = ?", new String[]{String.valueOf(id)});
    }
}
