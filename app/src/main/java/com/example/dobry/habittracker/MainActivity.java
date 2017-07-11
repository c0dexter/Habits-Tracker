package com.example.dobry.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dobry.habittracker.data.HabitContract;
import com.example.dobry.habittracker.data.HabitContract.HabitEntry;
import com.example.dobry.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    // (String) helper String tag with class name for logging
    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    // Database helper object
    private HabitDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // new instance of Database Helper: HabitDbHelper
        mDbHelper = new HabitDbHelper(this);

        insertHabit();
        readDatabase();
        displayDatabaseInfo();


    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the habit database.
     *
     * @return the Cursor object, which contains all data of columns
     * which has been selected in 'projection' (String) table
     */
    private Cursor readDatabase() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Select column for displaying
        String[] projection = {
                HabitEntry._ID,
                HabitEntry.COLUMN_ACTIVITY_NAME,
                HabitEntry.COLUMN_ACTIVITY_TYPE,
                HabitEntry.COLUMN_ACTIVITY_DATE,
                HabitEntry.COLUMN_ACTIVITY_DURATION,
                HabitEntry.COLUMN_ACTIVITY_STATUS
        };

        // The query for SQL SELECT action
        return db.query(
                HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * Helper method to insert dummy data for habits.
     */
    private void insertHabit() {
        // Switch DB into write (insert) mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and Yoga attributes are the values.
        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_ACTIVITY_NAME, getString(R.string.dummy_data_activity_name));
        values.put(HabitEntry.COLUMN_ACTIVITY_TYPE, HabitEntry.TYPE_LEARN);     // static type
        values.put(HabitEntry.COLUMN_ACTIVITY_DATE, 1499731200);                // Unix timestamp format
        values.put(HabitEntry.COLUMN_ACTIVITY_DURATION, 7);                     // minutes
        values.put(HabitEntry.COLUMN_ACTIVITY_STATUS, HabitEntry.STATUS_DONE);  // static status

        /// Insert the new row, returning the primary ***key value(current ID)***
        // of the new row
        long newRowId = db.insert(HabitContract.HabitEntry.TABLE_NAME, null, values);

        // Displaying proper message depends on result of saving data to DB
        if (newRowId == -1) {
            Log.i(LOG_TAG, getString(R.string.db_saving_error_log_msg) + newRowId);
            Toast.makeText(this, getString(R.string.db_saving_error_toast_msg) + newRowId, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, getString(R.string.db_success_saving_toast_msng) + newRowId, Toast.LENGTH_SHORT).show();
            Log.i(LOG_TAG, getString(R.string.db_saving_success_log_msng) + newRowId);
        }

    }

    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Perform this raw SQL query "SELECT * FROM habits"
        // to get a Cursor that contains all rows from the habits table.
        Cursor cursor = db.rawQuery("SELECT * FROM " + HabitContract.HabitEntry.TABLE_NAME, null);
        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // habit table in the database).
            TextView displayView = (TextView) findViewById(R.id.main_text_view);
            displayView.setText("Amount of rows in database habits table " + cursor.getCount());
            Log.i(LOG_TAG, getString(R.string.db_rows_amount_log_msng) + cursor.getCount());
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }
}
