package com.sms.model;

public enum Role {
	
	ADMINISTRATEUR("ADMINISTRATEUR"), 
	SIMPLE_UTILISATEUR("SIMPLE UTILISATEUR");
	
	private String value;
	
	private Role(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
