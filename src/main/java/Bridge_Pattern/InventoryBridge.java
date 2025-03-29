package Bridge_Pattern;

import Common_Class.Item;

public abstract class InventoryBridge {
    protected InventoryImplementor implementor;

    public InventoryBridge(InventoryImplementor implementor) {
        this.implementor = implementor;
    }

    public abstract void addItem(Item item);
    public abstract Item getItem(int id);
    public abstract void updateItem(Item item);
}
