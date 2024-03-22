package DB;

import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GestEmploye {

    private Scanner s = new Scanner(System.in);
    private Connection dbConnection;

    public void gestion(){
        dbConnection = DBConnection.getConnection();
        if(dbConnection == null){
            System.exit(1);
        }
        System.out.println("Connexion établie");
        do{
            System.out.println("1. Ajouter un employe\n2. Rechercher un Employé\n3.Modifier un employé\n4. Supprimer un Employé \n0.Fin");
            System.out.println("Choix: ");
            int choix = s.nextInt();
            s.skip("\n");
            switch (choix){
                case 1:
                    ajouterEmploye();
                    break;
                case 2 :
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide, veuillez entrer un chiffre dans la liste. ");
            }
        }while(true);
    }

    public void ajouterEmploye(){
        System.out.println("Matricule de l'employé: ");
        String mat = s.nextLine();
        System.out.println("Nom de l'employé: ");
        String nom = s.nextLine();
        System.out.println("Prénom de l'employé: ");
        String prenom = s.nextLine();
        System.out.println("Numéro de téléphone de l'employé: ");
        String telephone = s.nextLine();
        System.out.println("Adresse mail de l'employé: ");
        String adressMail = s.nextLine();
        String requete1 = "insert into APIEmploye(mat,nom,prenom,telephone,adressMail) values(?,?,?,?,?)";
        String requete2 = "select idEmploye from APIEmploye where matricule = ?";
        try(PreparedStatement ps1 = dbConnection.prepareStatement(requete1);
        PreparedStatement ps2 = dbConnection.prepareStatement(requete2);
        ){
            ps1.setString(1, mat);
            ps1.setString(2, nom);
            ps1.setString(1, prenom);
            ps1.setString(1, telephone);
            ps1.setString(1, adressMail);
            int n = ps1.executeUpdate();
            System.out.println(n + " ligne insérée");
            if(n==1){
                ps2.setString(1,mat);
                ResultSet rs = ps2.executeQuery();
                if(rs.next()){
                    int idEmploye = rs.getInt(1);
                    System.out.println("idEmploye = "+ idEmploye);
                }else System.out.println("Record introuvable ");
            }
        } catch (SQLException e){
            System.out.println("Erreur: "+e);
        }
    }

    public static void main(String[] args) {
        GestEmploye GEmp = new GestEmploye();
        GEmp.gestion();
    }
}
