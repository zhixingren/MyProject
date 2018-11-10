package com.mysummary.myproject.android_basis.web_view;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

import com.mysummary.myproject.R;

public class WebViewActivity extends AppCompatActivity {


    private WebView webview ;
    private Button btn_to_load ;
    private String url = "https://v.qq.com/x/page/y0647wil158.html";
    //https://m.qiandaojr.com/my-qb-convert.html
    private String TAG = "WebViewActivity";
    private LinearLayout ll ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        btn_to_load = findViewById(R.id.btn_to_load);
        ll = findViewById(R.id.ll);
        webview = new WebView(getApplicationContext());
        ll.addView(webview);
//        webview = findViewById(R.id.webview);
//--------------1----------------
        // 存储(storage)
        // 启用HTML5 DOM storage API，默认值 false
        webview.getSettings().setDomStorageEnabled(true);
        //清除缓存
        webview.clearCache(true);
        // 是否支持viewport属性，默认值 false
        // 页面通过`<meta name="viewport" ... />`自适应手机屏幕
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setLoadWithOverviewMode(true);
        // 是否支持Javascript，默认值false
        webview.getSettings().setJavaScriptEnabled(true);
//--------------=2-----------------



//        webview.loadDataWithBaseURL("about:blank", "", "text/html", "utf-8", null);

//        webview.setWebViewClient(new HelloWebViewClient());


        // 是否使用overview mode加载页面，默认值 false
        // ****当页面宽度大于WebView宽度时，缩小使页面宽度等于WebView宽度,
        /*


         */


//        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
//        webview.getSettings().setGeolocationEnabled(true);
//        webview.getSettings().setDomStorageEnabled(true);

//        webview.getSettings().setDatabaseEnabled(true);
//        webview.getSettings().setUseWideViewPort(true); // 关键点
//        webview.getSettings().setAllowFileAccess(true); // 允许访问文件
//        webview.getSettings().setLoadWithOverviewMode(true);
//        webview.getSettings().setPluginState(WebSettings.PluginState.ON);
//        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE); // 不加载缓存内容

        //解决当播放视频的时候，不显示视频画面，包括其他图片
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            // 5.0以上允许加载http和https混合的页面(5.0以下默认允许，5.0+默认禁止)
            webview.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        btn_to_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webview.loadUrl(url);

            }
        });


    }


    private class HelloWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            Log.e(TAG,"shouldOverrideUrlLoading");
            return super.shouldOverrideUrlLoading(view,request);
        }


        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Log.e(TAG,"onReceivedSslError");
            super.onReceivedSslError(view, handler, error);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            Log.e(TAG,"onReceivedError");
            super.onReceivedError(view, request, error);
        }


    }


}
