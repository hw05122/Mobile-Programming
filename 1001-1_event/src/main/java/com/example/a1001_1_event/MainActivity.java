package com.example.a1001_1_event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;
    float initX;//눌렸을 때 x좌표, 땠을 때 x좌표 차이
    double initTime;//back버튼 제한시간내에 다시 눌리면 종료

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper)findViewById(R.id.flipper);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {//generate -> override methods
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            initX = event.getRawX();
        }
        else if(event.getAction() == MotionEvent.ACTION_UP){
            float difX = initX - event.getRawX();

            if(difX > 30){// <------
                flipper.showNext();
            }
            else if(difX < -30){//------>
                flipper.showPrevious();
            }

            initX = 0;
        }

        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis() - initTime > 3000){//initTime 멤버변수라서 생성될 때 0으로 되어있다.
                Toast.makeText(this,"종료하려면 한 번 더 눌러주세요",Toast.LENGTH_SHORT).show();

                initTime = System.currentTimeMillis();
            }
            else{//back버튼 한 번 더 눌린 상태
                finish();
            }

            return true;
        }

        return false;
    }
}
