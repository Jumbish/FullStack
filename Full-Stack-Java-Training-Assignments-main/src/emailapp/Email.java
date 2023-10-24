package emailapp;

public class Email {

	private String firstName;
	private String lastName;
	private String department;
	private String password;
	private int defaultMailBox = 500;
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getMailCapacity() {
		return mailCapacity;
	}


	public void setMailCapacity(int mailCapacity) {
		this.mailCapacity = mailCapacity;
	}


	public String getAlternativeEmail() {
		return alternativeEmail;
	}


	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}


	private int mailCapacity;
	private String alternativeEmail;
	
	
	public Email(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	
	
	
	
	
	
	

}
