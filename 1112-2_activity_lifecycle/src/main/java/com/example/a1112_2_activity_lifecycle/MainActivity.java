package com.example.a1112_2_activity_lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnChoice, btnView;
    Uri contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChoice = (Button) findViewById(R.id.btnChoice);
        btnChoice.setOnClickListener(this);

        btnView = (Button) findViewById(R.id.btnView);
        btnView.setOnClickListener(this);

        if (savedInstanceState != null) {//data있다
            String txt = savedInstanceState.getString("contact");
            if (txt != null) {
                contact = Uri.parse(txt);
            }
        }

        btnView.setEnabled(contact != null);
    }

    @Override
    public void onClick(View v) {
        if (v == btnChoice) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setData(ContactsContract.Contacts.CONTENT_URI);//연락처에 있는 사람 한명에 대한 데이터
            startActivityForResult(intent, 10);
        } else if (v == btnView) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(contact);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 10 && resultCode == RESULT_OK) {
            contact = data.getData();

            btnView.setEnabled(true);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {//정보저장
        super.onSaveInstanceState(outState);

        if (contact != null) {
            outState.putString("contact", contact.toString());
            //outState.putSerializable();//객체저장

            Log.d("young", "contact.toString:" + contact.toString());//어떤 것이 들어있는 지 logcat에서 확인
        }
    }
}
