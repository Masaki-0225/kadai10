package com.kadai10.employee.entity;

public class CreateForm {
    private String name;
    private int age;
    private String mail;

    public CreateForm(String name, int age, String mail) {
        this.name = name;
        this.age = age;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }
}
