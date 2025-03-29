package Bridge_Pattern;

import Common_Class.Item;

// InventoryImplementor.java
public interface InventoryImplementor {
    void addItem(Item item);
    Item getItem(int id);
    void updateItem(Item item);
}
