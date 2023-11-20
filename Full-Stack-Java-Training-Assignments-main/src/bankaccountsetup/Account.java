package bankaccountsetup;

public abstract class Account implements IRate {

	private String name;
	private String ssN;
	private String accountType;
	static int index = 10000;
	private double balance;
	String accountNumber;
	double rate;

	public Account(String name, String ssN, double initDeposit) {

		this.name = name;
		this.ssN = ssN;
		balance = initDeposit;
		index++;
		this.accountNumber = setAccNumber();
		
		setRate();
	}
	
	public abstract void setRate();
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("total deposited amount: "+balance);
		printBalance();
	}
	
	public void withdrawal(double amount) {
		balance = balance - amount;
		System.out.println("total withdrawal amount: "+balance);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance= balance-amount;
		System.out.println("transfering "+amount+ "to"+ balance);
		printBalance();
	}
	
	public void compound() {
		double accruedbalance = balance * (rate/100);
		balance = balance + accruedbalance;
		
		System.out.println("accruedbalance"+ accruedbalance);
		printBalance();
	}
	
	
	public void printBalance() {
		System.out.println("your balance is now : "+ balance);
	}

	private String setAccNumber() {
		String lastTwoSsn = ssN.substring((ssN.length() - 2), ssN.length());
		int random = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoSsn+ index + random;
	}

	
	public void showInfo() {
		
		System.out.println("Account Name :"+ name +"balance :"+balance
				);
		
	}


	
//	deposit();
//	withdraw();
//	transfer();
//	showinfo();
}
