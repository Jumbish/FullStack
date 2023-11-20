package bankaccountsetup;

public class Saving extends Account {
	
	int safteyDepositBoxId;
	int safteyDepositBoxKey;

	public Saving(String name, String ssN, double i) {
		super(name, ssN, i);
		accountNumber= "1"+accountNumber;
		setsafteyDepositBox();
	}
	
	private void setsafteyDepositBox() {
		// TODO Auto-generated method stub
		
		safteyDepositBoxId = (int) (Math.random()* Math.pow(10, 3));
		safteyDepositBoxKey = (int) (Math.random()* Math.pow(10, 4));
//		System.out.println("safteyDepositBoxId"+safteyDepositBoxId);
		
		
	}

	public void showInfo() {
		super.showInfo();
		System.out.println("saving");
		System.out.println("safteyDepositBoxId "+safteyDepositBoxId);
		System.out.println("safteyDepositBoxKey "+safteyDepositBoxKey);
		System.out.println("rate"+rate);
		
	}

	@Override
	public void setRate() {
		// TODO Auto-generated method stub
		rate = getBaseRate() - .25;
	}

}
