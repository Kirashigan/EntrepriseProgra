package Package;

import java.math.*;
import java.util.*;

/**
 * classe Projet
 *
 * @author Kirashigan
 * @version 1.0
 */
public class Projet {
    /**
     * identifiant unique d'un projet
     */
    protected int idProjet;
    /**
     * nom du projet
     */
    protected String nom;
    /**
     * Date de debut d'un projet
     */
    protected Date dateDebut;
    /**
     * Date de fin de projet
     */
    protected Date dateFin;
    /**
     * Coût du projet
     */
    protected BigDecimal cout;
    /**
     * Liste de discipline d'un projet
     */
    protected List<Discipline> disciplineList = new ArrayList<>();
    /**
     * Liste de travail d'un travail
     */
    protected List<Travail> travailList = new ArrayList<>();

    /**
     * Permet d'ajouter un projet avec tout ses parametres
     *
     * @param idProjet
     * @param nom
     * @param dateDebut
     * @param dateFin
     * @param cout
     */
    public Projet(int idProjet, String nom, Date dateDebut, Date dateFin, BigDecimal cout) {
        this.idProjet = idProjet;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.cout = cout;
    }

    /**
     * Retourne le nom du projet
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom du projet
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la date de début du projet
     *
     * @return
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * change la date de début du projet
     *
     * @param dateDebut
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Retourne la date de fin de projet
     *
     * @return
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Changer la date de fin du projet
     *
     * @param dateFin
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Retourne le coût du projet
     *
     * @return
     */
    public BigDecimal getCout() {
        return cout;
    }

    /**
     * Changer le coût du projet
     *
     * @param cout
     */
    public void setCout(BigDecimal cout) {
        this.cout = cout;
    }

    /**
     * Retourne la liste de discipline utilisé dans un projet
     *
     * @return
     */
    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    /**
     * Permet de changer une liste de discipline d'un projet
     *
     * @param disciplineList
     */
    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    /**
     * Retourne une liste des employés qui travaillent sur le projet
     *
     * @return
     */
    public List<Travail> getTravailList() {
        return travailList;
    }

    /**
     * changer une liste d'employés qui travaillent sur un projet
     *
     * @param travailList
     */
    public void setTravailList(List<Travail> travailList) {
        this.travailList = travailList;
    }

    /**
     * Ajouter une employé, sa contribution dans le travail et sa date de début sur le projet
     *
     * @param e
     * @param pourcent
     * @param dateDebut
     */
    public void addEmploye(Employe e, int pourcent, Date dateDebut) {
        int c;
        Travail test = new Travail(e, pourcent, dateDebut);
        this.travailList.add(test);
    }

    /**
     * retourne la liste des employés, le pourcentage et la date des projets
     *
     * @return
     */
    public List<Travail> listeEmployesEtPourcentageEtDate() {
        return this.travailList;
    }

    /**
     * permet de supprimer un employé d'un projet
     *
     * @param e
     */
    public void supEmploye(Employe e) {
        boolean flag = true;
        for (int i = 0; i < this.getTravailList().size(); i++) {
            if (this.getTravailList().get(i).getE().equals(e)) {
                this.getTravailList().remove(i);
                flag = false;
            }
        }
        if (flag) {
            System.out.println(e.getPrenom() + " n'a pas été retrouvé dans ce projet.");
        }
    }

    /**
     * Permet de changer la contribution d'un employé sur un projet
     *
     * @param e
     * @param pourcent
     */
    public void modifEmploye(Employe e, int pourcent) {
        for (int i = 0; i < this.getTravailList().size(); i++) {
            if (this.getTravailList().get(i).getE().equals(e)) {
                this.getTravailList().get(i).setPourcentage(pourcent);
            }
        }
    }

    /**
     * retourne la contribution total des employés dans un projet.
     *
     * @return
     */
    public int totalPourcentage() {
        int pour = 0;
        for (int i = 0; i < this.getTravailList().size(); i++) {
            pour = pour + this.travailList.get(i).getPourcentage();
        }
        return pour;
    }

    /**
     * Me permet de retourner une liste d'employé qui sont plus qualifié que les employés déjà sur le projet.
     * @param niveau
     * @return
     */
    public List<Employe> listeEmployesDisciplineBase(int niveau) {
        List<Employe> listeplusqualifie = new ArrayList<>();
        for (int i = 0; i < travailList.size(); i++) {
            for (int j = 0; j < travailList.get(i).getE().competenceList.size(); j++) {
                if(travailList.get(i).getE().competenceList.get(j).getNiveau()>niveau){
                    listeplusqualifie.add(travailList.get(i).getE());
                }
            }
        }
        return listeplusqualifie;
    }
}



