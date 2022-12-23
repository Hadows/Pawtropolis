package lecivette.animals.domain;

import java.time.LocalDate;

public class Eagle extends Animal {
	private double wingspan;

	public Eagle(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height, double wingspan) {
		super(name, favoriteFood, age, joinDate, weight, height);
		this.wingspan = wingspan;
	}

	public double getWingspan() {
		return wingspan;
	}

	public void setWingspan(double wingspan) {
		this.wingspan = wingspan;
	}
}
