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
     * identifiant unique de l'employé
     */
    protected int idEmploye;
    /**
     * matricule de l'employé
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
     * numéro de téléphone de l'employé
     */
    protected String tel;
    /**
     * adresse mail de l'employé
     */
    protected String mail;
    /**
     * liste des compétences de l'employé
     */
    protected List<Competence> competenceList = new ArrayList<>();

    /**
     * Permet d'ajouter un employé avec tout ses parametres
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
     * permet d'ajouter un employé avec des parametres supplémentaire
     * @param idEmploye identifiant unique de l'employé
     * @param matricule matricule de l'employé
     * @param nom nom de l'employé
     * @param prenom prenom de l'employé
     * @param tel numéro de téléphone de l'employé
     * @param mail adresse mail de l'employé
     */
    public Employe(int idEmploye,String matricule, String nom, String prenom, String tel, String mail) {
        this.idEmploye = idEmploye;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
    }

    /**
     * Permet de retourner le matricule
     * @return le matricule
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * Permet de changer le matricule
     * @param matricule
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    /**
     * Permet de retourner le nom
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * permet de changer le nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * permet de retourner le prenom
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Permet de changer le prenom
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Permet de retourner le numéro de téléphone
     * @return
     */
    public String getTel() {
        return tel;
    }

    /**
     * permet de changer le numéro de téléphone
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * permet de retourner l'adresse mail
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     * Permet de changer l'adresse mail
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Permet de retourner une liste de compétence
     * @return competenceList
     */
    public List<Competence> getCompetenceList() {
        return competenceList;
    }

    /**
     * Permet de changer une liste de competence
     * @param competenceList
     */
    public void setCompetenceList(List<Competence> competenceList) {
        this.competenceList = competenceList;
    }


    /**
     * methode ajout d'une discipline et un niveau
     * @param d Ajout une discipline
     * @param niveau Ajout d'un niveau
     */
    public void addDiscipline(Discipline d, int niveau){
        Competence test = new Competence(niveau,d);
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
     * Modifie le niveau d'une discipline d
     * @param d
     * @param niveau
     */
    public void modifDiscipline(Discipline d, int niveau) {
        for (Competence c : competenceList){
            if(c.getDiscipline().equals(d)){
                c.setNiveau(niveau);
                return;
            }
        }
        System.out.println("Aucune discipline "+ d.getNom()+" n'a été trouvée");
    }

    /**
     * Supprime la discipline d
     * @param d
     */
        public void suppDiscipline(Discipline d){
            for (Competence c : competenceList){
                if(c.getDiscipline().equals(d)){
                    competenceList.remove(c);
                    return;
                }
            }
            System.out.println("Aucune discipline de ce nom n'a été répertoriée");

        }




}
