package com.sms;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
		showUserUI();
	}
	
	// Initializes the root layout
	public void initRootLayout() {
		try {
			//Load root layout from fxml file
			mainUI = (BorderPane) FXMLLoader.load(getClass().getResource("ui/MainUI.fxml"));
			
			// show the scene containig the root Layout
			Scene scene = new Scene(mainUI);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// show the user UI inside the root layout.
	public void showUserUI() {
		try {
			// Load userUI
			studentUI = (AnchorPane) FXMLLoader.load(getClass().getResource("ui/StudentUI.fxml"));
			
			// Set studentUI into the center of root layout 
			mainUI.setCenter(studentUI);
		}
		catch (IOException e) { e.printStackTrace();}
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static SMSApplication getInstance() {
		return instance;
	}
}
