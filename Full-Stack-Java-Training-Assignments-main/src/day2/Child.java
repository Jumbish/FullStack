package day2;

public class Child extends Parent {
	Child(){
		this("");
		System.out.println("D.C. of Child is called");
	}
	Child(String name){
		System.out.println("P.C. of Child is called");
	}
}
