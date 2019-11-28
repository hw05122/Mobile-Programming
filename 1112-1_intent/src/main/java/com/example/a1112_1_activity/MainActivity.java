package com.example.a1112_1_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = new Button(this);
        btn.setText("Main Activity");
        btn.setOnClickListener(this);
        setContentView(btn);
    }

    @Override
    public void onClick(View v) {
        if (v == btn) {
            //명시적 인텐트
            Intent intent = new Intent(this, SubActivity.class);
            intent.putExtra("data1", "young");
            intent.putExtra("data2", 100);
            startActivityForResult(intent, 10);

            //암묵적 인텐트
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("http:/www.yu.ac.kr"));
//            startActivity(intent);

            //암묵적 인텐트
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_GET_CONTENT);
//            intent.setType("image/*");
//            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 10 && resultCode == RESULT_OK) {
            String reData = data.getStringExtra("reData");
            Toast.makeText(this, reData, Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
