package cloud;


import com.luban.moudle.instance.InstanceConfig;
import org.springframework.context.SmartLifecycle;

import java.util.Timer;
import java.util.TimerTask;

public class ServerContext implements SmartLifecycle {




    private boolean isRunning = false;

    private InstanceConfig instanceConfig;


//    public static void main(String[] args)  throws Exception{
//        FileInputStream fileInputStream = new FileInputStream("c://新建文本文档.txt");
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//        System.out.println(bufferedInputStream.read());

//    }


    public  ServerContext(InstanceConfig instanceConfig){
        this.instanceConfig = instanceConfig;
    }

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

                    }
                },0,instanceConfig.getExpelTimerMs());

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
