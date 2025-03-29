package Adapter_Pattern;

import Common_Class.Item;
import java.util.ArrayList;
import java.util.List;

public class LegacyInventory {
    private List<Item> items;

    public LegacyInventory() {
        items = new ArrayList<>();
    }

    // Different method names compared to our interface
    public void insert(Item item) {
        items.add(item);
    }

    public Item findItem(int id) {
        for (Item i : items) {
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public void display() {
        for (Item i : items) {
            System.out.println(i);
        }
    }
}
