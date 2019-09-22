package com.example.a0917_2_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.edit1);
        edit2 = (EditText)findViewById(R.id.edit2);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnMul = (Button)findViewById(R.id.btnMul);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        textResult = (TextView)findViewById(R.id.textResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    public void onClick(View view) {
        int result=0;
        int num1 =Integer.parseInt(edit1.getText().toString());
        int num2 = Integer.parseInt(edit2.getText().toString());

        if(view == btnAdd){
            result = num1 + num2;
        }
        else if(view == btnSub){
            result = num1 - num2;
        }
        else if(view == btnMul){
            result = num1 * num2;
        }
        else if(view == btnDiv){
            result = num1 / num2;
        }

        textResult.setText("계산결과 : " + result);
    }
}
