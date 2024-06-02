package MVC.controller;

import Package.Employe;
import Package.Discipline;
import Package.Competence;
import MVC.model.DAOEmploye;
import MVC.view.EmployeAbstractView;

import java.util.List;

public class EmployeController {
    private DAOEmploye model;
    private EmployeAbstractView view;


    public EmployeController(DAOEmploye model, EmployeAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public List<Employe> getAll(){
        return model.getEmployes();
    }
    public Employe addEmploye(Employe employe) {
        return  model.addEmploye(employe);
    }

    public boolean removeEmploye(Employe emp) {
        return model.removeEmploye(emp);
    }

    public Employe update(Employe employe) {
        return model.updateEmploye(employe);

    }

    public Employe search(int idEmpl) {
        return  model.readEmploye(idEmpl);
    }

    public boolean addDiscipline(Employe emp, Discipline dis,int niveau){return model.addDiscipline(emp,dis,niveau);}
    public boolean updateDiscipline(Employe emp, Discipline dis,int niveau){return model.updateDiscipline(emp,dis,niveau);}
    public boolean supDiscipline(Employe emp,Discipline dis){return model.supDiscipline(emp,dis);}

}