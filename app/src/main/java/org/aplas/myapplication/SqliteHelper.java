package org.aplas.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class SqliteHelper extends SQLiteOpenHelper{
    private Context context;
    //Database name and version
    public static final String DATABASE_NAME = "myappfintech.db";
    public static final int DATABASE_VERSION = 1;

    //Nama Tabel
    public static final String TABLE_NAME = "user";

    //Nama Kolom
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";


    public SqliteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(id INTEGER primary key, username TEXT, password TEXT)");
        String sql = "CREATE TABLE IF NOT EXISTS tbl_trans(id_trans INTEGER PRIMARY KEY AUTOINCREMENT, tglmasuk TEXT, nommasuk TEXT, ketmasuk TEXT, totmasuk TEXT, tglkeluar TEXT, nomkeluar TEXT, ketkeluar TEXT, totkeluar TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);

    }
    public Boolean insertData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = db.insert("user", null, values);
        if (result == -1) return false;
        else
            return true;

    }

    public Boolean updateData(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = db.insert("user", null, values);
        if (result == -1) return false;
        else
            return true;

    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?", new String[] {username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[] {username,password});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean insertDataTransIn(String d, String n, String k ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("tglmasuk", d);
        values.put("nommasuk", n);
        values.put("ketmasuk", k);

        long result = db.insert("tbl_trans", null, values);
        if (result == -1) return false;
        else
            return true;

    }

}
