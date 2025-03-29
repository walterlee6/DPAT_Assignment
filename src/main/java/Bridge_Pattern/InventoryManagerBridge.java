package Bridge_Pattern;

import Common_Class.Item;
// InventoryManagerBridge.java
public class InventoryManagerBridge extends InventoryBridge {

    public InventoryManagerBridge(InventoryImplementor implementor) {
        super(implementor);
    }

    @Override
    public void addItem(Item item) {
        implementor.addItem(item);
    }

    @Override
    public Item getItem(int id) {
        return implementor.getItem(id);
    }

    @Override
    public void updateItem(Item item) {
        implementor.updateItem(item);
    }

    public static void main(String[] args) {
        // Using DB storage implementation
        InventoryImplementor dbImpl = new DBInventoryImplementor();
        InventoryBridge dbInventory = new InventoryManagerBridge(dbImpl);

        // Using Cloud storage implementation
        InventoryImplementor cloudImpl = new CloudInventoryImplementor();
        InventoryBridge cloudInventory = new InventoryManagerBridge(cloudImpl);

        // Test both implementations
        Item newItem = new Item(1, "Gadget", 200);
        dbInventory.addItem(newItem);
        cloudInventory.addItem(newItem);


        // Retrieve and update the item (simulating a -10 quantity update)
        Item dbItem = dbInventory.getItem(1);
        if(dbItem != null) {
            dbItem.setQuantity(dbItem.getQuantity() - 10);
            dbInventory.updateItem(dbItem);
        }

        Item cloudItem = cloudInventory.getItem(1);
        if(cloudItem != null) {
            cloudItem.setQuantity(cloudItem.getQuantity() - 10);
            cloudInventory.updateItem(cloudItem);
        }

        System.out.println("DB Inventory Retrieved: " + dbInventory.getItem(1));
        System.out.println("Cloud Inventory Retrieved: " + cloudInventory.getItem(1));
    }
}
