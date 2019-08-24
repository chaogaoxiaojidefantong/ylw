package com.canteen.zuulService.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableZuulProxy
@Controller
public class ZuulApp {
    @RequestMapping("/")
    public String index()throws Exception{
        //测试nginx 轮询
        return "index";
    }
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class,args);
    }
}
