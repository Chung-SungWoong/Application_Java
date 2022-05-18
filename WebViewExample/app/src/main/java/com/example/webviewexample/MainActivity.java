package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {


    private WebView wv_test;
    private String url = "http://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wv_test = (WebView)findViewById(R.id.wv_test);    // webview를 xml의 wv_test와 연결

        wv_test.getSettings().setJavaScriptEnabled(true);  // 자바스크립트의 사용을 허락할 것인지
        wv_test.loadUrl(url);                               //url을 로드
        wv_test.setWebChromeClient(new WebChromeClient());   // 여는 것을 크롬으로 지정
        wv_test.setWebViewClient(new WebViewClientClass());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_test.canGoBack()) {       //만약 뒤로가기를 눌렀고 웹뷰가 뒤로 갈 수 있다면
            wv_test.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {         //현재페이지의 url을 읽어올 수 있는 라이드
            view.loadUrl(url);
            return true;
        }
    }
}