package com.bludots.Person;

public class Person implements Comparable<Person>{
	
	private Integer id;
	private String firstName;
	private String lastName;
	
	public Person(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	public void showPerson() {
		System.out.println("ID: " + id);
		System.out.println("Full Name: " + firstName + " " + lastName);
	}

	@Override
	public int compareTo(Person o) {
        return this.getFirstName().compareTo(o.getFirstName());
	}
	

}
