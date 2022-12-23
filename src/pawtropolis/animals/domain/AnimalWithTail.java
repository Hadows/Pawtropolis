package pawtropolis.animals.domain;

import java.time.LocalDate;

public abstract class AnimalWithTail extends Animal{
	private double tailLength;

	public AnimalWithTail(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height, double tailLength) {
		super(name, favoriteFood, age, joinDate, weight, height);
		this.tailLength = tailLength;
	}

	public double getTailLength() {
		return tailLength;
	}

	public void setTailLength(double tailLength) {
		this.tailLength = tailLength;
	}
}
