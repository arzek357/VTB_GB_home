package com.vtb.zolotarev.homeWork2.entity;

import java.util.Arrays;
import java.util.Objects;

public class Group {
    private String name;
    private Employee[] groupState = new Employee[10];
    private int countOfEmployees = 0;

    public Group(String name){
        this.name=name;
    }

    public Group(String name,Employee... employees){
        this.name=name;
        if(employees.length<=10){
            System.arraycopy(employees,0,groupState,0,employees.length);
            countOfEmployees += employees.length;
        }
        else {
            System.out.println("Вы указали слишком много сотрудников! Максимальное число - 10!");
        }
    }

    public void addNewEmployee(Employee employee){
        if (employee==null){
            System.out.println("Невозможно добавить данного сотрудника!Информация о нем некорректна или отсутствует!");
            return;
        }
        if (countOfEmployees<10){
            countOfEmployees++;
            groupState[countOfEmployees-1]=employee;
        }
        else {
            System.out.println("В данной группе уже максимум сотрудников! Освободите место, прежде чем добавить нового.");
        }
    }

    public void removeEmployee(int index){
        if (index<0||index>9){
            System.out.println("Невозможно удалить сотрудника с таким индексом! Максимально возможный диапазон: 0-9");
            return;
        }
        else if(countOfEmployees-1<index){
            System.out.println("В данной группе отсутствует сотрудник с индексом "+index);
            return;
        }
        Employee[] newGroupState = new Employee[10];
        System.arraycopy(groupState,0,newGroupState,0,index);
        System.arraycopy(groupState,index+1,newGroupState,index,9-index);
        groupState=newGroupState;
        countOfEmployees--;
    }

    public void removeAll(){
        groupState = new Employee[10];
    }

    public void printEmployeesInfo(){
        for (int i =0;i<countOfEmployees;i++){
            System.out.println(groupState[i].toString()+"\n"+"Index in group: "+i+"\n");
        }
    }

    public String getName() {
        return name;
    }

    public Employee[] getGroupState() {
        return groupState;
    }

    public int getCountOfEmployees() {
        return countOfEmployees;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return countOfEmployees == group.countOfEmployees &&
                Objects.equals(name, group.name) &&
                Arrays.equals(groupState, group.groupState);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, countOfEmployees);
        result = 31 * result + Arrays.hashCode(groupState);
        return result;
    }
}
