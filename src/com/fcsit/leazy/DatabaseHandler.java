package com.fcsit.leazy;

import java.util.ArrayList;
import java.util.List;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class DatabaseHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
  
    // Database Name
    private static final String DATABASE_NAME = "spinnerExample";
  
    // Labels table name
    private static final String TABLE_DATA = "data";
  
    // Labels Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CALORIES = "calories";
  
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
  
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Category table create query
        String CREATE_CATEGORIES_TABLE = "CREATE TABLE " + TABLE_DATA + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_CALORIES + " INT)";
        db.execSQL(CREATE_CATEGORIES_TABLE);
    }
  
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
  
        // Create tables again
        onCreate(db);
    }
     
    /**
     * Inserting new lable into lables table
     * */
    public void addData(Data data){
        SQLiteDatabase db = this.getWritableDatabase();
         
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, data.getFoodName());
        values.put(KEY_CALORIES, data.getCalories());
          
        // Inserting Row
        db.insert(TABLE_DATA, null, values);
        db.close(); // Closing database connection
    }
     
    /**
     * Getting all labels
     * returns list of labels
     * */
    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();
         
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_DATA;
      
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
      
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
         
        // closing connection
        cursor.close();
        db.close();
         
        // returning lables
        return labels;
    }
}