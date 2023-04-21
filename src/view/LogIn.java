package view;
//ekorbi20
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.User;

public class LogIn {
	
	User currentUser;
	
public Scene showView(Stage primaryStage) {
		
		Label usernameLabel = new Label("Username");
		usernameLabel.setTextFill(Color.WHITE);
        usernameLabel.setFont(Font.font("Cambria", 18));
		TextField usernameField = new TextField();
		
		Label passwordLabel = new Label("Password");
		passwordLabel.setTextFill(Color.WHITE);
		passwordLabel.setFont(Font.font("Cambria", 18));
		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("Password");
		
		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setVgap(20);
		gp.setPadding(new Insets(10,10,10,10));
		gp.addRow(0, usernameLabel, usernameField);
		gp.addRow(1, passwordLabel, passwordField);
		gp.setAlignment(Pos.CENTER);
		
		Button logInButton = new Button("Log In");
		logInButton.setStyle("-fx-background-color:linear-gradient(to right, black, orange);");
		logInButton.setTextFill(Color.WHITE);
		logInButton.setPrefWidth(70);
		logInButton.setFont(Font.font("New Times Roman", FontWeight.BOLD, 15));
      	Button exitButton = new Button ("Exit");
		exitButton.setStyle("-fx-background-color:linear-gradient(to right, black, orange);");
		exitButton.setTextFill(Color.WHITE);
		exitButton.setFont(Font.font("New Times Roman", FontWeight.BOLD, 15));
        exitButton.setPrefWidth(70);
		
		HBox hb = new HBox(logInButton, exitButton);
		hb.setPadding(new Insets(5, 5, 5, 5));
		hb.setMargin(logInButton, new Insets(0, 10, 0, 0));
		hb.setAlignment(Pos.CENTER);
		
		GridPane mainPane = new GridPane();
		Text titleText=new Text("THIS IS BEIJING COFFEE SHOP");
		titleText.setFont(Font.font("Algerian", FontWeight.NORMAL, 30));
		 titleText.setFill(Color.WHEAT);
		titleText.setStroke(Color.ORANGE);
		mainPane.addColumn(0, titleText, gp, hb);
		mainPane.setAlignment(Pos.CENTER);
		exitButton.setOnAction(e->{
			primaryStage.close();
		});
		
		logInButton.setOnAction(e->{
			if(usernameField.getText().equals("cashier") && passwordField.getText().equals("cashier"))
			{
				
			    cashierView cashierview = new cashierView(currentUser);
				Scene scene1 = cashierview.showScene(primaryStage);
				primaryStage.setScene(scene1);
					
			   
			}
			else if(usernameField.getText().equals("manager") && passwordField.getText().equals("manager"))
			{
				
				managerView mv = new managerView(currentUser);
				Scene sc = mv.showView(primaryStage);
			}
			else if(usernameField.getText().equals("admin") && passwordField.getText().equals("admin"))
			{
	
				administratorView av = new administratorView();
				Scene sc = av.showView(primaryStage);
			}
			
			else {
				Alert errorAlert = new Alert(AlertType.ERROR);
				errorAlert.setTitle("Error");
				errorAlert.setContentText("Enter the correct credencials!");
	            errorAlert.show();
			}
			
		});
		
		mainPane.setStyle("-fx-background-image: url('resources/login_bg.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 600 400") ;
		Scene scene = new Scene(mainPane, 600, 400);
		primaryStage.setTitle("Log In");
		return scene;
	}
}
