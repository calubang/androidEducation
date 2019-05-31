package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Ex42Activity extends AppCompatActivity {

    public int clickedCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex42);
        //지역변수는 무명class 내에서 값을 변경할 수 없다.
        //final int clickedCnt = 0;

        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedCnt++;
                Context context = Ex42Activity.this;
                String text = String.valueOf(clickedCnt) + "회 클릭중";
                Toast.makeText(context, text, Toast.LENGTH_LONG).show();

                Button btn2 = (Button)findViewById(R.id.btn2);
                if(btn2.getVisibility() == View.GONE){
                    btn2.setVisibility(View.VISIBLE);
                }else{
                    btn2.setVisibility(View.GONE);
                }

            }
        });

    }
}
