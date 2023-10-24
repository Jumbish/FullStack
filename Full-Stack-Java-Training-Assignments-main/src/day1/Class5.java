package day1;

public class Class5 {
	public Class5() {
		this(1);
		System.out.println();
	}

	public Class5(int i) {
		this("one");
		System.out.println(i);
	}

	public Class5(String s) {
		this(true);
		System.out.println(s);
	}

	public Class5(boolean b) {
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		Class5 c = new Class5();
		System.out.println(c);
	}
}
