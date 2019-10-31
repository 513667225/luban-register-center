package com.luban.cloud;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @EventListener
    public void test(InstanceRegisterEvent instanceRegisterEvent){
        //..记录数据...
    }
}
