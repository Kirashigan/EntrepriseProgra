package Package;

import java.math.*;
import java.util.*;

/**
 * Classe Projet
 *
 * @author Kirashigan
 * @version 1.0
 */
public class Projet {
    /**
     * Permet d'incrémenter l'identifiant automatiquement
     */
    protected static int idIncrementation = 1;
    /**
     * Identifiant unique d'un projet
     */
    protected  int idProjet;
    /**
     * Nom du projet
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
     * Discipline de base du projet
     */
    protected Discipline discipline;
    /**
     * Liste de travail d'un travail
     */
    protected List<Travail> travailList = new ArrayList<>();

    /**
     * Permet d'ajouter un projet avec tous ses parametres
     * auto-incrémentation
     *
     * @param nom Nom du projet
     * @param dateDebut Date de début de projet
     * @param dateFin Date de fin de projet
     * @param cout Cout du projet
     */
    public Projet(String nom, Date dateDebut, Date dateFin, BigDecimal cout) {
        this.idProjet = idIncrementation++;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.cout = cout;
    }

    /**
     * @return  Retourne le nom du projet
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom  Change le nom du projet
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return  Retourne la date de début du projet
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut Change la date de début du projet
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return Retourne la date de fin de projet
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin Changer la date de fin du projet
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @return Retourne le coût du projet
     */
    public BigDecimal getCout() {
        return cout;
    }

    /**
     * @param cout Changer le coût du projet
     */
    public void setCout(BigDecimal cout) {
        this.cout = cout;
    }

    /**
     * @return retourne la discipline du projet
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * @param discipline Permet de changer la discipline du projet
     */
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    /**
     * @return Retourne une liste des employés qui travaillent sur le projet
     */
    public List<Travail> getTravailList() {
        return travailList;
    }

    /**
     * @param travailList Changer une liste d'employés qui travaillent sur un projet
     */
    public void setTravailList(List<Travail> travailList) {
        this.travailList = travailList;
    }

    /**
     * Ajouter un employé, sa contribution dans le travail et sa date de début sur le projet
     *
     * @param employe l'employé à ajouter
     * @param pourcent implicaton dans le projet
     * @param dateDebut date de début dans le projet
     */
    public void addEmploye(Employe employe, int pourcent, Date dateDebut) {
        int c;
        Travail test = new Travail(employe, pourcent, dateDebut);
        this.travailList.add(test);
    }

    /**
     * @return Retourne la liste des employés, le pourcentage et la date des projets
     */
    public List<Travail> listeEmployesEtPourcentageEtDate() {
        return this.travailList;
    }

    /**
     * @param employe Permet de supprimer un employé d'un projet
     */
    public void supEmploye(Employe employe) {
        boolean flag = true;
        for (int i = 0; i < this.getTravailList().size(); i++) {
            if (this.getTravailList().get(i).getEmploye().equals(employe)) {
                this.getTravailList().remove(i);
                flag = false;
            }
        }
        if (flag) {
            System.out.println(employe.getPrenom() + " n'a pas été retrouvé dans ce projet.");
        }
    }

    /**
     * Permet de changer la contribution d'un employé sur un projet
     * @param employe
     * @param pourcent
     */
    public void modifEmploye(Employe employe, int pourcent) {
        for (int i = 0; i < this.getTravailList().size(); i++) {
            if (this.getTravailList().get(i).getEmploye().equals(employe)) {
                this.getTravailList().get(i).setPourcentage(pourcent);
            }
        }
    }

    /**
     * @return Retourne la contribution totale des employés dans un projet.
     */
    public int totalPourcentage() {
        int pour = 0;
        for (int i = 0; i < this.getTravailList().size(); i++) {
            pour = pour + this.travailList.get(i).getPourcentage();
        }
        return pour;
    }

    /**
     * @param niveau niveau minimum recherché dans la discipline voulu parmit tous les employés de la discipline.
     * @return retourner une liste d'employé qui sont plus qualifié que les employés déjà sur le projet.
     */
    public List<Employe> listeEmployesDisciplineBase(int niveau) {
        List<Employe> listeplusqualifie = new ArrayList<>();
        for (int i = 0; i < travailList.size(); i++) {
            for (int j = 0; j < travailList.get(i).getEmploye().competenceList.size(); j++) {
                if(travailList.get(i).getEmploye().competenceList.get(j).getNiveau()>niveau && travailList.get(i).getEmploye().competenceList.get(j).getDiscipline().equals(this.discipline)){
                    listeplusqualifie.add(travailList.get(i).getEmploye());
                }
            }
        }
        return listeplusqualifie;
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
        Projet projet = (Projet) o;
        return idProjet == projet.idProjet;
    }
    /**
     * Retourne un code de hachage pour l'objet.
     * @return le code de hachage de l'objet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idProjet);
    }

    /**
     * Retourne une représentation sous forme de texte de la classe Projet
     * @return Une chaîne de caractères représentant cet objet.
     */
    @Override
    public String toString() {
        return "Projet :" +
                "\nidProjet : " + idProjet +
                "\nnom :'" + nom + '\'' +
                "\ndateDebut : " + dateDebut +
                "\ndateFin : " + dateFin +
                "\ncout : " + cout +
                "\ndiscipline : " + discipline +
                "\ntravailList : " + travailList.toString();
    }
}



