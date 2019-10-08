package com.example.a1008_1_option;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        TextView tv = new TextView(this);
        tv.setText("메뉴를 누르세요!");
        setContentView(tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        //자바로 메뉴생성
        /*MenuItem item = menu.add(0,1,0,"짜장");//2번째꺼로 item구별
        item.setIcon(R.mipmap.ic_launcher).setAlphabeticShortcut('a');

        menu.add(0,2,0,"짬뽕").setIcon(R.mipmap.ic_launcher_round);

        SubMenu etc = menu.addSubMenu("기타");
        etc.add(0,3,0,"우동");
        etc.add(0,4,0,"만두");*/

        //xml로 메뉴생성
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //id를 번호로 줌
        /*if(id == 1){
            showToast("짜장면을 선택하셨습니다!");
        }
        else if(id == 2){
            showToast("짬뽕을 선택하셨습니다!");
        }
        else if(id == 3){
            showToast("우동을 선택하셨습니다!");
        }
        else if(id == 4){
            showToast("만두를 선택하셨습니다.");
        }*/

        //id를 지정해줌
        if(id == R.id.menu1){
            showToast("menu1");
        }
        else if(id == R.id.menu2){
            showToast("menu2");
        }
        else if(id == R.id.menu3){
            showToast("menu3");
        }

        return super.onOptionsItemSelected(item);
    }

    private void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}
