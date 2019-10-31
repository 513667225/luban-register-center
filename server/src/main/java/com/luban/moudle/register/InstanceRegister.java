package com.luban.moudle.register;

import com.luban.moudle.instance.InstanceInfo;
import com.luban.moudle.instance.Lease;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InstanceRegister implements Register {

    private ConcurrentHashMap<String,Map<String,Lease<InstanceInfo>>>
                                                                        register = new ConcurrentHashMap<>();


    @Override
    public void register(InstanceInfo info, int timeLimit, boolean isSync) {


    }

    @Override
    public void renew(String appName, String instanceId, boolean isSync) {

    }

    @Override
    public void cancel(String appName, String instanceId, boolean isSync) {

    }


}
