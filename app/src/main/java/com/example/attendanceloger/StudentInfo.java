package com.example.attendanceloger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Spinner;

public class StudentInfo extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "appdb";
    private static final int DATABASE_VERSION = 17;
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
        String CREATE_FIRST = "create table table_first("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";
        String CREATE_SECOND = "create table table_second("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";
        String CREATE_THIRD = "create table table_third("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";
        String CREATE_FORTH = "create table table_forth("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";
        String CREATE_FIFTH = "create table table_fifth("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";
        String CREATE_SIXTH = "create table table_sixth("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";
        String CREATE_SEVENTH = "create table table_seventh("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";
        String CREATE_EIGHTH = "create table table_eighth("+ROLLNO+" integer primary key ,"+NAME+" text,"+FNAME+" text,"+ MOBNO+" text,"+ADDRESS+" text);";

        String CREATE_TABLE3 = "create table timetable(period integer primary key ,description1 text);";
        String CREATE_TABLE2 = "create table "+TABLE_NAME2+"(roll integer ,cur_date text,record text,primary key (roll,cur_date));";

        String CREATE_FIRST2 = "create table table_first2(roll integer ,cur_date text,record text,primary key (roll,cur_date));";
        String CREATE_SECOND2 ="create table table_second2(roll integer ,cur_date text,record text,primary key (roll,cur_date));";
        String CREATE_THIRD2 = "create table table_third2(roll integer ,cur_date text,record text,primary key (roll,cur_date));";
        String CREATE_FORTH2 = "create table table_forth2(roll integer ,cur_date text,record text,primary key (roll,cur_date));";
        String CREATE_FIFTH2 = "create table table_fifth2(roll integer ,cur_date text,record text,primary key (roll,cur_date));";
        String CREATE_SIXTH2 = "create table table_sixth2(roll integer ,cur_date text,record text,primary key (roll,cur_date));";
        String CREATE_SEVENTH2="create table table_seventh2(roll integer ,cur_date text,record text,primary key (roll,cur_date));";
        String CREATE_EIGHTH2 ="create table table_eighth2(roll integer ,cur_date text,record text,primary key (roll,cur_date));";

        sqLiteDatabase.execSQL(CREATE_FIRST);
        sqLiteDatabase.execSQL(CREATE_SECOND);
        sqLiteDatabase.execSQL(CREATE_THIRD);
        sqLiteDatabase.execSQL(CREATE_FORTH);
        sqLiteDatabase.execSQL(CREATE_FIFTH);
        sqLiteDatabase.execSQL(CREATE_SIXTH);
        sqLiteDatabase.execSQL(CREATE_SEVENTH);
        sqLiteDatabase.execSQL(CREATE_EIGHTH);

        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_TABLE2);
        sqLiteDatabase.execSQL(CREATE_TABLE3);

        sqLiteDatabase.execSQL(CREATE_FIRST2);
        sqLiteDatabase.execSQL(CREATE_SECOND2);
        sqLiteDatabase.execSQL(CREATE_THIRD2);
        sqLiteDatabase.execSQL(CREATE_FORTH2);
        sqLiteDatabase.execSQL(CREATE_FIFTH2);
        sqLiteDatabase.execSQL(CREATE_SIXTH2);
        sqLiteDatabase.execSQL(CREATE_SEVENTH2);
        sqLiteDatabase.execSQL(CREATE_EIGHTH2);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE3 = "drop table if exists '"+TABLE_NAME3+"';";
        String DROP_TABLE = "drop table if exists "+TABLE_NAME+";";
        String DROP_TABLE2 = "drop table if exists "+TABLE_NAME2+";";

        String DROP_FIRST = "drop table if exists table_first;";
        String DROP_SECOND = "drop table if exists table_second;";
        String DROP_THIRD = "drop table if exists table_third;";
        String DROP_FORTH = "drop table if exists table_forth;";
        String DROP_FIFTH = "drop table if exists table_fifth;";
        String DROP_SIXTH = "drop table if exists table_sixth;";
        String DROP_SEVENTH = "drop table if exists table_seventh;";
        String DROP_EIGHTH = "drop table if exists table_eighth;";

        String DROP_FIRST2 = "drop table if exists table_first2;";
        String DROP_SECOND2 = "drop table if exists table_second2;";
        String DROP_THIRD2 = "drop table if exists table_third2;";
        String DROP_FORTH2 = "drop table if exists table_forth2;";
        String DROP_FIFTH2 = "drop table if exists table_fifth2;";
        String DROP_SIXTH2 = "drop table if exists table_sixth2;";
        String DROP_SEVENTH2 = "drop table if exists table_seventh2;";
        String DROP_EIGHTH2 = "drop table if exists table_eighth2;";

        sqLiteDatabase.execSQL(DROP_TABLE);
        sqLiteDatabase.execSQL(DROP_TABLE2);
        sqLiteDatabase.execSQL(DROP_TABLE3);

        sqLiteDatabase.execSQL(DROP_FIRST);
        sqLiteDatabase.execSQL(DROP_SECOND);
        sqLiteDatabase.execSQL(DROP_THIRD);
        sqLiteDatabase.execSQL(DROP_FORTH);
        sqLiteDatabase.execSQL(DROP_FIFTH);
        sqLiteDatabase.execSQL(DROP_SIXTH);
        sqLiteDatabase.execSQL(DROP_SEVENTH);
        sqLiteDatabase.execSQL(DROP_EIGHTH);


        sqLiteDatabase.execSQL(DROP_FIRST2);
        sqLiteDatabase.execSQL(DROP_SECOND2);
        sqLiteDatabase.execSQL(DROP_THIRD2);
        sqLiteDatabase.execSQL(DROP_FORTH2);
        sqLiteDatabase.execSQL(DROP_FIFTH2);
        sqLiteDatabase.execSQL(DROP_SIXTH2);
        sqLiteDatabase.execSQL(DROP_SEVENTH2);
        sqLiteDatabase.execSQL(DROP_EIGHTH2);

        onCreate(sqLiteDatabase);
       }


    public Cursor readStudent()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {ROLLNO,NAME,FNAME,MOBNO,ADDRESS};
        String TABLE = StudentInfo.getTableNames();
        Cursor cursor = sqLiteDatabase.query(TABLE,projections,null,null,null,null,null,null);

        return cursor;
    }

    public boolean addAttendance(int r,String d,String re,SQLiteDatabase database)
    {
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("roll",r);
        contentValues2.put("cur_date",d);
        contentValues2.put("record",re);
        String TABLE = StudentInfo.getTableNames();
        if(TABLE.equals(TABLE_NAME)) {
            long res = database.insert(TABLE_NAME2, null, contentValues2);
            return res != -1;
        }else
            TABLE+="2";
        long res = database.insert(TABLE, null, contentValues2);
        return res != -1;
    }

    public boolean addStudentInTable(int r,String n,String f,String m,String a,SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROLLNO, r);
        contentValues.put(NAME, n);
        contentValues.put(FNAME, f);
        contentValues.put(MOBNO, m);
        contentValues.put(ADDRESS, a);

        String TABLE = StudentInfo.getTableNames();

        long res = database.insert(TABLE, null, contentValues);
        return res!=-1;
    }

    public boolean addTimeTable(int p,String d,SQLiteDatabase database)
    {
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(PNO,p);
        contentValues1.put(DECE,d);
        long res = database.insert(TABLE_NAME3, null, contentValues1);

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
        String TABLE = StudentInfo.getTableNames();
        if(TABLE.equals(TABLE_NAME)) {
            TABLE=TABLE_NAME2;
        }else
            TABLE+="2";
        Cursor cursor = sqLiteDatabase.query(TABLE,projections,"cur_date LIKE ?",new String[]{da},null,null,null,null);

        return cursor;
    }

    public Cursor showStudentWise(String ro, String de)
    {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {"roll","cur_date","record"};
        String TABLE = StudentInfo.getTableNames();
        if(TABLE.equals(TABLE_NAME)) {
            TABLE=TABLE_NAME2;
        }else
            TABLE+="2";
        Cursor cursor = sqLiteDatabase.query(TABLE,projections,"cur_date LIKE ? and roll LIKE ?",new String[]{de,ro},null,null,null,null);

        return cursor;
    }

    public Cursor readOneStudent(String r)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {NAME,FNAME};
        String TABLE = StudentInfo.getTableNames();
        Cursor cursor = sqLiteDatabase.query(TABLE,projections, StudentInfo.ROLLNO+" LIKE ? ",new String[]{r},null,null,null,null);

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
        String TABLE = StudentInfo.getTableNames();
        return sqLiteDatabase.delete(TABLE,StudentInfo.ROLLNO+"=?",new String[]{a.toString()})>0;

    }
    public Cursor multiAttendance(String r)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projections = {"roll","cur_date","record"};
        String TABLE = StudentInfo.getTableNames();
        if(TABLE.equals(TABLE_NAME)) {
            TABLE=TABLE_NAME2;
        }else
            TABLE+="2";
        Cursor cursor = sqLiteDatabase.query(TABLE,projections,"roll LIKE ?",new String[]{r},null,null,null,null);

        return cursor;
    }
    public static String getTableNames()
    {
        switch (MainActivity.item) {

            case "First":
                return "table_first";
            case "Second":
                return "table_second";
            case "Third":
                return "table_third";
            case "Forth":
                return "table_forth";
            case "Fifth":
                return "table_fifth";
            case "Sixth":
                return "table_sixth";
            case "Seventh":
                return "table_seventh";
            case "Eighth":
                return "table_eighth";
            default:
                return TABLE_NAME;
        }
    }
}

