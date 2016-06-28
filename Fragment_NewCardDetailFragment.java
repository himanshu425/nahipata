package com.tcs.androidproject.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tcs.androidproject.Interface.CallBackNotify;
import com.tcs.androidproject.PaymentActivity;
import com.tcs.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewCardDetailFragment extends Fragment implements View.OnClickListener {


    EditText editTxtCardNo;
    EditText editTxtNameCard;
    EditText editTxtCVV;
    Context mContext;
    Button btnNewPay;
    CallBackNotify callBackNotify;


    public NewCardDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_card_detail, container, false);

        btnNewPay =(Button)v.findViewById(R.id.btnPayNwCard);
        editTxtCardNo = (EditText)v.findViewById(R.id.editTxtCardNo);
        editTxtNameCard = (EditText)v.findViewById(R.id.editTxtNameCard);
        editTxtCVV = (EditText)v.findViewById(R.id.editTxtCvv);
        btnNewPay.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {

        String mCardNo = editTxtCardNo.getText().toString();
        String mNameOnCard = editTxtNameCard.getText().toString();
        String mCVV = editTxtCVV.getText().toString();


        callBackNotify.onCallBackCard(mCardNo, mNameOnCard, mCVV,PaymentActivity.newString);
    }

    @Override
    public void onAttach(Context context) {
        mContext =context;
        callBackNotify=(CallBackNotify)context;
        super.onAttach(context);
    }
}
