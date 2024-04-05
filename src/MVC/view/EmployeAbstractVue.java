package MVC.view;

import MVC.controller.EmployeController;
import MVC.observer.Observer;
import Package.Employe;
import java.util.List;

public abstract class EmployeAbstractVue implements Observer {

    protected List<Employe> employeList;
    protected EmployeController employeController;

    public void  setController(EmployeController EmployeController){
        this.employeController=employeController;
    }

    public abstract void affMsg(String msg);

    public abstract Employe selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List le) {
        this.employeList = le;
        affList(le);
    }


}
