package connectfour;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;



/**
 *
 * @author ken
 */
public class aboutBox {
    public static  void display(){
	Stage aboutWindow = new Stage();
	aboutWindow.getIcons().add(new Image("/img/icon.png"));
	
	aboutWindow.initModality(Modality.APPLICATION_MODAL);
	aboutWindow.setTitle("About Connect Four");
	aboutWindow.setWidth(400);
	//aboutWindow.setMinHeight(400);
	
	Label blank = new Label();
	Label blank1 = new Label();
	
	Label label1 = new Label();
	label1.setText("Credits : in alphabetical order");
	
	Label label2 = new Label();
	label2.setText("Ishrat Lallmamode - AI");
	
	Label label3 = new Label();
	label3.setText("Kenneth Bonilla - GUI");
	
	Label label4 = new Label();
	label4.setText("Shawn Hulce - Backend");
	
	Label label5 = new Label();
	label5.setText("2016 - SER 215 Spring A");
	
	Button close = new Button("OK");
	close.setOnAction(e -> aboutWindow.close());
	
	VBox layout = new VBox(20);
	layout.getChildren().addAll(blank, label1, label2, label3,
		label4, label5, close, blank1);
	layout.setAlignment(Pos.CENTER);
	
	Scene scene = new Scene(layout);
	aboutWindow.setScene(scene);
	aboutWindow.showAndWait();
    }
}
