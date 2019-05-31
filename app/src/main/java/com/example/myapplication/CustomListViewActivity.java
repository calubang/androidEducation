package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.kitri.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class CustomListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        //데이터 세팅
        List<Product> data = dataSetting();

        //디자인 세팅
        //Custom ListView 를 넣을 Layout 찾기
        LinearLayout layout = (LinearLayout)findViewById(R.id.list);
        //새로 만든 MyAdapter 생성
        MyAdapter adapter = new MyAdapter(this, data);
        //새로 만든 ListView 생성
        MyListView view = new MyListView(this);
        //view와 adapter 연결
        view.setAdapter(adapter);
        //Layout에 자신의 view를 넣기
        layout.addView(view);
    }

    public List<Product> dataSetting(){
        List<Product> list = new ArrayList<>();
        Product p1 = new Product();
        p1.setProd_no("001");
        p1.setProd_name("아메리카노우");
        p1.setProd_price(2500);
        p1.setProd_detail("가성비 좋은 아메리카노");

        Product p2 = new Product();
        p2.setProd_no("002");
        p2.setProd_name("카페라떼");
        p2.setProd_price(3000);
        p2.setProd_detail("몸에 좋은 카페라떼");

        Product p3 = new Product();
        p3.setProd_no("003");
        p3.setProd_name("카페베네");
        p3.setProd_price(3000);
        p3.setProd_detail("커즈 욘 마이 걸");

        Product p4 = new Product();
        p4.setProd_no("004");
        p4.setProd_name("밀크티");
        p4.setProd_price(1500);
        p4.setProd_detail("흑당 밀크티");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        return list;
    }
}
