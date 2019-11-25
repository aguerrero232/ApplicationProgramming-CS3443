/**
 * @author Ariel Guerrero
 */
package application.controller;
import application.Main;
import application.model.Dinosaur;
import application.model.Park;
import application.model.Zone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Name: MainController
 * Description: changes the scene to whichever zone the user decides based upon which button they push
 */
public class MainController implements Initializable {

    @FXML
    Button bButton, dButton, gButton, rButton, trButton, tyButton, xButton;

    @FXML
    ImageView logoimg;

    private static Park park = new Park("Jurassic Park");
    private static Zone tmpzone = null;
    private static ArrayList<Dinosaur> tmpdinos = null;

    /**
     * Name: getPark()
     * Description: gets the park , used to be accessed from zone controller
     * @return
     */
    public static Park getPark(){ return park; }

    /**
     * Name: getZone()
     * Description: gets the zone the user selected with a button, used to be accessed from zone controller
     * @return
     */
    public static Zone getZone(){ return tmpzone; }

    /**
     * Name: handle()
     * Description: when the user clicks a button in main it will change to that buttons zone
     * @param event
     * @throws IOException
     */
    @FXML
    private void handle(ActionEvent event) throws IOException {

        if (event.getSource() == bButton) {
            setStaticVals("B");
            changeScene();
        }

        if (event.getSource() == dButton) {
            setStaticVals("D");
            changeScene();
        }

        if (event.getSource() == gButton) {
            setStaticVals("G");
            changeScene();
        }

        if (event.getSource() == rButton) {
            setStaticVals("R");
            changeScene();
        }

        if (event.getSource() == trButton) {
            setStaticVals("TR");
            changeScene();
        }

        if (event.getSource() == tyButton) {
            setStaticVals("TY");
            changeScene();
        }

        if (event.getSource() == xButton) {
            setStaticVals("X");
            changeScene();
        }

    }

    /**
     * Name: changeScene()
     * Description: changes the scene to the zone scene
     * @throws IOException
     */
    private void changeScene() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../view/Zone.fxml"));
        Main.tmpstage.setScene(new Scene( root, 800, 800));
        Main.tmpstage.show();
        Main.tmpstage.setResizable(false);

    }

    /**
     * Name: setStaticVals()
     * Description: sets the zone and park
     * @param zonecode
     */
    private void setStaticVals(String zonecode){

        for(Zone z: park.getParkmap().keySet()){
            if (z.getZonecode().equals(zonecode)){
                tmpzone=z;
                break;
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File parkzones = new File("data/zones.csv");
        File parkdinos = new File("data/dinos.csv");

        park = new Park("Jurassic Park");
        tmpzone=null;
        tmpdinos=null;

        try {
            logoimg.setImage(new Image(new FileInputStream("mainscreenimages/parklogo.png")));
            park.loadParkData(parkzones, parkdinos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
