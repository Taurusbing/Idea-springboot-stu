package com.hpe.redis_template;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateApplicationTests {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /*
    * redis数据结构一：String,等同与java中的Map<String , string>
    * */
    @Test
    public void testRedis() {
        //存储数据
        redisTemplate.opsForValue().set("color","red");
        //获取数据
        String val = redisTemplate.opsForValue().get("color");
        System.out.println("redis_color_value: -->>  "+val);
    }

    @Test
    public void testExpired(){
        redisTemplate.opsForValue().set("time","20",50,TimeUnit.SECONDS);
    }


    /*
    * redis数据结构2：hash，等同于java中的Map<String , Map<String,String>>
    * */
    @Test
    public void testHash(){
        BoundHashOperations<String, Object, Object> hashOps = redisTemplate.boundHashOps("car");
        hashOps.put("type","SUV");
        hashOps.put("color","yellow");
        //取出单条数据
        Object type = hashOps.get("type");
        System.out.println("type -->> "+type);

        //获取所有数据
        Map<Object, Object> map = hashOps.entries();
        for(Map.Entry<Object,Object> ma : map.entrySet()){
            System.out.println("key -->> "+ma.getKey()+"  value -->>"+ma.getValue());
        }

        System.out.println(map);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonstr = objectMapper.writeValueAsString(map);
            System.out.println(jsonstr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /*
    * hash数据结构第二种方式
    * */
    @Test
    public void testihash2(){
        Map<Object,Object> map = new HashMap<>();
        map.put("name","bing");
        map.put("age","18");
        redisTemplate.opsForHash().putAll("user",map);
        Map<Object, Object> usermap = redisTemplate.opsForHash().entries("user");

        //获取单个值
        Object name = usermap.get("name");
        System.out.println(name);

        for(Map.Entry<Object,Object> ma : usermap.entrySet()){
            System.out.println("key -->> "+ma.getKey()+"  value -->>"+ma.getValue());
        }
    }

    /*
    * redis数据结构3：list,等同于java中的Map<String , List<String>>
    * */
    @Test
    public void testList(){
        List<String> list1 = new ArrayList<>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");

        List<String> list2 = new ArrayList<>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");

        redisTemplate.opsForList().leftPushAll("listkey1",list1);
        redisTemplate.opsForList().leftPushAll("listkey2",list2);

        //获取list数据
        List<String> rang1 = redisTemplate.opsForList().range("listkey1",0,-1);
        for(String str : rang1){
            System.out.println(str);
        }

        List<String> rang2 = redisTemplate.opsForList().range("listkey2",0,-1);
        for(String str : rang2){
            System.out.println(str);
        }
    }


    /*
     * 方式二 redis数据结构3：list,等同于java中的Map<String , List<String>>
     * */
    @Test
    public void testList2(){
        BoundListOperations<String, String> fenslist = redisTemplate.boundListOps("fens");
        //将数据压入栈中
        fenslist.leftPushAll("f1","f2","f3");

        List<String> list = fenslist.range(0,1);


        for(String str : list){
            System.out.println(str);
        }

        //将数据取出栈
        String fenstr = fenslist.leftPop();
        System.out.println(fenstr);
    }
}

