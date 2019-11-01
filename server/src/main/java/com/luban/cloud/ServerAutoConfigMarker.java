package com.luban.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerAutoConfigMarker {


    @Bean
    public  Marker marker(){
        return new Marker();
    }

    //标识
    public class Marker{

    }

}
