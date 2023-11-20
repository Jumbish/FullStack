package bankaccountsetup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Checking checking1 = new Checking("jumbish", "123456789", 1500);
//		Saving saving = new Saving("Akshay", "123456789", 1500);
		List<String[]> data = readCSV();
		Saving saving = null;
		Checking checking = null;
		for(String[] acc: data) {
			
			if(acc[2].equals("Savings")){
				saving = new Saving(acc[0], acc[1], Integer.parseInt(acc[3]));
				System.out.println("Open a Saving account");
				saving.showInfo();
			}else {
				checking = new Checking(acc[0], acc[1], Integer.parseInt(acc[3]));
				System.out.println("open a checking account");
				checking.showInfo();
			}

			
		}
		
//		saving.deposit(5000);
//		saving.withdrawal(200);
//		saving.transfer("br", 3213);
//		
//		saving.compound();
	}
	
	
	
	public static List<String[]> readCSV() {
		
		List<String[]> data = new LinkedList<String[]>();
		String csvFile = "NewBankAccounts.csv";
		try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){
			
			String line;
			while((line = br.readLine())!=null) {
//				System.out.println("--");
				String[] values = line.split(",");
				data.add(values);
				
			
				//for (int i = 0; i < data.size(); i++) {
//					System.out.println(data.toString());
				//}
//				for (int i = 0; i < values.length; i++) {
//					String column1 = values[i];
//					System.out.println("Coulmn "+ column1);
//				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
			
				
	}

}
