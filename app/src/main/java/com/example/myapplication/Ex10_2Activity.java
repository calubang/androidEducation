package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Ex10_2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_2);

        Button btn_movieScore = (Button)findViewById(R.id.btn_movieScore);
        btn_movieScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RatingBar ratingBar = (RatingBar) findViewById(R.id.rbar_movieScore);
                float movieRating = ratingBar.getRating();
                String movieName = ((TextView)findViewById(R.id.tv_movieName)).getText().toString();
                Intent intent = new Intent(Ex10_2Activity.this, Ex10_2ResultActivity.class);
                intent.putExtra("moviename", movieName);
                intent.putExtra("movierating", movieRating);
                //startActivity(intent);
                startActivityForResult(intent, 0);
                //Toast.makeText(Ex10_2Activity.this, "별점 : " + movieRating, Toast.LENGTH_LONG).show();
            }
        });

        Button button = (Button)findViewById(R.id.btn_close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ex10_2Activity.this.finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //Log.i("onActivityResult", "보내준 값은 : " + requestCode);
        if(resultCode == RESULT_OK){
            float scoreAvg = data.getFloatExtra("scoreavg", 0);
            Toast.makeText(this, "영화 평점은 " + scoreAvg + "입니다.", Toast.LENGTH_LONG).show();
        }
    }
}
