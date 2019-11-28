package com.example.a1015_1_adapterview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //java에서 데이터 생성(준비)
        ArrayList<String> al = new ArrayList<String>();
        al.add("이순신");
        al.add("김유신");
        al.add("강감찬");
        al.add("을지문덕");
        al.add("이순신");
        al.add("김유신");
        al.add("강감찬");
        al.add("을지문덕");
        al.add("이순신");
        al.add("김유신");
        al.add("강감찬");
        al.add("을지문덕");
        al.add("이순신");
        al.add("김유신");
        al.add("강감찬");
        al.add("을지문덕");
        //어댑터 준비
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,al);


        //xml에서 데이터 생성(준비)
        //리소스로 부터 어댑터생성

        //ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(this,R.array.country,android.R.layout.simple_list_item_single_choice);

        //어댑터뷰에 어댑터를 연결
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg;
                msg = "Selected Items is "+((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });

        list.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
    }
}
