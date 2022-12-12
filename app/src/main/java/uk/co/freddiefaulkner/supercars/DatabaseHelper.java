package uk.co.freddiefaulkner.supercars;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String COLUMN_HIGHSCORE = "HIGHSCORE";
    public static final String COLUMN_GENDER = "GENDER";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String USER_TABLE = "USER_TABLE";

    public DatabaseHelper(@Nullable Context context){
        super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USER_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FIRST_NAME + " TEXT, " + COLUMN_LAST_NAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_USERNAME + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_GENDER + " TEXT, " + COLUMN_HIGHSCORE + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean addOne(CustomerModel customerModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_FIRST_NAME, customerModel.firstName);
        cv.put(COLUMN_LAST_NAME, customerModel.lastName);
        cv.put(COLUMN_EMAIL, customerModel.email);
        cv.put(COLUMN_USERNAME, customerModel.username);
        cv.put(COLUMN_PASSWORD, customerModel.password);
        cv.put(COLUMN_GENDER, customerModel.gender);
        cv.put(COLUMN_HIGHSCORE, customerModel.highScore);
        long insert = db.insert(USER_TABLE, null, cv);

        if (insert == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public ArrayList<String> getUsername(){
        ArrayList<String> returnList = new ArrayList<>();
        String queryString = "SELECT " + COLUMN_USERNAME + " FROM " + USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                returnList.add(cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME)));
                cursor.moveToNext();
            }
        }
        db.close();
        cursor.close();
        return returnList;
    }

    public ArrayList<String> getEmail(){
        ArrayList<String> returnList = new ArrayList<>();
        String queryString = "SELECT " + COLUMN_EMAIL + " FROM " + USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                returnList.add(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)));
                cursor.moveToNext();
            }
        }
        db.close();
        cursor.close();
        return returnList;
    }
    public String getPassword(String username){
        String queryString = "SELECT " + COLUMN_PASSWORD + " FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME + "=username";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));
        db.close();
        cursor.close();
        return password;
    }
    public String getFirstName(String username){
        String queryString = "SELECT " + COLUMN_FIRST_NAME + " FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME + "=username";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();
        String firstName = cursor.getString(cursor.getColumnIndex(COLUMN_FIRST_NAME));
        db.close();
        cursor.close();
        return firstName;
    }
    public String getLastName(String username){
        String queryString = "SELECT " + COLUMN_LAST_NAME + " FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME + "=username";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();
        String lastName = cursor.getString(cursor.getColumnIndex(COLUMN_LAST_NAME));
        db.close();
        cursor.close();
        return lastName;
    }
    public String getEmail(String username){
        String queryString = "SELECT " + COLUMN_EMAIL + " FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME + "=username";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();
        String email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));
        db.close();
        cursor.close();
        return email;
    }
    public String getUsername(String username){
        String queryString = "SELECT " + COLUMN_USERNAME + " FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME + "=username";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();
        String Username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME));
        db.close();
        cursor.close();
        return Username;
    }
    public String getHighScore(String username){
        String queryString = "SELECT " + COLUMN_HIGHSCORE + " FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME + "=username";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        cursor.moveToFirst();
        int highScore = cursor.getInt(cursor.getColumnIndex(COLUMN_HIGHSCORE));
        String HighScore = Integer.toString(highScore);
        db.close();
        cursor.close();
        return HighScore;
    }

    public boolean updateEmail(String email, String username){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_EMAIL, email);
        db.update(USER_TABLE, cv, COLUMN_USERNAME + " = ?", new String[]{username});
        db.close();
        return true;
    }

    public boolean updateUsername(String username1, String newUsername){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USERNAME, newUsername);
        db.update(USER_TABLE, cv, COLUMN_USERNAME + " = ?", new String[]{username1});
        db.close();
        return true;
    }

    public boolean updatePassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PASSWORD, password);
        db.update(USER_TABLE, cv, COLUMN_USERNAME + " = ?", new String[]{username});
        db.close();
        return true;
    }

    public boolean updateWins(String username, int highScore){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        highScore += 1;
        cv.put(COLUMN_HIGHSCORE, highScore);
        db.update(USER_TABLE, cv, COLUMN_USERNAME + " = ?", new String[]{username});
        db.close();
        return true;
    }
}
