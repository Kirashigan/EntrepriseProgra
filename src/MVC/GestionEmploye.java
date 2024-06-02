package MVC;

import MVC.controller.DisciplinesController;
import MVC.controller.EmployeController;
import MVC.controller.ProjetController;
import MVC.model.*;
import MVC.view.*;
import utilitaires.Utilitaire;

import java.util.List;
import java.util.Arrays;

public class GestionEmploye {
    private DAOEmploye em;
    private DAOProjet pm;
    private DAODiscipline dm;
    private EmployeController ec;
    private DisciplinesController dc;
    private ProjetController pc;
    private EmployeAbstractView ev;
    private DisciplineAbstractView dv;
    private ProjetAbstractView pv;

    public void gestion() {
        dm=new ModelDisciplineDB();
        em = new ModelEmployeDB();
        pm = new ModelProjetDB();


        dv = new DisciplineViewConsole();
        ev = new EmployeViewConsole();
        pv = new ProjetViewConsole();

        dc = new DisciplinesController(dm, dv);
        ec = new EmployeController(em, ev);
        pc = new ProjetController(pm, pv);

        pv.setDisciplineView(dv);
        pv.setEmployeView(ev);
        ev.setDisciplineView(dv);

        dm.addObserver(dv);
        em.addObserver(ev);
        pm.addObserver(pv);
        List<String> loptions = Arrays.asList("Disciplines", "Employes", "Projets", "fin");
        do {
            int ch = Utilitaire.choixListe(loptions);
            switch (ch) {
                case 1:
                    dv.menu();
                    break;
                case 2:
                    ev.menu();
                    break;
                case 3:
                    pv.menu();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }

    public static void main(String[] args){
        GestionEmploye ge = new GestionEmploye();
        ge.gestion();
    }
}