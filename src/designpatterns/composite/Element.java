package designpatterns.composite;

import java.math.BigDecimal;

public abstract class Element {
    public int id;
    private static int idincrem = 0;
    private String nom;

    public Element(String nom) {
        this.id = idincrem++;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract BigDecimal coutTotal();
}
