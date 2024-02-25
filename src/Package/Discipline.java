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
     * Permet l'ajout d'une discipline avec ses parametres
     * @param idDiscipline identifiant de la discipline (Unique)
     * @param nom Nom de la discipline
     * @param description Description de la discipline
     */
    public Discipline(int idDiscipline,String nom, String description) {
        this.idDiscipline = idDiscipline;
        this.nom = nom;
        this.description = description;
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
}
