package com.kadai10.employee.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateForm {
    @NotBlank
    private String name;
    @Min(value = 18)
    private int age;
    @NotNull
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
