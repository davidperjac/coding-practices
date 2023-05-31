package espol;

import java.util.Scanner;

import exceptions.NumbersOfTravelersExceeded;

public final class Main {
    final static Scanner sc = new Scanner(System.in);

    public static void main(final String... args)
            throws NumbersOfTravelersExceeded {
        final int    numTravelers    = askInt(
                "Enter the number of travelers: ");
        final String destinationName = askString("Enter the destination: ");
        final int    duration        = askInt("Enter duration (in days): ");

        // FIXME: invoke destination correctly
        final VacationPackage vacationPackage = new VacationPackage(
                numTravelers, null, duration);
        // vacationPackage.calculateCost();

        // handle 80 travelers limit using created Exception
        // handle the -1 input thing
        // ensure accurate data (regex?)

    }

    private static String askString(final String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private static int askInt(final String prompt) {
        return Integer.parseInt(askString(prompt));
    }
}