package application.controller;

import application.Main;
import application.model.CrewMember;
import application.model.Fleet;
import application.model.Starship;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PersonnelController implements Initializable {

	@FXML
	private ImageView img1, img2, img3, img4, img5, img6, img7, img8;

	@FXML
	private Label lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8;

	@FXML
    private Label capname;

    @FXML
    private Label nocrew;

	@FXML private ImageView backgroundimg;

    @FXML

	private ArrayList<ImageView> images = new ArrayList<ImageView>();

	private ArrayList<Label> labels = new ArrayList<Label>();


	/**
     * This method loads the previous scene when the logout button is clicked.
     */
	@FXML public void handle(ActionEvent e) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			Main.tmpStage.setScene(new Scene(root, 800, 800));
			Main.tmpStage.show();
			Main.tmpStage.setResizable(false);
	}

	/**
	 * This method populates all the information including images before the user sees the scene.
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		CrewMember current = new CrewMember();
		Fleet fleet = null;
		int coCheck=0;

		labels.add(lbl1);
		labels.add(lbl2);
		labels.add(lbl3);
		labels.add(lbl4);
		labels.add(lbl5);
		labels.add(lbl6);
		labels.add(lbl7);
		labels.add(lbl8);

		images.add(img1);
		images.add(img2);
		images.add(img3);
		images.add(img4);
		images.add(img5);
		images.add(img6);
		images.add(img7);
		images.add(img8);


		try {
			fleet = new Fleet("United Federation of Planets");
			fleet.loadData(new File("data/fleet.csv"), new File("data/personnel.csv"));
			fleet.setImages();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fleet.toString();
		Starship tmpship = fleet.getStarshipCap(LoginController.capName);
		int tmpsize=tmpship.getCrew().size()-1;

		for(int i = 0; i< tmpship.getCrew().size();i++){
				current = tmpship.getCrew().get(i);
				switch (current.getPosition()) {

					case "Commanding Officer":
						labels.get(0).setText(current.getPosition() + "\n" + current.getRank() + " " + current.getName());
						images.get(0).setImage(current.getImage());
					break;
					case "First Officer":
						labels.get(1).setText(current.getPosition() + "\n" + current.getRank() + " " + current.getName());
						images.get(1).setImage(current.getImage());
					break;
					case "Chief Medical Officer":
						labels.get(2).setText(current.getPosition() + "\n" + current.getRank() + " " + current.getName());
						images.get(2).setImage(current.getImage());
					break;
					case "Chief Engineering Officer":
						labels.get(3).setText(current.getPosition() + "\n" + current.getRank() + " " + current.getName());
						images.get(3).setImage(current.getImage());
						break;

					default:
						labels.get(tmpsize).setText(current.getPosition() + "\n" + current.getRank() + " " + current.getName());
						images.get(tmpsize).setImage(current.getImage());
						tmpsize--;
				}
			}

		if(tmpship.getCrew().size() == 0){
			nocrew.setText("Ship has no Crew!");
		}

		Image img = null;
		try {
			img = new Image(new FileInputStream("data/background2.gif"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


		backgroundimg.setImage(img);
		backgroundimg.setFitWidth(1100);
		backgroundimg.setFitHeight(1150);
		backgroundimg.setOpacity(.20);

		capname.setText("Welcome, Captain " + (LoginController.capName.charAt(0)+"").toUpperCase()+ LoginController.capName.substring(1,LoginController.capName.length()).toLowerCase() + "\n"+ tmpship.getShipClass() + " " +  tmpship.getRegistry());
	}

}

