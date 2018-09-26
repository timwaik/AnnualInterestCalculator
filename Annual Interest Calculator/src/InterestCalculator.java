/*
 * This code is functional, but does not implement any try/catch blocks,
 * Any code that has been commented out is unnecessary, but may be implemented 
 * in the future.
 * */

import java.util.Scanner;

public class InterestCalculator {

	static Scanner input = new Scanner(System.in);

	public static void greeting() {
		System.out.println("Hello there, I am your annual interest calculator.");
	}

	public static float baseBalance() {
		float baseBalance;
		System.out.println("How much money do you currently have in your account?");
		baseBalance = input.nextFloat();
		input.nextLine();
		return baseBalance;
	}

	public static int numberOfYears() {
		int years;
		System.out.println("How many years would you like to run this simulation for?");
		years = input.nextInt();
		input.nextLine();
		return years;
	}

	/*public static float totalBalance() {
		float totalBalance = 0;
		System.out.println("Your total cash now amounts to: " + totalBalance);
		return totalBalance;
	}*/

	public static float interestRate() {
		System.out.println("What's your annual interest rate?");
		float interest;
		interest = input.nextFloat();
		input.nextLine();
		System.out.println("Your chosen interest rate is: " + interest);
		return interest;
	}

	public static int fixedOrVariable() {
		int indicator;
		String type = null;
		System.out.println("Are you depositing a fixed amount or a variable amount every month?");
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
			System.out.println("How much money are you depositing monthly for year " + (i+1));
			fixedDeposit[i] = input.nextFloat();
			input.nextLine();
		}
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

	public static void annualInterestFixedIncome(float interest, float[] fixedDeposit, float baseBalance, int years) {
		float newBalance = baseBalance;
		float annualInterestIncome = 0;
		float totalBalance = 0;
		float totalMonthlyBalance = 0;
		float monthlyInterest;
		
		int counter = 0;
		float[] totalMonthlyBalanceArray = new float[years*12];
		float[] accruedInterestIncomeArray = new float[years*12];
		float[] monthlyInterestArray = new float[years*12];
		
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
				
				System.out.println("\nYour total balance for month: " + deposit + " is: " + totalMonthlyBalanceArray[counter]);
				System.out.println("Your monthly paid interest amounts to: " + monthlyInterestArray[counter]);
				System.out.println("Your accrued interest is " + accruedInterestIncomeArray[counter]);
				counter++;
			}
			System.out.println("Your annual interest accrued for the year " + i + " will be: " + annualInterestIncome);
			System.out.println("Your annual balance accrued for the year " + i + " will be: " + totalMonthlyBalance);
			System.out.println("");
		}
		/*
		 * ***THIS COMMENTED OUT SECTION DETAILS ANOTHER METHOD TO DISPLAY THE ABOVE DATA.
		 * IT IS COMMENTED OUT AS IT IS VISUALLY UNAPPEALING.LOOKING FOR BETTER METHODS OF
		 * DISPLAYING DATA.***
		 *
		 * ***
		 * System.out.println("\nYour total balance at the end of each month is:-");
		System.out.println(Arrays.toString(totalMonthlyBalanceArray));
		System.out.println("Your total paid interest every month is:- ");
		System.out.println(Arrays.toString(monthlyInterestArray));
		System.out.println("Your total accrued interest each month is:- ");
		System.out.println(Arrays.toString(accruedInterestIncomeArray));
		***
		**/

	}

	public static void annualInterestVariableIncome(float interest, float[] variableDeposit, float baseBalance,
			int years) {
		float newBalance = baseBalance;
		float annualInterestIncome = 0;
		float totalBalance;
		float totalMonthlyBalance = 0;
		float monthlyInterest;
		
		int counter = 0;
		float[] totalMonthlyBalanceArray = new float[years*12];
		float[] accruedInterestIncomeArray = new float[years*12];
		float[] monthlyInterestArray = new float[years*12];
		
		for (int i = 1; i <= years; i++) {
			for (int deposit = 1; deposit < 13; deposit++) {
				newBalance += variableDeposit[((i-1)*12) + (deposit - 1)];
				totalBalance = newBalance + annualInterestIncome;
				monthlyInterest = ((totalBalance) * interest / 12);
				annualInterestIncome += monthlyInterest;
				totalMonthlyBalance = newBalance + annualInterestIncome;
				
				totalMonthlyBalanceArray[counter] = totalMonthlyBalance;
				accruedInterestIncomeArray[counter] = annualInterestIncome;
				monthlyInterestArray[counter] = monthlyInterest;
				
				System.out.println("\nYour total balance for month: " + deposit + " is: " + totalMonthlyBalanceArray[counter]);
				System.out.println("Your monthly paid interest amounts to: " + monthlyInterestArray[counter]);
				System.out.println("Your accrued interest is " + accruedInterestIncomeArray[counter]);
				counter++;
			}			
			System.out.println("\nYour annual interest accrued for the year " + i + " will be: " + annualInterestIncome);
			System.out.println("Your annual balance accrued for the year " + i + " will be: " + totalMonthlyBalance);
			System.out.println("");
		}
	}

	/*public static int continueRunning() {
		int indicator;
		System.out.println("Do you want to continue running the program?");
		System.out.println("Type in '1' for yes and '2' for no. ");
		indicator = input.nextInt();
		input.nextLine();
		return indicator;
	}*/

	public static void main(String[] args) {
		float interest;
		float baseBalance;
		//float totalBalance;
		//int continueRunning;
		int indicator;
		int years;
		greeting();
		baseBalance = baseBalance();
		//do {
			//totalBalance = totalBalance();
			years = numberOfYears();
			interest = interestRate();
			indicator = fixedOrVariable();
			if (indicator == 1) {
				float fixedDeposit[] = fixedMonthlyDeposit(years);
				annualInterestFixedIncome(interest, fixedDeposit, baseBalance, years);
			} else if (indicator == 2) {
				float variableMonthlyDeposit[] = variableMonthlyDeposit(years);
				annualInterestVariableIncome(interest, variableMonthlyDeposit, baseBalance, years);
			}
			//continueRunning = continueRunning();
		//} while (continueRunning == 1);
	}

}
