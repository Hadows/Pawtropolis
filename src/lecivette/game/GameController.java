package lecivette.game;

import lecivette.game.console.InputController;
import lecivette.game.domain.Player;
import lecivette.game.map.Direction;
import lecivette.game.map.Room;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class GameController {

	private Room entry;
	private Player player;

	public GameController(Room entry, Player player) {
		this.entry = entry;
		this.player = player;
	}

	public void runGame() {
		Room currentRoom = entry;
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
			if (command.length != 2){
				System.out.println("Robin: what are you doing Sherlock Owl!");
				continue;
			}

			switch(command[0]){
				case "go":
					System.out.println(go(command[1]));
					break;
				case "look":
					break;
				case "bag":
					break;
				case "get":
					break;
				case "drop":
					break;
				default:
					System.out.println("Robin: what are you doing Sherlock Owl!");
			}


		}
	}

	// TODO: incapsulare i controlli in classe room
	private String go(String playerDirection){
		List<String> checkDirection = entry.getDirections().stream().map(Direction::name)
				.filter(direction -> direction.equals(playerDirection)).collect(Collectors.toList());
		if (checkDirection.isEmpty()){
			return "Robin: You cannot go in that direction!";
		}
		else
		{
			entry = entry.getRoom(playerDirection);
			return "Robin: We are moving to " + entry.getNameRoom() + " room";
		}
	}
}
