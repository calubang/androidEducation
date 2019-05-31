package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.media.ExifInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    HashMap<Integer, Class> activityMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMap.put(R.id.btn_ex42, Ex42Activity.class);
        activityMap.put(R.id.btn_calcu, CalculatorTest.class);
        activityMap.put(R.id.btn_ex24, Ex4_24Activity.class);
        activityMap.put(R.id.btn_ex51, Ex51Activity.class);
        activityMap.put(R.id.btn_exInfl, InflationActivity.class);
        activityMap.put(R.id.btn_newActivity, NewActivity.class);
        activityMap.put(R.id.btn_ex52, Ex52Activity.class);
        activityMap.put(R.id.btn_movieStar, Ex10_2Activity.class);
        activityMap.put(R.id.btn_intent, Ex10_20Activity.class);
        activityMap.put(R.id.btn_lifeCycle, Ex10_3Activity.class);
        activityMap.put(R.id.btn_loginMenu, LoginActivity.class);
        activityMap.put(R.id.btn_callCompAc, CallComponentActivity.class);
        activityMap.put(R.id.btn_adapterAc, Ex11_2Activity.class);
        activityMap.put(R.id.btn_customListAc, CustomListViewActivity.class);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void btClick(View view){
        Intent intent = null;
        intent = new Intent(this, activityMap.get((Integer) view.getId()));
        startActivity(intent);

    }
}
