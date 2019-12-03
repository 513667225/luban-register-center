package luban.cloud;

import com.luban.moudle.instance.InstanceConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class InstanceConfigImpl implements InstanceConfig {

    @Autowired
    RegisterConfigProperties registerConfigProperties;

    @Override
    public String getInstanceName() {
        return registerConfigProperties.getHostname();
    }

    @Override
    public String getRegisterUrl() {
        return registerConfigProperties.getRegisterUrl();
    }

    @Override
    public long getExpelTimerMs() {
        return registerConfigProperties.getExpelTimerMs();
    }
}
