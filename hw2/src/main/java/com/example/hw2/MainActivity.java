package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3;
    TextView textFrame1, textFrame2;
    TableLayout tableFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        textFrame1 = (TextView)findViewById(R.id.textFrame1);
        textFrame2 = (TextView)findViewById(R.id.textFrame2);
        tableFrame = (TableLayout)findViewById(R.id.tableFrame);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    public void onClick(View view) {
        if(view == btn1){
            textFrame1.setVisibility(View.VISIBLE);
            textFrame2.setVisibility(View.INVISIBLE);
            tableFrame.setVisibility(View.INVISIBLE);
        }
        else if(view == btn2){
            textFrame1.setVisibility(View.INVISIBLE);
            textFrame2.setVisibility(View.VISIBLE);
            tableFrame.setVisibility(View.INVISIBLE);
        }
        else if(view == btn3){
            textFrame1.setVisibility(View.INVISIBLE);
            textFrame2.setVisibility(View.INVISIBLE);
            tableFrame.setVisibility(View.VISIBLE);
        }
    }
}
