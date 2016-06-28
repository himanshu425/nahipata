package com.tcs.androidproject.AsyncTask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.tcs.androidproject.Datbase.DBHelper;

/**
 * Created by 1012711 on 6/22/2016.
 */
public class NewCardAsyncTask extends AsyncTask <String,Void,Long> {

    Context mContext;
    DBHelper mDbHelper;
    String mCard ,mCardName ,NCardCVV;
    String mMobile;
    long mResult;

    public NewCardAsyncTask(Context context, String card, String cardName, String newCardCVV,String mobile, DBHelper dbHelper) {
        this.mContext = context;
        this.mCard = card;
        this.mCardName = cardName;
        this.NCardCVV = newCardCVV;
        this.mMobile = mobile;
        this.mDbHelper = dbHelper;
    }

    @Override
    protected Long doInBackground(String... params) {
        mResult = mDbHelper.insertCardData(mCard,mCardName,NCardCVV,mMobile);

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

