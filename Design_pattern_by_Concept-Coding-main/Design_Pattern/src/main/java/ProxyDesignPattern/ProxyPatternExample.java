package ProxyDesignPattern;

public class ProxyPatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Image image = new ProxyImage("example.jpg");
		
		image.display();
		
		image.display();

	}

}
