package com.example.singhnicershop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.singhnicershop.model.CardViewDesc;

import java.util.ArrayList;
import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private LinkedList<CardViewDesc> mCardData = new LinkedList<>();
    private final String objectName = "object";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        CardViewDesc cvd1 = new CardViewDesc(getResources().getString(R.string.watermelon_title), getResources().getString(R.string.product1_description), getResources().getString(R.string.price1), R.drawable.watermelon, getResources().getString(R.string.initial_quantity1), getResources().getString(R.string.subtotal_price3));
        CardViewDesc cvd2 = new CardViewDesc(getResources().getString(R.string.coconut_title), getResources().getString(R.string.product2_description), getResources().getString(R.string.price2), R.drawable.coconut, getResources().getString(R.string.initial_quantity2), getResources().getString(R.string.subtotal_price2));
        CardViewDesc cvd3 = new CardViewDesc(getResources().getString(R.string.apple_title), getResources().getString(R.string.product3_description), getResources().getString(R.string.price3), R.drawable.apple, getResources().getString(R.string.initial_quantity3), getResources().getString(R.string.subtotal_price1));

        mCardData.add(cvd1);
        mCardData.add(cvd2);
        mCardData.add(cvd3);

        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerView);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ProductAdapter(this, mCardData);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        ArrayList<String> test = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            test.add(mCardData.get(i).getQuantity());
            test.add(mCardData.get(i).getSubtotal());
        }
        Log.d("g", test.get(0));
        savedInstanceState.putStringArrayList("Array", test);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> list = savedInstanceState.getStringArrayList("Array");

        Log.d("Checker", list.get(0));
        for (int i = 0, j = 0; i < 3; i++, j+= 2){
                mCardData.get(i).setQuantity(list.get(j));
        }
        for (int i = 0, j = 1; i < 3; i++, j+=  2) {
            mCardData.get(i).setSubtotal(list.get(j));
        }
    }
}

