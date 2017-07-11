package com.example.dobry.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by dobry on 10.07.17.
 */

public final class HabitDbHelper extends SQLiteOpenHelper {

    // Helper String tag. Contains short class name for logging
    private static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "habits.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link HabitDbHelper}
     *
     * @param context of the app
     */
    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABITS_TABLE = "CREATE TABLE " +
                HabitContract.HabitEntry.TABLE_NAME + "(" +
                HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HabitContract.HabitEntry.COLUMN_ACTIVITY_NAME + " TEXT NOT NULL, " +
                HabitContract.HabitEntry.COLUMN_ACTIVITY_TYPE + " INTEGER DEFAULT 0, " +
                HabitContract.HabitEntry.COLUMN_ACTIVITY_DATE + " LONG NOT NULL, " +
                HabitContract.HabitEntry.COLUMN_ACTIVITY_DURATION + " INTEGER DEFAULT 0, " +
                HabitContract.HabitEntry.COLUMN_ACTIVITY_STATUS + " INTEGER NOT NULL DEFAULT 0);";
        Log.v(LOG_TAG, SQL_CREATE_HABITS_TABLE);

        // Execute command
        db.execSQL(SQL_CREATE_HABITS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
