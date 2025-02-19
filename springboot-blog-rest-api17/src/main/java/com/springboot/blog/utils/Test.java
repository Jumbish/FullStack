package com.springboot.blog.utils;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
//
//		List list = listOfIntegers.stream().filter((i -> i % 2 == 0)).collect(Collectors.toList());
//
//		System.out.println(list);
//
//		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
//
//		List list1 = listOfStrings.stream().distinct().collect(Collectors.toList());
//		System.out.println(list1);
//
//		String inputString = "Java Concept Of TheDay";
//
//		Map<Character, Long> charCountMap = inputString.chars().mapToObj(c -> (char) c)
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(charCountMap);
//
//		Map<String, Long> charCountMap1 = Arrays.stream(inputString.split(" "))
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//		System.out.println(charCountMap1);
//
////		
//
//		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
//				"Note Book", "Pencil");
//
//		Map<String, Long> stationaryCountMap = stationeryList.stream()
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//		System.out.println(stationaryCountMap);
//
//		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
//
//		decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
//
//		
//		List<String> listOfStrings1 = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
//		
//		String joinString = listOfStrings1.stream().collect(Collectors.joining(", ", "[", "]"));
//		System.out.println(joinString);
//		
//		List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//		
//		
//		listOfIntegers1.stream().filter(i-> i%5==0).forEach(System.out::println);
//		
//		
//		List<Integer> listOfIntegers2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
//		
//		listOfIntegers2.stream().max(Comparator.naturalOrder()).get();
//		listOfIntegers2.stream().min(Comparator.naturalOrder()).get();
		
		int[] a = new int[] {4, 2, 5, 1,2};
        
        int[] b = new int[] {8, 1, 9, 5};
        
        Arrays.stream(a).sorted().distinct().forEach(System.out::println);
        
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
        
        String s1 = "RaceCar";
        String s2 = "CarRace";
        
        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        System.out.println(s1);
        System.out.println(s2);
        
        int i = 15623;
        Integer  sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(sumOfDigits);
//        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().forEach(System.out::println);
		
//		System.out.println(l);

		// Programmer Good A Is jumbish
//		String str = "Jumbish is a good programmer";
//		StringBuffer str1 = new StringBuffer();
//		String rev = "";
//		for (int i = 0; i < str.length() ; i++) {
//			
//			rev = rev + str.charAt(i);
//			
////			str1.append(rev)
////			rev = rev + str.split(" ");
//			
//		}

//		System.out.println(rev);

//		String[][] persons = { 
//				{ "Alice", "28", "Female", "New York" }, 
//				{ "Bob", "22", "Male", "Los Angeles" },
//				{ "Charlie", "30", "Male", "Chicago" }, 
//				{ "Diana", "26", "Female", "New York" },
//				{ "Eva", "24", "Female", "San Francisco"} 
//				};
//		Map<String, String> map = new HashMap<String, String>();
//		
//		List<String[]> list = Arrays.asList(persons);
//		
//		
//		System.out.println(list);
//		list.stream().filter((i)-> persons[i][].)

	}

}
