package application.model;

/**
 * @author Ariel Guerrero
 *
 */
public class Zone {

    private String zonecode = "", name = "", risk = "";

    /**
     * Name: Zone()
     * Description: constructor of the zone object
     *                must have a name,risk and code passed in
     *                 to be set
     * @param name
     * @param risk
     * @param zonecode
     */
    public Zone(String name, String risk, String zonecode) {
        this.name = name;
        this.risk = risk;
        this.zonecode = zonecode;
    }

    /**
     * Name: setName()
     * Description: sets the name of the zone object
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * name: setRisk()
     * Description: sets the risk of the zone object
     * @param risk
     */
    public void setRisk(String risk) {
        this.risk = risk;
    }

    /**
     * Name: setZonecode()
     * Description: sets the zone code for the zone object
     * @param zonecode
     */
    public void setZonecode(String zonecode) {
        this.zonecode = zonecode;
    }

    /**
     * Name: getName()
     * Description: gets the name of the zone object
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Name: getRisk()
     * Description: gets the risk of the zone object
     * @return
     */
    public String getRisk() {
        return risk;
    }

    /**
     * Name: getZoneCode
     * Description: gets the zone code of zone object
     * @return
     */
    public String getZonecode() {
        return zonecode;
    }

    @Override
    public String toString() { return getZonecode() + " - " + getName() + " - " + getRisk(); }
}
