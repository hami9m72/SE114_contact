package com.example.se114_contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class PhoneDB extends SQLiteOpenHelper {
    public static final String DBNAME = "Phone.db";
    public PhoneDB(Context context) {
        super(context, "Phone.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Phone(name text primary key, phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists Phone");
    }

    public void deleteAllData() {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.delete("Phone", null, null);

    }
    public Boolean insertData(String name, String phone){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);

        long result = MyDB.insert("Phone", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public ArrayList<phone> getData() {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from Phone",null);
        ArrayList<phone> phoneArrayList = new ArrayList<>();
        cursor.moveToFirst();

        if (cursor.getCount()>0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                phone t = new phone(cursor.getString(0), cursor.getString(1));
                phoneArrayList.add(t);
                cursor.moveToNext();
            }
        }
        return phoneArrayList;
    }
}

