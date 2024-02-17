package Package;

/**
 * classe Competence
 *
 * @author Kirashigan
 * @version 1.0
 *
 */

public class Competence {

    protected int idCompetence;
    protected int niveau;
    protected Discipline d;


    /*
    * Exemple: id = 1 Java
    * id = 2 C
    * id = 3 Python
    */

    public Competence(int idCompetence,int niveau, Discipline d) {
        this.idCompetence = idCompetence;
        this.niveau = niveau;
        this.d = d;
    }

    public Competence(int niveau, Discipline d) {
        this.niveau = niveau;
        this.d = d;
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

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public Discipline getDiscipline() {
        return d;
    }

    public void setDiscipline(Discipline d) {
        this.d = d;
    }
}
