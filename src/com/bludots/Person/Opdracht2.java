package com.bludots.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Opdracht2 {

	public static ArrayList<Person> people = new ArrayList<>();

	public static void showPeople() {
		for (Person person : people) {
			person.showPerson();
		}
	}

	public static void showPeopleByOrderFirstName() {

	}

	public static void main(String[] args) {

		fillPeople();
		showPeople();
		System.out.println();

		//FirstName
		System.out.println("List ordered by first name:");
		Collections.sort(people);
		showPeople();
		System.out.println();

		//LastName
		System.out.println("List ordered by last name:");
		Comparator<Person> compareByLastName = (Person o1, Person o2) -> o1.getLastName().compareTo(o2.getLastName());
		Collections.sort(people, compareByLastName);
		showPeople();

	}

	public static void fillPeople() {
		Integer id = 0;
		for (int i = 0; i < 10; i++) {
			Random random = new Random();

			String[] firstNames = { "Andy", "Benjamin", "Carl", "David", "James", "Gloria", "Jennifer", "Melissa",
					"Whitney", "Gabriella", "Jasmine" };
			int chooseFirstName = random.nextInt(firstNames.length);

			String[] lastNames = { "Johnson", "Smith", "Davis", "Williams", "Lopez", "Anderson", "Martin", "Lee",
					"Chan", "Thompson", "Walker", "Young", "Wright" };
			int chooseLastName = random.nextInt(lastNames.length);

			Person person = new Person(id, firstNames[chooseFirstName], lastNames[chooseLastName]);
			people.add(person);

			id++;
		}
	}

}
