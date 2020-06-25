package com.vtb.zolotarev.homeWork3;

import com.vtb.zolotarev.homeWork3.entity.competitors.Cat;
import com.vtb.zolotarev.homeWork3.entity.competitors.Human;
import com.vtb.zolotarev.homeWork3.entity.competitors.Robot;
import com.vtb.zolotarev.homeWork3.entity.obstacles.Track;
import com.vtb.zolotarev.homeWork3.entity.obstacles.Wall;
import com.vtb.zolotarev.homeWork3.interfaces.Actionable;
import com.vtb.zolotarev.homeWork3.interfaces.GradeAbility;
import com.vtb.zolotarev.homeWork3.scripts.CompetitionScript;

public class MainClass {

//    1) Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
//    Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль:
//    успешно пробежал, не смог пробежать и т.д.).

//    2) Создайте два класса: беговая дорожка и стена, при прохождении через которые,
//    участники должны выполнять соответствующие действия (бежать или прыгать).
//    У препятствий есть длина (для дорожки) или высота (для стены), а у участников ограничения на бег и прыжки.
//    Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.

//    3) Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.

    public static void main(String[] args) {
        CompetitionScript.beginningOfCompetitions(testTeam(), testObstacleCourse());
    }

    private static Actionable[] testTeam() {
        Actionable[] participants = new Actionable[5];
        participants[0] = new Cat("Барсик", 130, 400);
        participants[1] = new Robot("R20", 110, 10000);
        participants[2] = new Human("Алексей", 150, 6000);
        participants[3] = new Cat("Бобик", 180, 300);
        participants[4] = new Human("Иван", 100, 5000);
        return participants;
    }

    private static GradeAbility[] testObstacleCourse() {
        GradeAbility[] obstacles = new GradeAbility[5];
        obstacles[0] = new Wall(50);
        obstacles[1] = new Wall(100);
        obstacles[2] = new Track(2000);
        obstacles[3] = new Wall(80);
        obstacles[4] = new Track(4000);
        return obstacles;
    }
}
