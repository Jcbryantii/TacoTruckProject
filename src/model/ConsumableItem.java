package model;

public abstract class ConsumableItem {

    private double unitPrice;

    private String itemName;

    public ConsumableItem(double price, String itemName){
        this.unitPrice = price;
        this.itemName = itemName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;

    }

    public void setUnitPrice(double price) {
        this.unitPrice = price;

    }
}
