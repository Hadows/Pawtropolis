package lecivette.game.domain;

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

	//TODO: aggiungere controllo sulla numerazione restante di slots in bag
	public boolean addItem(Item item){
		 return items.add(item);
	}

	public boolean removeItems(Item item) {
		return items.remove(item);
	}
}
