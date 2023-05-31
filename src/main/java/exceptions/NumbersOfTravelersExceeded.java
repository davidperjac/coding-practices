/*
 * Copyright (C) 2023, Juan Antonio González, Washington Cotera, David Pérez, Fernando Buchelli
 */

package exceptions;

/**
 * Constructs a new NumbersOfTravelersExceeded exception with the specified detail message.
 *
 * @param message the detail message
 */
public final class NumbersOfTravelersExceeded extends Exception {
	public NumbersOfTravelersExceeded(String message) {
		super(message);
	}
}