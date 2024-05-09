package MVC.controller;

import MVC.view.ProjetAbstractView;
import MVC.model.DAOProjet;
import Package.Projet;

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
}
