/**
 * @author Ariel Guerrero
 */
package application.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Park {

    private HashMap<Zone, ArrayList<Dinosaur>> parkmap = new HashMap<Zone, ArrayList<Dinosaur>>();
    private String parkname = "";

    public Park(String parkname) {
        this.parkname = parkname;
    }

    /**
     * Name: getParkMap()
     * Description: gets the hash map of the park object containing its zones and lists of dinos
     * @return
     */
    public HashMap<Zone, ArrayList<Dinosaur>> getParkmap() {
        return parkmap;
    }

    /**
     * Name: getDinoFromLine()
     * Description: returns a dino object from the passed string from the dinos.csv file
     * @param line
     * @return
     */
    private Dinosaur getDinoFromLine(String line) {

        Scanner scan = new Scanner(line);
        boolean isHebavore = true;
        Zone tmpzone = null;
        String[] vars = new String[4];
        scan.useDelimiter(",");

        for (int i = 0; i < vars.length; i++)
            vars[i] = scan.next();

        if (vars[2].equals("false"))
            isHebavore = false;

        for (Zone zone : parkmap.keySet()) {
            if (zone.getZonecode().equals(vars[3])) {
                tmpzone = zone;
                break;
            }
        }
        return new Dinosaur(vars[0], vars[1], isHebavore, tmpzone);
    }

    /**
     * Name: loadDinps()
     * Description: loads in the dinosaurs from the dinos.csv file
     * @param dinosaurs
     * @throws IOException
     */
    public void loadDinos(File dinosaurs) throws IOException {

        BufferedReader d = new BufferedReader(new FileReader(dinosaurs));
        String line = "";
        Dinosaur tmpdino = null;

        while ((line = d.readLine()) != null) {

            tmpdino = getDinoFromLine(line);

            for (Zone zone : parkmap.keySet()) {
                if (zone.getZonecode().equals(tmpdino.getCurrentZone().getZonecode())) {
                    parkmap.get(zone).add(tmpdino);
                }
            }
        }
    }

    /**
     * Name: loadZones()
     * Description: loads in the zones from the zones.csv file
     * @param zones
     * @throws IOException
     */
    public void loadZones(File zones) throws IOException {

        BufferedReader z = new BufferedReader(new FileReader(zones));
        String line = "";
        String[] vars = new String[3]; //zonename="", zonetlevel="", zonecode="";
        Zone tmpzone = null;

        while ((line = z.readLine()) != null) {
            Scanner scan = new Scanner(line);
            scan.useDelimiter(",");
            for (int i = 0; i < vars.length; i++)
                vars[i] = scan.next();

            tmpzone = new Zone(vars[0], vars[1], vars[2]);
            if (!parkmap.containsKey(tmpzone))
                parkmap.put(tmpzone, new ArrayList<Dinosaur>());

        }
    }

    /**
     * Name: loadParkData()
     * Description: loads in the data from the dinos.csv and zones.csv utilizing
     *              the loadDinos() and loadZones() funstions
     * @param zones
     * @param dinos
     * @throws IOException
     */
    public void loadParkData(File zones, File dinos) throws IOException {

        loadZones(zones);
        loadDinos(dinos);
    }

    /**
     * Name: save()
     * Description: saves newly created dinos to the dinos.csv file and adds them to the parkmap
     * @param newDino
     * @throws IOException
     */
    public void save(Dinosaur newDino) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/dinos.csv"), true));
        String output = "";
        parkmap.get(newDino.getCurrentZone()).add(newDino);
        output = newDino.getName() + "," + newDino.getType() + "," + newDino.getHerbivore() + "," + newDino.getCurrentZone().getZonecode() + "\n";
        writer.write(output);
        writer.close();
    }

    /**
     * Name: relocate()
     * Description: relocates the passed dino to a new zone
     * @param dino
     * @param z
     * @throws IOException
     */
    public void relocate(Dinosaur dino, Zone z) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(new File("data/dinos.csv")));
        String output = "", line = "";
        String[] vars = new String[4];
        Dinosaur tmpdino = null;

        while ((line = reader.readLine()) != null) {
            Scanner scan = new Scanner(line);
            scan.useDelimiter(",");

            for (int i = 0; i < vars.length; i++)
                vars[i] = scan.next();

            tmpdino = getDinoFromLine(line);

            if (tmpdino.getName().toUpperCase().equals(dino.getName().toUpperCase())) {
                output += (vars[0] + "," + vars[1] + "," + vars[2] + "," + z.getZonecode() + "\n");
            } else {
                output += (line + "\n");
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("data/dinos.csv")));
        writer.write(output);
        writer.close();
    }

    public String getParkname() { return parkname; }

    /**
     * Name: toString()
     * Description: made a toString for my park ... shows the name of the park and the toString data of everything inside its park map
     * @return
     */
    @Override
    public String toString() {

        String output=getParkname()+": \n";
        for(Zone z : getParkmap().keySet()){
            output += "  Zone: " + z.toString() + "\n";
            output += "   Dinosaurs: \n";
            for(Dinosaur d :parkmap.get(z) ){
                output += "             " + d.toString() + "\n";
            }
            output += "\n";
        }
        return output;
    }
}

/**
 * @author Ariel Guerrero
 *
 */
