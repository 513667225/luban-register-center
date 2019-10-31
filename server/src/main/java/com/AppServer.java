package com;

import com.luban.cloud.EnableLuBanRegisterServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableLuBanRegisterServer
@SpringBootApplication
//@xxx
public class AppServer {

    public static void main(String[] args) {
//        ConfigurableApplicationContext run = SpringApplication.run();
        SpringApplication.run(AppServer.class);

    }
}
