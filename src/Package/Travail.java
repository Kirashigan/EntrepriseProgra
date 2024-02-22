package Package;

import java.time.LocalDate;
import java.util.*;
/**
 * classe Travail
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
     * pourcentage de contribution sur un travail d'un employé
     */
    protected int pourcentage;
    /**
     * date d'engagement d'un employé sur un travail
     */
    protected Date dateEngag;
    /**
     * Employé sur un travail
     */
    protected Employe e;

    /**
     * Permet d'ajouter un travail avec ses parametres
     * @param idTravail unique
     * @param pourcentage
     * @param dateEngag
     */
    public Travail(int idTravail, int pourcentage, Date dateEngag) {
        this.idTravail = idTravail;
        this.pourcentage = pourcentage;
        this.dateEngag = dateEngag;
    }
    public Travail(Employe e,  int pourcentage, Date dateEngag) {
        this.e= e;
        this.pourcentage = pourcentage;
        this.dateEngag = dateEngag;
    }

    /**
     * retourne le pourcentage de l'employé sur un travail
     * @return
     */
    public int getPourcentage() {
        return pourcentage;
    }

    /**
     * changer l'implication d'un employé dans un travail
     * @param pourcentage
     */
    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    /**
     * retourne la date d'engagment d'un employé sur un travail
     * @return
     */
    public Date getDateEngag() {
        return dateEngag;
    }

    /**
     * Changer la date d'engagement d'un travailleur
     * @param dateEngag
     */
    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }

    /**
     * retourne l'identifiant d'un travail
     * @return
     */
    public int getIdTravail() {
        return idTravail;
    }

    /**
     * Permet de changer l'identifiant d'un travail
     * @param idTravail
     */
    public void setIdTravail(int idTravail) {
        this.idTravail = idTravail;
    }

    /**
     * Retroune les informations sur un employé
     * @return
     */
    public Employe getE() {
        return e;
    }

    /**
     * Permet de changer les infos sur un employé
     * @param e
     */
    public void setE(Employe e) {
        this.e = e;
    }
}
