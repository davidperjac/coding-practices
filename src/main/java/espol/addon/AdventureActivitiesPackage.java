package espol.addon;

public class AdventureActivitiesPackage implements Addon {
    private static final double COST_PER_TRAVELER = 150;
    
     @Override
    public double getCost(final int numberOfTravelers) {
        return COST_PER_TRAVELER * numberOfTravelers;
    }
}