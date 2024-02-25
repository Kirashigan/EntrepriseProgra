package Package;

import java.util.*;

/**
 * classe Employe
 *
 * @author Kirashigan
 * @version 1.0
 *
 */


public class Employe{
    /**
     * Identifiant unique de l'employé
     */
    protected int idEmploye;
    /**
     * Matricule de l'employé
     */
    protected String matricule;
    /**
     * nom de l'employé
     */
    protected String nom;
    /**
     * prenom de l'employé
     */
    protected String prenom;
    /**
     * Numéro de téléphone de l'employé
     */
    protected String telephone;
    /**
     * Adresse mail de l'employé
     */
    protected String adresseMail;
    /**
     * Liste des compétences de l'employé
     */
    protected List<Competence> competenceList = new ArrayList<>();

    /**
     * Permet d'ajouter un employé avec tous ses parametres
     * @param idEmploye identifiant unique
     * @param matricule matricule de l'employé
     * @param nom nom de l'employé
     * @param prenom prenom de l'employé
     */
    public Employe(int idEmploye, String matricule, String nom, String prenom){
        this.idEmploye = idEmploye;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * Permet d'ajouter un employé avec des parametres supplémentaire
     * @param idEmploye identifiant unique de l'employé
     * @param matricule matricule de l'employé
     * @param nom nom de l'employé
     * @param prenom prenom de l'employé
     * @param telephone numéro de téléphone de l'employé
     * @param adresseMail adresse mail de l'employé
     */
    public Employe(int idEmploye,String matricule, String nom, String prenom, String telephone, String adresseMail) {
        this.idEmploye = idEmploye;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.adresseMail = adresseMail;
    }

    /**
     * @return Permet de retourner le matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * @param matricule Permet de changer le matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * @return Permet de retourner le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom permet de changer le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return permet de retourner le prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom Permet de changer le prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return Permet de retourner le numéro de téléphone
     */
    public String getNumeroTelephone() {
        return telephone;
    }

    /**
     * @param telephone Permet de changer le numéro de téléphone
     */
    public void setNumeroTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return Permet de retourner l'adresse mail
     */
    public String getAdresseMail() {
        return adresseMail;
    }

    /**
     * @param adresseMail Permet de changer l'adresse mail
     */
    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    /**
     * @return competenceList Permet de retourner une liste de compétence
     */
    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    /**
     * @param competenceList Permet de changer une liste de competence
     */
    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }


    /**
     * Methode ajout d'une discipline et un niveau
     * @param discipline Ajout une discipline
     * @param niveau Ajout d'un niveau
     */
    public void addDiscipline(Discipline discipline, int niveau){
        Competence test = new Competence(niveau,discipline);
        competenceList.add(test);
    }

    /**
     * Retourne la liste des compétences
     * @return une liste de compétences
     */

    public List<Competence> disciplineEtNiveau(){
        return this.competenceList;
    }

    /**
     * Modifie le niveau d'une discipline
     * @param discipline
     * @param niveau
     */
    public void modifDiscipline(Discipline discipline, int niveau) {
        for (Competence c : competenceList){
            if(c.getDiscipline().equals(discipline)){
                c.setNiveau(niveau);
                return;
            }
        }
        System.out.println("Aucune discipline "+ discipline.getNom()+" n'a été trouvée");
    }

    /**
     * @param discipline Supprime la discipline d
     */
        public void suppDiscipline(Discipline discipline){
            for (Competence c : competenceList){
                if(c.getDiscipline().equals(discipline)){
                    competenceList.remove(c);
                    return;
                }
            }
            System.out.println("Aucune discipline de ce nom n'a été répertoriée");

        }




}
