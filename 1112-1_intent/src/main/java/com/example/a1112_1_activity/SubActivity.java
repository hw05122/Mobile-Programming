package com.example.a1112_1_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String data1 = intent.getStringExtra("data1");
        int data2 = intent.getIntExtra("data2", 0);

        btn = new Button(this);
        btn.setText(data1 + ":" + data2);
        btn.setOnClickListener(this);
        setContentView(btn);
    }

    @Override
    public void onClick(View v) {
        if (v == btn) {
            Intent intent = new Intent();
            intent.putExtra("reData", "hello");
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
