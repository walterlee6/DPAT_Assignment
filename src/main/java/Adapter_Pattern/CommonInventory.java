package Adapter_Pattern;
import Common_Class.Item;

public interface CommonInventory {
    void addItem(Item item);
    Item getItemById(int id);
    void listItems();
}
