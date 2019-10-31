package com.luban.moudle.controller;


import com.luban.moudle.annotation.Resources;
import com.luban.moudle.annotation.ResourcesMapping;
import com.luban.moudle.instance.InstanceConfig;
import com.luban.moudle.instance.InstanceInfo;
import com.luban.moudle.instance.Lease;
import com.luban.moudle.register.Register;
import com.luban.moudle.util.R;

@Resources
public class ApplicationController {

    private Register register;

    private InstanceConfig instanceConfig;

    public ApplicationController (Register register,InstanceConfig instanceConfig){
        this.register = register;
        this.instanceConfig = instanceConfig;
    }




    @ResourcesMapping("/register.do")
    public R register(InstanceInfo instanceInfo, boolean isSync) {
        if (isNull(instanceInfo.getHostName())) {
            return R.error("HostName 不能为空").set("code",400);
        } else if (isNull(instanceInfo.getInstanceId())) {
            return R.error("InstanceId 不能为空").set("code",400);
        } else if (isNull(instanceInfo.getInstanceName())) {
            return R.error("InstanceName 不能为空").set("code",400);
        } else if (isNull(instanceInfo.getPort())) {
            return R.error("Port 不能为空").set("code",400);
        } else if (isNull(instanceInfo.getIpAddr())) {
            return R.error("IpAddr 不能为空").set("code",400);
        }

        int timeLimit = Lease.DEFULT_TIME_LIMIT;
        if (instanceInfo.getTimeLimit()>0) {
            timeLimit = instanceInfo.getTimeLimit();
        }
        register.register(instanceInfo,timeLimit,isSync);
        return R.success();
    }


    @ResourcesMapping("/renew.do")
    public R renew(String appName,String instanceId,boolean isSync){
        if (isNull(appName)){
            return R.error("appName 不能为空").set("code",400);
        }else if(isNull(instanceId)){
            return R.error("InstanceId 不能为空").set("code",400);
        }
        register.renew(appName,instanceId,isSync);
        return R.success();
    }

    @ResourcesMapping("/cancel.do")
    public R cancel(String appName,String instanceId,boolean isSync){
        if (isNull(appName)){
            return R.error("appName 不能为空").set("code",400);
        }else if(isNull(instanceId)){
            return R.error("instanceId 不能为空").set("code",400);
        }
        register.cancel(appName,instanceId,isSync);
        return  R.success();
    }

    public boolean isNull(String str) {
        return str == null || str.isEmpty();
    }


}
