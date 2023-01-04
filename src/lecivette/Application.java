package lecivette;

import lecivette.animals.ZooController;
import lecivette.animals.domain.*;
import lecivette.game.GameController;
import lecivette.game.domain.Bag;
import lecivette.game.domain.Item;
import lecivette.game.domain.Player;
import lecivette.game.map.Map;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		Item i = new Item("Forbici", "Taglia tutto", 1);
		List<Item> items = new ArrayList<>();
		items.add(i);
		Bag bag = new Bag(items, 2);
		Player player = new Player("Sherlock Owl", 100, bag);
		Map map = new Map(4, 1);
		GameController gameController = new GameController(map.getInialRoom(), player);
		gameController.runGame();
	}
}
