import Package.*;

import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int po;
        Date date1 = new Date();
        Date date2 = new Date();
        BigDecimal b = new BigDecimal(15000);

        //instantiation d'employé pour essayer les fonctions
        Employe employe1 = new Employe("M1","Test","Test");
        Employe employe2 = new Employe("M2","Test1","Test1");
        Discipline discipline1 = new Discipline("test1","test1");
        Discipline discipline2 = new Discipline("test2","test2");
        Discipline discipline3 = new Discipline("test3","test3");
        Projet projet1 = new Projet("projet1",date1,date2,b);
        /*

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
*/
//Modification OK

        employe1.modifDiscipline(discipline1,10);
        employe1.modifDiscipline(discipline2,3);
/*
        for (int i = 0; i < employe1.disciplineEtNiveau().size(); i++) {
            System.out.println((i+1)+" Discipline: "+employe1.disciplineEtNiveau().get(i).getDiscipline().getNom()+ "\nNiveau: " + employe1.disciplineEtNiveau().get(i).getNiveau());
        }

*/


//Suppression OK
        employe1.suppDiscipline(discipline1);
        employe1.suppDiscipline(discipline3);
        /*
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
        /*
        System.out.println(projet1.getNom());
        for (int i = 0; i < projet1.getTravailList().size(); i++) {
            System.out.println("\nEmploye: "+projet1.getTravailList().get(i).getEmploye().getPrenom()+"\nDate engagement: "+projet1.getTravailList().get(i).getDateEngag());
        }
        projet1.modifEmploye(employe1,70);
        projet1.modifEmploye(employe2,30);
        for (int i = 0; i < projet1.getTravailList().size(); i++) {
            System.out.println("\nEmploye: "+projet1.getTravailList().get(i).getEmploye().getPrenom()+"\nDate engagement: "+projet1.getTravailList().get(i).getDateEngag()+"\nPourcent: "+projet1.getTravailList().get(i).getPourcentage());
        }
        po = projet1.totalPourcentage();
        System.out.println("\n"+po);
        projet1.supEmploye(employe1);

        for (int i = 0; i < projet1.getTravailList().size(); i++) {
            System.out.println("\nEmploye: "+projet1.getTravailList().get(i).getEmploye().getPrenom()+"\nDate engagement: "+projet1.getTravailList().get(i).getDateEngag());
        }
        po = projet1.totalPourcentage();
        System.out.println("\n"+po);
*/
//        System.out.println(projet1.toString());
//        System.out.println(discipline1.hashCode());
        System.out.println(discipline1.getIdDiscipline());
        System.out.println(discipline2.getIdDiscipline());
        System.out.println(discipline3.getIdDiscipline());
    }



}