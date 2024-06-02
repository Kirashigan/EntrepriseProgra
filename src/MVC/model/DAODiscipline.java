package MVC.model;
import MVC.observer.Subject;
import Package.Discipline;
import java.util.List;

public abstract class DAODiscipline extends Subject {
    public abstract Discipline addDiscipline(Discipline discipline);
    public abstract boolean removeDiscipline(Discipline discipline);
    public abstract Discipline updateDiscipline(Discipline discipline);
    public abstract Discipline readDiscipline(int idDiscipline);
    public abstract List<Discipline> getDisciplines();
}
