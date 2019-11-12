package com.example.a1022_2_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.service.autofill.CharSequenceTransformation;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    WebView wv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);

        wv = (WebView) findViewById(R.id.wv);
        wv.setWebChromeClient(new MyWebChrom());//브라우저 자체 이벤트처리
        wv.setWebViewClient(new MyWebClient());//웹 뷰에서 발생하는 유저 이벤트 처리하는 클래스

        //javascript에게 객체를 공개
        wv.addJavascriptInterface(new JavaScriptTest(), "android");

        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
        wv.loadUrl("file:///android_asset/test.html");
    }

    @Override
    public void onClick(View v) {
        wv.loadUrl("javascript:fromApp()");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {//웹 뷰 뒤로가기
        if(keyCode == KeyEvent.KEYCODE_BACK && wv.canGoBack()){
            wv.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    //웹 뷰에서 발생하는 유저 이벤트 처리하는 클래스
    class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.d("young", "url:" + request.getUrl().toString());
            view.loadUrl(request.getUrl().toString());

            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    //브라우저 자체 이벤트처리
    class MyWebChrom extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            result.cancel();

            return true;
        }
    }

    class JavaScriptTest {
        @JavascriptInterface
        public void vibrate() {
            Vibrator vr = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            VibrationEffect ve = VibrationEffect.createOneShot(500, 50);
            vr.vibrate(ve);
            Log.i("young", "진동!!!");
        }
    }
}
