package espol;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String destination;
		do {
			System.out.println("Enter the destination place: ");
			destination = scanner.nextLine();
		} while (!validDestination(destination));

		String numberOfTravelers;
		do {
			System.out.println("Enter the number of Travelers: ");
			numberOfTravelers = scanner.nextLine();
		} while (!validNumberOfTravelers(numberOfTravelers));

		String durationInDays;
		do {
			System.out.println("Enter the duration in days: ");
			durationInDays = scanner.nextLine();
		} while (!validNumber(durationInDays, "days"));

		Destination destinationObj = new Destination(destination);
		VacationPackage vacationPackage = new VacationPackage(Integer.parseInt(numberOfTravelers), destinationObj,
				Integer.parseInt(durationInDays));

		double cost = vacationPackage.calculateCost();
		System.out.println("==================================\n" + "The cost of the vacation package is: $" + cost
				+ "\n==================================");
		scanner.close();
	}

	public static boolean validNumber(String number, String variable) {
	    if (!number.isEmpty() && number.matches("\\d+") && !number.contains(".")) {
	        if (Integer.parseInt(number) <= 0) {
	            System.out.println("==================\n" + "The number of " + variable
	                    + " must be greater than zero" + "\n==================");
	            return false;
	        } else {
	            return true;
	        }
	    } else {
	        System.out.println("==================\n" + "The input is not valid" + "\n==================");
	        return false;
	    }
	}


	public static boolean validNumberOfTravelers(String numberOfTravelers) {
		if (validNumber(numberOfTravelers, "travelers")) {
			if (Integer.parseInt(numberOfTravelers) > 80) {
				System.out.println("==================\n" + "The vacation package is not available "
						+ "for groups of more than 80 people" + "\n==================");
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	public static boolean validDestination(String destination) {
		if (destination.isEmpty() || !destination.matches(".*\\w.*")) {
			System.out.println("==================\n" + "The destination is not valid\n" + "==================");
			return false;
		} else {
			return true;
		}
	}
}