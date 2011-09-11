package de.md.domain;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private String name;
	private String firstName;
	private String email;
	private Salutation salutation = Salutation.HERR;
	
	public Customer(String name, String firstName, String email) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.email = email;
	}
	
	public Customer(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public Salutation getSalutation() {
		return salutation;
	}

	public void setSalutation(Salutation gender) {
		this.salutation = gender;
	}



	public static enum Salutation {
		HERR,FRAU
	}

}
