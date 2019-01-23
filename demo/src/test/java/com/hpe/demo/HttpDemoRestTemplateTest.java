package com.hpe.demo;

import com.hpe.demo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class HttpDemoRestTemplateTest {
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void httpGet(){
        User user = restTemplate.getForObject("http://localhost:8081/hello",User.class);
        System.out.print(user);
    }











}
