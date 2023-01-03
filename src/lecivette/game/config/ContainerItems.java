package lecivette.game.config;

import lecivette.game.domain.Item;

import java.util.ArrayList;
import java.util.List;

public class ContainerItems {
    public static List<Item> getItem() {
        List<Item> items = new ArrayList<>();
        items.add (new Item("scissors", "rusty and dirty", 1));
        items.add (new Item("knife", "sharp and unattractive", 1));
        items.add (new Item("rope", "bind and choke",1));
        return items;
    }
}
