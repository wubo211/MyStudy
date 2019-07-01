package com.study.zookeeper;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Random;

/**
 * @Description：
 * @Author： wub
 * @Date： 2019/7/1 11:30
 **/
public class Worker implements Watcher {
    private static final Logger logger = LoggerFactory.getLogger(Worker.class);

    ZooKeeper zk;
    String hostPort;
    String serverId = Integer.toHexString(new Random().nextInt());

    Worker(String hostPort){
        this.hostPort = hostPort;
    }

    void startZK() throws IOException{
        zk = new ZooKeeper(hostPort,15000,this);
    }

    void register(){
        zk.create("/workers/worker_"+serverId,"Idle".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL,
                createWorkerCallback,null);
    }

    AsyncCallback.StringCallback createWorkerCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            switch (KeeperException.Code.get(i)){
                case CONNECTIONLOSS:
                    register();
                    break;
                case OK:
                    logger.info("Registered successfully: "+serverId);
                    break;
                case NODEEXISTS:
                    logger.warn("Already registered: "+serverId);
                    default:
                        logger.error("Something went wrong: "+ KeeperException.create(KeeperException.Code.get(i),s));
            }
        }
    };

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent.toString() + ", "+hostPort);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String hostPortLoacl = "127.0.0.1:2181";
        Worker worker = new Worker(hostPortLoacl);
        worker.startZK();

        worker.register();

        Thread.sleep(30000);

    }
}
