package view;
//ekorbi20
import controller.CashierController;
import controller.ManagerController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;

public class managerView {
User currentUser;
    
	public managerView(User currentUser) {
		this.currentUser = currentUser;
	}
	    
public Scene showView(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
	  	
		VBox vb = new VBox();
		
		Button addProdButton = new Button("Add Product");
		addProdButton.setStyle("-fx-background-color:#356f54;");
		addProdButton.setTextFill(Color.WHITE);
		addProdButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		Button exitButton = new Button("Exit");
		exitButton.setStyle("-fx-background-color:#356f54;");
		exitButton.setFont(Font.font("Algerian", FontWeight.NORMAL, 15));
		exitButton.setTextFill(Color.WHITE);
		
		
		vb.getChildren().add(addProdButton);
		vb.getChildren().add(exitButton);
        root.setRight(vb);
        root.setTop(menuBar);
        vb.setMargin(addProdButton, new Insets(5,10,5,10));
        vb.setMargin(exitButton, new Insets(5,10,5,10));
        vb.setPadding(new Insets(10));
        vb.setAlignment(Pos.CENTER);
        
        exitButton.setOnAction(e->{
			LogIn lg = new LogIn();
			Scene sc = lg.showView(primaryStage);
			primaryStage.setScene(sc);
		});
		
		addProdButton.setOnAction(e->{
			addProduct ap = new addProduct(currentUser);
			Scene sc = ap.showView(primaryStage);
			primaryStage.setScene(sc);
		});
		
		
		Label helpLabel = new Label("Help");
		Menu helpMenu = new Menu("", helpLabel);
		helpLabel.setOnMouseClicked(e->{
			Alert helpAlert = new Alert(AlertType.INFORMATION);
			helpAlert.setTitle("Manager functionalities");
			helpAlert.setContentText("If any problem consists while adding new products contact manage_office@hotmail.com.");
			helpAlert.show();
		});

		
		Label logout = new Label("Log out");
		Menu exitMenu= new Menu("", logout);
		
		logout.setOnMouseClicked(e->{
			LogIn lv= new LogIn();
			primaryStage.setScene(lv.showView(primaryStage));
		});
		menuBar.getMenus().addAll(helpMenu, exitMenu);
		
		//root.getChildren().add(menuBar);
		root.setStyle("-fx-background-image: url('resources/manager-bg.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 600 400") ;
		
		primaryStage.setTitle("Manager view");
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		
		
		
		Alert alert2 = new Alert(AlertType.WARNING);
		alert2.setHeaderText("Warning about Coffee Beans Dark Roast");
		alert2.setContentText("There is only one jar of Coffee Beans Dark Roast left in the store. Consider buying more!!");
		alert2.showAndWait();
		
	
		
		
		return scene;
		
		
		
		
	}
}
