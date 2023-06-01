/*
 * Copyright (C) 2023, Juan Antonio González, Washington Cotera, David Pérez, Fernando Buchelli
 */

package espol;

public final class VacationPackage {
	private int numberOfTravelers;
	private Destination destination;
	private int durationInDays;

	private final int BASE_COST = 1000;

	/**
	 * Constructs a new VacationPackage with the specified number of travelers,
	 * destination, and duration.
	 *
	 * @param travelers   the number of travelers
	 * @param destination the destination of the vacation
	 * @param duration    the duration of the vacation in days
	 */
	public VacationPackage(final int travelers, final Destination destination, final int duration) {
		this.numberOfTravelers = travelers;
		this.destination = destination;
		this.durationInDays = duration;
	}

	/**
	 * Calculates the total cost of the vacation package.
	 *
	 * @return the total cost
	 */
	public final double calculateCost() {
		double totalCost = this.BASE_COST;

		totalCost += destination.calculateAddtionalCost();
		totalCost += calculateGroupDiscount(totalCost);
		totalCost += calculatePenaltyFee();
		totalCost -= calculatePromotionPolicy();

//        if (numberOfTravelers > 80) {
//            throw new NumbersOfTravelersExceeded("No se pueden agregar más de 80 personas al paquete de vacaciones.");
//        }

		return totalCost;
	}

	/**
	 * Calculates the group discount based on the number of travelers.
	 *
	 * @param cost the original cost before applying the discount
	 * @return the discount amount
	 */
	private final double calculateGroupDiscount(final double cost) {
		if (numberOfTravelers > 4 && numberOfTravelers < 10) {
			return cost * 0.1;
		} else if (numberOfTravelers > 10) {
			return cost * 0.2;
		}

		return 0;
	}

	/**
	 * Calculates the penalty fee based on the vacation duration.
	 *
	 * @return the penalty fee
	 */
	private final int calculatePenaltyFee() {
		return (durationInDays < 7) ? 200 : 0;
	}

	/**
	 * Calculates the promotion policy based on the vacation duration and number of
	 * travelers.
	 *
	 * @return the promotion amount
	 */
	private final int calculatePromotionPolicy() {
		return (durationInDays > 30 || numberOfTravelers == 2) ? 200 : 0;
	}
}
