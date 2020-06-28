package com.vtb.zolotarev.homeWork5.Task3.entity;

import java.util.ArrayList;

public class Box {

    private final double maxWeight;
    private ArrayList<Fruit> boxContent;
    private Fruit activeFruit;
    private String name;

    public Box(double maxWeight, String name) {
        this.maxWeight = maxWeight;
        this.name = name;
        boxContent = new ArrayList<>();
    }

    //Наполнение коробки фруктами
    public <E extends Fruit> void fill(int putNumber, E fruit) {
        if (!isPossibleForFill(putNumber, fruit)) {
            return;
        }

        for (int i = 0; i < putNumber; i++) {
            boxContent.add(fruit);
        }
        activeFruit = fruit;
        System.out.println(String.format("Успешное добавление %d фруктов типа %s в коробку %s", putNumber, fruit.getName(), name));
    }

    private <E extends Fruit> boolean isPossibleForFill(int putNumber, E fruit) {
        if (!boxContent.isEmpty() && !boxContent.contains(fruit)) {
            System.out.println(String.format("В коробке %s уже лежат фрукты типа %s! Класть фрукты другого типа запрещено!", name, getActiveFruit().getName()));
            return false;
        }

        double fruitsWeightToPut = putNumber * fruit.getWeight();

        if (maxWeight - boxContent.size() * fruit.getWeight() < fruitsWeightToPut) {
            System.out.println(String.format("Коробка %s не выдержит такой вес! Еще можно загрузить на %f", name, maxWeight - getBoxContent().size() * fruit.getWeight()));
            return false;
        }
        return true;
    }

    //Вес коробки
    public double getActiveWeight() {
        if (getActiveFruit() == null) {
            return 0;
        }
        return boxContent.size() * getActiveFruit().getWeight();
    }

    //Сравнить с другой коробкой по весу
    public boolean compareWeightWith(Box anotherBox) {
        return (Math.abs(this.getActiveWeight() - anotherBox.getActiveWeight()) < 0.001);
    }

    //Перебросить фрукты в другую коробку
    public void dropInAnotherBox(Box anotherBox) {
        if (anotherBox.isPossibleForFill(this.getBoxContent().size(), this.getActiveFruit())) {
            anotherBox.fill(this.getBoxContent().size(), this.getActiveFruit());
            this.boxContent.clear();
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

    private ArrayList<Fruit> getBoxContent() {
        return boxContent;
    }

    public Fruit getActiveFruit() {
        return activeFruit;
    }
}
