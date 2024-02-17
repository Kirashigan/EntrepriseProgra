package Package;

import java.math.*;
import java.util.*;
/**
 * classe Projet
 *
 * @author Kirashigan
 * @version 1.0
 *
 */
public class Projet {
    protected int idProjet;

    protected String nom;
    protected Date dateDebut;
    protected Date dateFin;
    protected BigDecimal cout;
    protected List<Discipline> disciplineList = new ArrayList<>();
    protected List<Travail> travailList = new ArrayList<>();
    public Projet(int idProjet, String nom, Date dateDebut, Date dateFin, BigDecimal cout) {
        this.idProjet = idProjet;
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.cout = cout;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }


    public BigDecimal getCout() {
        return cout;
    }

    public void setCout(BigDecimal cout) {
        this.cout = cout;
    }

    public List<Discipline> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<Discipline> disciplineList) {
        this.disciplineList = disciplineList;
    }

    public List<Travail> getTravailList() {
        return travailList;
    }

    public void setTravailList(List<Travail> travailList) {
        this.travailList = travailList;
    }

    public void addEmploye(Employe e, int pourcent, Date dateDebut){
        int c;
        Travail test = new Travail(e,pourcent,dateDebut);
        this.travailList.add(test);
    }

    public List<Travail> listeEmployesEtPourcentageEtDate(){
        return this.travailList;
    }
    public void supEmploye(Employe e){
        for (int i = 0; i < this.getTravailList().size(); i++) {
            if (this.getTravailList().get(i).getE().equals(e)){
                this.getTravailList().remove(i);
            }
        }
    }
    public void modifEmploye(Employe e, int pourcent){
        for (int i = 0; i < this.getTravailList().size(); i++) {
            if (this.getTravailList().get(i).getE().equals(e)){
                this.getTravailList().get(i).setPourcentage(pourcent);
            }
        }
    }
    public int totalPourcentage(){
        int pour=0;
        for (int i = 0; i < this.getTravailList().size(); i++) {
            pour =pour+ this.travailList.get(i).getPourcentage();
        }
        return pour;
    }
    public void listeEmployesDisciplineBase(int niveau){

    }


}
