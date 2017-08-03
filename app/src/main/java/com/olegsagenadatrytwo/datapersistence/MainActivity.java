package com.olegsagenadatrytwo.datapersistence;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String MY_PREF_FILE = "mypref_fiel";
    private static final String TAG = "Life_MainActivity";
    private EditText etOne;
    private EditText etTwo;
    private TextView tvOne;
    private TextView tvTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        etOne = (EditText) findViewById(R.id.etOne);
        etTwo = (EditText) findViewById(R.id.etTwo);

        tvOne = (TextView) findViewById(R.id.tvOne);
        tvTwo = (TextView) findViewById(R.id.tvTwo);
    }

    public void saveDataGetData(View view) {

        switch (view.getId()){
            case R.id.btnSaveData:
                String one = etOne.getText().toString();
                String two = etTwo.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("value1", one);
                editor.putString("value2", two);
                boolean success = editor.commit();
                if(success){
                    Toast.makeText(this, "Saving was successful", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Saving was not successful", Toast.LENGTH_SHORT).show();

                }

                break;
            case R.id.btnGetData:
                SharedPreferences sharedPreferences2 = getSharedPreferences(MY_PREF_FILE, Context.MODE_PRIVATE);
                String returnOne = sharedPreferences2.getString("value1", "default value one");
                String returnTwo = sharedPreferences2.getString("value2", "default value two");
                tvOne.setText(returnOne);
                tvTwo.setText(returnTwo);
                break;
            case R.id.goToAnotherActivity:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
        }

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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged: ");
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(this, "LandScape", Toast.LENGTH_SHORT).show();
            
        }

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "Portrait", Toast.LENGTH_SHORT).show();
        }


    }
}
