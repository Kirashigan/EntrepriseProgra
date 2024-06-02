package MVC.controller;

import MVC.model.DAODiscipline;
import MVC.view.DisciplineAbstractView;
import Package.Discipline;

import java.util.List;

public class DisciplinesController {
    private DAODiscipline model;
    private DisciplineAbstractView view;

    public DisciplinesController(DAODiscipline model, DisciplineAbstractView view){
        this.model=model;
        this.view=view;
        this.view.setDisciplinesController(this);

    }
    public List<Discipline> getAll(){
        return model.getDisciplines();
    }
    public Discipline addDiscipline(Discipline discipline){return model.addDiscipline(discipline);}
    public boolean removeDiscipline(Discipline discipline){return model.removeDiscipline(discipline);}
    public Discipline update(Discipline discipline){
        return model.updateDiscipline(discipline);
    }
    public Discipline search(int idDis){return model.readDiscipline(idDis);}

}
