package com.vtb.zolotarev.homeWork3.entity.obstacles;

import com.vtb.zolotarev.homeWork3.interfaces.Actionable;
import com.vtb.zolotarev.homeWork3.interfaces.GradeAbility;
import java.util.Objects;

public class Track implements GradeAbility {
    private final int length;

    public Track(int length){
        if (length < 0) {
            throw new ArithmeticException("Длина дорожки не может быть отрицательной");
        }
        this.length=length;
    }

    public int getLength(){
        return length;
    }

    @Override
    public void actionChoose(Actionable g) {
        if (g==null){
            throw new NullPointerException("Участника не существует или его атрибуты заданы некорректно!");
        }
        g.action(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return length == track.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length);
    }
}
