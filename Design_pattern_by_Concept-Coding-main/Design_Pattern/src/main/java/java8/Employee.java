package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    

    @Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(name, other.name);
	}

	@Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Jumbish", 25));
        employees.add(new Employee("Alice", 30));
        employees.add(new Employee("Jumbish", 25)); // Same name and age
        employees.add(new Employee("Bob", 40));
        employees.add(new Employee("Apple", 30)); // Same name and age
        
        
        //sliced ages
        List<Integer> ages = employees.stream().map(x -> x.getAge()).sorted().collect(Collectors.toList());
        
        System.out.println(ages);
        
        List<Integer> slicedAge = ages.stream().skip(1).limit(2).collect(Collectors.toList());
        
        System.out.println(slicedAge);
        // to get the summery
        List<Integer> list = employees.stream().map(x -> x.getAge()).collect(Collectors.toList());
        
        
        
        IntSummaryStatistics summery = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("summery"+ summery);
        list.forEach(System.out::println); 
        // to find max age 
        
        Optional<Employee> employeeName = employees.stream().max(Comparator.comparing(Employee::getAge));
        
        Optional<Employee> employeeNameMin = employees.stream().min(Comparator.comparing(Employee::getAge));
        employeeNameMin.ifPresent(x -> System.out.println(x.getName()));
        //System.out.println(employeeName.get().name);
        
      //to group the employee by age
        Map<Integer, List<Employee>> wordCount1 = employees.stream()
        		.collect(Collectors.groupingBy(Employee::getAge, Collectors.toList()));

        wordCount1.forEach((Employee, count) -> System.out.println(Employee + ": " + count));
        
        //to group the unique employee by age
        Map<Integer, Set<Employee>> wordCount2 = employees.stream()
        		.collect(Collectors.groupingBy(Employee::getAge, TreeMap::new, Collectors.toSet()));
        wordCount2.forEach((Employee, count) -> System.out.println(Employee + ": " + count));
    }
}

