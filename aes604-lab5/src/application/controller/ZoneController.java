/**
 * @author Ariel Guerrero
 *
 */

package application.controller;

import application.Main;
import application.model.Dinosaur;
import application.model.Zone;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Name: ZoneController
 * Description: controls the zone scene and uses the users input to update the dinos.csv with given inputs
 */
public class ZoneController implements Initializable {
    private ArrayList<String> lvdata = new ArrayList<String>();
    private ToggleGroup group = new ToggleGroup();

    @FXML
    private Button homebutton, addButton, relocateButton;

    @FXML
    private Label zonelabel, numdinolabel, threatlevellabel, relocatedlabel;

    @FXML
    private ListView<String> dinosaurlistview;

    @FXML
    private RadioButton yesradiobutton, noradiobutton;

    @FXML
    private TextField newdinonametextfield, newdinotypetextfield, relocatedinonametextfield, zonecodetextfield;

    /**
     * Name: handle
     * Description: activates a event based on what button in the GUI the user pushed
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void handle(ActionEvent actionEvent) throws IOException {

        if (actionEvent.getSource() == homebutton) {
            changeScene();
        }
        if (actionEvent.getSource() == addButton) {
            addButtonPushed();
        }
        if (actionEvent.getSource() == relocateButton) {
            relocatedButtonPushed();
        }

    }

    /**
     * Name: changeScene()
     * Description: changes the scene from zone to main
     * @throws IOException
     */
    private void changeScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/Main.fxml"));
        Main.tmpstage.setScene(new Scene(root, 800, 800));
        Main.tmpstage.show();
        Main.tmpstage.setResizable(false);
    }

    /**
     * Name: addButtonPushed()
     * Description: User pushed the add button so we will add a new dino based on the params entered by the user in the GUI
     * @throws IOException
     */
    private void addButtonPushed() throws IOException {
        boolean isHerbavore = true;
        String diet = "Herbavore", dinoName = newdinonametextfield.getText(), dinoType = newdinotypetextfield.getText();
        int count = 0;

        if (dinoName.isEmpty() || dinoType.isEmpty()) {
            relocatedlabel.setText("");
            return;
        }

        if (yesradiobutton.isSelected()) {
            isHerbavore = false;
            diet = "Carnivore";
            yesradiobutton.setSelected(false);
        } else {
            noradiobutton.setSelected(false);
        }

        Dinosaur d = new Dinosaur(dinoName, dinoType, isHerbavore, MainController.getZone());
        newdinonametextfield.clear();
        newdinotypetextfield.clear();
        count = Integer.parseInt(numdinolabel.getText()) + 1;
        numdinolabel.setText("" + count);
        lvdata.add(d.toString());
        dinosaurlistview.setItems(FXCollections.observableList(lvdata));
        MainController.getPark().save(d);

    }

    /**
     * Name: relocatedButtonPushed()
     * Description: relocates a current dino in the zone to another zone given by the user
     * @throws IOException
     */
    private void relocatedButtonPushed() throws IOException {
        String dinoName = relocatedinonametextfield.getText(), newzone = zonecodetextfield.getText();
        Zone tmpzone = null;
        Dinosaur tmpdino = null;

        if (dinoName.isEmpty() || newzone.isEmpty()) {
            return;
        }

        for (Zone z : MainController.getPark().getParkmap().keySet()) {
            if (z.getZonecode().toUpperCase().equals(newzone.toUpperCase())) {
                tmpzone = z;
            }
            for (Dinosaur d : MainController.getPark().getParkmap().get(z)) {
                if (d.getName().toLowerCase().equals(dinoName.toLowerCase())) {
                    tmpdino = d;
                    break;
                }
            }
        }

        if(tmpzone == null){
            relocatedlabel.setText( newzone + " is not a valid Zone ");
            return;
        }

        if(tmpdino == null){
            relocatedlabel.setText(dinoName + " is not in Zone " + MainController.getZone().getZonecode() + "!");
            return;
        }

        assert tmpdino != null; // what does assert do?
        assert tmpzone != null;
        int count = Integer.parseInt(numdinolabel.getText()) - 1;
        numdinolabel.setText("" + count);
        removeFromListView(tmpdino);
        dinosaurlistview.setItems(FXCollections.observableList(new ArrayList<String>(lvdata)));
        relocatedlabel.setText(tmpdino.getName() + " successfully relocated to zone " + tmpzone.getZonecode() + "!");
        zonecodetextfield.clear();
        relocatedinonametextfield.clear();
        MainController.getPark().relocate(tmpdino, tmpzone);
    }

    /**
     * Name: removeFromListView()
     * Description: Removes the passed dinosaur from the ListView shown on the screen
     * @param tmpDino
     */
    private void removeFromListView(Dinosaur tmpDino) {
        for (int i = 0; i < lvdata.size(); i++) {
            if (lvdata.get(i).toLowerCase().equals(tmpDino.toString().toLowerCase())) {
                lvdata.remove(i);
                return;
            }
        }
    }

    /**
     * Name: populateListView()
     * Description: populates the ListView with the dinosaur data
     */
    private void populateListView() {
        for (Dinosaur d : MainController.getPark().getParkmap().get(MainController.getZone()))
            lvdata.add(d.toString());

        dinosaurlistview.setItems(FXCollections.observableList(lvdata));
    }

    /**
     * Name: threatLevelLabelColor()
     * Description: sets the threat level label based on the risk of the zone
     * @param risk
     * @return
     */
    private Color threatLevelLabelColor(String risk) {
        switch (risk.toLowerCase()) {
            case "critical":
                return Color.MAROON;
            case "high":
                return Color.RED;
            case "medium":
                return Color.ORANGE;
            case "low":
                return Color.GREEN;
            default:
                return Color.BLUE;
        }
    }

    /**
     * Name: initialize()
     * Description: begins and sets the current scene
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateListView();
        zonelabel.setText(MainController.getZone().getName() + " Zone  (" + MainController.getZone().getZonecode() + ")");
        numdinolabel.setText("" + MainController.getPark().getParkmap().get(MainController.getZone()).size());
        threatlevellabel.setText(MainController.getZone().getRisk().toUpperCase());
        threatlevellabel.setTextFill(threatLevelLabelColor(MainController.getZone().getRisk()));
        yesradiobutton.setToggleGroup(group); // adding yes and no to a radio button group
        noradiobutton.setToggleGroup(group); // super easy to do
    }
}
