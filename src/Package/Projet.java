package Package;

import java.util.*;

public class Projet {

    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private double cout;
    private List<Discipline> disci = new ArrayList<>();
    private List<Travail> tra = new ArrayList<>();
    public Projet(String nom, Date dateDebut, Date dateFin, double cout) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.cout = cout;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public List<Discipline> getDisci() {
        return disci;
    }

    public void setDisci(List<Discipline> disci) {
        this.disci = disci;
    }



}
