package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Ex10_2ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_2_result);
        final Intent intent = getIntent();
        String movieName = intent.getStringExtra("moviename");
        float movieRating = intent.getFloatExtra("movierating", 0);
        TextView tv_movieName = (TextView) findViewById(R.id.tv_movieName);
        tv_movieName.setText(movieName);
        TextView tv_movieScoreInfo = (TextView)findViewById(R.id.tv_movieScoreInfo);
        tv_movieScoreInfo.setText(String.valueOf(movieRating)+"점을 주셨습니다.");

        ((Button)findViewById(R.id.btn_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(Ex10_2ResultActivity.this, Ex10_2Activity.class);
                intent.putExtra("scoreavg", 4.3F);
                setResult(RESULT_OK, intent);
                Ex10_2ResultActivity.this.finish();
            }
        });
    }
}
