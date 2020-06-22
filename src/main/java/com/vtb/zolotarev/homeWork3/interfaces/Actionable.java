package com.vtb.zolotarev.homeWork3.interfaces;

import com.vtb.zolotarev.homeWork3.entity.obstacles.Track;
import com.vtb.zolotarev.homeWork3.entity.obstacles.Wall;

public interface Actionable {
    void action(Wall name); //Метод, позволяющий участникам прыгать через стены

    void action(Track name); //Метод, позволяющий участникам бегать по дорожкам

    void startDistance(); //Метод объявления участника сорвенований перед забегом

    boolean isSuccess(); //Проверка статуса пройденных этапов
}
