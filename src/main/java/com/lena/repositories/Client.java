package com.lena.repositories;

import java.io.PrintStream;
import java.time.LocalDateTime;


public class Client extends User{

    private int totalMany;

    @Override
    public String toString() {
        return "Client{" + super.toString() +
                "totalMany=" + totalMany +
                "} ";
    }

    public Client(){
    }

    public Client (String name, int phone, String adress, String email, LocalDateTime birthday, Discount discount, int totalMany){
        super();
        this.totalMany = totalMany;
    }

    public int getTotalMany() {
        return totalMany;
    }

    public void setTotalMany(int totalMany) {
        this.totalMany = totalMany;
    }

    public static class Builder {
        private Client client;

        public Builder() {
            client = new Client();
        }

        public Builder withId(int id) {
            client.id = id;
            return this;
        }

        public Builder withName(String name) {
            client.name = name;
            return this;
        }

        public Builder withPhone(int phone) {
            client.phone = phone;
            return this;
        }

        public Builder withAddress(String address) {
            client.address = address;
            return this;
        }


        public Builder withEmail(String email) {
            client.email = email;
            return this;
        }


        public Builder withBirthday(LocalDateTime birthday) {
            client.birthday = birthday;
            return this;
        }


        public Builder withDiscount(Discount discount) {
            client.discount = discount;
            return this;
        }


        public Builder withLogin(String login) {
            client.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            client.password = password;
            return this;
        }

        public Builder withTotalMany(int totalMany) {
            client.totalMany = totalMany;
            return this;
        }

        public Client build() {
            return client;
        }

    }
}
