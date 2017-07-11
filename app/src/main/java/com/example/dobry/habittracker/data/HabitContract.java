package com.example.dobry.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by dobry on 10.07.17.
 */

public final class HabitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabitContract() {
    }

    /**
     * Inner class that defines constant values for the habits database table.
     * Each entry in the table represents a single habit.
     */

    public static abstract class HabitEntry implements BaseColumns {
        public static final String TABLE_NAME = "habits";

        // (INTEGER) Unique ID number for the habit (only for use in the database table).
        public final static String _ID = BaseColumns._ID;

        public static final String COLUMN_ACTIVITY_NAME = "name";
        public static final String COLUMN_ACTIVITY_TYPE = "type";
        public static final String COLUMN_ACTIVITY_DATE = "date";
        public static final String COLUMN_ACTIVITY_DURATION = "duration";
        public static final String COLUMN_ACTIVITY_STATUS = "status";

        /**
         * (int) Possible values for the STATUS of habits.
         */
        public static final int STATUS_PENDING = 0;
        public static final int STATUS_DONE = 1;
        public static final int STATUS_VOID = 2;

        /**
         * (int) Possible values for the TYPE of habits.
         */
        public static final int OTHER = 0;
        public static final int TYPE_SPORT = 1;
        public static final int TYPE_HOUSE_DUTES = 2;
        public static final int TYPE_LEARN = 3;
        public static final int TYPE_HOBBY = 4;
        public static final int TYPE_WORK = 5;

    }
}
