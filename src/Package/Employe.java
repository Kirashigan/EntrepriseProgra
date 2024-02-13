package Package;

import java.util.*;

public class Employe{

    protected int idEmploye;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected String mail;
    protected List<Competence>c = new ArrayList<>();
    protected DisciplineEtNiveau disEtNiv;
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
        return c;
    }

    public void setC(List<Competence> c) {
        this.c = c;
    }


    private void listeDisciplinesEtNiveau(){
        List<Integer> Niveau = null;
        List<Discipline> Discipline = null;
        for(Competence com : c){
            Niveau.add(com.getNiveau());
            Discipline.add(com.getDiscipline());
        }
        disEtNiv.setDisEtNiv(Discipline, Niveau);
    }
    private void addDiscipline(Discipline d,Competence co){
        Competence test = new Competence(co.getNiveau(),d);
        c.add(test);
    }




}
