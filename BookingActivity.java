package com.tcs.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tcs.androidproject.AsyncTask.UserDetailAsyncTask;
import com.tcs.androidproject.Datbase.DBHelper;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnPay;
    DBHelper dbHelper;
    EditText editTxtName;
    EditText editTxtMobile;
    EditText editTxtRoom;
    EditText editTxtAmount;

    String regex = "[a-z]";
    String mPattern = "[0-9]{10}";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

    /*    toolbar = (Toolbar)findViewById(R.id.toolbar);
        getSupportActionBar();*/
        dbHelper = new DBHelper(this);
        editTxtName = (EditText)findViewById(R.id.editTxtName);
        editTxtMobile = (EditText)findViewById(R.id.editTxtMobile);
        editTxtRoom = (EditText)findViewById(R.id.editTxtNoRooms);
        editTxtAmount = (EditText)findViewById(R.id.editTxtAmount);
        btnPay = (Button)findViewById(R.id.btnProceed);

        btnPay.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        String mName = editTxtName.getText().toString();
        String mMobile = editTxtMobile.getText().toString();
        String mRooms = editTxtRoom.getText().toString();
        String mAmount = editTxtAmount.getText().toString();

        if(mName.trim().length()==0){
            Toast.makeText(BookingActivity.this, "Name Cannot be Empty", Toast.LENGTH_SHORT).show();
        }
    /*    else if (!mName.matches("[a-z]")){
            Toast.makeText(MakePaymentActivity.this, "Invalid Name", Toast.LENGTH_SHORT).show();
        }*/
        else if(!mMobile.matches(mPattern)){
            Toast.makeText(BookingActivity.this, "Invalid Mobile No.", Toast.LENGTH_SHORT).show();
        }
        else if(mRooms.equals("0")){
            Toast.makeText(BookingActivity.this, "Please enter valid room no", Toast.LENGTH_SHORT).show();

        }else{
            new UserDetailAsyncTask(BookingActivity.this,mName,mMobile,mRooms, " null ",mAmount,dbHelper).execute();


            Intent intent = new Intent(this,PaymentActivity.class);
            intent.putExtra("MOBILE_NO",mMobile);
            startActivity(intent);

            finish();
        }

    }
}
