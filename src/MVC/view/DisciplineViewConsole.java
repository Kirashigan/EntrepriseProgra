package MVC.view;

import Package.Discipline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class DisciplineViewConsole extends DisciplineAbstractView{
    private Scanner sc = new Scanner(System.in);
    @Override
    public void affMsg(String msg){
        System.out.println("Message : "+msg);
    }

    @Override
    public void affList(List l){affListe(l);}

    public void menu(){
        update(disciplinesController.getAll());
        do {
            int ch = choixListe(Arrays.asList("Ajout Discipline","Suppression Discipline","Recherche Discipline","Modifier Discipline","Fin"));
            switch (ch){
                case 1-> ajouter();
                case 2-> retirer();
                case 3-> rechercher();
                case 4-> modifier();
                case 5-> {return;}
                default-> System.out.println("Entrez un chiffre comprit dans le menu =)");
            }
        }while(true);
    }

    private void modifier(){
        int i=1;
        for (Discipline d : disciplinesList){
            System.out.println(i+") "+d.getIdDiscipline()+ " "+d.getNom());
            i++;
        }
        int m = choixElt(disciplinesList);
        Discipline discipline = disciplinesList.get(m-1);
        String Nom = modifyIfNotBlank("Nom de la discipline: ",discipline.getNom());
        String Description = modifyIfNotBlank("Description de la discipline: ",discipline.getDescription());
        Discipline disciplinemaj = disciplinesController.update(new Discipline(discipline.getIdDiscipline(),Nom,Description));
        if (disciplinemaj==null) affMsg("Mise à jour ratée");
        else affMsg("Mise à jour finie: "+disciplinemaj);
    }

    private void rechercher(){
        int i=1;
        for (Discipline d : disciplinesList){
            System.out.println(i+") "+d.getIdDiscipline()+ " "+d.getNom());
            i++;
        }
        System.out.println("id discipline: ");
        int iddis = sc.nextInt();
        Discipline d= disciplinesController.search(iddis-1);
        System.out.println(d.getIdDiscipline()+"\n"+d.getNom()+"\n"+d.getDescription());
    }
    private void retirer(){
        int i=1;
        System.out.println("Entrez le chiffre devant la discipline: ");
        for (Discipline d:disciplinesList){
            System.out.println(i+") Discipline id: "+d.getIdDiscipline()+ " "+ d.getNom());
            i++;
        }
        int nl = choixElt(disciplinesList);
        Discipline discipline = disciplinesList.get(nl-1);
        boolean ok = disciplinesController.removeDiscipline(discipline);
        if (ok) affMsg("Discipline retirée");
        else affMsg("Discipline non retirée");
    }

    private void ajouter(){
        System.out.println("Nom de la discipline: ");
        String nom = sc.nextLine();
        System.out.println("Description: ");
        String desc = sc.nextLine();
        Discipline d = disciplinesController.addDiscipline(new Discipline(nom, desc));

        if (d != null){
            affMsg("Discipline: "+d);
            disciplinesList.add(d);
        }
        else affMsg("Erreur de la création de la discipline");
    }
    @Override
    public Discipline select(){
        update(disciplinesController.getAll());
        int nl = choixListe(disciplinesList);
        Discipline dis = disciplinesList.get(nl-1);
        return dis;
    }
}
