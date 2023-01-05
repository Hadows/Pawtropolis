package lecivette.game;

import lecivette.game.config.ContainerItems;
import lecivette.game.console.InputController;
import lecivette.game.domain.Item;
import lecivette.game.domain.Player;
import lecivette.game.map.Direction;
import lecivette.game.map.Room;

import java.util.List;
import java.util.stream.Collectors;


public class GameController {

	private Room currentRoom;
	private Player player;

	public GameController(Room currentRoom, Player player) {
		this.currentRoom = currentRoom;
		this.player = player;
	}

	public void runGame() {
		Room currentRoom = this.currentRoom;
		boolean gameEnded = false;

		System.out.println("Robin: Welcome to pawtropolis. You are in a room, take a look around");
		while(!gameEnded) {
			String input;
			String[] command;
			System.out.print(">");
			input = InputController.readString();
			command = input.split(" ");

			// TODO: gestire meglio i controlli sull'input errato
			if (input.equals("exit")) {
				gameEnded = true;
				System.out.println("Robin: bye Sherlock :)");
				continue;
			}


			switch(input){
				case "look":
					System.out.println(look());
					break;
				case "bag":
					System.out.println(bag());
					break;
				default:
					break;
			}
			if (command.length != 2){
				System.out.println("Robin: what are you doing Sherlock Owl!");
				continue;
			}
			switch(command[0]){
				case "go":
					System.out.println(go(command[1]));
					break;
				case "get":
					System.out.println(get(command[1]));
					break;
				case "drop":
					System.out.println(drop(command[1]));
					break;
				default:
					System.out.println("Robin: what are you doing Sherlock Owl!");
			}
		}
	}

	// TODO: incapsulare i controlli in classe room
	private String go(String playerDirection){
		List<String> checkDirection = currentRoom.getDirections().stream().map(Direction::name)
				.filter(direction -> direction.equals(playerDirection)).collect(Collectors.toList());
		if (checkDirection.isEmpty()){
			return "\nRobin: You cannot go in that direction!";
		}
		else
		{
			currentRoom = currentRoom.getRoom(playerDirection);
			return "\nRobin: We are moving to " + currentRoom.getNameRoom() + " room"+
					"\nItems: " + currentRoom.getItemList().toString() +
					"\nNPC: " + currentRoom.getAnimalList().toString();
		}
	}

	private String look(){
		List<Direction> directions = currentRoom.getDirections();

		return ("\nYou look around, the direction that you can take are: " + directions +
				"\nItems: " + currentRoom.getItemList().toString() +
				"\nNPC: " + currentRoom.getAnimalList().toString());
	}

	private String bag() {
		return player.getBag().getItems().toString();
	}

	private String get(String item){
		Item save = null;
		for(Item i: currentRoom.getItemList()){
			if(i.getName().equalsIgnoreCase(item)){
				currentRoom.getItemList().remove(i);
				return (player.getBag().addItem(i)) ? "\nAdded " + item: "\nNot Added " + item;
			}

		}
		return "\nItem not exist";
	}

	private String drop(String item){
		Item save = null;
		for(Item i: player.getBag().getItems()){
			if(i.getName().equalsIgnoreCase(item))
				currentRoom.getItemList().add(i);
				return (player.getBag().removeItems(i)) ? "\nRemoved " + item: "\nNot Removed " + item;
		}
		return "\nBag Empty";
	}

}
