package com.neeraj.studentinfo.data.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.neeraj.studentinfo.data.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neeraj on 10/2/18.
 */

public class DatabaseHandler extends SQLiteOpenHelper implements InterfaceSqlitData {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "com_neeraj_studentinfo_db";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SqliteTable.CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SqliteTable.CREATE_STUDENT_TABLE);

        // Create tables again
        onCreate(sqLiteDatabase);

    }



    @Override
    public boolean insertValue(Student student) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SqliteTable.KEY_ROOL_NUMBER, student.getStudent_roll_no());
        values.put(SqliteTable.KEY_NAME, student.getStudent_name());
        values.put(SqliteTable.KEY_MATHS_MARK, student.getStudent_maths_marks());
        values.put(SqliteTable.KEY_SCIENCE_MARK, student.getStudent_science_marks());
        values.put(SqliteTable.KEY_ENGLISH_MARK, student.getStudent_english_marks());
        values.put(SqliteTable.KEY_PERCENTAGE, student.getStudent_percentage());

        // Inserting Row
        long result = db.insert(SqliteTable.TABLE_STUDENT, null, values);

        db.close(); // Closing database connection
        return result != -1;
    }



    @Override
    public List<Student> fetchValue() {
        List<Student> contactList = new ArrayList<Student>();

        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery(SqliteTable.selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.setStudent_id(Integer.parseInt(cursor.getString(0)));
                student.setStudent_roll_no(Integer.parseInt(cursor.getString(1)));
                student.setStudent_name(cursor.getString(2));
                student.setStudent_maths_marks(Integer.parseInt(cursor.getString(3)));
                student.setStudent_science_marks(Integer.parseInt(cursor.getString(4)));
                student.setStudent_english_marks(Integer.parseInt(cursor.getString(5)));
                student.setStudent_percentage(Float.parseFloat(cursor.getString(6)));

                // Adding contact to list
                contactList.add(student);
            } while (cursor.moveToNext());
        }

       cursor.close();
       db.close();
        // return contact list
        return contactList;
    }

}
