package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ex52Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex52);
    }

    public void btnNumClick(View view){
        Button btnNum = (Button)view;
        EditText input1 = (EditText)findViewById(R.id.et_first);
        EditText input2 = (EditText)findViewById(R.id.et_second);
        EditText targetEt = null;
        String num = btnNum.getText().toString();
        if(input1.isFocused()){
            //Log.i("btnNumClick", "focus : input1");
            targetEt = input1;
        }else if(input2.isFocused()){
            //Log.i("btnNumClick", "focus : input2");
            targetEt = input2;
        } else{
            Toast.makeText(this, "값을 입력할 곳을 선택하세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        String beforeText = targetEt.getText().toString();
        if(beforeText.equals("0") || beforeText.equals("")){
            Log.i("btnNumClick", "0임 현재 입력값 : " + beforeText);
            targetEt.setText(num);
        }else{
            Log.i("btnNumClick", "0 아님 현재 입력값 : " + beforeText);
            targetEt.setText(beforeText+num);
        }

    }

    public void btnCalcClick(View view){
        int id = view.getId();

        EditText etInput1 = (EditText)findViewById(R.id.et_first);
        EditText etInput2 = (EditText)findViewById(R.id.et_second);
        TextView textView = (TextView)findViewById(R.id.tv_calcResult);

        if(etInput1.getText().toString() == null || etInput1.getText().toString().length() == 0){
            etInput1.requestFocus();
            Toast.makeText(this, "값을 입력하세요.", Toast.LENGTH_LONG).show();
            return;
        }
        if(etInput2.getText().toString() == null || etInput2.getText().toString().length() == 0){
            etInput2.requestFocus();
            Toast.makeText(this, "값을 입력하세요.", Toast.LENGTH_LONG).show();
            return;
        }

        double input1 = Double.parseDouble(etInput1.getText().toString().trim());
        double input2 = Double.parseDouble(etInput2.getText().toString().trim());
        double result = 0.0;

        switch (id){
            case R.id.btn_p:
                result = input1 + input2;
                break;
            case R.id.btn_mi:
                result = input1 - input2;
                break;
            case R.id.btn_mul:
                result = input1 * input2;
                break;
            case R.id.btn_d:
                if(input2 == 0){
                    Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
                    return;
                }
                result = input1 / input2;
                break;
        }

        if(result == Math.ceil(result)){
            textView.setText("계산결과 : " + String.valueOf(new Double(result).intValue()));
        }else{
            textView.setText("계산결과 : " + String.valueOf(result));
        }
    }
}
