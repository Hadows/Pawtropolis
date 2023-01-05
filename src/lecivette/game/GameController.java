package lecivette.game;

import lecivette.game.console.InputController;
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
			if (command.length != 2){
				System.out.println("Robin: what are you doing Sherlock Owl!");
				continue;
			}

			//TODO: richiamare metodi per vedere bag e per aggiungervi/rimuovervi oggetti
			switch(command[0]){
				case "go":
					System.out.println(go(command[1]));
					break;
				case "look":
					System.out.println(look());
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
		List<String> checkDirection = currentRoom.getDirections().stream().map(Direction::name)
				.filter(direction -> direction.equals(playerDirection)).collect(Collectors.toList());
		if (checkDirection.isEmpty()){
			return "Robin: You cannot go in that direction!";
		}
		else
		{
			currentRoom = currentRoom.getRoom(playerDirection);
			return "Robin: We are moving to " + currentRoom.getNameRoom() + " room";
		}
	}

	private String look(){
		List<Direction> directions = currentRoom.getDirections();

		return ("You look around, the direction that you can take are: " + directions);
	}
}
