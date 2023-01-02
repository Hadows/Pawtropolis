package lecivette.game.domain;

public class Player {
	private final String name;
	private int lifePoints;

	private Bag bag;

	public Player(String name, int lifePoints, Bag bag){
		this.name = name;
		this.lifePoints = lifePoints;
		this.bag = bag;
	}

	public String getName() {
		return name;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public Bag getBag() {
		return bag;
	}

	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
}
