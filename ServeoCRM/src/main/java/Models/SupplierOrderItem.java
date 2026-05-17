package Models;

public class SupplierOrderItem {

    private int idSupplierOrderItem, idSupplierOrder, idInventory;
    private double quantity, unitCost;
    private String createDate, modDate;

    public int getIdSupplierOrderItem() {
        return idSupplierOrderItem;
    }

    public void setIdSupplierOrderItem(int idSupplierOrderItem) {
        this.idSupplierOrderItem = idSupplierOrderItem;
    }

    public int getIdSupplierOrder() {
        return idSupplierOrder;
    }

    public void setIdSupplierOrder(int idSupplierOrder) {
        this.idSupplierOrder = idSupplierOrder;
    }

    public int getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(int idInventory) {
        this.idInventory = idInventory;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    
    
}
