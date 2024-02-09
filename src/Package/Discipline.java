package Package;

import java.util.*;

public class Discipline {
    private String nom;
    private String description;
    private List<Projet> projet=new ArrayList<>();

    public Discipline(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Projet> getProjet() {
        return projet;
    }

    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }




}
