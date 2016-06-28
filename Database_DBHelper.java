package com.tcs.androidproject.Datbase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.Toast;

import com.tcs.androidproject.PaymentActivity;
import com.tcs.androidproject.TravleAppContext;

import java.sql.SQLDataException;

/**
 * Created by 1012711 on 6/22/2016.
 */
public class DBHelper extends SQLiteOpenHelper implements BaseColumns {
     private static final String DATABASE_NAME = "TRAVEL";
     private static final int DATABASE_VERSION = 1;
     public static final String TABLE_NAME_1 = "TABLE_TRAVEL";
    public static final String TABLE_NAME_2 = "USER_CARD_DETAIL";


    public static final String COL_2 = "NAME";
    public static final String COL_3 = "MOBILENO";
    public static final String COL_4 = "NO_OF_ROOMS";
    public static final String COL_5 = "HOTEL_NAME";
    public static final String COL_6 = "AMOUNT_PAID";
    public static final String COL_7 = "CARD_NO";
    public static final String COL_8 = "NAME_ON_CARD";
    public static final String COL_9 = "CVV_NO";
    public static final String COL_10 = "KEY";




    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table " + TABLE_NAME_1 + " ("
                        + _ID + " integer primary key autoincrement,"
                        + COL_2 + " text not null,"
                        + COL_3 + " text not null,"
                        + COL_4 + " text not null,"
                        + COL_5 + " text,"
                        + COL_6 + " text not null);"
        );


        db.execSQL(
                "create table " + TABLE_NAME_2 + " ( "
                        + COL_10 + " integer,"
                        + COL_7 + " integer,"
                        + COL_8 + " integer,"
                        + COL_9 + " integer,"
                        + " foreign key (" + COL_10 + ") REFERENCES " + TABLE_NAME_1 + " ( " + _ID + " ));"
        );


    }

    public long insertData(String Name,String MobileNo,String noOfRooms ,String hotelName ,String amountPaid ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,Name);
        contentValues.put(COL_3,MobileNo);
        contentValues.put(COL_4,noOfRooms);
        contentValues.put(COL_5,hotelName);
        contentValues.put(COL_6, amountPaid);

        long result = db.insert(TABLE_NAME_1,null,contentValues);
        return result;
    }


    public long insertCardData(String cardNo ,String nameOnCard, String cvvCard,String mobile){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(COL_7,cardNo);
        contentValues1.put(COL_8,nameOnCard);
        contentValues1.put(COL_9,cvvCard);
        contentValues1.put(COL_10,mobile);

        long result = db.insert(TABLE_NAME_2,null,contentValues1);

        return result;
    }


    public Cursor getCardNumber(){
        SQLiteDatabase db = this.getReadableDatabase();try {
            Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME_2, null);
            return c;
//        Cursor cursor = db.query(TABLE_NAME_2,new String[]{COL_7},COL_10+" ='"+mobileno+"'",null,null,null,null);
      /* // cursor.moveToFirst();

        int length = cursor.getCount();
        int position = 0;
        if (length > 0){
            cursor.moveToFirst();
            position = cursor.getPosition();
            Toast.makeText(TravleAppContext.getContext(), "" + position, Toast.LENGTH_SHORT).show();
            return cursor.getString(position);
        }
        return "";*/
        }catch (SQLiteException e){
            return null;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

     /*   db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME_1);
        onCreate(db);*/

    }
}
