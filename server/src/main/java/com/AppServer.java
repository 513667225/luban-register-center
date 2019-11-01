package com;

import com.luban.cloud.AppConfig;
import com.luban.cloud.EnableLuBanRegisterServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@EnableLuBanRegisterServer
@SpringBootApplication
public class AppServer {

    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run();
        ConfigurableApplicationContext run = SpringApplication.run(AppServer.class);
//        System.out.println(run.getBean(AppConfig.class));
    }
}
