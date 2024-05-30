/*
package com.sweet_bites_delivery_service.kafka;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZooKeeperStarter {

    private static final String ZOOKEEPER_CONNECT_STRING = "localhost:2181";
    private static final int SESSION_TIMEOUT = 3000;

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeperStarter example = new ZooKeeperStarter();
        example.run();
    }

    private void run() throws IOException, InterruptedException, KeeperException {
        // Подключаемся к Zookeeper
        final CountDownLatch connectedSignal = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(ZOOKEEPER_CONNECT_STRING, SESSION_TIMEOUT, event -> {
            if (event.getState() == Watcher.Event.KeeperState.SyncConnected) {
                connectedSignal.countDown();
            }
        });

        connectedSignal.await();

        // Создаем узел в Zookeeper
        String path = "/example";
        String data = "test-data";
        Stat stat = zooKeeper.exists(path, false);
        if (stat == null) {
            zooKeeper.create(path, data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        // Устанавливаем слежение за изменениями узла
        Stat updatedStat = zooKeeper.exists(path, event -> {
            if (event.getType() == Watcher.Event.EventType.NodeDataChanged) {
                try {
                    byte[] newData = zooKeeper.getData(path, false, null);
                    System.out.println("Node data updated: " + new String(newData));
                } catch (KeeperException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Изменяем данные узла
        if (updatedStat != null) {
            zooKeeper.setData(path, "new-test-data".getBytes(), updatedStat.getVersion());
        }

        // Закрываем соединение с Zookeeper
        zooKeeper.close();
    }
}
 */