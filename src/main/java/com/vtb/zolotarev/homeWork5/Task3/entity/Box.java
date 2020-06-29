package com.vtb.zolotarev.homeWork5.Task3.entity;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private T activeFruit;
    private final double maxWeight;
    private ArrayList<T> boxContent;
    private String name;

    public Box(double maxWeight, String name) {
        this.maxWeight = maxWeight;
        this.name = name;
        boxContent = new ArrayList<>();
    }

    //Наполнение коробки фруктами
    public void fill(int putNumber, T fruit) {
        if (!isPossibleForFill(putNumber, fruit)) {
            return;
        }

        activeFruit = fruit;

        for (int i =0;i<putNumber;i++){
            boxContent.add(fruit.getNewFruit());
        }

        System.out.println(String.format("Успешное добавление %d фруктов типа %s в коробку %s", putNumber, fruit.getName(), name));
    }

    private boolean isPossibleForFill(int putNumber, T fruit) {

        double fruitsWeightToPut = putNumber * fruit.getWeight();

        if (maxWeight - boxContent.size() * fruit.getWeight() < fruitsWeightToPut) {
            System.out.println(String.format("Коробка %s не выдержит такой вес! Еще можно загрузить на %f", name, maxWeight - getBoxContent().size() * fruit.getWeight()));
            return false;
        }
        return true;
    }

    //Вес коробки
    public double getActiveWeight() {
        if (activeFruit==null){
            return 0;
        }
        return boxContent.size() * activeFruit.getWeight();
    }

    //Сравнить с другой коробкой по весу
    public boolean compareWeightWith(Box<?> anotherBox) {
        return (Math.abs(this.getActiveWeight() - anotherBox.getActiveWeight()) < 0.001);
    }

    //Перебросить фрукты в другую коробку
    public void dropInAnotherBox(Box<T> anotherBox) {
        if (anotherBox.isPossibleForFill(boxContent.size(),activeFruit)) {
            anotherBox.fill(boxContent.size(),activeFruit);
            boxContent.clear();
            activeFruit=null;
        }
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ArrayList<T> getBoxContent() {
        return boxContent;
    }

}
