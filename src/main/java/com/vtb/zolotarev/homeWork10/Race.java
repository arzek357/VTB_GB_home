package com.vtb.zolotarev.homeWork10;

import com.vtb.zolotarev.homeWork10.stages.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    public static final int COMPETITORS_COUNT = 4;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(COMPETITORS_COUNT);
    private CountDownLatch countDownLatch = new CountDownLatch(COMPETITORS_COUNT);
    private Lock lock = new ReentrantLock();
    private List<Stage> stages;

    public List<Stage> getStages() { return stages; }

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void begin() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Car[] cars = new Car[COMPETITORS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            countDownLatch.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public Lock getLock() {
        return lock;
    }
}
