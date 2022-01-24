package com.sms;

import java.io.IOException;

import com.sms.model.Student;
import com.sms.ui.StudentEditUIController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SMSApplication extends Application {
	
	private Stage primaryStage;
	private BorderPane mainUI;
	private AnchorPane studentUI;
	private DataSource dataSource;
	
	private static SMSApplication instance;

	@Override
	public void start(Stage primaryStage) {
		instance = this;
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Student Management System");
		dataSource = new DataSource();
		
		initRootLayout();
		showStudentUI();
	}
	
	// Initializes the root layout
	public void initRootLayout() {
		try {
			//Load root layout from fxml file
			mainUI = (BorderPane) FXMLLoader.load(getClass().getResource("ui/MainUI.fxml"));
			
			// show the scene containing the root Layout
			Scene scene = new Scene(mainUI);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// show the user UI inside the root layout.
	public void showStudentUI() {
		try {
			// Load userUI
			studentUI = (AnchorPane) FXMLLoader.load(getClass().getResource("ui/StudentUI.fxml"));
			
			// Set studentUI into the center of root layout 
			mainUI.setCenter(studentUI);
		}
		catch (IOException e) { 
			e.printStackTrace();
			}
	}

	// show the student edit ui
	 public boolean showStudentEditUI(Student student) {
		 try {
			 FXMLLoader loader = new FXMLLoader();
			 loader.setLocation(SMSApplication.class.getResource("ui/StudentEditUI.fxml"));
			 AnchorPane page = (AnchorPane) loader.load();
			 
			 // create the dialog Stage
			 Stage dialogStage = new Stage();
			 dialogStage.setTitle("Ajouter/Modifier un student");
			 dialogStage.initModality(Modality.WINDOW_MODAL);
			 dialogStage.initOwner(primaryStage);
			 dialogStage.setScene(new Scene(page));
			 
			 StudentEditUIController controller = loader.getController();
			 controller.setDialogStage(dialogStage);
			 controller.setStudent(student); // Set the student into the controller
			 
			 // Show the dialog and wait until the student closes it.
			 dialogStage.showAndWait();
			 return controller.isValiderClicked();
			 
		 }
		 catch (IOException e) {
			 System.err.println(e.getMessage()); return false;
		 }
	 }
	
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public static SMSApplication getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
