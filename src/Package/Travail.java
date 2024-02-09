package Package;

import java.util.*;
public class Travail {

    private int pourcentage;
    private Date dateEngag;
    private Projet p;

    public Travail(int pourcentage, Date dateEngag) {
        this.pourcentage = pourcentage;
        this.dateEngag = dateEngag;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Date getDateEngag() {
        return dateEngag;
    }

    public void setDateEngag(Date dateEngag) {
        this.dateEngag = dateEngag;
    }

    public Projet getP() {
        return p;
    }

    public void setP(Projet p) {
        this.p = p;
    }




}
