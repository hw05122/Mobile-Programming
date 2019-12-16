package com.example.a1203_3_calllogex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    Button btnView;
    EditText etCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("전화 기록 앱");

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, MODE_PRIVATE);

        btnView = (Button) findViewById(R.id.btnView);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etCall.setText(getCallHistory());
            }
        });

        etCall = (EditText) findViewById(R.id.etCall);
    }

    public String getCallHistory() {
        String[] callSet = new String[] {CallLog.Calls.DATE, CallLog.Calls.TYPE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION};

        Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI, callSet, null, null, null);

        if (c == null) {
            return "통화 기록 없음";
        }

        StringBuffer callBuf = new StringBuffer();
        callBuf.append("\n날짜: 구분 : 전화번호 : 통화시간");
        c.moveToFirst();
        do {
            long callDate = c.getLong(0);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            String dateStr = dateFormat.format(callDate);
            callBuf.append(dateStr + " ");
            if (c.getInt(1) == CallLog.Calls.INCOMING_TYPE) {
                callBuf.append("착신 : ");
            } else {
                callBuf.append("발신 : ");
            }
            callBuf.append(c.getString(2));
            callBuf.append(c.getString(3));

            c.close();

            return callBuf.toString();
        } while (c.moveToNext());
    }
}
