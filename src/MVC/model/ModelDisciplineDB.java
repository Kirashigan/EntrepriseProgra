package MVC.model;

import myconnections.DBConnection;
import Package.Discipline;

import java.util.*;
import java.sql.*;

public class ModelDisciplineDB extends DAODiscipline {
    protected Connection dbConnect;

    public ModelDisciplineDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("Erreur de connexion");
            System.exit(1);
        }
    }

    @Override
    public Discipline addDiscipline(Discipline discipline) {
        String query1 = "insert into APIDiscipline(nom,description) values (?,?)";
        String query2 = "select iddiscipline from discipline where nom=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);) {
            pstm1.setString(1, discipline.getNom());
            pstm1.setString(2, discipline.getDescription());
            int n = pstm1.executeUpdate();
            if (n == 1) {
                pstm2.setString(1, discipline.getNom());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    int iddis = rs.getInt(1);
                    discipline.setIdDiscipline(iddis);
                    notifyObservers();
                    return discipline;
                } else {
                    System.err.println("Record introuvable");
                    return null;
                }
            } else return null;
        } catch (SQLException e) {
            System.err.println("erreur sql " + e);
            return null;
        }
    }

    @Override
    public Discipline readDiscipline(int idDiscipline) {
        String query = "select * from APIDiscipline where iddiscipline=?";
        try (PreparedStatement p = dbConnect.prepareStatement(query)) {
            p.setInt(1, idDiscipline);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String nom = rs.getString(2);
                String description = rs.getString(3);
                Discipline d = new Discipline(idDiscipline, nom, description);
                return d;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL: " + e);
            return null;
        }
    }

    @Override
    public List<Discipline> getDiscipline() {
        List<Discipline> ld = new ArrayList<>();
        String query = "select * from APidiscipline";
        try(Statement s = dbConnect.createStatement()){
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                int idDiscipline = r.getInt(1);
                String nom = r.getString(2);
                String description = r.getString(3);
                Discipline d = new Discipline(idDiscipline,nom,description);
                ld.add(d);
            }
            return ld;
        }catch (SQLException e){
            System.err.println("Erreur SQL: "+e);
            return null;
        }
    }

    @Override
    public Discipline updateDiscipline(Discipline discipline) {
        String query = "update APIDescipline set nom = ?, description = ? where iddiscipline = ?";
        try(PreparedStatement p = dbConnect.prepareStatement(query)){
            p.setString(1,discipline.getNom());
            p.setString(2,discipline.getDescription());
            int n = p.executeUpdate();
            notifyObservers();
            if (n != 0) {
                return readDiscipline(discipline.getIdDiscipline());
            }else return null;
    }catch (SQLException e){
            System.err.println("Erreur sql: "+e);
            return null;
        }
    }

    @Override
    public boolean removeDiscipline(Discipline discipline) {
        String query = "delete from APIDiscipline where iddisicpline = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, discipline.getIdDiscipline());
            int n = pstm.executeUpdate();
            notifyObservers();
            if (n != 0) return true;
            else return false;
        } catch (SQLException e) {
            System.err.println("Erreur sql: " + e);
            return false;
        }
    }

    @Override
    public List getNotification() {
        return getDiscipline();
    }

}
