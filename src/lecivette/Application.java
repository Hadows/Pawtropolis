package lecivette;

import lecivette.game.GameController;
import lecivette.game.domain.Bag;
import lecivette.game.domain.Item;
import lecivette.game.domain.Player;
import lecivette.game.map.Map;

import java.util.ArrayList;


public class Application {

	public static void main(String[] args) {
		Bag bag = new Bag(new ArrayList<Item>(), 2);
		Player player = new Player("Sherlock Owl", 100, bag);
		Map map = new Map(4, 1);
		GameController gameController = new GameController(map.getInialRoom(), player);
		gameController.runGame();
	}
}
