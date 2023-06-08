/*
 * Copyright (C) 2023
 * Juan Antonio González, Washington Cotera, David Pérez, Fernando Buchelli
 */

package espol;

import java.util.List;
import java.util.LinkedList;

import espol.addon.Addon;

public final class VacationPackage {
	private final int numberOfTravelers;
	private final Destination destination;
	private final int durationInDays;
	private final List<Addon> addons;

	private final static int BASE_COST = 1000;

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
		
		this.addons = new LinkedList<>();
	}
	
    public void addAddon(final Addon addon) {
        addons.add(addon);
    }

	/**
	 * Calculates the total cost of the vacation package.
	 *
	 * @return the total cost
	 */
	public double calculateCost() {
		double totalCost = BASE_COST;

		totalCost += destination.calculateAddtionalCost();
		totalCost += calculateGroupDiscount(totalCost);
		totalCost += calculatePenaltyFee();
		totalCost -= calculatePromotionPolicy();
		totalCost += calculateAddOnsCost();


		return totalCost;
	}

	/**
	 * Calculates the group discount based on the number of travelers.
	 *
	 * @param cost the original cost before applying the discount
	 * @return the discount amount
	 */
	private double calculateGroupDiscount(final double cost) {
		double result = 0;
		if (numberOfTravelers > 4 && numberOfTravelers < 10) {
			result = cost * 0.1;
		} else if (numberOfTravelers > 10) {
			result = cost * 0.2;
		}

		return result;
	}

	/**
	 * Calculates the penalty fee based on the vacation duration.
	 *
	 * @return the penalty fee
	 */
	private int calculatePenaltyFee() {
		return (durationInDays < 7) ? 200 : 0;
	}

	/**
	 * Calculates the promotion policy based on the vacation duration and number of
	 * travelers.
	 *
	 * @return the promotion amount
	 */
	private int calculatePromotionPolicy() {
		return (durationInDays > 30 || numberOfTravelers == 2) ? 200 : 0;
	}
	
	public double calculateAddOnsCost() {
		double totalCost = 0;
        for (final Addon addon : addons) {
            totalCost += addon.getCost(numberOfTravelers);
        }
        
        return totalCost;
	}
}
