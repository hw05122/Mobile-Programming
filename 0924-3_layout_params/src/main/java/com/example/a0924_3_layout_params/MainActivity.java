package com.example.a0924_3_layout_params;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button btnLeft, btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLeft = (Button)findViewById(R.id.btnLeft);
        btnRight = (Button)findViewById(R.id.btnRight);

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setParams(2,1);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setParams(1,2);
            }
        });
    }

    void setParams(int left, int right){
        LinearLayout.LayoutParams lParams = (LinearLayout.LayoutParams)btnLeft.getLayoutParams();
        lParams.weight = left;
        btnLeft.setLayoutParams(lParams);

        LinearLayout.LayoutParams rParams = (LinearLayout.LayoutParams)btnRight.getLayoutParams();
        rParams.weight = right;
        btnRight.setLayoutParams(rParams);
    }
}
