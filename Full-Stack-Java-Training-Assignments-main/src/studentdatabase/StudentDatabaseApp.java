package studentdatabase;

import java.util.Random;
import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("How many new student will be joining");
		Scanner sc = new Scanner(System.in);
		int numberOfStudent = sc.nextInt();
		
		for (int i = 0; i < numberOfStudent; i++) {
			Student stu = new Student();
			stu.setStudentId(generatedUniqueID(5));
			System.out.println(stu.getName()+" "+stu.getEnrolledYear()+" "+stu.getStudentId() );
			stu.enroll();
		}

	}
	
	public static String generatedUniqueID(int length) {
		
		String characters = "123456789";
		Random random = new Random();
		StringBuilder uniqueId = new StringBuilder();
		
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			uniqueId.append(characters.charAt(index));
		}
		
		return uniqueId.toString();
		
	}

}
