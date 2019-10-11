package com.example.singhnicershop;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.singhnicershop.model.CardViewDesc;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private LayoutInflater mInflater;
    private LinkedList<CardViewDesc> mWordList;

    public ProductAdapter(Context context, LinkedList<CardViewDesc> wordList) {
        this.mInflater = mInflater;
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        public final CardView cardView;
        final ProductAdapter mAdapter;

        public ProductViewHolder(@NonNull View itemView, ProductAdapter adapter) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview_template);
            this.mAdapter = adapter;
        }
    }
}
