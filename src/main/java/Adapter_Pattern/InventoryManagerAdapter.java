package Adapter_Pattern;
import Common_Class.Item;

public class InventoryManagerAdapter {
    public static void main(String[] args) {
        // Use the adapter to interact with the legacy system
        LegacyInventory legacyInventory = new LegacyInventory();
        CommonInventory inventory = new InventoryAdapter(legacyInventory);

        // Add 10 items using the modern interface
        inventory.addItem(new Item(1, "Widget", 100));
        inventory.addItem(new Item(2, "Gadget", 50));
        inventory.addItem(new Item(3, "Doohickey", 75));
        inventory.addItem(new Item(4, "Thingamajig", 120));
        inventory.addItem(new Item(5, "Contraption", 30));
        inventory.addItem(new Item(6, "Apparatus", 90));
        inventory.addItem(new Item(7, "Instrument", 60));
        inventory.addItem(new Item(8, "Device", 80));
        inventory.addItem(new Item(9, "Tool", 110));
        inventory.addItem(new Item(10, "Implement", 45));

        System.out.println("Initial Inventory (Adapter):");
        inventory.listItems();

        // Retrieve and update an item
        Item item = inventory.getItemById(1);
        if (item != null) {
            System.out.println("\nRetrieved item (Adapter): " + item);
            System.out.println("The name of the retrieved item is: " + item.getName());
            item.setQuantity(item.getQuantity() - 10);
        } else {
            System.out.println("Item with ID 1 not found.");
        }

        System.out.println("\nInventory after update (Adapter):");
        inventory.listItems();
    }
}
