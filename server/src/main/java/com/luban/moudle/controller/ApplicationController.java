package com.luban.moudle.controller;


import com.luban.moudle.annotation.Resources;
import com.luban.moudle.annotation.ResourcesMapping;
import com.luban.moudle.annotation.ResponseResources;
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


    //测试链接http://localhost/register.do?ipAddr=127.0.0.1&hostName=xxx&instanceId=clinet-001&instanceName=client&timeLimit=4000&port=8080
    @ResourcesMapping("/register.do")
    @ResponseResources
    public R register(InstanceInfo instanceInfo, String isSync) {
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
        register.register(instanceInfo,timeLimit,isSync==null?false:isSync.equals("true"));
        return R.success();
    }


    @ResourcesMapping("/renew.do")
    @ResponseResources
    public R renew(String instanceName,String instanceId,String isSync){
        if (isNull(instanceName)){
            return R.error("instanceName 不能为空").set("code",400);
        }else if(isNull(instanceId)){
            return R.error("InstanceId 不能为空").set("code",400);
        }
        register.renew(instanceName,instanceId,isSync==null?false:isSync.equals("true"));
        return R.success();
    }

    @ResourcesMapping("/cancel.do")
    @ResponseResources
    public R cancel(String instanceName,String instanceId,String isSync){
        if (isNull(instanceName)){
            return R.error("instanceName 不能为空").set("code",400);
        }else if(isNull(instanceId)){
            return R.error("instanceId 不能为空").set("code",400);
        }
        register.cancel(instanceName,instanceId,isSync==null?false:isSync.equals("true"));
        return  R.success();
    }

    public boolean isNull(String str) {
        return str == null || str.isEmpty();
    }


}
