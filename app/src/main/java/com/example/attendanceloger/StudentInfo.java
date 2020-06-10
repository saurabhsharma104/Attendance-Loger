package com.example.attendanceloger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentInfo extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "appdb";
    private static final int DATABASE_VERSION = 4;
    public static final String TABLE_NAME = "students";
    public static final String TABLE_NAME2 = "attendance";
    public static final String TABLE_NAME3 = "timetable";
    public static final String NAME = "name";
    public static final String FNAME = "fname";
    public static final String MOBNO = "mobno";
    public static final String ROLLNO = "rollno";
    public static final String ADDRESS = "address";
    public static final String PNO = "period";
    public static final String DECE = "description1";

    StudentInfo(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "create table "+TABLE_NAME+"("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";
        String CREATE_TABLE3 = "create table timetable(period integer primary key ,description1 text);";
        String CREATE_TABLE2 = "create table "+TABLE_NAME2+"(roll integer ,cur_date text,record text,primary key (roll,cur_date));";

        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE2);
        sqLiteDatabase.execSQL(CREATE_TABLE3);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_TABLE3 = "drop table if exists '"+TABLE_NAME3+"';";
        String DROP_TABLE = "drop table if exists "+TABLE_NAME+";";
        String DROP_TABLE2 = "drop table if exists "+TABLE_NAME2+";";
        sqLiteDatabase.execSQL(DROP_TABLE);
        sqLiteDatabase.execSQL(DROP_TABLE2);
        sqLiteDatabase.execSQL(DROP_TABLE3);
        onCreate(sqLiteDatabase);
       }


    public Cursor readStudent()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {ROLLNO,NAME,FNAME,MOBNO,ADDRESS};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,projections,null,null,null,null,null,null);

        return cursor;
    }

    public boolean addAttendance(int r,String d,String re,SQLiteDatabase database)
    {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("roll",r);
        contentValues2.put("cur_date",d);
        contentValues2.put("record",re);
        long res = database.insert("attendance",null,contentValues2);

        return res!=-1;
    }

    public boolean addStudentInTable(int r,String n,String f,String m,String a,SQLiteDatabase database)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROLLNO,r);
        contentValues.put(NAME,n);
        contentValues.put(FNAME,f);
        contentValues.put(MOBNO,m);
        contentValues.put(ADDRESS,a);
        long res = database.insert(TABLE_NAME,null,contentValues);

        return res!=-1;
    }

    public boolean addTimeTable(int p,String d,SQLiteDatabase database)
    {
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(PNO,p);
        contentValues1.put(DECE,d);
        long res;
        res = database.insert(TABLE_NAME3,null,contentValues1);

        return res!=-1;
    }

    public Cursor showTimeTable(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {PNO,DECE};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME3,projections,null,null,null,null,null,null);

        return cursor;
    }
    public Cursor showClassWise(String da)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {"roll","cur_date","record"};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME2,projections,"cur_date LIKE ?",new String[]{da},null,null,null,null);

        return cursor;
    }

    public Cursor showStudentWise(String ro, String de)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {"roll","cur_date","record"};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME2,projections,"cur_date LIKE ? and roll LIKE ?",new String[]{de,ro},null,null,null,null);

        return cursor;
    }

    public Cursor readOneStudent(String r)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {NAME,FNAME};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,projections, StudentInfo.ROLLNO+" LIKE ? ",new String[]{r},null,null,null,null);

        return cursor;
    }

    public  boolean deletePeriodInTable(Integer a)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME3,"period=?",new String[]{a.toString()})>0;

    }
    public  boolean deleteStudentInTable(Integer a)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,StudentInfo.ROLLNO+"=?",new String[]{a.toString()})>0;

    }
    public Cursor multiAttendance(String r)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {"roll","cur_date","record"};
        Cursor cursor = sqLiteDatabase.query(TABLE_NAME2,projections,"roll LIKE ?",new String[]{r},null,null,null,null);

        return cursor;
    }
}
