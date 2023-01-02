package pawtropolis;

import lecivette.animals.ZooController;
import lecivette.animals.domain.AnimalWithTail;
import lecivette.animals.domain.Eagle;
import lecivette.animals.domain.Lion;
import lecivette.animals.domain.Tiger;
import pawtropolis.game.GameController;
import pawtropolis.game.domain.Player;
import lecivette.game.map.Room;

import java.time.LocalDate;

public class Application {

	public static void main(String[] args) {
		Player player = new Player();
		Room entry = new Room();
		GameController gameController = new GameController(entry, player);
		gameController.runGame();

		// de-commentare per testare tutte le funzionalità della classe ZooController
		// testZoo();
	}

	private static void testZoo() {
		ZooController zooController = new ZooController();

		Lion lion1 = new Lion("Simba", "mango", 3, LocalDate.now(), 10.9, 1.1, 0.5);
		Lion lion2 = new Lion("Kimba", "caffè Kimbo", 5, LocalDate.now(), 13, 0.7, 0.9);
		Lion lion3 = new Lion("Cane Fifone", "Torta di Marilù", 10, LocalDate.now(), 8, 1.1, 6.21);

		zooController.addAnimal(lion1);
		zooController.addAnimal(lion2);
		zooController.addAnimal(lion3);

		Tiger tiger1 = new Tiger("Man", "pizza", 30, LocalDate.now(), 80, 1.8, 0.3);
		Tiger tiger2 = new Tiger("Tigro", "miele", 8, LocalDate.now(), 20, 1, 0.7);
		Tiger tiger3 = new Tiger("Asdrubale", "carbonara", 27, LocalDate.now(), 70, 1.7, 1);

		zooController.addAnimal(tiger1);
		zooController.addAnimal(tiger2);
		zooController.addAnimal(tiger3);

		Eagle eagle1 = new Eagle("Piccione", "pane", 1, LocalDate.now(), 1, 0.2, 0.3);
		Eagle eagle2 = new Eagle("Zazu", "marmellata", 9, LocalDate.now(), 2, 0.3, 0.5);
		Eagle eagle3 = new Eagle("Daily Eagle", "hot dog", 50, LocalDate.now(), 30, 1, 2);

		zooController.addAnimal(eagle1);
		zooController.addAnimal(eagle2);
		zooController.addAnimal(eagle3);

		AnimalWithTail animalWithLongestTail = zooController.getAnimalWithLongestTail();
		System.out.println("Animal with longest tail: " + animalWithLongestTail.getName());

		Eagle eagleWithWidestWingspan = zooController.getEagleWithWidestWingspan();
		System.out.println("Eagle with widest wingspan: " + eagleWithWidestWingspan.getName());

		Tiger tallestTiger = zooController.getTallestTiger();
		System.out.println("Tallest tiger: " + tallestTiger.getName());

		Tiger shortestTiger = zooController.getShortestTiger();
		System.out.println("Shortest tiger: " + shortestTiger.getName());

		Lion tallestLion = zooController.getTallestLion();
		System.out.println("Tallest lion: " + tallestLion.getName());

		Lion shortestLion = zooController.getShortestLion();
		System.out.println("Shortest lion: " + shortestLion.getName());

		Eagle tallestEagle = zooController.getTallestEagle();
		System.out.println("Tallest eagle: " + tallestEagle.getName());

		Eagle shortestEagle = zooController.getShortestEagle();
		System.out.println("Shortest eagle: " + shortestEagle.getName());

		Tiger heaviestTiger = zooController.getHeaviestTiger();
		System.out.println("Heaviest tiger: " + heaviestTiger.getName());

		Tiger lightestTiger = zooController.getLightestTiger();
		System.out.println("Lightest tiger: " + lightestTiger.getName());

		Lion heaviestLion = zooController.getHeaviestLion();
		System.out.println("Heaviest lion: " + heaviestLion.getName());

		Lion lightestLion = zooController.getLightestLion();
		System.out.println("Lightest lion: " + lightestLion.getName());

		Eagle heaviestEagle = zooController.getHeaviestEagle();
		System.out.println("Heaviest eagle: " + heaviestEagle.getName());

		Eagle lightestEagle = zooController.getLightestEagle();
		System.out.println("Lightest eagle: " + lightestEagle.getName());
	}
}
