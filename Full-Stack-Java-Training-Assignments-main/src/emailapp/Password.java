package emailapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Password {

	public static String createPassword(int length) {

		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String specialChars = "!@#$%^&*()_+[]{}|;:,.<>?";
		
		
//		char[] upperCaseCh = upperCase.toCharArray();
//		
//		for (int i = 0; i < upperCaseCh.length; i++) {
//			char c = upperCaseCh[i];
//			
//		}
		
		String allChars = upperCase + lowerCase + digits + specialChars;
		
		
		Random random = new Random();
		
		StringBuilder strB = new StringBuilder();
		
		
		for (int i = 0; i <= length; i++) {
			
			int index = random.nextInt(allChars.length());
			
			strB.append(allChars.charAt(index));
			
		}
		
		return strB.toString();

	}
	
	public static String changePassword(String password) {
		
		
		// split string by no space 
//        String[] strSplit = password.split(""); 
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String specialChars = "!@#$%^&*()_+[]{}|;:,.<>?";
        
        
        boolean isUpperCase=false, isLowerCase=false, isDigit=false, isSpecialChars=false;
        // Now convert string into ArrayList 
        ArrayList<String> set = new ArrayList<String>( 
            Arrays.asList(specialChars)); 
		
		
		
		
		 for (char i : password.toCharArray()) {
			 
			 if (Character.isLowerCase(i))
				 isUpperCase = true;
	            if (Character.isUpperCase(i))
	            	isLowerCase = true;
	            if (Character.isDigit(i))
	            	isDigit = true;
	            if (set.contains(i))
	            	isSpecialChars = true;
			 
		 }
		
		if(isUpperCase && isLowerCase && isDigit && isSpecialChars) {
			System.out.println("password is strong, No need to change");
		}else {
			createPassword(12);
		}
		
		
		return password;
	
		
		
		
		
	}

}
