package com.sms.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty email;
	private StringProperty telephone;
	private StringProperty login;
	private StringProperty password;
	private StringProperty role;
	
	public Student(String nom, String prenom, String email, String telephone, Role role) {
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.email = new SimpleStringProperty(email);
		this.telephone = new SimpleStringProperty(telephone);
		
		// login et password par defaut
		this.login = new SimpleStringProperty(prenom.trim().toLowerCase() + "." + nom.trim().toLowerCase());
		this.password = new SimpleStringProperty("passer");
		
		this.role = new SimpleStringProperty(role.getValue());
	}
	
	public Student() {
		this("", "", "", "", Role.SIMPLE_UTILISATEUR);
		this.login = new SimpleStringProperty();
		this.password = new SimpleStringProperty();
	}

	
	
	
	////////////////////////////////////////GETTERS AND SETTERS ///////////////////////////////////////////
	
	public StringProperty getNom() {
		return nom;
	}

	public void setNom(StringProperty nom) {
		this.nom = nom;
	}

	public StringProperty getPrenom() {
		return prenom;
	}

	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}

	public StringProperty getEmail() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public StringProperty getTelephone() {
		return telephone;
	}

	public void setTelephone(StringProperty telephone) {
		this.telephone = telephone;
	}

	public StringProperty getLogin() {
		return login;
	}

	public void setLogin(StringProperty login) {
		this.login = login;
	}

	public StringProperty getPassword() {
		return password;
	}

	public void setPassword(StringProperty password) {
		this.password = password;
	}

	public StringProperty getRole() {
		return role;
	}

	public void setRole(StringProperty role) {
		this.role = role;
	}
	
}
