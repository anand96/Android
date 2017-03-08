 package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
/**
 * Created by USER on 6/20/2016.
 */
class OuterDb {

    Squliteclssext squliteclssext;

    public OuterDb(Context context) {

        squliteclssext = new Squliteclssext(context);
    }

    long insetdata(String name, String email, String username, String password, String confirm, String phone, String gender, String country, String lang) {
        SQLiteDatabase sqLiteDatabase = squliteclssext.getWritableDatabase();
        ContentValues contextvlaues = new ContentValues();
        contextvlaues.put(Squliteclssext.name, name);
        contextvlaues.put(Squliteclssext.email, email);
        contextvlaues.put(Squliteclssext.username, username);
        contextvlaues.put(Squliteclssext.password, password);
        contextvlaues.put(Squliteclssext.confirm, confirm);
        contextvlaues.put(Squliteclssext.phone, phone);
        contextvlaues.put(Squliteclssext.gender, gender);
        contextvlaues.put(Squliteclssext.country, country);
        contextvlaues.put(Squliteclssext.lang, lang);
        long res = sqLiteDatabase.insert(Squliteclssext.table_name, null, contextvlaues);
        return res;
    }

    Cursor login(String username, String password) {
        SQLiteDatabase sqLiteDatabase = squliteclssext.getReadableDatabase();
        String[] clmun = {Squliteclssext.id, Squliteclssext.name, Squliteclssext.email, Squliteclssext.username, Squliteclssext.password, Squliteclssext.confirm, Squliteclssext.phone, Squliteclssext.gender, Squliteclssext.country, Squliteclssext.lang};
        String selection = Squliteclssext.username + "=? and  " + Squliteclssext.password + "=?";
        String[] selectionarg = {username, password};
        Cursor cursor = sqLiteDatabase.query(Squliteclssext.table_name, clmun, selection, selectionarg, null, null, null);
        return cursor;

    }
    long  update(int id,String name,String email,String username,String password,String gender,String phone,String country,String lang){
        SQLiteDatabase sqLiteDatabase=squliteclssext.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
       contentValues.put(Squliteclssext.name,name);
        contentValues.put(Squliteclssext.email,email);
        contentValues.put(Squliteclssext.username,username);
        contentValues.put(Squliteclssext.password,password);
        contentValues.put(Squliteclssext.gender,gender);
        contentValues.put(Squliteclssext.phone,phone);
        contentValues.put(Squliteclssext.country,country);
        contentValues.put(Squliteclssext.lang,lang);
        String where=Squliteclssext.id+"=?";
        String [] strngarg={String.valueOf(id)};
        long res =sqLiteDatabase.update(Squliteclssext.table_name,contentValues,where,strngarg);
        return res;


    }
    public long delete(String username, String password) {
        SQLiteDatabase sqLiteDatabase=squliteclssext.getWritableDatabase();
        String selection = Squliteclssext.username + "=? and  " + Squliteclssext.password + "=?";
        String[] selectionarg = {username, password};
        long res= sqLiteDatabase.delete(Squliteclssext.table_name,selection,selectionarg);
        return res;

    }


    public class Squliteclssext extends SQLiteOpenHelper {
        static final String databasename = "mydatabase";
        static final int databaseversion = 1;
        static final String table_name = "details";
        static final String id = "_id";
        static final String name = "name";
        static final String email = "email";
       public  static final String username = "username";
        public static final String password = "password";
        static final String confirm = "confirm";
        static final String phone = "phone";
        static final String gender = "gender";
        static final String country = "country";
        static final String lang = "lang";
        static final String create_quary = "create table " + table_name + "("+id+" integer primary key autoincrement," + name + " varchar(50)," + email + " varchar(40)," + username + " varchar(40)," + password + " varchar(25)," + confirm + " varchar(25)," + phone + " varchar(10)," + gender + " varchar(15)," + country + " varchar(25)," + lang + " varchar(25));";
        Context context;

        public Squliteclssext(Context context) {
            super(context, databasename, null, databaseversion);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(create_quary);
            Toast.makeText(context, "Table created", Toast.LENGTH_LONG).show();


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        }
    }
}