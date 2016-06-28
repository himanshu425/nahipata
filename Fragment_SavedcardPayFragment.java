package com.tcs.androidproject.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.tcs.androidproject.CardListAdapter;
import com.tcs.androidproject.Datbase.DBHelper;
import com.tcs.androidproject.PaymentActivity;
import com.tcs.androidproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedcardPayFragment extends Fragment {


    RecyclerView.Adapter adapter;

    public SavedcardPayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_savedcard_pay, container, false);
        RecyclerView cardList= (RecyclerView)v.findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager layout= new LinearLayoutManager(PaymentActivity.mContext);
        cardList.setLayoutManager(layout);
        adapter = new CardListAdapter();
        cardList.setAdapter(adapter);

        prepareData();
        //String svdCard = dbHelper.getCardNumber(PaymentActivity.newString);

        return v;
    }
    void prepareData(){
        adapter.notifyDataSetChanged();
    }


}
