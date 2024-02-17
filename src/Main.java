import Package.*;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int po;
        List<Competence> C = new ArrayList<>();
        Competence Comp;
        Date date1 = new Date();
        Date date2 = new Date();
        BigDecimal b = new BigDecimal(15000);
        BigDecimal a = new BigDecimal(25000);

        //instantiation d'employé pour essayer les fonctions (trois)
        Employe employe1 = new Employe(1,"M1","Test","Test");
        Employe employe2 = new Employe(2,"M2","Test1","Test1");
        Employe employe3 = new Employe(3,"M3","Test2","Test2");
        Discipline discipline1 = new Discipline(1,"test1","test1");
        Discipline discipline2 = new Discipline(1,"test2","test2");
        Discipline discipline3 = new Discipline(1,"test3","test3");
        Projet projet1 = new Projet(1,"projet1",date1,date2,b);
        Projet projet2 = new Projet(2,"projet2",date1,date2,a);
        /*
        Dans les conditions de test, je ne vais pas mettre de limite mais normalement le niveau
        va de 0 à 10.

        TEST:

        add discipline OKK
         */

        employe1.addDiscipline(discipline1,2);
        employe1.addDiscipline(discipline2,10);
        employe2.addDiscipline(discipline2, 5);
/*
        for (int i = 0; i < employe1.disciplineEtNiveau().size(); i++) {
            System.out.println((i+1)+" Discipline: "+employe1.disciplineEtNiveau().get(i).getDiscipline().getNom()+ "\nNiveau: " + employe1.disciplineEtNiveau().get(i).getNiveau());
        }

//Modification OK

        employe1.modifDiscipline(discipline1,10);
        employe1.modifDiscipline(discipline2,3);

        for (int i = 0; i < employe1.disciplineEtNiveau().size(); i++) {
            System.out.println((i+1)+" Discipline: "+employe1.disciplineEtNiveau().get(i).getDiscipline().getNom()+ "\nNiveau: " + employe1.disciplineEtNiveau().get(i).getNiveau());
        }
*/


/*
//Suppression OK
        employe1.suppDiscipline(discipline1);
        for (int i = 0; i < employe1.disciplineEtNiveau().size(); i++) {
            System.out.println((i+1)+" Discipline: "+employe1.disciplineEtNiveau().get(i).getDiscipline().getNom()+ "\nNiveau: " + employe1.disciplineEtNiveau().get(i).getNiveau());
        }
*/

        /*
        ========================================================

        TEST PROJET:
         */

        projet1.addEmploye(employe1,50,date1);
        projet1.addEmploye(employe2,50,date2);
        System.out.println(projet1.getNom());
        for (int i = 0; i < projet1.getTravailList().size(); i++) {
            System.out.println("\nEmploye: "+projet1.getTravailList().get(i).getE().getPrenom()+"\nDate engagement: "+projet1.getTravailList().get(i).getDateEngag());
        }
        projet1.modifEmploye(employe1,70);
        projet1.modifEmploye(employe2,30);
        for (int i = 0; i < projet1.getTravailList().size(); i++) {
            System.out.println("\nEmploye: "+projet1.getTravailList().get(i).getE().getPrenom()+"\nDate engagement: "+projet1.getTravailList().get(i).getDateEngag()+"\nPourcent: "+projet1.getTravailList().get(i).getPourcentage());
        }
        po = projet1.totalPourcentage();
        System.out.println("\n"+po);
        projet1.supEmploye(employe1);

        for (int i = 0; i < projet1.getTravailList().size(); i++) {
            System.out.println("\nEmploye: "+projet1.getTravailList().get(i).getE().getPrenom()+"\nDate engagement: "+projet1.getTravailList().get(i).getDateEngag());
        }
        po = projet1.totalPourcentage();
        System.out.println("\n"+po);
    }
}