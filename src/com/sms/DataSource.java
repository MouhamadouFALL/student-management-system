package com.sms;

import com.sms.model.Role;
import com.sms.model.Student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataSource {

	private ObservableList<Student> students = FXCollections.observableArrayList();
	
	public DataSource() {
		//Ajout de quelques students
		students.add(new Student("LO", "Leuk", "leuk.lo@esmt.sn", "778886655", Role.ADMINISTRATEUR));
		students.add(new Student("BA", "Bouki", "bouki.ba@esmt.sn", "779990088", Role.SIMPLE_UTILISATEUR));
		students.add(new Student("Ka", "Mousse", "mousse.ka@esmt.sn", "220009988", Role.SIMPLE_UTILISATEUR));
		students.add(new Student("NDIR", "Dianakh", "dianakh.ndir@esmt.sn", "771114433", Role.ADMINISTRATEUR));
		students.add(new Student("DIOP", "Faye", "faye.diop@esmt.sn", "775554433", Role.ADMINISTRATEUR));
		students.add(new Student("LO", "Leuk", "leuk.lo@esmt.sn", "778886655", Role.ADMINISTRATEUR));
		students.add(new Student("BA", "Bouki", "bouki.ba@esmt.sn", "779990088", Role.SIMPLE_UTILISATEUR));
		students.add(new Student("Ka", "Mousse", "mousse.ka@esmt.sn", "220009988", Role.SIMPLE_UTILISATEUR));
		students.add(new Student("NDIR", "Dianakh", "dianakh.ndir@esmt.sn", "771114433", Role.ADMINISTRATEUR));
		students.add(new Student("DIOP", "Faye", "faye.diop@esmt.sn", "775554433", Role.ADMINISTRATEUR));
	}
	
	
	public ObservableList<Student> getStudents() {
		return students;
	}
}
