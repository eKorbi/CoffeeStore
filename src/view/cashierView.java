package view;
//ekorbi20
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import model.User;

public class cashierView {
    User currentUser;
    
	public cashierView(User currentUser) {
		this.currentUser = currentUser;
	}
	    
		  public Scene showScene(Stage primaryStage) {
				
				MenuBar menuBar = new MenuBar();
				
				GridPane pane = new GridPane();
				pane.setVgap(20);
				pane.getChildren().add(menuBar);
				Label logout = new Label("Log out");
				Menu exitMenu= new Menu("", logout);
				
				logout.setOnMouseClicked(e->{
					LogIn lv= new LogIn();
					primaryStage.setScene(lv.showView(primaryStage));
				});
				
				Button addItem = new Button("Create bill");
				addItem.setTextFill(Color.WHITE);
			    addItem.setStyle("-fx-background-color: #A47786;");
			    addItem.setAlignment(Pos.CENTER_RIGHT);
			    addItem.setFont(Font.font("Algerian", FontWeight.NORMAL, 23));
				addItem.setOnAction(e->{
						User u = new User("Eralba", "Korbi","ekorbi20@epoka.edu.al", "administrator");
						BillView abv = new BillView(u);
						Scene sc1 = abv.showView(primaryStage);
						primaryStage.setScene(sc1);
					});
				pane.add(addItem,3,7);
				
				Label helpLabel = new Label("Help");
				Menu helpMenu = new Menu("", helpLabel);
				helpLabel.setOnMouseClicked(e->{
					Alert helpAlert = new Alert(AlertType.INFORMATION);
					helpAlert.setTitle("Cashier functionalities");
					helpAlert.setContentText("If there consists any problem while adding bills contact IT_office@hotmail.com.");
					helpAlert.show();
				});
				
				menuBar.getMenus().addAll(helpMenu, exitMenu);
				
				
				pane.setStyle("-fx-background-image: url('resources/cashier-bg.jpg'); " +
				           "-fx-background-position: center center; " +
				           "-fx-background-repeat: stretch;" +
				           "-fx-background-size: 600 400") ;
				Scene scene = new Scene(pane, 600, 400);
				primaryStage.setTitle("Cashier");
				
				return scene;

			}
			
}
