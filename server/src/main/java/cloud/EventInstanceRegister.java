package cloud;

import com.luban.moudle.instance.InstanceInfo;
import com.luban.moudle.register.SyncInstanceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;

//发布事件
public class EventInstanceRegister extends SyncInstanceRegister {

    @Autowired
  private   ApplicationContext applicationContext;

    public void handleRegisterEvent(InstanceInfo info,int timeLimit,boolean isSync){
        pushEvent(new InstanceRegisterEvent(this,info,timeLimit,isSync));
        super.register(info,timeLimit,isSync);
    }

    public void pushEvent(ApplicationEvent event){
        applicationContext.publishEvent(event);
    }

    @Override
    public void register(InstanceInfo info,int timeLimit,boolean isSync) {
        handleRegisterEvent(info,timeLimit,isSync);
        super.register(info,timeLimit,isSync);
    }

    @Override
    public void renew(String appName, String instanceId, boolean isSync) {
        super.renew(appName, instanceId, isSync);
    }

    @Override
    public void cancel(String appName, String instanceId, boolean isSync) {
        super.cancel(appName, instanceId, isSync);
    }


}
