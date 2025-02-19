//package testcode;
//
//import java.util.*;
//import java.util.stream.*;
//
//class Employee {
//    int id;
//    String name;
//    double salary;
//
//    // Constructor, getters, and setters
//    public Employee(int id, String name, double salary) {
//        this.id = id;
//        this.name = name;
//        this.salary = salary;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
//}
//
//public class SortEmployee {
//    public static void main(String[] args) {
//        List<Employee> employees = Arrays.asList(
//            new Employee(1, "Alice", 50000),
//            new Employee(2, "Bob", 60000),
//            new Employee(3, "Charlie", 55000)
//        );
//
//        Optional<Employee> minSalary = employees.stream().
//        		min(Comparator.comparingDouble(Employee::getSalary));
//        
//        
//        Optional<Employee> maxSalary = employees.stream().
//        		max(Comparator.comparing(Employee::getName));
//        minSalary.ifPresent(x -> System.out.println(x.getName()));
//        maxSalary.ifPresent(employee -> System.out.println(employee));
//        
//        List<Employee> list = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());
//        
//        //employees.stream().sorted(Comparator.comparing(null))
//        
//        list.forEach(System.out::println);
//        //System.out.println(minSalary.get());
//        //sortedEmployees.forEach(System.out::println);
//    }
//}