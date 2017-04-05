package com.xkq.xiao.xtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xkq.xiao.xutils.common.klog.KLog;
import com.xkq.xiao.xutils.okhttputils.src.main.java.com.zhy.http.okhttp.OkHttpUtils;
import com.xkq.xiao.xutils.okhttputils.src.main.java.com.zhy.http.okhttp.callback.StringCallback;
import com.xkq.xiao.xutils.okhttputils.src.main.java.com.zhy.http.okhttp.log.LoggerInterceptor;

import okhttp3.Call;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new LoggerInterceptor("TAG"))
                //其他配置
                .build();
        OkHttpUtils.initClient(okHttpClient);
        final TextView hello = (TextView) findViewById(R.id.tv_hello);
        hello.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                hello.setText("nima");
                String url = "http://www.csdn.net/";
                OkHttpUtils
                        .get()
                        .url(url)
                        .addParams("username", "hyman")
                        .addParams("password", "123")
                        .build()
                        .execute(new StringCallback() {

                            @Override
                            public void onError(Call call, Exception e, int id) {
                                KLog.e(e.toString());
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                KLog.d(response);
                            }
                        });
            }
        });
    }
}
