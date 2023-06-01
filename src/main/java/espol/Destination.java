package espol;

public class Destination {
	private String name;

	public Destination(String name) {
		this.name = name;
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
