package com.example.a1203_2_battery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etBattery;
    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();

            if (action.equals(Intent.ACTION_BATTERY_CHANGED)) {
                int remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                etBattery.setText("현재 충전량 : " + remain + "%\n");

                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
                switch (plug){
                    case 0:
                        etBattery.append("전원 연결 : 안됨");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        etBattery.append("전원 연결 : 어댑터");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        etBattery.append("전원 연결 : USB");
                        break;
                        case BatteryManager.BATTERY_PLUGGED_WIRELESS:
                            etBattery.append("전원 연결 : 무선");
                            break;

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배터리 잔량 확인 앱");

        etBattery = (EditText) findViewById(R.id.etBattery);
    }

    protected void onResume(){
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br,intentFilter);

    }

}
