package com.luban.moudle.instance;

import java.sql.Time;
import java.util.Date;

//租债器
// 如果有某个对象 需要给他一个过期的时间
public class Lease<T> {

    T object;

    //心跳连接的过期时间
    public static final int DEFULT_TIME_LIMIT=90;


    //最后活跃时间  2层意义：刚开始注册的时间  续约的时间
    private long lastActivityTime;
    //生命周期  租期
    private  long  timeLimit;

    //被剔除的时间
    private  long expelTime;

    public Lease(T object, long lastActivityTime, long timeLimit) {
        this.object = object;
        this.lastActivityTime = lastActivityTime;
        this.timeLimit = timeLimit;
    }

    //续约
    public void renew(){
        this.lastActivityTime = System.currentTimeMillis()+this.timeLimit;
    }

    //12.01 : 30s    30s
    //当前系统时间大于12.02分的时候 这个对象就过期了。

    //判断是否过期
    public  boolean isOverdue(){
        return expelTime>0||System.currentTimeMillis()>(lastActivityTime+timeLimit);
    }




    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public long getLastActivityTime() {
        return lastActivityTime;
    }

    public void setLastActivityTime(long lastActivityTime) {
        this.lastActivityTime = lastActivityTime;
    }

    public long getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(long timeLimit) {
        this.timeLimit = timeLimit;
    }

    public long getExpelTime() {
        return expelTime;
    }

    public void setExpelTime(long expelTime) {
        this.expelTime = expelTime;
    }
}
