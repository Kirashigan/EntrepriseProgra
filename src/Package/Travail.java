package Package;

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
     * @param idTravail unique
     * @param pourcentage implication dans le travail
     * @param dateEngag date d'engagement dans le travail
     */
    public Travail(int idTravail, int pourcentage, Date dateEngag) {
        this.idTravail = idTravail;
        this.pourcentage = pourcentage;
        this.dateEngag = dateEngag;
    }
    public Travail(Employe employe,  int pourcentage, Date dateEngag) {
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
}
