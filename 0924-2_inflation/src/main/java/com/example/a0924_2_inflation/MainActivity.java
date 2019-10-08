package com.example.a0924_2_inflation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMsg = (Button)findViewById(R.id.btnMsg);
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
                RelativeLayout rl = (RelativeLayout)View.inflate(MainActivity.this,R.layout.newlist,null);
                                                                    //this는 OnClickListener 객체를 참조
                if(ll.getChildCount()%2 == 0){
                    rl.setBackgroundColor(Color.GRAY);
                }
                else{
                    rl.setBackgroundColor(Color.RED);
                }

                ll.addView(rl);
            }
        });
    }
}
