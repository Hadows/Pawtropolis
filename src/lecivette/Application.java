package lecivette;

import lecivette.game.GameController;
import lecivette.game.domain.Bag;
import lecivette.game.domain.Item;
import lecivette.game.domain.Player;
import lecivette.game.map.Map;

import java.util.ArrayList;


public class Application {

	public static void main(String[] args) {
		GameController gameController = new GameController( new Map(4, 2).getInialRoom(),
															new Player("Sherlock Owl", 100,
																	new Bag(new ArrayList<Item>(), 3)));
		gameController.runGame();
	}
}
