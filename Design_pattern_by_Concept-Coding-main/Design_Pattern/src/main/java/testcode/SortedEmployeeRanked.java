package testcode;

import java.util.*;
import java.util.stream.*;

class Employee {
    private int id;
    private String name;
    private int rank;

    // Constructor, getters, and setters

    public Employee(int id, String name, int rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}

public class SortedEmployeeRanked {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 5),
            new Employee(2, "Bob", 3),
            new Employee(3, "Charlie", 4),
            new Employee(4, "David", 2),
            new Employee(5, "Eve", 1),
            new Employee(6, "Frank", 6)
        );
        
        employees.stream().filter(employee -> employee.getId() % 2 == 0)
        .sorted(Comparator.comparing(Employee::getRank).reversed()).limit(1).collect(Collectors.toList()).forEach(employee -> System.out.println(employee));
        
       // emp.forEach(System.out::prinln);
        
        
		//        employees.stream().sorted(Comparator.comparing(Employee::getRank).reversed()).limit(5).collect(Collectors.toList())
		//        .forEach(employee -> System.out.println(employee));
		//
		//        List<Employee> topRankedEmployees =employees.stream()
		//        		.sorted(Comparator.comparing(Employee::getRank))
		//        		.limit(5).collect(Collectors.toList());

        //topRankedEmployees.forEach(System.out::println);
    }
}