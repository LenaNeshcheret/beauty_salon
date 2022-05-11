package com.lena.repositories;

import java.time.LocalDateTime;


public abstract class User {
    protected int id;
    protected String name;
    protected int phone;
    protected String address;
    protected String email;
    protected LocalDateTime birthday;
    protected Discount discount;
    protected String login;
    protected String password;



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
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {

    }

    public User(String name, int phone, String adress, String email, LocalDateTime birthday, Discount discount,
                String login, String password) {
        this.name = name;
        this.phone = phone;
        this.address = adress;
        this.email = email;
        this.birthday = birthday;
        this.discount = discount;
        this.login=login;
        this.password = password;
    }

    public User(int id, String name, int phone, String adress, String email, LocalDateTime birthday, Discount discount,
                String login, String password) {
        this(name, phone, adress, email, birthday, discount, login, password);
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

