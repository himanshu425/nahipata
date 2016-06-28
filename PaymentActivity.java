package com.tcs.androidproject;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.tcs.androidproject.AsyncTask.NewCardAsyncTask;
import com.tcs.androidproject.Datbase.DBHelper;
import com.tcs.androidproject.Fragment.CCRadioFragment;
import com.tcs.androidproject.Fragment.NetBankngPayFragment;
import com.tcs.androidproject.Interface.CallBackNotify;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener,CallBackNotify{

    public  static Context mContext;
    DBHelper dbHelper;
    Button btnCreditCard;

    public static String newString;
    Button  btnNetBanking;

    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        dbHelper =new DBHelper(this);
        mContext=getApplicationContext();
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.ic_back_arrow);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("MOBILE_NO");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("MOBILE_NO");
        }

        Toast.makeText(PaymentActivity.this, newString, Toast.LENGTH_SHORT).show();


        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent i = new Intent(PaymentActivity.this, BookingActivity.class);
                startActivity(i);
                finish();

            }
        });


        btnCreditCard = (Button)findViewById(R.id.btnCreditCard);
        btnNetBanking = (Button)findViewById(R.id.btnNetBanking);

        btnCreditCard.setOnClickListener(this);
        btnNetBanking.setOnClickListener(this);
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch(id){
            case R.id.btnCreditCard:
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = new CCRadioFragment();
                fragmentTransaction.replace(R.id.fLayout1,fragment).commit();
                break;
            case R.id.btnNetBanking:
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                Fragment fragment1 = new NetBankngPayFragment();
                fragmentTransaction1.replace(R.id.fLayout1,fragment1).commit();
        }



    }

    @Override
    public void onCallBack() {

        int randomPIN =(int)(Math.random()*9000)+1000;

        String PinString = String.valueOf(randomPIN);

        showNotification(PinString);

    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void showNotification(String message){

        Notification noti = new Notification.Builder(this)
                .setContentTitle("One Time Password")
                .setContentText(message)
                .setSmallIcon(R.drawable.noti)
                .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }

    @Override
    public void onCallBackCard(String a, String b, String c,String d) {

        new NewCardAsyncTask(PaymentActivity.this,a,b,c,d,dbHelper).execute();

    }



}
