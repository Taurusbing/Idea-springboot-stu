package com.hpe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hpe.mapper")
public class Application {
    //main函数的快速写法，psvm
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
