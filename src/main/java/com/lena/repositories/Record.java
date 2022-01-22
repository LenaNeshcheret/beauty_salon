package com.lena.repositories;


import java.time.LocalDateTime;

public class Record {
    private int id;
    private LocalDateTime date;
    private Client client;
    private Master master;

    public Record() {
    }

    public Record(LocalDateTime date, int id, int clientId, int masterId) {
        this.date = date;
        this.id = id;
        this.client = client;
        this.master = master;
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

    @Override
    public String toString() {
        return "\"Record\"{" +
                "\"id="+" + id "+
                ", date=" + date +
                ", client=" + client +
                ", master=" + master +
                '}';
    }
}
