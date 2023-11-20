package bankaccountsetup;

public interface IRate {
	
//	public double savingIRate();
//	public double checkingIRate();
	
	default double getBaseRate() {
		return 2.5;	
	}

}
