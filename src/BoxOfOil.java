public class BoxOfOil extends CountableItem {
    private final String itemName = "Box of Oil";
    private final int productCostPerLiter = 20;
    private final int productPricePerLiter = 45;

    private double productCost;
    private double productPrice;

    public BoxOfOil(String itemCode, double volume,String serialNumber) {
        super(itemCode, volume,serialNumber);
        this.productCost = calculateCost();
        this.productPrice = calculatePrice();

    }

    public double calculatePrice(){
        return getProductPricePerLiter() * getVolume();
    }

    public double calculateCost(){
        return getProductCostPerLiter() * getVolume();
    }

    private int getProductCostPerLiter() {
        return productCostPerLiter;
    }

    private int getProductPricePerLiter() {
        return productPricePerLiter;
    }

    @Override
    public double getProductPrice() {
        return productPrice;
    }

    public double getProductCost() {
        return productCost;
    }

    public String getItemName() {
        return itemName;
    }

    public String toString() {
        return (getItemName() + " " + getVolume() + " " + getProductCost() + " " + getProductPrice());
    }
}
