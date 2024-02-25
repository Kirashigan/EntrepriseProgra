package Package;

import java.util.*;

/**
 * classe Discipline
 *
 * @author Kirashigan
 * @version 1.0
 *
 */

public class Discipline {
    /**
     * Permet d'incrémenter l'identifiant automatiquement
     */
    protected static int idIncrementation = 1;
    /**
     * identifiant unique de la discipline
     */
    protected int idDiscipline;
    /**
     * nom de la discipline
     */
    protected String nom;
    /**
     * description de la discipline
     */
    protected String description;
    /**
     * Liste de projet utilisé dans la discipline
     */
    protected List<Projet>projet=new ArrayList<>();

    /**
     * Permet l'ajout d'une discipline avec ses parametres avec auto incrémentation de l'identifiant
     * @param nom Nom de la discipline
     * @param description Description de la discipline
     */
    public Discipline(String nom, String description) {
        this.idDiscipline = idIncrementation++;
        this.nom = nom;
        this.description = description;
    }

    /**
     * @return Retourne l'Identifiant de la discipline
     */
    public int getIdDiscipline() {
        return idDiscipline;
    }

    /**
     * @return Retourne le nom
     */
    public String getNom() {
        return nom;
    }
    /**
     * @param nom Changer le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return Retourne la description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description Change la description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Retourne une liste de projet
     */
    public List<Projet> getProjet() {
        return projet;
    }

    /**
     * @param projet Change la liste de projet
     */
    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }

    /**
     * Retourne un code de hachage pour l'objet.
     * @return le code de hachage de l'objet.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idDiscipline);
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
        Discipline that = (Discipline) o;
        return idDiscipline == that.idDiscipline;
    }

    /**
     * Retourne une représentation sous forme de texte de la classe Discipline
     * @return Une chaîne de caractères représentant cet objet.
     */
    @Override
    public String toString() {
        return "Discipline: " +
                "\nidDiscipline=" + idDiscipline +
                "\nnom='" + nom + '\'' +
                "\ndescription='" + description + '\'' +
                "\nprojet=" + projet ;
    }
}
