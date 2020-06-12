package com.ehb.examen.Model;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String naam;
    private int startprijs;
    private LocalDateTime date;

    public Persoon getPeroon() {
        return peroon;
    }

    public void setPeroon(Persoon peroon) {
        this.peroon = peroon;
    }

    @OneToOne()
    private Persoon peroon;

    public Product() {
    }

    public Product(String naam, int startprijs, LocalDateTime date) {
        this.naam = naam;
        this.startprijs = startprijs;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getStartprijs() {
        return startprijs;
    }

    public void setStartprijs(int startprijs) {
        this.startprijs = startprijs;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
