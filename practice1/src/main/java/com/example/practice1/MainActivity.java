package com.example.practice1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMsg = (Button)findViewById(R.id.btnMsg);
        btnMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout rl = (RelativeLayout)View.inflate(MainActivity.this,R.layout.newmsg,null);
                LinearLayout ll = (LinearLayout)findViewById(R.id.ll);

                if(ll.getChildCount()%2==0){
                    rl.setBackgroundColor(Color.GRAY);
                }
                else{
                    rl.setBackgroundColor(Color.RED);
                }

                ll.addView(rl);

                final EditText et = (EditText)findViewById(R.id.et);
                final TextView tvContent = (TextView)rl.findViewById(R.id.tvContent);

                Button btnView = (Button)rl.findViewById(R.id.btnView);
                btnView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),tvContent.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                });

                Button btnModi = (Button)rl.findViewById(R.id.btnModi);
                btnModi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tvContent.setText(et.getText().toString());
                    }
                });

            }
        });
    }
}
