package com.vtb.zolotarev.homeWork1;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        //Тесты для 1 задания
        System.out.println("Task_1");
        System.out.println(checkRange(0,1));
        System.out.println(checkRange(13,17));
        System.out.println(checkRange(9,17));
        System.out.println(checkRange(10,20));
        //Тесты для 2 задания
        System.out.println("Task_2");
        numberSign(-3);
        numberSign(0);
        numberSign(2);
        //Тесты для 3 задания
        System.out.println("Task_3");
        System.out.println(isNegative(-3));
        System.out.println(isNegative(5));
        //Тесты для 4 задания
        System.out.println("Task_4");
        sayHelloTo("Вася");
        //Тесты для 5 задания
        System.out.println("Task_5");
        int[] array = {0,1,0,1,1,1,0};
        System.out.println(Arrays.toString(changeArrElements(array)));
        //Тесты для 6 задания
        System.out.println("Task_6");
        int[] inputArray = new int[8];
        System.out.println(Arrays.toString(fillArray(inputArray)));
        //Тесты для 7 задания
        System.out.println("Task_7");
        int[] superInputArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(mathArrElements(superInputArray)));
        //Тесты для 8 задания
        System.out.println("Task_8");
        int[][] superDuperArray = new int[5][5];
        fillSquareArray(superDuperArray);
        printSquareArray(superDuperArray);
        //Тесты для 9 задания
        System.out.println("Task_9");
        int[] megaArray = {-5,2,99,13,0,2};
        findMinAndMaxInArray(megaArray);
        //Тесты для 10 задания
        System.out.println("Task_10");
        isLeap(1700);
        isLeap(2004);
        isLeap(1600);
        //Тесты для 11 задания
        System.out.println("Task_11");
        System.out.println(isBalanced(new int[]{18,5,2,11}));

    }


    /* 1) Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true,
    в противном случае – false.*/
    private static boolean checkRange(int a,int b){
        return (a>=10&&a<=20)&&(b>=10&&b<=20);
    }
    /* 2) Написать метод, которому в качестве параметра передается целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом.*/
    private static void numberSign(int a){
        if(a<0){
            System.out.println("This number is negative!");
        }
        else{
            System.out.println("This number is positive!");
        }
    }
    /* 3) Написать метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное.*/
    private static boolean isNegative(int a){
        return a<0;
    }
    /* 4) Написать метод, которому в качестве параметра передается строка, обозначающая имя.
    Метод должен вывести в консоль сообщение «Привет, указанное_имя!*/
    private static void sayHelloTo(String name){
        System.out.println("Привет, "+name+"!");
    }
    /* 5) Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;*/
    private static int[] changeArrElements(int[] arr){
        for(int i =0;i<arr.length;i++){
            if (arr[i]==0){
                arr[i]=1;
            }
            else{
                arr[i]=0;
            }
        }
        return arr;
    }
    /* 6) Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 2 5 8 11 14 17 20 23*/
    private static int[] fillArray(int[] arr){
        arr[0]=2;
        for(int i =1;i<arr.length;i++){
            arr[i]=arr[i-1]+3;
        }
        return arr;
    }
    /* 7) Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    и числа меньшие 6 умножить на 2;*/
    private static int[] mathArrElements(int[] arr){
        for (int i =0;i<arr.length;i++){
            if (arr[i]<6){
                arr[i]*=2;
            }
        }
        return arr;
    }
    /* 8) Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;*/
    private static void fillSquareArray(int[][] arr){
        for (int i=0,j=0;i<arr.length;i++,j++){
            arr[i][j]=1;
            arr[i][arr.length-1-i]=1;
        }
    }
    private static void printSquareArray(int[][] arr){
        for (int i =0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
    }
    /* 9) Задать одномерный массив и найти в нем минимальный и максимальный элементы;*/
    private static void findMinAndMaxInArray(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
            }
            if (arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println("Min number: "+min);
        System.out.println("Max number: "+max);
    }
    /* 10) Написать метод, который определяет, является ли год високосным,
    и выводит сообщение в консоль. Каждый 4-й год является високосным, к
    роме каждого 100-го, при этом каждый 400-й – високосный.
     */
    private static void isLeap(int year){
        if((year%4==0&&!(year%100==0))||year%400==0){
            System.out.println("Leap year: Yes");
        }
        else{
            System.out.println("Leap year: No");
        }
    }
    /* 11) Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части
    массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
    эти символы в массив не входят.
     */
    private static boolean isBalanced(int[] arr){
        int startValue = arr[0];
        int sum=0;
        for (int i =0;i<arr.length;i++){
            sum+=arr[i];
        }
        for (int i =0;i<arr.length-1;i++){
            if (startValue==sum-startValue){
                return true;
            }
            else{
                startValue+=arr[i+1];
            }
        }
        return false;
    }
}
