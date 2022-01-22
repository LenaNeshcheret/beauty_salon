package com.lena.repositories;

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
}
