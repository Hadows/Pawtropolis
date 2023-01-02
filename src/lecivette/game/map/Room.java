package lecivette.game.map;

import lecivette.animals.domain.Animal;
import lecivette.game.domain.Item;

import java.util.List;

public class Room {

	private String nameRoom;
	private List<Item> itemList;
	private List<Animal> animalList;
	private Room roomNord, roomSud, roomEast, roomWest;

	public Room(String nameRoom){
		this.nameRoom = nameRoom;
	}

	public String getNameRoom() {
		return nameRoom;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public List<Animal> getAnimalList() {
		return animalList;
	}

	public Room getRoomNord() {
		return roomNord;
	}

	public Room getRoomSud() {
		return roomSud;
	}

	public Room getRoomEast() {
		return roomEast;
	}

	public Room getRoomWest() {
		return roomWest;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public void setAnimalList(List<Animal> animalList) {
		this.animalList = animalList;
	}

	public void setRoomNord(Room roomNord) {
		this.roomNord = roomNord;
	}

	public void setRoomSud(Room roomSud) {
		this.roomSud = roomSud;
	}

	public void setRoomEast(Room roomEast) {
		this.roomEast = roomEast;
	}

	public void setRoomWest(Room roomWest) {
		this.roomWest = roomWest;
	}
}
