package com.example.demo.webflux.Model;

public class Employee {

    private Integer id;
    private String name;
    private Integer age;
    private String cargo;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Employee [age=" + age + ", cargo=" + cargo + ", id=" + id + ", name=" + name + "]";
    }   
}
