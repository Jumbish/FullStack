package emailapp;

import java.util.Scanner;
import java.util.stream.Stream;

public class EmailApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Email email = new Email("Shweta", "A");
		String departmentName = null;
		String newEmail = null;
		String password = null;
		System.out.println("What is your department?");
	    Scanner scanner = new Scanner(System.in);
	    String name = scanner.nextLine();
	    if(name.isEmpty()){
	    	  newEmail = email.getFirstName()+"."+email.getLastName()+"@"+"."+Constant.COMPANY+".com";
	    }
	    else {
	    	for (Department day : Department.values()) {
		        if (day.name().toLowerCase().equalsIgnoreCase(name)) {
		        	departmentName =name;
		            break;
		        }
		    }
	    	
	    	 newEmail = email.getFirstName()+"."+email.getLastName()+"@"+departmentName+"."+Constant.COMPANY+".com";
	    	
	    }
	    
	    System.out.println(newEmail);
	    
	    password = Password.createPassword(12);
	    
	    System.out.println("password"+ password);
	    
	    String ChangedPassword = Password.changePassword(password);
	    
	    
	    
	    
	}
	
	

}

