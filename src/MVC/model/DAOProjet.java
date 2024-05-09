package MVC.model;
import MVC.observer.Subject;
import Package.Projet;
import java.util.List;
public abstract class DAOProjet extends Subject{
    public abstract Projet addProjet(Projet projet);
    public abstract boolean removeProjet(Projet projet);
    public abstract Projet updateProjet(Projet projet);
    public abstract Projet readProjet(int idProjet);
    public abstract List<Projet> getProjet();

}
