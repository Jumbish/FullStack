package bankaccountsetup;

public class Checking extends Account{
	
	
	int debitCardNumber;
	int debitCardPin;
	public Checking(String name, String ssN, double iniDeposit){
		super(name, ssN, iniDeposit);
		accountNumber= "2"+accountNumber;
		setDebitCardNumber();
//		System.out.println(": accountNumber"+ accountNumber);
	}
	
	private void setDebitCardNumber() {
		// TODO Auto-generated method stub
		debitCardNumber = (int) (Math.random()* Math.pow(10, 12));
		debitCardPin = (int) (Math.random()* Math.pow(10, 4));
		
	}

	public void showInfo() {
		super.showInfo();
		System.out.println("checking");
		System.out.println("debitCardPin"+debitCardNumber);
		System.out.println("debitCardPin"+debitCardPin);
		System.out.println("rate"+rate);
	}

	@Override
	public void setRate() {
		// TODO Auto-generated method stub
		rate = getBaseRate() * .15;
	}

}
