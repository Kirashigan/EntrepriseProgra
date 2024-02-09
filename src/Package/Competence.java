package Package;

public class Competence {

    private int niveau;
    private Employe e;


    public Competence(int niveau, Employe e) {
        this.niveau = niveau;
        this.e = e;
    }

    public Competence(int niveau) {
        this.niveau = niveau;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Employe getE() {
        return e;
    }

    public void setE(Employe e) {
        this.e = e;
    }




}
