package com.ehb.examen.Model;

import javax.persistence.*;

@Entity
public class Bod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int prijs;

    @OneToOne()
    private Persoon persoonId;

    @OneToOne
    private Product productId;

    public Bod(int prijs,Product productId) {
        this.prijs = prijs;

        this.productId = productId;
    }

    public Persoon getPersoonId() {
        return persoonId;
    }

    public void setPersoonId(Persoon persoonId) {
        this.persoonId = persoonId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }


    public Bod() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setPrijs(int prijs) {
        this.prijs = prijs;
    }
}
