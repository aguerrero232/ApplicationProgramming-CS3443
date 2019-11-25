/**
 * @author Ariel Guerrero
 */

package application.model;

/**
 * Name: Dinosaur
 * Description: Defines what it is to be a dinosaur
 *              each dinosaur will have a name, type, diet, and a zone.
 */
public class Dinosaur {

    private String name = "", type = "";
    private Boolean isHerbivore = null;
    private Zone currentZone = null;
    private String diet ="";

    /**
     * Name: Dinosaur:
     * Description: constructor of the Dinosaurs
     * @param name
     * @param type
     * @param isHerbivore
     * @param currentZone
     */
    public Dinosaur(String name, String type, Boolean isHerbivore, Zone currentZone) {
        this.name = name;
        this.type = type;
        this.isHerbivore = isHerbivore;
        this.currentZone = currentZone;
        setDiet(isHerbivore);
    }

    /**
     * Name: getDiet()
     * Description: returns the diet of the dinosaur (carnivore or herbivore)
     * @return
     */
    public String getDiet() {
        return diet;
    }

    /**
     * Name: getName()
     * Description: gets the name of the dinosaur
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Name: getHerbivore()
     * Description: returns false if the dinosaur is not a herbivore
     * @return
     */
    public Boolean getHerbivore() {
        return isHerbivore;
    }

    public String getType() {
        return type;
    }

    public Zone getCurrentZone() {
        return currentZone;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public void setDiet(Boolean isHerbivore) {
        setDiet("Herbivore");
        if(!isHerbivore)
            setDiet( "Carnivore");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentZone(Zone currentZone) {
        this.currentZone = currentZone;
    }

    public void setHerbivore(Boolean isHerbivore) {
        this.isHerbivore = isHerbivore;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() { return  getName() + " - " + getType() + " - " + getDiet(); }

}
