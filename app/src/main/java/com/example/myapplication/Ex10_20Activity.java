package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ex10_20Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex10_20);
    }

    public void dial(View view){
        Uri uri = Uri.parse("tel:01071633863");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    public void map(View view){
        //https://www.google.co.kr/maps/
        Uri uri = Uri.parse("https://www.google.co.kr/maps?q=37.4811484,126.8581845");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void send(View view){
        //https://www.google.co.kr/maps/
        //Uri uri = Uri.parse("https://www.google.co.kr/maps?q=37.4811484,126.8581845");
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra("sms_body", "문자 가나요?");
        intent.setData(Uri.parse("smsto:"+Uri.encode("010-7163-3863")));
        startActivity(intent);
    }

    public void capture(View view){
        //https://www.google.co.kr/maps/
        //Uri uri = Uri.parse("https://www.google.co.kr/maps?q=37.4811484,126.8581845");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(intent);
    }
}
