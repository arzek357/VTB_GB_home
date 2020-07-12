package com.vtb.zolotarev.homeWork10;


import com.vtb.zolotarev.homeWork10.stages.Road;
import com.vtb.zolotarev.homeWork10.stages.Tunnel;

import java.util.concurrent.Semaphore;

public class RaceApp {
    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(new Semaphore(Race.COMPETITORS_COUNT/2)), new Road(40),new Tunnel(new Semaphore(Race.COMPETITORS_COUNT/2)));
        race.begin();
    }
}
