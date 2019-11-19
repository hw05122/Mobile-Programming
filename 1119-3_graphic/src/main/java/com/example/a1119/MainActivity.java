package com.example.a1119;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphic(this));
    }

    private static class MyGraphic extends View{
        public MyGraphic(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setAntiAlias(true);//끝이 둥근
            paint.setColor(Color.GREEN);
            canvas.drawLine(10,10,300,10,paint);

            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(5);//굵기
            canvas.drawLine(10,30,300,30,paint);



            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);//가장 얇은 1pixel
            paint.setStyle(Paint.Style.FILL);//색깔채워서 만든다
            Rect rect1 = new Rect(10,50,10+100,50+100);//넓이,높이 쉽게 구분가능
            canvas.drawRect(rect1,paint);

            paint.setStyle(Paint.Style.STROKE);//선만 나온다, 채우지 않음
            Rect rect2 = new Rect(130,50,130+100,50+100);
            canvas.drawRect(rect2,paint);

            RectF rect3 = new RectF(250,50,250+100,50+100);//둥근 사각형그리기
            canvas.drawRoundRect(rect3,20,20,paint);



            canvas.drawCircle(60,220,50,paint);//원 그리기



            paint.setStrokeWidth(5);
            Path path1 = new Path();
            path1.moveTo(10,290);
            path1.lineTo(10+50,290+50);
            path1.lineTo(10+100,290);
            path1.lineTo(10+150,290+50);
            canvas.drawPath(path1,paint);

            paint.setStrokeWidth(0);
            paint.setTextSize(30);
            canvas.drawText("안드로이드",10,390,paint);
        }
    }
}
