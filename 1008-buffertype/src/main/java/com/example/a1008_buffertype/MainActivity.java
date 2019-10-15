package com.example.a1008_buffertype;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    TextView tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        Spannable et1Span = et1.getText();
        //exclusive 확장X
        //inclusive 경계선에서부터 확장O
        et1Span.setSpan(new StyleSpan(Typeface.ITALIC),1,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//exclusive 확장X
        et1Span.setSpan(new BackgroundColorSpan(0xffff0000),8,11,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);//앞에 4개는 투명도, inclusive 경계선에서 확장해나감
        et1Span.setSpan(new UnderlineSpan(),12,17,Spanned.SPAN_INCLUSIVE_INCLUSIVE);//

        tv2 = (TextView)findViewById(R.id.tv2);
        tv2.setText(Html.fromHtml("This <b>bold</b> is <i>italic</i> from <u>underline</u>"));

        tv3 = (TextView)findViewById(R.id.tv3);
        tv3.setText(Html.fromHtml("This is a androboy <img src = 'androboy'/>", new ImageGetter(), null));
    }

    public class ImageGetter implements Html.ImageGetter{
        public Drawable getDrawable(String source){
            int id = 0;

            if(source.equals("androboy")){
                id = R.mipmap.ic_launcher;
            }

            if(id != 0){//이미지 찾은거임
                Drawable drawable = getResources().getDrawable(id);

                //있어야 화면에 나옴
                drawable.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
                return drawable;
            }

            return null;
        }
    }
}
