package com.example.singhnicershop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.singhnicershop.model.CardViewDesc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckoutActivity extends AppCompatActivity {
    private final double TVQ = 0.09975;
    private final double TPS = 0.05;
    private TextView textView;
    private static final String LOG_TAG = CheckoutActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        displayTotals();
    }

    /**
     * Method that sets the taxes, total, and final total for each TextView
     */
    public void displayTotals() {
        Intent intent = getIntent();
        double total = 0;
        int shippingCost = 0;
        ArrayList<String> cardValues = getIntent().getStringArrayListExtra("CardData");
        String choice = intent.getStringExtra("Choice");

        for (int i = 0; i < cardValues.size(); i++)
            total += Double.parseDouble(cardValues.get(i)) * Double.parseDouble(cardValues.get(++i));

        if (choice.equals("express ($50)"))
            shippingCost += 50;
        else if (choice.equals("regular ($10)"))
            shippingCost += 10;

        //References each view then sets the text to the calculations perfomed
        textView = findViewById(R.id.total_textView);
        textView.setText(textView.getText() + " " + String.format("%.2f", total + shippingCost));

        textView = findViewById(R.id.tvq_textView);
        textView.setText(textView.getText() + " " + String.format("%.2f", TVQ * total + shippingCost));

        textView = findViewById(R.id.tps_textView);
        textView.setText(textView.getText() + " " + String.format("%.2f", TPS * total + shippingCost));

        textView = findViewById(R.id.end_total_textView);
        textView.setText(textView.getText() + " " + String.format("%.2f", total + TVQ * total + TPS * total + shippingCost));
        Log.d(LOG_TAG, "displayingTotal");
    }
}