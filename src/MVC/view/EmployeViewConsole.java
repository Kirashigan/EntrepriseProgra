package MVC.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import MVC.controller.EmployeController;
import Package.Employe;
import static utilitaires.Utilitaire.*;
import static utilitaires.Utilitaire.choixListe;

public class EmployeViewConsole extends EmployeAbstractVue{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }


    @Override
    public void menu() {
        update(employeController.getAll());
        do {

            int ch = choixListe(Arrays.asList("ajout", "retrait", "rechercher", "modifier", "fin"));
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

    @Override
    public void affList(List l) {
        affListe(l);
    }



    private void modifier() {
        int nl = choixElt(employeList) - 1;
        Employe employe = employeList.get(nl);
        String nom = modifyIfNotBlank("nom", employe.getNom());
        String matricule = modifyIfNotBlank("matricule", employe.getMatricule());
        String prenom = modifyIfNotBlank("prénom", employe.getPrenom());
        String tel = modifyIfNotBlank("téléphone", employe.getNumeroTelephone());
        String adressMail = modifyIfNotBlank("Adresse Mail",employe.getAdresseMail());
        Employe em =EmployeController.updateEmploye(new Employe(employe.getIdEmploye(),matricule, nom, prenom, tel, adressMail));
        if(em==null) affMsg("mise à jour infructueuse");
        else affMsg("mise à jour effectuée : "+em);
    }

    private void rechercher() {
        System.out.println("idclient : ");
        int idClient = sc.nextInt();
        Employe em = EmployeController.search(idClient);
        if(em==null) affMsg("recherche infructueuse");
        else {
            affMsg(em.toString());
        }
    }

    private void retirer() {
        int nl = choixElt(employeList)-1;
        Employe employe = employeList.get(nl);
        boolean ok = EmployeController.removeEmploye(employe);
        if(ok) affMsg("client effacé");
        else affMsg("client non effacé");
    }

    private void ajouter() {
        System.out.println("Matricule: ");
        String matricule = sc.nextLine();
        System.out.print("nom : ");
        String nom = sc.nextLine();
        System.out.print("prenom: ");
        String prenom = sc.nextLine();
        System.out.print("Numéro de téléphone: ");
        String tel = sc.nextLine();
        System.out.print("Adresse Mail: ");
        String mail = sc.nextLine();
        Employe em = EmployeController.addEmploye(new Employe(matricule, nom, prenom, tel, mail));
        if(em!=null) affMsg("création de : "+em);
        else affMsg("erreur de création");
    }

    @Override
    public Employe selectionner() {
        update(EmployeController.getAll());
        int nl = choixListe(employeList);
        Employe employe = employeList.get(nl - 1);
        return employe;
    }
}
