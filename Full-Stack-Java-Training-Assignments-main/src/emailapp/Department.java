package emailapp;

public enum Department {
	
	SALES("sales"),
	DEVELOPMENT("development"),
	ACCOUNTING("accounting");
	
	private String department;

    Department(String department) {
        this.department = department;
    } 

}
