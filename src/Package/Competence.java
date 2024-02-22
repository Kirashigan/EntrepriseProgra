package Package;

/**
 * classe Competence
 *
 * @author Kirashigan
 * @version 1.0
 *
 */

public class Competence {
    /**
     * identifiant unique des compétences
     */
    protected int idCompetence;
    /**
     * niveau qu'une compétence d'un employé
     */
    protected int niveau;
    /**
     * discipline de l'employé
     */
    protected Discipline d;


    /**
     * Permet d'ajouter une compétence avec ses parametres
     * @param idCompetence
     * @param niveau
     * @param d <== discipline
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

    /**
     * Retourne le niveau d'une compétence
     * @return
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Permet de changer le niveau d'une compétence
     * @param niveau
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    /**
     * Retourne id d'une compétence
     * @return
     */
    public int getIdCompetence() {
        return idCompetence;
    }

    /**
     * Permet de changer l'id d'une compétence
      * @param idCompetence
     */
    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    /**
     * Retourne une discipline
     * @return
     */
    public Discipline getDiscipline() {
        return d;
    }

    /**
     * permet de changer le discipline
     * @param d
     */
    public void setDiscipline(Discipline d) {
        this.d = d;
    }
}
