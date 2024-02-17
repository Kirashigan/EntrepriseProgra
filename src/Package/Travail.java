package Package;

import java.time.LocalDate;
import java.util.*;
/**
 * classe Travail
 *
 * @author Kirashigan
 * @version 1.0
 *
 */
public class Travail {

    protected int idTravail;
    protected int pourcentage;
    protected Date dateEngag;
    protected Employe e;

    public Travail(int idTravail, int pourcentage, Date dateEngag) {
        this.idTravail = idTravail;
        this.pourcentage = pourcentage;
        this.dateEngag = dateEngag;
    }
    public Travail(Employe e,  int pourcentage, Date dateEngag) {
        this.e= e;
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

    public int getIdTravail() {
        return idTravail;
    }

    public void setIdTravail(int idTravail) {
        this.idTravail = idTravail;
    }

    public Employe getE() {
        return e;
    }

    public void setE(Employe e) {
        this.e = e;
    }
}
