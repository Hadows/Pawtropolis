package pawtropolis.animals;

import pawtropolis.animals.domain.*;

import java.util.ArrayList;
import java.util.List;

public class ZooController {

	// una lista per ogni specie che attualmente gestiamo nello zoo
	// vedremo più avanti come migliorare questo approccio
	private List<Tiger> tigers;
	private List<Lion> lions;
	private List<Eagle> eagles;

	public ZooController() {
		this.tigers = new ArrayList<>();
		this.lions = new ArrayList<>();
		this.eagles = new ArrayList<>();
	}

	public void addAnimal(Animal animal) {
		// identifichiamo in quale lista aggiungere l'animale in base alla sua specie (classe)
		// il casting esplicito è necessario in quanto il parametro "animal" è tipizzato Animal e le liste sono specifiche
		if (animal instanceof Tiger) {
			tigers.add((Tiger) animal);
		} else if (animal instanceof Lion) {
			lions.add((Lion) animal);
		} else if (animal instanceof Eagle) {
			eagles.add((Eagle) animal);
		} else {
			System.out.println("Unrecognized species");
		}
	}

	private List<AnimalWithTail> getAllAnimalsWithTail() {
		List<AnimalWithTail> allAnimalsWithTail = new ArrayList<>();
		allAnimalsWithTail.addAll(lions);
		allAnimalsWithTail.addAll(tigers);
		return allAnimalsWithTail;
	}

	public AnimalWithTail getAnimalWithLongestTail() {
		List<AnimalWithTail> allAnimalsWithTail = getAllAnimalsWithTail();

		if (allAnimalsWithTail.isEmpty()) {
			return null;
		}

		AnimalWithTail animalWithLongestTail = allAnimalsWithTail.get(0);

		for (AnimalWithTail currentAnimal : allAnimalsWithTail) {
			if (currentAnimal.getTailLength() > animalWithLongestTail.getTailLength()) {
				animalWithLongestTail = currentAnimal;
			}
		}
		return animalWithLongestTail;
	}

	// ci saranno sempre solo aquile tra gli animali con le ali? ;)
	public Eagle getEagleWithWidestWingspan() {
		if (eagles.isEmpty()) {
			return null;
		}

		Eagle eagleWithWidestWingspan = eagles.get(0);

		for (Eagle currentEagle : eagles) {
			if (currentEagle.getWingspan() > eagleWithWidestWingspan.getWingspan()) {
				eagleWithWidestWingspan = currentEagle;
			}
		}
		return eagleWithWidestWingspan;
	}

	/*
	 * I metodi seguenti sono tutti praticamente identici tra specie diverse
	 * e anche tra le coppie di più/meno alto/pesante di ogni specie cambia solo il segno di disuguaglianza
	 * nella if del ciclo (oltre ai nomi delle variabili).
	 * Vedremo più avanti come evitare tutto questo codice duplicato
	 */

	public Tiger getTallestTiger() {
		// se non ci sono tigri, restituiamo null
		if (tigers.isEmpty()) {
			return null;
		}
		Tiger tallestTiger = tigers.get(0);

		// iteriamo su tutte le tigri con un for-each
		for (Tiger currentTiger : tigers) {
			if (currentTiger.getHeight() > tallestTiger.getHeight()) {
				tallestTiger = currentTiger;
			}
		}
		return tallestTiger;
	}

	public Tiger getShortestTiger() {
		// se non ci sono tigri, restituiamo null
		if (tigers.isEmpty()) {
			return null;
		}
		Tiger shortestTiger = tigers.get(0);

		// iteriamo su tutte le tigri con un for-each
		for (Tiger currentTiger : tigers) {
			if (currentTiger.getHeight() < shortestTiger.getHeight()) {
				shortestTiger = currentTiger;
			}
		}
		return shortestTiger;
	}

	public Lion getTallestLion() {
		// se non ci sono leoni, restituiamo null
		if (lions.isEmpty()) {
			return null;
		}
		Lion tallestLion = lions.get(0);

		// iteriamo su tutti i leoni con un for-each
		for (Lion currentLion : lions) {
			if (currentLion.getHeight() > tallestLion.getHeight()) {
				tallestLion = currentLion;
			}
		}
		return tallestLion;
	}

	public Lion getShortestLion() {
		// se non ci sono leoni, restituiamo null
		if (lions.isEmpty()) {
			return null;
		}
		Lion shortestLion = lions.get(0);

		// iteriamo su tutti i leoni con un for-each
		for (Lion currentLion : lions) {
			if (currentLion.getHeight() < shortestLion.getHeight()) {
				shortestLion = currentLion;
			}
		}
		return shortestLion;
	}

	public Eagle getTallestEagle() {
		// se non ci sono aquile, restituiamo null
		if (eagles.isEmpty()) {
			return null;
		}
		Eagle tallestEagle = eagles.get(0);

		// iteriamo su tutte le aquile con un for-each
		for (Eagle currentEagle : eagles) {
			if (currentEagle.getHeight() > tallestEagle.getHeight()) {
				tallestEagle = currentEagle;
			}
		}
		return tallestEagle;
	}

	public Eagle getShortestEagle() {
		// se non ci sono aquile, restituiamo null
		if (eagles.isEmpty()) {
			return null;
		}
		Eagle shortestEagle = eagles.get(0);

		// iteriamo su tutte le aquile con un for-each
		for (Eagle currentEagle : eagles) {
			if (currentEagle.getHeight() < shortestEagle.getHeight()) {
				shortestEagle = currentEagle;
			}
		}
		return shortestEagle;
	}

	public Tiger getHeaviestTiger() {
		// se non ci sono tigri, restituiamo null
		if (tigers.isEmpty()) {
			return null;
		}
		Tiger heaviestTiger = tigers.get(0);

		// iteriamo su tutte le tigri con un for-each
		for (Tiger currentTiger : tigers) {
			if (currentTiger.getWeight() > heaviestTiger.getWeight()) {
				heaviestTiger = currentTiger;
			}
		}
		return heaviestTiger;
	}

	public Tiger getLightestTiger() {
		// se non ci sono tigri, restituiamo null
		if (tigers.isEmpty()) {
			return null;
		}
		Tiger lightestTiger = tigers.get(0);

		// iteriamo su tutte le tigri con un for-each
		for (Tiger currentTiger : tigers) {
			if (currentTiger.getWeight() < lightestTiger.getWeight()) {
				lightestTiger = currentTiger;
			}
		}
		return lightestTiger;
	}

	public Lion getHeaviestLion() {
		// se non ci sono leoni, restituiamo null
		if (lions.isEmpty()) {
			return null;
		}
		Lion heaviestLion = lions.get(0);

		// iteriamo su tutti i leoni con un for-each
		for (Lion currentLion : lions) {
			if (currentLion.getWeight() > heaviestLion.getWeight()) {
				heaviestLion = currentLion;
			}
		}
		return heaviestLion;
	}

	public Lion getLightestLion() {
		// se non ci sono leoni, restituiamo null
		if (lions.isEmpty()) {
			return null;
		}
		Lion lightestLion = lions.get(0);

		// iteriamo su tutti i leoni con un for-each
		for (Lion currentLion : lions) {
			if (currentLion.getWeight() < lightestLion.getWeight()) {
				lightestLion = currentLion;
			}
		}
		return lightestLion;
	}

	public Eagle getHeaviestEagle() {
		// se non ci sono aquile, restituiamo null
		if (eagles.isEmpty()) {
			return null;
		}
		Eagle heaviestEagle = eagles.get(0);

		// iteriamo su tutte le aquile con un for-each
		for (Eagle currentEagle : eagles) {
			if (currentEagle.getWeight() > heaviestEagle.getHeight()) {
				heaviestEagle = currentEagle;
			}
		}
		return heaviestEagle;
	}

	public Eagle getLightestEagle() {
		// se non ci sono aquile, restituiamo null
		if (eagles.isEmpty()) {
			return null;
		}
		Eagle lightestEagle = eagles.get(0);

		// iteriamo su tutte le aquile con un for-each
		for (Eagle currentEagle : eagles) {
			if (currentEagle.getWeight() < lightestEagle.getWeight()) {
				lightestEagle = currentEagle;
			}
		}
		return lightestEagle;
	}
}
