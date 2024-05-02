package MVC.view;

import Package.Employe;
import MVC.controller.EmployeController;
import MVC.observer.Observer;
import java.util.List;

public abstract class EmployeAbstractView implements Observer {

    protected EmployeController employeController;
    protected List<Employe> lp;

    public void  setController(EmployeController employeController){
        this.employeController=employeController;
    }
    public abstract void affMsg(String msg);

    public abstract Employe selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lp) {
        this.lp = lp;
        affList(lp);
    }

}