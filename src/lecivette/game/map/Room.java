package lecivette.game.map;

import lecivette.animals.domain.Animal;
import lecivette.game.domain.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
	private String nameRoom;
	private List<Item> itemList;
	private List<Animal> animalList;
	private Map<Direction, Room> connectedRooms;

	public Room(){
		connectedRooms = new HashMap<>();
	}

	public List<Direction> getDirections(){
		return connectedRooms.keySet().stream().toList();
	}

	public void addRoom(Direction direction, Room room){
		if(connectedRooms.containsKey(direction)){
			System.out.println("Esiste già una stanza in direzione " + direction);
		}
		else{
			connectedRooms.put(direction, room);
		}
	}

	// TODO: Gestire i casi null
	public Room getRoom(String direction){

		Direction roomDirection = Direction.valueOf(direction);

		if(connectedRooms.containsKey(roomDirection)){
			return connectedRooms.get(roomDirection);
		}
		return null;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

	public String getNameRoom() {
		return nameRoom;
	}
}
