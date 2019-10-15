package com.example.practice2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    RadioButton rbDate, rbTime;
    DatePicker datePicker;
    TimePicker timePicker;
    TextView tvResult;

    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);

                rbDate.setVisibility(View.VISIBLE);
                rbTime.setVisibility(View.VISIBLE);
            }
        });

        rbDate = (RadioButton)findViewById(R.id.rbDate);
        rbDate.setVisibility(View.INVISIBLE);
        rbDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }
        });
        rbTime = (RadioButton)findViewById(R.id.rbTime);
        rbTime.setVisibility(View.INVISIBLE);
        rbTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }
        });

        datePicker = (DatePicker)findViewById(R.id.datePicker);
        datePicker.setVisibility(View.INVISIBLE);
        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                selectYear = year;
                selectMonth = monthOfYear + 1;
                selectDay = dayOfMonth;
            }
        });
        timePicker = (TimePicker)findViewById(R.id.timePicker);
        timePicker.setVisibility(View.INVISIBLE);

        tvResult = (TextView)findViewById(R.id.tvResult);
        tvResult.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLACK);

                String hour = Integer.toString(timePicker.getCurrentHour());
                String min = Integer.toString(timePicker.getCurrentMinute());
                String msg = selectYear + "년 " + selectMonth + "월 " + selectDay + "일 " + hour + "시 " + min + "분 예약됨";
                tvResult.setText(msg);

                rbDate.setVisibility(View.INVISIBLE);
                rbTime.setVisibility(View.INVISIBLE);
                datePicker.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.INVISIBLE);

                return false;
            }
        });
    }
}
