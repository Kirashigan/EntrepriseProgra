package MVC.view;

import MVC.controller.ProjetController;
import MVC.observer.Observer;
import Package.Projet;

import java.util.List;

public abstract class ProjetAbstractView implements Observer {
    protected ProjetController projetController;
    protected List<Projet> projetList;

    public void setProjetController(ProjetController projetController){this.projetController=projetController;}
    public abstract void affMsg(String msg);
    public abstract Projet select();
    public abstract void menu();
    public abstract void affList(List l);

    @Override
    public void update(List l){
        this.projetList=l;
        affList(l);
    }
}
