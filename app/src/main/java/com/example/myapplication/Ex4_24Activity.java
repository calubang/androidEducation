package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Ex4_24Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_24);
        //inflation 보여준다. 펼친다. 렌더링한다
        //xml 요소들을 객체화하고 화면에 전개한다.
        CheckBox cb_android = (CheckBox)findViewById(R.id.cb_android);
        CheckBox cb_apple = (CheckBox)findViewById(R.id.cb_apple);
        CheckBox cb_window = (CheckBox)findViewById(R.id.cb_window);

        MyCheckedChangeListener myListener = new MyCheckedChangeListener();
        //cb_android.setOnCheckedChangeListener(myListener);
        cb_apple.setOnCheckedChangeListener(myListener);
        cb_window.setOnCheckedChangeListener(myListener);

        RadioGroup rg_gender = (RadioGroup)findViewById(R.id.rg_gender);
        final RadioButton rb_female = (RadioButton)findViewById(R.id.rb_female);
        final RadioButton rb_male = (RadioButton)findViewById(R.id.rb_male);
        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb_female){
                    //female
                    Log.i("Ex4_24Activity", "선택 : " + rb_female.getText().toString());

                }else if(i == R.id.rb_male){
                    //male
                    Log.i("Ex4_24Activity", "선택 : " + rb_male.getText().toString());
                }
            }
        });


    }

    class MyCheckedChangeListener implements CompoundButton.OnCheckedChangeListener{
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Log.i("Ex4_24Activity", "checked: " + b + ", text : " + compoundButton.getText());
        }
    }
}
