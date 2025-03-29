package Simpler_Solution;


import java.util.ArrayList;
import java.util.List;
import Common_Class.Item;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item getItemById(int id) {
        for (Item i : items) {
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public void listItems() {
        for (Item i : items) {
            System.out.println(i);
        }
    }
}
