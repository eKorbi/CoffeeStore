package view;
//ekorbi20
import controller.productController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;
import model.product;


public class addProduct {
	 User currentUser;
	    String supplierName;
	    String address;
	    String email;
	    String phone;
	    
		public addProduct(User currentUser) {
			this.currentUser = currentUser;
		}
	
	public Scene showView(Stage primaryStage) {
		GridPane gp = new GridPane();
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(10, 10, 10, 10));
		gp.setAlignment(Pos.CENTER);
		Label nameLabel= new Label("Name");
		nameLabel.setTextFill(Color.SADDLEBROWN);
		nameLabel.setFont(Font.font("Cambria", FontWeight.EXTRA_BOLD, 20));
		TextField firstNameField = new TextField();
		gp.add(nameLabel, 1, 1);
		gp.add(firstNameField, 2, 1);
		
		Label prodIdLabel= new Label("ID");
		prodIdLabel.setTextFill(Color.SADDLEBROWN);
		prodIdLabel.setFont(Font.font("Cambria", FontWeight.EXTRA_BOLD,20));
		TextField idField = new TextField();
		gp.add(prodIdLabel, 1 , 2);
		gp.add(idField, 2, 2);
		
		Label quantLabel= new Label("Quantity");
		quantLabel.setTextFill(Color.SADDLEBROWN);
	    quantLabel.setFont(Font.font("Cambria", FontWeight.EXTRA_BOLD, 20));
		TextField quantField = new TextField();
		gp.add(quantLabel, 1, 3);
		gp.add(quantField, 2, 3);
		
		
		Label sellPrLabel = new Label("Sell Price:");
		sellPrLabel.setTextFill(Color.SADDLEBROWN);
		sellPrLabel.setFont(Font.font("Cambria", FontWeight.EXTRA_BOLD, 20));
		TextField sellField= new TextField();
		gp.add(sellPrLabel, 1, 4);
		gp.add(sellField, 2, 4);
	
		
		
		Button addButton = new Button("Add product");
		addButton.setStyle("-fx-background-color: #356f54;");
	    addButton.setTextFill(Color.WHITE);
	    addButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		
		addButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			productController pc = new productController();
				
				boolean isValidname=false;
				boolean validBtPrice=false;
				boolean validSellPrice=false;
				if(firstNameField.getText().isEmpty()){
					firstNameField.clear();
					firstNameField.setPromptText("Enter the name of the product");
					firstNameField.setStyle("-fx-prompt-text-fill: #8bc7a9");
				}else {
						isValidname=true;
				}
				

				if(!sellField.getText().isEmpty()) {
				  if(sellField.getText().toString().matches("^[0-9]{2,}$")) {
					     validSellPrice = true;
				  }else {
					sellField.clear();
					sellField.setPromptText("Invalid price format");
					sellField.setStyle("-fx-prompt-text-fill: red");
			      }
				}else {
					sellField.clear();
					sellField.setPromptText("Enter sell price");
					sellField.setStyle("-fx-prompt-text-fill: red");
				}
				
				boolean isValidId=false;
				if((idField.getText()).isEmpty()) {
					idField.setPromptText("Enter the ID of the product");
					idField.setStyle("-fx-prompt-text-fill: #8bc7a9");
				}else {
					if(idField.getText().toString().matches("^[0-9]{6}$")) {
						if(pc.useBarcode(idField.getText().toString())) {
							idField.clear();
							idField.setPromptText("This ID is used before");
							idField.setStyle("-fx-prompt-text-fill: #8bc7a9");
						}else {
							isValidId=true;
						}
					}else {
						idField.clear();
						idField.setPromptText("Should Be : XXXXXX");
						idField.setStyle("-fx-prompt-text-fill: #8bc7a9");
					}
				}
				
				
				if(isValidId  && isValidname  && validSellPrice) {
					
					double sellPrice = Double.parseDouble(sellField.getText().toString());
					pc.addProduct(new product(idField.getText(),firstNameField.getText(),sellPrice));
					Alert alert2 = new Alert(AlertType.INFORMATION);
					alert2.setHeaderText("Congrats");
					alert2.setContentText("Product is added successfully!");
					alert2.show();
			
				}
			}
		});
		Button cancelButton = new Button("Cancel");
		cancelButton.setStyle("-fx-background-color:#356f54");
		cancelButton.setTextFill(Color.WHITE);
		cancelButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		
		cancelButton.setOnAction(e->{
			managerView mv = new managerView(currentUser);
			Scene sc1 = mv.showView(primaryStage);
			primaryStage.setScene(sc1);
		});
		HBox hbtn = new HBox(addButton, cancelButton);
		hbtn.setPadding(new Insets(5, 5, 5, 5));
		hbtn.setMargin(addButton, new Insets(0, 10, 0, 0));
		hbtn.setAlignment(Pos.CENTER);
		gp.add(hbtn, 2, 8);
		gp.setStyle("-fx-background-image: url('resources/kafe-01.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 413 413") ;
		Scene scene = new Scene(gp, 413, 413);
		primaryStage.setTitle("Add Product");
		primaryStage.setScene(scene);
		return scene;
		
	}

}
