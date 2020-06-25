package com.vtb.zolotarev.homeWork4;

import com.vtb.zolotarev.homeWork4.exceptions.MyArrayDataException;
import com.vtb.zolotarev.homeWork4.exceptions.MyArraySizeException;

public class MainClass {
    public static void main(String[] args) {
        String[][] array = {{"8", "6", "-1", "2"}, {"4", "2", "3", "8"}, {"4", "2", "1", "4"}, {"4", "6", "12", "3"}};
        try {
            System.out.printf("Сумма всех приведенных значений внутри массива составляет %d", arraySum(array));
        } catch (MyArraySizeException | MyArrayDataException k) {
            System.err.println(k.getMessage());
        }
    }

    //Метод подсчета суммы всех элементов массива с выводом в консоль
    private static int arraySum(String[][] array) {
        if (!isTrueArray(array)) {
            throw new MyArraySizeException();
        }
        int mainAnswer = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    mainAnswer += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException k) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return mainAnswer;
    }

    private static boolean isTrueArray(String[][] arr) {
        if (arr.length != 4) {
            return false;
        }
        for (String[] i : arr) {
            if (i.length != 4) {
                return false;
            }
        }
        return true;
    }
}
