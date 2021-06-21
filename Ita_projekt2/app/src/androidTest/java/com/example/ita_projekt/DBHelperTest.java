package com.example.ita_projekt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.SqliteObjectLeakedViolation;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class DBHelperTest {
    public static String ime;
    public static String pass;

    Logger logger = Logger.getLogger("MyLog");
    Context context = ApplicationProvider.getApplicationContext();
    @Test
    public void testonCreate() {
        //Context context = ApplicationProvider.getApplicationContext();
        DBHelper data = new DBHelper(context);
        SQLiteDatabase db = data.getWritableDatabase();
        assertTrue(db.isOpen());
        logger.info("Izvedeno");
    }

    @Test
    public void testDropDB(){
        Context context = ApplicationProvider.getApplicationContext();
        assertTrue(context.deleteDatabase(DBHelper.DBName));

    }


    @Test
    public  void testinsert(){
       DBHelper dbHelper = new DBHelper(context);
       SQLiteDatabase db = dbHelper.getWritableDatabase();
       assertTrue(db.isOpen());
       ime = "ime";
       pass = "geslo";

        ContentValues contentValues = new ContentValues();
        contentValues.put("username",ime);
        contentValues.put("password",pass);
        long result = db.insert("users",null,contentValues);
        assertTrue(result != -1);
        logger.info("testInsertData - ID" + result);
    }


    @Test
    public  void checkusername(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ime ="ime";
        pass = "pass";

        ContentValues contentValues = new ContentValues();
        Cursor cursor = db.rawQuery("Select * from users where username = ?",new String[] {ime});
        assertTrue(cursor.getCount() > 0);
    }

    @Test
    public void checkPass(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        assertTrue(db.isOpen());
        ime = "ime";
        pass = "geslo99";

        long result = -1;
        if(preveri(pass)) {
         ContentValues contentValues = new ContentValues();
         contentValues.put("username",ime);
         contentValues.put("password",pass);
         result = db.insert("users", null, contentValues);
         logger.info("testInsertData - ID" + result);
        }
        assertTrue(result != -1);
    }

    public boolean preveri(String pass){
        char[] chars = pass.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            if (Character.isDigit(c)) {
                sb.append(c);
                return true;
            }
        }
        return false;
    }


    @Test
    public void checkUserLogin(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ime = "ime";
        pass  = "geslo";
        ContentValues contentValues = new ContentValues();
        Cursor cursor = db.rawQuery("Select * from users where username = ? and password = ?", new String[] {ime, pass});
        assertTrue(cursor.getCount() > 0);
    }


    @Test
    public void checkUserLoginFalse(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db =  dbHelper.getWritableDatabase();
        ime = "1";
        pass = "2";
        ContentValues contentValues = new ContentValues();
        Cursor cursor = db.rawQuery("Select * from users where username = ? and password = ?", new String[] {ime, pass});
        assertFalse(cursor.getCount() > 0);
    }

}
