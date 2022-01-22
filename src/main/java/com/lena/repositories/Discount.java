package com.lena.repositories;

public class Discount {

    private int id;
    private int accumulateCard;
    private int newYearDiscount;
    private int happyBirthdayDiscount;
    private int march8Discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccumulateCard() {
        return accumulateCard;
    }

    public void setAccumulateCard(int accumulateCard) {
        this.accumulateCard = accumulateCard;
    }

    public int getNewYearDiscount() {
        return newYearDiscount;
    }

    public void setNewYearDiscount(int newYearDiscount) {
        this.newYearDiscount = newYearDiscount;
    }

    public int getHappyBirthdayDiscount() {
        return happyBirthdayDiscount;
    }

    public void setHappyBirthdayDiscount(int happyBirthdayDiscount) {
        this.happyBirthdayDiscount = happyBirthdayDiscount;
    }

    public int getMarch8Discount() {
        return march8Discount;
    }

    public void setMarch8Discount(int march8Discount) {
        this.march8Discount = march8Discount;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", accumulateCard=" + accumulateCard +
                ", newYearDiscount=" + newYearDiscount +
                ", happyBirthdayDiscount=" + happyBirthdayDiscount +
                ", march8Discount=" + march8Discount +
                '}';
    }
}
