package connectfour;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author ken
 */
public class ConnectFour extends Application {

    public static Scene scene;
    public static boolean pl_turn;
    public static boolean pvpbool;
    public static gamebackend.GameLogic theBoard;



    @Override
    public void start(Stage stage) throws Exception {
	Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

	theBoard = new gamebackend.GameLogic();

	scene = new Scene(root);
	scene.getStylesheets().add(this.getClass().getResource("/css/button_red.css").toExternalForm());
	pl_turn = true;
	stage.setTitle("Connect Four");
	stage.getIcons().add(new Image("/img/icon.png"));
	stage.setScene(scene);
	stage.setWidth(800);
	stage.setHeight(600);
	stage.setResizable(false);
	stage.show();
    }

        //scene functions
    public static boolean changeColors(boolean e){
	if(e){
	    scene.getStylesheets().add(ConnectFour.class.getResource("/css/button_blue.css").toExternalForm());
	}
	else {
	    scene.getStylesheets().clear();
	    scene.getStylesheets().add(ConnectFour.class.getResource("/css/button_red.css").toExternalForm());

	}
	return (! e);
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	launch(args);
    }

}
