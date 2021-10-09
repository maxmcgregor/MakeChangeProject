package week1;

import java.util.Scanner;

public class CashRegister {

	static double itemPrice;
	static double amountPaid;
	static double changeNeeded;
	static int billsNeeded;
	static double coinsNeeded;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// add a loop until the user decides to be done. see project with Ian
		boolean customerPresent = true;

		while (customerPresent) {
			changeCalculator();

			if (amountPaid == itemPrice) {

				System.out.println("\nThat's exact change. Thank you, have a nice day!");

			} else if (amountPaid < itemPrice) {

				double amountOwed = itemPrice - amountPaid;
				System.err.println("Your item costs $" + amountOwed + " more than you paid. Please pay an additional $"
						+ amountOwed + ".");

			} else {

				System.out.println("\nChange of $" + changeNeeded + " to be given as follows: \n");
				billCalculator();
				coinsCalculator();

			}
			System.out.print("Cashier, is there another customer present? Y/N ");
			String anotherCustomer = scanner.nextLine();
			System.out.println();

			if (anotherCustomer.equals("Y") || anotherCustomer.equals("Yes") || anotherCustomer.equals("y")
					|| anotherCustomer.equals("yes")) {
				customerPresent = true;
			} else if (anotherCustomer.equals("N") || anotherCustomer.equals("n") || anotherCustomer.equals("No")
					|| anotherCustomer.equals("no")) {
				customerPresent = false;
				System.out.println("Got it. Enjoy your down time. ");
			} else {
				System.err.println("Not a valid response.");
			}
		}
	}

	public static void changeCalculator() {
		System.out.print("Cashier, what is the price of the item? ");
		itemPrice = scanner.nextDouble();

		System.out.print("Cashier, how much money was tendered by the customer? ");
		amountPaid = scanner.nextDouble();
		scanner.nextLine();

		changeNeeded = amountPaid - itemPrice;
		billsNeeded = (int) (changeNeeded);
		coinsNeeded = changeNeeded - billsNeeded;

	}

	// use parameters int bill, int denomination then call billCalculator 4 times in
	// main. same
	public static void billCalculator() {
		// feel like this could be a method that passes bill type & denomination
		// (twenties/20, tens/10, etc)
		int twenties = billsNeeded / 20;
		if (twenties != 0) {
			billsNeeded -= (twenties * 20);
			System.out.println("Twenties: " + twenties);
		}

		int tens = billsNeeded / 10;
		if (tens != 0) {
			billsNeeded -= (tens * 10);
			System.out.println("Tens: " + tens);
		}

		int fives = billsNeeded / 5;
		if (fives != 0) {
			billsNeeded -= (fives * 5);
			System.out.println("Fives: " + fives);
		}

		int ones = billsNeeded / 1;
		if (ones != 0) {
			billsNeeded -= (ones);
			System.out.println("Ones: " + ones);
		}

	}

	public static void coinsCalculator() {

		int quarters = (int) (coinsNeeded / 0.25);
		if (quarters != 0) {
			coinsNeeded -= (quarters * 0.25);
			System.out.println("Quarters: " + quarters);
		}

		int dimes = (int) (coinsNeeded / 0.1);
		if (dimes != 0) {
			coinsNeeded -= (dimes * 0.1);
			System.out.println("Dimes: " + dimes);
		}

		int nickels = (int) (coinsNeeded / 0.05);
		if (nickels != 0) {
			coinsNeeded -= (nickels * .05);
			System.out.println("Nickels: " + nickels);
		}

		int pennies = (int) (coinsNeeded / 0.01);
		if (pennies != 0) {
			System.out.println("Pennies: " + pennies);
		}
		System.out.println();

	}
}
