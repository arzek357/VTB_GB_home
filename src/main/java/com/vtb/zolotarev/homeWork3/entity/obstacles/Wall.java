package com.vtb.zolotarev.homeWork3.entity.obstacles;

import com.vtb.zolotarev.homeWork3.interfaces.Actionable;
import com.vtb.zolotarev.homeWork3.interfaces.GradeAbility;

import java.util.Objects;

public class Wall implements GradeAbility {
    private final int height;

    public Wall(int height) {
        if (height < 0) {
            throw new ArithmeticException("Высота стены не может быть отрицательной");
        }
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void actionChoose(Actionable g) {
        if (g == null) {
            throw new NullPointerException("Участника не существует или его атрибуты заданы некорректно!");
        }
        g.action(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wall wall = (Wall) o;
        return height == wall.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
