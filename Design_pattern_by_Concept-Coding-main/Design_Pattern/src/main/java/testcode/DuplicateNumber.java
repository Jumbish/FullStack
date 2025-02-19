package testcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list = Arrays.asList(10,28,20,76, 20, 80, 80, 5,4,3,10, 10);
		Set<Integer> set = new HashSet<>();
		
		list.stream().filter(x -> !set.add(x)).collect(Collectors.toSet()).forEach(x -> System.out.print("x"+x));;
		
//		list.stream().filter(x ->!set.add(x))
//		.collect(Collectors.toSet())
//		.forEach(x -> System.out.println(x));
		
		
		 // Get unique numbers using streams
//        Set<Integer> uniqueNumbers = list.stream()
//                                         .collect(Collectors.toSet());
        
        //System.out.println("Unique Numbers: " + uniqueNumbers);

	}

}
