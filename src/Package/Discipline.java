package Package;

import java.util.*;

/**
 * classe Discipline
 *
 * @author Kirashigan
 * @version 1.0
 *
 */

public class Discipline {
    protected int idDiscipline;
    protected String nom;
    protected String description;
    protected Projet projet;

    public Discipline(int idDiscipline,String nom, String description) {
        this.idDiscipline = idDiscipline;
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

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
}
