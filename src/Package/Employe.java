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

    protected int idEmploye;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected String mail;
    protected List<Competence> competenceList = new ArrayList<>();
    public Employe(int idEmploye, String matricule, String nom, String prenom){
        this.idEmploye = idEmploye;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }
    public Employe(int idEmploye,String matricule, String nom, String prenom, String tel, String mail) {
        this.idEmploye = idEmploye;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.mail = mail;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Competence> getC() {
        return competenceList;
    }

    public void setC(List<Competence> c) {
        this.competenceList = c;
    }


    /*
    le niveau allant de 1 à 10

    int niveau ==> Java 1
    int niveau ==> C++ 2


    */
    public void addDiscipline(Discipline d, int niveau){
        Competence test = new Competence(niveau,d);
        competenceList.add(test);
    }

    public List<Competence> disciplineEtNiveau(){
        return this.competenceList;
    }

    public void modifDiscipline(Discipline d, int niveau) {
        for (int i = 0; i < this.disciplineEtNiveau().size(); i++) {
            if (this.disciplineEtNiveau().get(i).getDiscipline().equals(d)) {
                this.competenceList.get(i).setNiveau(niveau);
            }
        }
    }

        public void suppDiscipline(Discipline d){
            for (int i = 0; i < this.disciplineEtNiveau().size(); i++) {
                if(this.disciplineEtNiveau().get(i).getDiscipline().equals(d)){
                    this.competenceList.remove(i);
                }
            }

    }




}
