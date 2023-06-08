package espol.addon;

public class SpaAndWellnessPackage implements Addon {
    private static final double COST_PER_TRAVELER = 100;

    @Override
    public double getCost(final int numberOfTravelers) {
        return COST_PER_TRAVELER * numberOfTravelers;
    }
}