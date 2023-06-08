package espol.addon;

public class AllInclusivePackage implements Addon {
    private static final double COST_PER_TRAVELER = 200;

    @Override
    public double getCost(final int numberOfTravelers) {
        return COST_PER_TRAVELER * numberOfTravelers;
    }
}