package designpatterns.observer;

import java.time.LocalDate;
import java.util.*;
/**
 * Classe Travail
 *
 * @author Kirashigan
 * @version 1.0
 *
 */
public class Travail {
    /**
     * Permet d'incrémenter l'identifiant automatiquement
     */
    protected static int idIncrementation = 1;
    /**
     * identifiant d'un travail
     */

    protected int idTravail;
    /**
     * Pourcentage de contribution sur un travail d'un employé
     */
    protected int pourcentage;
    /**
     * Date d'engagement d'un employé sur un travail
     */
    protected Date dateEngag;
    /**
     * Employé sur un travail
     */
    protected Employe employe;

    /**
     * Permet d'ajouter un travail avec ses parametres
     * auto incrémentation avec idIncrementation
     * @param pourcentage implication dans le travail
     * @param dateEngag date d'engagement dans le travail
     */
    public Travail(int pourcentage, Date dateEngag) {
        this.idTravail = idIncrementation++;
        this.pourcentage = pourcentage;
        this.dateEngag = dateEngag;
    }
    public Travail(Employe employe, int pourcentage, Date dateEngag) {
        this.employe= employe;
        this.pourcentage = pourcentage;
        this.dateEngag = dateEngag;
    }

    /**
     * @return Retourne le pourcentage de l'employé sur un travail
     */
    public int getPourcentage() {
        return pourcentage;
    }

    /**
     * @param pourcentage Changer l'implication d'un employé dans un travail
     */
    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    /**
     * @return Retourne la date d'engagment d'un employé sur un travail
     */
    public Date getDateEngag() {
        return dateEngag;
    }

    /**
     * @param dateEngag Changer la date d'engagement d'un travailleur
     */
    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }

    /**
     * @return Retourne l'identifiant d'un travail
     */
    public int getIdTravail() {
        return idTravail;
    }

    /**
     * @param idTravail Permet de changer l'identifiant d'un travail
     */
    public void setIdTravail(int idTravail) {
        this.idTravail = idTravail;
    }

    /**
     * @return Retroune les informations sur un employé
     */
    public Employe getEmploye() {
        return employe;
    }

    /**
     * @param employe Permet de changer les infos sur un employé
     */
    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    /**
     * Indique si un autre objet est "égal" à celui-ci.
     * La méthode compare cet objet à un autre objet spécifié.
     *
     * @param o l'objet à comparer avec cet objet.
     * @return {@code true} si les objets sont égaux ; {@code false} sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travail travail = (Travail) o;
        return idTravail == travail.idTravail && pourcentage == travail.pourcentage && Objects.equals(dateEngag, travail.dateEngag) && Objects.equals(employe, travail.employe);
    }
    /**
     * Retourne un code de hachage pour l'objet.
     * @return le code de hachage de l'objet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idTravail, pourcentage, dateEngag, employe);
    }

    /**
     * Retourne une représentation sous forme de texte de la classe Travail
     * @return Une chaîne de caractères représentant cet objet.
     */
    @Override
    public String toString() {
        return "Travail:"+
                "\nidTravail: " + idTravail +
                "\npourcentage: " + pourcentage +
                "\ndateEngag: " + dateEngag +
                "\nemploye: " + employe.toString();
    }
}

