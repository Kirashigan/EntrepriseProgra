package MVC.model;
import MVC.observer.Subject;
import Package.Projet;
import Package.Employe;
import java.sql.Date;
import java.util.List;

public abstract class DAOProjet extends Subject{
    public abstract Projet addProjet(Projet projet);
    public abstract boolean removeProjet(Projet projet);
    public abstract Projet updateProjet(Projet projet);
    public abstract Projet readProjet(int idProjet);
    public abstract List<Projet> getProjet();
    public abstract boolean addEmploye(Projet p, Employe e, int pourcentage);
    public abstract boolean delEmp(Projet p, Employe e);
    public abstract boolean modifEmploye(Projet p, Employe e, int pourcentage);
    public abstract int totalPourcentage(Projet p);


}
