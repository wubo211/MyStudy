package com.study.zookeeper;

import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

/**
 * @Author: wubo
 * @Description:
 * @Date Created in 下午10:40 19/6/28
 **/

public class Master implements Watcher {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Master.class);
    ZooKeeper zk;
    String hostPort;

    String serverId = String.valueOf(new Random().nextLong());
    static boolean isLeader = false;

    Master(String hostPort) {
        this.hostPort = hostPort;
    }

    void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    void stopZK() throws InterruptedException {
        zk.close();
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println(watchedEvent);
    }

    AsyncCallback.StringCallback masterCreateCallback = (i, s, o, s1) -> {
        switch (KeeperException.Code.get(i)) {
            case CONNECTIONLOSS:
                checkMaster();
                return;
            case OK:
                isLeader = true;
                break;
            default:
                isLeader = false;
        }
        System.out.println("I am " + (isLeader ? "" : "not") + " the leader!");
    };

    void runForMaster() {
        zk.create("/master", serverId.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, masterCreateCallback, null);
    }

    AsyncCallback.DataCallback masterCheckCallback = new AsyncCallback.DataCallback() {
        @Override
        public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
            logger.info("masterCheckCallback i:{},s:{}",i,s);
            switch (KeeperException.Code.get(i)) {
                case CONNECTIONLOSS:
                    checkMaster();
                    return;
                case NONODE:
                    runForMaster();
                    return;
                case NODEEXISTS:
                    logger.info("Master already exists");
                    break;
            }
        }
    };

    void checkMaster() {
        zk.getData("/master", false, masterCheckCallback, null);
    }

    public void bootstrap() {
        createParent("/workers",new byte[0]);
        createParent("/assign",new byte[0]);
        createParent("/tasks",new byte[0]);
        createParent("/status",new byte[0]);
    }

    void createParent(String path, byte[] data) {
        zk.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT, createParentCallback, data);
    }
    AsyncCallback.StringCallback createParentCallback = new AsyncCallback.StringCallback() {
        @Override
        public void processResult(int i, String s, Object o, String s1) {
            switch (KeeperException.Code.get(i)){
                case CONNECTIONLOSS:
                    createParent(s,(byte[]) o);
                    break;
                case OK:
                    logger.info("Parent created");
                    break;
                case NODEEXISTS:
                    logger.info("Parent already registered: "+s);
                    break;
                    default:
                        logger.error("Something went wrong: ",KeeperException.create(KeeperException.Code.get(i),s));

            }
        }
    };

    public static void main(String[] args) throws IOException, InterruptedException {
        String localHostPort = "127.0.0.1:2181";
        Master master = new Master(localHostPort);
        master.startZK();
        master.bootstrap();
        master.runForMaster();
        Thread.sleep(30000);
        master.stopZK();
    }
}
