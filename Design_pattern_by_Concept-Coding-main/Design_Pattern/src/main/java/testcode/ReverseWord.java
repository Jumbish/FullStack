package testcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String word1 = "I hate eating out";
		
		
		//		
		//		String[] words = word1.split(" ");
		//        StringBuilder reversed = new StringBuilder();
		//        
		//        for (int i =  words.length-1; i >=0;  i--) {
		//			
		//        	reversed.append(words[i]).append(" ");
		//        	
		//		}
		//        
		//        System.out.println(reversed);
        
        List<String> list = Arrays.asList(word1.split(" "));
        Collections.reverse(list);
        
        System.out.println(list);
        String wording = list.stream().collect(Collectors.joining(" "));
        System.out.println(wording);
        // Reverse each word and append to the result
		//        for (String word : words) {
		//            StringBuilder reversedWord = new StringBuilder(word);
		//            reversed.append(reversedWord.toString()).append(" ");
		//        }
		//
		//        // Trim the trailing space
		//        System.out.println(reversed.toString().trim());
    }

}
