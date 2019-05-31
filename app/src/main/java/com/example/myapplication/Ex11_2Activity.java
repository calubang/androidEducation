package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Ex11_2Activity extends AppCompatActivity {
    String[] arr = {"아메리카노", "아이스아메", "라떼", "치즈케잌"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex11_2);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, arr);
        final ListView lv_first = (ListView) findViewById(R.id.lv_firstListView);
        lv_first.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv_first.setAdapter(adapter);
        lv_first.setItemChecked(1, true);

        lv_first.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int index, long l) {
                //i 가 index
                //lv_first.getItemAtPosition(index);
                lv_first.setItemChecked(index, true);
                adapter.notifyDataSetChanged();
                Toast.makeText(Ex11_2Activity.this, arr[index] + "를 클릭하셨습니다.", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }
}
