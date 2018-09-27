
/*
 * This code is functional, but does not implement any try/catch blocks,
 * */

import java.util.Scanner;

public class InterestCalculator {

	static Scanner input = new Scanner(System.in);

	public static void greeting() {
		System.out.println("Hello there, I am your annual interest calculator.");
	}

	public static float baseBalance() {
		float baseBalance;
		System.out.println("\nHow much money do you currently have in your account?");
		baseBalance = input.nextFloat();
		input.nextLine();
		return baseBalance;
	}

	public static int numberOfYears() {
		int years;
		System.out.println("\nHow many years would you like to run this simulation for?");
		years = input.nextInt();
		input.nextLine();
		return years;
	}

	public static float interestRate() {
		System.out.println("\nWhat's your annual interest rate?");
		float interest;
		interest = input.nextFloat();
		input.nextLine();
		System.out.println("Your chosen interest rate is: " + interest);
		return interest;
	}

	public static int fixedOrVariable() {
		int indicator;
		String type = null;
		System.out.println("\nAre you depositing a fixed amount or a variable amount every month?");
		System.out.println("Type '1' for fixed or '2' for variable: ");
		indicator = input.nextInt();
		input.nextLine();
		if (indicator == 1) {
			type = "fixed";
		}
		if (indicator == 2) {
			type = "variable";
		}

		System.out.println("You entered " + indicator + " so your deposit is " + type);
		return indicator;
	}

	public static float[] fixedMonthlyDeposit(int years) {
		float fixedDeposit[] = new float[years];
		for (int i = 0; i < years; i++) {
			System.out.println("\nHow much money are you depositing monthly for year " + (i + 1));
			fixedDeposit[i] = input.nextFloat();
			input.nextLine();
		}
		System.out.println("\nCalculating..");
		return fixedDeposit;
	}

	public static float[] variableMonthlyDeposit(int years) {
		float[] variableMonthlyDeposit = new float[12 * years];
		for (int i = 1; i <= years; i++) {
			for (int i1 = 1; i1 <= 12; i1++) {
				System.out.println("For month: " + i1 + " and year: " + i + " how much money are you depositing?");
				variableMonthlyDeposit[(i * i1) - 1] = input.nextInt();
				input.nextLine();
				System.out.println("You are depositing " + variableMonthlyDeposit[(i * i1) - 1] + " for the month " + i1
						+ " and year: " + i + "\n");
			}
		}
		return variableMonthlyDeposit;
	}

	public static float annualInterestFixedIncome(float interest, float[] fixedDeposit, float baseBalance, int years) {
		float newBalance = baseBalance;
		float annualInterestIncome = 0;
		float totalBalance = 0;
		float totalMonthlyBalance = 0;
		float monthlyInterest;

		int counter = 0;
		float[] totalMonthlyBalanceArray = new float[years * 12];
		float[] accruedInterestIncomeArray = new float[years * 12];
		float[] monthlyInterestArray = new float[years * 12];

		for (int i = 1; i <= years; i++) {
			for (int deposit = 1; deposit < 13; deposit++) {
				newBalance += fixedDeposit[i - 1];
				totalBalance = newBalance + annualInterestIncome;
				monthlyInterest = ((totalBalance) * interest / 12);
				annualInterestIncome += monthlyInterest;
				totalMonthlyBalance = newBalance + annualInterestIncome;

				totalMonthlyBalanceArray[counter] = totalMonthlyBalance;
				accruedInterestIncomeArray[counter] = annualInterestIncome;
				monthlyInterestArray[counter] = monthlyInterest;

				System.out.println(
						"\nYour total balance for month: " + deposit + " is: " + totalMonthlyBalanceArray[counter]);
				System.out.println("Your monthly paid interest amounts to: " + monthlyInterestArray[counter]);
				System.out.println("Your accrued interest is " + accruedInterestIncomeArray[counter]);
				counter++;
			}
			System.out.println("\nYour annual interest accrued up to year " + i + " will be: " + annualInterestIncome);
			System.out.println("Your annual balance accrued up to year " + i + " will be: " + totalMonthlyBalance);
			System.out.println("");
		}
		return totalMonthlyBalance;
	}

	public static float annualInterestVariableIncome(float interest, float[] variableDeposit, float baseBalance,
			int years) {
		float newBalance = baseBalance;
		float annualInterestIncome = 0;
		float totalBalance;
		float totalMonthlyBalance = 0;
		float monthlyInterest;

		int counter = 0;
		float[] totalMonthlyBalanceArray = new float[years * 12];
		float[] accruedInterestIncomeArray = new float[years * 12];
		float[] monthlyInterestArray = new float[years * 12];

		for (int i = 1; i <= years; i++) {
			for (int deposit = 1; deposit < 13; deposit++) {
				newBalance += variableDeposit[((i - 1) * 12) + (deposit - 1)];
				totalBalance = newBalance + annualInterestIncome;
				monthlyInterest = ((totalBalance) * interest / 12);
				annualInterestIncome += monthlyInterest;
				totalMonthlyBalance = newBalance + annualInterestIncome;

				totalMonthlyBalanceArray[counter] = totalMonthlyBalance;
				accruedInterestIncomeArray[counter] = annualInterestIncome;
				monthlyInterestArray[counter] = monthlyInterest;

				System.out.println(
						"\nYour total balance for month: " + deposit + " is: " + totalMonthlyBalanceArray[counter]);
				System.out.println("Your monthly paid interest amounts to: " + monthlyInterestArray[counter]);
				System.out.println("Your accrued interest is " + accruedInterestIncomeArray[counter]);
				counter++;
			}
			System.out.println("\nYour annual interest accrued up to year " + i + " will be: " + annualInterestIncome);
			System.out.println("Your annual balance accrued up to year " + i + " will be: " + totalMonthlyBalance);
			System.out.println("");
		}
		return totalMonthlyBalance;
	}

	public static int continueRunning() {
		int indicator;
		System.out.println("Do you want to continue running the program?");
		System.out.println("Type in '1' for yes and '2' for no. ");
		indicator = input.nextInt();
		input.nextLine();
		return indicator;
	}

	public static int startOver() {
		int startOver;
		System.out.println("Do you want to start over, (Deletes existing data) or "
				+ "continue where you left off? (Keeps existing data)");
		System.out.println("Type '1' to start over or '2'' to continue where you left off:");
		startOver = input.nextInt();
		input.nextLine();
		System.out.print("You chose to ");
		if (startOver == 1) {
			System.out.println("start over.\n");
		}
		if (startOver == 2) {
			System.out.println("continue where you left off.\n");
		}
		return startOver;
	}

	public static float resetData() {
		float baseBalance;
		greeting();
		baseBalance = baseBalance();
		return baseBalance;
	}

	public static void main(String[] args) {
		float interest = 0;
		float baseBalance = 0;
		int continueRunning;
		int startOver = 0;
		int indicator = 0;
		int years = 0;

		do {

			if (startOver != 2) {
				baseBalance = resetData();
			}
			else if (startOver == 2) {
				System.out.println("From your previous run of this program. Your total balance was left at:");
				System.out.println(baseBalance + "\n");
			}
			interest = interestRate();
			indicator = fixedOrVariable();
			years = numberOfYears();

			if (indicator == 1) {
				float fixedDeposit[] = fixedMonthlyDeposit(years);
				baseBalance = annualInterestFixedIncome(interest, fixedDeposit, baseBalance, years);
			} else if (indicator == 2) {
				float variableMonthlyDeposit[] = variableMonthlyDeposit(years);
				baseBalance = annualInterestVariableIncome(interest, variableMonthlyDeposit, baseBalance, years);
			}
			continueRunning = continueRunning();
			if (continueRunning == 1) {
				startOver = startOver();
			}
			else {
				System.out.println("Thank you and goodbye!");
			}
		} while (continueRunning == 1);
	}

}
