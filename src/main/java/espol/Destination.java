package espol;

public class Destination {
	private String name;
	private int popularity;
	private int additionalCost;

	public Destination(String name, int popularity, int additionalCost) {
		this.name = name;
		this.popularity = popularity;
		this.additionalCost = additionalCost;
	}

	public double calculateAddtionalCost() {
		double cost = 0;

		switch (name.toLowerCase()) {
		case "paris":
			return 500;
		case "new york city":
			return 600;

		default:
			return cost;
		}
	}
	
}
