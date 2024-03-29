package DB;

import Package.*;
import myconnections.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class GestEmploye {

    private Scanner s = new Scanner(System.in);
    private Connection dbConnection;

    public void gestion() {
        dbConnection = DBConnection.getConnection();
        if (dbConnection == null) {
            System.exit(1);
        }
        System.out.println("Connexion établie");
        do {
            System.out.println("1. Ajouter un employe\n2. Rechercher un Employé\n3. Modifier un employé\n4. Supprimer un Employé\n5. Voir tous les employés de la BD.\n0. Fin");
            System.out.println("Choix: ");
            int choix = s.nextInt();
            s.skip("\n");
            switch (choix) {
                case 1:
                    ajouterEmploye();
                    break;
                case 2:
                    rechercheEmploye();
                    break;
                case 3:
                    modifEmploye();
                    break;
                case 4:
                    supprimerEmploye();
                    break;
                case 5:
                    voirTtLeMonde();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide, veuillez entrer un chiffre dans la liste. ");
            }
        } while (true);
    }

    public void voirTtLeMonde(){
        String query="select * from APIEmploye";
        try(Statement stm = dbConnection.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt(1);
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
                String email= rs.getString(6);
                Employe em = new Employe(matricule,nom,prenom,tel,email);
                System.out.println("\n"+em+"\n");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }
    public void supprimerEmploye(){
        System.out.println("Id de l'employé à supprimer de la bd: ");
        int id = s.nextInt();
        String requete = "delete FROM APIEMPLOYE where idemploye = ?";
        try(PreparedStatement ps = dbConnection.prepareStatement(requete)){
            ps.setInt(1,id);
            int n = ps.executeUpdate();
            if(n!=0){
                System.out.println("Employé supprimée de la BD.");
            }else System.out.println("Aucune modification apportée.");
        }catch (Exception e){
            System.out.println("erreur: " +e);
        }

    }

    public void modifEmploye() {
        System.out.println("Id du client recherché: ");
        int idrech = s.nextInt();
        s.skip("\n");
        System.out.println("Nouvelle adresse mail:  ");
        String nemail = s.nextLine();
        String requete = "update APIEMPLOYE set email=? where idemploye = ?";
        try(PreparedStatement pstm = dbConnection.prepareStatement(requete)) {
            pstm.setString(1,nemail);
            pstm.setInt(2,idrech);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ " ligne a bien été mis à jour.\n\n");
            else System.out.println("Aucune modification apportée.");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }

    public void rechercheEmploye() {
        System.out.println("Entrer l'ID de l'employé recherché: ");
        int id = s.nextInt();
        String requete = "select * from APIEMPLOYE where idEmploye = ?";
        try (PreparedStatement pt = dbConnection.prepareStatement(requete)) {
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            if (rs.next()) {
                String matricule = rs.getString(2);
                String nom = rs.getString(3);
                String prenom = rs.getString(4);
                String tel = rs.getString(5);
                String email = rs.getString(6);
                Employe e = new Employe(matricule, nom, prenom, tel, email);
                System.out.println(e);
            } else System.out.println("Employé introuvable / Pas dans la BD.");
        } catch (SQLException e) {
            System.out.println("erreur sql: " + e);
        }
    }

    public void ajouterEmploye() {
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
        String requete1 = "insert into APIEmploye(matricule,nom,prenom,telephone,EMAIL) values(?,?,?,?,?)";
        String requete2 = "select idEmploye from APIEmploye where matricule = ?";
        try (PreparedStatement ps1 = dbConnection.prepareStatement(requete1);
             PreparedStatement ps2 = dbConnection.prepareStatement(requete2);
        ) {
            ps1.setString(1, mat);
            ps1.setString(2, nom);
            ps1.setString(3, prenom);
            ps1.setString(4, telephone);
            ps1.setString(5, adressMail);
            int n = ps1.executeUpdate();
            System.out.println(n + " ligne insérée");
            if (n == 1) {
                ps2.setString(1, mat);
                ResultSet rs = ps2.executeQuery();
                if (rs.next()) {
                    int idEmploye = rs.getInt(1);
                    System.out.println("idEmploye = " + idEmploye);
                } else System.out.println("Record introuvable ");
            }
        } catch (SQLException e) {
            System.out.println("Erreur: " + e);
        }
    }

    public static void main(String[] args) {
        GestEmploye GEmp = new GestEmploye();
        GEmp.gestion();
    }
}
