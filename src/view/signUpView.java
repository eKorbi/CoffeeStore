package view;
//ekorbi20
import controller.UserController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class signUpView {

	public Scene showView(Stage primaryStage) {
	GridPane gp = new GridPane();
	gp.setHgap(10);
	gp.setVgap(10);
	gp.setPadding(new Insets(10, 10, 10, 10));
	gp.setAlignment(Pos.CENTER);
	Label firstNameLabel= new Label("First Name");
	firstNameLabel.setTextFill(Color.WHITE);
	firstNameLabel.setFont(Font.font("Cambria", 18));
	TextField firstNameField = new TextField();
	gp.add(firstNameLabel, 1, 1);
	gp.add(firstNameField, 2, 1);
	
	Label lastNameLabel= new Label("Last Name");
	lastNameLabel.setTextFill(Color.WHITE);
	lastNameLabel.setFont(Font.font("Cambria", 18));
	TextField lastNameField = new TextField();
	//gp.add(lastNameLabel, 1, 2);
	gp.add(lastNameLabel, 1 , 2);
	gp.add(lastNameField, 2, 2);
	
	Label emailLabel= new Label("Email:");
	emailLabel.setTextFill(Color.WHITE);
	emailLabel.setFont(Font.font("Cambria", 18));
	TextField emailField = new TextField();
	gp.add(emailLabel, 1, 3);
	gp.add(emailField, 2, 3);
	
	Label passwordLabel = new Label("Password:");
	passwordLabel.setTextFill(Color.WHITE);
	passwordLabel.setFont(Font.font("Cambria", 18));
	PasswordField passwordField= new PasswordField();
	gp.add(passwordLabel, 1, 4);
	gp.add(passwordField, 2, 4);
	
	Label verifyLabel = new Label("Verify Password:");
	verifyLabel.setTextFill(Color.WHITE);
	verifyLabel.setFont(Font.font("Cambria", 18));
	PasswordField verifyField= new PasswordField();
	gp.add(verifyLabel, 1, 5);
	gp.add(verifyField, 2, 5);
	
	
	Label positionLabel = new Label("Position");
	positionLabel.setTextFill(Color.WHITE);
	positionLabel.setFont(Font.font("Cambria", 18));
	gp.add(positionLabel, 1, 6);
	RadioButton cashier= new RadioButton("Cashier");
	cashier.setTextFill(Color.WHITE);
	cashier.setFont(Font.font("Cambria", 18));
	RadioButton manager= new RadioButton("Manager");
	manager.setTextFill(Color.WHITE);
	manager.setFont(Font.font("Cambria", 18));
	HBox hb = new HBox();
	hb.getChildren().addAll(cashier, manager);
	gp.add(hb, 2, 6);
	
	Label gender = new Label("Gender");
    gender.setTextFill(Color.WHITE);
    gender.setFont(Font.font("Cambria", 18));
	gp.add(gender, 1, 7);
	RadioButton male= new RadioButton("Male");
	male.setTextFill(Color.WHITE);
	male.setFont(Font.font("Cambria", 18));
   	RadioButton female= new RadioButton("Female");
    female.setTextFill(Color.WHITE);
    female.setFont(Font.font("Cambria", 18));
	RadioButton other = new RadioButton("Other");
	other.setTextFill(Color.WHITE);
	other.setFont(Font.font("Cambria", 18));
	HBox h = new HBox();
	h.getChildren().addAll(male, female);
	VBox v= new VBox();
	v.getChildren().addAll(h, other);
	gp.add(v, 2, 7);
	
	Button addButton = new Button("Add employee");
	addButton.setStyle("-fx-background-color:white;");
	
	addButton.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent arg0) {
			String name= firstNameField.getText();
			String surname= lastNameField.getText();
			String email= emailField.getText();
			String password= passwordField.getText();
			String verifyPassword= verifyField.getText();
			String gender="";
			if(male.isSelected()){
				gender=male.getText();
			}else{
				if(female.isSelected()){
					gender=female.getText();
				}else{
					gender=other.getText();
				}
			}
			String access="";
			if(cashier.isSelected()) {
				access=cashier.getText();
			}
			else if(manager.isSelected())
				access=manager.getText();
			
			UserController uc= new UserController();
		
			if(email.matches("^[a-z]*@bjcaffee.gmail.com$") && password.equals(verifyPassword)) {

            boolean result = uc.signUp(name, surname, email, password, verifyPassword, access);
			
			if(result){
				
			Alert successAlert= new Alert(AlertType.CONFIRMATION);
			successAlert.setHeaderText("The employee was successfully registered!");
			successAlert.showAndWait();
			successAlert.close();
			
			administratorView av = new administratorView();
			Scene sc = av.showView(primaryStage);
			primaryStage.setScene(sc);
			}
			}
			else {
				Alert error = new Alert(AlertType.ERROR);
				error.setContentText("Not valid email or password. Please enter the right credentials!");
				error.show();
			
			}}
		
	});
	Button cancelButton = new Button("Cancel");
	cancelButton.setStyle("-fx-background-color:white");
	
	cancelButton.setOnAction(e->{
		administratorView av = new administratorView();
		Scene sc1 = av.showView(primaryStage);
		primaryStage.setScene(sc1);
	});
	HBox hbtn = new HBox(addButton, cancelButton);
	hbtn.setPadding(new Insets(5, 5, 5, 5));
	hbtn.setMargin(addButton, new Insets(0, 10, 0, 0));
	hbtn.setAlignment(Pos.CENTER);
	gp.add(hbtn, 2, 9);
	gp.setStyle("-fx-background-image: url('resources/register.jpg'); " +
	           "-fx-background-position: center center; " +
	           "-fx-background-repeat: stretch;" +
	           "-fx-background-size: 450 450") ;
	Scene scene = new Scene(gp, 450, 450);
	primaryStage.setTitle("Sign up");
	primaryStage.setScene(scene);
	return scene;
	
}


}
