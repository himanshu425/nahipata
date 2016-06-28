package com.tcs.androidproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tcs.androidproject.Fragment.CCRadioFragment;

/**
 * Created by 1012711 on 6/28/2016.
 */
public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardViewHolder> {
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout, parent, false);

        return new CardViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(CardListAdapter.CardViewHolder holder, int position) {
        holder.cardNumber.setText(CCRadioFragment.cardList.get(position));

    }

    @Override
    public int getItemCount() {
        return CCRadioFragment.cardList.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public TextView cardNumber;
        public CardViewHolder(View itemView) {
            super(itemView);
            cardNumber = (TextView) itemView.findViewById(R.id.textView123);
        }
    }
}
