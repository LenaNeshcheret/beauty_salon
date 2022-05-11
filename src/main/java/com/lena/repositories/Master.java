package com.lena.repositories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Master extends User {

    private String profession;
    private int payment;
    private BigDecimal rating;

    public Master() {
    };

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Master{" + super.toString() +
                "profession='" + profession + '\'' +
                ", payment=" + payment +
                ", rating=" + rating +
                "} ";
    }

    public static class Builder {
        private Master master;

        public Builder() {
            master = new Master();
        }

        public Builder withId(int id) {
            master.id = id;
            return this;
        }

        public Builder withName(String name) {
            master.name = name;
            return this;
        }

        public Builder withPhone(int phone) {
            master.phone = phone;
            return this;
        }

        public Builder withAddress(String address) {
            master.address = address;
            return this;
        }


        public Builder withEmail(String email) {
            master.email = email;
            return this;
        }


        public Builder withBirthday(LocalDateTime birthday) {
            master.birthday = birthday;
            return this;
        }


        public Builder withDiscount(Discount discount) {
            master.discount = discount;
            return this;
        }


        public Builder withLogin(String login) {
            master.login = login;
            return this;
        }

        public Builder withProfession(String profession) {
            master.profession = profession;
            return this;
        }

        public Builder withPayment(int payment) {
            master.payment = payment;
            return this;
        }
        public Builder withRating(BigDecimal rating) {
            master.rating = rating;
            return this;
        }
        public Master build(){
            return master;
        }
    }
}
