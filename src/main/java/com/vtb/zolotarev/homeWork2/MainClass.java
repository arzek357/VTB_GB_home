package com.vtb.zolotarev.homeWork2;

import com.vtb.zolotarev.homeWork2.entity.Employee;
import com.vtb.zolotarev.homeWork2.entity.Group;

public class MainClass {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Vasya","00@mail.ru",18,"Developer");
        Employee employee2 = new Employee("Katya","fef@gmail.com",22,"Manager");
        Employee employee3 = new Employee("Musya","fefe@gmail.com",25,"Director");
        Group group1 = new Group("Team1",employee1,employee2);
        group1.printEmployeesInfo();
        group1.addNewEmployee(employee3);
        group1.printEmployeesInfo();
        group1.removeEmployee(1);
        group1.printEmployeesInfo();
    }
}
