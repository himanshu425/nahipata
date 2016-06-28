package com.tcs.androidproject.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tcs.androidproject.Interface.CallBackNotify;
import com.tcs.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NetBankngPayFragment extends Fragment implements View.OnClickListener {


    Button btnOTP;
    Context mContext;
    CallBackNotify callBackNotify;


    public NetBankngPayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v =  inflater.inflate(R.layout.fragment_net_bankng_pay, container, false);

        btnOTP = (Button)v.findViewById(R.id.btnProceedPay);
        btnOTP.setOnClickListener(this);

        return  v;

    }


    @Override
    public void onClick(View v) {

        callBackNotify.onCallBack();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new NetBnkOtpFragment();
        fragmentTransaction.replace(R.id.fLayout1,fragment).commit();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext =context;
        callBackNotify=(CallBackNotify)context;
    }
}
