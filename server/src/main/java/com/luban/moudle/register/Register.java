package com.luban.moudle.register;

import com.luban.moudle.instance.InstanceInfo;

public interface Register {


    void register(InstanceInfo info, int timeLimit, boolean isSync);

    void  renew(String appName,String instanceId,boolean isSync);

    void cancel(String appName,String instanceId,boolean isSync);


}
