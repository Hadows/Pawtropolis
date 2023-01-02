package pawtropolis.game.domain;

import java.util.List;

public class Bag {
	private List<Item> items;
	private int slots;

	public Bag(List<Item> items, int slots){
		this.items = items;
		this.slots = slots;
	}

	public List<Item> getItems() {
		return items;
	}

	public int getSlots() {
		return slots;
	}
	public void addItem(Item item){
		items.add(item);
	}

	public void removeItems(Item item) {
		items.remove(item);
	}
}
