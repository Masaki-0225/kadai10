package com.kadai10.employee.entity;

public class Employee {
    private Integer id;
    private String name;
    private int age;
    private String mail;

    public Employee(Integer id, String name, int age, String mail) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public Employee(String name, int age, String mail) {
        this.id = null;
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public int getAge() {
        return age;
    }

    public void update(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }
}
