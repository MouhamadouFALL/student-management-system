package com.sms.ui;

import com.sms.model.Role;
import com.sms.model.Student;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentEditUIController {

	@FXML
	private TextField nomField;
	@FXML
	private TextField prenomField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField telephoneField;
	@FXML
	private TextField loginField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private ComboBox<String> roleComboBox;
	
	
	private Stage dialogStage;
	private Student student;
	private boolean validerClicked;
	
	@FXML
	private void initialize() {
		
		roleComboBox.getItems().clear();
		roleComboBox.getItems().addAll(Role.ADMINISTRATEUR.getValue(), Role.SIMPLE_UTILISATEUR.getValue());
		
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
//----------------------------------------------------------------------------------------------------------
//////////////////////////////////////////   Modifier un étudiant   ////////////////////////////////////////
	public void setStudent(Student student) {
		this.student = student;
		
		nomField.setText(student.getNom().get());
		prenomField.setText(student.getPrenom().get());
		emailField.setText(student.getEmail().get());
		telephoneField.setText(student.getTelephone().get());
		loginField.setText(student.getLogin().get());
		passwordField.setText(student.getPassword().get());
		roleComboBox.getSelectionModel().select(student.getRole().get());
	}
	
	// Called when the student clicks Valider
	@FXML
	private void handleValider() {
		if (isInputValid()) {
			student.setNom(new SimpleStringProperty(nomField.getText()));
			student.setPrenom(new SimpleStringProperty(prenomField.getText()));
			student.setEmail(new SimpleStringProperty(emailField.getText()));
			student.setTelephone(new SimpleStringProperty(telephoneField.getText()));
			student.setLogin(new SimpleStringProperty(loginField.getText()));
			student.setPassword(new SimpleStringProperty(passwordField.getText()));
			student.setRole(new SimpleStringProperty(roleComboBox.getSelectionModel().getSelectedItem()));
			
			validerClicked = true;
			dialogStage.close();
		}
	}
	
	// Validers the student input in the text fields
	private boolean isInputValid() {
		String errorMessage = "";
		
		if (nomField.getText() == null || nomField.getText().length() == 0) {
			errorMessage += "Le nom n'est pas renseigné. ";
		}
		
		if (prenomField.getText() == null || prenomField.getText().length() == 0) {
			errorMessage += "Le prenom n'est pas renseigné. ";
		}
		
		if (emailField.getText() == null || emailField.getText().length() == 0)  {
			errorMessage += "L'Email n'est pas renseigné.";
		}
		
		if (telephoneField.getText() == null || telephoneField.getText().length() == 0) {
			errorMessage += "Le téléphone n'est pas renseigné.";
		}
		
		if (errorMessage.length() == 0) return true;
		else {
			// show the error messsage
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Champs non renseignés et/ou non invalides !");
			alert.setHeaderText("Veuillez remplir tous les champs svp !");
			alert.setContentText(errorMessage);
			
			alert.showAndWait();
			return false;
		}
	}
//-------------------------------------------------------------------------------------------------

	@FXML
	private void handleAnnuler() {
		validerClicked = false;
		dialogStage.close();
	}
	
	public boolean isValiderClicked() {
		return validerClicked;
	}
	
	
	
}
