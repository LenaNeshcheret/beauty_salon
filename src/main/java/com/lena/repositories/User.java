package com.lena.repositories;

import java.time.LocalDateTime;


public abstract class User {
    private int id;
    private String name;
    private int phone;
    private String address;
    private String email;
    private LocalDateTime birthday;
    private Discount discount;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", discount=" + discount +
                '}';
    }

    public User() {

    }

    public User(String name, int phone, String adress, String email, LocalDateTime birthday, Discount discount) {
        this.name = name;
        this.phone = phone;
        this.address = adress;
        this.email = email;
        this.birthday = birthday;
        this.discount = discount;
    }

    public User(int id, String name, int phone, String adress, String email, LocalDateTime birthday, Discount discount) {
        this(name, phone, adress, email, birthday, discount);
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public Discount getDiscount() {
        return discount;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}

