package com.example.a1119_1_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDBHelper myDBHelper;
    EditText etName, etNumber, etNameResult, etNumResult;
    Button btnInit, btnInsert, btnSelect;
    SQLiteDatabase sqlDB;
    Switch sw;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("데이터베이스 예제");

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnSelect = (Button) findViewById(R.id.btnSelect);

        etName = (EditText) findViewById(R.id.etName);
        etNumber = (EditText) findViewById(R.id.etNumber);
        etNameResult = (EditText) findViewById(R.id.etNameResult);
        etNumResult = (EditText) findViewById(R.id.etNumResult);

        sw = (Switch) findViewById(R.id.sw);
        final MediaPlayer mediaPlayer;
        mediaPlayer = MediaPlayer.create(this, R.raw.koreansong);
        mediaPlayer.setLooping(true);
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw.isChecked()) {
                    mediaPlayer.start();
                } else {
                    mediaPlayer.stop();
                }
            }
        });

        myDBHelper = new MyDBHelper(this);

        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myDBHelper.getWritableDatabase();
                myDBHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myDBHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ('" + etName.getText().toString() + "' ," + etNumber.getText().toString() + ");");
                sqlDB.close();

                Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();
            }
        });

        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myDBHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);
                String strName = "그룹이름" + "\r\n" + "----------" + "\r\n";
                String strNum = "인원" + "\r\n" + "----------" + "\r\n";

                while (cursor.moveToNext()) {
                    strName += cursor.getString(0) + "\r\n";
                    strNum += cursor.getString(1) + "\r\n";
                }

                etNameResult.setText(strName);
                etNumResult.setText(strNum);

                cursor.close();
                sqlDB.close();
            }
        });
    }

    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context) {
            super(context, "groupDB", null, 1);//디비생성
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE groupTBL (gName CHAR(20) PRIMARY KEY, gNumber INTEGER);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");//존재하면 테이블 삭제
            onCreate(db);
        }
    }
}
