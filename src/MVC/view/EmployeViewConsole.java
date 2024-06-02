package MVC.view;

import MVC.controller.DisciplinesController;
import MVC.controller.EmployeController;
import Package.Employe;
import Package.Discipline;
import Package.Competence;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;

public class EmployeViewConsole extends EmployeAbstractView {

    private Scanner sc = new Scanner(System.in);

    @Override
    public void affMsg(String msg) {
        System.out.println("Information : " + msg);
    }

    @Override
    public void affList(List infos) {
        affListe(infos);
    }

    public void menu() {
        update(employeController.getAll());
        do {
            int ch = choixListe(Arrays.asList("Ajout", "Retrait", "Rechercher", "Modifier", "Plus","Fin"));

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
                    gererDiscipline();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

    private void gererDiscipline(){
        Employe e = selectionner();
        if(e != null)menu2(e);
        else affMsg("Employé pas trouvé");
    }
    private void menu2(Employe e){
        do {
            int ch = choixListe(Arrays.asList("Ajouter une discipline","Modifier une Discipline","Supprimer une Discipline"," Fin"));
            switch (ch){
                case 1 -> ajoutDis(e);
                case 2-> modifDis(e);
                case 3-> suppDis(e);
                case 4-> {
                    return;
                }
                default -> System.out.println("Choissiez quelque chose qui est dans le menu, merci.");

            }
        }while(true);
    }
    public void modifDis(Employe e){
        System.out.println("Modif d'une competence: ");
        affList(competenceList);
        Competence c = competenceList.get(choixElt(competenceList)-1);
        Discipline d = c.getDiscipline();
        System.out.println("Niveau: ");
        int niv = sc.nextInt();
        boolean ok = employeController.updateDiscipline(e,d,niv);
        if(ok) affMsg("Mise à jour effectuée");
        else affMsg("Probleme lors de la MAJ");
    }
    public void suppDis(Employe e){
        System.out.println("Suppression d'une competence: ");
        affList(competenceList);
        Competence c = competenceList.get(choixListe(competenceList)-1);
        Discipline dis = c.getDiscipline();
        boolean ok = employeController.supDiscipline(e,dis);
        if(ok) affMsg("Competence supprimée");
        else affMsg("Probleme lors de la suppression");
    }
public void ajoutDis(Employe e){
    System.out.println("Ajout d'une discipline: ");
    Discipline dis = dav.select();
    System.out.println("Entrez le niveau de le discipline: ");
    int niv = sc.nextInt();
    boolean ok = employeController.addDiscipline(e, dis,niv);
    if(ok) affMsg("Discipline ajoutée avec success");
    else affMsg("Erreur lors de l'ajout");
}
    private void modifier() {
        System.out.println("Entrez le numéro qui précède l'id: ");
        int i =1;
        for (Employe e : lp){
            System.out.println(i+ ") id employe: "+e.getIdEmploye()+" Prenom: "+e.getPrenom());
            i++;
        }
        int nl = choixElt(lp);
        Employe emp = lp.get(nl - 1);
        String matricule = modifyIfNotBlank("Matricule de l'employé : ", emp.getMatricule());
        String nom = modifyIfNotBlank("Nom : ", emp.getNom());
        String prenom = modifyIfNotBlank("Prénom : ", emp.getPrenom());
        String tel = modifyIfNotBlank("Téléphone : ", emp.getNumeroTelephone());
        String mail = modifyIfNotBlank("Mail : ", emp.getAdresseMail());
        Employe empmaj = employeController.update(new Employe(emp.getIdEmploye(), matricule, nom, prenom, tel, mail));
        if (empmaj == null) affMsg("mise à jour infructeuse");
        else affMsg("mise à jour effectuée : " + empmaj);
    }

    private void rechercher() {
        for (Employe e : lp){
            System.out.println(e.getIdEmploye()+" "+e.getPrenom());
        }
        System.out.println("idEmploye : ");
        int idEmploye = sc.nextInt();
        Employe e = employeController.search(idEmploye);
        if(e != null) System.out.println("Résultat de la recherche: "+e);
        else System.out.println("Aucun employé n'a cet id.");
    }

    private void retirer() {
        int i=1;
        System.out.println("Entrez le chiffre devant l'employé que vous voulez supprimer: ");
        for (Employe e : lp){
            System.out.println(i+") id: "+e.getIdEmploye()+" Prénom: "+e.getPrenom());
            i++;
        }
        int nl = sc.nextInt();
        Employe emp = lp.get(nl - 1);
        boolean ok = employeController.removeEmploye(emp);
        if (ok) affMsg("Employé effacé");
        else affMsg("Employé non effacé");
    }

    private void ajouter() {
        System.out.print("Matricule de l'employé : ");
        String matricule = sc.nextLine();
        System.out.print("Nom : ");
        String nom = sc.nextLine();
        System.out.print("Prénom : ");
        String prenom = sc.nextLine();
        System.out.print("Téléphone : ");
        String telephone = sc.nextLine();
        System.out.print("Mail : ");
        String mail = sc.nextLine();
        Employe emp = employeController.addEmploye(new Employe(matricule, nom, prenom, telephone, mail));
        if (emp != null) affMsg("création de :" + emp);
        else affMsg("erreur de création");
    }

    @Override
    public Employe selectionner() {
        update(employeController.getAll());
        int nl = choixListe(lp);
        Employe emp = lp.get(nl - 1);
        return emp;
    }
}

