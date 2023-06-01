package espol;

import java.util.Scanner;

import exceptions.NumbersOfTravelersExceeded;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el destino de la vacación: ");
        String destination = scanner.nextLine();

        System.out.println("Introduce el número de viajeros: ");
        int numberOfTravelers = scanner.nextInt();

        System.out.println("Introduce la duración de la vacación en días: ");
        int durationInDays = scanner.nextInt();

        try {
            Destination destinationObj = new Destination(destination);

            VacationPackage vacationPackage = new VacationPackage(numberOfTravelers, destinationObj, durationInDays);

            double cost = vacationPackage.calculateCost();
            System.out.println("El costo del paquete de vacaciones es: $" + cost);
        } catch (NumbersOfTravelersExceeded e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al calcular el costo del paquete de vacaciones. Puede ser un error de entrada.");
        }
    }

    private static boolean isValidInput(int numberOfTravelers, int durationInDays,  String destinationObj) {
        if (numberOfTravelers <= 0 || durationInDays <= 0) {
            return false;
        }

        if (destinationObj == null) {
            return false;
        }

        return true;
    }
}