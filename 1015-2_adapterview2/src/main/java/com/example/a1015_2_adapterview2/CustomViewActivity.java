package com.example.a1015_2_adapterview2;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomViewActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<User> list = new ArrayList<User>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.name = "park" + i;
            user.phone = "010-" + i + "" + i + "" + i + "" + i;
            list.add(user);//Adyapter
        }

        MyAdapter myAdapter = new MyAdapter(this,R.layout.activity_custom_view,list);
        setListAdapter(myAdapter);
    }

    //vo클래스 (value-object) 값 표현을 위해 사용됨
    class User {
        String name;
        String phone;
    }

    class MyAdapter extends ArrayAdapter<User> {
        Context context;
        int resId;
        ArrayList<User> list;

        public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<User> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resId = resource;
            this.list = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {//처음으로 만들려고 할 때
                //inflater, xml을 객체화 시키는것
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(resId, null);
            }

            TextView nameView = (TextView)convertView.findViewById(R.id.tv1);
            TextView phoneView = (TextView)convertView.findViewById(R.id.tv2);

            User user = list.get(position);

            nameView.setText(user.name);
            phoneView.setText(user.phone);

            return convertView;
        }
    }
}
