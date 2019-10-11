package com.example.a1008_2_context_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("컨텍스트 메뉴 예제");

        ll = (LinearLayout)findViewById(R.id.ll);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        registerForContextMenu(btn1);//컨텍스트 메뉴를 사용할 뷰 등록.
        registerForContextMenu(btn2);//롱 클릭하면 컨텍스트 메뉴 켤려고 한다.
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        if(v == btn1){
            menu.setHeaderTitle("배경색 변경");
            menuInflater.inflate(R.menu.menu1, menu);
        }

        if(v == btn2){
            menu.setHeaderTitle("버튼 변경");
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemRed:
                ll.setBackgroundColor(Color.RED);
                break;
            case R.id.itemGreen:
                ll.setBackgroundColor(Color.GREEN);
                break;
            case R.id.itemBlue:
                ll.setBackgroundColor(Color.BLUE);
                break;
            case R.id.itemRotate:
                btn2.setRotation(45);
                break;
            case R.id.itemDouble:
                btn2.setScaleX(2);
                break;
        }

        return super.onContextItemSelected(item);
    }
}
