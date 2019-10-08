package com.example.a0924_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll;
    Button btn;
    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout)findViewById(R.id.ll);
        btn = (Button)findViewById(R.id.btn);
        tv = (TextView)findViewById(R.id.tv);
        et = (EditText)findViewById(R.id.et);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll.setOrientation(LinearLayout.HORIZONTAL);
                tv.setText("버튼눌림");
                et.setBackgroundColor(0xffff0000);//0xff 투명도
            }
        });
    }
}
