package com.vtb.zolotarev.homeWork10;

import com.vtb.zolotarev.homeWork10.stages.Tunnel;

public class Car implements Runnable {
    private static int CARS_COUNT;

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            race.getCyclicBarrier().await();
            System.out.println(this.name + " готов");
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).overcome(this);
        }
            race.getLock().lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (race.getCountDownLatch().getCount()==Race.COMPETITORS_COUNT){
                System.out.println(this.name+" WIN");
            }
            race.getCountDownLatch().countDown();
            race.getLock().unlock();
        }
    }
}