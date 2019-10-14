// Student name: Upkar Singh
// Student ID: 1295545

package com.example.singhnicershop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Creates an intent to change to the MenuActivity
     *
     * @param view the button being clicked
     */
    public void launchMenuActivity(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        Log.d(LOG_TAG, "launchCheckoutActivity");
        startActivity(intent);
    }
}