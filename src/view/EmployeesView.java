package view;
//ekorbi20
import java.util.ArrayList;

import controller.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;

public class EmployeesView {
private User currentU;
	
	public EmployeesView(User u){
		currentU= u;
	}
	
	public Scene showScene(Stage primaryStage) {
	VBox root= new VBox();
	UserController uc= new UserController();
	ArrayList<User> users =uc.getUsers();
	ObservableList<User> list=FXCollections.observableArrayList(users);
	
	TableView<User> table = new TableView();
	
	table.setItems(list);
	table.setEditable(true);
	
	TableColumn nameColumn = new TableColumn("First Name");
	nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	nameColumn.setCellValueFactory(new PropertyValueFactory("name"));
	
	nameColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

		public void handle(CellEditEvent t) {
			User currentU= (User) t.getTableView().getItems().get(t.getTablePosition().getRow());
			int pos= table.getSelectionModel().getSelectedIndex();
			String newName=(String) t.getNewValue();
			
			currentU.setName(newName);
			uc.editUser(currentU, pos);
		} });
	
	TableColumn lastNameColumn = new TableColumn("Last Name");
	lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	lastNameColumn.setCellValueFactory(new PropertyValueFactory("surname"));
	lastNameColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

		public void handle(CellEditEvent t) {
			User currentUser= (User) t.getTableView().getItems().get(t.getTablePosition().getRow());
			int pos= table.getSelectionModel().getSelectedIndex();
			String newSurname=(String) t.getNewValue();
			currentUser.setSurname(newSurname);
			uc.editUser(currentUser, pos);
		} });
	
	TableColumn emailColumn = new TableColumn("Email");
	emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	emailColumn.setCellValueFactory(new PropertyValueFactory("email"));
	
	emailColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

		@Override
		public void handle(CellEditEvent t) {
			// TODO Auto-generated method stub
			
			User currentUser= (User) t.getTableView().getItems().get(t.getTablePosition().getRow());
			int pos= table.getSelectionModel().getSelectedIndex();
			String newEmail=(String) t.getNewValue();
			
			currentUser.setEmail(newEmail);
			uc.editUser(currentUser, pos);
		}
		
	});
	
	TableColumn positionColumn = new TableColumn("Position");
	positionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
	positionColumn.setCellValueFactory(new PropertyValueFactory("access"));
	
	positionColumn.setOnEditCommit(new EventHandler<CellEditEvent>(){

		public void handle(CellEditEvent t) {
			// TODO Auto-generated method stub
			
			User currentUser= (User) t.getTableView().getItems().get(t.getTablePosition().getRow());
			int pos= table.getSelectionModel().getSelectedIndex();
			String newPosition=(String) t.getNewValue();
			
			currentUser.setAccess(newPosition);
			uc.editUser(currentUser, pos);
		} });
		
	
	
	
	table.getColumns().addAll(nameColumn,lastNameColumn,emailColumn, positionColumn);
	
	Button addButton = new Button("Add employee");
	addButton.setStyle("-fx-background-color:#8FBC8F;");
	addButton.setOnAction(e->{
		signUpView sv = new signUpView();
		Scene sc = sv.showView(primaryStage);
		primaryStage.setScene(sc);
	});
	
	Button cancelButton = new Button("Cancel");
	cancelButton.setStyle("-fx-background-color:#8FBC8F;");
	cancelButton.setOnAction(e->{
		administratorView av = new administratorView();
		primaryStage.setScene(av.showView(primaryStage));
	});
	
	HBox hb = new HBox();
	hb.getChildren().addAll(addButton, cancelButton);
	hb.setMargin(addButton, new Insets(0,10,0,10));
	hb.setPadding(new Insets(5,5,5,5));
	
	root.getChildren().addAll(table, hb);
	
	root.setStyle("-fx-background-image:url('imageResources/imageA.jpg')");
	
	Scene scene = new Scene(root, 400, 450);
	scene.getStylesheets().add("/Style/format.css");
	
	primaryStage.setTitle("All employees");
	primaryStage.setScene(scene);
	return scene;
	}
}
