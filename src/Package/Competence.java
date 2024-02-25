package Package;

/**
 * Classe Competence
 *
 * @author Kirashigan
 * @version 1.0
 *
 */

public class Competence {
    /**
     * Identifiant unique des compétences
     */
    protected int idCompetence;
    /**
     * Niveau qu'une compétence d'un employé
     */
    protected int niveau;
    /**
     * Discipline de l'employé
     */
    protected Discipline discipline;


    /**
     * Permet d'ajouter une compétence avec ses parametres
     * @param idCompetence Identifiant de la compétence (Unique)
     * @param niveau Le niveau requit par la compétence
     * @param discipline La discipline sur laquelle la compétence repose
     */
    public Competence(int idCompetence,int niveau, Discipline discipline) {
        this.idCompetence = idCompetence;
        this.niveau = niveau;
        this.discipline = discipline;
    }

    public Competence(int niveau, Discipline discipline) {
        this.niveau = niveau;
        this.discipline = discipline;
    }

    public Competence(int niveau) {
        this.niveau = niveau;
    }

    /**
     * @return Retourne le niveau d'une compétence
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * @param niveau Permet de changer le niveau d'une compétence
     */
    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    /**
     * @return Retourne id d'une compétence
     */
    public int getIdCompetence() {
        return idCompetence;
    }

    /**
      * @param idCompetence Permet de changer l'id d'une compétence
     */
    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    /**
     * @return Retourne une discipline
     */
    public Discipline getDiscipline() {
        return discipline;
    }

    /**
     * @param discipline Permet de changer la discipline
     */
    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
