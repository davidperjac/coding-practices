package espol;

import java.util.Scanner;

import java.util.List;
import java.util.LinkedList;

import espol.addon.Addon;
import espol.addon.AdventureActivitiesPackage;
import espol.addon.AllInclusivePackage;
import espol.addon.SpaAndWellnessPackage;

public final class MainApp {
	public static void main(String[] args) {

		final Scanner scanner = new Scanner(System.in);

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

		final Destination destinationObj = new Destination(destination);
		final VacationPackage vacationPackage = new VacationPackage(Integer.parseInt(numberOfTravelers), destinationObj,
				Integer.parseInt(durationInDays));
		double cost = vacationPackage.calculateCost();
		System.out.println("==================================\n" + "The cost of the vacation package is: $" + cost
				+ "\n==================================");
		System.out.println("Select add-ons (Enter 'yes' or 'no'):");
		System.out.print("All-Inclusive Package ($200 per traveler): ");
		final boolean allInclusive = "yes".equalsIgnoreCase(scanner.nextLine());
		System.out.print("Adventure Activities Package ($150 per traveler): ");
		final boolean adventure = "yes".equalsIgnoreCase(scanner.nextLine());
		System.out.print("Spa and Wellness Package ($100 per traveler): ");
		final boolean spa = "yes".equalsIgnoreCase(scanner.nextLine());

		if (allInclusive) {
			vacationPackage.addAddon(new AllInclusivePackage());
		}
		if (adventure) {
			vacationPackage.addAddon(new AdventureActivitiesPackage());
		}
		if (spa) {
			vacationPackage.addAddon(new SpaAndWellnessPackage());
		}

		cost = vacationPackage.calculateCost();
		System.out.println("==================================\n" + "The cost of the vacation package is: $" + cost
				+ "\n==================================");
		scanner.close();
	}

	public static boolean validNumber(final String number, final String variable) {
		if (!number.isEmpty() && number.matches("\\d+") && !number.contains(".")) {
			if (Integer.parseInt(number) <= 0) {
				System.out.println("==================\n" + "The number of " + variable + " must be greater than zero"
						+ "\n==================");
				return false;
			} else {
				return true;
			}
		} else {
			System.out.println("==================\n" + "The input is not valid" + "\n==================");
			return false;
		}
	}

	public static boolean validNumberOfTravelers(final String numberOfTravelers) {
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

	public static boolean validDestination(final String destination) {
		if (destination.isEmpty() || !destination.matches(".*\\w.*")) {
			System.out.println("==================\n" + "The destination is not valid\n" + "==================");
			return false;
		} else {
			return true;
		}
	}
}