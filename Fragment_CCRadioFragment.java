package com.tcs.androidproject.Fragment;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;


import com.tcs.androidproject.Datbase.DBHelper;
import com.tcs.androidproject.PaymentActivity;
import com.tcs.androidproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CCRadioFragment extends Fragment implements View.OnClickListener {


    DBHelper dbHelper;
    RadioButton radioBtnNewCard;
    RadioButton radioBtnsavedCard;
    public static List<String> cardList;

    private  Cursor cards;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;

    public CCRadioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ccradio, container, false);

        radioBtnNewCard = (RadioButton)v.findViewById(R.id.radioBtnNewCard);
        radioBtnsavedCard = (RadioButton)v.findViewById(R.id.radioBtnSavedCard);
        radioBtnNewCard.setOnClickListener(this);
        radioBtnsavedCard.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch(id){
            case R.id.radioBtnNewCard:
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragment = new NewCardDetailFragment();
                fragmentTransaction.replace(R.id.fLayout1,fragment).commit();

                break;
            case R.id.radioBtnSavedCard:
                dbHelper=new DBHelper(PaymentActivity.mContext);
                cards = dbHelper.getCardNumber();
                cardList=new ArrayList<>();
                if(cards!=null){
                    cards.moveToFirst();
                    while (cards.moveToNext()){
                        if(PaymentActivity.newString.equals(cards.getString(0))){
                             cardList.add(cards.getString(1));
                        }
                    }
                }

                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragment = new SavedcardPayFragment();
                fragmentTransaction.replace(R.id.fLayout2,fragment).commit();
                break;

        }

    }
}
