package com.vtb.zolotarev.homeWork10.stages;

import com.vtb.zolotarev.homeWork10.Car;

public abstract class Stage {
    int length;
    String description;

    public String getDescription() {
        return description;
    }

    public abstract void overcome(Car c);
}
