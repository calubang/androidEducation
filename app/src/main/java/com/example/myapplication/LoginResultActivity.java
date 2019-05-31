package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_result);

        String id = getIntent().getStringExtra("id");
        String password = getIntent().getStringExtra("password");

        TextView tv_id = (TextView)findViewById(R.id.tv_id);
        TextView tv_pass = (TextView)findViewById(R.id.tv_pass);

        tv_id.setText(id);
        tv_pass.setText(password);
    }

    public void close(View view){
        Intent intent = new Intent(this, MainActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("msg", getIntent().getStringExtra("id")+"님 환영합니다");
        startActivity(intent);
        finish();
    }
}
