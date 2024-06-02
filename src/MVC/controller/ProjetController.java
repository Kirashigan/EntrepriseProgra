package MVC.controller;

import MVC.view.ProjetAbstractView;
import MVC.model.DAOProjet;
import Package.Projet;
import Package.Employe;
import java.sql.Date;
import java.util.List;

public class ProjetController {
    private DAOProjet model;
    private ProjetAbstractView view;

    public ProjetController(DAOProjet model, ProjetAbstractView view){
        this.model = model;
        this.view=view;
        this.view.setProjetController(this);
    }
    public List<Projet> getAll(){return model.getProjet();}
    public Projet addProjet(Projet projet){
        return model.addProjet(projet);
    }
    public boolean removeProjet(Projet projet){
        return model.removeProjet(projet);
    }
    public Projet update(Projet projet){
        return model.updateProjet(projet);
    }
    public Projet search(int idProjet){return model.readProjet(idProjet);}
    public boolean addEmploye(Projet p,Employe e, int pourcent){return model.addEmploye(p,e, pourcent);}
    public boolean delEmp(Projet p,Employe e){return model.delEmp(p,e);}
    public boolean modifEmploye(Projet p,Employe e, int pourcent){return model.modifEmploye(p,e,pourcent);}
    public boolean totalPourcentage(Projet p){return model.totalPourcentage(p);}

}
