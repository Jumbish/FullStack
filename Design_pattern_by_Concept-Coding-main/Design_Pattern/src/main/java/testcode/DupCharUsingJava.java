package testcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DupCharUsingJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//to get the unique character
		String input = "welcome to code decode and code decode welcome you";
		
		String uniqCh = "aab25CGG67";
		
		
		
		String r1 = uniqCh.chars().filter(Character::isDigit).distinct().mapToObj(c-> String.valueOf((char)c)).collect(Collectors.joining());
		
		System.out.println(r1);
		
		String rr = uniqCh.chars().filter(Character::isLetter).mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());
		
		System.out.println(rr);
		
		
		uniqCh.chars().filter(Character::isLetter).mapToObj(c-> String.valueOf((char)c)).distinct().collect(Collectors.toList());
		
		List<String> result = uniqCh.chars().filter(Character::isLetter).mapToObj(c -> String.valueOf((char) c)).distinct().collect(Collectors.toList());
		
		System.out.println(result);
		
		
		System.out.println(uniqCh.chars());
		
		//to get the count of character
		List<Character> listch = uniqCh.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
		
		Collections.reverse(listch);
		
		String rev = listch.stream().map(String::valueOf).distinct().collect(Collectors.joining());
		
		
		System.out.println("rev" + rev);
		
		Map<Character, Long> mapch = listch.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		//mapch.forEach((chaa, co) -> System.out.print(chaa+"---"+co));
		
		mapch.entrySet().stream().filter(entry -> entry.getValue() <2)
		.forEach(entry -> System.out.println(entry.getKey() +"=========="+entry.getValue()));
		
		
		//to get the unique word
		List<String> list = Arrays.asList(input.split(" "));
		
	    List<String> wordCount = list.stream().map(String::toLowerCase).distinct().sorted().collect(Collectors.toList());
		
	    System.out.println("wordCount" + wordCount);
	    
	    //to get the word count
	    Map<String, Long> wordCount1 = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	    System.out.println(wordCount1);
	    wordCount1.entrySet().stream().filter(entry -> entry.getValue() > 1).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
	    
	    //wordCount1.forEach((word, count) -> System.out.println(word + ": " + count));
	}

}
