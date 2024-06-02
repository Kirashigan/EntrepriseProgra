package MVC.view;

import Package.Projet;
import Package.Employe;
import Package.Travail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;
import static utilitaires.Utilitaire.choixListe;

public class ProjetViewConsole extends ProjetAbstractView{
    private Scanner sc = new Scanner(System.in);
    @Override
    public void affMsg(String msg){
        System.out.println("Information: "+msg);
    }
    @Override
    public void affList(List infos) {
        affListe(infos);
    }

    public void menu() {
        update(projetController.getAll());
        do {
            int ch = choixListe(Arrays.asList("Ajout", "Retrait", "Rechercher", "Modifier", "Fin"));

            switch (ch) {
                case 1:
                    ajouter();
                    break;
                case 2:
                    retirer();
                    break;
                case 3:
                    rechercher();
                    break;
                case 4:
                    modifier();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private void menu2(Projet p){
        do {
            int ch = choixListe(Arrays.asList("1: Ajouter un employé au projet","2: Supprimer un employé au projet","3: modifier un Employe au projet", "4: Implication total sur le projet","0: Fin"));
            switch (ch){
                case 1 ->ajoutEmploye(p);
                case 2-> suppEmp(p);
                case 3 -> modifEmp(p);
                case 4->implicationTotal(p);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Choix invalide, Merci d'entrer un chiffre comprit dans la liste.");
            }
        }while(true);
    }
    private void implicationTotal(Projet p){
        boolean ok = projetController.totalPourcentage(p);
        if(ok) System.out.println(" % du projet a été attribué");
        else System.out.println("Erreur, % d'implication.");
    }
    private void modifEmp(Projet p){
        System.out.println("Selectionnez un employé: ");
        affList(travailList);
        Travail t = travailList.get(choixListe(travailList)-1);
        System.out.println("Entrez son nouveau pourcentage d'investissement au projet: ");
        int part = sc.nextInt();
        boolean ok = projetController.modifEmploye(p,t.getEmploye(),part);
        if(ok) affMsg("Investissement sur le projet modifié");
        else affMsg("Erreur lors de la MAJ");
    }
    private void suppEmp(Projet p){
        System.out.println("Selectionnez l'employé que vous voulez supprimer: ");
        Employe emp = eav.selectionner();
        boolean ok = projetController.delEmp(p,emp);
        if(ok) affMsg("Employé supprimé du projet");
        else affMsg("Probleme lors de la suppression de l'employé");
    }
    private void ajoutEmploye(Projet proj){
        System.out.println("Choix de l'employe: ");
        Employe emp = eav.selectionner();
        System.out.println("Pourcentage d'investissement: ");
        int pourcent = sc.nextInt();
        boolean ok = projetController.addEmploye(proj,emp,pourcent);
        if(ok) affMsg("Employé ajouté au projet");
        else affMsg("Probleme lors de l'ajout de l'employé.");
    }
    private void modifier() {
        int nl = choixElt(projetList);

        Projet proj = projetList.get(nl - 1);
        String nom = modifyIfNotBlank("Nom: ", proj.getNom());
        Date debut = new Date(modifyIfNotBlank("Date début de projet: ",proj.getDateDebut().toString()));
        Date fin = new Date(modifyIfNotBlank("Date fin de projet: ",proj.getDateFin().toString()));
        BigDecimal cout = new BigDecimal( modifyIfNotBlank("Cout: ",proj.getCout().toString()));
        Projet empmaj = projetController.update(new Projet(proj.getIdProjet(), nom, debut, fin, cout));
        if (empmaj == null) affMsg("mise à jour infructeuse");
        else affMsg("mise à jour effectuée : " + empmaj);
    }

    private void rechercher() {
        System.out.println("id Projet : ");
        int idProjet = sc.nextInt();
        projetController.search(idProjet);
    }

    private void retirer() {

        int nl = choixElt(projetList);
        Projet proj = projetList.get(nl - 1);
        boolean ok = projetController.removeProjet(proj);
        if (ok) affMsg("Employé effacé");
        else affMsg("Employé non effacé");
    }
    private void ajouter() {
        System.out.println("Nom du projet: ");
        String nom = sc.nextLine();
        System.out.println("Date début du projet: (entrez une date comme suit : xx/xx/xx\n");
        String debutString = sc.nextLine();
        Date debut = new Date(debutString);
        System.out.println("Date butoir: ");
        Date fin = new Date(sc.nextLine());
        System.out.println("Cout du projet: ");
        BigDecimal cout = new BigDecimal(sc.nextLine());
        Projet proj = projetController.addProjet(new Projet(nom,debut,fin,cout));
        if(proj != null) affMsg("creation du projet :"+proj);
        else affMsg("Erreur de création");
    }

    @Override
    public Projet select() {
        update(projetController.getAll());
        int nl = choixListe(projetList);
        Projet pro = projetList.get(nl - 1);
        return pro;
    }
}

