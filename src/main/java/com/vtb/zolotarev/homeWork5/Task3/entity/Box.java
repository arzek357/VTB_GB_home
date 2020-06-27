package com.vtb.zolotarev.homeWork5.Task3.entity;

import java.util.ArrayList;

public class Box {

    private final double maxWeight;
    private ArrayList<Fruit> boxContent;
    private String name;
    private int activeFruitNumber;
    private double activeWeight;

    public Box(double maxWeight, String name) {
        activeFruitNumber = 0;
        activeWeight=0;
        this.maxWeight = maxWeight;
        this.name = name;
        boxContent = new ArrayList<>();
    }

    //Наполнение коробки фруктами
    public <E extends Fruit> void fill(int putNumber, E fruit) {
        if (!isPossibleForFill(putNumber,fruit)){
            return;
        }
        activeFruitNumber += putNumber;
        activeWeight=activeFruitNumber*fruit.getWeight();
        if (boxContent.isEmpty()) {
            boxContent.add(fruit);
        }
        System.out.println(String.format("Успешное добавление %d фруктов типа %s в коробку %s",putNumber,fruit.getName(),name));
    }

     <E extends Fruit> boolean isPossibleForFill(int putNumber, E fruit) {
        if (!boxContent.isEmpty() && !boxContent.contains(fruit)) {
            System.out.println(String.format("В коробке %s уже лежат фрукты типа %s! Класть фрукты другого типа запрещено!", name, getFruitTypeInBox().getName()));
            return false;
        }

        double fruitsWeightToPut = putNumber * fruit.getWeight();

        if (maxWeight - activeWeight < fruitsWeightToPut) {
            System.out.println(String.format("Коробка %s не выдержит такой вес! Еще можно загрузить на %f", name, maxWeight - activeWeight));
            return false;
        }
        return true;
    }

    //Вес коробки
    public double getActiveWeight() {
        return activeWeight;
    }

    //Сравнить с другой коробкой по весу
    public boolean compareWeightWith(Box anotherBox) {
        double weightInThisBox = this.getActiveFruitNumber() * this.getFruitTypeInBox().getWeight();
        double weightInAnotherBox = anotherBox.getActiveFruitNumber() * anotherBox.getFruitTypeInBox().getWeight();
        return (Math.abs(weightInThisBox - weightInAnotherBox) < 0.001);
    }

    //Перебросить фрукты в другую коробку
    public void dropInAnotherBox(Box anotherBox) {
        if (anotherBox.isPossibleForFill(this.activeFruitNumber,this.getFruitTypeInBox())){
            anotherBox.fill(this.activeFruitNumber,this.getFruitTypeInBox());
            this.activeFruitNumber=0;
            this.activeWeight=0;
            this.boxContent.remove(0);
        }
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public String getName() {
        return name;
    }

    public int getActiveFruitNumber() {
        return activeFruitNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fruit getFruitTypeInBox() {
        return boxContent.get(0);
    }
}
