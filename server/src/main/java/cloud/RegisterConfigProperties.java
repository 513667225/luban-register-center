package cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("luban.register.instance")
public class RegisterConfigProperties {

    private String hostname;

//    @Value("${luban.register.client.url}")//127.0.0.1 , 127.0.0.2,127.0.0.3
    private String registerUrl;

//    @Value("${expelTimerMs}")
    private int expelTimerMs;

    public int getExpelTimerMs() {
        return expelTimerMs;
    }

    public void setExpelTimerMs(int expelTimerMs) {
        this.expelTimerMs = expelTimerMs;
    }

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
