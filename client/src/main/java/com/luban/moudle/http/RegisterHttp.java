package com.luban.moudle.http;

import com.luban.moudle.instance.InstanceInfo;
import com.luban.moudle.util.R;

public interface RegisterHttp {

    /**
     * 服务注册
     * @param instanceInfo
     * @return
     */
    R register(InstanceInfo instanceInfo);

    /**
     * 获取注册中心注册信息
     * @return
     */
    R getInstanceInfo();

    /**
     * 获取注册中心更新的注册信息
     * @return
     */
    R getUpdateInstanceInfo();

    /**
     * 心跳续约
     * @param instanceInfo
     * @return
     */
    R renew(InstanceInfo instanceInfo);


    /**
     * 服务下架
     * @param instanceInfo
     * @return
     */
    R cancel(InstanceInfo instanceInfo);

}
