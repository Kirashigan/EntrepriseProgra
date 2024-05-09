package MVC.model;

import myconnections.DBConnection;
import Package.Projet;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelProjetDB extends DAOProjet {
    protected Connection dbConnect;

    public ModelProjetDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("Erreur de co");
            System.exit(1);
        }
    }

    @Override
    public Projet addProjet(Projet projet) {
        String query1 = "insert into APIProjet(nom, datedebut,datefin, cout,pourcentage, iddiscipline) value(?,?,?,?,?,?)";
        String query2 = "select idprojet from APIPRojet where nom = ?";
        try (PreparedStatement p1 = dbConnect.prepareStatement(query1);
             PreparedStatement p2 = dbConnect.prepareStatement(query2);) {
            p1.setString(1, projet.getNom());
            java.sql.Date sqldatedebut = new java.sql.Date(projet.getDateDebut().getTime());
            java.sql.Date sqldatefin = new java.sql.Date(projet.getDateFin().getTime());
            p1.setDate(2, sqldatedebut);
            p1.setDate(3, sqldatefin);
            p1.setInt(4, projet.getCout().intValue());
            p1.setInt(5, projet.totalPourcentage());
            int n = p1.executeUpdate();
            if (n == 1) {
                p2.setString(1, projet.getNom());
                ResultSet r = p2.executeQuery();
                if (r.next()) {
                    int idpro = r.getInt(1);
                    projet.setIdProjet(idpro);
                    notifyObservers();
                    return projet;
                } else {
                    System.err.println("Record introuvable");
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erreur sql: " + e);
            return null;
        }
        return null;
    }

    @Override
    public Projet readProjet(int idProj) {
        String query = "Select * from APIProjet where idProjet=?";
        try (PreparedStatement p = dbConnect.prepareStatement(query);) {
            p.setInt(1, idProj);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                String nom = r.getString(2);
                java.sql.Date datedebut = r.getDate(3);
                java.sql.Date datefin = r.getDate(4);
                int cout = r.getInt(5);
                BigDecimal cout1 = BigDecimal.valueOf(cout);
                java.util.Date date_debut = datedebut;
                java.util.Date date_fin = datefin;
                Projet pro = new Projet(nom, date_debut, date_fin, cout1);
                return pro;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Erreur sql: " + e);
            return null;
        }
    }

    @Override
    public List<Projet> getProjet() {
        List<Projet> lp = new ArrayList<>();
        String query = "select * from APIProjet";
        try (Statement s = dbConnect.createStatement()) {
            ResultSet r = s.executeQuery(query);
            while (r.next()) {
                int idPro = r.getInt(1);
                String nom = r.getString(2);
                java.util.Date datedebut = r.getDate(3);
                java.util.Date datefin = r.getDate(4);
                java.math.BigDecimal cout = r.getBigDecimal(5);
                Projet projet = new Projet(idPro, nom, datedebut, datefin, cout);
                lp.add(projet);
            }
            return lp;
        } catch (SQLException e) {
            System.err.println("Erreur: " + e);
            return null;
        }
    }

    @Override
    public Projet updateProjet(Projet projet) {
        String query = "update APIProjet set nom = ?, datedebut = ?, datefin = ?, cout = ? where idprojet = ?";
        try (PreparedStatement p = dbConnect.prepareStatement(query)) {
            p.setString(1, projet.getNom());
            java.sql.Date sqldatedebut = new java.sql.Date(projet.getDateDebut().getTime());
            java.sql.Date sqldatefin = new java.sql.Date(projet.getDateFin().getTime());
            p.setDate(2, sqldatedebut);
            p.setDate(3, sqldatefin);
            p.setBigDecimal(4, projet.getCout());
            int n = p.executeUpdate();
            notifyObservers();
            if (n != 0) {
                return readProjet(projet.getIdProjet());
            } else return null;
        } catch (SQLException e) {
            System.err.println("Erreur sql: " + e);
            return null;
        }
    }

    @Override
    public boolean removeProjet(Projet projet) {
        String query = "delete from APIPRojet where idprojet = ?";
        try (PreparedStatement p = dbConnect.prepareStatement(query)) {
            p.setInt(1, projet.getIdProjet());
            int n = p.executeUpdate();
            notifyObservers();
            if (n != 0) return true;
            else return false;
        } catch (SQLException e) {
            System.err.println("Erreur : " + e);
            return false;
        }
    }

    @Override
    public List getNotification() {
        return getProjet();
    }
}
