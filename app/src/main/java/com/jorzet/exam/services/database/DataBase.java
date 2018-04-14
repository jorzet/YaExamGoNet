package com.jorzet.exam.services.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jorge on 14/04/18.
 */

public class DataBase extends SQLiteOpenHelper {
    Context mContext;

    /* To build the DB */
    private static final String DATABASE_NAME = "PTDB";
    private static final SQLiteDatabase.CursorFactory DATABASE_FACTORY = null;
    private static final int DATABASE_VERSION = 1;

    /* Table names */
    private static final String TABLE_RESPONSE = "Response";
    private static final String TABLE_USER = "User";

    /* SQL instructions */
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
    private static final String DROP_TABLE = "CREATE TABLE IF NOT EXISTS ";

    /* Columns name */
    private static final String COL_ID_USER = "id_user";
    private static final String COL_USER = "user";
    private static final String COL_PASSWORD = "password";

    private static final String USER_ATRIBUTS = "("+COL_ID_USER + " integer primary key," +
            COL_USER + " text," +
            COL_PASSWORD + " text); ";

    public DataBase(Context context) {
        super(context, DataBase.DATABASE_NAME, DataBase.DATABASE_FACTORY, DataBase.DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("MyTAG","onCreate");
        db.execSQL(
                DataBase.CREATE_TABLE + DataBase.TABLE_USER + DataBase.USER_ATRIBUTS
                //CREATE_TABLE + TABLE_SPETIALIST + SPETIALIST_ATRIBUTS
        );
        Log.i("MyTAG","onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.i("MyTAG: ","onUpgrade");
        db.execSQL("DROP TABLE " + DataBase.TABLE_USER + ";");
        onCreate(db);
        Log.i("MyTAG: ","onUpgrade");
    }

    public void storeLoginJSON(String json){
        SharedPreferences.Editor editor = mContext.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE).edit();
        editor.putString(TABLE_RESPONSE, json);
        editor.apply();
    }

    public String getLoginJSON() {
        SharedPreferences prefs = mContext.getSharedPreferences(DATABASE_NAME, Context.MODE_PRIVATE);
        return prefs.getString(TABLE_RESPONSE, null);
    }
}
