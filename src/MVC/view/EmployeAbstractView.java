package MVC.view;

import Package.Employe;
import Package.Competence;
import MVC.controller.EmployeController;
import MVC.observer.Observer;
import java.util.List;

public abstract class EmployeAbstractView implements Observer {

    protected EmployeController employeController;
    protected List<Employe> lp;
    protected DisciplineAbstractView dav;
    protected EmployeAbstractView eav;
    protected List<Competence> competenceList;

    public void  setController(EmployeController employeController){
        this.employeController=employeController;
    }
    public abstract void affMsg(String msg);
    public void setDisciplineView(DisciplineAbstractView dav){this.dav=dav;}

    public abstract Employe selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lp) {
        this.lp = lp;
        affList(lp);
    }

}