package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class InflationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflation);

        final LinearLayout root = (LinearLayout)findViewById(R.id.root);
        Button btn_showCheck = (Button)findViewById(R.id.btn_showCheck);


        btn_showCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //부분 XML 전개
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.activity_sub_1, root, true);

            }
        });

        Button btn_removeCheck = (Button)findViewById(R.id.btn_removeCheck);

        btn_removeCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //View 제거
                root.removeView((View)findViewById(R.id.sub_1));
            }
        });

    }
}
