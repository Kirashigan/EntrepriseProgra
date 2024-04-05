package MVC.controller;

import MVC.model.DAOEmploye;
import MVC.view.EmployeAbstractVue;
import Package.Employe;

import java.util.List;

public class EmployeController {

    private static DAOEmploye model;
    private EmployeAbstractVue view;

    public EmployeController(DAOEmploye model, EmployeAbstractVue view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public static List<Employe> getAll(){
        return model.getEmploye();
    }
    public static Employe addEmploye(Employe employe){
        return model.addEmploye(employe);
    }
    public static boolean removeEmploye(Employe employe){
        return model.removeEmploye(employe);
    }
    public static Employe updateEmploye(Employe employe){return model.updateEmploye(employe);}
    public static Employe search(int idEmploye){return model.readEmploye(idEmploye);}
}
