package view;
//ekorbi20
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;

public class administratorView {
private User currentUser;
	
	
	public Scene showView(Stage primaryStage) {
		
		BorderPane bp = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		Menu fileMenu = new Menu("File");
		
		MenuItem viewEmployees= new MenuItem("View employees");
		MenuItem addEmployees = new MenuItem("Add employee");
		MenuItem totalIncome = new MenuItem("Total income");
		MenuItem totalCost = new MenuItem("Total cost");
		
		Label label= new Label("Beijing coffee shop" + System.lineSeparator() +
				"is one of the best in city." + System.lineSeparator()
		+ "Beijing caffee owners" + System.lineSeparator() + "taking advantage of the" + System.lineSeparator()
		+ "coffee house rage that has been"+ System.lineSeparator()+  "sweeping the country." + System.lineSeparator()
		+ "Along with taking advantage of this trend" + System.lineSeparator() +"they are also planning for the future"
		+ System.lineSeparator() + "Beijing Coffee is also"  + System.lineSeparator()
		+ "marketing itself as a full service restaurant" + System.lineSeparator() + "to maintain stability in case" 
		+System.lineSeparator() + "the coffee trend begins to fizzle.");
		label.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15));
		label.setStyle("-fx-text-fill: white;");
		label.setStyle("-fx-background-color:#8FBC8F; -fx-padding: 25px;");
	    bp.setMargin(label, new Insets(10,10,10,10));
		
		bp.setLeft(label);
		
		fileMenu.getItems().addAll(viewEmployees, addEmployees, totalIncome, totalCost);
		
		totalIncome.setOnAction(e->{
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setHeaderText("Total incomes for the day");
			alert1.setContentText("Total incomes that Beijing caffee has earned up by far: $1000");
			alert1.show();
		});
		
		totalCost.setOnAction(e->{
			Alert alert2 = new Alert(AlertType.INFORMATION);
			alert2.setHeaderText("Total costs for the day");
			alert2.setContentText("Total costs that have arisen today: $195.30");
			alert2.show();
		});
		
		addEmployees.setOnAction(e->{
			signUpView sv = new signUpView();
			Scene sc = sv.showView(primaryStage);
			primaryStage.setScene(sc);
		});
		
		viewEmployees.setOnAction(e->{
			EmployeesView aev = new EmployeesView(currentUser);
			Scene sc = aev.showScene(primaryStage);
			primaryStage.setScene(sc);
		});
		
		
		Label logout = new Label("Log out");
		Menu exitMenu= new Menu("", logout);
		logout.setOnMouseClicked(e->{
			LogIn lv= new LogIn();
			primaryStage.setScene(lv.showView(primaryStage));
		});
		
		Label helpLabel = new Label("Help");
		Menu helpMenu = new Menu("", helpLabel);
		helpLabel.setOnMouseClicked(e->{
			Alert helpAlert = new Alert(AlertType.INFORMATION);
			helpAlert.setTitle("Administrator functionalities");
			helpAlert.setContentText("If any problem consists while accessing employees data"
					+ " contact IT_office@hotmail.com");
			helpAlert.show();
		});
		
		menuBar.getMenus().addAll(fileMenu, helpMenu, exitMenu);
		
		bp.setTop(menuBar);
		primaryStage.setTitle("Administrator view");
		bp.setStyle("-fx-background-image: url('resources/sign-up-bg.jpg'); " +
		           "-fx-background-position: center center; " +
		           "-fx-background-repeat: stretch;" +
		           "-fx-background-size: 600 400") ;
		Scene scene = new Scene(bp, 600, 400);
		primaryStage.setScene(scene);
		return scene;
		
	}
}
