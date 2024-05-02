package designpatterns.composite;

import java.util.Objects;

/**
 * Classe Competence
 *
 * @author Kirashigan
 * @version 1.0
 *
 */

public class Competence {
    /**
     * Permet d'incrémenter l'identifiant automatiquement
     */
    protected static int idIncrementation = 1;
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
     * auto incrementation avec idIncrementation
     * @param niveau Le niveau requit par la compétence
     * @param discipline La discipline sur laquelle la compétence repose
     */
    public Competence(int niveau, Discipline discipline) {
        this.idCompetence = idIncrementation++;
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
    /**
     * Indique si un autre objet est "égal" à celui-ci.
     * La méthode compare cet objet à un autre objet spécifié.
     *
     * @param o l'objet à comparer avec cet objet.
     * @return {@code true} si les objets sont égaux ; {@code false} sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competence that = (Competence) o;
        return idCompetence == that.idCompetence;
    }
    /**
     * Retourne un code de hachage pour l'objet.
     * @return le code de hachage de l'objet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idCompetence);
    }

    /**
     * Retourne une représentation sous forme de texte de la classe Competence
     * @return Une chaîne de caractères représentant cet objet.
     */
    @Override
    public String toString() {
        return "Competence:" +
                "\nidCompetence: " + idCompetence +
                "\nniveau: " + niveau +
                "\ndiscipline: " + discipline;
    }
}
