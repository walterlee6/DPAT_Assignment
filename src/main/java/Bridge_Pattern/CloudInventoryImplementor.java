package Bridge_Pattern;

// CloudInventoryImplementor.java
import Common_Class.Item;
import java.util.HashMap;
import java.util.Map;

public class CloudInventoryImplementor implements InventoryImplementor {
    private Map<Integer, Item> cloudStorage = new HashMap<>();

    @Override
    public void addItem(Item item) {
        cloudStorage.put(item.getId(), item);
        System.out.println("Added " + item + " to Cloud storage.");
    }

    @Override
    public Item getItem(int id) {
        Item item = cloudStorage.get(id);
        System.out.println("Retrieved " + item + " from Cloud storage.");
        return item;
    }

    @Override
    public void updateItem(Item item) {
        cloudStorage.put(item.getId(), item); // Replaces the old item
        System.out.println("Updated " + item + " in Cloud storage.");
    }
}
