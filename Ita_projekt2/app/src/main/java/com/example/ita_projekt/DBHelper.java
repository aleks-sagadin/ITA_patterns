package com.example.ita_projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper  extends SQLiteOpenHelper {

    public static final String DBName = "Login.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLEName ="users";


   public static final String SQLUSERNAMECHECK =  "Select * from users where username = ?";
   public static final String SQLUSER_PASS = "Select * from users where username = ? and password = ?";

    public DBHelper(Context context ) { super(context,DBName,null,DATABASE_VERSION);
    }


    private static final String CREATE_USERS_TABLE_SQL =
            "CREATE TABLE users (" +
                    "id INTEGER primary key, " +
                    "username TEXT," +
                    " password TEXT " +
                    " )";

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL(CREATE_USERS_TABLE_SQL);

    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");

    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);

        contentValues.put("password",password);
        long result = MyDB.insert(TABLEName,null,contentValues);

        if(result== -1) return false;
        else
            return true;

    }

    //vsebovat morav vsaj eno st
    public Boolean checkPassword(String password){
        char[] chars = password.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                sb.append(c);
                return true;
            }
        }
        return false;

    }


    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery(SQLUSERNAMECHECK,new String[] {username});
        if(cursor.getCount() > 0)
            return true;
        else
                return false;
        }




        public Boolean checkUserpassword(String username,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery(SQLUSER_PASS, new String[] {username, password});
        if (cursor.getCount() > 0 )
            return true;
        else
            return false;
        }


}
