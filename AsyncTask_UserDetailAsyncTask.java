package com.tcs.androidproject.AsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.tcs.androidproject.Datbase.DBHelper;

/**
 * Created by 1012711 on 6/23/2016.
 */
public class UserDetailAsyncTask extends AsyncTask<String,Void,Long> {

    Context mContext;
    String mName,mMobileNo, mNoOfRooms , mHotelName , mAmountPaid;
    DBHelper mDbHelper;
    long mResult;

    public UserDetailAsyncTask(Context context, String name, String mobileNo, String noOfRooms, String hotelName, String amountPaid, DBHelper dbHelper) {
        this.mContext = context;
        this.mName = name;
        this.mMobileNo = mobileNo;
        this.mNoOfRooms = noOfRooms;
        this.mHotelName = hotelName;
        this.mAmountPaid = amountPaid;
        this.mDbHelper = dbHelper;
    }

    @Override
    protected Long doInBackground(String... params) {
        mResult = mDbHelper.insertData(mName,mMobileNo,mNoOfRooms,mHotelName,mAmountPaid);
        return mResult;

    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);

        if(aLong==-1)
        {
            Toast.makeText(mContext, "Data not Inserted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(mContext, "Data Inserted", Toast.LENGTH_SHORT).show();
        }

    }
}
