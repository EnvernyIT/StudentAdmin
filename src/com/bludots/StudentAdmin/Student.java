package com.bludots.StudentAdmin;

import java.time.LocalDate;

public class Student {

	public enum Course {
		DATA_SCIENCE(4, "Data Science with python", true), CYBERSECURITY(2, "Comptia Cyber Security", false),
		SOFTWARE_DEVELOPMENT(3, "Software Development with java", true),
		DATA_ANALYSIS(3, "Data Analysis with python", true),
		WEB_DEVELOPMENT(2, "Web Development with vanilla javascript", false),
		MOBILE_DEVELOPMENT(2, "Mobile Development with dart(flutter)", false);

		private int duration;
		private String courseName;
		private boolean bachelor;

		private Course(int duration, String courseName, boolean bachelor) {
			this.duration = duration;
			this.courseName = courseName;
			this.bachelor = bachelor;
		}

		int courseDuration() {
			return duration;
		}

		String courseName() {
			return courseName;
		}

		boolean isBachelor() {
			return bachelor;
		}
	};

	private String studentId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private Course course;
	private LocalDate courseStartDate;
	private LocalDate expectedCourseEndDate;
	private int level;

	public Student(String studentId, String firstName, String lastName, LocalDate birthOfDate, Course course,
			LocalDate courseStartDate, int level) {
		super();
		this.studentId = "NOVA/" + courseStartDate.getYear() + "/" + studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = birthOfDate;
		this.course = course;
		this.courseStartDate = courseStartDate;
		this.level = level;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = "NOVA/" + courseStartDate.getYear() + "/" + studentId;
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

	public LocalDate getBirthOfDate() {
		return dateOfBirth;
	}

	public void setBirthOfDate(LocalDate birthOfDate) {
		this.dateOfBirth = birthOfDate;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDate getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public LocalDate getExpectedCourseEndDate() {
		return courseStartDate.plusYears(getLengthOfCourse());
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAge() {
		LocalDate now = LocalDate.now();
		LocalDate years = now.minusYears(dateOfBirth.getYear());
		return years.getYear();
	}

	public int getLengthOfCourse() {
		LocalDate now = LocalDate.now();
		LocalDate years = now.minusYears(courseStartDate.getYear());
		return years.getYear();
	}

	public void showStudentWithCourse() {
		System.out.println("Full Name: " + firstName + " " + lastName);
		System.out.println("Course: " + course);
	}

	public void showStudent() {
		System.out.println("ID: " + studentId);
		System.out.println("Full Name: " + firstName + " " + lastName);
		System.out.println("Birthdate: " + dateOfBirth);
		System.out.println("Course: " + course);
		System.out.println("Course Years: " + course.duration);
		System.out.println("Start Date: " + courseStartDate);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", course=" + course + ", courseStartDate=" + courseStartDate + "]";
	}

}
