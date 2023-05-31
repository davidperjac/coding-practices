import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Vacation Package Calculator!");

        System.out.print("Enter the destination of the vacation (Paris, New York City): ");
        String destination = scanner.nextLine();

        System.out.print("Enter the number of travelers: ");
        int numTravelers = scanner.nextInt();

        System.out.print("Enter the duration of the vacation in days: ");
        int duration = scanner.nextInt();

        // Validate input
        if (!isValidInput(destination, numTravelers, duration)) {
            System.out.println("Invalid input!");
            System.out.println("Please make sure you entered a valid destination, number of travelers, and duration.");
            System.out.println("Destination should be either Paris or New York City.");
            System.out.println("Number of travelers should be between 1 and 80.");
            System.out.println("Duration should be a positive integer.");
            System.exit(0);
        }

        // Calculate base cost
        int baseCost = 1000;

        // Add additional cost based on the destination
        int additionalCost = 0;
        if (destination.equalsIgnoreCase("Paris")) {
            additionalCost = 500;
        } else if (destination.equalsIgnoreCase("New York City")) {
            additionalCost = 600;
        }

        // Calculate total cost
        int totalCost = baseCost + additionalCost;

        // Apply group discount
        double groupDiscount = 0;
        if (numTravelers > 4 && numTravelers <= 10) {
            groupDiscount = 0.1;
        } else if (numTravelers > 10) {
            groupDiscount = 0.2;
        }
        totalCost -= totalCost * groupDiscount;

        // Apply penalty fee for duration less than 7 days
        if (duration < 7) {
            totalCost += 200;
        }

        // Apply promotion policy
        if (duration > 30 || numTravelers == 2) {
            totalCost -= 200;
        }

        System.out.println("The total cost of the vacation package is: $" + totalCost);
    }

    private static boolean isValidInput(String destination, int numTravelers, int duration) {
        return (destination.equalsIgnoreCase("Paris") || destination.equalsIgnoreCase("New York City")) &&
                numTravelers > 0 && numTravelers <= 80 && duration > 0;
    }
}
