package com.vtb.zolotarev.homeWork4.exceptions;

public class MyArrayDataException extends MyHomeWorkException {
    public MyArrayDataException(int i, int j) {
        super(String.format("Элемент массива с координатами [%d][%d] невозможно преобразовать в формат Integer!",i,j));
    }
}
