package com.luban.moudle.util;

import java.util.HashMap;

/**
 * 需要咨询java高级VIP课程的同学可以加安其拉老师的QQ：3164703201
 * 需要往期视频的同学可以加木兰老师的QQ：2746251334
 * author：鲁班学院-商鞅老师
 */
public class R extends HashMap{
    public static  String SUCCESS_CODE="200";
    public static String ERROR_CODE="500";
    public static String DATA_KEY = "data";
    public static String MSG_KEY = "msg";

    private R(){

    }

    public R set(String key, Object object){
        super.put(key,object);
        return  this;
    }

    private  static R ok(){
        return new R();
    }

    public static R success(){

        return R.ok().set("code", R.SUCCESS_CODE).set(R.MSG_KEY,"操作成功");
    }

    public static R success(String msg){

        return R.ok().set("code", R.SUCCESS_CODE).set(R.MSG_KEY,msg);
    }

    public static R success(String msg, Object object){

        return R.ok().set("code", R.SUCCESS_CODE).set(R.MSG_KEY,msg).set(R.DATA_KEY,object);
    }

    public R data(Object obj){
        return this.set("data",obj);
    }

    public static R error(){
        return R.ok().set(R.MSG_KEY,"操作失败").set("code", R.ERROR_CODE);
    }

    public static R error(String msg){
        return R.ok().set(R.MSG_KEY,msg).set("code", R.ERROR_CODE);
    }

    public static R error(String msg, Object object){
        return R.ok().set(R.MSG_KEY,msg).set(R.DATA_KEY,object).set("code", R.ERROR_CODE);
    }

}
