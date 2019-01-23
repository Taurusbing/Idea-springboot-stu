package com.hpe.demo.Controller;

@Controller
public class TimeController {

    @Scheduled(cron = "0 59 9 * * ?")
    public void scheduled(){
        System.out.println("一分钟定时执行了");
    }
}
