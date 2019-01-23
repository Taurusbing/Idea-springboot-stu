package com.hpe.demo;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class HttpTest {
    CloseableHttpClient httpClient;

    @Before
    public void init(){
        //创建httpClient的客户端
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void testGet() throws IOException {
        //发起get请求，有post,delect,put,要什么请求new哪一个就行
        HttpGet request = new HttpGet("http://www.baidu.com");
        //执行请求,BasicResponseHandler()是相应处理器
        String response = httpClient.execute(request,new BasicResponseHandler());
        System.out.print(response);
    }

    @Test
    public void testGetHello() throws IOException {
        HttpGet request = new HttpGet("http://localhost:8081/hello");
        String response = httpClient.execute(request,new BasicResponseHandler());
        System.out.print(response);
    }
}
