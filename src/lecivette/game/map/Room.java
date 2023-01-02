package lecivette.game.map;

import lecivette.animals.domain.Animal;
import lecivette.game.domain.Item;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Log4j
public class Room {
	private final String nameRoom;
	private List<Item> itemList;
	private List<Animal> animalList;
	private Map<Direction, Room> connectedRooms;

	public Room(String nameRoom){
		this.nameRoom = nameRoom;
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
	public Room getRoom(Direction direction){
		if(connectedRooms.containsKey(direction)){
			return connectedRooms.get(direction);
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
