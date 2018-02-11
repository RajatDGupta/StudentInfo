package com.neeraj.studentinfo.data.sqlite;

/**
 * Created by neeraj on 10/2/18.
 */

public class SqliteTable {
    // All Static variables
    // Database Version


    // Contacts table name
     static final String TABLE_STUDENT = "studentinfo";

    // Contacts Table Columns names
     private static final String KEY_ID = "stud_id";
     static final String KEY_ROOL_NUMBER = "stud_roll_no";
     static final String KEY_NAME = "stud_name";
     static final String KEY_MATHS_MARK = "mark_maths";
     static final String KEY_SCIENCE_MARK = "mark_science";
     static final String KEY_ENGLISH_MARK = "mark_english";
     static final String KEY_PERCENTAGE = "mark_percentage";


     static String CREATE_STUDENT_TABLE = "CREATE TABLE " + TABLE_STUDENT + "("
            + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_ROOL_NUMBER + " INTEGER,"
            + KEY_NAME + " TEXT,"+ KEY_MATHS_MARK +" INTEGER,"+ KEY_SCIENCE_MARK +" INTEGER,"+ KEY_ENGLISH_MARK +
            " INTEGER,"+ KEY_PERCENTAGE + " REAL "+")";

    //quires

    static String selectQuery = "SELECT  * FROM " + TABLE_STUDENT +" ORDER BY "+ KEY_PERCENTAGE  +" DESC";
   //static String selectQuery = "SELECT  * FROM " + TABLE_STUDENT ;


}
