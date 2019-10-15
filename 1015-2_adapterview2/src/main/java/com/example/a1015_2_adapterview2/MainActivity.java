package com.example.a1015_2_adapterview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.list);

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();//두가지 데이터 쌍을 넣기 위해

        HashMap<String, String> map;
        map = new HashMap<String, String>();
        map.put("data1", "kkang");
        map.put("data2", "1000");

        list.add(map);

        map = new HashMap<String, String>();
        map.put("data1", "kim");
        map.put("data2", "2000");

        list.add(map);

        String[] arSt = {"data1", "data2"};
        SimpleAdapter sa = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,arSt,new int[]{android.R.id.text1,android.R.id.text2});
    
        lv.setAdapter(sa);
    }
}
