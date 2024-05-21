package designpatterns.composite;

import designpatterns.observer.Employe;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;


public class GestionEmploye {
    public static void main(String[] args) {
        Employe E1 = new Employe("E1", "E1", "E1");
        Projet P1 = new Projet("Pro1", datejour(2024, 9, 30), datejour(2024, 12, 31), new BigDecimal((45111)));
        System.out.println(P1);
        Employe e2 = new Employe("TEST2", "Test2", "Test2");
        Projet p2 = new Projet("Test2", datejour(2024, 6, 30), datejour(2024, 8, 30), new BigDecimal(4900));
        System.out.println(p2);

        Employe e3 = new Employe("TEST3", "Test3", "Test3");
        Projet p3 = new Projet("Test3", datejour(2024, 6, 20), datejour(2024, 8, 20), new BigDecimal(4700));
        System.out.println(p3);

        P1.getHashElem().add(p2);
        System.out.println(P1);


        P1.getHashElem().add(p3);
        System.out.println(P1);

    }

    public static Date datejour(int annee, int mois, int jour) {
        Calendar calendar = Calendar.getInstance();
        switch (mois) {
            case 1 -> calendar.set(annee, calendar.JANUARY, jour);
            case 2 -> calendar.set(annee, calendar.FEBRUARY, jour);
            case 3 -> calendar.set(annee, calendar.MARCH, jour);
            case 4 -> calendar.set(annee, calendar.APRIL, jour);
            case 5 -> calendar.set(annee, calendar.MAY, jour);
            case 6 -> calendar.set(annee, calendar.JUNE, jour);
            case 7 -> calendar.set(annee, calendar.JULY, jour);
            case 8 -> calendar.set(annee, calendar.AUGUST, jour);
            case 9 -> calendar.set(annee, calendar.SEPTEMBER, jour);
            case 10 -> calendar.set(annee, calendar.OCTOBER, jour);
            case 11 -> calendar.set(annee, calendar.NOVEMBER, jour);
            case 12 -> calendar.set(annee, calendar.DECEMBER, jour);
        }
        Date date = calendar.getTime();
        return date;
    }
}
