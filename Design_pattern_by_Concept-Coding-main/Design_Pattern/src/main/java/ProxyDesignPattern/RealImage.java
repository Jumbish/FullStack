package ProxyDesignPattern;

public class RealImage implements Image {
	
	private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }
    
    private void loadImageFromDisk() {
        System.out.println("Loading image: " + filename);
    }

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Displaying image: " + filename);
	}

}
