package lecivette.game.map;

import lecivette.animals.domain.Animal;
import lecivette.game.config.ContainerAnimals;
import lecivette.game.config.ContainerItems;
import lecivette.game.domain.Item;

import java.util.*;

//TODO: provare semplificare codice, generalizzandolo per ogni cluster (parti di codice ripetute)
public class Map {
    class Cluster {

        List<Room> rooms;
        Room centralRoom;
        Random rand;

        public Cluster(int seed) {
            centralRoom = new Room();
            centralRoom.setNameRoom("Sherlock's Room");
            rooms = new ArrayList<Room>();
            rooms.add(centralRoom);
            populateCluster(seed);
        }

        private void populateCluster(int seed) {
            //TODO: verificare e completare nomi delle room man mano che si generano/collegano le stesse
            //TODO: fixare nome della stanza centrale per ogni cluster che si crea
            rand = new Random();
            rand.setSeed(seed);

            Room currentRoom = centralRoom;
            int roomsNumer = rand.nextInt(3, 11);
            while (rooms.size() <= roomsNumer) {
                ArrayList<Direction> directionList = new ArrayList<>(List.of((Direction.values())));
                directionList.removeAll(currentRoom.getDirections());
                int adiacentRooms = rand.nextInt(1, (directionList.size() + 1));

                List<Direction> directionListCopy = new ArrayList<>();
                directionListCopy.addAll(directionList);

                for (int i = 1; i <= adiacentRooms; i++) {
                    int direction = rand.nextInt(0, directionListCopy.size());

                    Room newRoom = new Room();
                    switch (directionListCopy.get(direction).name()) {
                        case "north":
                            newRoom.addRoom(Direction.south, currentRoom);
                            break;
                        case "south":
                            newRoom.addRoom(Direction.north, currentRoom);
                            break;
                        case "west":
                            newRoom.addRoom(Direction.east, currentRoom);
                            break;
                        case "east":
                            newRoom.addRoom(Direction.west, currentRoom);
                            break;
                    }

                    //add items in rooms
                    int numberOfItemsOnRoom = rand.nextInt(1, 3);
                    List<Item> item = new ArrayList<>();
                    for (int j = 0; j < numberOfItemsOnRoom; j++) {
                        item.add(ContainerItems.getItem().get(j));
                    }
                    currentRoom.setItemList(item);

                    //add animals in room
                    int numberOfAnimalsOnRoom = rand.nextInt(1, 3);
                    List<Animal> animal = new ArrayList<>();
                    for (int k = 0; k < numberOfAnimalsOnRoom; k++) {
                        animal.add(ContainerAnimals.getAnimals().get(k));
                    }

                    currentRoom.setAnimalList(animal);
                    currentRoom.addRoom(directionListCopy.get(direction), newRoom);
                    directionListCopy.remove(direction);

                    rooms.add(newRoom);
                }


                int direction = rand.nextInt(0, currentRoom.getDirections().size());
                currentRoom = currentRoom.getRoom(currentRoom.getDirections().get(direction).name());

            }
        }
    }

    List<Cluster> clusterList;
    List<Room> corridors;

    public Map(int clustersNumber, int seed){
        clusterList = new ArrayList<>();
        corridors = new ArrayList<>();

        for (int i = 0; i < clustersNumber; i++){
            clusterList.add(new Cluster(seed + i));
        }

        Random rand = new Random();
        rand.setSeed(seed);

        for (int i = 0; i < clustersNumber - 1; i++){
            List<Room> firstCluster = clusterList.get(i).rooms;
            List<Room> secondCluster = clusterList.get(i+1).rooms;

            //first cluster
            int roomNumberCluster1 = rand.nextInt(0, firstCluster.size());
            ArrayList<Direction> directionList1 = new ArrayList<>(List.of(Direction.values()));
            directionList1.removeAll(firstCluster.get(roomNumberCluster1).getDirections());

            while(directionList1.isEmpty()){
                roomNumberCluster1 = rand.nextInt(0, firstCluster.size());

                directionList1 = new ArrayList<>(List.of(Direction.values()));
                directionList1.removeAll(firstCluster.get(roomNumberCluster1).getDirections());
            }

            Direction direction1 = directionList1.get(rand.nextInt(0, directionList1.size()));
            Room room1 = firstCluster.get(roomNumberCluster1);

            //second cluster
            int roomNumberCluster2 = rand.nextInt(0, secondCluster.size());
            List<Direction> directionList2 = new ArrayList<>(List.of(Direction.values()));
            directionList2.removeAll(secondCluster.get(roomNumberCluster2).getDirections());
            directionList2.remove(direction1);

            while(directionList2.isEmpty()){
                roomNumberCluster2 = rand.nextInt(0, secondCluster.size());

                directionList2 = new ArrayList<>(List.of(Direction.values()));
                directionList2.removeAll(secondCluster.get(roomNumberCluster2).getDirections());
            }

            Direction direction2 = directionList2.get(rand.nextInt(0, directionList2.size()));
            Room room2 = secondCluster.get(roomNumberCluster2);

            //connect the two rooms
            Room newCorridor = new Room();
            newCorridor.setCorridor(true);
            newCorridor.setNameRoom("Corridor");

            room1.addRoom(direction1, newCorridor);
            switch (direction1.name()){
                case "north":
                    newCorridor.addRoom(Direction.south, room1);
                    break;
                case "south":
                    newCorridor.addRoom(Direction.north, room1);
                    break;
                case "west":
                    newCorridor.addRoom(Direction.east, room1);
                    break;
                case "east":
                    newCorridor.addRoom(Direction.west, room1);
                    break;
            }
            room2.addRoom(direction2, newCorridor);
            switch (direction2.name()){
                case "north":
                    newCorridor.addRoom(Direction.south, room2);
                    break;
                case "south":
                    newCorridor.addRoom(Direction.north, room2);
                    break;
                case "west":
                    newCorridor.addRoom(Direction.east, room2);
                    break;
                case "east":
                    newCorridor.addRoom(Direction.west, room2);
                    break;
            }

            corridors.add(newCorridor);
        }
    }

    public Room getInialRoom(){
        return clusterList.get(0).centralRoom;
    }

    public List<Room> getAllRooms() {
        List<Room> listRoom = new ArrayList<>();
        clusterList.forEach(cluster -> listRoom.addAll(cluster.rooms));
        return listRoom;
    }
    public void setRoomName(){
        List <String> multipleRoomNames = new ArrayList<>(Arrays.asList("Gallery","Dining room", "Lounge","Stateroom","Crew quarters"));
        Collections.shuffle(multipleRoomNames);
        List <String> singleRoomNames = new ArrayList<>(Arrays.asList("Bridge","Engine room","Sick bay", "Laundry room","Cargo hold"));
        Collections.shuffle(singleRoomNames);
        List<Room> allRoomsList = getAllRooms();
        Collections.shuffle(allRoomsList);
        for (int i=0; i<singleRoomNames.size();i++){
            allRoomsList.get(0).setNameRoom(singleRoomNames.get(i));
            allRoomsList.remove(0);
        }
    }
}

