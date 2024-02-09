package Package;

import java.util.*;

public class Employe{

    private String matricule;
    private String nom;
    private String prenom;
    private String tel;
    private String mail;
    private List<Competence>c = new ArrayList<>();
    public Employe(String matricule, String nom, String prenom, String tel, String mail) {
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




}
