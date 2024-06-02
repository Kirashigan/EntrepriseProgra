package MVC.view;
import Package.Discipline;
import MVC.controller.DisciplinesController;
import MVC.observer.*;

import java.util.ArrayList;
import java.util.List;

public abstract class DisciplineAbstractView implements Observer {

    protected DisciplinesController disciplinesController;
    protected List<Discipline> disciplinesList;

    public void setDisciplinesController(DisciplinesController disciplinesController){this.disciplinesController=disciplinesController;}
    public abstract void affMsg(String msg);
    public abstract Discipline select();
    public abstract void menu();
    public abstract void affList(List l);

    @Override
    public void update(List disciplinesList){
        this.disciplinesList=disciplinesList;
        affList(disciplinesList);
    }
}
