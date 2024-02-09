package Package;

import java.time.LocalDate;
import java.util.*;
public class Travail {

    protected int idTravail;
    protected int pourcentage;
    protected LocalDate dateEngag;
    protected Employe e;

    public Travail(int idTravail, int pourcentage, LocalDate dateEngag) {
        this.idTravail = idTravail;
        this.pourcentage = pourcentage;
        this.dateEngag = dateEngag;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public LocalDate getDateEngag() {
        return dateEngag;
    }

    public void setDateEngag(LocalDate dateEngag) {
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
