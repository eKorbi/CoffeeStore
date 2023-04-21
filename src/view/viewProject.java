package view;
//ekorbi20
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class viewProject extends Application{
public void start(Stage primaryStage) throws Exception {
		
		LogIn project = new LogIn();
		
		Scene scene = project.showView(primaryStage);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.getIcons().add(new Image("resources/icons.jpg"));

	}
	
	public static void main (String [] args) {
		launch(args);
	}
}
