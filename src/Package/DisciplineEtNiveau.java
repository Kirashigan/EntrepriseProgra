package Package;
import java.util.*;
public class DisciplineEtNiveau {
    protected List<Integer> Niveau;
    protected List<Discipline> Disciplines;
    public DisciplineEtNiveau(List<Integer> niv, List<Discipline> dis){
        this.Disciplines=dis;
        this.Niveau=niv;
    }

    public List<Integer> getNiveau() {
        return Niveau;
    }

    public void setNiveau(List<Integer> niveau) {
        Niveau = niveau;
    }

    public List<Discipline> getDisciplines() {
        return Disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        Disciplines = disciplines;
    }

    public void setDisEtNiv(List<Discipline> dis, List<Integer> niveau){
        Disciplines = dis;
        Niveau = niveau;
    }
}
