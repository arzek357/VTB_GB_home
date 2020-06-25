package com.vtb.zolotarev.homeWork3.entity.competitors;

import com.vtb.zolotarev.homeWork3.entity.obstacles.Track;
import com.vtb.zolotarev.homeWork3.entity.obstacles.Wall;
import com.vtb.zolotarev.homeWork3.interfaces.Actionable;

import java.util.Objects;

public class Human implements Actionable {
    private String name; //Имя
    private final int maxHeight; //Максимальная высота прыжка в сантиметрах, начальное значение
    private final int maxLength; //Максимальная длина дистанции для бега в метрах, начальное значение
    private boolean status = true; //Переменная, которая сообщает о готовности участника к выполнению следующего препятствия

    public Human(String name,int maxHeight,int maxLength){
        this.name=name;
        this.maxHeight=maxHeight;
        this.maxLength=maxLength;
    }

    @Override
    public void action(Wall wall) {
        if (maxHeight>=wall.getHeight()){
            System.out.printf("Человек %s перепрыгнул стену длиной %d сантиметров\n",name,wall.getHeight());
        }
        else{
            System.out.printf("Человек %s не смог перепрыгнуть стену длиной %d сантиметров\n",name,wall.getHeight());
            status=false;
        }
    }

    @Override
    public void action(Track track) {
        if (maxLength>=track.getLength()){
            System.out.printf("Человек %s смог пробежать дистанцию длиной %d метров\n",name,track.getLength());
        }
        else{
            System.out.printf("Человек %s не смог пробежать дистанцию длиной %d метров\n",name,track.getLength());
            status=false;
        }
    }

    @Override
    public void startDistance() {
        System.out.printf("На забег приглашается человек %s!\nЕго характеристики:\nВысота прыжка: %d сантиметров\nДистанция бега: %d метров\n",name,maxHeight,maxLength);
    }

    @Override
    public boolean isSuccess() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return maxHeight == human.maxHeight &&
                maxLength == human.maxLength &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, maxHeight, maxLength);
    }

    @Override
    public String toString() {
        return String.format("Human [Name: %s; MaxHeight: %d; MaxLength: %d]", name, maxHeight, maxLength);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
