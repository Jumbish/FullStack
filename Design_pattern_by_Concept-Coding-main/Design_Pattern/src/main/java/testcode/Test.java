package testcode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//  BASIC_ISO_DATE, ISO_DATE, ISO_LOCAL_DATE, ISO_TIME, ISO_LOCAL_TIME, ISO_DATE_TIME, ISO_LOCAL_DATE_TIME.

//Given a list of transactions, find the sum of transaction amounts for each day using Java streams:

class A {
    public void print() {
        System.out.println("A");
    }
}


class B extends A {
    public void print() {
        System.out.println("B");
    }
}



class C extends A {
    public void print() {
        System.out.println("C");
    }
}



public class Test {
    public static void main(String[] args) {
    	 String [] arr = {"abc", "TrUe", "false", null, "FALSE"};
         for(String s : arr) {
             System.out.print(Boolean.valueOf(s) ? "T" : "F");
         }
    }
}
    	
		//    	 // making the arraylist object of List of Integer
		//        List<List<Integer> > number = new ArrayList<>();
		//      
		//        // adding the elements to number arraylist
		//        number.add(Arrays.asList(1, 2));
		//        number.add(Arrays.asList(3, 4));
		//        number.add(Arrays.asList(5, 6));
		//        number.add(Arrays.asList(7, 8));
		//      
		//        System.out.println("List of list-" + number);
		//        
		//        // using flatmap() to flatten this list
		//        List<Integer> flatList
		//            = number.stream()
		//                  .flatMap(list -> list.stream())
		//                  .collect(Collectors.toList());
		//      
		//        // printing the list
		//        System.out.println("List generate by flatMap-"
		//                           + flatList);




