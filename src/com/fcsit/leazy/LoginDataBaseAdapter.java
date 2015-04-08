package com.fcsit.leazy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class LoginDataBaseAdapter {
	static final String DATABASE_NAME = "leazy.db";
	static final int DATABASE_VERSION = 1;
	public static final int NAME_COLUMN = 1;
	// TODO: Create public field for each column in your table.
	// SQL Statement to create a new database.
	static final String DATABASE_CREATE = "CREATE TABLE " + "TableData" + " ("
			+ "ID" + " integer primary key autoincrement," + "USERNAME"
			+ " text," + "PASSWORD" + " text," + "WEIGHT" + " integer,"
			+ "HEIGHT" + " integer," + "AGE" + " integer," + "GENDER"
			+ " text," + "CALORIES" + " integer," + "CALORIES_BURNED"
			+ " integer," + "CALORIES_PEDO" + " integer" + " );";

	// Variable to hold the database instance
	public SQLiteDatabase db;
	// Context of the application using the database.
	private final Context context;
	// Database open/upgrade helper
	private DataBaseHelper dbHelper;

	public LoginDataBaseAdapter(Context _context) {
		context = _context;
		dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,
				DATABASE_VERSION);
	}

	public LoginDataBaseAdapter open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
	}

	public SQLiteDatabase getDatabaseInstance() {
		return db;
	}

	public void insertEntry(Data data) {
		ContentValues newValues = new ContentValues();
		newValues.put("USERNAME", data.getUsername());
		Log.d("db", "stored username+" + data.getUsername());
		newValues.put("PASSWORD", data.getPassword());
		Log.d("db", "stored password+" + data.getPassword());
		newValues.put("AGE", data.getAge());
		Log.d("db", "stored age+" + data.getAge());
		newValues.put("GENDER", data.getGender());
		Log.d("db", "stored gender+" + data.getGender());
		newValues.put("WEIGHT", data.getWeight());
		Log.d("db", "stored weight+" + data.getWeight());
		newValues.put("HEIGHT", data.getHeight());
		Log.d("db", "stored height+" + data.getHeight());
		newValues.put("CALORIES", data.getCalories());
		Log.d("db", "stored calories+" + data.getCalories());
		newValues.put("CALORIES_BURNED", data.getCaloriesBurned());
		Log.d("db", "stored calories burned+" + data.getCaloriesBurned());
		newValues.put("CALORIES_PEDO", data.getCaloriesPedo());
		Log.d("db", "stored cal pedo+" + data.getCaloriesPedo());

		db.insert("TableData", null, newValues);
	}

	// public void insertEntry(String userName, String password, ) {
	// ContentValues newValues = new ContentValues();
	// // Assign values for each row.
	// newValues.put("USERNAME", userName);
	// newValues.put("PASSWORD", password);
	//
	// // Insert the row into your table
	// db.insert("LOGIN", null, newValues);
	// // /Toast.makeText(context, "Reminder Is Successfully Saved",
	// // Toast.LENGTH_LONG).show();
	// }

	public int deleteEntry(Data data) {
		// String id=String.valueOf(ID);
		String where = "USERNAME=?";
		int numberOFEntriesDeleted = db.delete("TableData", where,
				new String[] { data.getUsername() });
		// Toast.makeText(context,
		// "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted,
		// Toast.LENGTH_LONG).show();
		return numberOFEntriesDeleted;
	}

	public Boolean checkIsExist(String username) throws SQLException {
		Cursor cur = db.query("TableData", new String[] { "USERNAME" },
				"USERNAME" + "=?", new String[] { username }, null, null, null);

		int index = cur.getColumnIndex("USERNAME");

	    boolean exists = cur.moveToFirst();//cur back to first?
	    cur.close();
	    return exists ;
	}

	public String getSinlgeEntry(String userName) {
		Cursor cursor = db.query("TableData", null, " USERNAME=?",
				new String[] { userName }, null, null, null);
		if (cursor.getCount() < 1) // UserName Not Exist
		{
			cursor.close();
			return "NOT EXIST";
		}
		cursor.moveToFirst();
		String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
		Log.d("db", "password= " + password);
		cursor.close();
		return password;
	}

	public int getSinlgeWeight(String userName) {
		Cursor cursor = db.query("TableData", null, " USERNAME=?",
				new String[] { userName }, null, null, null);
		if (cursor.getCount() < 1) // UserName Not Exist
		{
			cursor.close();
			return 0;
		}
		cursor.moveToFirst();
		int weight = cursor.getInt(cursor.getColumnIndex("WEIGHT"));
		Log.d("db", "weight= " + weight);
		cursor.close();
		return weight;
	}

	public int getSinlgeHeight(String userName) {
		Cursor cursor = db.query("TableData", null, " USERNAME=?",
				new String[] { userName }, null, null, null);
		if (cursor.getCount() < 1) // UserName Not Exist
		{
			cursor.close();
			return 0;
		}
		cursor.moveToFirst();
		int height = cursor.getInt(cursor.getColumnIndex("HEIGHT"));
		Log.d("db", "height= " + height);
		cursor.close();
		return height;
	}
	
	public Data getUser(int userid) {
	    SQLiteDatabase db = dbHelper.getReadableDatabase();

	    String selectQuery = "SELECT  * FROM " + "TableData"+ " = " + userid;
	    //+ " WHERE "  + "ANOTHERTABLELAH" + " = " + userid;

	    Log.d("db", selectQuery);

	    Cursor c = db.rawQuery(selectQuery, null);

	    if (c != null)
	        c.moveToFirst();

	    Data user = new Data();
	    user.setId(c.getInt(c.getColumnIndex("ID")));//KEY_ID key for fetching id
	    user.setAge((c.getInt(c.getColumnIndex("AGE"))));//KEY_BREAKFAST key for fetching isBreakfast
	    user.setWeight((c.getInt(c.getColumnIndex("WEIGHT"))));//KEY_LUNCH key for fetching isLunch
	    user.setHeight((c.getInt(c.getColumnIndex("HEIGHT"))));//KEY_VEGETABLE key for fetching vegetables

	    return user;
	}

	public void updateEntry(Data data) {
		// Define the updated row content.
		ContentValues updatedValues = new ContentValues();
		// Assign values for each row.
		updatedValues.put("USERNAME", data.getUsername());
		updatedValues.put("PASSWORD", data.getPassword());

		String where = "USERNAME = ?";
		db.update("TABLE DATA", updatedValues, where,
				new String[] { data.getUsername() });
	}
}

// package com.fcsit.leazy;
//
// import android.content.ContentValues;
// import android.content.Context;
// import android.database.Cursor;
// import android.database.SQLException;
// import android.database.sqlite.SQLiteDatabase;
//
// public class LoginDataBaseAdapter
// {
// static final String DATABASE_NAME = "leazy.db";
// static final int DATABASE_VERSION = 1;
// public static final int NAME_COLUMN = 1;
// // TODO: Create public field for each column in your table.
// // SQL Statement to create a new database.
// static final String DATABASE_CREATE = "create table "+"LOGIN"+
// "( " +"ID"+" integer primary key autoincrement,"+
// "USERNAME  text,PASSWORD text); ";
// // Variable to hold the database instance
// public SQLiteDatabase db;
// // Context of the application using the database.
// private final Context context;
// // Database open/upgrade helper
// private DataBaseHelper dbHelper;
// public LoginDataBaseAdapter(Context _context)
// {
// context = _context;
// dbHelper = new DataBaseHelper(context, DATABASE_NAME, null,
// DATABASE_VERSION);
// }
// public LoginDataBaseAdapter open() throws SQLException
// {
// db = dbHelper.getWritableDatabase();
// return this;
// }
// public void close()
// {
// db.close();
// }
//
// public SQLiteDatabase getDatabaseInstance()
// {
// return db;
// }
//
// public void insertEntry(String userName,String password)
// {
// ContentValues newValues = new ContentValues();
// // Assign values for each row.
// newValues.put("USERNAME", userName);
// newValues.put("PASSWORD",password);
//
// // Insert the row into your table
// db.insert("LOGIN", null, newValues);
// ///Toast.makeText(context, "Reminder Is Successfully Saved",
// Toast.LENGTH_LONG).show();
// }
// public int deleteEntry(String UserName)
// {
// //String id=String.valueOf(ID);
// String where="USERNAME=?";
// int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName})
// ;
// // Toast.makeText(context,
// "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted,
// Toast.LENGTH_LONG).show();
// return numberOFEntriesDeleted;
// }
// public String getSinlgeEntry(String userName)
// {
// Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName},
// null, null, null);
// if(cursor.getCount()<1) // UserName Not Exist
// {
// cursor.close();
// return "NOT EXIST";
// }
// cursor.moveToFirst();
// String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
// cursor.close();
// return password;
// }
// public void updateEntry(String userName,String password)
// {
// // Define the updated row content.
// ContentValues updatedValues = new ContentValues();
// // Assign values for each row.
// updatedValues.put("USERNAME", userName);
// updatedValues.put("PASSWORD",password);
//
// String where="USERNAME = ?";
// db.update("LOGIN",updatedValues, where, new String[]{userName});
// }
// }

