package luban.cloud;


import com.luban.moudle.instance.InstanceConfig;
import com.luban.moudle.register.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;

import java.util.Timer;
import java.util.TimerTask;

public class ServerContext implements SmartLifecycle {




    private boolean isRunning = false;

    @Autowired
    private InstanceConfig instanceConfig;

    @Autowired
    private Register register;


//    public static void main(String[] args)  throws Exception{
//        FileInputStream fileInputStream = new FileInputStream("c://新建文本文档.txt");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        System.out.println(bufferedInputStream.read());

//    }



    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable callback) {
        callback.run();
    }

    @Override
    public void start() {
        new  Thread(){
            @Override
            public void run() {
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        register.eviction();
                    }
                },instanceConfig.getExpelTimerMs(),instanceConfig.getExpelTimerMs());
            }
        }.start();
    }



    @Override
    public void stop() {
        this.isRunning =false;
    }

    @Override
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public int getPhase() {
        return 0;
    }
}
