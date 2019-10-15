package com.example.a1015_3_calendar_time;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button btnStart, btnEnd;
    RadioButton rbCal, rbTime;
    CalendarView calendarView;
    TimePicker timePicker;
    TextView tvResult;

    int Year, Month, Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.chronometer);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());//0으로 초기화
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });
        btnEnd = (Button) findViewById(R.id.btnEnd);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setTextColor(Color.BLACK);

                String hour = Integer.toString(timePicker.getCurrentHour());
                String min = Integer.toString(timePicker.getCurrentMinute());
                String msg = Year + "년 " + Month + "월 " + Day + "일 " + hour + "시 " + min + "분 예약됨";
                tvResult.setText(msg);
            }
        });

        rbCal = (RadioButton) findViewById(R.id.rbCal);
        rbCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.INVISIBLE);
                calendarView.setVisibility(View.VISIBLE);
            }
        });
        rbTime = (RadioButton) findViewById(R.id.rbTime);
        rbTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker.setVisibility(View.VISIBLE);
                calendarView.setVisibility(View.INVISIBLE);
            }
        });

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setVisibility(View.INVISIBLE);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Year = year;
                Month = month + 1;//1월->0  12월->11
                Day = dayOfMonth;


            }
        });
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setVisibility(View.INVISIBLE);

        tvResult = (TextView) findViewById(R.id.tvResult);
    }
}
