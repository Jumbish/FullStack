package studentdatabase;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Student {

	private String studentId;
	private String name;
	private String courses;
	private int enrolledYear;
	private double balance;
	private static int costOFCourses = 600;
	private int tutionBalance;

	public Student() {
		System.out.println("Please enter the name and year for the student");
		Scanner sc1 = new Scanner(System.in);
		this.name = sc1.nextLine();
//		System.out.println("name " + name);
		this.enrolledYear = sc1.nextInt();
//		System.out.println("year " + enrolledYear);
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getEnrolledYear() {
		return enrolledYear;
	}

	public void setEnrolledYear(int enrolledYear) {
		this.enrolledYear = enrolledYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void enroll() {
		
		do {	
			System.out.print("Please enter the course to enroll");
			Scanner sc1 = new Scanner(System.in);
			String course = sc1.nextLine();
			
			if(!course.equals("Q")) {
				courses = course;
				tutionBalance = tutionBalance + costOFCourses;
			}else {
				break;
			}
		}while(1!=0);
		
		System.out.println("Enrolled in "+ courses);
		System.out.println("Tution Balance "+ tutionBalance);
	}
	
	

}
