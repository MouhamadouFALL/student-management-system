package com.sms.ui;

import com.sms.SMSApplication;
import com.sms.model.Student;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
		// Ajouter liste de donn?es observable ? la table 
		studentTable.setItems(SMSApplication.getInstance().getDataSource().getStudents());
		
		//Add a changeListener to the studentTable
		addChangeListener();
	}
	
	
	//---------------------------------------------------------------------------------------------------------------------------------
	///////////////////////////////////////////////// S?lectionner un ?tudiant et l'afficher //////////////////////////////////////////
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
	 * Suveillez les changements sur la table et affiche les informations dans le formulaire (?couter)
	 */
	private void addChangeListener() {
		studentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> displayStudentDetails(newValue));
	}
	//---------------------------------------------------------------   FIN   --------------------------------------------------------------------------------------
	
	
	///////////////////////////////////////////////////////////// Supprimer un ?tudiant /////////////////////////////////////////////////////////////////
	/**
	 * Called when the user clicks on the Supprimer button
	 */
	@FXML
	private void handleDeleteStudent() {
		int selectedIndex = studentTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			studentTable.getItems().remove(selectedIndex);
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Warning ...");
			alert.setHeaderText("Alert !");
			alert.setContentText("veuillez s?lectionner un student svp !");
			
			alert.showAndWait();
		}
	}
	
//////////////////////////////////  
	@FXML
	 private void handleNewStudent() {
		 Student student = new Student();
		 
		 boolean validerClicked = SMSApplication.getInstance().showStudentEditUI(student);
		 if (validerClicked) {
			 SMSApplication.getInstance().getDataSource().getStudents().add(student);
		 }
	 }
	 
	 @FXML
	 private void handleModifierStudent() {
		 Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
		 
		 if (selectedStudent != null) {
			 boolean validerClicked = SMSApplication.getInstance().showStudentEditUI(selectedStudent);
			 if (validerClicked) {
				 displayStudentDetails(selectedStudent);
			 }
		 }
		 else {
			 // Nothing selected
			 Alert alert = new Alert(AlertType.WARNING);
			 alert.setTitle("Aucune selection");
			 alert.setHeaderText("Aucun ?tudiant a ?t? s?lectionner!");
			 alert.setContentText("Veuillez choisir un ?tudiant svp !");
			 
			 alert.showAndWait();
		 }
	 }
	
}
