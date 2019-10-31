package com.luban.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("luban.register.instance")
public class RegisterConfigProperties {

    private String hostname;

    @Value("${luban.register.client.url}")//127.0.0.1 , 127.0.0.2,127.0.0.3
    private String registerUrl;



    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getRegisterUrl() {
        return registerUrl;
    }

    public void setRegisterUrl(String registerUrl) {
        this.registerUrl = registerUrl;
    }
}
