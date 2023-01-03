package lecivette.game.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    class Cluster{

        List<Room> rooms;
        Room centralRoom;

        public Cluster(int seed){
            centralRoom = new Room();
            rooms = new ArrayList<Room>();
            rooms.add(centralRoom);
            populateCluster(seed);
        }

        private void populateCluster(int seed){
            Random rand = new Random();
            rand.setSeed(seed);

            Room currentRoom = centralRoom;
            int roomsNumer = rand.nextInt(3, 11);
            while (rooms.size() <= roomsNumer){
                int adiacentRooms = rand.nextInt(1, 5);
                List<Direction> directionList = List.of(Direction.values());
                directionList.removeAll(currentRoom.getDirections());

                List<Direction> directionListCopy = new ArrayList<>();
                directionListCopy.addAll(directionList);

                for (int i = 0; i < adiacentRooms; i++){
                    int direction = rand.nextInt(0, directionListCopy.size());

                    Room newRoom = new Room();
                    switch (directionListCopy.get(direction).name()){
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

                    currentRoom.addRoom(directionListCopy.remove(direction), newRoom);

                    rooms.add(newRoom);
                }

                directionList = List.of(Direction.values());
                int direction = rand.nextInt(0, directionList.size());
                currentRoom = currentRoom.getRoom(directionList.get(direction).name());
            }
        }
    }
    List<Cluster> clusterList;

    public Map(int clustersNumber, int seed){
        clusterList = new ArrayList<>();
        for (int i = 0; i < clustersNumber; i++){
            clusterList.add(new Cluster(seed + i));
        }
    }
}

