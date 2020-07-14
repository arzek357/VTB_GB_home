package com.vtb.zolotarev.homeWork12;

import com.vtb.zolotarev.homeWork12.entity.Cat;
import com.vtb.zolotarev.homeWork12.entity.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestReflectionRepository {
    private static ReflectionRepository<Student> studentRepository;
    private static ReflectionRepository<Cat> catRepository;

    @BeforeAll
    public static void init(){
        studentRepository = new ReflectionRepository<>(Student.class);
        catRepository = new ReflectionRepository<>(Cat.class);
    }

    @Test
    public void saveMethodTest1(){
        Assertions.assertNotNull(studentRepository.save(new Student("Dmitry","Zolotarev",20,251)).getId());
    }

    @Test
    public void saveMethodTest2(){
        Assertions.assertNotNull(catRepository.save(new Cat("Barsik",4,"white")).getId());
    }
}
