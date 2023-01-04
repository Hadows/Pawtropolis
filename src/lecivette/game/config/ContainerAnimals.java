package lecivette.game.config;

import lecivette.animals.ZooController;
import lecivette.animals.domain.Animal;
import lecivette.animals.domain.Eagle;
import lecivette.animals.domain.Lion;
import lecivette.animals.domain.Tiger;

import java.time.LocalDate;
import java.util.List;

public class ContainerAnimals {
    public static List<Animal> getAnimals() {
        ZooController zooController = new ZooController();

        zooController.addAnimal(new Lion("Simba", "mango", 3, LocalDate.now(), 10.9, 1.1, 0.5));
        zooController.addAnimal(new Lion("Kimba", "caffè Kimbo", 5, LocalDate.now(), 13, 0.7, 0.9));
        zooController.addAnimal(new Lion("Cane Fifone", "Torta di Marilù", 10, LocalDate.now(), 8, 1.1, 6.21));

        zooController.addAnimal(new Tiger("Man", "pizza", 30, LocalDate.now(), 80, 1.8, 0.3));
        zooController.addAnimal(new Tiger("Tigro", "miele", 8, LocalDate.now(), 20, 1, 0.7));
        zooController.addAnimal(new Tiger("Asdrubale", "carbonara", 27, LocalDate.now(), 70, 1.7, 1));

        zooController.addAnimal(new Eagle("Piccione", "pane", 1, LocalDate.now(), 1, 0.2, 0.3));
        zooController.addAnimal(new Eagle("Zazu", "marmellata", 9, LocalDate.now(), 2, 0.3, 0.5));
        zooController.addAnimal(new Eagle("Daily Eagle", "hot dog", 50, LocalDate.now(), 30, 1, 2));

        return zooController.getAnimals();
    }

}
