package testcode;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
	private LocalDate date;
	private double amount;

	// Constructor, getters, and setters
	public Transaction(LocalDate date, double amount) {
		this.date = date;
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getAmount() {
		return amount;
	}
}

public class TransactionsSum {
	public static void main(String[] args) {
		List<Transaction> transactions = List.of(new Transaction(LocalDate.of(2025, 2, 1), 100.0),
				new Transaction(LocalDate.of(2025, 2, 1), 200.0), new Transaction(LocalDate.of(2025, 2, 2), 150.0),
				new Transaction(LocalDate.of(2025, 2, 2), 50.0));

		//		Map<LocalDate, Double> dailySums = transactions.stream()
		//				.collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingDouble(Transaction::getAmount)));

		Map<LocalDate, Double> dailySums = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingDouble(Transaction::getAmount)));
		
		
		dailySums.forEach((date, sum) -> System.out.println("Date: " + date + ", Sum: " + sum));
		//dailySums.forEach((date, sum) -> System.out.println("Date: " + date + ", Sum: " + sum));
	}
}
