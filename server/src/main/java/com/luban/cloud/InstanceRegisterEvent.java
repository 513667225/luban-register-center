package com.luban.cloud;

import com.luban.moudle.instance.InstanceInfo;
import org.springframework.context.ApplicationEvent;

public class InstanceRegisterEvent extends ApplicationEvent {

    private InstanceInfo instanceInfo;

    private int timeLimit;

    private  boolean isSync;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public InstanceRegisterEvent(Object source, InstanceInfo info,int timeLimit,boolean isSync) {
        super(source);
        this.instanceInfo = info;
        this.isSync = isSync;
        this.timeLimit = timeLimit;

    }

    public InstanceInfo getInstanceInfo() {
        return instanceInfo;
    }

    public void setInstanceInfo(InstanceInfo instanceInfo) {
        this.instanceInfo = instanceInfo;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean sync) {
        isSync = sync;
    }
}
