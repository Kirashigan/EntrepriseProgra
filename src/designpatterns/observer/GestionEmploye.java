package designpatterns.observer;

import java.math.BigDecimal;
import java.util.Date;

public class GestionEmploye {
    public static void main(String[] args) {
        Date startDate = new Date();
        Date endDate = new Date();
        Date modif = new Date();
        modif.setDate(9);
        startDate.getDate(); // This will return the day of the month
        endDate.setDate(7); // This will set the day of the month to 7
        BigDecimal test = new BigDecimal(5000);
        Projet p1 = new Projet("test", startDate, endDate, test);
        Projet p2 = new Projet("testt", startDate, endDate, test);
        Employe em1 = new Employe(1,"test","test","test","test","test");
        Employe em2 = new Employe(2,"testt","testt","testt","testt","testt");
        p1.addObserver(em1);
        p2.addObserver(em1);
        p2.addObserver(em2);
        p1.setDateFin(modif);
        p2.setDateFin(modif);
    }
}
