public class BoxOfWater extends CountableItem {
    private final String itemName = "Box of Water";
    private final int productCostPerLiter = 1;
    private final int productPricePerLiter = 3;

    private double productCost;
    private double productPrice;

    public BoxOfWater(String itemCode, double volume, String serialNumber) {
        super(itemCode, volume, serialNumber);
        this.productCost = calculateCost();
        this.productPrice = calculatePrice();

    }

    public double calculatePrice(){
        return getProductPricePerLiter() * getVolume();
    }

    public double calculateCost(){
        return getProductCostPerLiter() * getVolume();
    }

    public int getProductCostPerLiter() {
        return productCostPerLiter;
    }

    public int getProductPricePerLiter() {
        return productPricePerLiter;
    }

    public double getProductCost() {
        return productCost;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String toString() {
        return (getItemName() + " " + getVolume() + " " + getProductCost() + " " + getProductPrice());
    }
}
