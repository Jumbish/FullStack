package testcode;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class DateCaluculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // Get today's date
        LocalDate today = LocalDate.now();

        // Calculate the next Wednesday
		//        TemporalAdjusters is a utility class in the java.time.
		//        temporal package that provides a set of common date-time adjustments.
		//        These adjustments can be used to manipulate dates in various ways, 
		//        such as finding the next or previous occurrence of a specific day of the week.
        LocalDate nextWednesday = today.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));

        // Calculate the Wednesday two weeks from today
        //ChronoUnit is an enumeration in the java.time.temporal package that defines units of time, such as days, weeks, 
        //months, and years. These units can be used to perform date-time calculations.
        LocalDate wednesdayTwoWeeks = today.plus(2, ChronoUnit.WEEKS);

        // Print the result
        System.out.println("The date of the Wednesday two weeks from today is: " + wednesdayTwoWeeks);

	}

}
