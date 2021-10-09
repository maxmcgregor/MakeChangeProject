package com.skilldistillery.app;

import java.util.Scanner;

public class MakeChange {

	static int itemPrice;
	static int amountPaid;
	static int changeNeeded;
	static int billsNeeded;
	static int coinsNeeded;
	static boolean customerPresent = true;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (customerPresent) {

			changeCalculator();

			transaction();
			
			if (customerPresent) {
				customerPresent();				
			}
		}

		scanner.close();
	}

	public static void changeCalculator() {
		System.out.print("Cashier, what is the price of the item? ");
		itemPrice = (int) (100 * scanner.nextDouble());

		System.out.print("Cashier, how much money was tendered by the customer? ");
		amountPaid = (int) (100 * scanner.nextDouble());
		scanner.nextLine();

		changeNeeded = amountPaid - itemPrice;
		billsNeeded = changeNeeded / 100;
		coinsNeeded = changeNeeded - (billsNeeded * 100);

	}

	public static void transaction() {
		if (amountPaid == itemPrice) {

			System.out.println("\nThat's exact change. Thank you, have a nice day!");

		} else if (amountPaid < itemPrice) {

			double amountOwed = itemPrice - amountPaid;
			System.err.println("\nYour item costs more than you paid. Please pay the difference.\n");
			customerPresent = false;

		} else {

			billCalculator();
			coinsCalculator();

		}
	}

	public static void billCalculator() {
		// feel like this could be a method that passes bill type & denomination
		// (twenties/20, tens/10, etc) but had trouble figuring it out cleanly
		System.out.println("\nChange to be given as follows: \n");

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

		int quarters = (coinsNeeded / 25);
		if (quarters != 0) {
			coinsNeeded -= (quarters * 25);
			System.out.println("Quarters: " + quarters);
		}

		int dimes = (coinsNeeded / 10);
		if (dimes != 0) {
			coinsNeeded -= (dimes * 10);
			System.out.println("Dimes: " + dimes);
		}

		int nickels = (coinsNeeded / 5);
		if (nickels != 0) {
			coinsNeeded -= (nickels * 5);
			System.out.println("Nickels: " + nickels);
		}

		int pennies = (coinsNeeded / 1);
		if (pennies != 0) {
			System.out.println("Pennies: " + pennies);
		}
		System.out.println();

	}

	public static void customerPresent() {
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
			System.err.println("Not a valid response. Assuming no one is there. Goodbye.");
			customerPresent = false;
		}
	}
}
