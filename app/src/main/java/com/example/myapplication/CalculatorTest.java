package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CalculatorTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_test);

    }

    public void btnClick(View view){
        int viewId = view.getId();
        Log.i("CalculatorTest", "지금 클릭한 view객체의 id : " + viewId);
        if(viewId == R.id.btn_plus){
            Log.i("CalculatorTest", "지금 클릭한 객체는 plus");
        }

        Log.i("CalculatorTest", "root : " + view.getRootView().getContext());
        EditText etInput1 = (EditText)findViewById(R.id.et_input1);
        EditText etInput2 = (EditText)findViewById(R.id.et_input2);
        TextView textView = (TextView)findViewById(R.id.tv_result);
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
        int id = view.getId();


        switch (id){
            case R.id.btn_plus:
                result = input1 + input2;
                break;
            case R.id.btn_minus:
                result = input1 - input2;
                break;
            case R.id.btn_multi:
                result = input1 * input2;
                break;
            case R.id.btn_divi:
                if(input2 == 0){
                    Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
                    return;
                }
                result = input1 / input2;
                break;
            case R.id.btn_remainder:
                if(input2 == 0){
                    Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_LONG).show();
                    return;
                }
                result = input1 % input2;
                break;
        }
        Log.i("계산기", result + "//" + Math.ceil(result));
        Log.i("계산기", (result == Math.ceil(result)) + "");
        Log.i("계산기", new Double(result).intValue() + "//" + result);
        if(result == Math.ceil(result)){
            textView.setText("계산결과 : " + String.valueOf(new Double(result).intValue()));
        }else{
            textView.setText("계산결과 : " + String.valueOf(result));
        }

    }
}
