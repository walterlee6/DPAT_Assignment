package Bridge_Pattern;

import java.util.HashMap;
import Common_Class.Item;
import java.util.Map;

public class DBInventoryImplementor implements InventoryImplementor {
    private Map<Integer, Item> dbStorage = new HashMap<>();

    @Override
    public void addItem(Item item) {
        dbStorage.put(item.getId(), item);
        System.out.println("Added " + item + " to DB storage.");
    }

    @Override
    public Item getItem(int id) {
        Item item = dbStorage.get(id);
        System.out.println("Retrieved " + item + " from DB storage.");
        return item;
    }

    @Override
    public void updateItem(Item item) {
        dbStorage.put(item.getId(), item); // Replaces the old item
        System.out.println("Updated " + item + " in DB storage.");
    }
}
