package com.lena.repositories;

import java.time.LocalDateTime;

public class Feedback {
    private int id;
    private LocalDateTime date;
    private Client client;
    private Master master;
    private String feedback;
    private int rating;

    public Feedback (LocalDateTime date, int id, int clientId, int masterId, int rating) {
        this.date = date;
        this.id = id;
        this.client = client;
        this.master = master;
        this.rating=rating;
    }

    public Feedback (LocalDateTime date, int id, int clientId, int masterId, int rating, String feedback) {
        this.date = date;
        this.id = id;
        this.client = client;
        this.master = master;
        this.rating=rating;
        this.feedback=feedback;
    }
    public Feedback(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Master getMaster() {
        return master;
    }

    public void setMaster(Master master) {
        this.master = master;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", date=" + date +
                ", client=" + client +
                ", master=" + master +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                '}';
    }
}
