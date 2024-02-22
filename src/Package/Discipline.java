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
     * @param idDiscipline
     * @param nom
     * @param description
     */
    public Discipline(int idDiscipline,String nom, String description) {
        this.idDiscipline = idDiscipline;
        this.nom = nom;
        this.description = description;
    }

    /**
     * Retourne le nom
     * @return
     */
    public String getNom() {
        return nom;
    }
    /**
     * Changer le nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Change la description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retourne une liste de projet
     * @return
     */
    public List<Projet> getProjet() {
        return projet;
    }

    /**
     * Change la liste de projet
     * @param projet
     */
    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }
}
