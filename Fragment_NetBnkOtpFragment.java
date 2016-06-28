package com.tcs.androidproject.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tcs.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NetBnkOtpFragment extends Fragment {


    public NetBnkOtpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_net_bnk_otp, container, false);
    }


}
