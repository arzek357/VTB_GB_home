package com.vtb.zolotarev.homeWork11;

import com.vtb.zolotarev.homeWork11.annotations.AfterSuite;
import com.vtb.zolotarev.homeWork11.annotations.BeforeSuite;
import com.vtb.zolotarev.homeWork11.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class TestRunner {
    public static void main(String[] args) {
        Class c = SimpleTest.class;
        start(c);
    }

    private static void start(Class c) {
        try {
            Constructor constructor = c.getConstructor();
            Object obj = constructor.newInstance();
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].isAnnotationPresent(BeforeSuite.class)) {
                    if (methods[0].isAnnotationPresent(BeforeSuite.class) && i != 0) {
                        throw new RuntimeException("Possible only one BeforeSuite annotation in class");
                    }
                    Method tmp = methods[0];
                    methods[0] = methods[i];
                    methods[i] = tmp;
                }
                if (methods[i].isAnnotationPresent(AfterSuite.class)) {
                    if (methods[methods.length - 1].isAnnotationPresent(AfterSuite.class) && i != methods.length - 1) {
                        throw new RuntimeException("Possible only one AfterSuite annotation in class");
                    }
                    Method tmp = methods[methods.length - 1];
                    methods[methods.length - 1] = methods[i];
                    methods[i] = tmp;
                }
            }
            Arrays.sort(methods, 1, methods.length - 2, (o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());
            for (Method method : methods) {
                method.invoke(obj);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            ex.printStackTrace();
            System.out.println("Impossible to test this Class");
        }
    }
}
