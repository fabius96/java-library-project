package com.survivalcoding.library.domain.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    
    private int id;
    private String name;
    private int gender;
    private int age;
    private String address;
    private String number;
    private Date birthDate;
    private Date joinDate;

    public User(String name) {
        this(name, 0, 0, null, null, null, null);
    }

    public User(String name, int gender, int age, String address, String number,
            Date birthDate, Date joinDate) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.number = number;
        this.birthDate = birthDate;
        this.joinDate = joinDate;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public int getGender() {
        return gender;
    }



    public void setGender(int gender) {
        this.gender = gender;
    }



    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        this.age = age;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public String getNumber() {
        return number;
    }



    public void setNumber(String number) {
        this.number = number;
    }



    public Date getBirthDate() {
        return birthDate;
    }



    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



    public Date getJoinDate() {
        return joinDate;
    }



    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }



    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age
                + ", address=" + address + ", number=" + number + ", birthDate=" + birthDate
                + ", joinDate=" + joinDate + "]";
    }

}
