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
		
		// Clear the student Details form
		displayStudentDetails(null);
		// Ajouter liste de données observable à la table 
		studentTable.setItems(SMSApplication.getInstance().getDataSource().getStudents());
		
		//Add a changeListener to the studentTable
		addChangeListener();
	}
	
	/**
	* Fills all text fields to show details about the user.
	* If the specified user is null, all text fields are cleared.
	* 
	* @param user the user or null
	*/
	private void displayStudentDetails(Student stu) {
		if (stu != null) {
			
			// Fills the labels with info from the student
			this.nomLabel.setText(stu.getNom().get());
			this.prenomLabel.setText(stu.getPrenom().get());
			this.emailLabel.setText(stu.getEmail().get());
			this.telephoneLabel.setText(stu.getTelephone().get());
			this.loginLabel.setText(stu.getLogin().get());
			this.passwordLabel.setText("*******");
			this.roleLabel.setText(stu.getRole().get());
		}
		else {
			// Student is null, remove all the text.
			this.nomLabel.setText(null);
			this.prenomLabel.setText(null);
			this.emailLabel.setText(null);
			this.telephoneLabel.setText(null);
			this.loginLabel.setText(null);
			this.passwordLabel.setText(null);
			this.roleLabel.setText(null);
		}
	}
	
	/*
	 * Suveillez les changements sur la table et affiche les informations dans le formulaire
	 */
	private void addChangeListener() {
		studentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> displayStudentDetails(newValue));
	}
	
	
}
