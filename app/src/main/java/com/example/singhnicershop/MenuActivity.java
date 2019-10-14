package com.example.singhnicershop;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.singhnicershop.model.CardViewDesc;

import java.util.ArrayList;
import java.util.LinkedList;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ProductAdapter mAdapter;
    private LinkedList<CardViewDesc> mCardData = new LinkedList<>();
    private final String objectName = "object";
    private final String[] OPTIONS = new String[]{"express ($50)", "regular ($10)",
            "no hurry (no cost)"};
    public static final String EXTRA_MESSAGE =
            "com.example.android.singhnicershop.extra.MESSAGE";
    private String choice = OPTIONS[0];
    private static final String LOG_TAG = MenuActivity.class.getSimpleName();
    private boolean priceChanged;

    /**
     * Creates the activity and allows the user to choose from three options for shipping.
     * When pressing the FAB an alert appears for the shipping options and allows the user
     * to checkout or cancel to dismiss the dialog box.
     *
     * @param savedInstanceState contains all the values
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder optionsAlert = new AlertDialog.Builder(MenuActivity.this);
                optionsAlert.setTitle("Shipping options");
                optionsAlert.setSingleChoiceItems(OPTIONS, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(LOG_TAG, "FAB clicked");
                        choice = OPTIONS[i];
                        Toast.makeText(MenuActivity.this, OPTIONS[i] + " selected",
                                Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("Checkout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int total = 0;

                        for (int k = 0; k < mCardData.size(); k++)
                            total += Integer.parseInt(mCardData.get(k).getQuantity());

                        if (total > 0) {
                            Intent intent = new Intent(MenuActivity.this, CheckoutActivity.class);
                            intent.putExtra("Choice", choice);
                            ArrayList<String> valuesList = new ArrayList<>();

                            for (int j = 0; j < mCardData.size(); j++) {
                                valuesList.add(mCardData.get(j).getPrice());
                                valuesList.add(mCardData.get(j).getQuantity());
                            }
                            intent.putExtra("CardData", valuesList);
                            startActivity(intent);
                        } else
                            Toast.makeText(MenuActivity.this, "Can not checkout " +
                                    "without having at least 1 item in the cart", Toast.LENGTH_SHORT).show();
                        Log.d(LOG_TAG, "checkout clicked");
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Log.d(LOG_TAG, "Cancel clicked");
                    }
                });
                optionsAlert.show();
            }
        });

        CardViewDesc cvd1 = new CardViewDesc(getResources().getString(R.string.watermelon_title), getResources().getString(R.string.product1_description), getResources().getString(R.string.price1), R.drawable.watermelon, getResources().getString(R.string.initial_quantity1), getResources().getString(R.string.subtotal_price3));
        CardViewDesc cvd2 = new CardViewDesc(getResources().getString(R.string.coconut_title), getResources().getString(R.string.product2_description), getResources().getString(R.string.price2), R.drawable.coconut, getResources().getString(R.string.initial_quantity2), getResources().getString(R.string.subtotal_price2));
        CardViewDesc cvd3 = new CardViewDesc(getResources().getString(R.string.apple_title), getResources().getString(R.string.product3_description), getResources().getString(R.string.price3), R.drawable.apple, getResources().getString(R.string.initial_quantity3), getResources().getString(R.string.subtotal_price1));
        CardViewDesc cvd4 = new CardViewDesc(getResources().getString(R.string.watermelon_title), getResources().getString(R.string.product1_description), getResources().getString(R.string.price1), R.drawable.watermelon, getResources().getString(R.string.initial_quantity1), getResources().getString(R.string.subtotal_price3));
        CardViewDesc cvd5 = new CardViewDesc(getResources().getString(R.string.coconut_title), getResources().getString(R.string.product2_description), getResources().getString(R.string.price2), R.drawable.coconut, getResources().getString(R.string.initial_quantity2), getResources().getString(R.string.subtotal_price2));
        CardViewDesc cvd6 = new CardViewDesc(getResources().getString(R.string.apple_title), getResources().getString(R.string.product3_description), getResources().getString(R.string.price3), R.drawable.apple, getResources().getString(R.string.initial_quantity3), getResources().getString(R.string.subtotal_price1));
        CardViewDesc cvd7 = new CardViewDesc(getResources().getString(R.string.watermelon_title), getResources().getString(R.string.product1_description), getResources().getString(R.string.price1), R.drawable.watermelon, getResources().getString(R.string.initial_quantity1), getResources().getString(R.string.subtotal_price3));
        CardViewDesc cvd8 = new CardViewDesc(getResources().getString(R.string.coconut_title), getResources().getString(R.string.product2_description), getResources().getString(R.string.price2), R.drawable.coconut, getResources().getString(R.string.initial_quantity2), getResources().getString(R.string.subtotal_price2));
        CardViewDesc cvd9 = new CardViewDesc(getResources().getString(R.string.apple_title), getResources().getString(R.string.product3_description), getResources().getString(R.string.price3), R.drawable.apple, getResources().getString(R.string.initial_quantity3), getResources().getString(R.string.subtotal_price1));
        CardViewDesc cvd10 = new CardViewDesc(getResources().getString(R.string.watermelon_title), getResources().getString(R.string.product1_description), getResources().getString(R.string.price1), R.drawable.watermelon, getResources().getString(R.string.initial_quantity1), getResources().getString(R.string.subtotal_price3));

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

    /**
     * Stores all values in an ArrayList and stores inside the bundle
     *
     * @param savedInstanceState the object containing the items values
     */
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        ArrayList<String> test = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            test.add(mCardData.get(i).getQuantity());
            test.add(mCardData.get(i).getSubtotal());
        }
        savedInstanceState.putStringArrayList("Array", test);
        Log.d(LOG_TAG, "Changing orientation");
    }

    /**
     * Sends all respective values to each object when orientation is changed
     *
     * @param savedInstanceState the object containing the ArrayList
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> list = savedInstanceState.getStringArrayList("Array");

        for (int i = 0, j = 0; i < list.size(); i++, j += 2) {
            mCardData.get(i).setQuantity(list.get(j));
        }
        for (int i = 0, j = 1; i < list.size(); i++, j += 2) {
            mCardData.get(i).setSubtotal(list.get(j));
        }
        Log.d(LOG_TAG, "Restoring values");
    }

    /**
     * Inflates the menu, and adds items to the action bar if it is present.
     *
     * @param menu Menu to inflate.
     * @return Returns true if the menu inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content_menu, menu);
        Log.d(LOG_TAG, "creating menu");
        return true;
    }

    /**
     * Handles app bar item clicks.
     *
     * @param item Item clicked.
     * @return True if one of the defined items was clicked.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_size_large:
                if (priceChanged == false) {
                    for (int i = 0; i < mCardData.size(); i++)
                        mCardData.get(i).setPrice(String.format("%.2f", Double.parseDouble(mCardData.get(i).getPrice()) * 2));
                    priceChanged = true;
                }
                break;
            case R.id.action_size_normal:
                if (priceChanged == true) {
                    for (int i = 0; i < mCardData.size(); i++)
                        mCardData.get(i).setPrice(String.format("%.2f", Double.parseDouble(mCardData.get(i).getPrice()) / 2));
                    priceChanged = false;
                }
                break;
        }
        Log.d(LOG_TAG, "clicking menu item");
        return super.onOptionsItemSelected(item);
    }
}


