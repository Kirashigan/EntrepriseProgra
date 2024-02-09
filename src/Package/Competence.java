package Package;

public class Competence {

    protected int idCompetence;
    protected int niveau;
    protected Discipline d;


    public Competence(int idCompetence,int niveau, Discipline d) {
        this.idCompetence = idCompetence;
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
