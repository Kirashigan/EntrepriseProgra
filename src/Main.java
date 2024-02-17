import Package.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Competence> C = new ArrayList<>();
        Competence Comp;

        //instantiation d'employé pour essayer les fonctions (trois)
        Employe employe1 = new Employe(1,"M1","Test","Test");
        Employe employe2 = new Employe(2,"M2","Test1","Test1");
        Employe employe3 = new Employe(3,"M3","Test2","Test2");
        Discipline discipline1 = new Discipline(1,"test1","test1");
        Discipline discipline2 = new Discipline(1,"test2","test2");
        Discipline discipline3 = new Discipline(1,"test3","test3");

        /*
        Dans les conditions de test, je ne vais pas mettre de limite mais normalement le niveau
        va de 0 à 10.

        TEST:

        add discipline OKK
         */

        employe1.addDiscipline(discipline1,2);
        employe1.addDiscipline(discipline2,10);
        employe2.addDiscipline(discipline2, 5);

        for (int i = 0; i < employe1.disciplineEtNiveau().size(); i++) {
            System.out.println((i+1)+" Discipline: "+employe1.disciplineEtNiveau().get(i).getDiscipline().getNom()+ "\nNiveau: " + employe1.disciplineEtNiveau().get(i).getNiveau());
        }
/*
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


    }
}