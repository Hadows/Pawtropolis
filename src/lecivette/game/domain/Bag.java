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

	public boolean addItem(Item item){
		if(slots>0) {
			slots--;
			return items.add(item);
		}
		else
			return false;
	}

	public boolean removeItems(Item item) {
		if(items.contains(item)){
			slots++;
			return items.remove(item);
		}
		else
			return false;
	}
}
