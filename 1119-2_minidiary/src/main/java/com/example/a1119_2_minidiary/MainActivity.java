package com.example.a1119_2_minidiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    DatePicker datePicker;
    EditText etContent;
    Button btnSave;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 일기장");

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + Integer.toString(monthOfYear) + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                etContent.setText(str);

                btnSave.setEnabled(true);
            }
        });

        etContent = (EditText) findViewById(R.id.etContent);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream fos = openFileOutput(fileName,MODE_PRIVATE);
                    String str = etContent.getText().toString();
                    fos.write(str.getBytes());

                    Toast.makeText(getApplicationContext(),fileName+"이 저장됨",Toast.LENGTH_SHORT).show();
                }catch (IOException e){

                }
            }
        });
    }

    private String readDiary(String fileName){
        String diaryStr = null;
        FileInputStream fis;

        try{
            fis = openFileInput(fileName);
            byte[] txt = new byte[512];
            fis.read(txt);
            fis.close();

            diaryStr = (new String(txt)).trim();

            btnSave.setText("수정하기");
        }catch (IOException e){
            etContent.setHint("일기가 존재하지 않습니다.");
            btnSave.setText("저장");//파일없어서 수정불가능 하기 때문
        }

        return diaryStr;
    }
}
