package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Ariel Guerrero
 *
 */

public class Main extends Application {

    public static Stage tmpstage;
    Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            tmpstage = primaryStage;
            root = FXMLLoader.load(getClass().getResource("../application/view/Main.fxml"));
            tmpstage.setTitle("Login");
            tmpstage.setScene(new Scene(root, 800, 800));
            tmpstage.show();
            tmpstage.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}