package com.bludots.StudentAdmin;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Random;

import com.bludots.StudentAdmin.Student.Course;

public class StudentManager {

	public static ArrayList<Student> studenten = new ArrayList<>();

	public static void search(String name) {
		System.out.println("Results of " + name);
		for (Student student : studenten) {
			if (student.getFirstName().equals(name) || student.getLastName().equals(name)) {
				student.showStudent();
				System.out.println();
			}
		}
	}

	public static void search(int id) {
		System.out.println("Student with id: " + id);
		for (Student student : studenten) {
			if (student.getStudentId().equals("NOVA/" + student.getCourseStartDate().getYear() + "/" + id)) {
				student.showStudent();
				System.out.println();
			}
		}
	}
	
	public static void searchByCourse(Course course) {
		searchByFirstNameAndCourse("", course);
	}

	public static void searchByFirstNameAndCourse(String searchFirstName, Course course) {
		System.out.println("Course: " + course.toString());
		System.out.println("Description: " + course.courseName());
		for (Student student : studenten) {
			if (student.getCourse().equals(course)) {
				String firstName = student.getFirstName();
				if(searchFirstName.equals("") || searchFirstName.equals(firstName)) {
					student.showStudent();
					System.out.println();
				}
			}
		}
	}
	
	public static void showStudentByTypeOfCourse(boolean searchBachelor) {
		String title = searchBachelor ? "Bachelors" : "Non-Bachelors";
		System.out.println(title);
		for (Student student : studenten) {
			boolean bachelorOrNot = student.getCourse().isBachelor();
			if (searchBachelor == bachelorOrNot) {
				student.showStudentWithCourse();
				System.out.println();
			}
		}
	}
	
	public static void showTotalStudentByTypeOfCourse(boolean searchBachelor) {
		String title = searchBachelor ? "Bachelors" : "Non-Bachelors";
		System.out.println(title);
		int total = 0;
		for (Student student : studenten) {
			boolean bachelorOrNot = student.getCourse().isBachelor();
			if (searchBachelor == bachelorOrNot) {
				total++;
			}
		}
		System.out.println("Number of " + title + " : " + total);
	}

	public static void showStudentenList() {
		for (Student student : studenten) {
			student.showStudent();
			System.out.println();
		}
	}

	public static void searchByHowLongTheStudentIsFollowingACourse(int years) {
		for (Student student : studenten) {
			if (student.getLengthOfCourse() >= years) {
				student.showStudent();
				System.out.println();
			}
		}
	}

	public static void searchByHowOldTheStudentIs(int years) {
		for (Student student : studenten) {
			if (student.getAge() >= years) {
				student.showStudent();
				System.out.println();
			}
		}
	}

	public static void searchStudentByDurationOfCourse(int duration) {
		System.out.println("Duration of course: " + duration);
		for (Student student : studenten) {
			if (student.getCourse().courseDuration() == duration) {
				student.toString();
			}
		}
	}

	public static void main(String[] args) {
		// Start Application
		fillStudentArray();
//		showStudentenList();
		System.out.println();

		// search by name
		search("Andy");
		System.out.println();

		// search By Id
		search(1);
		System.out.println();

		// search By course
		searchByCourse(Course.DATA_SCIENCE);
		System.out.println();
		
		//Search By FirstName and Course
		searchByFirstNameAndCourse("Whitney",Course.CYBERSECURITY);
		System.out.println();
		
		//Search by type of course
		showStudentByTypeOfCourse(true);
		System.out.println();

		showTotalStudentByTypeOfCourse(false);
		System.out.println();

		/*
		 * searchByHowLongTheStudentIsFollowingACourse(3); System.out.println();
		 * 
		 * searchByHowOldTheStudentIs(20); System.out.println();
		 * 
		 * searchStudentByDurationOfCourse(2); System.out.println();
		 */

	}

	public static void fillStudentArray() {
		Integer begin = 0;
		for (int i = 0; i < 20; i++) {
			Random random = new Random();
			begin++;

			String[] firstNames = { "Andy", "Benjamin", "Carl", "David", "James", "Gloria", "Jennifer", "Melissa",
					"Whitney", "Gabriella", "Jasmine" };
			int chooseFirstName = random.nextInt(firstNames.length);

			String[] lastNames = { "Johnson", "Smith", "Davis", "Williams", "Lopez", "Anderson", "Marting", "Lee",
					"Chan", "Thompson", "Walker", "Young", "Wright" };
			int chooseLastName = random.nextInt(lastNames.length);

			int maandArray = random.nextInt(12) + 1;
			int dagArray;
			if (maandArray == 2) {
				dagArray = random.nextInt(28) + 1;
			} else if (maandArray == 1 || maandArray == 3 || maandArray == 5 || maandArray == 7 || maandArray == 8
					|| maandArray == 10 || maandArray == 12) {
				dagArray = random.nextInt(31) + 1;
			} else {
				dagArray = random.nextInt(30) + 1;
			}
			int jaarArray = random.nextInt(2002 - 1985) + 1985;

			int chooseCourse = random.nextInt(Course.values().length);

			int month = random.nextInt(12) + 1;
			int day;
			if (month == 2) {
				day = random.nextInt(28) + 1;
			} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
					|| month == 12) {
				day = random.nextInt(31) + 1;
			} else {
				day = random.nextInt(30) + 1;
			}
			int year = random.nextInt(2021 - 2016) + 2016;

			int level = random.nextInt(Course.values()[chooseCourse].courseDuration() + 1);

			Student student = new Student(begin.toString(), firstNames[chooseFirstName], lastNames[chooseLastName],
					LocalDate.of(jaarArray, maandArray, dagArray), Course.values()[chooseCourse],
					LocalDate.of(year, month, day), level);

			studenten.add(student);
		}
	}
}
