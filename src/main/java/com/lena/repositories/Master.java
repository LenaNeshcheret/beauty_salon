package com.lena.repositories;

public class Master extends User {

    private String profession;
    private int payment;
    private int rating;

    public Master(){
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
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

}
