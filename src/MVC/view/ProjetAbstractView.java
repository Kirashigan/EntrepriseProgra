package MVC.view;

import MVC.controller.ProjetController;
import MVC.observer.Observer;
import Package.Projet;
import Package.Travail;

import java.util.List;

public abstract class ProjetAbstractView implements Observer {
    protected ProjetController projetController;
    protected List<Projet> projetList;
    protected List<Travail> travailList;
    protected EmployeAbstractView eav;
    protected DisciplineAbstractView dav;

    public void setProjetController(ProjetController projetController){this.projetController=projetController;}
    public void setDisciplineView(DisciplineAbstractView dav){ this.dav=dav;}
    public void setEmployeView(EmployeAbstractView eav){
        this.eav=eav;
    }
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
