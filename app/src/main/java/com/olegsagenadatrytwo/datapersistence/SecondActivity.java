package com.olegsagenadatrytwo.datapersistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String MY_PREF_FILE = "mypref_fiel";
    private static final String TAG = "Life_SecondActivity";
    private TextView tvOne, tvTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG, "onCreate: ");

        tvOne = (TextView) findViewById(R.id.tvOne);
        tvTwo = (TextView) findViewById(R.id.tvTwo);

        SharedPreferences sharedPreferences2 = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
        String returnOne = sharedPreferences2.getString("value1", "default value one");
        String returnTwo = sharedPreferences2.getString("value2", "default value two");
        tvOne.setText(returnOne);
        tvTwo.setText(returnTwo);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
