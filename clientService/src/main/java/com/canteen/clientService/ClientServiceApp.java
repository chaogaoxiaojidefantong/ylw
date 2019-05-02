package com.canteen.clientService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.canteen.clientService.dao")
public class ClientServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApp.class,args);
    }
}
