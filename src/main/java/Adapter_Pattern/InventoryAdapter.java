package Adapter_Pattern;
import Common_Class.Item;

// InventoryAdapter.java
public class InventoryAdapter implements CommonInventory {
    private LegacyInventory legacyInventory;

    public InventoryAdapter(LegacyInventory legacyInventory) {
        this.legacyInventory = legacyInventory;
    }

    @Override
    public void addItem(Item item) {
        legacyInventory.insert(item);
    }

    @Override
    public Item getItemById(int id) {
        return legacyInventory.findItem(id);
    }

    @Override
    public void listItems() {
        legacyInventory.display();
    }
}
