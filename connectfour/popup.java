package connectfour;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;



/**
 *
 * @author ken
 */
public class popup {
    public static void display(String title, String message){
	Stage window = new Stage();
	window.initModality(Modality.APPLICATION_MODAL);
	window.setTitle(title);
	window.getIcons().add(new Image("/img/icon.png"));
	
	VBox layout = new VBox(20);
	layout.setAlignment(Pos.CENTER);
	
	Label theMessage = new Label(message);
	Button close = new Button("OK");
	close.setOnAction(e -> window.close());
	
	layout.getChildren().addAll(theMessage, close);
	layout.setPadding(new Insets(20,20,20,20));
	
	Scene scene = new Scene(layout);
	window.setWidth(400);
	window.setScene(scene);
	window.showAndWait();
    }
    
}
