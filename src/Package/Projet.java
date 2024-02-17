package Package;

import java.math.*;
import java.util.*;
/**
 * classe Projet
 *
 * @author Kirashigan
 * @version 1.0
 *
 */
public class Projet {
    protected int idProjet;

    protected String nom;
    protected Date dateDebut;
    protected Date dateFin;
    protected BigDecimal cout;
    protected List<Discipline> disci = new ArrayList<>();
    protected List<Travail> tra = new ArrayList<>();
    public Projet(int idProjet, String nom, Date dateDebut, Date dateFin, BigDecimal cout) {
        this.idProjet = idProjet;
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


    public List<Discipline> getDisci() {
        return disci;
    }

    public void setDisci(List<Discipline> disci) {
        this.disci = disci;
    }


    private void addEmploye(Employe e,Travail pourcentage, Projet dateDebut){

    }




}
