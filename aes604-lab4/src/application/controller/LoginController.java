package application.controller;

import application.Main;
import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Name: LoginController
 * Description: controls the login screen and all its properties
 */
public class LoginController implements Initializable {
	
	@FXML private PasswordField pass;

    @FXML private Button login;
    
    public static String capName = "";

    @FXML private TextField usrname;
    @FXML private Label errorlabel;

    @FXML ImageView smallimg;

	@FXML ImageView backgroundimg;

	User tmpUser = new User();

	/**
	 * This method tests to see if the username and password passed in by the user is correct and if so it 
	 * loads the PersonnelController and then sends the user to the next scene.
	 */
	@FXML public void handle(ActionEvent event) {
		try {
			capName = usrname.getText();
			tmpUser = new User(capName,pass.getText());
			tmpUser.populateuserdataLists();

			if(tmpUser.validate(usrname.getText(), pass.getText())) {
				Parent root = FXMLLoader.load(getClass().getResource("../view/Personnel.fxml"));
				Main.tmpStage.setScene(new Scene( root, 800, 800));
				Main.tmpStage.show();
				Main.tmpStage.setResizable(false);
			}
			else{
				errorlabel.setText("Error: Invalid Input!");
			}

		}catch(Exception e ) {
			e.printStackTrace();
		}

	}


	/**
	 * Name: initialize()
	 * Descritpion: just sets some images and their params to the view
	 * @param url
	 * @param resourceBundle
	 */
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		Image i = null, j= null;

		try {
			i = new Image(new FileInputStream("data/Background.gif"));
			j = new Image(new FileInputStream("data/ufp_banner-320.gif"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		backgroundimg.setImage(i);
		backgroundimg.setFitHeight(800);
		backgroundimg.setFitWidth(800);
		smallimg.setImage(j);


	}
}
