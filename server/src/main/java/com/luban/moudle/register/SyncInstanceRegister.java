package com.luban.moudle.register;

import com.luban.moudle.emun.Action;
import com.luban.moudle.instance.InstanceInfo;

public class SyncInstanceRegister extends InstanceRegister {
    //责任链
       @Override
    public void register(InstanceInfo info, int timeLimit, boolean isSync) {
        super.register(info, timeLimit, isSync);
        sync(Action.Register,info,isSync);
    }

    //要注意处理重复同步
    public  void sync(Action action,InstanceInfo info,boolean isSync){
           //判断 isSync是否为true
          //判断是什么操作
            //拿到了你配置文件里面其他节点的地址
        //遍历所有节点地址发送请求

    }

}
