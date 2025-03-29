package Simpler_Solution;

import Common_Class.Item;

// InventoryManager.java
public class InventoryManager {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add 10 items to the inventory
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

        System.out.println("Initial Inventory:");
        inventory.listItems();

        // Retrieve an item by its ID using getItemById
        Item item = inventory.getItemById(1);
        if (item != null) {
            System.out.println("\nRetrieved item:");
            System.out.println(item);

            // Demonstrate usage of getName()
            System.out.println("\nThe name of the retrieved item is: " + item.getName());

            // Update the quantity using the setter method
            System.out.println("\nUpdating quantity for the retrieved item...");
            item.setQuantity(item.getQuantity() - 10); // For example, reducing quantity by 10
        } else {
            System.out.println("\nItem with ID 1 not found.");
        }

        // List items after update to reflect changes
        System.out.println("\nInventory after update:");
        inventory.listItems();
    }
}
