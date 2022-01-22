package com.sms.ui;

import com.sms.SMSApplication;
import com.sms.model.Student;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StudentUIController {

	@FXML
	private TableView<Student> studentTable;
	@FXML
	private TableColumn<Student, String> nomColumn;
	@FXML
	private TableColumn<Student, String> prenomColumn;
	@FXML
	private Label nomLabel;
	@FXML
	private Label prenomLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label telephoneLabel;
	@FXML
	private Label loginLabel;
	@FXML
	private Label passwordLabel;
	@FXML
	private Label roleLabel;
	
	public StudentUIController() {}
	
	/**
	 * Initializes the controller class. this method is automatically called 
	 * after the fxml file has been loaded
	 */
	@FXML
	private void initialize() {
		// initilise la table des utilisateurs
		nomColumn.setCellValueFactory(cellData -> cellData.getValue().getNom());
		prenomColumn.setCellValueFactory(cellData -> cellData.getValue().getPrenom());
		
		// Ajouter liste de données observable à la table 
		studentTable.setItems(SMSApplication.getInstance().getDataSource().getStudents());
	}
}
