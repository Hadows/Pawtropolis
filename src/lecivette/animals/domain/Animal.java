package lecivette.animals.domain;

import java.time.LocalDate;

public abstract class Animal {
	private String name;
	private String favoriteFood;
	private int age;

	public Animal(String name, String favoriteFood, int age, LocalDate joinDate, double weight, double height) {
		this.name = name;
		this.favoriteFood = favoriteFood;
		this.age = age;
		this.joinDate = joinDate;
		this.weight = weight;
		this.height = height;
		this.isAlive = true;
	}

	private LocalDate joinDate;
	private double weight;
	private double height;
	private boolean isAlive;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	public void setAlive(boolean isAlive){
		this.isAlive = isAlive;
	}
}
