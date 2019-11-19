package com.example.a1119_1_txtfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button btnWrite, btnRead;

    //파일위치: View -> Tool Windows -> Device File Explorer -> data - > data -> 패키지명 ->files
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = (Button)findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{//파일은 try-catch필요
                    FileOutputStream fos = openFileOutput("data.txt",MODE_APPEND);
                    //PRIVATE 쓸 때마다 새로 쓰임
                    //APPEND 쓸 때마다 붙여짐

                    String str = "안드로이드 강의\n";
                    fos.write(str.getBytes());//파일은 바이트단위
                    fos.close();

                    Toast.makeText(getApplicationContext(),"쓰기완료",Toast.LENGTH_SHORT).show();
                }catch (IOException e){

                }
            }
        });

        btnRead = (Button)findViewById(R.id.btnRead);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream fis = openFileInput("data.txt");
                    byte[] txt = new byte[100];
                    fis.read(txt);

                    String str = new String(txt);

                    Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();

                    fis.close();
                }catch (IOException e){

                }
            }
        });
    }
}
