package day2;

public class Parent {
	Parent(){
		this("");
		System.out.println("D.C. of Parent is called");
	}
	Parent(String name){
		System.out.println("P.C. of Parent is called" + name);
	}
}
