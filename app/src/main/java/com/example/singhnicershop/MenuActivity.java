package com.example.singhnicershop;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.singhnicershop.model.CardViewDesc;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        CardViewDesc cvd1 = new CardViewDesc(getResources().getString(R.string.watermelon_title), getResources().getString(R.string.product1_description), getResources().getString(R.string.price1), R.drawable.watermelon, getResources().getString(R.string.initial_quantity1));
        CardViewDesc cvd2 = new CardViewDesc(getResources().getString(R.string.coconut_title), getResources().getString(R.string.product2_description), getResources().getString(R.string.price2), R.drawable.coconut, getResources().getString(R.string.initial_quantity2));
        CardViewDesc cvd3 = new CardViewDesc(getResources().getString(R.string.apple_title), getResources().getString(R.string.product3_description), getResources().getString(R.string.price3), R.drawable.apple, getResources().getString(R.string.initial_quantity3));

    }

}
