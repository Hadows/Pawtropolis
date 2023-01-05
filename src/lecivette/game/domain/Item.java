package lecivette.game.domain;

public class Item {
	private String name;
	private String description;
	private int requestSlot;
	public Item(String name, String description, int requestSlot){
		this.name = name;
		this.description = description;
		this.requestSlot = requestSlot;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getRequestSlot() {
		return requestSlot;
	}

	@Override
	public String toString() {
		return name;
	}
}
