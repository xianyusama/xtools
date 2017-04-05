package com.xkq.xiao.xutils.okhttputils.src.main.java.com.zhy.http.okhttp.builder;

import com.xkq.xiao.xutils.okhttputils.src.main.java.com.zhy.http.okhttp.request.PostStringRequest;
import com.xkq.xiao.xutils.okhttputils.src.main.java.com.zhy.http.okhttp.request.RequestCall;

import okhttp3.MediaType;

/**
 * Created by zhy on 15/12/14.
 */
public class PostStringBuilder extends OkHttpRequestBuilder<PostStringBuilder>
{
    private String content;
    private MediaType mediaType;


    public PostStringBuilder content(String content)
    {
        this.content = content;
        return this;
    }

    public PostStringBuilder mediaType(MediaType mediaType)
    {
        this.mediaType = mediaType;
        return this;
    }

    @Override
    public RequestCall build()
    {
        return new PostStringRequest(url, tag, params, headers, content, mediaType,id).build();
    }


}
